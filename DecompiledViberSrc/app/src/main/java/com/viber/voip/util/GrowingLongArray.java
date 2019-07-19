package com.viber.voip.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GrowingLongArray
  implements Parcelable
{
  public static final Parcelable.Creator<GrowingLongArray> CREATOR = new Parcelable.Creator()
  {
    public GrowingLongArray a(Parcel paramAnonymousParcel)
    {
      return new GrowingLongArray(paramAnonymousParcel);
    }

    public GrowingLongArray[] a(int paramAnonymousInt)
    {
      return new GrowingLongArray[paramAnonymousInt];
    }
  };
  private int mSize;
  private long[] mValues;

  public GrowingLongArray()
  {
    this(10);
  }

  public GrowingLongArray(int paramInt)
  {
    this.mValues = new long[paramInt];
    this.mSize = 0;
  }

  GrowingLongArray(Parcel paramParcel)
  {
    this.mValues = paramParcel.createLongArray();
    this.mSize = paramParcel.readInt();
  }

  private static long[] append(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramInt > paramArrayOfLong.length))
      throw new IllegalArgumentException("currentSize must be a value between 0 and " + paramArrayOfLong.length + ", but actually " + paramInt);
    if (paramInt + 1 > paramArrayOfLong.length)
    {
      long[] arrayOfLong = new long[growSize(paramInt)];
      System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, paramInt);
      paramArrayOfLong = arrayOfLong;
    }
    paramArrayOfLong[paramInt] = paramLong;
    return paramArrayOfLong;
  }

  private static int growSize(int paramInt)
  {
    if (paramInt <= 4)
      return 8;
    return paramInt * 2;
  }

  private static long[] insert(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfLong.length))
      throw new IllegalArgumentException("currentSize must be a value between 0 and " + paramArrayOfLong.length + ", but actually " + paramInt1);
    if (paramInt1 + 1 <= paramArrayOfLong.length)
    {
      System.arraycopy(paramArrayOfLong, paramInt2, paramArrayOfLong, paramInt2 + 1, paramInt1 - paramInt2);
      paramArrayOfLong[paramInt2] = paramLong;
      return paramArrayOfLong;
    }
    long[] arrayOfLong = new long[growSize(paramInt1)];
    System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, paramInt2);
    arrayOfLong[paramInt2] = paramLong;
    System.arraycopy(paramArrayOfLong, paramInt2, arrayOfLong, paramInt2 + 1, paramArrayOfLong.length - paramInt2);
    return arrayOfLong;
  }

  public void add(int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramInt >= this.mSize))
      throw new IndexOutOfBoundsException("index " + paramInt + " requested for array of size " + this.mSize);
    this.mValues = insert(this.mValues, this.mSize, paramInt, paramLong);
    this.mSize = (1 + this.mSize);
  }

  public void add(long paramLong)
  {
    this.mValues = append(this.mValues, this.mSize, paramLong);
    this.mSize = (1 + this.mSize);
  }

  // ERROR //
  public Object clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 97	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/viber/voip/util/GrowingLongArray
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 28	com/viber/voip/util/GrowingLongArray:mValues	[J
    //   13: invokevirtual 99	[J:clone	()Ljava/lang/Object;
    //   16: checkcast 98	[J
    //   19: putfield 28	com/viber/voip/util/GrowingLongArray:mValues	[J
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 30	com/viber/voip/util/GrowingLongArray:mSize	I
    //   27: putfield 30	com/viber/voip/util/GrowingLongArray:mSize	I
    //   30: aload_2
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: areturn
    //   35: astore_3
    //   36: aload_2
    //   37: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	32	java/lang/CloneNotSupportedException
    //   8	30	35	java/lang/CloneNotSupportedException
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (this == paramObject)
      bool2 = true;
    GrowingLongArray localGrowingLongArray;
    int i;
    int j;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof GrowingLongArray;
        bool2 = false;
      }
      while (!bool1);
      localGrowingLongArray = (GrowingLongArray)paramObject;
      i = this.mSize;
      j = localGrowingLongArray.mSize;
      bool2 = false;
    }
    while (i != j);
    for (int k = 0; ; k++)
    {
      if (k >= this.mSize)
        break label91;
      boolean bool3 = this.mValues[k] < localGrowingLongArray.mValues[k];
      bool2 = false;
      if (bool3)
        break;
    }
    label91: return true;
  }

  public long get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mSize))
      throw new IndexOutOfBoundsException("index " + paramInt + " requested for array of size " + this.mSize);
    return this.mValues[paramInt];
  }

  public int hashCode()
  {
    int i = 0;
    if (this.mSize == 0)
      return 0;
    int j = 1;
    while (i < this.mSize)
    {
      long l = this.mValues[i];
      j = j * 31 + (int)(l ^ l >>> 32);
      i++;
    }
    return j;
  }

  public boolean isEmpty()
  {
    return this.mSize == 0;
  }

  public int size()
  {
    return this.mSize;
  }

  public long[] toArray()
  {
    long[] arrayOfLong = new long[this.mSize];
    System.arraycopy(this.mValues, 0, arrayOfLong, 0, this.mSize);
    return arrayOfLong;
  }

  public String toString()
  {
    if (this.mSize == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    for (int i = 0; i < this.mSize; i++)
    {
      if (i != 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(this.mValues[i]);
    }
    return ']';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLongArray(this.mValues);
    paramParcel.writeInt(this.mSize);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.GrowingLongArray
 * JD-Core Version:    0.6.2
 */