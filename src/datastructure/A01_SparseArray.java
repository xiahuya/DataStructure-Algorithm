package datastructure;

/**
 * @author Xiahu
 * @create 2023/2/27
 * <p>
 * 稀疏数组
 * <p>
 * 二维数组 ---> 稀疏数组
 * 稀疏数组 ---> 二维数组
 */
public class A01_SparseArray {
    public static void main(String[] args) {
        //创建一个二维数组(11*11),模拟棋盘
        int[][] array = new int[11][11];

        // 元素 1 表示黑棋
        // 元素 2 表示白旗


        array[1][2] = 1;
        array[2][3] = 2;
        array[3][4] = 2;

        //打印原始棋盘
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int data = array[i][j];
                System.out.print(String.format("%d\t", data));
            }
            System.out.println();
        }

        System.out.println("******************************************");


        //A、二维数组 ---> 稀疏数组
        //1、遍历二维数组,获取有效元素的个数
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int data = array[i][j];
                if (data > 0) {
                    sum++;
                }
            }
        }

        //2、根据sum,创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];

        //3、遍历二维数组、依次填入有效元素
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array.length;
        sparseArray[0][2] = sum;

        int x = 1;
        int y = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int data = array[i][j];
                if (data > 0) {
                    sparseArray[x][0] = i;
                    sparseArray[x][1] = j;
                    sparseArray[x][2] = data;
                    x ++;
                }

            }

        }

        //4、打印稀疏数组
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                int data = sparseArray[i][j];
                System.out.print(String.format("%d\t", data));
            }
            System.out.println();
        }

    }
}
