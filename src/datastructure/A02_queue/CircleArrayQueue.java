package datastructure.A02_queue;

/**
 * @author Xiahu
 * @create 2023/2/28
 * 基于数组实现一个环形队列
 */
public class CircleArrayQueue {
    //成员变量
    private int maxSize;
    // 队头下标
    private int front = -1;

    //队尾下标
    private int rear = -1;

    private int[] queue;

    //构造方法
    public CircleArrayQueue(int capacity) {
        this.maxSize = capacity;
        this.queue = new int[this.maxSize];
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        if (this.front == -1) {
            return false;
        }
        return this.rear == this.front;
    }

    // 判断队列是否已经满了
    public boolean isFull() {
        if (this.rear == -1) {
            return false;
        }
        return this.rear + 1 % this.maxSize == 0;
    }

    // 入队方法
    public void addQueue(int data) {
        //判断队列是否已经满了
        if (isFull()) {
            throw new RuntimeException("队列已经满了,无法添加数据");
        } else {
            if (rear + 1 == maxSize) {
                rear = 0;
                queue[rear] = data;
            } else {
                queue[++rear] = data;
            }
            System.out.println("添加数据：" + data);
        }
    }


    // 出队方法
    public void headQueue() {
        int result;
        //判断队列是否已经满了
        if (isEmpty()) {
            throw new RuntimeException("队列是空,没有数据");
        } else {
            if (front + 1 == maxSize) {
                front = 0;
            } else {
                front++;
            }
        }
        System.out.println("取出数据：" + queue[front]);
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空,没有数据");
        }
        for (int i = front + 1; i < maxSize; i++) {
            System.out.println(queue[i]);
        }

        for (int i = 0; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }
}
