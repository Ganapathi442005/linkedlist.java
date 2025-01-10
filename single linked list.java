import java.nio.channels.Pipe.SourceChannel;
import java.util.*;

import javax.sound.sampled.SourceDataLine;
class Node{
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
}



public class Main {
    public static void display(Node headNode)
    {
        if(headNode == null)
        {
            System.out.println("null");
        }
        else
        {
            // Node temp = heaNode;
            // while(temp!=null)
            // {
            //     System.out.print(temp.data+"->");
            //     temp = temp.next;
            // }
            // System.out.print("null");
            System.out.print(headNode.data+"->");
            display(headNode.next);
        }
    }
    public static Node insertionBegin(Node headNode,int data)
    {
        Node temp = new Node(data);
        if(headNode==null)
        {
            headNode = temp;
        }
        else
        {
            temp.next = headNode;
            headNode = temp;
        }
        return headNode;
    }
    public static Node insertionEnd(Node headNode,int data)
    {
        Node temp = new Node(data);
        if(headNode==null)
        {
            headNode = temp;
        }
        else
        {
            Node temp1 = headNode;
            while(temp1.next != null)
            {
                temp1 = temp1.next;
            }
            temp1.next = temp;
        }
        return headNode;
    }
    public static Node insertionSpecificPos(Node headNode,int data,int pos)
    {
        Node temp = new Node(data);
        if(headNode==null)
        {
            headNode = temp;
        }
        if(pos == 1)
        {
            headNode = insertionBegin(headNode, data);
            return headNode;
        }
        int count = 1;
        Node temp1 = headNode;
        while(temp1.next != null)
        {
            count++;
            if(count == pos)
            {
                Node temp2 = temp1.next;
                temp1.next = temp;
                temp.next = temp2;
                break;
            }
            temp1 = temp1.next;
        }
        if(temp1.next == null)
        {
            temp1.next = temp;
        }
        return headNode;
    }
    public static Node insertionMiddle(Node head,int data)
    {
        Node temp = new Node(data);
        if(head==null)
        {
            System.out.println("There no elements in the List");
        }
        else
        {
            int count = 0;
            Node temp1 = head;
            while(temp1.next!=null)
            {
                count++;
                temp1 = temp1.next;
            }
            int pos = 0;
            count = count/2;
            temp1 = head;
            while(temp1.next!=null)
            {
                if(pos==count)
                {
                    temp.next = temp1.next;
                    temp1.next = temp;
                    break;
                }
                pos++;
                temp1 = temp1.next;
            }
        }
        return head;
    }
    public static Node reverseList(Node head)
    {
        if(head==null)
        {
            System.out.println("There are No elements in the list");
        }
        else{
            Node temp = null;
            Node temp1 = head;
            Node temp2 = null;
            while(temp1!=null)
            {
                temp2 = temp1.next;
                temp1.next = temp;
                temp = temp1;
                temp1 = temp2;
            }
            head = temp;
        }
        return head;
    }
    public static Node deleteByValue(Node head,int data)
    {
        if(head==null)
        {
            System.out.println("There are No elements in the list");
        }
        else
        {
            Node temp = head;
            while(temp.next!=null)
            {
                
                if(temp.next.data == data)
                {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
            if(temp.data == data)
            {
                head = deleteLast(head);
            }
            else
            {
                System.out.println("The Element is not found in the");
            }
        }
        return head;
    }
    public static Node deleteSpecificPos(Node head,int pos)
    {
        if(head == null)
        {
            System.out.println("There is no elements in the list");
        }
        else if(pos==1)
        {
            head = deleteFirst(head);
            return head;
        }
        else
        {
            int count = 1;
            Node temp = head;
            temp = head;
            while(temp.next!=null)
            {
                count++;
                if(count == pos)
                {
                    System.out.println("The Element Deleted is : "+temp.next.data);
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
            if(temp.next==null && count==pos)
            {
                head = deleteLast(head);
            }
            else{
                System.out.println("Index Out Of Bounce!!!Enter Within the Size");
            }
        }
        return head;
    }
    public static Node deleteFirst(Node head)
    {
        if(head == null)
        {
            System.out.println("There is no elements in the Linked List");
        }
        else{
            System.out.println("The Element Deleted is : "+head.data);
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        return head;
    }
    public static Node deleteLast(Node head)
    {
        if(head == null)
        {
            System.out.println("There is no elements in the Linked List");
        }
        else if(head.next == null)
        {
            System.out.println("The Element Deleted is : "+head.data);
            head = head.next;
        }
        else
        {
            Node temp1 = null;
            Node temp = head;
            while(temp.next != null)
            {
                temp1 = temp;
                temp = temp.next;
            }
            System.out.println("The Element Deleted is : "+temp.data);
            temp1.next = null;
        }
        return head;
    }
    public static boolean elementSearch(Node head,int num)
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.data == num)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("==================================LINKED LIST OPERATION===============================");
        while(true)
        {
            System.out.println();
            System.out.println();
            System.out.println("---------Menu of Operation in the linked list---------------");
            System.out.println("1 -> Inserting an element");
            System.out.println("2 -> Deleting an element");
            System.out.println("3 -> Reverse of the Linked List");
            System.out.println("4 -> Display the Elements in the Linked List");
            System.out.println("5 -> Search a particular number");
            System.out.println("6 -> Exit");
            System.out.print("Enter your choice from the above Menu : ");
            int choice = sc.nextInt();
            if(choice == 1)
            {
                System.out.println("+++++++++++++Menu of Operation in the Insertion of Linked List++++++++++++");
                System.out.println("1 -> Insert Element Continuously");
                System.out.println("2 -> Insert Element at the Begin");
                System.out.println("3 -> Insert Element at the End");
                System.out.println("4 -> Insert Element at middle");
                System.out.println("5 -> Insert Element at the Specific Position");
                System.out.print("Enter your choice from the above Insertion Menu : ");
                int insert = sc.nextInt();
                if(insert == 1)
                {
                    System.out.print("Enter the Number of Elements you need to insert : ");
                    int n = sc.nextInt();
                    for(int i=0;i<n;i++)
                    {
                        System.out.print("Enter the Element : ");
                        int num = sc.nextInt();
                        head = insertionEnd(head,num);
                        System.out.println("Element added : "+num);
                    }
                }
                else if(insert == 2)
                {
                    System.out.print("Enter the Element to Insert at the begining : ");
                    int num = sc.nextInt();
                    head = insertionBegin(head, num);
                    System.out.println("Element added : "+num);
                }
                else if(insert == 3)
                {
                    System.out.print("Enter the Element to Insert at the End : ");
                    int num = sc.nextInt();
                    head = insertionEnd(head, num);
                    System.out.println("Element added : "+num);
                }
                else if(insert == 4)
                {
                    System.out.print("Enter the Element to Insert at the Middle : ");
                    int num = sc.nextInt();
                    head = insertionMiddle(head, num);
                    System.out.println("Element added : "+num);
                }
                else if(insert == 5)
                {
                    System.out.print("Enter the Element to Insert at the Specific Position : ");
                    int num = sc.nextInt();
                    System.out.print("Enter the position to insert : ");
                    int pos = sc.nextInt();
                    head = insertionSpecificPos(head, num, pos);
                    System.out.println("Element added : "+num);
                }
            }
            else if(choice == 2)
            {
                System.out.println("+++++++++++++Menu of Operation in the Deletion of Elements in Linked List++++++++++++");
                System.out.println("1 -> Delete Element at the Begin");
                System.out.println("2 -> Delete Element at the End");
                System.out.println("3 -> Delete Element by the value");
                System.out.println("4 -> Delete at the Specific pos");
                System.out.print("Enter your choice from the above Deletion Menu : ");
                int del = sc.nextInt();
                if(del == 1)
                {
                    head = deleteFirst(head);
                }
                else if(del == 2)
                {
                    head = deleteLast(head);
                }
                else if(del == 3)
                {
                    System.out.print("Enter the value to Delete : ");
                    int num = sc.nextInt();
                    head = deleteByValue(head,num );
                    System.out.println("The Element Deleted is : "+num);
                }
                else if(del == 4)
                {
                    System.out.print("Enter the position to Delete : ");
                    int pos = sc.nextInt();
                    head = deleteSpecificPos(head, pos);
                }
            }
            else if(choice == 3)
            {
                System.out.print("The Linked list After the Reversing is : ");
                head = reverseList(head);
                display(head);
            }
            else if(choice == 4)
            {
                System.out.print("The Elements in the Linked List is : ");
                display(head);
            }
            else if(choice == 5)
            {
                System.out.print("Enter the number to Check : ");
                int num = sc.nextInt();
                System.out.println("The element "+num+" is found or not : "+elementSearch(head, num));
            }
            else if(choice == 6)
            {
                System.out.println("=============================END OF THE OPERATION=================================");
                break;
            }
            else
            {
                System.out.println("Enter the valid Choice!!!!!");
            }
        }
    }
}
