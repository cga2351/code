package com.viber.voip.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.SparseArrayCompat;
import java.util.Collection;
import java.util.Iterator;

public class SparseSet
  implements Parcelable
{
  public static final Parcelable.Creator<SparseSet> CREATOR = new Parcelable.Creator()
  {
    public SparseSet a(Parcel paramAnonymousParcel)
    {
      return new SparseSet(paramAnonymousParcel);
    }

    public SparseSet[] a(int paramAnonymousInt)
    {
      return new SparseSet[paramAnonymousInt];
    }
  };
  private static final Object VALUE = new Object();
  private final SparseArrayCompat<Object> mContainer;

  public SparseSet()
  {
    this.mContainer = new SparseArrayCompat();
  }

  public SparseSet(int paramInt)
  {
    this.mContainer = new SparseArrayCompat(paramInt);
  }

  SparseSet(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.mContainer = new SparseArrayCompat(i);
    for (int j = 0; j < i; j++)
      this.mContainer.append(paramParcel.readInt(), VALUE);
  }

  public static SparseSet from(int[] paramArrayOfInt)
  {
    SparseSet localSparseSet = new SparseSet(paramArrayOfInt.length);
    localSparseSet.addAll(paramArrayOfInt);
    return localSparseSet;
  }

  public static SparseSet from(String[] paramArrayOfString)
  {
    SparseSet localSparseSet = new SparseSet(paramArrayOfString.length);
    int i = paramArrayOfString.length;
    int j = 0;
    while (true)
    {
      String str;
      if (j < i)
        str = paramArrayOfString[j];
      try
      {
        localSparseSet.add(Integer.parseInt(str));
        label34: j++;
        continue;
        return localSparseSet;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label34;
      }
    }
  }

  public void add(int paramInt)
  {
    this.mContainer.put(paramInt, VALUE);
  }

  public void addAll(SparseSet paramSparseSet)
  {
    if (paramSparseSet == null);
    while (true)
    {
      return;
      int i = 0;
      int j = paramSparseSet.size();
      while (i < j)
      {
        append(paramSparseSet.get(i));
        i++;
      }
    }
  }

  public void addAll(Collection<Integer> paramCollection)
  {
    if (paramCollection == null);
    while (true)
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger != null)
          append(localInteger.intValue());
      }
    }
  }

  public void addAll(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null);
    while (true)
    {
      return;
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++)
        append(paramArrayOfInt[j]);
    }
  }

  public void append(int paramInt)
  {
    this.mContainer.append(paramInt, VALUE);
  }

  public void clear()
  {
    this.mContainer.clear();
  }

  public boolean contains(int paramInt)
  {
    return this.mContainer.get(paramInt) == VALUE;
  }

  public int describeContents()
  {
    return 0;
  }

  public int get(int paramInt)
  {
    return this.mContainer.keyAt(paramInt);
  }

  public int indexOf(int paramInt)
  {
    return this.mContainer.indexOfKey(paramInt);
  }

  public boolean isEmpty()
  {
    return this.mContainer.size() == 0;
  }

  public void remove(int paramInt)
  {
    this.mContainer.remove(paramInt);
  }

  public void removeAll(SparseSet paramSparseSet)
  {
    if (paramSparseSet == null);
    while (true)
    {
      return;
      int i = 0;
      int j = paramSparseSet.size();
      while (i < j)
      {
        remove(paramSparseSet.get(i));
        i++;
      }
    }
  }

  public void removeAll(Collection<Integer> paramCollection)
  {
    if (paramCollection == null);
    while (true)
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger != null)
          remove(localInteger.intValue());
      }
    }
  }

  public void removeAll(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null);
    while (true)
    {
      return;
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++)
        remove(paramArrayOfInt[j]);
    }
  }

  public void removeAt(int paramInt)
  {
    this.mContainer.removeAt(paramInt);
  }

  public int size()
  {
    return this.mContainer.size();
  }

  public int[] toArray()
  {
    int[] arrayOfInt = new int[size()];
    int i = 0;
    int j = size();
    while (i < j)
    {
      arrayOfInt[i] = this.mContainer.keyAt(i);
      i++;
    }
    return arrayOfInt;
  }

  public String toString()
  {
    if (this.mContainer.size() == 0)
      return "[]";
    int i = this.mContainer.size();
    StringBuilder localStringBuilder = new StringBuilder(i * 28);
    localStringBuilder.append('[');
    for (int j = 0; j < i; j++)
    {
      if (j > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(this.mContainer.keyAt(j));
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = this.mContainer.size();
    paramParcel.writeInt(i);
    for (int j = 0; j < i; j++)
      paramParcel.writeInt(this.mContainer.keyAt(j));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.SparseSet
 * JD-Core Version:    0.6.2
 */