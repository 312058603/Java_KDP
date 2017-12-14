package JavaInnerClass;


import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public class 局部内部类 {

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

    //局部内部类 访问外部变量必须为final类型 Jdk1.8之后没限制
    public int getInnerClassAge(String content) {
        class InnerClass {
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

            public void showContent(){
                System.out.println(content);
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.setName("InnerClass");
        innerClass.setAge(1);
        innerClass.showContent();
        return innerClass.getAge();
    }

    public static void main(String[] args){
        局部内部类 OuterClass=new 局部内部类();
        System.out.println(OuterClass.getInnerClassAge("你好"));
    }


}
