package com.viber.voip.util;

import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.billing.ac;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.registration.o;
import com.viber.voip.settings.d.ax;
import com.viber.voip.user.UserManager;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dl
{
  public static String a(Uri paramUri)
  {
    String str = paramUri.getHost();
    if (str == null)
      str = paramUri.toString();
    if (str.toLowerCase(Locale.US).startsWith("www."))
      str = str.substring(4);
    return str;
  }

  public static String a(String paramString, int paramInt)
  {
    return Uri.parse(paramString).buildUpon().appendPath("collection." + paramInt).build().toString();
  }

  public static String a(String paramString, Location paramLocation)
  {
    if (paramLocation == null)
      return paramString;
    return Uri.parse(paramString).buildUpon().appendQueryParameter("lat", String.valueOf(paramLocation.getLatitude())).appendQueryParameter("lon", String.valueOf(paramLocation.getLongitude())).build().toString();
  }

  public static String a(String paramString, ac paramac)
  {
    if (paramac == null)
      return paramString;
    return Uri.parse(paramString).buildUpon().appendQueryParameter("token", paramac.b).appendQueryParameter("ts", Long.toString(paramac.a)).build().toString();
  }

  public static String a(String paramString1, String paramString2)
  {
    return Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, Locale.getDefault().getLanguage()).build().toString();
  }

  public static boolean a(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str = localUri.getHost();
      boolean bool1 = ce.h.matcher(paramString).matches();
      if ((str != null) && (str.toLowerCase(Locale.US).endsWith("viber.com")));
      for (int i = 1; ; i = 0)
      {
        boolean bool2 = dk.g(localUri);
        if (((!bool1) || (i == 0)) && (!bool2))
          break;
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static String b(String paramString)
  {
    return a(paramString, "lang");
  }

  public static String b(String paramString1, String paramString2)
  {
    Uri.Builder localBuilder = Uri.parse(paramString1).buildUpon().appendQueryParameter("action", "promocode");
    if (!da.a(paramString2))
      localBuilder.appendQueryParameter("code", paramString2);
    return localBuilder.build().toString();
  }

  public static String c(String paramString)
  {
    af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    return Uri.parse(paramString).buildUpon().appendQueryParameter("default_country", localaf.e()).build().toString();
  }

  public static String c(String paramString1, String paramString2)
  {
    return Uri.parse(paramString1).buildUpon().appendPath("tab." + paramString2).build().toString();
  }

  public static String d(String paramString)
  {
    af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    return Uri.parse(paramString).buildUpon().appendQueryParameter("phone_number", localaf.g()).build().toString();
  }

  public static String d(String paramString1, String paramString2)
  {
    return Uri.parse(paramString1).buildUpon().appendQueryParameter("google_ad_id", paramString2).build().toString();
  }

  public static String e(String paramString)
  {
    af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    return Uri.parse(paramString).buildUpon().appendQueryParameter("mid", localaf.l()).build().toString();
  }

  public static String e(String paramString1, String paramString2)
  {
    if (da.a(paramString2))
      return paramString1;
    return Uri.parse(paramString1).buildUpon().appendQueryParameter("coupon", paramString2).build().toString();
  }

  public static String f(String paramString)
  {
    af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    String str1 = z.a(z.a(localaf.l(), localaf.k()));
    try
    {
      String str2 = Uri.parse(paramString).buildUpon().appendQueryParameter("user_id", URLEncoder.encode(str1, "utf-8")).build().toString();
      return str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return paramString;
  }

  public static String f(String paramString1, String paramString2)
  {
    return Uri.parse(paramString1).buildUpon().appendQueryParameter("plan_id", paramString2).build().toString();
  }

  public static String g(String paramString)
  {
    return Uri.parse(paramString).buildUpon().appendQueryParameter("scid", String.valueOf(d.ax.t.d())).build().toString();
  }

  public static String g(String paramString1, String paramString2)
  {
    return Uri.parse(paramString1).buildUpon().appendQueryParameter("origin", paramString2).build().toString();
  }

  public static String h(String paramString)
  {
    return Uri.parse(paramString).buildUpon().appendQueryParameter("mcc", ViberApplication.getInstance().getHardwareParameters().getMCC()).appendQueryParameter("mnc", ViberApplication.getInstance().getHardwareParameters().getMNC()).build().toString();
  }

  public static String i(String paramString)
  {
    return Uri.parse(paramString).buildUpon().appendQueryParameter("sim_mcc", ViberApplication.getInstance().getHardwareParameters().getSimMCC()).appendQueryParameter("sim_mnc", ViberApplication.getInstance().getHardwareParameters().getSimMNC()).build().toString();
  }

  public static String j(String paramString)
  {
    af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    return Uri.parse(paramString).buildUpon().appendQueryParameter("sid", Integer.toString(o.b())).appendQueryParameter("cc", localaf.e()).appendQueryParameter("vv", p.d()).appendQueryParameter("uid", localaf.n()).build().toString();
  }

  public static String k(String paramString)
  {
    return Uri.parse(paramString).buildUpon().appendQueryParameter("action", "download").build().toString();
  }

  public static String l(String paramString)
  {
    return Uri.parse(paramString).buildUpon().appendQueryParameter("udid", ViberApplication.getInstance().getHardwareParameters().getUdid()).build().toString();
  }

  public static String m(String paramString)
  {
    return Uri.parse(paramString).buildUpon().appendQueryParameter("cpnFlag", "true").build().toString();
  }

  public static String n(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      String str2 = new URI(paramString).toString();
      return str2;
    }
    catch (Exception localException1)
    {
      try
      {
        URL localURL = new URL(paramString);
        String str1 = new URI(localURL.getProtocol(), localURL.getUserInfo(), localURL.getHost(), localURL.getPort(), localURL.getPath(), localURL.getQuery(), localURL.getRef()).toString();
        return str1;
      }
      catch (Exception localException2)
      {
      }
    }
    return paramString;
  }

  public static String o(String paramString)
  {
    if (!da.a(paramString))
      return a(Uri.parse(paramString));
    return "";
  }

  public static boolean p(String paramString)
  {
    String str = o(paramString).toLowerCase();
    return (str.contains("viber.com")) || (str.contains("viber.me")) || (str.contains("vb.me"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dl
 * JD-Core Version:    0.6.2
 */