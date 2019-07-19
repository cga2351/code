package com.viber.voip.messages.shopchat;

import android.content.Context;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.shopchat.library.util.BuildConfigUtils;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class a
  implements com.shopchat.library.a.a
{
  private static final e a = ViberEnv.getLogger();
  private String b;
  private MixpanelAPI c;

  public a(Context paramContext, MixpanelAPI paramMixpanelAPI)
  {
    this.b = ((String)BuildConfigUtils.getBuildConfigValue(paramContext, "BUILD_TYPE"));
    this.c = paramMixpanelAPI;
  }

  public void a()
  {
    if (this.b.equals("release"))
      this.c.flush();
  }

  public void a(String paramString)
  {
    this.c.timeEvent(paramString);
  }

  public void a(String paramString, Map<String, String> paramMap)
  {
    String str1 = paramString.toLowerCase();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str3 = (String)paramMap.get(str2);
      localHashMap.put(str2.toLowerCase(), str3.toLowerCase());
    }
    JSONObject localJSONObject = new JSONObject(localHashMap);
    this.c.track(str1, localJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.shopchat.a
 * JD-Core Version:    0.6.2
 */