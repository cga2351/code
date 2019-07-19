package com.viber.voip.ui.doodle.objects;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.b.a.a.a.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.f;
import com.viber.voip.stickers.f.e;
import com.viber.voip.stickers.w;
import com.viber.voip.ui.doodle.objects.b.d;

public class StickerBitmapObject extends BitmapObject
{
  public static final Parcelable.Creator<StickerBitmapObject> CREATOR = new Parcelable.Creator()
  {
    public StickerBitmapObject a(Parcel paramAnonymousParcel)
    {
      return new StickerBitmapObject(paramAnonymousParcel);
    }

    public StickerBitmapObject[] a(int paramAnonymousInt)
    {
      return new StickerBitmapObject[paramAnonymousInt];
    }
  };
  private static final long STICKER_BITMAP_OBJECT_CONTENT_SIZE_IN_BYTES = 4L * com.viber.voip.ui.doodle.extras.i.a;
  private b mBitmapHolder;
  private Object mCancelationToken;
  protected final int mPackageId;
  private f mStickerBitmapLoader;
  protected final int mStickerId;
  protected final int mStickerMenuPortHeight;
  protected final int mStickerMenuPortWidth;
  protected final String mStickerPath;

  StickerBitmapObject(Parcel paramParcel)
  {
    super(paramParcel);
    this.mStickerId = paramParcel.readInt();
    this.mPackageId = paramParcel.readInt();
    this.mStickerPath = paramParcel.readString();
    this.mStickerMenuPortWidth = paramParcel.readInt();
    this.mStickerMenuPortHeight = paramParcel.readInt();
    init();
  }

  public StickerBitmapObject(d paramd)
  {
    super(paramd);
    Sticker localSticker = paramd.e();
    this.mStickerId = localSticker.id;
    this.mPackageId = localSticker.packageId;
    this.mStickerPath = localSticker.getOrigPath();
    this.mStickerMenuPortWidth = localSticker.getMenuPortWidth();
    this.mStickerMenuPortHeight = localSticker.getMenuPortHeight();
    init();
  }

  private int getStickerIdToLoad()
  {
    return this.mStickerId;
  }

  protected void cancelPotentialWork(Object paramObject)
  {
    this.mStickerBitmapLoader.b(paramObject);
  }

  public void freeResources()
  {
    super.freeResources();
    if (this.mCancelationToken != null)
    {
      cancelPotentialWork(this.mCancelationToken);
      this.mCancelationToken = null;
    }
    if (this.mBitmapHolder != null)
    {
      this.mBitmapHolder.d();
      this.mBitmapHolder = null;
    }
  }

  public int getPackageId()
  {
    return this.mPackageId;
  }

  public long getSavedStateSizeInBytes()
  {
    return super.getSavedStateSizeInBytes() + STICKER_BITMAP_OBJECT_CONTENT_SIZE_IN_BYTES + com.viber.voip.ui.doodle.extras.i.a(this.mStickerPath);
  }

  public int getStickerId()
  {
    return this.mStickerId;
  }

  public BaseObject.a getType()
  {
    return BaseObject.a.b;
  }

  void init()
  {
    this.mStickerBitmapLoader = com.viber.voip.stickers.i.a().e();
  }

  void onBitmap(Bitmap paramBitmap)
  {
    if (isDestroyed());
    do
    {
      return;
      if (paramBitmap == null)
      {
        this.mPreparationCallback.c(this);
        return;
      }
      super.onBitmap(paramBitmap);
    }
    while (this.mPreparationCallback == null);
    this.mPreparationCallback.a(this);
  }

  Object prepareBitmap()
  {
    return this.mStickerBitmapLoader.a(getStickerIdToLoad(), false, false, true, w.a, new f.e()
    {
      public void a(Sticker paramAnonymousSticker, Object paramAnonymousObject)
      {
        StickerBitmapObject.this.onBitmap(null);
      }

      public void a(Sticker paramAnonymousSticker, Object paramAnonymousObject, b paramAnonymousb)
      {
        StickerBitmapObject.access$002(StickerBitmapObject.this, paramAnonymousb);
        StickerBitmapObject.this.mBitmapHolder.b();
        StickerBitmapObject.this.onBitmap(StickerBitmapObject.this.mBitmapHolder.a());
      }
    });
  }

  public void setPreparationCallback(BaseObject.b paramb)
  {
    super.setPreparationCallback(paramb);
    if (this.mCancelationToken == null)
      this.mCancelationToken = prepareBitmap();
    if (canBeDrawn())
      paramb.a(this);
  }

  public String toString()
  {
    return "StickerBitmapObject{mStickerId=" + this.mStickerId + ", mPackageId=" + this.mPackageId + ", mStickerPath='" + this.mStickerPath + '\'' + ", mStickerMenuPortWidth=" + this.mStickerMenuPortWidth + ", mStickerMenuPortHeight=" + this.mStickerMenuPortHeight + ", mCancelationToken=" + this.mCancelationToken + ", mStickerBitmapLoader=" + this.mStickerBitmapLoader + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mStickerId);
    paramParcel.writeInt(this.mPackageId);
    paramParcel.writeString(this.mStickerPath);
    paramParcel.writeInt(this.mStickerMenuPortWidth);
    paramParcel.writeInt(this.mStickerMenuPortHeight);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.StickerBitmapObject
 * JD-Core Version:    0.6.2
 */