package com.viber.voip.messages.shopchat;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OpenShopChatPanelData
  implements Parcelable
{
  public static final Parcelable.Creator<OpenShopChatPanelData> CREATOR = new Parcelable.Creator()
  {
    public OpenShopChatPanelData a(Parcel paramAnonymousParcel)
    {
      return new OpenShopChatPanelData(paramAnonymousParcel);
    }

    public OpenShopChatPanelData[] a(int paramAnonymousInt)
    {
      return new OpenShopChatPanelData[paramAnonymousInt];
    }
  };
  public final long groupId;
  public final String memberId;
  public final String productId;

  protected OpenShopChatPanelData(Parcel paramParcel)
  {
    this.memberId = paramParcel.readString();
    this.groupId = paramParcel.readLong();
    this.productId = paramParcel.readString();
  }

  public OpenShopChatPanelData(String paramString1, long paramLong, String paramString2)
  {
    this.memberId = paramString1;
    this.groupId = paramLong;
    this.productId = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.memberId);
    paramParcel.writeLong(this.groupId);
    paramParcel.writeString(this.productId);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.shopchat.OpenShopChatPanelData
 * JD-Core Version:    0.6.2
 */