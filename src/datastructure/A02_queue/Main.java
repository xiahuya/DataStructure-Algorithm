package datastructure.A02_queue;

/**
 * @author Xiahu
 * @create 2023/2/28
 */
public class Main {
    public static void main(String[] args) {
        //testArrayQueue();
        testCircleArrayQueue();
    }

    public static void testArrayQueue(){
        ArrayQueue queue = new ArrayQueue(5);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);
        System.out.println(queue.headQueue());
        System.out.println(queue.headQueue());
        System.out.println("=====");
        queue.showQueue();
        System.out.println("=====");

        System.out.println(queue.headQueue());
        System.out.println(queue.headQueue());
        System.out.println(queue.headQueue());
        System.out.println(queue.headQueue());
    }

    public static void testCircleArrayQueue(){
        CircleArrayQueue queue = new CircleArrayQueue(5);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);
        queue.headQueue();
        queue.headQueue();
        queue.headQueue();
        queue.addQueue(6);
        queue.addQueue(7);
        /*System.out.println("=====");
        queue.showQueue();
        System.out.println("=====");*/
        queue.headQueue();
        queue.headQueue();
        queue.headQueue();
        queue.headQueue();
        queue.headQueue();
        queue.headQueue();
        /*System.out.println(queue.headQueue());
        System.out.println(queue.headQueue());
        System.out.println("=====");
        queue.showQueue();
        System.out.println("=====");

        System.out.println(queue.headQueue());
        System.out.println(queue.headQueue());
        System.out.println(queue.headQueue());
        System.out.println(queue.headQueue());*/
    }
}
