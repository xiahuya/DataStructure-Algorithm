package datastructure.A03_linkedlist;

/**
 * @author Xiahu
 * @create 2023/3/6
 * 环形链表
 */
public class LoopLinkedList {

    public Boy firstNode;

    // 创建任意node个数的环形链表
    public void add(int num) {
        if (num <= 1) {
            System.err.println(String.format("不允许创建节点个数为 %s 的环形链表", num));
        }

        Boy current = null;

        for (int i = 1; i <= num; i++) {
            Boy node = new Boy(i);
            if (i == 1) {
                firstNode = node;
                node.next = firstNode;
                current = firstNode;
            } else {
                current.next = node;
                node.next = firstNode;
                current = current.next;
            }
        }
    }

    // 环形链表判断条件：currentNode.next == firstNode
    public void list() {
        Boy current = firstNode;

        if(current == null){
            System.err.println("该环形链表没有数据");
            return;
        }

        while (true) {
            if (current.next == firstNode) {
                System.out.println(current);
                System.out.println("该环形链表遍历结束");
                break;
            }

            System.out.println(current);
            current = current.next;
        }
    }

    public void printJosepfu(int startIndex, int interval) {
        // 标记是否找到开始Boy
        boolean flag = false;

        Boy current = null;
        // 开始人的编号
        while (true) {
            current = firstNode;
            if (current.num == startIndex) {
                flag = true;
                break;
            }
            current = current.next;
        }

        if (flag) {
            firstNode = current;
            System.out.println(String.format("开始Boy: %s", firstNode));
        } else {
            System.err.println(String.format("没有找到指定编号为：%s 的Boy", startIndex));
            return;
        }

        // 当前node preBoy = 1 ,currentBoy = 2
        // currentBoy 被移除后,preBoy.next = currentBoy.next; currentBoy = currentBoy.next;
        Boy preBoy = null; // 删除的前一个boy
        Boy currentBoy = firstNode; // 待删除的boy


        // 1、获取开始Boy
        while (true) {
            // 判断循环链表是否结束
            if(currentBoy.next == currentBoy){
                System.out.println(String.format("当前退出的Boy是: %s", currentBoy));
                System.out.println("该环形链表遍历结束");
                return;
            }

            //为什么需要 -1 ,因为是从自身开始数,自己的那一次需要 -
            for (int i = 0; i < interval-1; i++) {
                preBoy = currentBoy;
                currentBoy = currentBoy.next;
            }

            System.out.println(String.format("当前退出的Boy是: %s", currentBoy));
            preBoy.next = currentBoy.next;

            // 待退出的Boy持续递增
            currentBoy = currentBoy.next;
        }
    }
}

class Boy {
    public int num;
    public Boy next;


    public Boy(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Boy{" + "num=" + num + '}';
    }
}

