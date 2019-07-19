package com.facebook.react.views.image;

import android.graphics.Shader.TileMode;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import javax.annotation.Nullable;

public class ImageResizeMode
{
  public static Shader.TileMode defaultTileMode()
  {
    return Shader.TileMode.CLAMP;
  }

  public static ScalingUtils.ScaleType defaultValue()
  {
    return ScalingUtils.ScaleType.CENTER_CROP;
  }

  public static ScalingUtils.ScaleType toScaleType(@Nullable String paramString)
  {
    if ("contain".equals(paramString))
      return ScalingUtils.ScaleType.FIT_CENTER;
    if ("cover".equals(paramString))
      return ScalingUtils.ScaleType.CENTER_CROP;
    if ("stretch".equals(paramString))
      return ScalingUtils.ScaleType.FIT_XY;
    if ("center".equals(paramString))
      return ScalingUtils.ScaleType.CENTER_INSIDE;
    if ("repeat".equals(paramString))
      return ScaleTypeStartInside.INSTANCE;
    if (paramString == null)
      return defaultValue();
    throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + paramString + "'");
  }

  public static Shader.TileMode toTileMode(@Nullable String paramString)
  {
    if (("contain".equals(paramString)) || ("cover".equals(paramString)) || ("stretch".equals(paramString)) || ("center".equals(paramString)))
      return Shader.TileMode.CLAMP;
    if ("repeat".equals(paramString))
      return Shader.TileMode.REPEAT;
    if (paramString == null)
      return defaultTileMode();
    throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + paramString + "'");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.ImageResizeMode
 * JD-Core Version:    0.6.2
 */