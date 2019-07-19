package com.yandex.mobile.ads.video.models.blocksinfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Block
  implements Parcelable
{
  public static final Parcelable.Creator<Block> CREATOR = new Parcelable.Creator()
  {
  };
  private int mDuration;
  private String mId;
  private int mPositionsCount;
  private int mStartTime;
  private Type mType;

  private Block()
  {
  }

  private Block(Parcel paramParcel)
  {
    this.mId = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i == -1);
    for (Type localType = null; ; localType = Type.values()[i])
    {
      this.mType = localType;
      this.mStartTime = paramParcel.readInt();
      this.mDuration = paramParcel.readInt();
      this.mPositionsCount = paramParcel.readInt();
      return;
    }
  }

  private void setDuration(String paramString)
  {
    try
    {
      this.mDuration = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void setId(String paramString)
  {
    this.mId = paramString;
  }

  private void setPositionsCount(String paramString)
  {
    try
    {
      this.mPositionsCount = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void setStartTime(String paramString)
  {
    try
    {
      this.mStartTime = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void setType(String paramString)
  {
    this.mType = Type.getByType(paramString);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Block localBlock;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localBlock = (Block)paramObject;
      if (this.mDuration != localBlock.mDuration)
        return false;
      if (this.mPositionsCount != localBlock.mPositionsCount)
        return false;
      if (this.mStartTime != localBlock.mStartTime)
        return false;
      if (this.mId != null)
      {
        if (this.mId.equals(localBlock.mId));
      }
      else
        while (localBlock.mId != null)
          return false;
    }
    while (this.mType == localBlock.mType);
    return false;
  }

  public final int getDuration()
  {
    return this.mDuration;
  }

  public final String getId()
  {
    return this.mId;
  }

  public final int getPositionsCount()
  {
    return this.mPositionsCount;
  }

  public final int getStartTime()
  {
    return this.mStartTime;
  }

  public final Type getType()
  {
    return this.mType;
  }

  public final int hashCode()
  {
    if (this.mId != null);
    for (int i = this.mId.hashCode(); ; i = 0)
    {
      int j = i * 31;
      Type localType = this.mType;
      int k = 0;
      if (localType != null)
        k = this.mType.hashCode();
      return 31 * (31 * (31 * (j + k) + this.mStartTime) + this.mDuration) + this.mPositionsCount;
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mId);
    if (this.mType == null);
    for (int i = -1; ; i = this.mType.ordinal())
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.mStartTime);
      paramParcel.writeInt(this.mDuration);
      paramParcel.writeInt(this.mPositionsCount);
      return;
    }
  }

  public static enum Type
  {
    private final String mType;

    static
    {
      MIDROLL = new Type("MIDROLL", 1, "midroll");
      POSTROLL = new Type("POSTROLL", 2, "postroll");
      PAUSEROLL = new Type("PAUSEROLL", 3, "pauseroll");
      OVERLAYROLL = new Type("OVERLAYROLL", 4, "overlayroll");
      Type[] arrayOfType = new Type[5];
      arrayOfType[0] = PREROLL;
      arrayOfType[1] = MIDROLL;
      arrayOfType[2] = POSTROLL;
      arrayOfType[3] = PAUSEROLL;
      arrayOfType[4] = OVERLAYROLL;
    }

    private Type(String paramString)
    {
      this.mType = paramString;
    }

    public static Type getByType(String paramString)
    {
      for (Type localType : values())
        if (localType.mType.equals(paramString))
          return localType;
      return null;
    }

    public final String toString()
    {
      return this.mType;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.models.blocksinfo.Block
 * JD-Core Version:    0.6.2
 */