/**
 * Created by wpx on 2017/12/12.
 */
//函数接口注解 只能有一个抽象方法的接口(SAM接口)
@FunctionalInterface
public interface Default {
    //接口中创建静态方法
    public static void testStaticMethod(){
        System.out.println("testStaticMethod");
    }
    //接口中添加默认方法
    default void testDafaultMethod(){
        System.out.println("testDafaultMethod");
    }
    //接口中的抽象方法
    public void absMethod();
}
