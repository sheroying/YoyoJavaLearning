package com.yoyo.test.algorithmProblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//BFS 广度遍历，或者DFS 深度遍历
public class TwoLevelArrays {
    public static void main(String[] args) {
        int[][] aa = {{1, 2, 3, 1, 0},
                      {1, 7, 4, 0, 0},
                      {1, 1, 1, 0, 1},
                      {1, 1, 1, 0, 1},
                      {1, 1, 1, 0, 1}};

        int[][] bb = {{1, 2, 3},
                      {1, 7, 0},
                      {1, 1, 1}};

        Node resultNode = new Node(0, 0, 0,0, null, null);  // 存储最小路径的叶子节点信息

        List<Node> result = findShortestPath(aa, resultNode); // 存储所有路径的叶子节点信息，将所有的sum 值进行冒泡排序，最小路经和最大路径都可以找出来；
        System.out.println(result);
        System.out.println(resultNode);

    }

    //BFS 广度遍历，使用Queue 进行循环判断，对应树形结构进行遍历，常用与寻找最短路径，使用链表存储二维数组路经的节点信息（当前值，横，竖坐标，sum值，前后节点信息）
    public static List<Node> findShortestPath(int[][] arrays, Node resultNode) {
        List<Node> resultList = new ArrayList<>();
        int horizontalLength = arrays[0].length;
        int verticalLength = arrays.length;
        Queue<Node> queue = new ArrayDeque();
        Node node1 = new Node(1, 0, 0, 1, null, null);
        queue.add(node1);
        resultNode = node1;
        while (!queue.isEmpty()) { // 判断队列为空时，则退出循环
            Node polledNode = queue.poll();
            System.out.println("Current node " + polledNode.number + ", " + polledNode.indexX + ", " + polledNode.indexY);
            if (polledNode.indexX == verticalLength - 1 && polledNode.indexY == horizontalLength - 1) { // 当遍历到二维数组的最后一个元素时，存储最后一个节点信息
                resultList.add(polledNode);
                resultNode = resultNode.sum <= polledNode.sum ? resultNode : polledNode; // 比较最小的sum值，存储到result中
            }
            if (polledNode.indexX < verticalLength - 1) { // 当遍历到边界右节点时，存储节点信息
                Node nodeLeft = new Node(arrays[polledNode.indexX + 1][polledNode.indexY], polledNode.indexX + 1, polledNode.indexY, polledNode.sum + arrays[polledNode.indexX + 1][polledNode.indexY],
                        polledNode, null);
                System.out.println("Next left node " + nodeLeft.number + ", " + nodeLeft.indexX + ", " + nodeLeft.indexY);
                queue.add(nodeLeft);
                resultNode = polledNode.sum <= nodeLeft.sum ? polledNode : nodeLeft;
            }
            if (polledNode.indexY < horizontalLength - 1) {// 当遍历到边界底节点时，存储节点信息
                Node nodeRight = new Node(arrays[polledNode.indexX][polledNode.indexY + 1], polledNode.indexX, polledNode.indexY + 1, polledNode.sum + arrays[polledNode.indexX][polledNode.indexY + 1],
                        polledNode, null);
                System.out.println("Next right node " + nodeRight.number + ", " + nodeRight.indexX + ", " + nodeRight.indexY);
                queue.add(nodeRight);
                resultNode = resultNode.sum <= nodeRight.sum ? resultNode : nodeRight;
            }

        }
        return resultList;
    }


    static class Node {
        int number;
        int indexX;
        int indexY;
        int sum;
        Node preNode;
        Node NextNode;

        public Node(int number,
                    int indexX,
                    int indexY,
                    int sum,
                    Node preNode, Node nextNode) {
            this.number = number;
            this.indexX = indexX;
            this.indexY = indexY;
            this.sum = sum;
            this.preNode = preNode;
            this.NextNode = nextNode;

        }
    }

//    public static int moveAndReturnNumber(int[][] arrays, int a, int b){
//        int sum = arrays[0][0];
//        for(int i = 0; i < arrays.length + arrays[0].length -2; i++) {
//            System.out.println("loop " + i + " sum is "+ sum);
//            boolean isMovedRightEdge = b >= arrays[0].length - 1;
//            boolean isMovedBottomEdge = a >= arrays.length - 1;
//            if (isMovedRightEdge && !isMovedBottomEdge) {
//                a++;
//                sum += arrays[a][b];
//            } else if (isMovedBottomEdge && !isMovedRightEdge) {
//                b++;
//                sum += arrays[a][b];
//            } else if (arrays[a+1][b] <= arrays[a][b+1]) {
//                sum += arrays[a++][b];
//            } else if (arrays[a+1][b] > arrays[a][b+1]) {
//                sum += arrays[a][b++];
//            } else if(isMovedRightEdge && isMovedBottomEdge){
//                break;
//            }
//        }
//        System.out.println(sum);
//        return sum;
//    }
}

//    https://blog.csdn.net/cjxiaobaic/article/details/120307309

