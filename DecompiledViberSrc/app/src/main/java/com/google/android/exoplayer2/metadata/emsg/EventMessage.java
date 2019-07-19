package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import java.util.Arrays;

public final class EventMessage
  implements Metadata.Entry
{
  public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator()
  {
    public EventMessage a(Parcel paramAnonymousParcel)
    {
      return new EventMessage(paramAnonymousParcel);
    }

    public EventMessage[] a(int paramAnonymousInt)
    {
      return new EventMessage[paramAnonymousInt];
    }
  };
  public final long durationMs;
  private int hashCode;
  public final long id;
  public final byte[] messageData;
  public final long presentationTimeUs;
  public final String schemeIdUri;
  public final String value;

  EventMessage(Parcel paramParcel)
  {
    this.schemeIdUri = ((String)ag.a(paramParcel.readString()));
    this.value = ((String)ag.a(paramParcel.readString()));
    this.presentationTimeUs = paramParcel.readLong();
    this.durationMs = paramParcel.readLong();
    this.id = paramParcel.readLong();
    this.messageData = ((byte[])ag.a(paramParcel.createByteArray()));
  }

  public EventMessage(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3)
  {
    this.schemeIdUri = paramString1;
    this.value = paramString2;
    this.durationMs = paramLong1;
    this.id = paramLong2;
    this.messageData = paramArrayOfByte;
    this.presentationTimeUs = paramLong3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    EventMessage localEventMessage;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localEventMessage = (EventMessage)paramObject;
    }
    while ((this.presentationTimeUs == localEventMessage.presentationTimeUs) && (this.durationMs == localEventMessage.durationMs) && (this.id == localEventMessage.id) && (ag.a(this.schemeIdUri, localEventMessage.schemeIdUri)) && (ag.a(this.value, localEventMessage.value)) && (Arrays.equals(this.messageData, localEventMessage.messageData)));
    return false;
  }

  public int hashCode()
  {
    if (this.hashCode == 0)
      if (this.schemeIdUri == null)
        break label127;
    label127: for (int i = this.schemeIdUri.hashCode(); ; i = 0)
    {
      int j = 31 * (i + 527);
      String str = this.value;
      int k = 0;
      if (str != null)
        k = this.value.hashCode();
      this.hashCode = (31 * (31 * (31 * (31 * (j + k) + (int)(this.presentationTimeUs ^ this.presentationTimeUs >>> 32)) + (int)(this.durationMs ^ this.durationMs >>> 32)) + (int)(this.id ^ this.id >>> 32)) + Arrays.hashCode(this.messageData));
      return this.hashCode;
    }
  }

  public String toString()
  {
    return "EMSG: scheme=" + this.schemeIdUri + ", id=" + this.id + ", value=" + this.value;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.schemeIdUri);
    paramParcel.writeString(this.value);
    paramParcel.writeLong(this.presentationTimeUs);
    paramParcel.writeLong(this.durationMs);
    paramParcel.writeLong(this.id);
    paramParcel.writeByteArray(this.messageData);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.EventMessage
 * JD-Core Version:    0.6.2
 */