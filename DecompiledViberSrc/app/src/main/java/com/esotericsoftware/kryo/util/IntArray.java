package com.esotericsoftware.kryo.util;

import java.util.Arrays;

public class IntArray
{
  public int[] items;
  public boolean ordered;
  public int size;

  public IntArray()
  {
    this(true, 16);
  }

  public IntArray(int paramInt)
  {
    this(true, paramInt);
  }

  public IntArray(IntArray paramIntArray)
  {
    this.ordered = paramIntArray.ordered;
    this.size = paramIntArray.size;
    this.items = new int[this.size];
    System.arraycopy(paramIntArray.items, 0, this.items, 0, this.size);
  }

  public IntArray(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = new int[paramInt];
  }

  public IntArray(boolean paramBoolean, int[] paramArrayOfInt)
  {
    this(paramBoolean, paramArrayOfInt.length);
    this.size = paramArrayOfInt.length;
    System.arraycopy(paramArrayOfInt, 0, this.items, 0, this.size);
  }

  public IntArray(int[] paramArrayOfInt)
  {
    this(true, paramArrayOfInt);
  }

  public void add(int paramInt)
  {
    int[] arrayOfInt = this.items;
    if (this.size == arrayOfInt.length)
      arrayOfInt = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfInt[i] = paramInt;
  }

  public void addAll(IntArray paramIntArray)
  {
    addAll(paramIntArray, 0, paramIntArray.size);
  }

  public void addAll(IntArray paramIntArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramIntArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramIntArray.size);
    addAll(paramIntArray.items, paramInt1, paramInt2);
  }

  public void addAll(int[] paramArrayOfInt)
  {
    addAll(paramArrayOfInt, 0, paramArrayOfInt.length);
  }

  public void addAll(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.items;
    int i = paramInt2 + this.size - paramInt1;
    if (i >= arrayOfInt.length)
      arrayOfInt = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfInt, paramInt1, arrayOfInt, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    this.size = 0;
  }

  public boolean contains(int paramInt)
  {
    int i = -1 + this.size;
    int[] arrayOfInt = this.items;
    while (true)
    {
      int j;
      if (i >= 0)
      {
        j = i - 1;
        if (arrayOfInt[i] == paramInt)
          return true;
      }
      else
      {
        return false;
      }
      i = j;
    }
  }

  public int[] ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.items.length)
      resize(Math.max(8, i));
    return this.items;
  }

  public int get(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    return this.items[paramInt];
  }

  public int indexOf(int paramInt)
  {
    int[] arrayOfInt = this.items;
    int i = 0;
    int j = this.size;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt)
        return i;
      i++;
    }
    return -1;
  }

  public void insert(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.items;
    if (this.size == arrayOfInt.length)
      arrayOfInt = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfInt[paramInt1] = paramInt2;
      return;
      arrayOfInt[this.size] = arrayOfInt[paramInt1];
    }
  }

  public int peek()
  {
    return this.items[(-1 + this.size)];
  }

  public int pop()
  {
    int[] arrayOfInt = this.items;
    int i = -1 + this.size;
    this.size = i;
    return arrayOfInt[i];
  }

  public int removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    int[] arrayOfInt = this.items;
    int i = arrayOfInt[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, this.size - paramInt);
      return i;
    }
    arrayOfInt[paramInt] = arrayOfInt[this.size];
    return i;
  }

  public boolean removeValue(int paramInt)
  {
    int[] arrayOfInt = this.items;
    int i = this.size;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfInt[j] == paramInt)
        {
          removeIndex(j);
          bool = true;
        }
      }
      else
        return bool;
    }
  }

  protected int[] resize(int paramInt)
  {
    int[] arrayOfInt1 = new int[paramInt];
    int[] arrayOfInt2 = this.items;
    System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, Math.min(arrayOfInt2.length, arrayOfInt1.length));
    this.items = arrayOfInt1;
    return arrayOfInt1;
  }

  public void reverse()
  {
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      int n = this.items[i];
      this.items[i] = this.items[m];
      this.items[m] = n;
      i++;
    }
  }

  public void set(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt1));
    this.items[paramInt1] = paramInt2;
  }

  public void shrink()
  {
    resize(this.size);
  }

  public void sort()
  {
    Arrays.sort(this.items, 0, this.size);
  }

  public void swap(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt1));
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt2));
    int[] arrayOfInt = this.items;
    int i = arrayOfInt[paramInt1];
    arrayOfInt[paramInt1] = arrayOfInt[paramInt2];
    arrayOfInt[paramInt2] = i;
  }

  public int[] toArray()
  {
    int[] arrayOfInt = new int[this.size];
    System.arraycopy(this.items, 0, arrayOfInt, 0, this.size);
    return arrayOfInt;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    int[] arrayOfInt = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfInt[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfInt[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    int[] arrayOfInt = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfInt[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfInt[i]);
    }
    return localStringBuilder.toString();
  }

  public void truncate(int paramInt)
  {
    if (this.size > paramInt)
      this.size = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.util.IntArray
 * JD-Core Version:    0.6.2
 */