package linkedlist;

import java.util.HashSet;

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
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.nextNode;
        }

        int midPoint = count / 2;
        currentNode = list.headNode;
        for (int i = 0; i < midPoint; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode.data;
    }


    public void removeDuplicatesWithHashing() {
        Node current = this.headNode;
        Node prevNode = this.headNode;
        //will store all the elements that we observe once
        HashSet<T> visitedNodes = new HashSet<T>();

        if (!isEmpty() && current.nextNode != null) {
            while (current != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(current.data)) {
                    //deleting the node by undating the pointer of previous node
                    prevNode.nextNode = current.nextNode;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add(current.data);
                    //moving on to next element in the list
                    prevNode = current;
                }
                current = current.nextNode;
            }
        }
    }

    //Union and Intersection
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> union = new SinglyLinkedList<>();
        SinglyLinkedList<T>.Node headNodeOne = list1.headNode;
        SinglyLinkedList<T>.Node headNodeTwo = list2.headNode;

        while (!list1.isEmpty() && headNodeOne != null) {
            union.insertAtEnd(headNodeOne.data);
            headNodeOne = headNodeOne.nextNode;
        }

        while (!list2.isEmpty() && headNodeTwo != null) {
            union.insertAtEnd(headNodeTwo.data);
            headNodeTwo = headNodeTwo.nextNode;
        }

        union.removeDuplicatesWithHashing();
        return union;
    }

    public static <T> boolean contains(SinglyLinkedList<T> list, T data) {
        SinglyLinkedList<T>.Node current = list.headNode;
        //traverses the whole list
        while (current != null) {
            //returns true if found
            if (current.data.equals(data))
                return true;
            current = current.nextNode;
        }
        //returns false if not found
        return false;
    }

    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        //returns empty list if either one of the lists is empty
        if (list1.isEmpty() || list2.isEmpty())
            return result;

        SinglyLinkedList<T>.Node current = list1.headNode;
        //traverses list1 and checks if each element is present in list2
        while (current != null) {
            if (contains(list2, current.data)) {
                //inserts in result if it is present in both
                result.insertAtHead(current.data);
            }
            current = current.nextNode;
        }

        return result;
    }

    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        SinglyLinkedList<T>.Node head = list.headNode;
        int count = 0;
        int positionFromFront;
        if(list.isEmpty()) {
            return null;
        }
        while(head != null){
            count ++;
            head = head.nextNode;
        }

        if(n > count){
            return null;
        }

        positionFromFront = count - n;
        head = list.headNode;
        for(int i = 1; i <= positionFromFront; i++){
            head = head.nextNode;
        }
        return head.data;
    }


}


