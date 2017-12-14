package JavaInnerClass;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public class 静态内部类 {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //静态内部类 无法访问外部非static的变量与方法
    private static class InnerClass {

        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args){
        静态内部类 OuterClass=new 静态内部类();
        OuterClass.setName("OuterName");
        OuterClass.setAge(1);
        InnerClass innerClass=new InnerClass();
        innerClass.setName("InnerName");
        innerClass.setAge(2);
        System.out.println(OuterClass.getName());
        System.out.println(OuterClass.getAge());
        System.out.println(innerClass.getName());
        System.out.println(innerClass.getAge());
    }

}
