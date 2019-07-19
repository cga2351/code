package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.nativeads.MediaView;
import com.yandex.mobile.ads.nativeads.af;
import com.yandex.mobile.ads.nativeads.aj;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class nz
{
  private final fb a;
  private final List<le> b;
  private final b c;
  private final String d;
  private fd.a e;

  public nz(Context paramContext, b paramb, String paramString, List<le> paramList)
  {
    this.c = paramb;
    this.d = paramString;
    this.a = fb.a(paramContext);
    if (paramList != null);
    while (true)
    {
      this.b = paramList;
      return;
      paramList = Collections.emptyList();
    }
  }

  public final void a(fd.a parama)
  {
    this.e = parama;
  }

  public final void a(af paramaf)
  {
    MediaView localMediaView = paramaf.c().k();
    Object localObject1 = null;
    Iterator localIterator = this.b.iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (le)localIterator.next();
      if (!"media".equals(((le)localObject2).a()))
        break label254;
    }
    while (true)
    {
      localObject1 = localObject2;
      break;
      if (localMediaView == null)
        if ((localObject1 == null) || (!(localObject1.c() instanceof lk)) || (((lk)localObject1.c()).a() == null))
          break label248;
      label248: for (int j = 1; ; j = 0)
      {
        if (j != 0);
        for (int i = 1; ; i = 0)
        {
          if (i != 0)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("ad_type", this.c.a());
            localHashMap.put("block_id", this.d);
            localHashMap.put("reason", "expected_view_missing");
            localHashMap.put("view", "mediaview");
            localHashMap.put("asset_name", "media");
            if (this.e != null)
              localHashMap.putAll(this.e.a());
            fd localfd = new fd(fd.b.z, localHashMap);
            this.a.a(localfd);
            new Object[] { "mediaview" };
          }
          return;
        }
      }
      label254: localObject2 = localObject1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nz
 * JD-Core Version:    0.6.2
 */