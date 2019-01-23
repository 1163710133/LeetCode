import java.util.ArrayList;
import java.util.List;

/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result= new ArrayList<>();
        int row_number,column_number;
        row_number = matrix.length;
        column_number= matrix[0].length;
        for(int i =0,j=0;i<(row_number+1)/2&&j<(column_number+1)/2;i++,j++){
            for(int h=i;h<column_number;h++){
                result.add(matrix[i][h]);
            }
            for(int h= i;h<row_number-i;h++){
                result.add(matrix[column_number-j-1][h]);
            }
            for(int h=column_number-i-1;h>i;h--){
                result.add(matrix[row_number-i-1][h]);
            }
            for(int h= row_number-i-1;h>i;h--) {
                result.add(matrix[i][row_number - i - 1]);
            }
        }
        return result;
    }
}
