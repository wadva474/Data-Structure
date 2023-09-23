package linkedlist;

import java.util.HashMap;

public class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    public Node headNode; //head node of the linked list
    public int size;      //size of the linked list

    //Constructor - initializes headNode and size
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    //Helper Function that checks if List is empty or not
    public boolean isEmpty() {
        return headNode == null;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }


    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node temp = headNode;
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = newNode;
        size++;
    }


    public void deleteAtHead() {
        //if list is empty then simply return
        if (isEmpty())
            return;
        //make the nextNode of the headNode equal to new headNode
        headNode = headNode.nextNode;
        size--;
    }


    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node currentNode = this.headNode;
        Node prevNode = null; //previous node starts from null

        if (currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)) {
                prevNode.nextNode = currentNode.nextNode;
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        // Write -- Your -- Code
        SinglyLinkedList<T>.Node currentNode = list.headNode;
        int count = 0 ;
        while(currentNode != null){
            count ++;
            currentNode = currentNode.nextNode;
        }

        int midPoint = count/2 ;
        currentNode = list.headNode;
        for(int i = 0; i<midPoint;i++){
            currentNode = currentNode.nextNode;
        }
        return currentNode.data;
    }


    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node current = list.headNode; // will be used for outer loop
        SinglyLinkedList<T>.Node compare = null;     // will be used for inner loop

        while (current != null && current.nextNode != null) {
            compare = current;
            while (compare.nextNode != null) {
                if (current.data.equals(compare.nextNode.data)) { //check if duplicate
                    compare.nextNode = compare.nextNode.nextNode;
                } else {
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }
}


