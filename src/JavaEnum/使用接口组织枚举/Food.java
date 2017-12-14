package JavaEnum.使用接口组织枚举;

/**
 * Created by GM-KF007 on 2017/12/14.
 */
public interface Food {
    // 油泼面,裤袋面,扯面
    enum Noodle implements Food {POUPO_NOODLE, POCKET_NOODLE, PULLED_NOODLE}
    // 盖浇饭,黄焖鸡,炒饭
    enum Rice implements Food {GAIJIAO_RICE, BRAISED_CHICKEN_RICE, FRIED_RICE}
    // 蔬菜类:西红柿,土豆,西兰花
    enum Vegetables implements Food {TOMATO, POTATO, BROCCOLI}
    //对enum而言,实现接口,是实现子类化的唯一方式,上面的例子,每个enum都实现了Food接口,可以向上转型,所有的东西都是一种食物.
    public static void main(String[] args) {
        Food food1 = Noodle.POUPO_NOODLE;
        Food food2 = Rice.GAIJIAO_RICE;
        Food food3 = Vegetables.BROCCOLI;
        System.out.println(food1);
        System.out.println(food2);
        System.out.println(food3);
    }
}