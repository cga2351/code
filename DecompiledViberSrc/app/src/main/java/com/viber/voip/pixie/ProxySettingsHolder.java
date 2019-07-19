package com.viber.voip.pixie;

import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.r;
import com.viber.voip.util.da;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ProxySettingsHolder
{
  private static final Logger L = ViberEnv.getLogger();

  public static ProxySettings newInstance(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean1, String paramString5, String paramString6, String paramString7, boolean paramBoolean2)
  {
    if ((paramString1 == null) || (Arrays.asList(ProxySettings.TYPES).indexOf(paramString1) == -1));
    for (String str1 = "socks5"; ; str1 = paramString1)
    {
      if ((paramString5 == null) || (Arrays.asList(ProxySettings.ENCRYPTION_METHODS).indexOf(paramString5) == -1));
      for (String str2 = "AES-128/GCM"; ; str2 = paramString5)
        return new ProxySettings(str1, da.h(paramString2), da.h(paramString3), da.h(paramString4), paramInt, paramBoolean1, str2, da.h(paramString6), da.h(paramString7), paramBoolean2);
    }
  }

  public static ProxySettings obtain()
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    String str7 = "";
    String str8 = d.r.e.d();
    if (!da.a(str8));
    while (true)
    {
      try
      {
        localJSONObject = new JSONObject(str8);
        str1 = localJSONObject.getString("type");
        str2 = localJSONObject.getString("url");
        str3 = localJSONObject.getString("username");
        str4 = localJSONObject.getString("password");
        int j = localJSONObject.getInt("port");
        i = j;
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          boolean bool3 = localJSONObject.getBoolean("udp");
          bool1 = bool3;
        }
        catch (JSONException localJSONException2)
        {
          try
          {
            JSONObject localJSONObject;
            str5 = localJSONObject.getString("method");
            str6 = localJSONObject.getString("server_name");
            str7 = localJSONObject.getString("key");
            boolean bool4 = localJSONObject.getBoolean("proxy_enabled");
            bool2 = bool4;
            return newInstance(str1, str2, str3, str4, i, bool1, str5, str6, str7, bool2);
            localJSONException1 = localJSONException1;
            i = 0;
            bool1 = false;
            bool2 = false;
            continue;
            localJSONException2 = localJSONException2;
            bool1 = false;
            bool2 = false;
            continue;
          }
          catch (JSONException localJSONException3)
          {
            bool2 = false;
            continue;
          }
        }
      }
      int i = 0;
      boolean bool1 = false;
      boolean bool2 = false;
    }
  }

  public static boolean update(ProxySettings paramProxySettings)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramProxySettings.type);
      localJSONObject.put("url", paramProxySettings.url);
      localJSONObject.put("username", paramProxySettings.username);
      localJSONObject.put("password", paramProxySettings.password);
      localJSONObject.put("port", paramProxySettings.port);
      localJSONObject.put("udp", paramProxySettings.udp);
      localJSONObject.put("method", paramProxySettings.encryptionMethod);
      localJSONObject.put("server_name", paramProxySettings.serverName);
      localJSONObject.put("key", paramProxySettings.key);
      localJSONObject.put("proxy_enabled", paramProxySettings.enabled);
      String str = localJSONObject.toString();
      d.r.e.a(str);
      return true;
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.ProxySettingsHolder
 * JD-Core Version:    0.6.2
 */