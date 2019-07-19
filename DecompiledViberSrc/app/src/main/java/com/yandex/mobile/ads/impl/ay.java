package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ay
{
  private final eo a;

  public ay(eo parameo)
  {
    this.a = parameo;
  }

  private Map<String, Object> a(bc parambc)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("block_id", this.a.e());
    localHashMap.put("ad_type", this.a.a().a());
    localHashMap.put("adapter", parambc.a());
    localHashMap.put("adapter_parameters", parambc.b());
    return localHashMap;
  }

  private void a(Context paramContext, fd.b paramb, bc parambc, Map<String, Object> paramMap)
  {
    Map localMap = a(parambc);
    localMap.putAll(paramMap);
    fd localfd = new fd(paramb, localMap);
    fb.a(paramContext).a(localfd);
  }

  public final void a(Context paramContext, bc parambc)
  {
    a(paramContext, fd.b.c, parambc, Collections.emptyMap());
  }

  public final void a(Context paramContext, bc parambc, v paramv)
  {
    HashMap localHashMap = new HashMap();
    new az();
    localHashMap.put("reward_info", az.a(paramv));
    a(paramContext, fd.b.B, parambc, localHashMap);
  }

  public final void a(Context paramContext, bc parambc, Map<String, Object> paramMap)
  {
    a(paramContext, fd.b.t, parambc, paramMap);
  }

  public final void b(Context paramContext, bc parambc, Map<String, Object> paramMap)
  {
    a(paramContext, fd.b.k, parambc, paramMap);
    a(paramContext, fd.b.l, parambc, paramMap);
  }

  public final void c(Context paramContext, bc parambc, Map<String, Object> paramMap)
  {
    a(paramContext, fd.b.a, parambc, paramMap);
  }

  public final void d(Context paramContext, bc parambc, Map<String, Object> paramMap)
  {
    a(paramContext, fd.b.d, parambc, paramMap);
  }

  public final void e(Context paramContext, bc parambc, Map<String, Object> paramMap)
  {
    a(paramContext, fd.b.s, parambc, paramMap);
  }

  public final void f(Context paramContext, bc parambc, Map<String, Object> paramMap)
  {
    a(paramContext, fd.b.b, parambc, paramMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ay
 * JD-Core Version:    0.6.2
 */