package com.viber.voip.analytics.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.voip.av.e;
import com.viber.voip.backgrounds.m;
import com.viber.voip.backgrounds.p;
import com.viber.voip.pixie.ProxySettings;
import com.viber.voip.pixie.ProxySettingsHolder;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.settings.d.af;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.i;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.r;
import com.viber.voip.user.UserData;
import java.util.Map;

public class d extends c
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private dagger.a<a> a = new com.viber.voip.g.b.b()
  {
    protected d.a a()
    {
      return new d.a(null);
    }
  };
  private final com.viber.voip.analytics.story.g.a b;
  private final UserData c;

  public d(com.viber.voip.analytics.story.g.a parama, UserData paramUserData, boolean paramBoolean)
  {
    this.b = parama;
    this.c = paramUserData;
    a(paramBoolean);
  }

  private static String b()
  {
    ProxySettings localProxySettings = ProxySettingsHolder.obtain();
    if ((localProxySettings.enabled) && (!TextUtils.isEmpty(localProxySettings.url)))
      return localProxySettings.url;
    return "None";
  }

  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return "Value Changed Unavailable";
    p localp = m.a(paramString, 0);
    if (localp != null)
      return localp.d() + String.valueOf(localp.a);
    return "Custom";
  }

  private static String e(String paramString)
  {
    if ("pref_wifi_policy_use_device_settings".equals(paramString))
      return "Use device's settings";
    if ("pref_wifi_policy_always_connected".equals(paramString))
      return "Always connected";
    return "Value Changed Unavailable";
  }

  private static String f(String paramString)
  {
    if ("pref_pixie_mode_auto".equals(paramString))
      return "Auto";
    if ("pref_pixie_mode_always_on".equals(paramString))
      return "Always on";
    if ("pref_pixie_mode_off".equals(paramString))
      return "Off";
    return "Value Changed Unavailable";
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.get();
      com.viber.voip.settings.d.a(this);
      return;
    }
    com.viber.voip.settings.d.b(this);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    av.e.g.a().post(new e(this, paramString, paramSharedPreferences));
  }

  private static class a
  {
    final Map<String, d.b> a = new ArrayMap();

    private a()
    {
      this.a.put(d.bf.j.c(), new d.b("Privacy", "Share online status", Boolean.valueOf(d.bf.j.d()), true));
      this.a.put(d.ag.f.c(), new d.b("Privacy", "Share seen status", Boolean.valueOf(d.ag.f.d()), true));
      this.a.put(d.ad.r.c(), new d.b("Privacy", "Show your photo", Boolean.valueOf(d.ad.r.d()), true));
      this.a.put(d.ad.V.c(), new d.b("Privacy", "Use Peer-to-peer", Boolean.valueOf(d.ad.V.d()), true));
      this.a.put(d.f.b.c(), new d.b("Privacy", "Collect analytics", Boolean.valueOf(d.f.b.d()), true));
      this.a.put(d.f.c.c(), new d.b("Privacy", "Allow content personalization", Boolean.valueOf(d.f.c.d()), true));
      this.a.put(d.f.d.c(), new d.b("Privacy", "Allow interest-based ads", Boolean.valueOf(d.f.d.d()), true));
      this.a.put(d.f.e.c(), new d.b("Privacy", "Allow accurate location-based serices", Boolean.valueOf(d.f.e.d()), true));
      this.a.put(d.ag.b.c(), new d.b("Notifications", "Show messages preview", Boolean.valueOf(d.ag.b.d()), true));
      this.a.put(d.p.b.c(), new d.b("Notifications", "Contact joined Viber", Boolean.valueOf(d.p.b.d()), true));
      Map localMap1 = this.a;
      String str1 = d.ag.a.c();
      boolean bool1;
      Map localMap2;
      String str2;
      if ((!com.viber.common.d.a.o()) && (d.ag.a.d()))
      {
        bool1 = true;
        localMap1.put(str1, new d.b("Notifications", "New message popup", Boolean.valueOf(bool1), true));
        this.a.put(d.ag.d.c(), new d.b("Notifications", "Light screen for messages", Boolean.valueOf(d.ag.d.d()), true));
        localMap2 = this.a;
        str2 = d.ag.c.c();
        if ((com.viber.common.d.a.o()) || (!d.ag.c.d()))
          break label1309;
      }
      label1309: for (boolean bool2 = true; ; bool2 = false)
      {
        localMap2.put(str2, new d.b("Notifications", "Unlock for popups", Boolean.valueOf(bool2), true));
        this.a.put(d.ag.h.c(), new d.b("Notifications", "Outgoing messages sounds", Boolean.valueOf(d.ag.h.d()), true));
        this.a.put(d.m.a.c(), new d.b("Notifications", "Use system sounds", Boolean.valueOf(d.m.a.d()), true));
        this.a.put(d.m.c.c(), new d.b("Notifications", "Call ringtone", d.m.c.d(), false));
        this.a.put(d.ag.i.c(), new d.b("Notifications", "Notification sound", d.ag.i.d(), false));
        this.a.put(d.m.b.c(), new d.b("Notifications", "Vibrate when ringing", Boolean.valueOf(d.m.b.d()), true));
        this.a.put(d.m.f.c(), new d.b("Calls and Messages", "Viber-In calls", Boolean.valueOf(d.m.f.d()), true));
        this.a.put(d.r.B.c(), new d.b("Calls and Messages", "Receive service messages", Boolean.valueOf(d.r.B.d()), true));
        this.a.put(d.m.k.c(), new d.b("Calls and Messages", "Use device proximity sensor", Boolean.valueOf(d.m.k.d()), true));
        this.a.put(d.r.a.c(), new d.b("Calls and Messages", "Press enter to send", Boolean.valueOf(d.r.a.d()), true));
        this.a.put(d.af.a.c(), new d.b("Media", "Auto download media over mobile network", Boolean.valueOf(d.af.a.d()), true));
        this.a.put(d.af.b.c(), new d.b("Media", "Auto download media when connected to Wi-Fi", Boolean.valueOf(d.af.b.d()), true));
        this.a.put(d.af.c.c(), new d.b("Media", "Restrict data usage", Boolean.valueOf(d.af.c.d()), true));
        this.a.put(d.i.d.c(), new d.b("Chat background", "Change default background", d.a(d.i.d.d()), false));
        this.a.put(d.ag.e.c(), new d.b("General", "Show Viber status icon", Boolean.valueOf(d.ag.e.d()), true));
        this.a.put(d.p.c.c(), new d.b("General", "Show all contacts", Boolean.valueOf(d.p.c.d()), true));
        this.a.put(d.p.g.c(), new d.b("General", "Sync contacts", Boolean.valueOf(d.p.g.d()), true));
        this.a.put(d.ad.a.c.c(), new d.b("General", "Select Language", d.ad.a.c.d(), false));
        this.a.put(d.r.D.c(), new d.b("General", "Open links internally", Boolean.valueOf(d.r.D.d()), true));
        this.a.put(d.r.e.c(), new d.b("General", "Use Proxy", d.a(), false));
        this.a.put(d.af.d.c(), new d.b("General", "Wi-Fi - sleep policy", d.b(d.af.d.d()), false));
        this.a.put(d.af.e.c(), new d.b("General", "Enhance Connectivity", d.c(d.af.e.d()), false));
        return;
        bool1 = false;
        break;
      }
    }
  }

  static class b
  {
    final String a;
    final String b;
    Object c;
    final boolean d;

    b(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramObject;
      this.d = paramBoolean;
    }

    public String toString()
    {
      return "TrackableSetting{changeSettingsCategory='" + this.a + '\'' + ", name='" + this.b + '\'' + ", initialValue='" + this.c + '\'' + ", isBooleanSetting='" + this.d + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.d.d
 * JD-Core Version:    0.6.2
 */