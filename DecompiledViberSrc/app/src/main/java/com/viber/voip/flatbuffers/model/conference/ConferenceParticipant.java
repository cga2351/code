package com.viber.voip.flatbuffers.model.conference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;

public class ConferenceParticipant
  implements Parcelable
{
  public static final Parcelable.Creator<ConferenceParticipant> CREATOR = new Parcelable.Creator()
  {
    public ConferenceParticipant a(Parcel paramAnonymousParcel)
    {
      return new ConferenceParticipant(paramAnonymousParcel);
    }

    public ConferenceParticipant[] a(int paramAnonymousInt)
    {
      return new ConferenceParticipant[paramAnonymousInt];
    }
  };

  @c(a="image")
  private String image;

  @c(a="memberId")
  private String memberId;

  @c(a="name")
  private String name;

  public ConferenceParticipant()
  {
  }

  protected ConferenceParticipant(Parcel paramParcel)
  {
    this.memberId = paramParcel.readString();
    this.name = paramParcel.readString();
    this.image = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getImage()
  {
    return this.image;
  }

  public String getMemberId()
  {
    return this.memberId;
  }

  public String getName()
  {
    return this.name;
  }

  public void setImage(String paramString)
  {
    this.image = paramString;
  }

  public void setMemberId(String paramString)
  {
    this.memberId = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public String toString()
  {
    return "ConferenceParticipant{memberId='" + this.memberId + '\'' + ", name='" + this.name + '\'' + ", image='" + this.image + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.memberId);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.image);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.conference.ConferenceParticipant
 * JD-Core Version:    0.6.2
 */