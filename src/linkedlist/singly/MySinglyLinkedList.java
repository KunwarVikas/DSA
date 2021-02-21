package linkedlist.singly;

public class MySinglyLinkedList {

    /**
     * Head of the LinkedList
     */
    public Node head;

    /**
     *  This is a method static class defining a LinkedList Node.
     *  since it is static, main() method  can access it
     */
    static class Node {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    /**
     * Insert a node to the given LinkedList
     * @param list - LinkedList
     * @param data - node data
     */
    public static void  insert(MySinglyLinkedList list, int data)
    {
        Node node = new Node(data);
        node.next = null;

        // If the LinkedList is empty, then make the new node as head.
        if (list.head == null) {
            list.head = node;
        }
        else {// else traverse the list till the last node and insert at the last.
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new node at last node
            last.next = node;
        }
    }

    /**
     * Delete a node by given data at the node.
     * @param list - LinkedList
     * @param data - node data
     */
    public void deleteByKey(MySinglyLinkedList list, int data)
    {
        System.out.println("trying to delete node with data:" + data);
        // Store head node
        Node currentNode = list.head;
        Node prev = null;

        if(currentNode!=null){
            if(currentNode.data==data){
                list.head = currentNode.next; // Changed head
                System.out.println("element " + data + " has been deleted");
            }else{
                while (currentNode != null && currentNode.data != data) {
                    prev = currentNode;
                    currentNode = currentNode.next;
                }
                if (currentNode != null) {
                    prev.next = currentNode.next;
                    System.out.println("element " + data  + " has been deleted");
                }else{
                    System.out.println("no node found with data:" + data);
                }
            }
        }
    }

    /**
     * Delete a node by given position.
     * @param list - LinkedList
     * @param pos - position of the node
     */
    public void deleteAtPosition(MySinglyLinkedList list, int pos)
    {
        System.out.println("trying to delete node at position:"+ pos);

        Node currentNode = list.head;
        Node prev = null;
        int counter = 0;

        if(currentNode!=null){
            if(pos==0){
                list.head = currentNode.next;
                System.out.println("element at position" + pos + " has been deleted");
            }else{
                // Count for the pos to be deleted, keep track of the previous node as it is needed to change currentNode.next
                while (currentNode != null) {
                    if (counter == pos) {
                        prev.next = currentNode.next;
                        System.out.println("element at " + pos + " has been deleted");
                        break;
                    } else {
                        prev = currentNode;
                        currentNode = currentNode.next;
                        counter++;
                    }
                }
            }
        }
        if(pos>counter){
            System.out.println("no node found at position:"+ pos + " ,as it greater than the size of the list");
        }

    }

    /**
     * Recursive Searching
     * find a node with given data in the LinkedList
     * @param head - head node
     * @param data - node data
     * @return - boolean value (true/false)
     */
    public boolean search(Node head, int data)
    {
        if (head == null)
            return false;
        if (head.data == data)
            return true;
        return search(head.next, data);
    }


    /**
     * Traverse and print the list
     * @param list
     */
    public void traverseAndPrintList(MySinglyLinkedList list)
    {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    /**
     *
     * @param list
     * @return the size of the list
     */
    public int size(MySinglyLinkedList list){
        int count=0;
        Node currNode = list.head;
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }

    /**
     * Main methoid to test the functionality.
     * @param args
     */
    public static void main(String[] args)
    {
//        MySinglyLinkedList list = new MySinglyLinkedList();
//        //insertion
//        insert(list, 1);
//        insert(list, 2);
//        insert(list, 3);
//        insert(list, 4);
//        insert(list, 5);
//        insert(list, 6);
//        insert(list, 7);
//        insert(list, 8);
//        insert(list, 9);
//        insert(list, 10);
//        insert(list, 11);
//        insert(list, 12);
//        insert(list, 13);
//        insert(list, 14);
//        insert(list, 15);
//        insert(list, 16);
//
//        //size of the list
//        System.out.println("size of the list at the beginning: " + size(list));
//
//        //delete by key
//        traverseAndPrintList(list);
//        deleteByKey(list, 1);
//
//        traverseAndPrintList(list);
//        deleteByKey(list, 4);
//
//        traverseAndPrintList(list);
//        deleteByKey(list, 10);
//
//        traverseAndPrintList(list);
//        deleteByKey(list, 17);
//
//        traverseAndPrintList(list);
//
//        //delete by position
//        deleteAtPosition(list, 0);
//        traverseAndPrintList(list);
//
//        deleteAtPosition(list, 2);
//        traverseAndPrintList(list);
//
//        deleteAtPosition(list, 10);
//        traverseAndPrintList(list);
//
//        deleteAtPosition(list, 18);
//        traverseAndPrintList(list);
//
//        //search
//        System.out.println("searching for element with data 13");
//        if (list.search(list.head, 13))
//            System.out.println("Yes, given data is present in the list");
//        else
//            System.out.println("No, given data is not present in the list");
//        traverseAndPrintList(list);
//
//        //size of the list
//        System.out.println("size of the list at the end: " + size(list));

    }
}
