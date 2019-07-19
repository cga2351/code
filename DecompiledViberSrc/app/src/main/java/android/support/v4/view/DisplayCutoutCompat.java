package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import java.util.List;

public final class DisplayCutoutCompat
{
  private final Object mDisplayCutout;

  public DisplayCutoutCompat(Rect paramRect, List<Rect> paramList)
  {
  }

  private DisplayCutoutCompat(Object paramObject)
  {
    this.mDisplayCutout = paramObject;
  }

  static DisplayCutoutCompat wrap(Object paramObject)
  {
    if (paramObject == null)
      return null;
    return new DisplayCutoutCompat(paramObject);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    DisplayCutoutCompat localDisplayCutoutCompat;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localDisplayCutoutCompat = (DisplayCutoutCompat)paramObject;
      if (this.mDisplayCutout != null)
        break;
    }
    while (localDisplayCutoutCompat.mDisplayCutout == null);
    return false;
    return this.mDisplayCutout.equals(localDisplayCutoutCompat.mDisplayCutout);
  }

  public List<Rect> getBoundingRects()
  {
    if (Build.VERSION.SDK_INT >= 28)
      return ((DisplayCutout)this.mDisplayCutout).getBoundingRects();
    return null;
  }

  public int getSafeInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 28)
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetBottom();
    return 0;
  }

  public int getSafeInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 28)
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetLeft();
    return 0;
  }

  public int getSafeInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 28)
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetRight();
    return 0;
  }

  public int getSafeInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 28)
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetTop();
    return 0;
  }

  public int hashCode()
  {
    if (this.mDisplayCutout == null)
      return 0;
    return this.mDisplayCutout.hashCode();
  }

  public String toString()
  {
    return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.DisplayCutoutCompat
 * JD-Core Version:    0.6.2
 */