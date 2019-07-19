package com.viber.voip.util.upload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ObjectId
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public ObjectId a(Parcel paramAnonymousParcel)
    {
      return ObjectId.fromLong(paramAnonymousParcel.readLong());
    }

    public ObjectId[] a(int paramAnonymousInt)
    {
      return new ObjectId[paramAnonymousInt];
    }
  };
  public static final ObjectId EMPTY = new ObjectId(0L);
  private static final long EMPTY_ID_VALUE;
  private long mObjectId;

  private ObjectId(long paramLong)
  {
    this.mObjectId = paramLong;
  }

  public static ObjectId fromLong(long paramLong)
  {
    if (paramLong == 0L)
      return EMPTY;
    return new ObjectId(paramLong);
  }

  public static ObjectId fromServerString(String paramString)
    throws ObjectId.a
  {
    try
    {
      ObjectId localObjectId = fromLong(Long.parseLong(paramString, 16));
      return localObjectId;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new a("Invalid objectId: " + paramString, localNumberFormatException);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ObjectId localObjectId;
    do
    {
      return true;
      if (getClass() != paramObject.getClass())
        return false;
      localObjectId = (ObjectId)paramObject;
    }
    while (this.mObjectId == localObjectId.mObjectId);
    return false;
  }

  public int hashCode()
  {
    return (int)(this.mObjectId ^ this.mObjectId >>> 32);
  }

  public boolean isEmpty()
  {
    return this == EMPTY;
  }

  public String toDecString()
  {
    return Long.toString(this.mObjectId);
  }

  public long toLong()
  {
    return this.mObjectId;
  }

  public String toServerString()
  {
    return Long.toHexString(this.mObjectId);
  }

  public int toStickerId()
  {
    return (int)this.mObjectId;
  }

  public String toString()
  {
    return toServerString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mObjectId);
  }

  public static class a extends Exception
  {
    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.ObjectId
 * JD-Core Version:    0.6.2
 */