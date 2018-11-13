package lesson11;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TaskDunno {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<10; i++){
            set.add(i+5);
        }

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            if (iterator.next()>10) iterator.remove();
            }
        System.out.println(set);
        }

    }
