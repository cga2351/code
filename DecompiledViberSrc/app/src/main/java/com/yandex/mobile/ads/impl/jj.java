package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.yandex.mobile.ads.nativeads.i;

public final class jj
{
  private final i a;
  private final nu b;

  public jj(i parami)
  {
    this.a = parami;
    this.b = new nu();
  }

  public final boolean a(Drawable paramDrawable, lh paramlh)
  {
    Bitmap localBitmap = this.a.a(paramlh);
    boolean bool = false;
    if (paramDrawable != null)
    {
      bool = false;
      if (localBitmap != null)
        bool = nu.a(paramDrawable).a(paramDrawable, localBitmap);
    }
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jj
 * JD-Core Version:    0.6.2
 */