package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;

public class RoundedNinePatchDrawable extends RoundedDrawable
{
  public RoundedNinePatchDrawable(NinePatchDrawable paramNinePatchDrawable)
  {
    super(paramNinePatchDrawable);
  }

  public void draw(Canvas paramCanvas)
  {
    if (!shouldRound())
    {
      super.draw(paramCanvas);
      return;
    }
    updateTransform();
    updatePath();
    paramCanvas.clipPath(this.mPath);
    super.draw(paramCanvas);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.RoundedNinePatchDrawable
 * JD-Core Version:    0.6.2
 */