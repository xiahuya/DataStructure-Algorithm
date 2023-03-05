package datastructure.A03_linkedlist;

import java.awt.*;

/**
 * @author Xiahu
 * @create 2023/3/1
 * 单链表
 */
public class SingleLinkedList {
    //声明一个head节点
    public HeroNode headNode = new HeroNode(0, "", "");


    // 添加一个节点到尾部
    // 思路: 找到链表的最后一个节点,将新节点添加即可
    public void add(HeroNode node) {
        HeroNode temp = headNode.next;
        while (true) {
            // 最后一个节点指向的地址为null,表示当前节点为最后一个节点
            if (temp == null) {
                temp = node;
                break;
            }
            temp = temp.next;
        }
    }

    // 根据排名,将英雄插入指定的位置(如果链表中有这个排名了,则标记失败)
    // 需要使用一个temp节点来标记,并且tmep节点是添加位置的前一个节点,否则无法添加
    public void addByOrder(HeroNode node) {
        HeroNode tempNode = headNode.next;
        HeroNode tempPreNode = headNode;

        if (tempNode == null) {
            tempPreNode.next = node;
            return;
        }

        int num = node.id;
        while (true) {
            if (num > tempNode.id) {
                tempPreNode = tempNode;
                tempNode = tempNode.next;
            } else if (tempNode.id == num) {
                System.out.println("已经存在这个英雄了,不能添加");
                return;
            } else if (num < tempNode.id) {
                tempPreNode.next = node;
                node.next = tempNode;
                return;
            }

            if (tempNode == null) {
                tempPreNode.next = node;
                return;
            }
        }
    }


    public void addByOrder2(HeroNode node) {
        HeroNode temp = headNode;

        // 是否有相同的人
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }

            // 当前node的ID:4 ,temp.next = 5 , 那么该node就是被添加到 temp  -->  node --->  temp.next
            if (temp.next.id > node.id) {

                break;
            }

            if (temp.next.id == node.id) {
                flag = true;
            }

            temp = temp.next;
        }

        if (flag) {
            System.out.println("已经存在相同编号的人,不能添加");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }


    // 根据ID删除节点,如果没有找到,警告
    public void delete(HeroNode newHeroNode) {
        // temp:待删除节点的前一个节点为: temp.next.name = name
        HeroNode temp = headNode;
        // 是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == newHeroNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            //找到了待删除的节点=temp.next
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到这个节点：" + newHeroNode);
        }
    }


    // 根据 id 修改node的name、nickName
    public void update(HeroNode newHeroNode) {
        // 构建temp节点,表示待删除节点
        HeroNode temp = headNode.next;
        // 是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == newHeroNode.id) {
                flag = true;
                break;
            }
            temp = newHeroNode.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没有找到这个节点：" + newHeroNode);
        }
    }


    // 遍历链表
    public void list() {
        HeroNode temp = headNode;

        while (true) {
            if (temp == null) {
                System.out.println("链表遍历结束");
                return;
            } else {
                System.out.println(temp);
            }
            temp = temp.next;
        }
    }


    /**
     * 获取单链表节点的个数,如果包含头节点,需要去除
     *
     * @param node 链表的头节点
     * @return 链表个数
     */
    public int size(HeroNode node) {
        int size = 0;
        HeroNode temp = node.next;
        while (true) {
            if (temp == null) {
                break;
            }
            size++;
            temp = temp.next;
        }

        return size;
    }


    //查找单链表中的倒数第K个节点
    // 思路:
    // 1、获取链表的size
    // 2、倒数第K个节点 = 正数(size - k)个节点
    public HeroNode getLastNodeByIndex(HeroNode node, int k) {
        HeroNode resultNode = null;
        int size = size(node);

        if (k <= 0 || k > size) {
            System.err.println("超过链表的长度");
            resultNode = null;
        }


        int index = 0;
        HeroNode tempNode = node.next;
        while (true) {
            if (tempNode == null) {
                resultNode = null;
                break;
            }

            if (index == (size - k)) {
                resultNode = tempNode;
                break;
            }
            index++;
            tempNode = tempNode.next;
        }

        return resultNode;
    }

    // 单链表反转
    // 思路图解：https://www.processon.com/view/link/64043ce81c8923293d83903c
    public static void reverseList(HeroNode headNode) {
        HeroNode reverseHeadNode = new HeroNode(0, "", "");


        HeroNode currentNode = headNode.next;
        HeroNode next = null; // 指向当前节点[current]的下一个节点


        // 遍历旧链表
        while (currentNode != null) {
            if (currentNode == null) {
                break;
            }

            // 需要使用一个临时变量存储原链表后续的数据
            next = currentNode.next;


            currentNode.next = reverseHeadNode.next;
            reverseHeadNode.next = currentNode;
            currentNode = next;
        }

        headNode.next = reverseHeadNode.next;
    }

    // 从尾到头打印单链表
    // 方式1: 先将单链表进行反转,然后顺序打印(不建议)
    // 方式2: 使用栈存储,在进行出栈打印
    public void println(HeroNode headNode) {
        Stack<HeroNode> heroNodeStack = new Stack();

        if (headNode.next == null) {
            System.out.println("链表没有数据");
        }

        HeroNode temp = headNode.next;
        while (temp != null) {
            heroNodeStack.push(temp);
            temp = temp.next;
        }

        int size = heroNodeStack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(heroNodeStack.poll());
        }
    }

    //合并两个有序的单链表,合并之后链表依然有序
    public static HeroNode mergeList(HeroNode headNodeA, HeroNode headNodeB) {
        // 思路：遍历链表B,将每一个节点添加到链表A

        HeroNode addNode = headNodeB.next;
        HeroNode next = null; // addNode 下一个节点

        while (addNode != null) {
            // 使用一个变量临时存储
            next = addNode.next;

            HeroNode tempNodeA = headNodeA;
            while (true) {
                if (tempNodeA.next == null) {
                    break;
                }

                if (tempNodeA.next.id  >= addNode.id) {
                    break;
                }
                tempNodeA = tempNodeA.next;
            }

            addNode.next = tempNodeA.next;
            tempNodeA.next = addNode;

            addNode = next;
        }
        return headNodeA;
    }

}

