package com.orange.viewbinding;

import org.junit.Test;
import org.mockito.internal.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void lambda() {
        //java8-lambda
        Arrays.asList("a", "b", "c").sort((c1, c2) -> c1.compareTo(c2));
        //java7
        Arrays.asList("a", "b", "c").sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    /**
     * java.util.Collection接口新方法：stream、parallelStream、forEach、removeif
     * java8 提供了大量默认函数式接口
     * Function<T,R>: T输入,R输出
     * Predicate<T>
     * Consumer<T>
     * Supplier<T>
     * BinaryOperator<T>2个T输入
     * UnaryOperator<T>输入、输出都是T
     */
    @Test
    public void functionalIfc() {
        Function<String, String> funtion1 = (s) -> {
            return s + "Function";
        };
        Function<String, String> funtion2 = s -> {
            return s + "Function";
        };
        Function<String, String> funtion3 = s -> s + "Function";
        String add = funtion1.apply("first");
        System.out.println("add: " + add);

        UnaryOperator<String> unaryOperator = s -> {
            return s + 2;
        };
        System.out.println("unaryOperator: " + unaryOperator.apply("9420-"));

        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };
        consumer1.accept("Consumer");

        Supplier<String> supplier = () -> "Supplier";
        System.out.println(supplier.get());

        BinaryOperator<Integer> bina = (x, y) -> x + y;
        System.out.println(bina.apply(1, 2) + "");
    }

    @Test
    public void funApply() {
        Car car = Car.create(Car::new);
        Car car1 = Car.create(() -> new Car());

        List<Car> list = new ArrayList<>();
        list.forEach(Car::collide);//静态方法带参数

        list.forEach(Car::repair);// 成员方法不带参数
    }

    @Test
    public void streams() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Stream<Integer> integerStream = list.stream().filter(i -> i > 2);
        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println(collect);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("奔驰1", 10001));
        cars.add(new Car("奔驰1", 20001));
        cars.add(new Car("奔驰2", 10002));
        cars.add(new Car("奔驰3", 10003));
        cars.add(new Car("奔驰4", 10004));
        List<String> collect1 = cars.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(collect1);

        Map<String, List<Car>> collect2 = cars.stream().collect(Collectors.groupingBy(Car::getName));
        System.out.println(collect2);

        Map<String, Integer> collect3 = cars.stream().collect(Collectors.groupingBy(Car::getName, Collectors.summingInt(Car::getNumber)));
        System.out.println(collect3);

        List<Vehicle> vehicles = new ArrayList<>();
        List<String> imeis = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> singleVehicleDevices = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String imei = String.valueOf(new Random().nextInt(15));
                singleVehicleDevices.add(imei);
            }
            imeis.add(StringUtil.join(singleVehicleDevices, ','));
        }
        vehicles.add(new Vehicle("KPTSOA1K67P081452", "17620411498", "9420", 1, 4.5, imeis.get(0)));
        vehicles.add(new Vehicle("KPTCOB1K18P057071", "15073030945", "张玲", 2, 1.4, imeis.get(1)));
        vehicles.add(new Vehicle("KPTS0A1K87P080237", "19645871598", "sanri1993", 1, 3.0, imeis.get(2)));
        vehicles.add(new Vehicle("KNAJC526975740490", "15879146974", "李种", 1, 3.9, imeis.get(3)));
        vehicles.add(new Vehicle("KNAJC521395884849", "13520184976", "袁绍", 2, 4.9, imeis.get(4)));

        List<String[]> collect4 = vehicles.stream().map(vehicle -> vehicle.getDeviceNos().split(",")).collect(Collectors.toList());

        for (String[] s : collect4) {
            System.out.println(Arrays.toString(s));
        }
    }

    @Test
    public void optional() {
        String a = null;
        Optional<String> opt = Optional.ofNullable(a);
        opt.ifPresent(System.out::println);
    }

    @Test
    public void map() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(squaresList);
    }

    @Test
    public void limit() {
        Random ran = new Random();
        ran.ints(5, 5, 20).forEach(System.out::println);
    }

    @Test
    public void parallel() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
// 获取空字符串的数量
        int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("count: " + count);
    }

    @Test
    public void summary(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
    }
}
