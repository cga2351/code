package com.viber.voip.gallery.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberEnv;

public class y extends x
{
  private static final Logger c = ViberEnv.getLogger();
  private static final int d = R.drawable.bottom_gradient;
  private static final int e = R.drawable.ab_cam_icon;
  private Drawable f;
  private int g;
  private int h;
  private int i;

  public y(Context paramContext)
  {
    this(paramContext, 0L);
  }

  public y(Context paramContext, long paramLong)
  {
    super(paramContext, paramLong);
    this.g = paramContext.getResources().getDimensionPixelOffset(R.dimen.ab_cam_icon_width);
    this.h = paramContext.getResources().getDimensionPixelOffset(R.dimen.ab_cam_icon_height);
    this.f = ContextCompat.getDrawable(paramContext, e);
    this.i = paramContext.getResources().getDimensionPixelOffset(R.dimen.custom_cam_gallery_item_size);
  }

  protected int a()
  {
    return this.i;
  }

  protected int b()
  {
    return getBounds().top;
  }

  protected int c()
  {
    return getBounds().bottom;
  }

  protected int d()
  {
    return d;
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.f.setBounds(this.i - this.g - (int)this.a, getBounds().top + (int)this.b, this.i - (int)this.a, getBounds().top + this.h);
    this.f.draw(paramCanvas);
  }

  public int e()
  {
    return (int)this.b + this.h;
  }

  public int f()
  {
    return this.i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.y
 * JD-Core Version:    0.6.2
 */