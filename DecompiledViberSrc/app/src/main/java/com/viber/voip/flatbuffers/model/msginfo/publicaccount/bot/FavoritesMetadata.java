package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FavoritesMetadata
  implements Parcelable
{
  public static final Parcelable.Creator<FavoritesMetadata> CREATOR = new Parcelable.Creator()
  {
    public FavoritesMetadata a(Parcel paramAnonymousParcel)
    {
      return new FavoritesMetadata(paramAnonymousParcel);
    }

    public FavoritesMetadata[] a(int paramAnonymousInt)
    {
      return new FavoritesMetadata[paramAnonymousInt];
    }
  };
  private String mMetadata;

  public FavoritesMetadata()
  {
  }

  protected FavoritesMetadata(Parcel paramParcel)
  {
    this.mMetadata = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FavoritesMetadata localFavoritesMetadata;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFavoritesMetadata = (FavoritesMetadata)paramObject;
      if (this.mMetadata != null)
        return this.mMetadata.equals(localFavoritesMetadata.mMetadata);
    }
    while (localFavoritesMetadata.mMetadata == null);
    return false;
  }

  public String getMetadata()
  {
    return this.mMetadata;
  }

  public int hashCode()
  {
    if (this.mMetadata != null)
      return this.mMetadata.hashCode();
    return 0;
  }

  public void setMetadata(String paramString)
  {
    this.mMetadata = paramString;
  }

  public String toString()
  {
    return "FavoritesMetadata{mMetadata='" + this.mMetadata + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mMetadata);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.FavoritesMetadata
 * JD-Core Version:    0.6.2
 */