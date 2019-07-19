package com.viber.voip.analytics.story;

import android.support.v4.util.ArrayMap;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.analytics.e.g;
import com.viber.voip.pixie.ProxySettings;
import com.viber.voip.pixie.ProxySettingsHolder;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.af;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.r;
import com.viber.voip.util.da;

public class c
{
  public static void a(ArrayMap<f, g> paramArrayMap)
  {
    paramArrayMap.put(n.a("Settings - Share Online Status", Boolean.valueOf(d.bf.j.d())), g.c);
    paramArrayMap.put(n.a("Settings - Send Seen Status", Boolean.valueOf(d.ag.f.d())), g.c);
    paramArrayMap.put(n.a("Settings - Collect Analytics Data", Boolean.valueOf(d.f.b.d())), g.c);
    paramArrayMap.put(n.a("Settings - Show Your Photo", Boolean.valueOf(d.ad.r.d())), g.c);
    paramArrayMap.put(n.a("Settings - In-App Vibrate", Boolean.valueOf(d.m.b.d())), g.c);
    paramArrayMap.put(n.a("Settings - Show Message Preview", Boolean.valueOf(d.ag.b.d())), g.c);
    paramArrayMap.put(n.a("Settings - Contact Joined Viber", Boolean.valueOf(d.p.b.d())), g.c);
    paramArrayMap.put(n.a("Settings - Viber-In Calls", Boolean.valueOf(d.m.f.d())), g.c);
    paramArrayMap.put(n.a("Settings - Receive Business Messages", Boolean.valueOf(d.r.B.d())), g.c);
    paramArrayMap.put(n.a("Settings - Restrict Data Usage", Boolean.valueOf(d.af.c.d())), g.c);
    paramArrayMap.put(n.a("Settings - Open Links Internally", Boolean.valueOf(d.r.D.d())), g.c);
    if (da.a(d.r.e.d()));
    ProxySettings localProxySettings;
    for (String str = "None"; ; str = localProxySettings.url + ":" + localProxySettings.port)
    {
      paramArrayMap.put(n.a("Settings - Use Proxy", str), g.c);
      paramArrayMap.put(n.a("Settings - Auto Download Media on 3G", Boolean.valueOf(d.af.a.d())), g.c);
      paramArrayMap.put(n.a("Settings - Auto Download Media on Wi-Fi", Boolean.valueOf(d.af.b.d())), g.c);
      paramArrayMap.put(n.a("Settings - Peer2Peer", Boolean.valueOf(d.ad.V.d())), g.c);
      return;
      localProxySettings = ProxySettingsHolder.obtain();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.c
 * JD-Core Version:    0.6.2
 */