package com.yandex.mobile.ads.nativeads;

import android.os.Handler;
import android.os.Looper;
import com.yandex.mobile.ads.impl.bz;
import com.yandex.mobile.ads.impl.cp;
import com.yandex.mobile.ads.impl.fd.b;
import java.util.HashMap;
import java.util.Map;

public final class g
  implements cp
{
  private final Handler a;
  private final AdTapHandler b;

  public g(AdTapHandler paramAdTapHandler)
  {
    this.b = paramAdTapHandler;
    this.a = new Handler(Looper.getMainLooper());
  }

  public final void a(bz parambz, final String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("click_type", "custom");
    parambz.a(fd.b.t, localHashMap);
    this.a.post(new Runnable()
    {
      public final void run()
      {
        g.a(g.this).handleAdTapWithURL(paramString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.g
 * JD-Core Version:    0.6.2
 */