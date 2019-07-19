package com.viber.voip.messages.ui.media;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ComposeDataContainer
  implements Parcelable
{
  public static final Parcelable.Creator<ComposeDataContainer> CREATOR = new Parcelable.Creator()
  {
    public ComposeDataContainer a(Parcel paramAnonymousParcel)
    {
      return new ComposeDataContainer(paramAnonymousParcel, null);
    }

    public ComposeDataContainer[] a(int paramAnonymousInt)
    {
      return new ComposeDataContainer[paramAnonymousInt];
    }
  };
  public String contactName;
  public String contactPhoneticName;
  public String photoId;
  public Uri photoUri;
  public String selectedNumber;
  public String viberNumber;

  public ComposeDataContainer()
  {
  }

  private ComposeDataContainer(Parcel paramParcel)
  {
    this.contactName = paramParcel.readString();
    this.contactPhoneticName = paramParcel.readString();
    this.selectedNumber = paramParcel.readString();
    this.viberNumber = paramParcel.readString();
    this.photoUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.photoId = paramParcel.readString();
  }

  public ComposeDataContainer(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5)
  {
    this.contactName = paramString1;
    this.contactPhoneticName = paramString2;
    this.selectedNumber = paramString3;
    this.viberNumber = paramString4;
    this.photoUri = paramUri;
    this.photoId = paramString5;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "ComposeDataContainer{contactName=" + this.contactName + "contactPhoneticName=" + this.contactPhoneticName + ", selectedNumber=" + this.selectedNumber + ", viberNumber=" + this.viberNumber + ", photoUri=" + this.photoUri + ", photoId=" + this.photoId + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.contactName);
    paramParcel.writeString(this.contactPhoneticName);
    paramParcel.writeString(this.selectedNumber);
    paramParcel.writeString(this.viberNumber);
    paramParcel.writeParcelable(this.photoUri, paramInt);
    paramParcel.writeString(this.photoId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.ComposeDataContainer
 * JD-Core Version:    0.6.2
 */