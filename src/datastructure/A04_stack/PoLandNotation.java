package datastructure.A04_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiahu
 * @create 2023/3/14
 * <p>
 * 基于栈 & 逆波兰表达式实现计算器
 */
public class PoLandNotation {
    private Stack<String> numberStack = new Stack<>("数字");

    public static void main(String[] args) {
        String expression = "3 4 + 5 * 6 -";
        PoLandNotation poLandNotation = new PoLandNotation();
        poLandNotation.compute(expression);
    }


    public void compute(String expression) {
        List<String> list = new ArrayList<>();
        String[] strArray = expression.trim().split(" ");
        // 数组 --> list
        for (String str : strArray) {
            list.add(str);
        }

        for (String element : list) {
            if (CounterStack.isDigit(element)) {
                numberStack.push(element);
            } else {
                Integer num1 = Integer.valueOf(numberStack.pop());
                Integer num2 = Integer.valueOf(numberStack.pop());
                Character chara = element.charAt(0);
                int compute = CounterStack.compute(num1, num2, chara);
                numberStack.push(String.valueOf(compute));
            }
        }

        System.out.println(numberStack.pop());

    }
}
