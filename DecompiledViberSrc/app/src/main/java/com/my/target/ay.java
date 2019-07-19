package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;

public class ay extends View
{
  private static final Paint a = new Paint();
  private int b;
  private float c;
  private float d;
  private Bitmap e;
  private boolean f;

  static
  {
    a.setAntiAlias(true);
    a.setStyle(Paint.Style.FILL);
  }

  public ay(Context paramContext)
  {
    super(paramContext);
  }

  private Path a(int paramInt1, float paramFloat, int paramInt2)
  {
    Path localPath = new Path();
    localPath.setFillType(Path.FillType.EVEN_ODD);
    for (int i = 0; i < paramInt2; i++)
    {
      float f1 = paramFloat + paramInt1 + 2.0F * (paramFloat * i) + i * this.c;
      float f2 = paramFloat * 0.45F;
      localPath.moveTo((float)(f1 + paramFloat * Math.sin(0.0D)), 2.0F * paramFloat - (float)(paramFloat + paramFloat * Math.cos(0.0D)));
      localPath.lineTo((float)(f1 + f2 * Math.sin(0.6283185307179586D)), 2.0F * paramFloat - (float)(paramFloat + f2 * Math.cos(0.6283185307179586D)));
      for (int j = 1; j < 5; j++)
      {
        localPath.lineTo((float)(f1 + paramFloat * Math.sin(2.0D * 0.6283185307179586D * j)), 2.0F * paramFloat - (float)(paramFloat + paramFloat * Math.cos(2.0D * 0.6283185307179586D * j)));
        localPath.lineTo((float)(f1 + f2 * Math.sin(0.6283185307179586D + 2.0D * 0.6283185307179586D * j)), 2.0F * paramFloat - (float)(paramFloat + f2 * Math.cos(0.6283185307179586D + 2.0D * 0.6283185307179586D * j)));
      }
    }
    localPath.close();
    return localPath;
  }

  private void a()
  {
    if (this.b <= 0)
      return;
    int i = (int)Math.floor(this.d);
    int j = (int)Math.ceil(5.0F - this.d);
    int k;
    if (this.d - i >= 0.2F)
      k = 1;
    try
    {
      while (true)
      {
        this.e = Bitmap.createBitmap((int)(5.0F * (this.b + this.c)), this.b, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(this.e);
        a(0, this.b, -552162, localCanvas, i);
        int m = (int)(0 + (this.b + this.c) * i);
        a(m, this.b, -3355444, localCanvas, j);
        if (k != 0)
          a(m, this.b, (float)(this.d - Math.floor(this.d)), localCanvas);
        invalidate();
        this.f = false;
        return;
        k = 0;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      dp.a("Unable to create rating bitmap because of OOME");
    }
  }

  private void a(int paramInt1, int paramInt2, float paramFloat, Canvas paramCanvas)
  {
    a.setColor(-552162);
    Path localPath = a(0, paramInt2 / 2, 1);
    Rect localRect = new Rect(paramInt1, 0, (int)(paramInt1 + paramFloat * paramInt2), paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap((int)(paramFloat * paramInt2), paramInt2, Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap).drawPath(localPath, a);
    paramCanvas.drawBitmap(localBitmap, null, localRect, a);
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, Canvas paramCanvas, int paramInt4)
  {
    a.setColor(paramInt3);
    paramCanvas.drawPath(a(paramInt1, paramInt2 / 2, paramInt4), a);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.e == null)
    {
      if ((this.b > 0) && (!this.f))
      {
        this.f = true;
        post(new Runnable()
        {
          public void run()
          {
            ay.a(ay.this);
          }
        });
      }
      return;
    }
    paramCanvas.drawBitmap(this.e, 0.0F, 0.0F, null);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    if (this.b > 0)
      i = this.b;
    while (true)
    {
      setMeasuredDimension((int)(i * 5 + 4.0F * this.c), i);
      return;
      i = View.MeasureSpec.getSize(paramInt2);
      this.b = i;
    }
  }

  public void setRating(float paramFloat)
  {
    setContentDescription(Float.toString(paramFloat));
    if ((paramFloat > 5.0F) || (paramFloat < 0.0F))
      dp.a("Rating is out of bounds: " + paramFloat);
    for (this.d = 0.0F; ; this.d = paramFloat)
    {
      invalidate();
      return;
    }
  }

  public void setStarSize(int paramInt)
  {
    this.b = paramInt;
  }

  public void setStarsPadding(float paramFloat)
  {
    this.c = paramFloat;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ay
 * JD-Core Version:    0.6.2
 */