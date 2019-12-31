package com.company;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Problem2 {
    public static void main(String[] args) {
        int a=1,b=4,a1=1,b1=4;
        int a11=1, b11=6, a12=1,b12=6;
        List<Integer> G=new ArrayList<Integer>();
        G.add(a);
        G.add(b);
        G.add(a1);
        G.add(b1);
        List<Integer> E=new ArrayList<Integer>();
        E.add(a11);
        E.add(b11);
        E.add(a12);
        E.add(b12);
        System.out.println(prb2(G,E));

    }

    public static String prb2(List<Integer> G,List<Integer> E) {
        double EsperenceG=esperance(G.get(0), G.get(1))+esperance(G.get(2), G.get(3));
        double EsperenceE=esperance(E.get(0), E.get(1))+esperance(E.get(2), E.get(3));
        double VarianceG= variance(G.get(0), G.get(1))+variance(G.get(2), G.get(3));
        double VarianceE=variance(E.get(0), E.get(1))+variance(E.get(2), E.get(3));
        double Esp=EsperenceG-EsperenceE;
        double Var=VarianceE+VarianceG;
        return Compare(Esp,Var);
    }

    public static double esperance(int a, int b) {
        int x=b-a+1;
        double p=(double)1/x;
        double sum = 0;
        for (int i = a; i <= b; i++)
            sum += i*p;

        return sum;
    }

    public static double variance(int a, int b) {
        double var = 0;
        int x=b-a+1;
        double average=esperance(a, b);
        for (int i = a; i <= b; i++)
        {
            var += Math.pow((i - average),2) / x;
        }
        return var;
    }

    public static double normale (double x,double v, double E) {
        double A=Math.exp(-1*0.5*Math.pow(((x-E)/Math.sqrt(v)),2));
        double B=A/(Math.sqrt(v)*Math.sqrt(2*Math.PI));
        return B;
    }

    public static String Compare(double E ,double V) {
        double max=-1;
        int k=0;
        List<Integer> L = new ArrayList<Integer>();
        double verif_finale=0;
        for (int i = -200; i <=200; i++) {
            double A=normale(i, V, E);
            if(A>max) {
                max=A;
            }
        }
        for (int i = -200; i <=200; i++) {
            double A=normale(i,V,E);
            if(A==max) {
                L.add(i);
            }
        }
        for(double a:L) {
            verif_finale+=a;
            k++;
        }
        verif_finale=verif_finale/k;
        if(verif_finale==0) return "Tie";
        if(verif_finale<0) return "Emma";
        return "Gunnar";

    }
}