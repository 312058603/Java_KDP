package JavaGeneric;


//泛型类型在逻辑上看以看成是多个不同的类型,实际上都是相同的基本类型
public class Generic3 {

    public static void main(String[] args) {

        GenericClass.Box<String> name = new GenericClass.Box<String>("corn");
        GenericClass.Box<Integer> age = new GenericClass.Box<Integer>(712);

        System.out.println("name class:" + name.getClass());      // com.qqyumidi.Box
        System.out.println("age class:" + age.getClass());        // com.qqyumidi.Box
        System.out.println(name.getClass() == age.getClass());    // true

    }

}