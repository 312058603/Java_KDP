package JavaEnum.使用EnumSet替代标志;

import java.util.EnumSet;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public enum  EnumSetTest {

    STATUS1,
    STATUS2,
    STATUS3,
    STATUS4,
    STATUS5,
    STATUS6;

    public static void main(String[] args){
        EnumSet<EnumSetTest> currEnumSet=EnumSet.range(STATUS1,STATUS5);
        currEnumSet.remove(STATUS1);
        for (EnumSetTest enumSetTest : currEnumSet) {
            System.out.println("当前EnumSet中数据为：" + enumSetTest);
        }
    }

}
