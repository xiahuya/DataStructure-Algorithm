package algorithm.leetcode.array;

/**
 * @author Xiahu
 * @create 2023/3/16 0016
 * 二维数组的查找
 */
public class JZ_04_TwoArray {

    public static void main(String[] args) {
        int num = 0;
        /*int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num++;
            }
        }

        // 打印二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }*/

        int[][] arr = new int[1][2];
        arr[0][0] = -1;
        arr[0][1] = 3;
        JZ_04_TwoArray JZ04TwoArray = new JZ_04_TwoArray();
        System.out.println(JZ04TwoArray.findNumberIn2DArray(arr,3));
    }


    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * <p>
     * 给定 target = 20，返回 false。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            int yLength = matrix[i].length;
            // 判断target是否在这一列
            if (matrix[i][0] <= target && matrix[i][yLength - 1] >= target) {
                for (int matrix1 : matrix[i]) {
                    if (matrix1 == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
