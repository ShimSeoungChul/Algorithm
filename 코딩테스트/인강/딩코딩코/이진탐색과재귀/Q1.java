package 인강.딩코딩코.이진탐색과재귀;

public class Q1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(6);
        linkedList.append(7);
        linkedList.append(8);

        System.out.println(linkedList.getKthNodeFromLast(2).data);

    }
}

class Node {
    int data;
    Node next;

    // Node 생성자
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // LinkedList 생성자
    public LinkedList(int value) {
        this.head = new Node(value);
    }

    // 리스트에 값 추가
    public void append(int value) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    public Node getKthNodeFromLast(int k) {
        int size = size();

        int index = 0;
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            index += 1;

            if (size - 2 == index) break;
        }

        return cur;
    }

    private int size() {
        int size = 1;
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            size += 1;
        }

        return size;
    }
}
