package stack.postfix;

public class PostExpressionCalDemo {
    public static void main(String[] args) {
        // (3+4)*5-6 => 3 4 + 5 * 6 -  =
        String expression = "3 4 + 5 * 6 -";
        PostfixExpressionCal calculator = new PostfixExpressionCal();
        int result = calculator.calPostfixExpression(expression);
        System.out.println(expression + " = " + result);
    }
}
