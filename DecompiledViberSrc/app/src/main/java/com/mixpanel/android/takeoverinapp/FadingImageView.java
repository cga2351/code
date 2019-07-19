package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class FadingImageView extends ImageView
{
  private Matrix a;
  private Paint b;
  private Shader c;
  private Paint d;
  private Shader e;
  private int f;
  private int g;
  private boolean h;

  public FadingImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public FadingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public FadingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    this.a = new Matrix();
    this.b = new Paint();
    this.c = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, new int[] { -16777216, -16777216, -452984832, 0 }, new float[] { 0.0F, 0.2F, 0.4F, 1.0F }, Shader.TileMode.CLAMP);
    this.b.setShader(this.c);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.d = new Paint();
    this.e = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, new int[] { 0, 0, -16777216, -16777216 }, new float[] { 0.0F, 0.85F, 0.98F, 1.0F }, Shader.TileMode.CLAMP);
    this.d.setShader(this.e);
    this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
  }

  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.h)
    {
      Rect localRect = paramCanvas.getClipBounds();
      int i = paramCanvas.saveLayer(0.0F, 0.0F, localRect.width(), localRect.height(), null, 31);
      super.draw(paramCanvas);
      paramCanvas.drawRect(0.0F, 0.0F, this.g, this.f, this.b);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.h)
    {
      this.f = getHeight();
      this.g = getWidth();
      int i = View.MeasureSpec.getSize(paramInt2);
      this.a.setScale(1.0F, i);
      this.c.setLocalMatrix(this.a);
      this.e.setLocalMatrix(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.takeoverinapp.FadingImageView
 * JD-Core Version:    0.6.2
 */