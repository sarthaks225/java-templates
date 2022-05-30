package utils;

public class TMArrayList<T> implements TMList<T> 
{

private Object[] collection;
private int size;
private int capacity;

public TMArrayList()
{
collection=new Object[10];
capacity=10;
size=0;
}

public TMArrayList(int size)
{
this.size=0;
if(size%10!=0) this.capacity=size+10-(size%10);
else this.capacity=size;
collection=new Object[this.capacity];
}


public void add(T data)
{
if(size==capacity)
{
Object[] tmpCollection=new Object[this.capacity+10];
this.capacity+=10;
for(int i=0; i<this.size; ++i ) tmpCollection[i]=collection[i];
collection=tmpCollection;
}

collection[this.size]=data;
++size;
}


public void add(int index,T data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
if(size==capacity)
{
Object[] tmpCollection=new Object[this.capacity+10];
this.capacity+=10;
for(int i=0; i<this.size; ++i ) tmpCollection[i]=collection[i];
collection=tmpCollection;
}
		   
                         		               //array  11  12  13  14  15  16 
		                                      // Index  0   1   2   3   4   5   6   7  8 9 10 
for(int i=this.size; i>index; --i)           // now we want to add (23) at index (2)
{                              	            // solution: array  11  12  (23)  13  14  15  16 
collection[i]=collection[i-1];	           //            Index  0   1   [2]   3   4   5   6   7  8 9 10 
}

collection[index]=data;
++size;
}

public void insert(int index,T data)
{
	add(index,data);
}


public void removeAll()
{
	clear();
}


public void clear()
{
this.size=0;
}



public T removeAt(int index)
{
if(index<0 || index>=size) throw new IndexOutOfBoundsException("Invalid index: "+index);
T remove;
remove=(T) collection[index];
if(index==size-1)
{
--this.size;
return remove;
}

--this.size;
for(int i=index; i<this.size; ++i) collection[i]=collection[i+1];
return remove;
}


public int getSize()
{
return this.size;
}
public int capacity()
{
return this.capacity;
}

public T get(int index)
{
if(index>=size || index<0)  throw new IndexOutOfBoundsException("Invalid index: "+index);
return (T)this.collection[index];
}


public void update(int index,T data)
{
	if(index>=size || index<0) throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);
	this.collection[index]=data;
}


class TMArrayListIterator <T> implements TMIterator<T>
{
	private int index;
	public TMArrayListIterator(int index)
	{
		this.index=index;
	}

	public boolean hasNext()
	{
		return index!=size;
	}
	public T get()
	{
		if(index==size) throw new InvalidIteratorException("Iterator has no more elements");
		T data;
		data=(T)collection[index];
		index++;
		return data;
	}

}



public TMIterator iterator()
{
	return new TMArrayListIterator(0);
	
}


public void copyTo(TMList other)
{

	other.clear();
    TMIterator iterator;
    iterator=this.iterator();
    while(iterator.hasNext())
    {
        other.add((T)iterator.get());
    }

}


public void copyFrom(TMList other)
{


	this.clear();
    TMIterator iterator;
    iterator=other.iterator();
    while(iterator.hasNext())
    {
        this.add((T)iterator.get());
    }

}



public void appendTo(TMList other)
{

	TMIterator iterator;
    iterator=this.iterator();
    while(iterator.hasNext())
    {
        other.add((T)iterator.get());
    }

}
public void appendFrom(TMList other)
{

	TMIterator iterator;
    iterator=other.iterator();
    while(iterator.hasNext())
    {
        this.add((T)iterator.get());
    }

}


}