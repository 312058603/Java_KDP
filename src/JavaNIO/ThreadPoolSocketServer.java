package JavaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wpx on 2017/12/14.
 */
public class ThreadPoolSocketServer {

    /**
     * 服务器默认绑定端口
     */
    public static final int DEFAULT_PORT = 9999;

    /**
     * 选择器
     */
    private Selector selector;
    /**
     * 读取线程池
     */
    private ExecutorService pool;

    public ThreadPoolSocketServer(String ip, int port) {
        ServerSocketChannel ssc = null;
        try {
            int _port = DEFAULT_PORT;
            if (port > 0)
                _port = port;
            /* 获取通道 */
            ssc = ServerSocketChannel.open();
            /* 配置非阻塞 */
            ssc.configureBlocking(false);
            /**
             * 配置绑定端口 ServerSocketChannel没有bind()方法，
             * 因此有必要取出对等的ServerSocket并使用它来绑定到一
             * 个端口以开始监听连接
             */
            ssc.socket().bind(new InetSocketAddress(ip, _port));
            /* 获取选择器 */
            this.selector = Selector.open();
            /* 将通道注册到选择器 */
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);

            /**
             * 可以使用Executors,快速创建线程池,但是如果综合考虑
             * CPU、内存等资及并发情况，可以采用自定方式创建池（
             *  拒绝处理等问题
             * ）,此处简单自定义创建读取池
             * */
            pool = new ThreadPoolExecutor(1, 2, 2000L,
                    TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(5));
        } catch (IOException e2) {
            System.out.println("服务器启动失败！");
            e2.printStackTrace();
            try {
                if (ssc != null) ssc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 轮询选择器
     *
     * @throws Exception
     */
    public void pollSelect() throws Exception {
        /* (阻塞)轮询选择器,直到有事件 */
        while (true) {
            int readyChannels = 0;
            /*选择器是否关闭*/
            if (this.selector.isOpen()) {
                readyChannels = this.selector.select();
            }
            if (readyChannels == 0) continue;
            /* 获取事件通知列表 */
            Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey selectKey = it.next();
                it.remove();
                try {
                    process(selectKey);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 事件处理
     *
     * @param selectKey
     */
    public void process(SelectionKey selectKey) throws Exception {
        /* 客户端连接事件 */
        if (selectKey.isAcceptable()) {
            accept(selectKey);
        } else if (selectKey.isReadable()) { /* 可读事件 */
            read(selectKey);
            /**
             * 解决重复读
             * 或设置不关注读事件来解决重复
             * selectKey.interestOps(selectKey.interestOps() & (~SelectionKey.OP_READ));
             * */
            selectKey.cancel();
        }
    }

    /**
     * 连接事件
     *
     * @param selectKey
     */
    public void accept(SelectionKey selectKey) throws Exception {
        SocketChannel sc = null;
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) selectKey.channel();
            sc = ssc.accept();
            sc.configureBlocking(false);
            System.out.println("客户端:" + sc.socket().getInetAddress().getHostAddress() + "端口" + sc.socket().getPort() + " 已连接");
            sc.register(this.selector, SelectionKey.OP_READ);
        } catch (Exception e) {
            if (sc != null)
                sc.close();
            throw new IOException("客户端已断开连接!");
        }
    }

    /**
     * 可读事件
     *
     * @param selectKey
     */
    public void read(SelectionKey selectKey) throws Exception {
        SocketChannel sc = (SocketChannel) selectKey.channel();
        /*提交线程池处理*/
        pool.submit(new SocketServerReadThread(sc));
    }


    public static void main(String[] args) {
        SocketServer ss = null;
        try {
            ss = new SocketServer("192.168.1.102", 9999);
            ss.pollSelect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
