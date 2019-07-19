package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;

public final class pj
  implements pa
{
  private final pa a;
  private final fk b;
  private final Context c;

  public pj(Context paramContext, pa parampa)
  {
    this.a = parampa;
    this.b = new fk();
    if (paramContext != null);
    for (Context localContext = paramContext.getApplicationContext(); ; localContext = null)
    {
      this.c = localContext;
      return;
    }
  }

  public final HttpResponse a(oi<?> paramoi, Map<String, String> paramMap)
    throws IOException, ov
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    localHashMap.put(oa.y.a(), this.b.a(this.c));
    return this.a.a(paramoi, localHashMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pj
 * JD-Core Version:    0.6.2
 */