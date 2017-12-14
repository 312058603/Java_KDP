package JavaInnerClass;


/**
 * Created by GM-KF007 on 2017/12/14.
 */
public class 成员内部类 {

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

    //成员内部类 可以无条件访问外部类的成员 因为编译器会默认为成员内部类添加了一个指向外部类对象的引用
    private class InnerClass{

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

        public String getOuterName(){
            return 成员内部类.this.name;
        }

        public int getOuterAge(){
            return 成员内部类.this.age;
        }

    }

    public static void main(String[] args){
        成员内部类 OuterClass=new 成员内部类();
        OuterClass.setName("OuterName");
        OuterClass.setAge(1);
        InnerClass innerClass=OuterClass.new InnerClass();
        innerClass.setName("InnerName");
        innerClass.setAge(2);
        System.out.println(innerClass.getName());
        System.out.println(innerClass.getAge());
        System.out.println(innerClass.getOuterName());
        System.out.println(innerClass.getOuterAge());
    }

}
