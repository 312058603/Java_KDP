package Java8NewFeature;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wpx on 2017/12/12.
 */
public class Main {
    public static void main(String[] args) {
        //Lambda表达式
        Lambda lambda = () -> {
            System.out.println("Lambda");
        };
        lambda.onlyOneMethod();

        //方法引用 使得Lambda更加简洁
        //构造器引用 构造器没有参数
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        //静态方法方法引用 方法接受一个Car类型的参数
        cars.forEach(Car::collide);
        //特定类的任意对象的方法引用 方法没有参数
        cars.forEach(Car::repair);
        //引特定对象的方法引用 方法接受一个Car类型的参数
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

        //生成Stream
        // 1. 对象
        Stream stream = Stream.of("a", "b", "c");
        // 2. 数组
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. 集合
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

        List<Student> students = Arrays.asList(
                new Student("Fndroid", 22, Student.Sax.MALE, 180),
                new Student("Jack", 20, Student.Sax.MALE, 170),
                new Student("Liliy", 18, Student.Sax.FEMALE, 160)
        );

        students.stream()
                .filter(student -> student.getSax() == Student.Sax.MALE) // 进行过滤
                .forEach(System.out::println); // 输出

        OptionalDouble averageAge = students.stream()
                .mapToInt(Student::getAge) // 将对象映射为整型
                .average(); // 根据整形数据求平均值
        System.out.println("所有学生的平均年龄为：" + averageAge.orElse(0));

        List<String> names = students.stream()
                .map(Student::getName) // 将Student对象映射为String（姓名）
                .map(String::toUpperCase) // 将姓名转为小写
                .collect(Collectors.toList()); // 生成列表
        System.out.println("所有学生姓名的大写为：" + names);

        List<Student> sortedStudents = students.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge()) // 按照年龄排序
                .collect(Collectors.toList()); // 生成列表
        System.out.println("按年龄排序后列表为：" + sortedStudents);


        boolean isContain = students.stream()
                .anyMatch(student -> student.getName().equals("Fndroid")); // 查询任意匹配项是否存在
        System.out.println("是否包含姓名为Fndroid的学生：" + isContain);


        Map<Student.Sax, List<Student>> groupBySax = students.stream()
                .collect(Collectors.groupingBy(Student::getSax)); // 根据性别进行分组
        System.out.println(groupBySax.get(Student.Sax.FEMALE));


        double sumHeight = students.stream().mapToInt(Student::getHeight).sum(); // 求出身高总和
        DecimalFormat formator = new DecimalFormat("##.00"); // 保留两位小数
        List<String> percentages = students.stream()
                .mapToInt(Student::getHeight) // 将Student对象映射为身高整型值
                .mapToDouble(value -> value / sumHeight * 100) // 求出比例
                .mapToObj(per -> formator.format(per) + "%") // 组装为字符串
                .collect(Collectors.toList());
        System.out.println("所有学生身高比例：" + percentages);

        Method method = null;
        try {
            method = Main.class.getMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }

        //并行数据数组
        long[] arrayOfLong = new long[20000];
        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
    }
}
