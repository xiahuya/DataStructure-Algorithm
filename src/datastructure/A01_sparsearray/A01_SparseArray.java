package datastructure.A01_sparsearray;

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
                if (data != 0) {
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
                if (data != 0) {
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
        System.out.println("******************************************");

        //B、稀疏数组 --> 二维数组
        //1、读取稀疏数组第一行数据,创建二维数组
        int m =  sparseArray[0][0];
        int n =  sparseArray[0][1];

        int[][] array2 = new int[m][n];

        //2、遍历稀疏数组剩余的元素
        for (int i = 1; i < sparseArray.length; i++) {
            int x1 = sparseArray[i][0];
            int y1 = sparseArray[i][1];
            int data1 = sparseArray[i][2];
            array2[x1][y1] = data1;
        }

        //3、打印二维数组
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                int data = array2[i][j];
                System.out.print(String.format("%d\t", data));
            }
            System.out.println();
        }
    }
}
