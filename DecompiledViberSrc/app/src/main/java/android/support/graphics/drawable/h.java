package android.support.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;

abstract class h extends Drawable
  implements TintAwareDrawable
{
  Drawable c;

  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.c != null)
      DrawableCompat.applyTheme(this.c, paramTheme);
  }

  public void clearColorFilter()
  {
    if (this.c != null)
    {
      this.c.clearColorFilter();
      return;
    }
    super.clearColorFilter();
  }

  public ColorFilter getColorFilter()
  {
    if (this.c != null)
      return DrawableCompat.getColorFilter(this.c);
    return null;
  }

  public Drawable getCurrent()
  {
    if (this.c != null)
      return this.c.getCurrent();
    return super.getCurrent();
  }

  public int getMinimumHeight()
  {
    if (this.c != null)
      return this.c.getMinimumHeight();
    return super.getMinimumHeight();
  }

  public int getMinimumWidth()
  {
    if (this.c != null)
      return this.c.getMinimumWidth();
    return super.getMinimumWidth();
  }

  public boolean getPadding(Rect paramRect)
  {
    if (this.c != null)
      return this.c.getPadding(paramRect);
    return super.getPadding(paramRect);
  }

  public int[] getState()
  {
    if (this.c != null)
      return this.c.getState();
    return super.getState();
  }

  public Region getTransparentRegion()
  {
    if (this.c != null)
      return this.c.getTransparentRegion();
    return super.getTransparentRegion();
  }

  public void jumpToCurrentState()
  {
    if (this.c != null)
      DrawableCompat.jumpToCurrentState(this.c);
  }

  protected void onBoundsChange(Rect paramRect)
  {
    if (this.c != null)
    {
      this.c.setBounds(paramRect);
      return;
    }
    super.onBoundsChange(paramRect);
  }

  protected boolean onLevelChange(int paramInt)
  {
    if (this.c != null)
      return this.c.setLevel(paramInt);
    return super.onLevelChange(paramInt);
  }

  public void setChangingConfigurations(int paramInt)
  {
    if (this.c != null)
    {
      this.c.setChangingConfigurations(paramInt);
      return;
    }
    super.setChangingConfigurations(paramInt);
  }

  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    if (this.c != null)
    {
      this.c.setColorFilter(paramInt, paramMode);
      return;
    }
    super.setColorFilter(paramInt, paramMode);
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.setFilterBitmap(paramBoolean);
  }

  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.c != null)
      DrawableCompat.setHotspot(this.c, paramFloat1, paramFloat2);
  }

  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.c != null)
      DrawableCompat.setHotspotBounds(this.c, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.c != null)
      return this.c.setState(paramArrayOfInt);
    return super.setState(paramArrayOfInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.graphics.drawable.h
 * JD-Core Version:    0.6.2
 */