package JavaEnum.向enum中添加属性与方法;

import JavaEnum.基本enum特性.Enum_BaseFeature;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public enum Enum_AddMumber {

    ONE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args){
        ONE.setValue(1);
        System.out.println(ONE.getValue());
    }

}
