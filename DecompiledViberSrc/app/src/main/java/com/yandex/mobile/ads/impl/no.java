package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class no extends cc<lm>
{
  private final np a = new np();

  protected final Map<String, Object> a(eo parameo)
  {
    Map localMap = super.a(parameo);
    localMap.put("image_loading_automatically", Boolean.valueOf(parameo.s()));
    String[] arrayOfString = parameo.m();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
      localMap.put("image_sizes", parameo.m());
    return localMap;
  }

  protected final Map<String, Object> a(ok<v<lm>> paramok, int paramInt, eo parameo)
  {
    Map localMap = super.a(paramok, paramInt, parameo);
    fd.c localc;
    if (204 == paramInt)
      localc = fd.c.c;
    while (true)
    {
      if (localc != null)
        localMap.put("status", localc.a());
      ArrayList localArrayList1 = new ArrayList();
      if ((paramok != null) && (paramok.a != null) && (((v)paramok.a).r() != null))
      {
        List localList2 = ((lm)((v)paramok.a).r()).c();
        if (localList2 != null)
        {
          Iterator localIterator2 = localList2.iterator();
          while (true)
            if (localIterator2.hasNext())
            {
              localArrayList1.addAll(p.a((ll)localIterator2.next()));
              continue;
              if ((paramok == null) || (paramok.a == null) || (paramInt != 200))
              {
                localc = fd.c.b;
                break;
              }
              lm locallm = (lm)((v)paramok.a).r();
              if (locallm != null)
              {
                localc = (fd.c)locallm.a().get("status");
                break;
              }
              if (((v)paramok.a).q() != null)
                break label415;
              localc = fd.c.b;
              break;
            }
        }
      }
      if (!localArrayList1.isEmpty())
        localMap.put("image_sizes", localArrayList1.toArray(new String[localArrayList1.size()]));
      ArrayList localArrayList2 = new ArrayList();
      if ((paramok != null) && (paramok.a != null) && (((v)paramok.a).r() != null))
      {
        List localList1 = ((lm)((v)paramok.a).r()).c();
        if (localList1 != null)
        {
          Iterator localIterator1 = localList1.iterator();
          while (localIterator1.hasNext())
          {
            NativeAdType localNativeAdType = ((ll)localIterator1.next()).b();
            if (localNativeAdType != null)
              localArrayList2.add(localNativeAdType.getValue());
          }
        }
      }
      if (!localArrayList2.isEmpty())
        localMap.put("native_ad_types", localArrayList2.toArray(new String[localArrayList2.size()]));
      return localMap;
      label415: localc = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.no
 * JD-Core Version:    0.6.2
 */