package linked_list;

import java.util.Iterator;
import java.util.LinkedList;

public class MiddleElem {

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        System.out.println("findMiddle = " + findMiddle(integers));
    }

    public static  <T> T findMiddle(LinkedList<T> linkedList){
        Iterator<T> iterator1 = linkedList.iterator();
        Iterator<T> iterator2 = linkedList.iterator();
        T middle = null;
        while (iterator1.hasNext()){
            iterator1.next();
            middle = iterator2.next();
            if (iterator1.hasNext()) iterator1.next();
        }
        return middle;
    }
}
