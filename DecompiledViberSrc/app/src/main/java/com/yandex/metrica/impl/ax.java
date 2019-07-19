package com.yandex.metrica.impl;

import android.text.TextUtils;
import com.yandex.metrica.PreloadInfo;
import com.yandex.metrica.impl.ob.of;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ax
{
  private PreloadInfo a;

  public ax(PreloadInfo paramPreloadInfo, of paramof)
  {
    if (paramPreloadInfo != null)
    {
      if (!TextUtils.isEmpty(paramPreloadInfo.getTrackingId()))
        break label32;
      if (paramof.c())
        paramof.c("Required field \"PreloadInfo.trackingId\" is empty!\nThis preload info will be skipped.");
    }
    return;
    label32: this.a = paramPreloadInfo;
  }

  String a()
  {
    JSONObject localJSONObject;
    if (this.a != null)
      localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("preloadInfo", b());
      label26: return localJSONObject.toString();
      return "";
    }
    catch (JSONException localJSONException)
    {
      break label26;
    }
  }

  public JSONObject b()
  {
    JSONObject localJSONObject;
    if (this.a != null)
      localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trackingId", this.a.getTrackingId());
      if (!this.a.getAdditionalParams().isEmpty())
        localJSONObject.put("additionalParams", new JSONObject(this.a.getAdditionalParams()));
      return localJSONObject;
      return null;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ax
 * JD-Core Version:    0.6.2
 */