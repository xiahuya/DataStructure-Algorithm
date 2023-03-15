package datastructure.A04_stack;

/**
 * @author Xiahu
 * @create 2023/3/8
 */
public class StackDemo {
    public static void main(String[] args) {
        /*ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        System.out.println(stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();*/
        System.out.println("*****************");
        LinkedListStack linkedListStack = new LinkedListStack(10);
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);
        linkedListStack.list();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.pop();


    }

}
