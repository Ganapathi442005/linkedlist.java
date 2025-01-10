import java.util.*;

class Node{
    int data;
    Node prev;
    Node next;
    Node(int x)
    {
        prev = null;
        data = x;
        next = null;
    }
}





public class Main {

    public static void display(Node head)
    {
        if(head==null)
        {
            System.out.println("No elements in the Linked list");
        }
        else 
        {
            Node temp = head;
            while(temp!=null)
            {
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }
    public static Node insertBegin(Node head,int data)
    {
        Node temp = new Node(data);
        if(head==null)
        {
            head = temp;
        }
        else{
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
        return head;
    }
    public static Node insertEnd(Node head,int data)
    {
        Node temp = new Node(data);
        if(head==null)
        {
            head = temp;
        }
        else if(head.next == null)
        {
            head.next = temp;
            temp.prev = head;
        }
        else
        {
            Node temp1 = head;
            while(temp1.next != null)
            {
                temp1 = temp1.next;
            }
            temp1.next = temp;
            temp.prev = temp1;
        }
        return head;
    }
    public static Node insertSpecificPos(Node head,int data,int pos)
    {
        Node temp = new Node(data);
        if(pos==1 && head==null)
        {
            head = temp;
        }
        else if(head==null)
        {
            System.out.println("There no elements in the List");
        }
        else if(pos==1)
        {
            head = insertBegin(head, data);
        }
        else
        {
            int count = 1;
            Node temp1 = head;
            while(temp1.next!=null)
            {
                count++;
                if(count==pos)
                {
                    temp.next = temp1.next;
                    temp.prev = temp.next.prev;
                    temp1.next = temp;
                    temp.next.prev = temp;
                    break;
                }
                temp1 = temp1.next;
            }
            if(temp1.next==null && count>pos)
            {
                head = insertEnd(head, data);
            }
            else if(count<pos)
            {
                System.out.println("Enter the Valid position.");
            }
        }
        return head;
    }
    public static int nodeCount(Node head)
    {
        Node temp = head;
        int count = 0;
        while(temp!=null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static Node insertMiddle(Node head,int data)
    {
        Node temp = new Node(data);
        int pos = nodeCount(head);
        if(head==null)
        {
            head=temp;
        }
        else
        {
            if(pos%2==0)
            {
                pos = pos/2;
            }
            else
            {
                pos = (pos/2)+1;
            }
            int count = 1;
            Node temp1 = head;
            while(temp1!=null)
            {
                count++;
                if(count==pos)
                {
                    temp.next = temp1.next;
                    temp.prev = temp.next.prev;
                    temp1.next = temp;
                    temp.next.prev = temp;
                    break;
                }
                temp1 = temp1.next;
            }
        }
        return head;
    }
    public static Node deleteFirst(Node head)
    {
        if(head==null)
        {
            System.out.println("There are No elements in the Linked List");
        }
        else
        {
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        return head;
    }
    public static Node deleteLast(Node head)
    {
        if(head==null)
        {
            System.out.println("There are No elements in the Linked List");
        }
        else if(head.next == null)
        {
            head = head.next;
        }
        else
        {
            Node temp = head;
            while(temp.next.next!=null)
            {
                temp = temp.next;
            }
            System.out.println("The Element Deleted is : "+temp.next.data);
            temp.next.prev = null;
            temp.next = null;
        }
        return head;
    }
    public static Node deleteByPos(Node head,int pos)
    {
        if(head==null)
        {
            System.out.println("There are No elements in the Linked List");
        }
        else if(pos==1)
        {
            head = deleteFirst(head);
        }
        else
        {
            int count = 1;
            Node temp = head;
            while (temp.next!=null) 
            {
                Node temp1 = temp.next;
                count++;
                if(count==pos)
                {
                    if(temp.next.next!=null)
                    {
                        temp1.next.prev = temp;
                    }
                    temp.next = temp1.next;
                    temp1.next = null;
                    temp1.prev = null;
                    break;
                }
                temp = temp.next;    
            }
            if(temp.next==null && (count+1)==pos)
            {
                head = deleteLast(head);
            }
            else if(count<pos)
            {
                System.out.println("Enter the element to delete Within "+nodeCount(head));
            }
        }
        return head;
    }
    public static Node deleteByValue(Node head,int data)
    {
        if(head == null)
        {
            System.out.println("There are No elements in the Linked List");
        }
        else if(head.data == data)
        {
            head = deleteFirst(head);
        }
        else
        {
            Node temp = head;
            while(temp != null && temp.data!=data)                          
            {
                temp = temp.next;
            }
            if(temp==null)
            {
                System.out.println("The value "+data+" is not found!!");
            }
            else if(temp.next == null && temp.data == data)
            {
                head = deleteLast(head);
            }
            else if(temp.data==data)
            {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = null;
                temp.prev = null;
            }
        }
        return head;
    }
    public static boolean searchElement(Node head,int data)
    {
        if(head==null)
        {
            System.out.println("There are No elements in the list");
        }
        else
        {
            Node temp = head;
            while(temp!=null)
            {
                if(temp.data ==data)
                {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
    public static Node reverseList(Node head)
    {
        if(head==null)
        {
            System.out.println("There are No elements in the list");
        }
        else if(nodeCount(head)==1)
        {
            return head;
        }
        else
        {
            Node temp = null;
            Node temp1 = head;
            while(temp1!=null)
            {
                temp = temp1.prev;
                temp1.prev = temp1.next;
                temp1.next = temp;
                temp1 = temp1.prev;
            }
            head=temp.prev;
        }
        return head;
    }
    public static void displayReverse(Node head)
    {
        if(head == null)
        {
            System.out.println("There are No elements in the list");
        }
        else
        {
            Node temp = head;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            while(temp!=null)
            {
                System.out.print(temp.data+" -> ");
                temp = temp.prev;
            }
            System.out.print("null");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        System.out.println("===================OPERATION ON DOUBLE LINKED LIST=======================");
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
            System.out.println("6 -> Count of Elements in the Double Linked List");
            System.out.println("7 -> Exit");
            System.out.print("Enter your choice from the above Menu : ");
            int choice = sc.nextInt();
            if(choice == 1)
            {
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++Menu of Operation in the Insertion of Double Linked List++++++++++++");
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
                        head = insertEnd(head,num);
                        System.out.println("Element added : "+num);
                    }
                }
                else if(insert == 2)
                {
                    System.out.print("Enter the Element to Insert at the begining : ");
                    int num = sc.nextInt();
                    head = insertBegin(head, num);
                    System.out.println("Element added : "+num);
                }
                else if(insert == 3)
                {
                    System.out.print("Enter the Element to Insert at the End : ");
                    int num = sc.nextInt();
                    head = insertEnd(head, num);
                    System.out.println("Element added : "+num);
                }
                else if(insert == 4)
                {
                    System.out.print("Enter the Element to Insert at the Middle : ");
                    int num = sc.nextInt();
                    head = insertMiddle(head, num);
                    System.out.println("Element added : "+num);
                }
                else if(insert == 5)
                {
                    System.out.print("Enter the Element to Insert at the Specific Position : ");
                    int num = sc.nextInt();
                    System.out.print("Enter the position to insert : ");
                    int pos = sc.nextInt();
                    head = insertSpecificPos(head, num, pos);
                    System.out.println("Element added : "+num);
                }
                else
                {
                    System.out.println("Enter Valid Choice and Moving to Main Menu");
                }
            }
            else if(choice==2)
            {
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++Menu of Operation in the Deletion of Elements in Double Linked List++++++++++++");
                System.out.println("1 -> Delete Element at the Begin");
                System.out.println("2 -> Delete Element at the End");
                System.out.println("3 -> Delete Element by the value");
                System.out.println("4 -> Delete at the Specific pos");
                System.out.print("Enter your choice from the above Deletion Menu : ");
                int del = sc.nextInt();
                if(del == 1)
                {
                    System.out.println("The Element Deleted is : "+head.data);
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
                    head = deleteByPos(head, pos);
                }
                else
                {
                    System.out.println("Enter Valid Choice and Moving to Main Menu");
                }
            }
            else if(choice==3)
            {
                System.out.println("This Choice will change Your Linked List to Reverse of the List");
                System.out.print("Type 'Yes' to Continue else Type 'No' : ");
                String str = sc.next();
                if(str.equals("Yes") || str.equals("yes")|| str.equals("YES"))
                {
                    head = reverseList(head);
                    System.out.println("The Reversed List is : ");
                    display(head);
                    System.out.println();
                }
                else if(str.equals("No") || str.equals("no")|| str.equals("NO"))
                {
                    continue;
                }
                else
                {
                    System.out.println("Enter Valid Choice and Moving to Main Menu");
                    System.out.println();
                }
            }
            else if(choice==4)
            {
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++Menu of Operation in the Display Elements in Double Linked List++++++++++++");
                System.out.println("1 -> Normal order of Linked List");
                System.out.println("2 -> Reverse Order of the Linked List");
                System.out.print("Enter your choice from the above Display Menu : ");
                int dis = sc.nextInt();
                if(dis==1)
                {
                    System.out.print("The Normal Order : ");
                    display(head);
                }
                else if(dis==2)
                {
                    System.out.print("The Reverse Order : ");
                    displayReverse(head);
                }
                else
                {
                    System.out.println("Enter Valid Choice and Moving to Main Menu");
                    System.out.println();
                }
            }
            else if(choice==5)
            {
                System.out.print("Enter the number to Check : ");
                int num = sc.nextInt();
                System.out.println("The element "+num+" is found or not : "+searchElement(head, num));
                System.out.println();
            }
            else if(choice==6)
            {
                System.out.println("The Count of Elements in the Double Linked List : "+nodeCount(head));
            }
            else if(choice==7)
            {
                System.out.println();
                System.out.println();
                System.out.println("=============================END OF THE OPERATION=================================");
                System.out.println();
                break;
            }
            else
            {
                System.out.println();
                System.out.println("Enter Valid Choice and Moving to Main Menu");
                System.out.println();
            }
        }
    }
}
