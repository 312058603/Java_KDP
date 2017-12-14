package JavaGeneric;

//优先考虑泛型方法
public class GenericMethod {

    public static <T> void out(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        out("findingsea");
        out(123);
        out(11.11);
        out(true);
    }

}