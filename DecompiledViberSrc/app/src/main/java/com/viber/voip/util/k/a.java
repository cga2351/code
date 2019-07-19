package com.viber.voip.util.k;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.SDKSettings;
import com.appnexus.opensdk.utils.Settings;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.j;
import com.viber.voip.i.f;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.settings.d.bh;
import com.viber.voip.settings.d.bj;
import com.viber.voip.settings.d.c;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.v;
import com.viber.voip.util.ax;
import com.viber.voip.util.cj;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class a
{
  public static final Set<String> a;
  private static final Logger b = ViberEnv.getLogger();
  private static Map<com.viber.voip.ads.b.b.b.c, b> c;

  static
  {
    a = new HashSet(4);
    a.add("2G");
    a.add("3G");
    a.add("4G");
    a.add("Wifi");
    c = new HashMap();
    c.put(com.viber.voip.ads.b.b.b.c.b, new f());
    c.put(com.viber.voip.ads.b.b.b.c.d, new d());
    c.put(com.viber.voip.ads.b.b.b.c.a, new c());
    c.put(com.viber.voip.ads.b.b.b.c.f, new e());
  }

  public static int a(Context paramContext)
  {
    int[] arrayOfInt = j.a(paramContext, false);
    Resources localResources = paramContext.getResources();
    int i = localResources.getDimensionPixelSize(R.dimen.ads_after_call_container_left_padding) + 2 * localResources.getDimensionPixelSize(R.dimen.ads_after_call_container_left_right_padding) + 2 * localResources.getDimensionPixelSize(R.dimen.ads_after_call_content_padding);
    return arrayOfInt[0] - i;
  }

  public static Pair<Integer, String> a(int paramInt)
  {
    String str = "SDK failure";
    int i;
    switch (paramInt)
    {
    default:
      i = 1;
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return new Pair(Integer.valueOf(i), str);
      i = 4;
      str = "SDK internal error";
      continue;
      i = 5;
      str = "invalid request";
      continue;
      i = 6;
      str = "network error";
      continue;
      i = 7;
      str = "no fill";
    }
  }

  public static Pair<Integer, String> a(ResultCode paramResultCode)
  {
    String str = "SDK failure";
    int i;
    switch (1.b[paramResultCode.ordinal()])
    {
    default:
      i = 1;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return new Pair(Integer.valueOf(i), str);
      i = 4;
      str = "SDK internal error";
      continue;
      i = 5;
      str = "invalid request";
      continue;
      i = 6;
      str = "network error";
      continue;
      i = 7;
      str = "no fill";
    }
  }

  @NotNull
  public static com.viber.voip.ads.a.d a(com.viber.common.b.d paramd, MediationAdRequest paramMediationAdRequest)
  {
    com.viber.voip.ads.a.d locald = com.viber.voip.ads.a.d.fromId(paramd.d());
    if (locald != com.viber.voip.ads.a.d.UNKNOWN)
      return locald;
    return com.viber.voip.ads.a.d.fromId(paramMediationAdRequest.getGender());
  }

  private static a a(Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1) - paramCalendar.get(1);
    int j = localCalendar.get(2);
    int k = paramCalendar.get(2);
    if ((j < k) || ((j == k) && (localCalendar.get(5) < paramCalendar.get(5))))
      i--;
    if (i > 50)
      return a.e;
    if (i > 34)
      return a.d;
    if (i > 24)
      return a.c;
    if (i > 17)
      return a.b;
    return a.a;
  }

  public static String a(com.viber.voip.ads.b.b.b.c paramc, boolean paramBoolean)
  {
    switch (1.a[paramc.ordinal()])
    {
    default:
      return "";
    case 1:
      return ((b)c.get(com.viber.voip.ads.b.b.b.c.d)).a(paramBoolean);
    case 2:
      return ((b)c.get(com.viber.voip.ads.b.b.b.c.a)).a(paramBoolean);
    case 3:
      return ((b)c.get(com.viber.voip.ads.b.b.b.c.b)).a(paramBoolean);
    case 4:
    }
    return ((b)c.get(com.viber.voip.ads.b.b.b.c.f)).a(paramBoolean);
  }

  public static Calendar a(MediationAdRequest paramMediationAdRequest)
  {
    Calendar localCalendar1 = b();
    if (localCalendar1 != null)
      return localCalendar1;
    if ((paramMediationAdRequest != null) && (paramMediationAdRequest.getBirthday() != null))
    {
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime(paramMediationAdRequest.getBirthday());
      return localCalendar2;
    }
    return null;
  }

  public static void a()
  {
    Settings.getSettings().debug_mode = false;
  }

  public static void a(com.viber.common.permission.c paramc)
  {
    boolean bool = paramc.a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
    SDKSettings.setLocationEnabled(bool);
    if (bool)
    {
      Location localLocation = ViberApplication.getInstance().getLocationManager().b(0);
      if (localLocation != null)
        SDKSettings.setLocation(localLocation);
    }
    else
    {
      return;
    }
    SDKSettings.setLocationEnabled(false);
  }

  public static void a(com.viber.common.permission.c paramc, AdRequest.Builder paramBuilder)
  {
    if (paramc.a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }))
    {
      Location localLocation = ViberApplication.getInstance().getLocationManager().b(0);
      if (localLocation != null)
        paramBuilder.setLocation(localLocation);
    }
  }

  public static void a(com.viber.common.permission.c paramc, PublisherAdRequest.Builder paramBuilder)
  {
    if (paramc.a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }))
    {
      Location localLocation = ViberApplication.getInstance().getLocationManager().b(0);
      if (localLocation != null)
        paramBuilder.setLocation(localLocation);
    }
  }

  public static boolean a(AdSize paramAdSize, Context paramContext)
  {
    int i = paramAdSize.getWidthInPixels(paramContext);
    paramAdSize.getHeightInPixels(paramContext);
    if (dj.a(paramContext));
    for (int j = j.a(paramContext, false)[0]; ; j = a(paramContext))
    {
      boolean bool = false;
      if (i <= j)
        bool = true;
      return bool;
    }
  }

  public static Calendar b()
  {
    String str = d.c.b.d();
    if (!TextUtils.isEmpty(str))
    {
      Calendar localCalendar = Calendar.getInstance();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
      try
      {
        localCalendar.setTime(localSimpleDateFormat.parse(str));
        return localCalendar;
      }
      catch (ParseException localParseException)
      {
      }
    }
    return null;
  }

  public static Map<String, String> b(Context paramContext)
  {
    HashMap localHashMap = new HashMap(5);
    localHashMap.put("lang", Locale.getDefault().getLanguage());
    localHashMap.put("v_ver", p.e());
    Calendar localCalendar = b();
    if (localCalendar != null)
      localHashMap.put("age_group", a(localCalendar).b());
    com.viber.voip.ads.a.d locald = com.viber.voip.ads.a.d.values()[d.c.a.d()];
    if (locald != null)
      localHashMap.put("gender", locald.toTargetingParamGender());
    String str = cj.g(paramContext);
    if ((!TextUtils.isEmpty(str)) && (a.contains(str)))
      localHashMap.put("connection", str);
    return localHashMap;
  }

  public static Map<String, String> c(Context paramContext)
  {
    HashMap localHashMap = new HashMap(12);
    localHashMap.put("ck_os_language", Locale.getDefault().getLanguage());
    localHashMap.put("ck_version", p.e());
    Calendar localCalendar = b();
    if (localCalendar != null)
      localHashMap.put("ck_age_group", a(localCalendar).a());
    com.viber.voip.ads.a.d locald = com.viber.voip.ads.a.d.values()[d.c.a.d()];
    if (locald != null)
      localHashMap.put("ck_gender", locald.toTargetingParamGender());
    String str1 = cj.g(paramContext);
    if ((!TextUtils.isEmpty(str1)) && (a.contains(str1)))
      localHashMap.put("ck_connection", str1);
    String str2 = ViberApplication.getInstance().getHardwareParameters().getMCC();
    if (!TextUtils.isEmpty(str2))
      localHashMap.put("ck_mcc_value", str2);
    String str3 = ViberApplication.getInstance().getHardwareParameters().getMNC();
    if (!TextUtils.isEmpty(str3))
      localHashMap.put("ck_mnc_value", str3);
    String str4 = ViberApplication.getInstance().getHardwareParameters().getCN();
    if (!TextUtils.isEmpty(str4))
      localHashMap.put("ck_carrier", str4);
    if (c.j.a.e())
      localHashMap.put("euconsent", d.v.q.d());
    if (d.f.d.d())
      localHashMap.put("ck_advertising_id", ax.a());
    String str5;
    if (d.bj.a.d())
    {
      str5 = "1";
      localHashMap.put("ck_vo_user", str5);
      if (!d.bh.b.d())
        break label322;
    }
    label322: for (String str6 = "1"; ; str6 = "0")
    {
      localHashMap.put("ck_vln_user", str6);
      return localHashMap;
      str5 = "0";
      break;
    }
  }

  private static enum a
  {
    private final String f;
    private final String g;

    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }

    private a(String paramString1, String paramString2)
    {
      this.f = paramString1;
      this.g = paramString2;
    }

    String a()
    {
      return this.f;
    }

    String b()
    {
      return this.g;
    }
  }

  private static abstract class b
  {
    boolean a = true;
    String b;
    String c;

    String a(boolean paramBoolean)
    {
      if (paramBoolean)
        return this.b;
      return this.c;
    }
  }

  private static class c extends a.b
  {
    c()
    {
      String str1;
      if (this.a)
      {
        str1 = "12375637";
        this.b = str1;
        if (!this.a)
          break label41;
      }
      label41: for (String str2 = "12349511"; ; str2 = "12693851")
      {
        this.c = str2;
        return;
        str1 = "12693879";
        break;
      }
    }
  }

  private static class d extends a.b
  {
    d()
    {
      if (this.a);
      for (String str = "12671897"; ; str = "12693675")
      {
        this.c = str;
        this.b = str;
        return;
      }
    }
  }

  private static class e extends a.b
  {
    e()
    {
      if (this.a);
      for (String str = "12693693"; ; str = "12693695")
      {
        this.c = str;
        this.b = str;
        return;
      }
    }
  }

  private static class f extends a.b
  {
    f()
    {
      String str1;
      if (this.a)
      {
        str1 = "12693909";
        this.b = str1;
        if (!this.a)
          break label41;
      }
      label41: for (String str2 = "12693901"; ; str2 = "12693904")
      {
        this.c = str2;
        return;
        str1 = "12693924";
        break;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.k.a
 * JD-Core Version:    0.6.2
 */