package com.viber.jni;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class CMissedCall
  implements Parcelable
{
  public static final Parcelable.Creator<CMissedCall> CREATOR = new Parcelable.Creator()
  {
    public CMissedCall createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CMissedCall(paramAnonymousParcel);
    }

    public CMissedCall[] newArray(int paramAnonymousInt)
    {
      return new CMissedCall[paramAnonymousInt];
    }
  };
  private final long callToken;
  private final int callType;
  private final long calledAt;
  private final String conferenceId;
  private final String[] conferenceMemberIDs;
  private final int conferenceState;
  private final int duration;
  private final int flags;
  private final String memberId;
  private final String phoneNumber;
  private final String toVln;

  public CMissedCall(Parcel paramParcel)
  {
    this.phoneNumber = paramParcel.readString();
    this.memberId = paramParcel.readString();
    this.calledAt = paramParcel.readLong();
    this.callToken = paramParcel.readLong();
    this.flags = paramParcel.readInt();
    this.toVln = paramParcel.readString();
    this.callType = paramParcel.readInt();
    this.conferenceId = paramParcel.readString();
    this.conferenceState = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.conferenceMemberIDs = paramParcel.createStringArray();
    paramParcel.readStringArray(this.conferenceMemberIDs);
  }

  public CMissedCall(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4, String[] paramArrayOfString)
  {
    this.phoneNumber = paramString1;
    this.memberId = paramString2;
    this.calledAt = paramLong1;
    this.callToken = paramLong2;
    this.flags = paramInt1;
    this.toVln = paramString3;
    this.callType = paramInt2;
    this.conferenceId = paramString4;
    this.conferenceState = paramInt3;
    this.duration = paramInt4;
    this.conferenceMemberIDs = paramArrayOfString;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getCallType()
  {
    return this.callType;
  }

  public long getCalledAt()
  {
    return this.calledAt;
  }

  public String getConferenceId()
  {
    return this.conferenceId;
  }

  public String[] getConferenceMemberIDs()
  {
    return this.conferenceMemberIDs;
  }

  public int getConferenceState()
  {
    return this.conferenceState;
  }

  public int getDuration()
  {
    return this.duration;
  }

  public int getFlags()
  {
    return this.flags;
  }

  public String getMemberId()
  {
    return this.memberId;
  }

  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }

  public String getToVln()
  {
    return this.toVln;
  }

  public long getToken()
  {
    return this.callToken;
  }

  public String toString()
  {
    return "CMissedCall{phoneNumber='" + this.phoneNumber + '\'' + ", memberId='" + this.memberId + '\'' + ", calledAt=" + this.calledAt + ", callToken=" + this.callToken + ", flags=" + this.flags + ", toVln=" + this.toVln + ", callType=" + this.callType + ", conferenceId='" + this.conferenceId + '\'' + ", conferenceState=" + this.conferenceState + ", duration=" + this.duration + ", conferenceMemberIDs=" + Arrays.toString(this.conferenceMemberIDs) + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.phoneNumber);
    paramParcel.writeString(this.memberId);
    paramParcel.writeLong(this.calledAt);
    paramParcel.writeLong(this.callToken);
    paramParcel.writeInt(this.flags);
    paramParcel.writeString(this.toVln);
    paramParcel.writeInt(this.callType);
    paramParcel.writeString(this.conferenceId);
    paramParcel.writeInt(this.conferenceState);
    paramParcel.writeInt(this.duration);
    paramParcel.writeStringArray(this.conferenceMemberIDs);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CMissedCall
 * JD-Core Version:    0.6.2
 */