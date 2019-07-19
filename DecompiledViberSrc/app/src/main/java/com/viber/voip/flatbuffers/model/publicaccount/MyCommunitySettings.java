package com.viber.voip.flatbuffers.model.publicaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import com.viber.voip.flatbuffers.model.a;

public class MyCommunitySettings
  implements Parcelable, a
{
  public static final Parcelable.Creator<MyCommunitySettings> CREATOR = new Parcelable.Creator()
  {
    public MyCommunitySettings a(Parcel paramAnonymousParcel)
    {
      return new MyCommunitySettings(paramAnonymousParcel);
    }

    public MyCommunitySettings[] a(int paramAnonymousInt)
    {
      return new MyCommunitySettings[paramAnonymousInt];
    }
  };

  @c(a="M2M")
  private boolean mAllowM2M;

  public MyCommunitySettings()
  {
  }

  protected MyCommunitySettings(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mAllowM2M = bool;
      return;
    }
  }

  public MyCommunitySettings(boolean paramBoolean)
  {
    this.mAllowM2M = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MyCommunitySettings localMyCommunitySettings;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localMyCommunitySettings = (MyCommunitySettings)paramObject;
    }
    while (this.mAllowM2M == localMyCommunitySettings.mAllowM2M);
    return false;
  }

  public int hashCode()
  {
    if (this.mAllowM2M)
      return 1;
    return 0;
  }

  public boolean isAllowM2M()
  {
    return this.mAllowM2M;
  }

  public String toString()
  {
    return "MyCommunitySettings{mAllowM2M=" + this.mAllowM2M + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mAllowM2M);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.publicaccount.MyCommunitySettings
 * JD-Core Version:    0.6.2
 */