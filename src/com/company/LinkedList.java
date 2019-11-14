package com.company;

import java.lang.reflect.Array;
import java.util.*;


public class LinkedList<T> implements List<T> {

    private Node head;


    public class Node{
        T data;
        Node next;


        Node(T d){                      //constructor
            data = d;
            next = null;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    LinkedList() {
        head = null;                /// constructor
    }

    public boolean add(T data) {
        // Appends the specified element to the end of this list (optional operation).

        //create new node to add
        Node newNode = new Node(data);

        // case if head is null, then head becomes new node
        if(head == null ) {
            head = newNode;
        }
        /// find the last node in link
        else {
            Node last = head;  			// set value of node last to head
            while(last.next != null) {  // while the next value of last node is not null
                last = last.next;       // last becomes the next node until last.next value becomes null
            }
            last.next = newNode;       // if next value of last node is null , last node = new node
        }
        return true;
    }

    @Override
    public void add(int index,  T data) throws IndexOutOfBoundsException {

        //Inserts the specified element(Object arg1) at the specified position in this list (int arg0).
        // create new node
        Node newNode = new Node(data);
        newNode.data = data;
        newNode.next = null;
        Node currentNode = this.head;
        // if head is null and index is not 0 then return
        if(index > this.size() || index < 0){
            throw new IndexOutOfBoundsException();
        }
            //If Head is null and position is 0. Then insert new Node to the
            //Head and exit it.
        /*if (this.head == null) {
            this.head = newNode;   /// unnecessary ?!
            return;
        }*/
        // if head is not null and position is 0, head is set to new node, and new node next is set to head
        if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }
            // check for index = 1 case.
        if (index == 1) {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        int count = 0;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            count++;
            if (count == index - 1) {   // won't trigger if index is set to 1;
                newNode.next = currentNode.next; // set newNode next to the current node Next
                currentNode.next = newNode;  // set current node to new Node.
            }
        }
        
    }

