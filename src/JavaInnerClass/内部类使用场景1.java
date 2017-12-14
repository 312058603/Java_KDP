package JavaInnerClass;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public class 内部类使用场景1 {

    //方便将存在一定逻辑关系的类组织在一起,又可以对外界隐藏

    private static class InnerHolderClass{
        public String name;
        public int age;

        @Override
        public String toString() {
            return "InnerHolderClass{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args){
        InnerHolderClass innerHolderClass=new InnerHolderClass();
        innerHolderClass.name="wpx";
        innerHolderClass.age=1;
        System.out.println(innerHolderClass.toString());
    }

}
