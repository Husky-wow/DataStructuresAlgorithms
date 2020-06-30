package stack;

/**
 * @author admin
 * @ClassName CalculatorDemo.java
 * @Description TODO
 * @createTime 2020年06月29日 23:24:00
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        String str = "4/2*2";
        Calculator calculator = new Calculator();

        try {
            int result = calculator.calculation(str);
            System.out.println("result = " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*System.out.println("NumStack~~~");
        calculator.getNumStack().list();
        System.out.println("OperaStack~~~");
        calculator.getOperaStack().list();*/
    }
}
