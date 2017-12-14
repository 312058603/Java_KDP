package JavaInnerClass;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public class 匿名内部类 {

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

    public interface NoNameInnerClass{
        void show();
    }

    public void showNoNameInnerClass(NoNameInnerClass noNameInnerClass){
        if(noNameInnerClass!=null){
            noNameInnerClass.show();
        }
    }

    public static void main(String[] args){
        匿名内部类 OuterClass=new 匿名内部类();
        OuterClass.showNoNameInnerClass(new NoNameInnerClass() {
            @Override
            public void show() {
                System.out.print("你们好");
            }
        });
    }

}
