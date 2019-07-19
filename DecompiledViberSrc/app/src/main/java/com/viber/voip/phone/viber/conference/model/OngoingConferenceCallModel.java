package com.viber.voip.phone.viber.conference.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;

public class OngoingConferenceCallModel
  implements Parcelable
{
  public static final Parcelable.Creator<OngoingConferenceCallModel> CREATOR = new Parcelable.Creator()
  {
    public OngoingConferenceCallModel createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OngoingConferenceCallModel(paramAnonymousParcel);
    }

    public OngoingConferenceCallModel[] newArray(int paramAnonymousInt)
    {
      return new OngoingConferenceCallModel[paramAnonymousInt];
    }
  };
  public final long callToken;
  public final ConferenceInfo conferenceInfo;
  public final long conversationId;
  public final long startTimeMillis;

  public OngoingConferenceCallModel(long paramLong1, long paramLong2, long paramLong3, ConferenceInfo paramConferenceInfo)
  {
    this.conversationId = paramLong1;
    this.callToken = paramLong2;
    this.startTimeMillis = paramLong3;
    this.conferenceInfo = paramConferenceInfo;
  }

  protected OngoingConferenceCallModel(Parcel paramParcel)
  {
    this.conversationId = paramParcel.readLong();
    this.callToken = paramParcel.readLong();
    this.startTimeMillis = paramParcel.readLong();
    this.conferenceInfo = ((ConferenceInfo)paramParcel.readParcelable(ConferenceInfo.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "OngoingConferenceCallModel{conversationId=" + this.conversationId + ", callToken=" + this.callToken + ", startTimeMillis=" + this.startTimeMillis + ", conferenceInfo=" + this.conferenceInfo + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.conversationId);
    paramParcel.writeLong(this.callToken);
    paramParcel.writeLong(this.startTimeMillis);
    paramParcel.writeParcelable(this.conferenceInfo, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel
 * JD-Core Version:    0.6.2
 */