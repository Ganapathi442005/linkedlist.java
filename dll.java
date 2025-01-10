

class Node{
    int data;
    Node next;
    Node prev;
    Node(int val)
    {
        prev=null;
        data=val;
        next=null;

    }
}
public class dll {
    public static void display(Node head)
    {
      if(head==null)
      {
        System.out.print("NULL");
      }  
      else
      {
        System.out.print(head.data +"->");
        display(head.next);
      }
    }


    public static Node insertbegin(Node head,int val)
    {
        Node temp=new Node(val);
        if(head==null)
        {
            head=temp;
        }
        else
        {
            temp.next=head;
            head.prev=temp;
            head=temp;
        }
        return head;
    }
    public static Node insertatend(Node head,int val)
    {
        Node nn=new Node(val);
        if(head==null)
        {
            head=nn;
        }
        else
        {    
            Node temp1=head;
             while(temp1.next!=null)
             {
                  
                  temp1=temp1.next;
                  
             }
             
             temp1.next=nn;
             nn.prev=temp1;
             
        }
        return head;
    }
    public static Node insertatspecific(Node head,int val,int pos)
    {  
        Node nn=new Node(val);
        if(head==null)
        {
            head=nn;
        }
        else if(pos==1)
        {
            head=insertbegin(head,val);
        }
        else
        {
            int count=1;
            Node temp=head;
            
            while(temp!=null)
            {
                count++;
                if(count==pos)
                {
                    break;
                }
                temp=temp.next;
            }
            if(count==pos)
            {
                Node temp1=temp.next;
                nn.next=temp1;
                temp1.prev=nn;
                temp.next=nn;
                nn.prev=temp;
            }
        }
        return head;
    }
    public static Node deleteatbegin( Node head)
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
           Node temp=head;
           head=head.next;
           head.prev=null;
           temp.next=null;
        }
        return head;
    }
    public static Node deleteatend(Node head)
    {
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
            Node temp=head;
            while(temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next.prev=null;
            temp.next=null;
            
        }
        return head;
    }
  
    public static Node deleteatpos(Node head,int pos)
    {
        
        if(head==null)
        {
            System.out.println("list is empty");
        }
        else if(pos==1)
        {
            head=deleteatbegin(head);
        }
        else
        {
            int count=1;
            Node temp=head;
            Node temp1=head.next;
            while(temp!=null)
            {
                count++;
               
                if(count==pos)
                {
                    break;
                }
                temp=temp.next;
                temp1=temp1.next;
            }
            if(count==pos)
            {
                temp.next=temp1.next;
                
                temp1.prev=null;
                temp1.next=null;

            }
        }
        return head;
    }

public static void main(String[] args) {
    Node head=new Node(10);
    head.next=new Node(20);
    head=insertbegin(head, 100);
    display(head);
    System.out.println();
    head=insertatend(head,40);
    display(head);
    System.out.println();
    head=insertatspecific(head, 50, 3);
    display(head);
    System.out.println();
    head=deleteatbegin(head);
    display(head);
    System.out.println();
    head=deleteatend(head);
    display(head);
    System.out.println();
    head=deleteatpos(head,3);
    display(head);
    System.out.println();

}
}
