package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import com.yandex.mobile.ads.impl.aj;
import com.yandex.mobile.ads.impl.aw;
import com.yandex.mobile.ads.impl.eo;
import java.util.Map;

final class f extends aw
{
  f(eo parameo)
  {
    super(parameo);
  }

  public final Map<String, Object> a(Context paramContext)
  {
    Map localMap = super.a(paramContext);
    aj localaj = this.a.b();
    if (localaj != null)
    {
      localMap.put("width", Integer.valueOf(localaj.a()));
      localMap.put("height", Integer.valueOf(localaj.b()));
    }
    return localMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.banner.f
 * JD-Core Version:    0.6.2
 */