package com.mopub.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.mopub.common.Preconditions;

public class Dips
{
  private static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }

  public static float asFloatPixels(float paramFloat, Context paramContext)
  {
    return TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }

  public static int asIntPixels(float paramFloat, Context paramContext)
  {
    return (int)(0.5F + asFloatPixels(paramFloat, paramContext));
  }

  public static float dipsToFloatPixels(float paramFloat, Context paramContext)
  {
    return paramFloat * a(paramContext);
  }

  public static int dipsToIntPixels(float paramFloat, Context paramContext)
  {
    return (int)(0.5F + dipsToFloatPixels(paramFloat, paramContext));
  }

  public static float pixelsToFloatDips(float paramFloat, Context paramContext)
  {
    return paramFloat / a(paramContext);
  }

  public static int pixelsToIntDips(float paramFloat, Context paramContext)
  {
    return (int)(0.5F + pixelsToFloatDips(paramFloat, paramContext));
  }

  public static int screenHeightAsIntDips(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    return pixelsToIntDips(paramContext.getResources().getDisplayMetrics().heightPixels, paramContext);
  }

  public static int screenWidthAsIntDips(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    return pixelsToIntDips(paramContext.getResources().getDisplayMetrics().widthPixels, paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Dips
 * JD-Core Version:    0.6.2
 */