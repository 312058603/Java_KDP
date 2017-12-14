package JavaEnum.使用EnumMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public class   EnumMapTest {

    //EnumMap内部用数组实现,因此查找速度非常快

    enum Operate{
        ADD, UPDATE, DELETE;
    }

    public static void main(String[] args){
        Map<Operate, String> map = new EnumMap<Operate, String>(Operate.class);

        //put方法
        map.put(Operate.ADD, "add operate");
        map.put(Operate.UPDATE, "update operate");
        map.put(Operate.DELETE, "delete operate");

        //重写了toString方法
        System.out.println(map);

        //size方法
        System.out.println(map.size());

        System.out.println(map.containsKey(Operate.UPDATE));
        System.out.println(map.containsValue("update operate"));
        System.out.println(map.get(Operate.DELETE));

        //remove
        map.remove(Operate.UPDATE);
        System.out.println(map);

        //key集合
        for(Operate operate:map.keySet()){
            System.out.print(operate + " ");
        }

        System.out.println();
        //value集合
        for(String obj:map.values()){
            System.out.print(obj + ",");
        }

        System.out.println();
        //key-value集合
        for(Map.Entry<Operate, String> entry:map.entrySet()){
            System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
        }

    }

}
