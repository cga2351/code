package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.mobile.ads.b;
import java.util.HashMap;
import java.util.Map;

public final class cb
{
  private final fb a;
  private final b b;
  private String c;
  private fd.a d;

  public cb(Context paramContext, b paramb)
  {
    this.a = fb.a(paramContext);
    this.b = paramb;
  }

  private Map<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ad_type", this.b.a());
    localHashMap.put("block_id", this.c);
    localHashMap.put("adapter", "Yandex");
    if (this.d != null)
      localHashMap.putAll(this.d.a());
    return localHashMap;
  }

  private void b(fd.b paramb, Map<String, Object> paramMap)
  {
    fd localfd = new fd(paramb, paramMap);
    this.a.a(localfd);
  }

  private Map<String, Object> c(ak paramak)
  {
    Map localMap = a();
    localMap.put("reason", paramak.b().a());
    String str = paramak.a();
    if (!TextUtils.isEmpty(str))
      localMap.put("asset_name", str);
    return localMap;
  }

  public final void a(ak paramak)
  {
    Map localMap = c(paramak);
    b(paramak.c(), localMap);
  }

  public final void a(fd.a parama)
  {
    this.d = parama;
  }

  public final void a(fd.b paramb)
  {
    b(paramb, a());
  }

  public final void a(fd.b paramb, Map<String, Object> paramMap)
  {
    Map localMap = a();
    localMap.putAll(paramMap);
    b(paramb, localMap);
  }

  public final void a(String paramString)
  {
    this.c = paramString;
  }

  public final void b(ak paramak)
  {
    Map localMap = c(paramak);
    b(paramak.e(), localMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cb
 * JD-Core Version:    0.6.2
 */