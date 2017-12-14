package JavaGeneric;

public class GenericClass {

    static class Box<T> {

        private T data;

        public Box() {

        }

        public Box(T data) {
            this.data = data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

    }

    public static void main(String[] args) {
        Box<String> name = new Box<String>("corn");
        System.out.println("name:" + name.getData());
    }

}
