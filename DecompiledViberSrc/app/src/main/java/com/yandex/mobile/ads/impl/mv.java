package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class mv
  implements mr<lk>
{
  private final nb a = new nb();
  private final na b = new na();

  private static <T> T a(JSONObject paramJSONObject, String paramString, mz<T> parammz)
    throws JSONException, x
  {
    boolean bool = a(paramJSONObject, paramString);
    Object localObject = null;
    if (bool)
      localObject = parammz.a(paramJSONObject.getJSONObject(paramString));
    return localObject;
  }

  private static boolean a(JSONObject paramJSONObject, String paramString)
  {
    return (paramJSONObject.has(paramString)) && (!paramJSONObject.isNull(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.mv
 * JD-Core Version:    0.6.2
 */