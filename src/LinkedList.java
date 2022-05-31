public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {

    }

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    void insert(int info) {
        Node temp = new Node();
        temp.setData(info);
        if(head == null) {
            head = tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
    }

    void delete() {
        Node temp = head;
        if(head == tail) {
            head = tail = null;
        }
        else {
            while(temp.getNext() != tail) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            tail = temp;
        }
    }

    String display() {
        Node temp = head;
        String tempo = " ";

        while(temp != null) {
            tempo = tempo + " " + temp.getData();
            temp = temp.getNext();
        }
        return tempo;
    }


}
