package com.viber.voip.gallery;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.m;
import com.viber.voip.util.e.j;

public class GalleryItem
  implements Parcelable
{
  public static final Parcelable.Creator<GalleryItem> CREATOR = new Parcelable.Creator()
  {
    public GalleryItem a(Parcel paramAnonymousParcel)
    {
      return new GalleryItem(paramAnonymousParcel);
    }

    public GalleryItem[] a(int paramAnonymousInt)
    {
      return new GalleryItem[paramAnonymousInt];
    }
  };
  private String description;
  private long duration;
  private Uri itemUri;
  private int mediaType;
  private String mimeType;
  private Uri originalUri;

  public GalleryItem()
  {
  }

  GalleryItem(Parcel paramParcel)
  {
    this.itemUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.originalUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.description = paramParcel.readString();
    this.mediaType = paramParcel.readInt();
    this.mimeType = paramParcel.readString();
    this.duration = paramParcel.readLong();
  }

  public static GalleryItem from(Uri paramUri, String paramString)
  {
    GalleryItem localGalleryItem = new GalleryItem();
    localGalleryItem.itemUri = paramUri;
    localGalleryItem.originalUri = paramUri;
    if (j.e(paramUri));
    for (int i = 3; ; i = 1)
    {
      localGalleryItem.mediaType = i;
      localGalleryItem.mimeType = paramString;
      return localGalleryItem;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    GalleryItem localGalleryItem;
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (!(paramObject instanceof GalleryItem))
          return false;
        localGalleryItem = (GalleryItem)paramObject;
        if (this.originalUri != null)
          break;
      }
      while (localGalleryItem.originalUri == null);
      return false;
    }
    while (this.originalUri.equals(localGalleryItem.originalUri));
    return false;
  }

  public String getDescription()
  {
    return this.description;
  }

  public long getDuration()
  {
    return this.duration;
  }

  public Uri getItemUri()
  {
    return this.itemUri;
  }

  public int getMediaType()
  {
    return this.mediaType;
  }

  public String getMimeType()
  {
    return this.mimeType;
  }

  public Uri getOriginalUri()
  {
    return this.originalUri;
  }

  public boolean hasDoodle()
  {
    return (this.itemUri != null) && (!this.itemUri.equals(this.originalUri));
  }

  public int hashCode()
  {
    if (this.originalUri == null);
    for (int i = 0; ; i = this.originalUri.hashCode())
      return i + 31;
  }

  public boolean isGif()
  {
    return m.e(this.mimeType);
  }

  public boolean isImage()
  {
    return this.mediaType == 1;
  }

  public boolean isVideo()
  {
    return this.mediaType == 3;
  }

  public void setDescription(String paramString)
  {
    this.description = paramString;
  }

  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }

  public void setItemUri(Uri paramUri)
  {
    this.itemUri = paramUri;
  }

  public void setMediaType(int paramInt)
  {
    this.mediaType = paramInt;
  }

  public void setOriginalUri(Uri paramUri)
  {
    this.originalUri = paramUri;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GalleryItem [itemUri=").append(this.itemUri).append(", originalUri=").append(this.originalUri).append(", description=").append(this.description).append(", mimeType=").append(this.mimeType).append(", videoDuration=").append(this.duration).append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.itemUri, 0);
    paramParcel.writeParcelable(this.originalUri, 0);
    paramParcel.writeString(this.description);
    paramParcel.writeInt(this.mediaType);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeLong(this.duration);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.GalleryItem
 * JD-Core Version:    0.6.2
 */