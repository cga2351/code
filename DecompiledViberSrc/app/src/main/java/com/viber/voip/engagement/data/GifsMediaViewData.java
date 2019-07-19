package com.viber.voip.engagement.data;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class GifsMediaViewData extends BaseMediaViewData<GifItem>
{
  public static final Parcelable.Creator<GifsMediaViewData> CREATOR = new Parcelable.Creator()
  {
    public GifsMediaViewData a(Parcel paramAnonymousParcel)
    {
      return new GifsMediaViewData(paramAnonymousParcel);
    }

    public GifsMediaViewData[] a(int paramAnonymousInt)
    {
      return new GifsMediaViewData[paramAnonymousInt];
    }
  };

  public GifsMediaViewData()
  {
  }

  protected GifsMediaViewData(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public GifsMediaViewData(List<GifItem> paramList, float paramFloat)
  {
    super(paramList, paramFloat);
  }

  protected Parcelable.Creator<GifItem> getItemCreator()
  {
    return GifItem.CREATOR;
  }

  public static class GifItem
    implements Parcelable
  {
    public static final Parcelable.Creator<GifItem> CREATOR = new Parcelable.Creator()
    {
      public GifsMediaViewData.GifItem a(Parcel paramAnonymousParcel)
      {
        return new GifsMediaViewData.GifItem(paramAnonymousParcel);
      }

      public GifsMediaViewData.GifItem[] a(int paramAnonymousInt)
      {
        return new GifsMediaViewData.GifItem[paramAnonymousInt];
      }
    };
    private final int mHeight;
    private final Uri mUrl;
    private final int mWidth;

    public GifItem(Uri paramUri, int paramInt1, int paramInt2)
    {
      this.mUrl = paramUri;
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }

    protected GifItem(Parcel paramParcel)
    {
      this.mUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      this.mWidth = paramParcel.readInt();
      this.mHeight = paramParcel.readInt();
    }

    public int describeContents()
    {
      return 0;
    }

    public int getHeight()
    {
      return this.mHeight;
    }

    public Uri getUrl()
    {
      return this.mUrl;
    }

    public int getWidth()
    {
      return this.mWidth;
    }

    public String toString()
    {
      return "GifItem{mUrl=" + this.mUrl + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.mUrl, paramInt);
      paramParcel.writeInt(this.mWidth);
      paramParcel.writeInt(this.mHeight);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.data.GifsMediaViewData
 * JD-Core Version:    0.6.2
 */