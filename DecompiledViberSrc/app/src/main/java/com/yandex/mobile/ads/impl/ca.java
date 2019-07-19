package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.b;
import java.util.HashMap;
import java.util.Map;

public final class ca
  implements bz
{
  private final fb a;
  private final v b;
  private final fd.a c;

  public ca(Context paramContext, v paramv, fd.a parama)
  {
    this.a = fb.a(paramContext);
    this.b = paramv;
    this.c = parama;
  }

  private fd b(fd.b paramb, Map<String, Object> paramMap)
  {
    b localb = this.b.a();
    if (localb != null)
      paramMap.put("ad_type", localb.a());
    paramMap.put("block_id", this.b.b());
    paramMap.put("adapter", "Yandex");
    if (this.c != null)
      paramMap.putAll(this.c.a());
    return new fd(paramb, paramMap);
  }

  public final void a(fd.b paramb)
  {
    fd localfd = b(paramb, new HashMap());
    this.a.a(localfd);
  }

  public final void a(fd.b paramb, Map<String, Object> paramMap)
  {
    fd localfd = b(paramb, paramMap);
    this.a.a(localfd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ca
 * JD-Core Version:    0.6.2
 */