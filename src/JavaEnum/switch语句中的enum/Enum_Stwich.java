package JavaEnum.switch语句中的enum;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public enum  Enum_Stwich {
    ONE,TWO,THREE;
    public static void main(String[] args){
        Enum_Stwich enum_stwich=Enum_Stwich.ONE;
        switch (enum_stwich){
            case ONE:
                System.out.println(enum_stwich);
                break;
        }
    }

}
