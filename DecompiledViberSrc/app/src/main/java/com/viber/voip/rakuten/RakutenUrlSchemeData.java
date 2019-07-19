package com.viber.voip.rakuten;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RakutenUrlSchemeData
  implements Parcelable
{
  public static final Parcelable.Creator<RakutenUrlSchemeData> CREATOR = new Parcelable.Creator()
  {
    public RakutenUrlSchemeData a(Parcel paramAnonymousParcel)
    {
      return new RakutenUrlSchemeData(paramAnonymousParcel);
    }

    public RakutenUrlSchemeData[] a(int paramAnonymousInt)
    {
      return new RakutenUrlSchemeData[paramAnonymousInt];
    }
  };
  static final String RAKUTEN_URI_AUTHORITY = "setrtoken";
  public String rToken;
  public String referral;

  public RakutenUrlSchemeData(Uri paramUri)
  {
    List localList1 = paramUri.getQueryParameters("t");
    if ((localList1 != null) && (!localList1.isEmpty()))
      this.rToken = ((String)localList1.get(0));
    List localList2 = paramUri.getQueryParameters("r");
    if ((localList2 != null) && (!localList2.isEmpty()))
      this.referral = ((String)localList2.get(0));
  }

  public RakutenUrlSchemeData(Parcel paramParcel)
  {
    this.rToken = paramParcel.readString();
    this.referral = paramParcel.readString();
  }

  public RakutenUrlSchemeData(String paramString1, String paramString2)
  {
    this.rToken = paramString1;
    this.referral = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.rToken);
    paramParcel.writeString(this.referral);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.rakuten.RakutenUrlSchemeData
 * JD-Core Version:    0.6.2
 */