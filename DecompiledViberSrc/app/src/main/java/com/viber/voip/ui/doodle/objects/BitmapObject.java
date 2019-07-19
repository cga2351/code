package com.viber.voip.ui.doodle.objects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import com.viber.common.d.a;
import com.viber.voip.ui.doodle.objects.b.c;

public abstract class BitmapObject extends MovableObject
{
  private Bitmap mBitmap;
  private Rect mBounds;
  private final Paint mPaint = new Paint(3);

  BitmapObject(Parcel paramParcel)
  {
    super(paramParcel);
  }

  BitmapObject(c paramc)
  {
    super(paramc);
  }

  public void freeResources()
  {
    super.freeResources();
    this.mBitmap = null;
    this.mBounds = null;
  }

  protected Rect getBounds()
  {
    return this.mBounds;
  }

  void onBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
    if (a.g());
    for (int i = 0; ; i = 1)
    {
      this.mBounds = new Rect(0, 0, i + this.mBitmap.getWidth(), i + this.mBitmap.getHeight());
      onBoundsReady();
      return;
    }
  }

  protected void performDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.mBitmap, null, this.mBounds, this.mPaint);
  }

  public String toString()
  {
    return "BitmapObject{mBitmap=" + this.mBitmap + ", mBounds=" + this.mBounds + ", " + super.toString() + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.objects.BitmapObject
 * JD-Core Version:    0.6.2
 */