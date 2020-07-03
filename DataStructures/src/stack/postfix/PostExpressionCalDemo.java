package stack.postfix;

import java.util.List;

public class PostExpressionCalDemo {
    public static void main(String[] args) {
        // (3+4)*5-6 => 3 4 + 5 * 6 -  =
        String expression = "3 4 + 5 * 6 -";
        PostfixExpressionCal calculator = new PostfixExpressionCal();
        int result = calculator.calPostfixExpression(expression);
        System.out.println(expression + " = " + result);

        String infixExpression = "(31+450)*4-60";

        List<String> infixList = Infix2PostExpression.infixString2List(infixExpression);
        System.out.println("中缀表达式");
        for (String item: infixList) {
            System.out.print(item);
        }
        System.out.println();

        List<String> postfixList = Infix2PostExpression.infix2Postfix(infixList);
        System.out.println("后缀表达式");
        for (String item: postfixList) {
            System.out.print(item + " ");
        }
        System.out.println();

        int postfixResult = calculator.calPostfixExpression(postfixList);
        System.out.println(infixExpression + " = " + postfixResult);




    }
}
