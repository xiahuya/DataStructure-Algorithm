package datastructure.A04_stack.pojo;

/**
 * @author Xiahu
 * @create 2023/3/14
 */
public class Stack<T> {
    T[] dataArray;

    int top = -1;

    String name = null;

    public Stack(String stackName) {
        dataArray = (T[]) new Object[10];
        this.name = stackName;
    }


    public void push(T data) {
        top++;
        dataArray[top] = data;
        System.out.println(String.format("%s栈内添加数据：%s", this.name, data));
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println(String.format("%s栈内没有数据", this.name));
            return null;
        }
        T data = dataArray[top--];
        System.out.println(String.format("%s栈内删除数据：%s", this.name, data));
        return data;
    }

    public T peek() {
        return dataArray[top];
    }

    public boolean isEmpty() {
        boolean flag = false;
        if (top < 0) {
            flag = true;
        }
        return flag;
    }

    public int size() {
        return top + 1;
    }
}
