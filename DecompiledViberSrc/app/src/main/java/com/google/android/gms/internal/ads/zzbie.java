package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzbie
{
  private static final Pattern zzemj = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
  private static final Pattern zzemk = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

  public static String zzabt()
  {
    zzaci localzzaci = zzact.zzcmw;
    String str = (String)zzyr.zzpe().zzd(localzzaci);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", str);
      localJSONObject.put("sdk", "Google Mobile Ads");
      localJSONObject.put("sdkVersion", "12.4.51-000");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<script>");
      localStringBuilder.append("Object.defineProperty(window,'MRAID_ENV',{get:function(){return ").append(localJSONObject.toString()).append("}});");
      localStringBuilder.append("</script>");
      return localStringBuilder.toString();
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzd("Unable to build MRAID_ENV", localJSONException);
    }
    return null;
  }

  public static String zzf(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (paramArrayOfString.length == 0)
      return paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = zzemj.matcher(paramString);
    if (localMatcher.find())
    {
      int k = localMatcher.end();
      localStringBuilder.append(paramString.substring(0, k));
      int m = paramArrayOfString.length;
      while (i < m)
      {
        String str2 = paramArrayOfString[i];
        if (str2 != null)
          localStringBuilder.append(str2);
        i++;
      }
      localStringBuilder.append(paramString.substring(k));
    }
    while (true)
    {
      return localStringBuilder.toString();
      if (!zzemk.matcher(paramString).find())
      {
        int j = paramArrayOfString.length;
        while (i < j)
        {
          String str1 = paramArrayOfString[i];
          if (str1 != null)
            localStringBuilder.append(str1);
          i++;
        }
      }
      localStringBuilder.append(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbie
 * JD-Core Version:    0.6.2
 */