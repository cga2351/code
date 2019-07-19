package com.viber.voip.engagement.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SendButtonReceiverId
  implements Parcelable
{
  public static final Parcelable.Creator<SendButtonReceiverId> CREATOR = new Parcelable.Creator()
  {
    public SendButtonReceiverId a(Parcel paramAnonymousParcel)
    {
      return new SendButtonReceiverId(paramAnonymousParcel);
    }

    public SendButtonReceiverId[] a(int paramAnonymousInt)
    {
      return new SendButtonReceiverId[paramAnonymousInt];
    }
  };
  private static final long NO_CONTACT_ID = -1L;
  private static final long NO_CONVERSATION_ID = -1L;
  private final long mContactId;
  private final long mConversationId;

  private SendButtonReceiverId(long paramLong1, long paramLong2)
  {
    this.mContactId = paramLong1;
    this.mConversationId = paramLong2;
  }

  protected SendButtonReceiverId(Parcel paramParcel)
  {
    this.mContactId = paramParcel.readLong();
    this.mConversationId = paramParcel.readLong();
  }

  public static SendButtonReceiverId createFromContactId(long paramLong)
  {
    return new SendButtonReceiverId(paramLong, -1L);
  }

  public static SendButtonReceiverId createFromConversationId(long paramLong)
  {
    return new SendButtonReceiverId(-1L, paramLong);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    SendButtonReceiverId localSendButtonReceiverId;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localSendButtonReceiverId = (SendButtonReceiverId)paramObject;
      if (this.mContactId != localSendButtonReceiverId.mContactId)
        return false;
    }
    while (this.mConversationId == localSendButtonReceiverId.mConversationId);
    return false;
  }

  public int hashCode()
  {
    return 31 * (int)(this.mContactId ^ this.mContactId >>> 32) + (int)(this.mConversationId ^ this.mConversationId >>> 32);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mContactId);
    paramParcel.writeLong(this.mConversationId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.contacts.SendButtonReceiverId
 * JD-Core Version:    0.6.2
 */