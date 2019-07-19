package com.viber.voip.util.links;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class MessageOpenUrlSpec extends SimpleOpenUrlSpec
{
  public static final Parcelable.Creator<MessageOpenUrlSpec> CREATOR = new Parcelable.Creator()
  {
    public MessageOpenUrlSpec a(Parcel paramAnonymousParcel)
    {
      return new MessageOpenUrlSpec(paramAnonymousParcel);
    }

    public MessageOpenUrlSpec[] a(int paramAnonymousInt)
    {
      return new MessageOpenUrlSpec[paramAnonymousInt];
    }
  };
  public final long conversationId;
  public final int conversationType;
  public final boolean isSecret;

  protected MessageOpenUrlSpec(Parcel paramParcel)
  {
    super(paramParcel);
    this.conversationId = paramParcel.readLong();
    this.conversationType = paramParcel.readInt();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.isSecret = bool;
      return;
    }
  }

  public MessageOpenUrlSpec(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramString, paramLong, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, 0);
  }

  public MessageOpenUrlSpec(String paramString, long paramLong, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    this(paramString, paramLong, paramInt1, paramBoolean1, paramBoolean2, paramBoolean3, paramInt2, -1);
  }

  public MessageOpenUrlSpec(String paramString, long paramLong, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3)
  {
    super(paramString, paramBoolean2, paramBoolean3, paramInt2, paramInt3);
    this.conversationId = paramLong;
    this.conversationType = paramInt1;
    this.isSecret = paramBoolean1;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.conversationId);
    paramParcel.writeInt(this.conversationType);
    if (this.isSecret);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.links.MessageOpenUrlSpec
 * JD-Core Version:    0.6.2
 */