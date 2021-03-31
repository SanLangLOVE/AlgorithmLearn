package sanlang;

/**
 * author:sanlang
 * time:2021.3.22
 * @Description:
 * 给定n种物品和一个背包。物品i的重量是Wi，
 * 其价值为Vi，背包的容量为C。应如何选择装入背包的物品，
 * 可以选择物品i的一部分,使得装入背包中物品的总价值最大?
 * email:179874957@qq.com
 * github:SanLangLOVE
 * PS:Keep Coding
 **/
import java.util.Scanner;
class Object{
    float v;
    float w;
    float x;
    float index;
}
/**
 * @author sanlang
 */
public class PacketCarry {
    private static Scanner scanner;
    static float Knapsack(int n,float M, Object p[])
    {
        int i=0;
        float value=0;
        while(p[i].w<M){
            value=value+p[i].v;
            M=M-p[i].w;
            i++;
        }
        float m=(float)M/p[i].w;
        value=value+p[i].v*m;
        return value;
    }
    private static void Sort(int n, Object p[]) {
        float t;
        for(int i=1;i<n;i++) {
            for(int j=n-1;j>=i;j--){
                if(p[j-1].x<p[j].x){
                    t=p[j].index;
                    p[j].index=p[j-1].index;
                    p[j-1].index=t;
                    t=p[j].w;
                    p[j].w=p[j-1].w;
                    p[j-1].w=t;
                    t=p[j].v;
                    p[j].v=p[j-1].v;
                    p[j-1].v=t;
                    t=p[j].x;
                    p[j].x=p[j-1].x;
                    p[j-1].x=t;
                }
            }
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("请输入物品个数：");
        int n=scanner.nextInt();
        Object []p=new Object[n];
        System.out.print("请输入物品的序号、重量、价值：");
        for(int i=0;i<n;i++){
            p[i]=new Object();
            p[i].index=scanner.nextInt();
            p[i].w=scanner.nextInt();
            p[i].v=scanner.nextInt();
            p[i].x=p[i].v/p[i].w;
        }
        Sort(n,p);;
        System.out.println("各商品的序号、重量、价值、单位价值排序后如下：");
        for(int i=0;i<n;i++){
            System.out.println(p[i].index+"  "+p[i].w+"  "+p[i].v+"  "+p[i].x);
        }
        System.out.print("请输入背包最大容量：");
        int M=scanner.nextInt();
        System.out.println( "背包中才放入物品最大总价值为："+Knapsack(n,M,p));
    }
}
