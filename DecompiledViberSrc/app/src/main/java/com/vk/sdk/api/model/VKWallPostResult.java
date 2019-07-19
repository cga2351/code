package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class VKWallPostResult extends VKApiModel
{
  public static Parcelable.Creator<VKWallPostResult> CREATOR = new Parcelable.Creator()
  {
    public VKWallPostResult createFromParcel(Parcel paramAnonymousParcel)
    {
      VKWallPostResult localVKWallPostResult = new VKWallPostResult();
      localVKWallPostResult.post_id = paramAnonymousParcel.readInt();
      return localVKWallPostResult;
    }

    public VKWallPostResult[] newArray(int paramAnonymousInt)
    {
      return new VKWallPostResult[paramAnonymousInt];
    }
  };
  public int post_id;

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.post_id);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.model.VKWallPostResult
 * JD-Core Version:    0.6.2
 */