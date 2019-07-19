package com.viber.voip.ui.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class a extends ImageSpan
{
  public a(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    Rect localRect1 = paramCanvas.getClipBounds();
    Rect localRect2 = getDrawable().getBounds();
    int i = localRect2.right - localRect2.left;
    int j = (int)paramFloat;
    if ((i + j <= localRect1.right) && (j >= localRect1.left))
      super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.style.a
 * JD-Core Version:    0.6.2
 */