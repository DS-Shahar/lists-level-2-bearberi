package com.shaharyi.node;

public class Main {

    public static IntNode mergeLists(IntNode list1, IntNode list2) {
        IntNode mergedList = null;
        IntNode tail = null;

        while (list1 != null && list2 != null) {
            IntNode newNode;
            if (list1.getValue() <= list2.getValue()) {
                newNode = new IntNode(list1.getValue());
                list1 = list1.getNext();
            } else {
                newNode = new IntNode(list2.getValue());
                list2 = list2.getNext();
            }
            if (mergedList == null) {
                mergedList = newNode;
                tail = mergedList;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }

        while (list1 != null) {
            IntNode newNode = new IntNode(list1.getValue());
            tail.setNext(newNode);
            tail = newNode;
            list1 = list1.getNext();
        }

        while (list2 != null) {
            IntNode newNode = new IntNode(list2.getValue());
            tail.setNext(newNode);
            tail = newNode;
            list2 = list2.getNext();
        }

        return mergedList;
    }

    public static IntNode selectionSort(IntNode list) {
        if (list == null) return null;

        IntNode sortedList = null;
        while (list != null) {
            IntNode minNode = list;
            IntNode current = list.getNext();

            while (current != null) {
                if (current.getValue() < minNode.getValue()) {
                    minNode = current;
                }
                current = current.getNext();
            }

            IntNode prev = null;
            current = list;
            while (current != minNode) {
                prev = current;
                current = current.getNext();
            }

            if (prev != null) prev.setNext(current.getNext();
            else list = current.getNext();

            current.setNext(null);
            if (sortedList == null) {
                sortedList = current;
            } else {
                IntNode temp = sortedList;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(current);
            }
        }

        return sortedList;
    }

    public static int calculateDistance(IntNode list, int value) {
        int firstIndex = -1, lastIndex = -1;
        int index = 0;

        while (list != null) {
            if (list.getValue() == value) {
                if (firstIndex == -1) firstIndex = index;
                lastIndex = index;
            }
            list = list.getNext();
            index++;
        }

        if (firstIndex == -1) return -1;

        return firstIndex + (lastIndex - firstIndex);
    }

    public static boolean areAllElementsUnique(IntNode list) {
        IntNode outer = list;
        while (outer != null) {
            IntNode inner = outer.getNext();
            while (inner != null) {
                if (outer.getValue() == inner.getValue()) {
                    return false;
                }
                inner = inner.getNext();
            }
            outer = outer.getNext();
        }
        return true;
    }

    public static void main(String[] args) {
        IntNode list1 = new IntNode(1, new IntNode(3, new IntNode(5)));
        IntNode list2 = new IntNode(2, new IntNode(4, new IntNode(6)));

        IntNode mergedList = mergeLists(list1, list2);
        System.out.println("רשימה ממוינת אחרי מיזוג: " + mergedList);

        IntNode unsortedList = new IntNode(5, new IntNode(2, new IntNode(9, new IntNode(1))));
        IntNode sortedList = selectionSort(unsortedList);
        System.out.println("רשימה אחרי מיון: " + sortedList);

        IntNode list3 = new IntNode(5, new IntNode(8, new IntNode(3, new IntNode(8, new IntNode(2, new IntNode(9))))));
        int distanceSum = calculateDistance(list3, 8);
        System.out.println("סכום המרחקים עבור 8: " + distanceSum);

        IntNode list4 = new IntNode(1, new IntNode(2, new IntNode(3)));
        boolean unique = areAllElementsUnique(list4);
        System.out.println("האם כל האיברים שונים? " + unique);
    }
}



















תרגיל בודק כפילויות:

package targil;

public class Main {
    public static void main(String[] args) {
        Node<Integer> p = new Node<>(1);
        p.next = new Node<>(2);
        p.next.next = new Node<>(3);
        p.next.next.next = new Node<>(2);

        boolean result = RepetNum(p);
        System.out.println("האם יש איברים שחוזרים על עצמם? " + result);
    }

    public static boolean RepetNum(Node<Integer> p) {
        for (Node<Integer> i = p; i != null; i = i.next) {
            for (Node<Integer> j = p; j != i; j = j.next) {
                if (i.value.equals(j.value)) {
                    return true;
                }
            }
        }
        return false;
    }
}
