package com.viber.voip.ui.doodle.objects;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.viber.voip.av.e;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.x;
import com.viber.voip.ui.doodle.objects.b.d;

public class StickerSvgObject extends StickerBitmapObject
{
  public static final Parcelable.Creator<StickerSvgObject> CREATOR = new Parcelable.Creator()
  {
    public StickerSvgObject a(Parcel paramAnonymousParcel)
    {
      return new StickerSvgObject(paramAnonymousParcel, null);
    }

    public StickerSvgObject[] a(int paramAnonymousInt)
    {
      return new StickerSvgObject[paramAnonymousInt];
    }
  };
  private x mStickerSvgController;
  private Handler mUiHandler;
  private Handler mWorker;

  private StickerSvgObject(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public StickerSvgObject(d paramd)
  {
    super(paramd);
  }

  private int getStickerWidthLoad()
  {
    return this.mStickerMenuPortWidth;
  }

  protected void cancelPotentialWork(Object paramObject)
  {
    this.mWorker.removeCallbacksAndMessages(paramObject);
    this.mUiHandler.removeCallbacksAndMessages(paramObject);
  }

  void init()
  {
    this.mStickerSvgController = i.a().A();
    this.mWorker = av.e.f.a();
    this.mUiHandler = av.e.a.a();
  }

  Object prepareBitmap()
  {
    final Object localObject = new Object();
    this.mWorker.postAtTime(new Runnable()
    {
      public void run()
      {
        final Bitmap localBitmap = StickerSvgObject.this.mStickerSvgController.a(StickerSvgObject.this.mStickerPath, StickerSvgObject.this.getStickerWidthLoad(), StickerSvgObject.this.mStickerMenuPortHeight);
        StickerSvgObject.this.mUiHandler.postAtTime(new Runnable()
        {
          public void run()
          {
            StickerSvgObject.this.onBitmap(localBitmap);
          }
        }
        , localObject, SystemClock.uptimeMillis());
      }
    }
    , localObject, SystemClock.uptimeMillis());
    return localObject;
  }

  public String toString()
  {
    return "StickerSvgObject{" + super.toString() + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.StickerSvgObject
 * JD-Core Version:    0.6.2
 */