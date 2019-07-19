package com.viber.voip.messages.conversation.community.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.a;
import com.google.d.a.c;

public class Loc
  implements Parcelable
{
  public static final Parcelable.Creator<Loc> CREATOR = new Parcelable.Creator()
  {
    public Loc a(Parcel paramAnonymousParcel)
    {
      return new Loc(paramAnonymousParcel);
    }

    public Loc[] a(int paramAnonymousInt)
    {
      return new Loc[paramAnonymousInt];
    }
  };

  @a
  @c(a="lat")
  private int lat;

  @a
  @c(a="lon")
  private int lon;

  Loc(Parcel paramParcel)
  {
    this.lon = paramParcel.readInt();
    this.lat = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public int getLat()
  {
    return this.lat;
  }

  public int getLon()
  {
    return this.lon;
  }

  public void setLat(int paramInt)
  {
    this.lat = paramInt;
  }

  public void setLon(int paramInt)
  {
    this.lon = paramInt;
  }

  public String toString()
  {
    return "Loc{lon=" + this.lon + ", lat=" + this.lat + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.lon);
    paramParcel.writeInt(this.lat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.search.Loc
 * JD-Core Version:    0.6.2
 */