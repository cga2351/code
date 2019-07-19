package com.google.a.a.f;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class a<K, V> extends AbstractMap<K, V>
  implements Cloneable
{
  int a;
  private Object[] b;

  public static <K, V> a<K, V> a()
  {
    return new a();
  }

  private int b(Object paramObject)
  {
    int i = this.a << 1;
    Object[] arrayOfObject = this.b;
    for (int j = 0; j < i; j += 2)
    {
      Object localObject = arrayOfObject[j];
      if (paramObject == null)
      {
        if (localObject != null);
      }
      else
        while (paramObject.equals(localObject))
          return j;
    }
    return -2;
  }

  private void b(int paramInt, K paramK, V paramV)
  {
    Object[] arrayOfObject = this.b;
    arrayOfObject[paramInt] = paramK;
    arrayOfObject[(paramInt + 1)] = paramV;
  }

  private void e(int paramInt)
  {
    if (paramInt == 0)
      this.b = null;
    int i;
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    do
    {
      do
      {
        return;
        i = this.a;
        arrayOfObject1 = this.b;
      }
      while ((i != 0) && (paramInt == arrayOfObject1.length));
      arrayOfObject2 = new Object[paramInt];
      this.b = arrayOfObject2;
    }
    while (i == 0);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i << 1);
  }

  private V f(int paramInt)
  {
    if (paramInt < 0)
      return null;
    return this.b[paramInt];
  }

  private V g(int paramInt)
  {
    int i = this.a << 1;
    if ((paramInt < 0) || (paramInt >= i))
      return null;
    Object localObject = f(paramInt + 1);
    Object[] arrayOfObject = this.b;
    int j = -2 + (i - paramInt);
    if (j != 0)
      System.arraycopy(arrayOfObject, paramInt + 2, arrayOfObject, paramInt, j);
    this.a = (-1 + this.a);
    b(i - 2, null, null);
    return localObject;
  }

  public final int a(K paramK)
  {
    return b(paramK) >> 1;
  }

  public final K a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a))
      return null;
    return this.b[(paramInt << 1)];
  }

  public final V a(int paramInt, V paramV)
  {
    int i = this.a;
    if ((paramInt < 0) || (paramInt >= i))
      throw new IndexOutOfBoundsException();
    int j = 1 + (paramInt << 1);
    Object localObject = f(j);
    this.b[j] = paramV;
    return localObject;
  }

  public final V a(int paramInt, K paramK, V paramV)
  {
    if (paramInt < 0)
      throw new IndexOutOfBoundsException();
    int i = paramInt + 1;
    d(i);
    int j = paramInt << 1;
    Object localObject = f(j + 1);
    b(j, paramK, paramV);
    if (i > this.a)
      this.a = i;
    return localObject;
  }

  public a<K, V> b()
  {
    try
    {
      a locala = (a)super.clone();
      Object[] arrayOfObject1 = this.b;
      if (arrayOfObject1 != null)
      {
        int i = arrayOfObject1.length;
        Object[] arrayOfObject2 = new Object[i];
        locala.b = arrayOfObject2;
        System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      }
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    return null;
  }

  public final V b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a))
      return null;
    return f(1 + (paramInt << 1));
  }

  public final V c(int paramInt)
  {
    return g(paramInt << 1);
  }

  public void clear()
  {
    this.a = 0;
    this.b = null;
  }

  public final boolean containsKey(Object paramObject)
  {
    return -2 != b(paramObject);
  }

  public final boolean containsValue(Object paramObject)
  {
    int i = this.a << 1;
    Object[] arrayOfObject = this.b;
    for (int j = 1; j < i; j += 2)
    {
      Object localObject = arrayOfObject[j];
      if (paramObject == null)
      {
        if (localObject != null);
      }
      else
        while (paramObject.equals(localObject))
          return true;
    }
    return false;
  }

  public final void d(int paramInt)
  {
    if (paramInt < 0)
      throw new IndexOutOfBoundsException();
    Object[] arrayOfObject = this.b;
    int i = paramInt << 1;
    int j;
    int k;
    if (arrayOfObject == null)
    {
      j = 0;
      if (i > j)
      {
        k = 1 + 3 * (j / 2);
        if (k % 2 != 0)
          k++;
        if (k >= i)
          break label73;
      }
    }
    while (true)
    {
      e(i);
      return;
      j = arrayOfObject.length;
      break;
      label73: i = k;
    }
  }

  public final Set<Map.Entry<K, V>> entrySet()
  {
    return new c();
  }

  public final V get(Object paramObject)
  {
    return f(1 + b(paramObject));
  }

  public final V put(K paramK, V paramV)
  {
    int i = a(paramK);
    if (i == -1)
      i = this.a;
    return a(i, paramK, paramV);
  }

  public final V remove(Object paramObject)
  {
    return g(b(paramObject));
  }

  public final int size()
  {
    return this.a;
  }

  final class a
    implements Map.Entry<K, V>
  {
    private int b;

    a(int arg2)
    {
      int i;
      this.b = i;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Map.Entry localEntry;
      do
      {
        return true;
        if (!(paramObject instanceof Map.Entry))
          return false;
        localEntry = (Map.Entry)paramObject;
      }
      while ((y.a(getKey(), localEntry.getKey())) && (y.a(getValue(), localEntry.getValue())));
      return false;
    }

    public K getKey()
    {
      return a.this.a(this.b);
    }

    public V getValue()
    {
      return a.this.b(this.b);
    }

    public int hashCode()
    {
      return getKey().hashCode() ^ getValue().hashCode();
    }

    public V setValue(V paramV)
    {
      return a.this.a(this.b, paramV);
    }
  }

  final class b
    implements Iterator<Map.Entry<K, V>>
  {
    private boolean b;
    private int c;

    b()
    {
    }

    public Map.Entry<K, V> a()
    {
      int i = this.c;
      if (i == a.this.a)
        throw new NoSuchElementException();
      this.c = (1 + this.c);
      return new a.a(a.this, i);
    }

    public boolean hasNext()
    {
      return this.c < a.this.a;
    }

    public void remove()
    {
      int i = -1 + this.c;
      if ((this.b) || (i < 0))
        throw new IllegalArgumentException();
      a.this.c(i);
      this.b = true;
    }
  }

  final class c extends AbstractSet<Map.Entry<K, V>>
  {
    c()
    {
    }

    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new a.b(a.this);
    }

    public int size()
    {
      return a.this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.a
 * JD-Core Version:    0.6.2
 */