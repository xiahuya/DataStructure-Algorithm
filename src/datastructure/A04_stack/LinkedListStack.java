package datastructure.A04_stack;

/**
 * @author Xiahu
 * @create 2023/3/8
 * 使用单链表构建一个栈
 */
public class LinkedListStack {
    ListNode headNode;

    int currentSize = 0;
    int maxSize = 0;

    public LinkedListStack(int size) {
        maxSize = size;
    }

    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("栈已经满了");
        }

        //单链表的add方法
        if (headNode == null) {
            currentSize++;
            headNode = new ListNode(data);
            System.out.println(String.format("栈内添加数据：%s", data));
            return;
        }

        ListNode current = headNode;
        while (true) {
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        current.next = new ListNode(data);
        System.out.println(String.format("栈内添加数据：%s", data));
        currentSize++;
    }

    public int pop() {
        int data = -1;
        if (isEmpty()) {
            throw new RuntimeException("栈内没有数据了");
        }

        // 从后往前遍历链表
        ListNode current = headNode;

        boolean flag = false;
        while (true) {
            if (current.next == null) {
                flag = true;
                break;
            }
            if (current.next.next == null) {
                break;
            }

            current = current.next;
        }


        if (flag) {
            // 链表内只有一个节点
            data = headNode.num;
            headNode = null;
        } else {
            data = current.next.num;
            current.next = null;
        }
        currentSize--;
        System.out.println(String.format("栈内删除数据：%s", data));
        return data;
    }

    public void list() {
        ListNode current = headNode;
        while (true) {
            if (current == null) {
                break;
            }
            System.out.println(current);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        boolean flag = false;
        if (currentSize <= 0) {
            flag = true;
        }
        return flag;
    }

    public boolean isFull() {
        boolean flag = false;
        if (currentSize >= maxSize) {
            flag = true;
        }
        return flag;
    }

    public int size() {
        return currentSize;
    }


}
