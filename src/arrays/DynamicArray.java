package arrays;

import java.util.Arrays;

public class DynamicArray {
    private int array[];
    private int size;
    private int capacity;

    /**
     * Constructor with initial capacity
     */
    public DynamicArray(){
        array = new int[2];
        size=0;
        capacity=2;
    }

    /**
     * check for capacity and if there is capacity add the element at the end of the array.
     * @param element
     */
    public void addElement(int element){
        if (size == capacity){
            increaseCapacity(2);
        }
        array[size++] = element;
    }

    /**
     * Adding element at a given index
     * @param index
     * @param element
     */
    public void addElement(int index, int element){
        // double the capacity if all the allocated space is utilized
        if (size == capacity){
            increaseCapacity(2);
        }
        // shift all elements from the given index to right
        for(int i=size-1;i>=index;i--){
            array[i+1] = array[i];
        }
        // insert the element at the specified index
        array[index] = element;
        size++;
    }

    /**
     * get an element from given index
     * @param index
     * @return
     */
    public int getElement(int index){
        return array[index];
    }

    /**
     * Remove an element from given index
     * @param index
     */
    public void remove(int index){
        if(index>=size || index<0){
            System.out.println("No element at this index");
        }else{
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=0;
            size--;
        }
    }

    /**
     * If there is no place
     * @param minCapacity
     */
    public void increaseCapacity(int minCapacity){
        int tempArray[] = new int[capacity*2];
        for (int i=0; i < capacity; i++){
            tempArray[i] = array[i];
        }
        array = tempArray;
        capacity = capacity * 2;
    }

    /*
     *  Trim the capacity of dynamic array to the current size. i.e. remove unused space
     */
    public void trimToSize(){
        System.out.println("Trimming the array");
        int tempArray[] = new int[size];
        for (int i=0; i < size; i++){
            tempArray[i] = array[i];
        }
        array = tempArray;
        capacity = array.length;

    }

    public int getSize(){
        return this.size;
    }

    public int getCapacity(){
        return this.capacity;
    }

    /**
     * Print the array elements
     */
    public void printElements(){
        System.out.println("elements in array are :"+ Arrays.toString(array));
    }


    public static void main(String args[]){
        DynamicArray array = new DynamicArray();
        // adding elements at index 0 and 1
        array.addElement(1);
        array.addElement(2);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());

        array.addElement(3);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();

        // add element at index 1
        array.addElement(1,5);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();

        // add element at index 2
        array.addElement(2,6);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();

        array.remove(2);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();

        array.remove(2);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();

        array.remove(1);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();

        array.remove(2);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();
        array.remove(1);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();

        // Trim the array
        array.trimToSize();
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();
        array.addElement(2);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();
        array.addElement(3);
        System.out.println("Size :"+array.getSize()+
                " and Capacity :"+array.getCapacity());
        array.printElements();
    }
}
