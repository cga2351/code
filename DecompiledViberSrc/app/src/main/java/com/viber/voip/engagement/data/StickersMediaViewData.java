package com.viber.voip.engagement.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class StickersMediaViewData extends BaseMediaViewData<StickerItem>
{
  public static final Parcelable.Creator<StickersMediaViewData> CREATOR = new Parcelable.Creator()
  {
    public StickersMediaViewData a(Parcel paramAnonymousParcel)
    {
      return new StickersMediaViewData(paramAnonymousParcel);
    }

    public StickersMediaViewData[] a(int paramAnonymousInt)
    {
      return new StickersMediaViewData[paramAnonymousInt];
    }
  };

  public StickersMediaViewData()
  {
  }

  protected StickersMediaViewData(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public StickersMediaViewData(List<StickerItem> paramList, float paramFloat)
  {
    super(paramList, paramFloat);
  }

  protected Parcelable.Creator<StickerItem> getItemCreator()
  {
    return StickerItem.CREATOR;
  }

  public static class StickerItem
    implements Parcelable
  {
    public static final Parcelable.Creator<StickerItem> CREATOR = new Parcelable.Creator()
    {
      public StickersMediaViewData.StickerItem a(Parcel paramAnonymousParcel)
      {
        return new StickersMediaViewData.StickerItem(paramAnonymousParcel);
      }

      public StickersMediaViewData.StickerItem[] a(int paramAnonymousInt)
      {
        return new StickersMediaViewData.StickerItem[paramAnonymousInt];
      }
    };
    private final boolean mAnimated;
    private final int mId;

    public StickerItem(int paramInt, boolean paramBoolean)
    {
      this.mId = paramInt;
      this.mAnimated = paramBoolean;
    }

    protected StickerItem(Parcel paramParcel)
    {
      this.mId = paramParcel.readInt();
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.mAnimated = bool;
        return;
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public int getId()
    {
      return this.mId;
    }

    public boolean isAnimated()
    {
      return this.mAnimated;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mId);
      if (this.mAnimated);
      for (byte b = 1; ; b = 0)
      {
        paramParcel.writeByte(b);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.data.StickersMediaViewData
 * JD-Core Version:    0.6.2
 */