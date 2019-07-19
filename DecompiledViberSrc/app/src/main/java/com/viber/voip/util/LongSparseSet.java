package com.viber.voip.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.LongSparseArray;
import java.util.Collection;
import java.util.Iterator;

public class LongSparseSet
  implements Parcelable
{
  public static final Parcelable.Creator<LongSparseSet> CREATOR = new Parcelable.Creator()
  {
    public LongSparseSet a(Parcel paramAnonymousParcel)
    {
      return new LongSparseSet(paramAnonymousParcel);
    }

    public LongSparseSet[] a(int paramAnonymousInt)
    {
      return new LongSparseSet[paramAnonymousInt];
    }
  };
  private static final Object VALUE = new Object();
  private final LongSparseArray<Object> mContainer;

  public LongSparseSet()
  {
    this.mContainer = new LongSparseArray();
  }

  public LongSparseSet(int paramInt)
  {
    this.mContainer = new LongSparseArray(paramInt);
  }

  LongSparseSet(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.mContainer = new LongSparseArray(i);
    for (int j = 0; j < i; j++)
      this.mContainer.append(paramParcel.readLong(), VALUE);
  }

  public LongSparseSet(LongSparseSet paramLongSparseSet)
  {
    this.mContainer = new LongSparseArray(paramLongSparseSet.size());
    addAll(paramLongSparseSet);
  }

  public static LongSparseSet from(long[] paramArrayOfLong)
  {
    LongSparseSet localLongSparseSet = new LongSparseSet(paramArrayOfLong.length);
    localLongSparseSet.addAll(paramArrayOfLong);
    return localLongSparseSet;
  }

  public static LongSparseSet from(String[] paramArrayOfString)
  {
    LongSparseSet localLongSparseSet = new LongSparseSet(paramArrayOfString.length);
    int i = paramArrayOfString.length;
    int j = 0;
    while (true)
    {
      String str;
      if (j < i)
        str = paramArrayOfString[j];
      try
      {
        localLongSparseSet.add(Long.parseLong(str));
        label34: j++;
        continue;
        return localLongSparseSet;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label34;
      }
    }
  }

  public void add(long paramLong)
  {
    this.mContainer.put(paramLong, VALUE);
  }

  public void addAll(LongSparseSet paramLongSparseSet)
  {
    if (paramLongSparseSet == null);
    while (true)
    {
      return;
      int i = 0;
      int j = paramLongSparseSet.size();
      while (i < j)
      {
        append(paramLongSparseSet.get(i));
        i++;
      }
    }
  }

  public void addAll(Collection<Long> paramCollection)
  {
    if (paramCollection == null);
    while (true)
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (localLong != null)
          append(localLong.longValue());
      }
    }
  }

  public void addAll(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null);
    while (true)
    {
      return;
      int i = paramArrayOfLong.length;
      for (int j = 0; j < i; j++)
        append(paramArrayOfLong[j]);
    }
  }

  public void append(long paramLong)
  {
    this.mContainer.append(paramLong, VALUE);
  }

  public void clear()
  {
    this.mContainer.clear();
  }

  public boolean contains(long paramLong)
  {
    return this.mContainer.get(paramLong) == VALUE;
  }

  public int describeContents()
  {
    return 0;
  }

  public long get(int paramInt)
  {
    return this.mContainer.keyAt(paramInt);
  }

  public int getItemsHashCode()
  {
    int i = 0;
    int j = this.mContainer.size();
    int k = 0;
    while (i < j)
    {
      long l = this.mContainer.keyAt(i);
      k = (int)(l ^ l >>> 32) + k * 31;
      i++;
    }
    return k;
  }

  public int indexOf(long paramLong)
  {
    return this.mContainer.indexOfKey(paramLong);
  }

  public boolean isEmpty()
  {
    return this.mContainer.size() == 0;
  }

  public void remove(long paramLong)
  {
    this.mContainer.remove(paramLong);
  }

  public void removeAll(LongSparseSet paramLongSparseSet)
  {
    if (paramLongSparseSet == null);
    while (true)
    {
      return;
      int i = 0;
      int j = paramLongSparseSet.size();
      while (i < j)
      {
        remove(paramLongSparseSet.get(i));
        i++;
      }
    }
  }

  public void removeAll(Collection<Long> paramCollection)
  {
    if (paramCollection == null);
    while (true)
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (localLong != null)
          remove(localLong.longValue());
      }
    }
  }

  public void removeAll(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null);
    while (true)
    {
      return;
      int i = paramArrayOfLong.length;
      for (int j = 0; j < i; j++)
        remove(paramArrayOfLong[j]);
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

  public long[] toArray()
  {
    long[] arrayOfLong = new long[size()];
    int i = 0;
    int j = size();
    while (i < j)
    {
      arrayOfLong[i] = this.mContainer.keyAt(i);
      i++;
    }
    return arrayOfLong;
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
      paramParcel.writeLong(this.mContainer.keyAt(j));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.LongSparseSet
 * JD-Core Version:    0.6.2
 */