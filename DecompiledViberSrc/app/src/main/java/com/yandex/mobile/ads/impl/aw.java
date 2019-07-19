package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.AdRequest;
import java.util.HashMap;
import java.util.Map;

public class aw
  implements aq
{
  protected final eo a;

  public aw(eo parameo)
  {
    this.a = parameo;
  }

  public Map<String, Object> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    AdRequest localAdRequest = this.a.c();
    et localet;
    if (localAdRequest != null)
    {
      localHashMap.put("age", localAdRequest.getAge());
      localHashMap.put("context_tags", localAdRequest.getContextTags());
      localHashMap.put("gender", localAdRequest.getGender());
      localHashMap.put("location", localAdRequest.getLocation());
      localet = es.a().a(paramContext);
      if (localet == null)
        break label111;
    }
    label111: for (Boolean localBoolean = localet.f(); ; localBoolean = null)
    {
      if (localBoolean != null)
        localHashMap.put("user_consent", localBoolean);
      return localHashMap;
    }
  }

  public final Map<String, String> a(bc parambc)
  {
    return parambc.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.aw
 * JD-Core Version:    0.6.2
 */