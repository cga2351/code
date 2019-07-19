package com.yandex.mobile.ads.nativeads;

import android.graphics.Bitmap;
import com.yandex.mobile.ads.impl.lh;
import java.util.Map;

public final class bf
  implements i
{
  private Map<String, Bitmap> a;

  public final Bitmap a(lh paramlh)
  {
    String str = paramlh.c();
    if (this.a != null)
      return (Bitmap)this.a.get(str);
    return null;
  }

  public final void a(Map<String, Bitmap> paramMap)
  {
    this.a = paramMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.bf
 * JD-Core Version:    0.6.2
 */