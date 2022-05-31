package utils;
public interface TMList <T>
{
public void add(T data);
public void add(int index,T data);
public void insert(int index,T data);

public void removeAll();
public void clear();
public T removeAt(int index);

public int getSize();
public T get(int index);

public void update(int index,T data);

public TMIterator<T> iterator();

public void copyTo(TMList<T> other);
public void copyFrom(TMList<T> other);

public void appendTo(TMList<T> other);
public void appendFrom(TMList<T> other);
public void forEach(TMListItemAcceptor<T> a);
}