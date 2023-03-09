package algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * @author Xiahu
 * @create 2023/3/8 0008
 * <p>
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)
 */
public class A02_MinStack {
    public static void main(String[] args) {
        //["MinStack","push","push","min","min","push","min","min","top","min","pop","push","push","min","push","pop","top","min","pop"]
        //[[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
        MinStack stack = new MinStack();
        stack.push(-10);
        stack.push(14);
        System.out.println(stack.min());
        System.out.println(stack.min());
        stack.push(-20);
        System.out.println(stack.min());
        System.out.println(stack.min());
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.pop();
        stack.push(10);
        stack.push(-7);
        System.out.println(stack.min());
        stack.push(-7);
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.pop();
        System.out.println("================");

        LinkedList<Integer> integers = new LinkedList<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        System.out.println(integers.pop());
        System.out.println(integers.peek());
    }

    //[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]

}


/**
 * 思路：
 * 同时生成两个栈,一个用于存储数据,另外一个用于存储min
 * 根据入栈的数据，比如顺序是:-2,0,-3
 * dataStack:-2,0,-3
 * minStack:-2,-2,-3
 */
class MinStack {

    int[] dataArray;
    int[] minArray;

    int top = -1;

    int lastValue = Integer.MAX_VALUE;


    public MinStack() {
        dataArray = new int[20001];
        minArray = new int[20001];
    }

    public void push(int x) {
        top++;
        dataArray[top] = x;

        lastValue = Math.min(lastValue, x);
        minArray[top] = lastValue;
    }


    // 弹出
    public void pop() {
        dataArray[top] = 0;
        minArray[top] = 0;
        if (top == 0) {
            top = 0;
            lastValue = Integer.MAX_VALUE;
        }else{
            lastValue = minArray[top -1];
            top--;
        }
    }

    // 输出
    public int top() {

        return dataArray[top];
    }

    public int min() {
        return minArray[top];
    }
}
