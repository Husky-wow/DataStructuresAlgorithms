package stack.postfix;

import java.util.List;

public class PostExpressionCalDemo {
    public static void main(String[] args) {
        // (3+4)*5-6 => 3 4 + 5 * 6 -  =
        /*String expression = "3 4 + 5 * 6 -";
        PostfixExpressionCal calculator = new PostfixExpressionCal();
        int result = calculator.calPostfixExpression(expression);
        System.out.println(expression + " = " + result);*/

        String infixExpression = "(300+412)*45-64";

        Infix2PostExpression convertor = new Infix2PostExpression();

        List<String> infixList = Infix2PostExpression.infixString2List(infixExpression);
        for (String item: infixList) {
            System.out.print(item);
        }

        List<String> postfixList = Infix2PostExpression.infix2Postfix(infixList);
        System.out.println("后缀表达式");
        for (String item: postfixList) {
            System.out.print(item + " ");
        }


    }
}
