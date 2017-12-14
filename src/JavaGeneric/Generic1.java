package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

//一.为什么需要泛型?
//那么有没有什么办法可以使集合能够记住集合内元素各类型,且能够达到只要编译时不出现问题,运行时就不会出现"java.lang.ClassCastException"异常呢?答案就是使用泛型.
public class Generic1 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        list.add(100);

        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i); // 1
            System.out.println("name:" + name);
        }
    }

}