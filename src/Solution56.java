/*
给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//Definition for an interval.
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution56 {
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> result = new LinkedList<>();
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        for(Interval temp : intervals) {
            if(result.isEmpty() || result.peekLast().end < temp.start)
                result.add(temp);
            else
                result.peekLast().end = Math.max(result.peekLast().end, temp.end);
        }
        return result;
    }
}
