package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;

public class ab extends LinearLayout
{
  private Bitmap a;
  private Paint b;
  private Paint c;
  private float d;
  private float e;

  public ab(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }

  private Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ALPHA_8);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-1);
    localCanvas.drawRect(0.0F, 0.0F, paramInt1, paramInt2, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    localCanvas.drawRoundRect(new RectF(0.0F, this.e, paramInt1, paramInt2), this.d, this.d, localPaint);
    return localBitmap;
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.d = TypedValue.applyDimension(1, 20.0F, paramContext.getResources().getDisplayMetrics());
    this.b = new Paint(1);
    this.c = new Paint(3);
    this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    setWillNotDraw(false);
    setLayerType(1, null);
  }

  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramCanvas.getWidth(), paramCanvas.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    super.draw(localCanvas);
    if (this.a == null)
      this.a = a(paramCanvas.getWidth(), paramCanvas.getHeight());
    localCanvas.drawBitmap(this.a, 0.0F, 0.0F, this.c);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.b);
  }

  public void setOffset(int paramInt)
  {
    this.e = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ab
 * JD-Core Version:    0.6.2
 */