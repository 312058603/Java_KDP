package JavaGeneric;

//类型通配符的使用
public class GenericTest {
    public static void main(String[] args) {
        GenericClass.Box<Number> name = new GenericClass.Box<Number>(99);
        GenericClass.Box<Integer> age = new GenericClass.Box<Integer>(712);
        setData(name);
        getData(name);
        getData(age);
    }

    public static void setData(GenericClass.Box<? super Number> data){
        int testData=22;
        data.setData(testData);
    }
    
    public static void getData(GenericClass.Box<? extends Number> data){
        System.out.println("data :" + data.getData());
    }

}