package com.viber.voip.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GrowingIntArray
  implements Parcelable
{
  public static final Parcelable.Creator<GrowingIntArray> CREATOR = new Parcelable.Creator()
  {
    public GrowingIntArray a(Parcel paramAnonymousParcel)
    {
      return new GrowingIntArray(paramAnonymousParcel);
    }

    public GrowingIntArray[] a(int paramAnonymousInt)
    {
      return new GrowingIntArray[paramAnonymousInt];
    }
  };
  private int mSize;
  private int[] mValues;

  public GrowingIntArray()
  {
    this(10);
  }

  public GrowingIntArray(int paramInt)
  {
    this.mValues = new int[paramInt];
    this.mSize = 0;
  }

  GrowingIntArray(Parcel paramParcel)
  {
    this.mValues = paramParcel.createIntArray();
    this.mSize = paramParcel.readInt();
  }

  private static int[] append(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfInt.length))
      throw new IllegalArgumentException("currentSize must be a value between 0 and " + paramArrayOfInt.length + ", but actually " + paramInt1);
    if (paramInt1 + 1 > paramArrayOfInt.length)
    {
      int[] arrayOfInt = new int[growSize(paramInt1)];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
      paramArrayOfInt = arrayOfInt;
    }
    paramArrayOfInt[paramInt1] = paramInt2;
    return paramArrayOfInt;
  }

  private static int growSize(int paramInt)
  {
    if (paramInt <= 4)
      return 8;
    return paramInt * 2;
  }

  private static int[] insert(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfInt.length))
      throw new IllegalArgumentException("currentSize must be a value between 0 and " + paramArrayOfInt.length + ", but actually " + paramInt1);
    if (paramInt1 + 1 <= paramArrayOfInt.length)
    {
      System.arraycopy(paramArrayOfInt, paramInt2, paramArrayOfInt, paramInt2 + 1, paramInt1 - paramInt2);
      paramArrayOfInt[paramInt2] = paramInt3;
      return paramArrayOfInt;
    }
    int[] arrayOfInt = new int[growSize(paramInt1)];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt2);
    arrayOfInt[paramInt2] = paramInt3;
    System.arraycopy(paramArrayOfInt, paramInt2, arrayOfInt, paramInt2 + 1, paramArrayOfInt.length - paramInt2);
    return arrayOfInt;
  }

  public void add(int paramInt)
  {
    this.mValues = append(this.mValues, this.mSize, paramInt);
    this.mSize = (1 + this.mSize);
  }

  public void add(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.mSize))
      throw new IndexOutOfBoundsException("index " + paramInt1 + " requested for array of size " + this.mSize);
    this.mValues = insert(this.mValues, this.mSize, paramInt1, paramInt2);
    this.mSize = (1 + this.mSize);
  }

  // ERROR //
  public Object clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 96	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/viber/voip/util/GrowingIntArray
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 28	com/viber/voip/util/GrowingIntArray:mValues	[I
    //   13: invokevirtual 98	[I:clone	()Ljava/lang/Object;
    //   16: checkcast 97	[I
    //   19: putfield 28	com/viber/voip/util/GrowingIntArray:mValues	[I
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 30	com/viber/voip/util/GrowingIntArray:mSize	I
    //   27: putfield 30	com/viber/voip/util/GrowingIntArray:mSize	I
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
    GrowingIntArray localGrowingIntArray;
    int i;
    int j;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof GrowingIntArray;
        bool2 = false;
      }
      while (!bool1);
      localGrowingIntArray = (GrowingIntArray)paramObject;
      i = this.mSize;
      j = localGrowingIntArray.mSize;
      bool2 = false;
    }
    while (i != j);
    for (int k = 0; ; k++)
    {
      if (k >= this.mSize)
        break label94;
      int m = this.mValues[k];
      int n = localGrowingIntArray.mValues[k];
      bool2 = false;
      if (m != n)
        break;
    }
    label94: return true;
  }

  public int get(int paramInt)
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
      j = j * 31 + this.mValues[i];
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

  public int[] toArray()
  {
    int[] arrayOfInt = new int[this.mSize];
    System.arraycopy(this.mValues, 0, arrayOfInt, 0, this.mSize);
    return arrayOfInt;
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
    paramParcel.writeIntArray(this.mValues);
    paramParcel.writeInt(this.mSize);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.GrowingIntArray
 * JD-Core Version:    0.6.2
 */