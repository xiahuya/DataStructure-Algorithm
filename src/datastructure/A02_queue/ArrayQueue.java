package datastructure.A02_queue;

/**
 * @author Xiahu
 * @create 2023/2/28
 * 基于数组实现一个队列
 */
public class ArrayQueue {
    //成员变量
    private int maxSize;
    // 队头下标
    private int front = -1;

    //队尾下标
    private int rear = -1;

    private int[] queue;

    //构造方法
    public ArrayQueue(int capacity) {
        this.maxSize = capacity;
        this.queue = new int[this.maxSize];
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    // 判断队列是否已经满了
    public boolean isFull() {
        return this.rear + 1 == this.maxSize;
    }

    // 入队方法
    public void addQueue(int data) {
        //判断队列是否已经满了
        if (isFull()) {
            throw new RuntimeException("队列已经满了,无法添加数据");
        } else {
            queue[++rear] = data;
        }
    }


    // 出队方法
    public int headQueue() {
        int result;
        //判断队列是否已经满了
        if (isEmpty()) {
            throw new RuntimeException("队列是空,没有数据");
        }
        front++;
        return queue[front];
    }

    public void showQueue() {
        if(isEmpty()){
            throw new RuntimeException("队列是空,没有数据");
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }
}
