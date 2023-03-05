package datastructure.A03_linkedlist;

/**
 * @author Xiahu
 * @create 2023/3/5
 */
class Stack<T> {
    public T[] heroNodeArray;
    int index = -1;

    public Stack() {
        heroNodeArray = (T[]) new Object[100];
    }

    public T poll() {
        if (index < 0) {
            System.err.println("栈内没得数据");
            return null;
        }
        return heroNodeArray[index--];
    }

    public void push(T headNode) {
        heroNodeArray[++index] = headNode;
    }

    public int size() {
        return index + 1;
    }

}
