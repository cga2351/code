package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import java.util.Locale;
import javax.annotation.Nullable;

public class ResizeOptions
{
  public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667F;
  public final int height;
  public final float maxBitmapSize;
  public final float roundUpFraction;
  public final int width;

  public ResizeOptions(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 2048.0F);
  }

  public ResizeOptions(int paramInt1, int paramInt2, float paramFloat)
  {
    this(paramInt1, paramInt2, paramFloat, 0.6666667F);
  }

  public ResizeOptions(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool2;
    if (paramInt1 > 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt2 <= 0)
        break label57;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.width = paramInt1;
      this.height = paramInt2;
      this.maxBitmapSize = paramFloat1;
      this.roundUpFraction = paramFloat2;
      return;
      bool2 = false;
      break;
      label57: bool1 = false;
    }
  }

  @Nullable
  public static ResizeOptions forDimensions(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      return null;
    return new ResizeOptions(paramInt1, paramInt2);
  }

  @Nullable
  public static ResizeOptions forSquareSize(int paramInt)
  {
    if (paramInt <= 0)
      return null;
    return new ResizeOptions(paramInt, paramInt);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ResizeOptions localResizeOptions;
    do
    {
      return true;
      if (!(paramObject instanceof ResizeOptions))
        return false;
      localResizeOptions = (ResizeOptions)paramObject;
    }
    while ((this.width == localResizeOptions.width) && (this.height == localResizeOptions.height));
    return false;
  }

  public int hashCode()
  {
    return HashCodeUtil.hashCode(this.width, this.height);
  }

  public String toString()
  {
    Locale localLocale = (Locale)null;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.width);
    arrayOfObject[1] = Integer.valueOf(this.height);
    return String.format(localLocale, "%dx%d", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.common.ResizeOptions
 * JD-Core Version:    0.6.2
 */