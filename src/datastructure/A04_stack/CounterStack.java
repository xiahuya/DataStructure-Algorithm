package datastructure.A04_stack;


import datastructure.A04_stack.pojo.Stack;

/**
 * @author Xiahu
 * @create 2023/3/8
 * 基于栈 & 中缀表达式 实现一个 + - * / 的计算器
 */
public class CounterStack {
    Stack<String> numStack;

    Stack<Character> charStack;


    public CounterStack() {
        numStack = new Stack("数字");
        charStack = new Stack("符号");
    }


    public static void main(String[] args) {
        CounterStack stack = new CounterStack();
        String express = "13 + 2 * 6 * 2 - 25";
        stack.compute(express);
    }


    /**
     * 思路：
     * 1、遍历表达式,如果碰到数字,直接放入数字栈
     * 2、如果碰到符号,进行判断：如果栈内为空,直接添加符号
     * 3、如果栈内不为空,判断符号的优先级;
     * 4、如果上一个符号是+&-,当前符号是 *&/,则表示当前符号优先级大,直接添加到符号栈
     * 5、如果上一个符号是*&/,当前符号是 +&-,则表示当前符号优先级大,需要从数字栈中弹出两个元素,与当前符号进行运算,将最终结果添加到数字栈
     * 6、直至表达式中的内容遍历结束
     * 7、while(true)进行循环,直到符号栈.isEmpty()结束
     * 8、从数字栈中弹出两个元素,与当前符号进行运算,将最终结果添加到数字栈
     * <p>
     * 问题？如果数字是两位数,三位数,甚至是多位数,应该怎么判断呢
     */
    public void compute(String expression) {
        expression = expression.replaceAll(" ", "");

        int numLen = 0;
        // 依次将表达式中的数据填入栈中
        while (expression.length() > 0) {
            StringBuffer sb = new StringBuffer();
            char[] chars = expression.toCharArray();
            for (char aChar : chars) {
                // 如果是数字
                if (isDigit(aChar)) {
                    numLen++;
                    sb.append(aChar);
                } else {
                    break;
                }

            }

            String operStr = null;
            if (numLen == 0) {
                operStr = expression.substring(0, 1);
                numLen++;
            } else {
                operStr = sb.toString();
            }

            expression = expression.substring(numLen, expression.length());
            numLen = 0;


            if (isDigit(operStr)) {
                numStack.push(operStr);
            } else {
                char achar = operStr.charAt(0);
                // 判断栈内是否有操作符号
                if (charStack.size() > 0) {
                    //栈内有操作符,判断上一个操作符的优先级是否较高
                    // 如果当前操作符的优先级低于上一个操作符的优先级,需要取出numStack的两个元素做运算
                    Character lastChar = charStack.peek();

                    boolean flag = comparePrioroty(lastChar, achar);
                    if (flag) {
                        Integer num1 = Integer.valueOf(numStack.pop());
                        Integer num2 = Integer.valueOf(numStack.pop());
                        Character chara = charStack.pop();
                        int compute = compute(num1, num2, chara);
                        numStack.push(String.valueOf(compute));
                        charStack.push(achar);
                    } else {
                        charStack.push(achar);
                    }
                } else {
                    charStack.push(achar);
                }
            }
        }

        while (!charStack.isEmpty()) {
            // 依次遍历两个栈,获取最终结果集
            Integer num1 = Integer.valueOf(numStack.pop());
            Integer num2 = Integer.valueOf(numStack.pop());
            Character chara = charStack.pop();
            int compute = compute(num1, num2, chara);
            numStack.push(String.valueOf(compute));
        }
        System.out.println(numStack.pop());

    }


    // 是否为 阿拉伯数字
    public static boolean isDigit(String achar) {
        if (achar.length() == 1) {
            return Character.isDigit(achar.charAt(0));
        } else {
            return true;
        }

    }

    public static boolean isDigit(char achar) {
        return Character.isDigit(achar);
    }


    //比较优先级
    // + : 43
    // - : 45
    // * : 42
    // / : 47
    public static boolean comparePrioroty(char lastChara, char currentChara) {
        int lastPriority = getPriority(lastChara);
        int currentPriority = getPriority(currentChara);
        return lastPriority >= currentPriority ? true : false;
    }

    public static int compute(int numA, int numB, char chara) {
        int result = 0;
        String charStr = String.valueOf(chara).trim();
        switch (charStr) {
            case "+":
                result = numB + numA;
                break;
            case "-":
                result = numB - numA;

                break;
            case "*":
                result = numB * numA;
                break;
            case "/":
                result = numB / numA;
                break;
        }
        return result;
    }

    public static int getPriority(char achar) {
        int priority = -1;
        switch ((int) achar) {
            case 43:
            case 45:
                priority = 0;
                break;
            case 42:
            case 47:
                priority = 1;
                break;
            default:
                throw new RuntimeException("运算符有问题");
        }
        return priority;
    }
}

