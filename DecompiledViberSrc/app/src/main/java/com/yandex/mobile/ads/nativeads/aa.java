package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.ac;
import com.yandex.mobile.ads.impl.fd.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class aa extends aw
  implements y
{
  private final i a;
  private final List<? extends NativeGenericAd> b;
  private final bd c;
  private final aw.a d = aw.a.a;
  private final fd.a e = new fd.a()
  {
    public final Map<String, Object> a()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("bind_type", aa.a(aa.this).c);
      localHashMap.put("native_ad_type", ac.b.a());
      return localHashMap;
    }
  };

  aa(Context paramContext, List<? extends NativeGenericAd> paramList, i parami, c paramc)
  {
    super(paramContext, paramc);
    this.b = paramList;
    this.a = parami;
    this.c = paramc.c();
    a(this.e);
  }

  protected final List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("sponsored");
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.aa
 * JD-Core Version:    0.6.2
 */