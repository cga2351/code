package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ba
{
  private static String a(List<ll> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      NativeAdType localNativeAdType = ((ll)paramList.get(0)).b();
      if (localNativeAdType != null)
        return localNativeAdType.getValue();
    }
    return "";
  }

  private static Map<String, Object> a(v paramv)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("block_id", paramv.b());
    localHashMap.put("adapter", "Yandex");
    b localb = paramv.a();
    if (localb != null);
    for (String str = localb.a(); ; str = null)
    {
      localHashMap.put("ad_type", str);
      if ((paramv.r() != null) && ((paramv.r() instanceof lm)))
        localHashMap.put("native_ad_type", a(((lm)paramv.r()).c()));
      return localHashMap;
    }
  }

  public static void a(Context paramContext, v paramv)
  {
    a(paramContext, paramv, fd.b.c, Collections.emptyMap());
  }

  private static void a(Context paramContext, v paramv, fd.b paramb, Map<String, Object> paramMap)
  {
    Map localMap = a(paramv);
    localMap.putAll(paramMap);
    fd localfd = new fd(paramb, localMap);
    fb.a(paramContext).a(localfd);
  }

  public static void b(Context paramContext, v paramv)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", fd.c.a.a());
    a(paramContext, paramv, fd.b.d, localHashMap);
  }

  public static void c(Context paramContext, v paramv)
  {
    HashMap localHashMap = new HashMap();
    new az();
    localHashMap.put("reward_info", az.a(paramv));
    a(paramContext, paramv, fd.b.B, localHashMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ba
 * JD-Core Version:    0.6.2
 */