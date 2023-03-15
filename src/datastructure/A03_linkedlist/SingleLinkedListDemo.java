package datastructure.A03_linkedlist;

/**
 * @author Xiahu
 * @create 2023/3/1
 */
public class SingleLinkedListDemo {
    /*public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(new HeroNode(1,"宋江","及时雨"));
        linkedList.add(new HeroNode(5,"林冲","豹子头"));
        linkedList.add(new HeroNode(7,"李逵","黑旋风"));
        linkedList.add(new HeroNode(8,"武松","行者"));
        linkedList.list();
        System.out.println("============删除============");
        linkedList.delete("卢俊义");
        linkedList.delete("吴用");
        linkedList.list();
    }*/

    public static void main(String[] args) {
        /*SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByOrder2(new HeroNode(7,"李逵","黑旋风"));
        linkedList.addByOrder2(new HeroNode(1,"宋江","及时雨"));
        linkedList.addByOrder2(new HeroNode(8,"武松","行者"));
        linkedList.addByOrder2(new HeroNode(5,"林冲","豹子头"));*/

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByOrder2(new HeroNode(7,"李逵","黑旋风"));
        linkedList.addByOrder2(new HeroNode(1,"宋江","及时雨"));
        linkedList.addByOrder2(new HeroNode(8,"武松","行者"));
        linkedList.addByOrder2(new HeroNode(5,"林冲","豹子头"));

        SingleLinkedList linkedList2 = new SingleLinkedList();
        linkedList2.addByOrder2(new HeroNode(2,"张三","张啊三"));
        linkedList2.addByOrder2(new HeroNode(3,"李四","李啊四"));
        linkedList2.addByOrder2(new HeroNode(4,"王五","王啊五"));
        linkedList2.addByOrder2(new HeroNode(6,"赵六","赵啊六"));


        linkedList.list();
        System.out.println("***************************");

        //System.out.println(linkedList.getLastNodeByIndex(linkedList.headNode,5));
       /* SingleLinkedList.reverseList(linkedList.headNode);
        linkedList.list();
        System.out.println("***************************");*/

        /*linkedList.println(linkedList.headNode);*/
        SingleLinkedList.mergeList(linkedList.headNode,linkedList2.headNode);
        linkedList.list();
        System.out.println("***************************");


    }
}
