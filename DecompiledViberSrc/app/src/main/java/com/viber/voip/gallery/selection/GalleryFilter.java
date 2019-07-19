package com.viber.voip.gallery.selection;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.R.string;

public enum GalleryFilter
  implements Parcelable
{
  public static final Parcelable.Creator<GalleryFilter> CREATOR = new Parcelable.Creator()
  {
    public GalleryFilter a(Parcel paramAnonymousParcel)
    {
      return GalleryFilter.values()[paramAnonymousParcel.readInt()];
    }

    public GalleryFilter[] a(int paramAnonymousInt)
    {
      return new GalleryFilter[paramAnonymousInt];
    }
  };
  private final int mLaberRes;

  static
  {
    ALL_MEDIA = new GalleryFilter("ALL_MEDIA", 2, R.string.media);
    GalleryFilter[] arrayOfGalleryFilter = new GalleryFilter[3];
    arrayOfGalleryFilter[0] = IMAGE;
    arrayOfGalleryFilter[1] = VIDEO;
    arrayOfGalleryFilter[2] = ALL_MEDIA;
  }

  private GalleryFilter(int paramInt)
  {
    this.mLaberRes = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getLabel(Context paramContext)
  {
    return paramContext.getString(this.mLaberRes);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ordinal());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.GalleryFilter
 * JD-Core Version:    0.6.2
 */