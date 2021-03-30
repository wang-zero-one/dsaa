package com.bluesky.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建原始的二维数组 11 * 11
        // 0 ： 表示没有妻子 1 ：表示黑子 2 ： 表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("--------------------原始的二维数组--------------------");
        //输出原始的二维数据
        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        /**
         * 将二维数组转稀疏数组
         *  1、先遍历二维数组得到非0数据的个数
         */
        int sum = 0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //2、创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给系数数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值存放在spareArr中
        int count = 0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("--------------------得到的系数数组--------------------");
        for(int i = 0;i < sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
        System.out.println("--------------------系数数组恢复为原始数组--------------------");
        //先读取稀疏数组的第一行，根据第一行的数据创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //读取稀疏数组的数组赋值给原始二维数组
        for(int i = 1; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出恢复后的二维数组
        for(int[] row : chessArr2){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
