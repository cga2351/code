package com.mixpanel.android.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;

public class a
{
  public static int a(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    arrayOfFloat[2] = 0.3F;
    return Color.HSVToColor(242, arrayOfFloat);
  }

  public static int a(Activity paramActivity)
  {
    int i = -16777216;
    Bitmap localBitmap = a(paramActivity, 1, 1, false);
    if (localBitmap != null)
      i = localBitmap.getPixel(0, 0);
    return a(i);
  }

  public static Bitmap a(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    View localView = paramActivity.findViewById(16908290).getRootView();
    boolean bool = localView.isDrawingCacheEnabled();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache(true);
    Bitmap localBitmap1 = localView.getDrawingCache();
    Object localObject = null;
    if (localBitmap1 != null)
    {
      int i = localBitmap1.getWidth();
      localObject = null;
      if (i > 0)
      {
        int j = localBitmap1.getHeight();
        localObject = null;
        if (j > 0)
        {
          if (paramBoolean)
          {
            paramInt1 = localBitmap1.getWidth() / paramInt1;
            paramInt2 = localBitmap1.getHeight() / paramInt2;
          }
          localObject = null;
          if (paramInt1 > 0)
          {
            localObject = null;
            if (paramInt2 <= 0);
          }
        }
      }
    }
    try
    {
      Bitmap localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, paramInt1, paramInt2, false);
      localObject = localBitmap2;
      if (!bool)
        localView.setDrawingCacheEnabled(false);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        f.c("MixpanelAPI.ActImgUtils", "Not enough memory to produce scaled image, returning a null screenshot");
        localObject = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.b.a
 * JD-Core Version:    0.6.2
 */