package datastructure.A03_linkedlist;

/**
 * @author Xiahu
 * @create 2023/3/5
 * 双向链表
 */
public class DoubleLinkedList {
    public DoubleHeroNode headNode;

    public DoubleLinkedList() {
        this.headNode = new DoubleHeroNode(0, "", "");
    }


    // 添加
    // 默认添加到链表的最后一个节点
    public void add(DoubleHeroNode node) {
        // 找到当前的节点
        DoubleHeroNode temp = headNode;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        temp.next = node;
        node.pre = temp;
    }

    // 根据ID有序添加
    public void addOrderby(DoubleHeroNode node) {
        // 找到当前的节点
        DoubleHeroNode temp = headNode;

        // 表示当前节点temp的下一个节点
        DoubleHeroNode next = null;

        boolean flag = false;



        while (true) {
            if (temp.next == null) {
                break;
            }

            next = temp.next;
            if(temp.next.id > node.id){
                flag = true;
                break;
            }
            temp = next;
        }

        if(flag){
            node.pre = temp;
            temp.next = node;
            node.next = next;
            next.pre = node;
        }else{
            temp.next = node;
            node.pre = temp;
        }


    }

    // 删除
    public void delete(DoubleHeroNode node) {
        DoubleHeroNode temp = headNode.next;

        // 是否找到待删除的节点
        boolean flag = false;

        while (true){
            if(temp == null){
                break;
            }

            if(temp.id == node.id){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            // 找到了待删除的节点
            temp.next.pre = temp.pre;
            temp.pre.next = temp.next;
            System.out.println(String.format("成功删除ID = %s 的节点",node.id));
        }else{
            System.out.println(String.format("没有找到ID = %s 的节点",node.id));
        }

    }

    public void update(DoubleHeroNode node) {
        DoubleHeroNode temp = headNode.next;

        // 是否找到待修改的节点
        boolean flag = false;

        while (true){
            if(temp == null){
                break;
            }

            if(temp.id == node.id){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            // 找到了待修改的节点
            temp.name = node.name;
            temp.nickName = node.nickName;
            System.out.println(String.format("成功修改ID = %s 的节点",node.id));
        }else{
            System.out.println(String.format("没有找到ID = %s 的节点",node.id));
        }
    }

    public void list() {
        DoubleHeroNode temp = headNode.next;
        System.out.println("=======双向链表遍历开始=======");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("=======双向链表遍历结束=======");
    }
}
