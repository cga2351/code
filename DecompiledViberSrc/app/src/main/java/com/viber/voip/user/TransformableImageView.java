package com.viber.voip.user;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TransformableImageView extends ImageView
{
  private Matrix drawMatrix = new Matrix();

  public TransformableImageView(Context paramContext)
  {
    super(paramContext);
  }

  public TransformableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TransformableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    int i;
    int j;
    int k;
    int m;
    int n;
    float f2;
    if (getDrawable() != null)
    {
      i = paramCanvas.getSaveCount();
      paramCanvas.save();
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      j = getDrawable().getIntrinsicWidth();
      k = getDrawable().getIntrinsicHeight();
      m = getWidth() - getPaddingLeft() - getPaddingRight();
      n = getHeight() - getPaddingTop() - getPaddingBottom();
      if (j * n <= m * k)
        break label174;
      f2 = n / k;
    }
    for (float f3 = 0.5F * (m - f2 * j); ; f3 = 0.0F)
    {
      this.drawMatrix.setScale(f2, f2);
      this.drawMatrix.postTranslate((int)(f3 + 0.5F), (int)(f1 + 0.5F));
      paramCanvas.concat(this.drawMatrix);
      getDrawable().draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
      label174: f2 = m / j;
      f1 = 0.5F * (n - f2 * k);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.TransformableImageView
 * JD-Core Version:    0.6.2
 */