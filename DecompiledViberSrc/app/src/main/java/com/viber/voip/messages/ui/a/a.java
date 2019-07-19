package com.viber.voip.messages.ui.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class a extends c
{
  public a(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
  }

  protected void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    paramDrawable.draw(paramCanvas);
  }

  protected void a(Canvas paramCanvas, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      paramDrawable1.setAlpha(255 - paramInt);
    paramDrawable1.draw(paramCanvas);
    if (paramBoolean)
      paramDrawable1.setAlpha(255);
    if (paramInt > 0)
    {
      paramDrawable2.setAlpha(paramInt);
      paramDrawable2.draw(paramCanvas);
      paramDrawable2.setAlpha(255);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.a.a
 * JD-Core Version:    0.6.2
 */