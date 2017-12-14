package JavaEnum.基本enum特性;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public enum Enum_BaseFeature {
    ONE,TWO,THREE;
    public static void main(String[] args){
        Enum_BaseFeature[] values= Enum_BaseFeature.values();//是由编译器添加的static方法
        for(int i=0;i<values.length;i++){
            System.out.println(values[i]+"-->"+values[i].ordinal());
            System.out.println("getDeclaringClass()="+values[i].getDeclaringClass());
            System.out.println(values[i]+"-->"+values[i].name());
        }
        System.out.println("Enum_BaseFeature.valueOf('ONE')-->"+ Enum_BaseFeature.valueOf("ONE"));
    }
}
