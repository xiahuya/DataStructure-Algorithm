package algorithm.leetcode.stack;

/**
 * @author Xiahu
 * @create 2023/3/2 0002
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 * 输出：   [null,null,3,-1,-1]
 *
 * 图解：https://www.processon.com/view/link/6400706c0766090488347c67
 */
public class JZ_09_Stack {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }

}


class CQueue {
    CStack tmpStack = null;
    CStack saveStack = null;


    public CQueue() {
        tmpStack = new CStack();
        saveStack = new CStack();
    }

    public void appendTail(int value) {
        // 如果存储的栈没有数据,直接添加数据至存储栈
        if (saveStack.length() == 0) {
            saveStack.push(value);
        } else {
            //将存储栈的数据取出来,都放入临时栈
            while (saveStack.length() > 0) {
                tmpStack.push(saveStack.poll());
            }

            //将新添加的数据装入存储栈
            saveStack.push(value);

            //在将临时栈的所有数据装入存储栈
            while (tmpStack.length() > 0) {
                saveStack.push(tmpStack.poll());
            }
        }
    }

    public int deleteHead() {
        return saveStack.poll();

    }
}

class CStack {
    int[] array;

    int currentIndex = -1;

    public CStack() {
        array = new int[1001];
    }


    //入栈
    public void push(int value) {
        currentIndex++;
        array[currentIndex] = value;
    }


    //弹栈
    public int poll() {
        if (currentIndex == -1) {
            return -1;
        }
        return array[currentIndex--];
    }

    public int length() {
        return currentIndex + 1;
    }

}
