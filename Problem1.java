package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Problem1 {

    public static void main(String[] args) {
        List<String> L = new ArrayList<String>();
        L.add("4");
        L.add("artist");
        L.add("engineer");
        L.add("beekeeper");
        L.add("programmer");
        L.add("3");
        L.add("bookkatt");
        L.add("jailaikia");
        L.add("yeehaaw");
        L.add("0");

        List<String> L2=prb1_1(L);


        System.out.println("******");
        for(String s1:L2) {
            System.out.println(s1);
        }
    }
    public static List<String> prb1_1(List<String> L2){
        int cas;
        int cpt_old=0;
        int cpt_new=0;
        String returned_mot = null;
        ListIterator<String> LIterator = L2.listIterator();
        List<String> L = new ArrayList<String>();
        while(LIterator.hasNext()) {
            String data = LIterator.next();
            cas=Integer.parseInt(data);
            if(cas==0)break;
            for(int i=0;i<cas;i++) {
                String mot=LIterator.next();
                for (int j = 0; j < mot.length()-1; j++){
                    char c=mot.charAt(i);
                    if(is_voyel(c)==1 && c== mot.charAt(j+1)) {
                        cpt_new++;
                    }
                }
                if(cpt_new>=cpt_old) {
                    returned_mot=mot;
                    cpt_old=cpt_new;
                    cpt_new=0;
                }
            }
            L.add(returned_mot);
        }
        return L;
    }

    public static int is_voyel(char a) {
        if(a=='a'||a=='i'||a=='e'||a=='u'||a=='o'||a=='y')
            return 1;
        return 0;

    }

}

