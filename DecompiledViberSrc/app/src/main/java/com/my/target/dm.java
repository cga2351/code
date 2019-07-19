package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.TextureView;

public final class dm extends TextureView
{
  public dm(Context paramContext)
  {
    super(paramContext);
  }

  public final Bitmap getScreenShot()
  {
    try
    {
      Bitmap localBitmap = getBitmap(getWidth(), getHeight());
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dm
 * JD-Core Version:    0.6.2
 */