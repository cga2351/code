package com.viber.voip.model.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.calls.a.a.a.a;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.c;
import com.viber.voip.flatbuffers.b.e;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.Call;

public class CallEntity extends b
  implements Call
{
  public static final Parcelable.Creator<CallEntity> CREATOR = new Parcelable.Creator()
  {
    public CallEntity a(Parcel paramAnonymousParcel)
    {
      return new CallEntity(paramAnonymousParcel, null);
    }

    public CallEntity[] a(int paramAnonymousInt)
    {
      return new CallEntity[paramAnonymousInt];
    }
  };
  public static final a.a ENTITY_CREATOR = new a.a()
  {
    public CallEntity a()
    {
      return new CallEntity();
    }

    public com.viber.voip.model.d createInstance(Cursor paramAnonymousCursor)
    {
      return createInstance(paramAnonymousCursor, 0);
    }

    public com.viber.voip.model.d createInstance(Cursor paramAnonymousCursor, int paramAnonymousInt)
    {
      return a(a(), paramAnonymousCursor, paramAnonymousInt);
    }
  };
  private long aggregatedHash;
  private String canonizedNumber;
  private ConferenceInfo conferenceInfo;
  private long date;
  private long duration;
  private int endReason;
  private boolean looked;
  private String memberId;
  private long nativeCallId;
  private String number;
  private String rawConferenceInfo;
  private int startReason;
  private long token;
  private int type;
  private boolean viberCall;
  private int viberCallType;

  public CallEntity()
  {
  }

  private CallEntity(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.nativeCallId = paramParcel.readLong();
    this.number = paramParcel.readString();
    this.canonizedNumber = paramParcel.readString();
    this.aggregatedHash = paramParcel.readLong();
    this.date = paramParcel.readLong();
    this.duration = paramParcel.readLong();
    this.token = paramParcel.readLong();
    this.type = paramParcel.readInt();
    this.startReason = paramParcel.readInt();
    this.endReason = paramParcel.readInt();
    int j;
    if (paramParcel.readInt() == i)
    {
      j = i;
      this.looked = j;
      if (paramParcel.readInt() != i)
        break label144;
    }
    while (true)
    {
      this.viberCall = i;
      this.viberCallType = paramParcel.readInt();
      this.rawConferenceInfo = paramParcel.readString();
      return;
      j = 0;
      break;
      label144: i = 0;
    }
  }

  public CallEntity(String paramString1, long paramLong1, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, int paramInt3, String paramString2, long paramLong2, long paramLong3, int paramInt4, String paramString3)
  {
    this(paramString1, paramLong1, paramBoolean1, paramInt1, paramBoolean2, paramString2, paramLong2, paramLong3, paramInt4, paramString3);
    this.startReason = paramInt2;
    this.endReason = paramInt3;
  }

  private CallEntity(String paramString1, long paramLong1, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString2, long paramLong2, long paramLong3, int paramInt2, String paramString3)
  {
    this.nativeCallId = -1L;
    this.number = paramString2;
    this.date = paramLong2;
    this.duration = paramLong3;
    this.type = paramInt2;
    this.looked = paramBoolean2;
    this.viberCall = paramBoolean1;
    this.viberCallType = paramInt1;
    this.token = paramLong1;
    this.canonizedNumber = paramString1;
    this.rawConferenceInfo = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  public long getAggregatedHash()
  {
    return this.aggregatedHash;
  }

  public String getCanonizedNumber()
  {
    return this.canonizedNumber;
  }

  public ConferenceInfo getConferenceInfo()
  {
    if (this.conferenceInfo == null)
      this.conferenceInfo = ((ConferenceInfo)e.c().a().a(this.rawConferenceInfo));
    return this.conferenceInfo;
  }

  public ContentValues getContentValues()
  {
    return ENTITY_CREATOR.getContentValues(this);
  }

  public Creator getCreator()
  {
    return ENTITY_CREATOR;
  }

  public long getDate()
  {
    return this.date;
  }

  public long getDuration()
  {
    return this.duration;
  }

  public int getEndReason()
  {
    return this.endReason;
  }

  public String getMemberId()
  {
    return this.memberId;
  }

  public long getNativeCallId()
  {
    return this.nativeCallId;
  }

  public String getNumber()
  {
    return this.number;
  }

  public String getRawConferenceInfo()
  {
    return this.rawConferenceInfo;
  }

  public int getStartReason()
  {
    return this.startReason;
  }

  public long getToken()
  {
    return this.token;
  }

  public int getType()
  {
    return this.type;
  }

  public int getViberCallType()
  {
    return this.viberCallType;
  }

  public boolean hasConferenceInfo()
  {
    return !c.a(this.rawConferenceInfo);
  }

  public boolean isAnswerredOnAnotherDevice()
  {
    return this.endReason == 10;
  }

  public boolean isIncoming()
  {
    return this.type == 1;
  }

  public boolean isLooked()
  {
    return this.looked;
  }

  public boolean isMissed()
  {
    return this.type == 3;
  }

  public boolean isOutgoing()
  {
    return this.type == 2;
  }

  public boolean isPrivateNumber()
  {
    return "private_number".equals(this.number);
  }

  public boolean isTransferredIn()
  {
    return this.startReason == 1;
  }

  public boolean isTypeViberGroup()
  {
    return this.viberCallType == 6;
  }

  public boolean isTypeViberOut()
  {
    return this.viberCallType == 2;
  }

  public boolean isTypeViberVideo()
  {
    return this.viberCallType == 4;
  }

  public boolean isTypeVln()
  {
    return this.viberCallType == 5;
  }

  public boolean isViberCall()
  {
    return this.viberCall;
  }

  public void setAggregatedHash(long paramLong)
  {
    this.aggregatedHash = paramLong;
  }

  public void setCanonizedNumber(String paramString)
  {
    this.canonizedNumber = paramString;
  }

  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }

  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }

  public void setEndReason(int paramInt)
  {
    this.endReason = paramInt;
  }

  public void setLooked(boolean paramBoolean)
  {
    this.looked = paramBoolean;
  }

  public void setMemberId(String paramString)
  {
    this.memberId = paramString;
  }

  public void setNativeCallId(long paramLong)
  {
    this.nativeCallId = paramLong;
  }

  public void setNumber(String paramString)
  {
    this.number = paramString;
  }

  public void setRawConferenceInfo(String paramString)
  {
    this.rawConferenceInfo = paramString;
  }

  public void setStartReason(int paramInt)
  {
    this.startReason = paramInt;
  }

  public void setToken(long paramLong)
  {
    this.token = paramLong;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }

  public void setViberCall(boolean paramBoolean)
  {
    this.viberCall = paramBoolean;
  }

  public void setViberCallType(int paramInt)
  {
    this.viberCallType = paramInt;
  }

  public String toString()
  {
    return "CallEntity [nativeCallId=" + this.nativeCallId + ", number=" + this.number + ", canonizedNumber=" + this.canonizedNumber + ", memberId=" + this.memberId + ", aggregatedHash=" + this.aggregatedHash + ", date=" + this.date + ", duration=" + this.duration + ", token=" + this.token + ", type=" + this.type + ", startReason=" + this.startReason + ", endReason=" + this.endReason + ", viberCallType=" + this.viberCallType + ", looked=" + this.looked + ", viberCall=" + this.viberCall + ", id=" + this.id + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.id);
    paramParcel.writeLong(this.nativeCallId);
    paramParcel.writeString(this.number);
    paramParcel.writeString(this.canonizedNumber);
    paramParcel.writeLong(this.aggregatedHash);
    paramParcel.writeLong(this.date);
    paramParcel.writeLong(this.duration);
    paramParcel.writeLong(this.token);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.startReason);
    paramParcel.writeInt(this.endReason);
    int j;
    if (this.looked)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.viberCall)
        break label141;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.viberCallType);
      paramParcel.writeString(this.rawConferenceInfo);
      return;
      j = 0;
      break;
      label141: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.CallEntity
 * JD-Core Version:    0.6.2
 */