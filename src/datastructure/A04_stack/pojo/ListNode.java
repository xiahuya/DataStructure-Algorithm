package datastructure.A04_stack.pojo;

/**
 * @author Xiahu
 * @create 2023/3/8
 */
public class ListNode {
    public int num;
    public ListNode next;

    public ListNode(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "num=" + num +
                '}';
    }
}
