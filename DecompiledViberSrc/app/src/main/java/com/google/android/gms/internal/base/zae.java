package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class zae extends Drawable
  implements Drawable.Callback
{
  private int mAlpha = 0;
  private int mFrom;
  private boolean zamy = true;
  private int zang = 0;
  private long zanh;
  private int zani;
  private int zanj = 255;
  private int zank;
  private boolean zanl;
  private zai zanm;
  private Drawable zann;
  private Drawable zano;
  private boolean zanp;
  private boolean zanq;
  private boolean zanr;
  private int zans;

  public zae(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    if (paramDrawable1 == null)
      paramDrawable1 = zag.zacg();
    this.zann = paramDrawable1;
    paramDrawable1.setCallback(this);
    zai localzai1 = this.zanm;
    localzai1.zanv |= paramDrawable1.getChangingConfigurations();
    if (paramDrawable2 == null)
      paramDrawable2 = zag.zacg();
    this.zano = paramDrawable2;
    paramDrawable2.setCallback(this);
    zai localzai2 = this.zanm;
    localzai2.zanv |= paramDrawable2.getChangingConfigurations();
  }

  zae(zai paramzai)
  {
    this.zanm = new zai(paramzai);
  }

  private final boolean canConstantState()
  {
    if (!this.zanp)
      if ((this.zann.getConstantState() == null) || (this.zano.getConstantState() == null))
        break label44;
    label44: for (boolean bool = true; ; bool = false)
    {
      this.zanq = bool;
      this.zanp = true;
      return this.zanq;
    }
  }

  public final void draw(Canvas paramCanvas)
  {
    int i = 1;
    switch (this.zang)
    {
    default:
    case 1:
    case 2:
    }
    int k;
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
      for (int j = i; ; j = 0)
      {
        k = this.mAlpha;
        bool = this.zamy;
        localDrawable1 = this.zann;
        localDrawable2 = this.zano;
        if (j == 0)
          break;
        if ((!bool) || (k == 0))
          localDrawable1.draw(paramCanvas);
        if (k == this.zanj)
        {
          localDrawable2.setAlpha(this.zanj);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.zanh = SystemClock.uptimeMillis();
        this.zang = 2;
      }
    while (this.zanh < 0L);
    float f = (float)(SystemClock.uptimeMillis() - this.zanh) / this.zank;
    if (f >= 1.0F);
    while (true)
    {
      if (i != 0)
        this.zang = 0;
      this.mAlpha = ((int)(0.0F + Math.min(f, 1.0F) * this.zani));
      break;
      i = 0;
    }
    if (bool)
      localDrawable1.setAlpha(this.zanj - k);
    localDrawable1.draw(paramCanvas);
    if (bool)
      localDrawable1.setAlpha(this.zanj);
    if (k > 0)
    {
      localDrawable2.setAlpha(k);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.zanj);
    }
    invalidateSelf();
  }

  public final int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.zanm.mChangingConfigurations | this.zanm.zanv;
  }

  public final Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.zanm.mChangingConfigurations = getChangingConfigurations();
      return this.zanm;
    }
    return null;
  }

  public final int getIntrinsicHeight()
  {
    return Math.max(this.zann.getIntrinsicHeight(), this.zano.getIntrinsicHeight());
  }

  public final int getIntrinsicWidth()
  {
    return Math.max(this.zann.getIntrinsicWidth(), this.zano.getIntrinsicWidth());
  }

  public final int getOpacity()
  {
    if (!this.zanr)
    {
      this.zans = Drawable.resolveOpacity(this.zann.getOpacity(), this.zano.getOpacity());
      this.zanr = true;
    }
    return this.zans;
  }

  public final void invalidateDrawable(Drawable paramDrawable)
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null)
      localCallback.invalidateDrawable(this);
  }

  public final Drawable mutate()
  {
    if ((!this.zanl) && (super.mutate() == this))
    {
      if (!canConstantState())
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      this.zann.mutate();
      this.zano.mutate();
      this.zanl = true;
    }
    return this;
  }

  protected final void onBoundsChange(Rect paramRect)
  {
    this.zann.setBounds(paramRect);
    this.zano.setBounds(paramRect);
  }

  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null)
      localCallback.scheduleDrawable(this, paramRunnable, paramLong);
  }

  public final void setAlpha(int paramInt)
  {
    if (this.mAlpha == this.zanj)
      this.mAlpha = paramInt;
    this.zanj = paramInt;
    invalidateSelf();
  }

  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.zann.setColorFilter(paramColorFilter);
    this.zano.setColorFilter(paramColorFilter);
  }

  public final void startTransition(int paramInt)
  {
    this.mFrom = 0;
    this.zani = this.zanj;
    this.mAlpha = 0;
    this.zank = 250;
    this.zang = 1;
    invalidateSelf();
  }

  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null)
      localCallback.unscheduleDrawable(this, paramRunnable);
  }

  public final Drawable zacf()
  {
    return this.zano;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.base.zae
 * JD-Core Version:    0.6.2
 */