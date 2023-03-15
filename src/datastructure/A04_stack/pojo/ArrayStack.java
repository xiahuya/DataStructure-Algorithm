package datastructure.A04_stack.pojo;

/**
 * @author Xiahu
 * @create 2023/3/8
 *  使用数组构建一个栈
 */
public class ArrayStack {
    int[] dataArray;

    int top = -1;
    int maxSize;

    public ArrayStack(int size) {
        maxSize = size;
        dataArray = new int[size];
    }

    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("栈已经满了");
        }
        top++;
        dataArray[top] = data;
        System.out.println(String.format("栈内添加数据：%s", data));
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈内没有数据了");

        }
        int data = dataArray[top--];
        System.out.println(String.format("栈内删除数据：%s", data));
        return data;
    }

    public boolean isEmpty() {
        boolean flag = false;
        if (top < 0) {
            flag = true;
        }
        return flag;
    }

    public boolean isFull() {
        boolean flag = false;
        if (top > maxSize - 1) {
            flag = true;
        }
        return flag;
    }

    public int size() {
        return top + 1;
    }


}
