package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.x;
import org.json.JSONException;

public final class mb
  implements bs<lm>
{
  private final bj a = new bj();

  private static lm a(String paramString)
  {
    lm locallm = null;
    try
    {
      locallm = mc.a(paramString);
      locallm.a("status", fd.c.a);
      return locallm;
    }
    catch (JSONException localJSONException)
    {
      return locallm;
    }
    catch (x localx)
    {
    }
    return locallm;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.mb
 * JD-Core Version:    0.6.2
 */