/*
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        int length=matrix.length;
        for(int i=0;i<length/2;i++){
            int start=i;
            int end = length-1-i;
            for(int j=0;j<end-start;j++){//曾经没有想清楚这里为什么是<而不是<=，终于懂了。
                // 因为就算是六维矩阵，最外层只有20个元素，而不是二十四个。每行与列共用了四个角落的四个元素。
                int temp = matrix[start][start+j];
                matrix[start][start+j]=matrix[end-j][start];
                matrix[end-j][start]=matrix[end][end-j];
                matrix[end][end-j]=matrix[start+j][end];
                matrix[start+j][end]=temp;
            }
        }
    }
}
