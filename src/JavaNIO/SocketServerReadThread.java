package JavaNIO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 从线程中读信息 
 * @author wpx
 * 
 */  
public class SocketServerReadThread implements Runnable{  
      
    private SocketChannel channel;
      
    public SocketServerReadThread(SocketChannel channel){  
        this.channel = channel;  
    }  
      
    @Override  
    public void run() {  
        try {  
            // 创建读取的缓冲区  
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);  
            byte[] data = buffer.array();  
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            User user = (User)ois.readObject();  
            System.out.println("客户端:" + channel.socket().getInetAddress().getHostAddress()+"端口"+channel.socket().getPort() + " 消息： " + user.toString());
        } catch (Exception e) {  
            System.out.println("客户端已断开连接!");  
            try {  
                if(channel != null)   
                    channel.close();  
            } catch (IOException e1) {
                e1.printStackTrace();  
            }  
        }  
    }

} 