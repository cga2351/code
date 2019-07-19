package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class mu
  implements mr<lh>
{
  public static lh b(JSONObject paramJSONObject)
    throws JSONException, x
  {
    if ((paramJSONObject.has("value")) && (!paramJSONObject.isNull("value")))
    {
      lh locallh = new lh();
      JSONObject localJSONObject = paramJSONObject.getJSONObject("value");
      locallh.a(mc.b(localJSONObject, "url"));
      locallh.a(localJSONObject.getInt("w"));
      locallh.b(localJSONObject.getInt("h"));
      String str = localJSONObject.optString("sizeType");
      if (!TextUtils.isEmpty(str))
        locallh.b(str);
      return locallh;
    }
    throw new x("Native Ad json has not required attributes");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.mu
 * JD-Core Version:    0.6.2
 */