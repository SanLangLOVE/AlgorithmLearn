package sanlang;

/**
 * author:sanlang
 * time:2021 3 26
 * @Description:最佳装载
 * 有一批集装箱要装上一艘载重量为c的轮船。
 * 其中集装箱i的重量为Wi。
 * 最优装载问题要求确定在装载体积不受限制的情况下，
 * 将尽可能多的集装箱装上轮船
 * email:179874957@qq.com
 * github:SanLangLOVE
 * PS:Keep Coding
 **/
import java.util.Arrays;
import java.util.Scanner;
public class TheBestCarry {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int c;
        System.out.println("请输入轮船的容量c：");
        c=sc.nextInt();
        System.out.println("请输入集装箱的数量n:");
        int tmp=0;
        //tmp为已经装载到船上的集装箱重量
        int count=0;
        //已经已经装载的数量
        int n=sc.nextInt();
        int  []w=new int[n];
        int []ans=new int[n];
        //ans为已经装上的集装箱
        System.out.println("请输入每个集装箱的重量：");
        for (int i=0;i<n;i++){
            w[i]=sc.nextInt();
        }
        Arrays.sort(w);
        //将数组从小到大排序，使后面的重量越来越大，当前面的某一个不能满足时，后面的也无法满足，方便退出循环。
        for (int  i=0;i<n;i++){
            tmp+=w[i];
            if(tmp<=c){
                ans[i]=w[i];
                count++;
            }
            else {
                break;
            }

        }
        System.out.println("装入的集装箱的重量为：");
        for (int i=0;i<count;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
