package utils;


public class TMLinkedList<T> implements TMList<T>
{
    class Node<T>
    {
        public T data;
        public Node next;
        public Node()
        {   
            data=null;
            next=null;
        }
    }

    private Node start,end;
    private int size;
    
    public TMLinkedList()
    {
        this.start=this.end=null;
        this.size=0;
    }
public void add(T data)
{
    if(this.start==null)
    {
        start=new Node();
        start.data=data;
        end=start;
    }
    else
    {
        end.next=new Node();
        end=end.next;
        end.data=data;
    }

    size++;


}
public void add(int index,T data)
{
    if(this.size<index || index<0) throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);
    if(this.size==index)
    {
     this.add(data);
     return;
    }
    Node<T> t=new Node<T>();
    t.data=data;
    if(index==0)
    {
        t.next=start;
        start=t;
    }
    else
    {
    Node<T> node;
    node=this.start;
    int ep=index-1;
    for(int i=0; i<ep; ++i) node=node.next;
    t.next=node.next;
    node.next=t;
    }
    this.size++;
}
public void insert(int index,T data)
{
    this.add(index,data);
}

public void removeAll()
{
    this.start=null;
    this.end=null;
    this.size=0;
}
public void clear()
{
    this.removeAll();
}
public T removeAt(int index)
{
    if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);
    T data;
    
    if(index==0)    // remove at index 0
    {
        data=(T)start.data;
        this.start=start.next;
        if(start==null) this.end=null; // there is only one node list
        this.size--;
        return data;
    }
    Node<T> node=start;
    int ep=index-1;
    for(int i=0; i<ep; ++i) node=node.next;   // searching for node before to remove
    data=(T)node.next.data;
    if(index==this.size-1)  
    {                       // remove for last node
        
        node.next=null;
        this.end=node;
    }
    else
    {
    node.next=node.next.next;  // node somewhare between start and end
    }
    this.size--;
    return data;
}

public int getSize()
{
    return this.size;
}
public T get(int index)
{
    if(index>=size || index<0) throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);
    Node<T> node=start;
    for(int i=0; i<index; ++i) node=node.next;
    
    return (T)node.data;
}

public void update(int index,T data)
{
if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);

if(this.size-1==index)
{
    this.end.data=data;
    return;
}
 Node<T> node=start;
for(int i=0; i<index; ++i) node=node.next;
 node.data=data;
}

class TMLinkedListIterator<T> implements TMIterator <T>
{
    private Node node;
    TMLinkedListIterator(Node<T> node)
    {
        this.node=node;
    }
    public boolean hasNext()
    {
        return this.node!=null;
    }
    public T get()
    {
        if(node==null) throw new InvalidIteratorException("Iterator has no more elements");
        T data;
        data=(T)this.node.data;
        node=node.next;
        return data;
    }
}

public TMIterator<T> iterator()
{
    return new TMLinkedListIterator<T>(this.start);
}

public void copyTo(TMList<T> other)
{
    other.clear();
    TMIterator<T> iterator;
    iterator=this.iterator();
    while(iterator.hasNext())
    {
        other.add((T)iterator.get());
    }

}
public void copyFrom(TMList<T> other)
{
    this.clear();
    TMIterator<T> iterator;
    iterator=other.iterator();
    while(iterator.hasNext())
    {
        this.add((T)iterator.get());
    }

}

public void appendTo(TMList<T> other)
{
    TMIterator<T> iterator;
    iterator=this.iterator();
    while(iterator.hasNext())
    {
        other.add((T)iterator.get());
    }

}
public void appendFrom(TMList<T> other)
{
    TMIterator<T> iterator;
    iterator=other.iterator();
    while(iterator.hasNext())
    {
        this.add((T)iterator.get());
    }
}


public void forEach(TMListItemAcceptor<T> a)
{
    if(a==null) return;
    for(Node node=start; node!=null; node=node.next) a.accept((T)node.data);
}


}