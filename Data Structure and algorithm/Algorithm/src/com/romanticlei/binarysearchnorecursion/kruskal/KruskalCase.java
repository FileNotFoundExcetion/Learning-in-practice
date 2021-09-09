package com.romanticlei.binarysearchnorecursion.kruskal;

import java.util.Arrays;

public class KruskalCase {

    private int edgeNum;    // 边的个数
    private char[] vertexs; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    // 使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ { 0,   12, INF, INF, INF, 16,  14},
                /*B*/ { 12,  0,   10, INF, INF,  7, INF},
                /*C*/ { INF, 10,   0,   3,   5,  6, INF},
                /*D*/ { INF, INF,  3,   0,   4,INF, INF},
                /*E*/ { INF, INF,  5,   4,   0,  2,   8},
                /*F*/ { 16,    7,  6, INF,   2,  0,   9},
                /*G*/ { 14, INF,  INF, INF,  8,  9,   0}};

        // 创建 KruskalCase 对象实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        // 初始化顶点数和个数
        int vlen = vertexs.length;

        // 初始化顶点，复制拷贝的方式
        this.vertexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //初始化边, 使用的是复制拷贝的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];

                // 二维数组右三角部分统计边的条数
                if (j > i && this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    // 打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为：" );
        for (int[] temp : this.matrix) {
            System.out.println(Arrays.toString(temp));
        }
    }

    private void sortEdges(EData[] edges) {

    }
}

// 创建一个类EData，它的对象实例就表示一条边
class EData{
    char start; // 边的一个点
    char end;   // 边的另一个点
    int weight; // 边的权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}