package JavaInnerClass;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public class 内部类使用场景2 extends AbsEvent {

    //方便编写事件驱动程序
    //方便编写线程代码
    //最重要的一点:内部类使得多继承的解决方案变得完整

    @Override
    void action() {

    }


    private class MyEvent1 extends AbsEvent{

        @Override
        void action() {

        }
    }

    private class MyEvent2 extends AbsEvent{

        @Override
        void action() {

        }
    }

}
