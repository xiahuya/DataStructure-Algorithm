package datastructure.A04_stack;

import datastructure.A04_stack.pojo.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
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
//        String expression = "3 4 + 5 * 6 -";
        String expression = "4 5 * 8 - 60 + 8 2 / +";
        PoLandNotation poLandNotation = new PoLandNotation();
        //poLandNotation.compute(expression);
        expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        poLandNotation.transform(expression);
    }


    // 逆波兰表达式计算
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



    Stack<Character> charStack = new Stack<>("符号");

    // 中缀表达式转为后缀表达式
    // 1 + ( ( 2 + 3 ) * 4 ) - 5 ==> 1 2 3 + 4 * 5 - +
    public void transform(String expression) {
        String[] expressArray = expression.trim().split(" ");
        for (String element : expressArray) {
            if (CounterStack.isDigit(element)) {
                numberStack.push(element);
            } else {
                // 如果操作符栈为null,直接添加
                if (charStack.isEmpty() || element.equalsIgnoreCase("(")) {
                    charStack.push(element.charAt(0));
                } else if (element.equalsIgnoreCase(")")) {
                    while (true) {
                        Character pop = charStack.pop();
                        if (String.valueOf(pop).equalsIgnoreCase("(")) {
                            break;
                        } else {
                            numberStack.push(String.valueOf(pop));
                        }
                    }
                } else {
                    if (charStack.isEmpty()) {
                        charStack.push(element.charAt(0));
                    } else {
                        Character lastChar = charStack.peek();
                        if (!String.valueOf(lastChar).equalsIgnoreCase("(")) {
                            // 如果上一个操作符的优先级 >= 当前操作符 ,直接添加
                            boolean flag = CounterStack.comparePrioroty(lastChar, element.charAt(0));
                            if (flag) {
                                charStack.push(element.charAt(0));
                            } else {
                                // 当前操作符的优先级要大
                                Character pop = charStack.pop();
                                numberStack.push(String.valueOf(pop));
                            }
                        } else {
                            charStack.push(element.charAt(0));
                        }
                    }

                }
            }
        }

        // 将符号栈中的元素按序添加到数字栈中
        System.out.println("===将符号栈中的元素按序添加到数字栈中===");
        LinkedList<String> linkedList = new LinkedList<>();
        while (true) {
            if (charStack.isEmpty()) {
                break;
            }
            linkedList.addFirst(String.valueOf(charStack.pop()));
        }
        linkedList.forEach(a -> {
            numberStack.push(a);
        });
        System.out.println("======================================");

        // 遍历numberStack
        linkedList.clear();
        while (true) {
            if (numberStack.isEmpty()) {
                break;
            }
            linkedList.addFirst(numberStack.pop());
        }
        linkedList.forEach(a -> {
            System.out.print(a + " ");
        });
    }
}
