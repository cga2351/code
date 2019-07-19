package com.viber.voip.flatbuffers.model.conference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.a;
import java.util.Arrays;

public class ConferenceInfo
  implements Parcelable, a
{
  public static final Parcelable.Creator<ConferenceInfo> CREATOR = new Parcelable.Creator()
  {
    public ConferenceInfo a(Parcel paramAnonymousParcel)
    {
      return new ConferenceInfo(paramAnonymousParcel);
    }

    public ConferenceInfo[] a(int paramAnonymousInt)
    {
      return new ConferenceInfo[paramAnonymousInt];
    }
  };
  private static final ConferenceParticipant[] NO_PARTICIPANTS = new ConferenceParticipant[0];

  @c(a="isSelfInitiated")
  private boolean isSelfInitiated;

  @c(a="participants")
  private volatile ConferenceParticipant[] participants;

  public ConferenceInfo()
  {
  }

  protected ConferenceInfo(Parcel paramParcel)
  {
    this.participants = ((ConferenceParticipant[])paramParcel.createTypedArray(ConferenceParticipant.CREATOR));
    if (1 == paramParcel.readByte());
    for (boolean bool = true; ; bool = false)
    {
      this.isSelfInitiated = bool;
      return;
    }
  }

  public ConferenceInfo copy()
  {
    ConferenceInfo localConferenceInfo = new ConferenceInfo();
    localConferenceInfo.participants = this.participants;
    localConferenceInfo.isSelfInitiated = this.isSelfInitiated;
    return localConferenceInfo;
  }

  public int describeContents()
  {
    return 0;
  }

  public ConferenceParticipant[] getParticipants()
  {
    if (this.participants != null)
      return this.participants;
    return NO_PARTICIPANTS;
  }

  public boolean isSelfInitiated()
  {
    return this.isSelfInitiated;
  }

  public ConferenceInfo setIsSelfInitiated(boolean paramBoolean)
  {
    this.isSelfInitiated = paramBoolean;
    return this;
  }

  public ConferenceInfo setParticipants(ConferenceParticipant[] paramArrayOfConferenceParticipant)
  {
    this.participants = paramArrayOfConferenceParticipant;
    return this;
  }

  public String toString()
  {
    return "ConferenceInfo{participants=" + Arrays.toString(this.participants) + ", isSelfInitiated=" + this.isSelfInitiated + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.participants, paramInt);
    if (this.isSelfInitiated);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.conference.ConferenceInfo
 * JD-Core Version:    0.6.2
 */