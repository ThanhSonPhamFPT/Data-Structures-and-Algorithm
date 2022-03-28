import implementations.*;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      // testStack();
     //   testQueue();
        testSinglyLinklist();
    }
    public static void testArrayList(){
        ArrayList<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(3);

        System.out.println(myArrayList);
        myArrayList.add(2,8);
        myArrayList.set(4,10);
        System.out.println("After adding:");
        System.out.println(myArrayList);
        System.out.println("Index of 5 is "+ myArrayList.indexOf(10));
        System.out.println("Delete element  "+ myArrayList.remove(1) + " out of Arraylist");
        System.out.println("Delete element  "+ myArrayList.remove(1) + " out of Arraylist");
        System.out.println("Delete element  "+ myArrayList.remove(1) + " out of Arraylist");
        System.out.println("Delete element  "+ myArrayList.remove(1) + " out of Arraylist");
        System.out.println("Delete element  "+ myArrayList.remove(1) + " out of Arraylist");

        System.out.println(myArrayList);
        System.out.println("Capacity of the Arraylist "+ myArrayList.getCapacity());

        ArrayList<String> myStringArrayList = new ArrayList<>();
        myStringArrayList.add("Hello");
        myStringArrayList.add("Welcome");
        myStringArrayList.add("Goodbye");
        myStringArrayList.add("See you");
        myStringArrayList.add("International");
        myStringArrayList.add("Student");
        System.out.println(myStringArrayList);
        System.out.println("Index of 5 Welcome "+ myStringArrayList.indexOf("Welcome"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string you want to search:");
        String input=sc.next();
        System.out.println("Index of "+input+" is "+ myStringArrayList.indexOf(input));
        ArrayList<Student> myStudentList = new ArrayList<Student>();
        Student student2 = new Student(1, "Pham Thanh Son", 32, 7.0);
        Student student3 = new Student(4, "Tran Dinh Trung", 22, 10.0);
        GreatStudent student4 = new GreatStudent(1,"Nguyen Van B", 20, 10.0,"Boi loi");
        GreatStudent student5 = new GreatStudent(19,"Huynh Tan Hoa", 22, 10.0,"Toan");
        myStudentList.add(student2);
        myStudentList.add(student3);
        myStudentList.add(student4);
        myStudentList.add(student5);
        System.out.println(myStudentList);
        System.out.println("Index of Student with ID 4 is" + myStudentList.indexOf(new Student(4)));
        Iterator<Integer> myIntIterator = myArrayList.iterator();
        while(myIntIterator.hasNext()){
            System.out.println(myIntIterator.next());
        }
    }

    public static void testStack(){
        Stack2<Integer> myIntegerStack = new Stack2<>();
        myIntegerStack.push(3);
        myIntegerStack.push(4);
        myIntegerStack.push(7);
        myIntegerStack.push(5);
        System.out.println(myIntegerStack);
        System.out.println("Pop element from stack:");
        System.out.println(myIntegerStack.pop());
        System.out.println(myIntegerStack.pop());
        System.out.println("The stack after pop:");
        System.out.println(myIntegerStack);

        Iterator<Integer> myIntIterator = myIntegerStack.iterator();
        while(myIntIterator.hasNext()){
            System.out.println(myIntIterator.next());
        }
        Stack2<Student> myStudentStack = new Stack2<>();
        Student student2 = new Student(1, "Pham Thanh Son", 32, 7.0);
        Student student3 = new Student(4, "Tran Dinh Trung", 22, 10.0);
        GreatStudent student4 = new GreatStudent(1,"Nguyen Van B", 20, 10.0,"Boi loi");
        GreatStudent student5 = new GreatStudent(19,"Huynh Tan Hoa", 22, 10.0,"Toan");
        myStudentStack.push(student2);
        myStudentStack.push(student3);
        myStudentStack.push(student4);
        myStudentStack.push(student5);
        System.out.println(myStudentStack);
    }
    public static void testQueue(){
        Queue2<Integer> myIntegerQueue = new Queue2<>();
        myIntegerQueue.offer(3);
        myIntegerQueue.offer(4);
        myIntegerQueue.offer(6);
        myIntegerQueue.offer(10);
        System.out.println(myIntegerQueue);
        System.out.println("Take element "+myIntegerQueue.poll() +" out of queue");
        System.out.println("Take element "+myIntegerQueue.poll() +" out of queue");
        System.out.println("Take element "+myIntegerQueue.poll() +" out of queue");
        System.out.println(myIntegerQueue);
    }
    public static void testSinglyLinklist(){
        SinglyLinkedList<Integer> mySinglyLinkedList = new SinglyLinkedList<>();
        mySinglyLinkedList.addFirst(3);
        mySinglyLinkedList.addFirst(4);
        mySinglyLinkedList.addFirst(7);
        mySinglyLinkedList.addFirst(8);
        mySinglyLinkedList.addLast(34);
        mySinglyLinkedList.addLast(20);
        mySinglyLinkedList.addLast(30);
        System.out.println(mySinglyLinkedList);
        System.out.println("remove element "+mySinglyLinkedList.removeFirst() + " out of the list");
        System.out.println("remove element "+mySinglyLinkedList.removeFirst() + " out of the list");
        System.out.println("remove element "+mySinglyLinkedList.removeLast() + " out of the list");
        System.out.println(mySinglyLinkedList);
    }
}
