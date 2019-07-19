package com.viber.voip.phone.viber.conference.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ConferenceParticipantModel
  implements Parcelable
{
  public static final Parcelable.Creator<ConferenceParticipantModel> CREATOR = new Parcelable.Creator()
  {
    public ConferenceParticipantModel createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ConferenceParticipantModel(paramAnonymousParcel);
    }

    public ConferenceParticipantModel[] newArray(int paramAnonymousInt)
    {
      return new ConferenceParticipantModel[paramAnonymousInt];
    }
  };
  public final ConferenceCallStatus callStatus;
  public final String displayName;
  public final String memberId;
  public final String name;
  public final Uri photoUri;
  public final long statusUpdateTimeMillis;

  protected ConferenceParticipantModel(Parcel paramParcel)
  {
    this.memberId = paramParcel.readString();
    this.displayName = paramParcel.readString();
    this.name = paramParcel.readString();
    this.photoUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.callStatus = ((ConferenceCallStatus)paramParcel.readParcelable(ConferenceCallStatus.class.getClassLoader()));
    this.statusUpdateTimeMillis = paramParcel.readLong();
  }

  public ConferenceParticipantModel(String paramString1, String paramString2, String paramString3, Uri paramUri, ConferenceCallStatus paramConferenceCallStatus, long paramLong)
  {
    this.memberId = paramString1;
    this.displayName = paramString2;
    this.name = paramString3;
    this.photoUri = paramUri;
    this.callStatus = paramConferenceCallStatus;
    this.statusUpdateTimeMillis = paramLong;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "ConferenceParticipantModel{memberId='" + this.memberId + '\'' + ", displayName='" + this.displayName + '\'' + ", name='" + this.name + '\'' + ", photoUri=" + this.photoUri + ", callStatus=" + this.callStatus + ", statusUpdateTimeMillis=" + this.statusUpdateTimeMillis + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.memberId);
    paramParcel.writeString(this.displayName);
    paramParcel.writeString(this.name);
    paramParcel.writeParcelable(this.photoUri, paramInt);
    paramParcel.writeParcelable(this.callStatus, paramInt);
    paramParcel.writeLong(this.statusUpdateTimeMillis);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.model.ConferenceParticipantModel
 * JD-Core Version:    0.6.2
 */