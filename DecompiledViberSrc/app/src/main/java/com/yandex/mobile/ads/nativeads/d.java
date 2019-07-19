package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.LruCache;
import com.yandex.mobile.ads.impl.lh;
import com.yandex.mobile.ads.impl.lw;
import com.yandex.mobile.ads.impl.lz;
import java.util.Map;

public final class d
  implements i
{
  private final Context a;

  public d(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }

  public final Bitmap a(lh paramlh)
  {
    LruCache localLruCache = lz.a(this.a).a();
    if (Build.VERSION.SDK_INT >= 12)
    {
      String str = lw.a(paramlh);
      Bitmap localBitmap = (Bitmap)localLruCache.get(str);
      if ((localBitmap != null) && (localBitmap.getWidth() == 1) && (localBitmap.getHeight() == 1))
      {
        localBitmap = Bitmap.createScaledBitmap(localBitmap, paramlh.a(), paramlh.b(), false);
        localLruCache.put(str, localBitmap);
      }
      return localBitmap;
    }
    return null;
  }

  public final void a(Map<String, Bitmap> paramMap)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.d
 * JD-Core Version:    0.6.2
 */