package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mixpanel.android.b.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstallReferrerReceiver extends BroadcastReceiver
{
  private final Pattern a = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
  private final Pattern b = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
  private final Pattern c = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
  private final Pattern d = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
  private final Pattern e = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");

  private String a(Matcher paramMatcher)
  {
    if (paramMatcher.find())
    {
      String str1 = paramMatcher.group(2);
      if (str1 != null)
        try
        {
          String str2 = URLDecoder.decode(str1, "UTF-8");
          return str2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          f.e("MixpanelAPI.InstRfrRcvr", "Could not decode a parameter into UTF-8");
        }
    }
    return null;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null);
    String str1;
    do
    {
      return;
      str1 = localBundle.getString("referrer");
    }
    while (str1 == null);
    HashMap localHashMap = new HashMap();
    localHashMap.put("referrer", str1);
    String str2 = a(this.a.matcher(str1));
    if (str2 != null)
      localHashMap.put("utm_source", str2);
    String str3 = a(this.b.matcher(str1));
    if (str3 != null)
      localHashMap.put("utm_medium", str3);
    String str4 = a(this.c.matcher(str1));
    if (str4 != null)
      localHashMap.put("utm_campaign", str4);
    String str5 = a(this.d.matcher(str1));
    if (str5 != null)
      localHashMap.put("utm_content", str5);
    String str6 = a(this.e.matcher(str1));
    if (str6 != null)
      localHashMap.put("utm_term", str6);
    n.a(paramContext, "com.mixpanel.android.mpmetrics.ReferralInfo", localHashMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.InstallReferrerReceiver
 * JD-Core Version:    0.6.2
 */