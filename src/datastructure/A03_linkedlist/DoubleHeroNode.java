package datastructure.A03_linkedlist;

/**
 * @author Xiahu
 * @create 2023/3/1
 * 双向链表节点
 *
 */
public class DoubleHeroNode {
    int id = 0;
    String name;
    String nickName;
    DoubleHeroNode next;
    DoubleHeroNode pre;


    public DoubleHeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
