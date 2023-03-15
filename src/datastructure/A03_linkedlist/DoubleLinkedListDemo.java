package datastructure.A03_linkedlist;

/**
 * @author Xiahu
 * @create 2023/3/5
 * 双向链表测试类
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        // add 测试
        doubleLinkedList.addOrderby(new DoubleHeroNode(1,"宋江","及时雨"));
        doubleLinkedList.addOrderby(new DoubleHeroNode(8,"武松","行者"));
        doubleLinkedList.addOrderby(new DoubleHeroNode(5,"林冲","豹子头"));
        doubleLinkedList.addOrderby(new DoubleHeroNode(7,"李逵","黑旋风"));

        doubleLinkedList.list();

        // 删除测试
        doubleLinkedList.delete(new DoubleHeroNode(1,"宋江","及时雨"));
        doubleLinkedList.list();

        doubleLinkedList.delete(new DoubleHeroNode(10,"宋江","及时雨"));
        doubleLinkedList.list();

        // 修改测试
        doubleLinkedList.update(new DoubleHeroNode(5,"林怂蛋","禁军教头"));
        doubleLinkedList.list();
    }
}
