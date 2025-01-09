
import java.util.*;

class Node {

    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class Main {

    static void display(Node headNode) {
        if (headNode == null) {
            System.out.println(" NULL");
        } else {

            System.out.print(headNode.data + "->");
            display(headNode.next);
        }
    }

    static Node insertionBegin(Node headNode, int val) {
        Node temp = new Node(val);
        if (headNode == null) {
            headNode = temp;
        } else {
            temp.next = headNode;
            headNode = temp;
        }
        return headNode;
    }

    static Node insertionEnd(Node head, int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = temp;

        }
        return head;
    }

    static Node insertionatpos(Node head, int pos, int val) {
        Node tem = head;
        Node temp = new Node(val);

        if (head == null) {
            head = temp;
        } else if (pos == 1) {
            head = insertionBegin(head, val);
        } else {
            int count = 1;
            while (tem.next != null && count < pos - 1) {
                count++;
                tem = tem.next;
            }

            temp.next = tem.next;
            tem.next = temp;

        }
        return head;
    }

    static Node deleteatbegin(Node head) {

        Node temp = head;
        if (head == null) {
            System.out.println("no element in list");
        } else {
            head = head.next;
            temp = null;
        }
        return head;

    }

    static Node deleteatend(Node head) {
        if (head == null) {
            System.out.println("no element in list");
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;

        }
        return head;

    }

    static Node deleteatmiddle(Node head, int pos) {
        if (head == null) {
            System.out.println("no element in list");
        } else {
            int count = 1;
            Node temp = head;

            while (temp != null && count < pos - 1) {
                temp = temp.next;

                count++;

            }
            temp.next = temp.next.next;
        }
        return head;
    }

    static boolean searchelement(int num, Node head) {
        if (head == null) {
            System.out.println("list is empty");
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
                if (num == temp.data) {
                    return true;
                }
            }
            

        }
                return false;

    }
    static Node nodereverse(Node head)
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
              Node temp=null;
              Node temp1=head;
              Node temp2=null;
              while(temp1!=null)
              {
                  temp2 = temp1.next;
                  temp1.next=temp;
                  temp=temp1;
                  temp1=temp2;
              } 
              head=temp;
        }
        return head;
    }
    

    public static void main(String[] args) {
        
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        Scanner sc = new Scanner(System.in);
        head=deleteatend(head);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
         int val;
         System.out.println("enter the elements");
         val=sc.nextInt();
         head = insertionBegin(head, val);
         System.out.println();
         display(head);
        head=insertionEnd(head, val);
         System.out.println();
         display(head);
        head = insertionatpos(head, 1, 5);
        System.out.println();
        display(head);
        head=deleteatbegin(head);
        System.out.println();
        display(head);
        head=deleteatend(head);
        System.out.println();
        display(head);
        head=deleteatmiddle(head, 2);
        System.out.println();
        display(head);
        boolean found = searchelement(20, head);
        System.out.println("Element found: " + found);
        display(head);
        head=nodereverse(head);
        display(head);
    }
}
