package sanlang;

/**
 * author:sanlang
 *
 * @Date: 2021/03/31/19:40
 * email:179874957@qq.com
 * github:SanLangLOVE
 * PS:Keep Coding
 * * @Description:
 * 设有n个独立的作业{1, 2, …, n}, 由m台相同的机器进行加工处理.
 * 作业i所需时间为t i. 约定:任何作业可以在任何一台机器上加工处理,
 * 但未完工前不允许中断处理,任何作业不能拆分成更小的子作业。
 * 要求给出一种作业调度方案，使所给的n 个作业在尽可能短的时间内由m台机器加工处理完成。
 *
 *  多机调度问题是一个NP完全问题，到目前为止还没有完全有效的解法。
 *  对于这类问题，用贪心选择策略有时可以设计出一个比较好的近似算法。
 *
 *  贪心算法求解思路
 *  采用最长处理时间作业优先的贪心策略:
 *  当n≤m时, 只要将机器i的[0, ti]时间区间分配给作业i即可。
 *  当n>m时, 将n个作业依其所需的处理时间从大到小排序,然后依次将作业分配给空闲的处理机。
 **/


import java.util.*;

public class GreedyDispatch {
    private static Integer workTime[]={35,20,16,15,13,5,2};
    private static int machineNumber=3;
    private static Integer min;
    private static Integer max;
    private static Integer minRunNumber;
    private static int getMin(List<Integer> list){
        min=list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)<min){
                min=list.get(i);
            }
        }
        return list.indexOf(min);
    }
    private static int getMax(List<Integer> list){

        max=list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (max<list.get(i)){
                max=list.get(i);
            }
        }
        return list.indexOf(max);
    }
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < workTime.length; i++) {
            list.add(workTime[i]);
        }

        List<Integer> listRun=new ArrayList<Integer>();
        for (int i = 0; i < machineNumber; i++) {
            listRun.add(list.get(i));
        }
        for (int i = 0; i < machineNumber; i++) {
            list.remove(0);
        }
        for (int i = 0; i < list.size(); i++) {
            minRunNumber=getMin(listRun);//返回最小值的下标
            listRun.set(minRunNumber,(list.get(i)+listRun.get(minRunNumber)));
        }
        System.out.println("最短的时间："+listRun.get(getMax(listRun)));

    }
}