    @Override
    public boolean addAll(Collection<? extends  T> collection) {

        for (Object element : collection) {
            add((T) element);
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        if(index > this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }


        int i = 0;                              // initiliaze int i
        int position = index - 1;                // set position variable to index - 1
        for(Object element : collection) {      // for each element in the collection
            i++;                                // increment i
            add(position + i, (T) element);   // add the element at position + value of i
        }
        return false;
    }

    @Override
    public void clear() {
        this.head = null;   // setting head to null will remove the ptr references to the next node

    }

    @Override
    public boolean contains(Object data) {
        for (Object element : this) {
            if (element.equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {


        for(Object element : collection) {

            if(!(this.contains(element))) {
                return false;
            }

        }
        return true;
    }

    @Override
    public T get(int index) {
        if(index >= size() || index < 0) {
          throw new IndexOutOfBoundsException();
        }

        if(head == null){
            System.out.println("List is empty");
        }
        Node currentNode = head;
        int count = 0;
        while(currentNode != null){
            count++;
            if(count - 1 == index){
                return currentNode.data;
            }
            else currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public int indexOf(Object data) {
        Node currentNode = head;
        int i = 0;

        while(currentNode != null) {
            i++;
            if(currentNode.data.equals(data)) {
                return i - 1;
            } else currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public Iterator<T> iterator() {

        class Iterator<T> implements java.util.Iterator{   // create new Iterator interface implementation

            private Node current;

            private Iterator(){
                current = head;                    //iterator constructor with head node
            }

            @Override
            public boolean hasNext() {
                return (current != null);    //return true if current node  is not null
            }

            @Override
            public T next() {
                if(hasNext()) {
                    T data = (T) current.data;    // assign current data to object data
                    current = current.next;         // set current node to next node
                    return data;                    // return data
                } else System.out.println("No Such Element Exception");
                return null;
            }
        }
        return new Iterator<T>();
    }

    @Override
    public int lastIndexOf(Object data) {

        Node currentNode = head;
        int index = 0;
        int found = - 1;
        while(currentNode != null  ) {
            if (currentNode.data.equals(data)) {
                found = index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return found;
    }

    @Override
    public ListIterator listIterator() {

        class ListIterator implements java.util.ListIterator {

            private Node current;
            private Node previous;         /// set current node

            private ListIterator() {
                current = head;
                previous = null;            /// define constructor with current node = head
            }

            @Override                       /// return true if current node has next
            public boolean hasNext() {
                return (current != null);
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    Object data = current.data;
                    previous = current;
                    current = current.next;
                    return data;
                }
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return hasNext() && previous != null;
            }

            @Override
            public Object previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Object o) {

            }

            @Override
            public void add(Object o) {

            }
        }


        return new ListIterator();

    }

    @Override
    public ListIterator listIterator(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object data) {
       /* Removes the first occurrence of the specified element from this list,
         * if it is present (optional operation).  If this list does not contain
         * the element, it is unchanged.  More formally, removes the element with
         * the lowest index */
        Node currentNode = this.head;
        Node previousNode = null;

        if(head.data.equals(data) && head.next == null) {  // check for size 1 and data equality and set to null
           head = null;
        }else
        if(head.data.equals(data) && head.next != null) {

            head = head.next;

        }

        while(currentNode.next != null) {  // iterate through nodes

                previousNode = currentNode;  // set previous node to instance of current node
                currentNode = currentNode.next; // advance to next node

                if(currentNode.data.equals(data)) {   // if current node data equals passed parameter
                    previousNode.next = currentNode.next; // previous node ptr is set to current node ptr.
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        Node currentNode = this.head;   // set currentNode
        Node previousNode = null;       // set previousNode
        int i = 0;

        if(index >= this.size() || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        /*if(currentNode == null) {
            System.out.println("Element not found"); Not needed?
        }*/
        // check for index 0
       if(index == 0) {
           if (currentNode != null) {
               this.head = currentNode.next;
           }
       }
        while(currentNode != null) {                   //iterate through the nodes
            previousNode = currentNode;                     // save current instance of node to previous node
            currentNode = currentNode.next;                 // move to next node
            i++;                                            // increment position
            if(i  == index ){                               // if position is equal to index
                previousNode.next = currentNode.next;       // set  previous node pointer to current node pointer
            }
        }
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if(head == null ){
            return false;
        }
        for(Object element : collection) {

            remove(element);

        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {

        Node currentNode = head;

        while(currentNode != null) {

            if(!(collection.contains(currentNode.data))) {
                this.remove(currentNode.data);
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public T set(int index, T data) {

        Node newNode = new Node(data);  // initialize new node with S data
        Node currentNode = head;            // set currentNode to head

        if( index > this.size() || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0 ) {
            head.data = newNode.data; // set head data to new node data if index provided is 0
        }
        int i = 0;
        while(currentNode != null) {                        //while current node is not null
            i++;                                            // increment i
            currentNode = currentNode.next;                 // move to next node
            if(i  == index ) {
                currentNode.data = newNode.data;            // set current node data to new node data
            }
        }
        return null;
    }

    @Override
    public int size() {
        Node nextNode = head;
        int count =0;
        while(nextNode != null) {
            count++;
            nextNode = nextNode.next;
        }
        return count;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {

    if(fromIndex < 0 || toIndex > this.size() || fromIndex > toIndex) {
        throw new IndexOutOfBoundsException();
    }

    LinkedList<T> subList = new LinkedList<>();

    for(int i = fromIndex; i <= toIndex; i++){
        subList.add(this.get(i));
    }

    return subList;
    }

    @Override
    public Object[] toArray() {


        Object[] array = new Object[this.size()];

        for(int i = 0; i < this.size(); i++) {

           array[i] = this.get(i);
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] array) {

       int size = this.size();

       if(array.length < size) {
           array = (T[]) Array.newInstance(array.getClass().getComponentType(), size);
       }
       else if (array.length > size) {
           array[size] = null;
       }
        for(int i = 0; i < this.size(); i++) {

            array[i] = (T) this.get(i);
        }

        return array;
    }

    public void printList() {
        Node currentNode = head;
        System.out.println("Linked list: ");
        while(currentNode != null) {
            System.out.println("Data is: " + currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void printListIterator() {

        for (Object o : this) {
            System.out.println(o);
        }
    }


    //git test modification //

    // test branch bugfix//
    // commit before merge //



}
