package linked_list;

import java.util.Iterator;
import java.util.LinkedList;

public class GetFromLast {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("getFromLast(linkedList, 2) = " + getFromLast(linkedList, 2));
        System.out.println("getFromLast(linkedList, 2) = " + getFromLast(linkedList, 3));
    }

    private static Integer getFromLast(LinkedList<Integer> list, int indexFromLast){
        Iterator<Integer> iterator1 = list.iterator();
        Iterator<Integer> iterator2 = list.iterator();
        int pointer = 0;
        while (iterator1.hasNext()){
            iterator1.next();
            pointer++;
            if (pointer > indexFromLast){
                iterator2.next();
            }
        }
        return iterator2.next();
    }
}
