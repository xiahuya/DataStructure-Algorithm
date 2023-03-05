package datastructure.A03_linkedlist;

/**
 * @author Xiahu
 * @create 2023/3/1
 *
 */
public class HeroNode {
    int id = 0;
    String name;
    String nickName;
    HeroNode next;


    public HeroNode(int id,String name,String nickName) {
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
