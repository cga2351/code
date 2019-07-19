package com.viber.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.viber.dexshared.Logger;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.e.c;

public class f extends LinearLayout
{
  private static final Logger a = ViberEnv.getLogger();
  private Rect b;
  private Paint c;
  private Bitmap d;
  private int e;
  private boolean f;
  private c g;

  public f(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public f(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public f(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private Bitmap a(Bitmap paramBitmap)
  {
    if (this.b == null)
      this.b = new Rect();
    this.b.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    return this.g.a(paramBitmap, this.e, true);
  }

  private void a()
  {
    b();
    setDrawingCacheQuality(524288);
    setDrawingCacheEnabled(true);
    Bitmap localBitmap = getDrawingCache();
    if (localBitmap == null)
      return;
    try
    {
      if (this.e != 0)
        localBitmap = a(localBitmap);
      this.d = localBitmap;
      label43: destroyDrawingCache();
      setDrawingCacheEnabled(false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label43;
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.g = c.a(paramContext);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BlurView);
    try
    {
      this.e = localTypedArray.getDimensionPixelSize(R.styleable.BlurView_blurRadius, 0);
      this.f = localTypedArray.getBoolean(R.styleable.BlurView_blurEnabled, false);
      localTypedArray.recycle();
      this.c = new Paint(3);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private void b()
  {
    if (this.d != null)
    {
      this.d.recycle();
      this.d = null;
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.d != null) && (!this.d.isRecycled()))
    {
      paramCanvas.drawBitmap(this.d, null, this.b, this.c);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }

  public int getBlurRadius()
  {
    return this.e;
  }

  protected void onDetachedFromWindow()
  {
    b();
    super.onDetachedFromWindow();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.f) && ((paramBoolean) || (this.d == null)))
      a();
  }

  public void setBlurState(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      if (!this.f)
      {
        b();
        invalidate();
      }
    }
    else
    {
      return;
    }
    requestLayout();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.f
 * JD-Core Version:    0.6.2
 */