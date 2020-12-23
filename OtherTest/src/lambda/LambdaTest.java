package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxiaoding
 * @version 1.0.0
 * @ClassName LambdaTest.java
 * @Description TODO
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.stream().filter(i -> i % 2 ==0).forEach(System.out::println);


        // list.stream().forEach((i) -> {
        //     if (i % 2 == 0) {
        //         System.out.println(i * i);
        //     }
        // });
    }
}
