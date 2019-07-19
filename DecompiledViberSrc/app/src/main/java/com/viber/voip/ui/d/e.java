package com.viber.voip.ui.d;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public abstract class e extends Drawable
{
  private static Logger a = ViberEnv.getLogger();
  protected double d = 1.0D;

  public int getOpacity()
  {
    return -3;
  }

  public void setAlpha(int paramInt)
  {
    if (paramInt > 255)
      paramInt = 255;
    this.d = (paramInt / 255.0D);
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.d.e
 * JD-Core Version:    0.6.2
 */