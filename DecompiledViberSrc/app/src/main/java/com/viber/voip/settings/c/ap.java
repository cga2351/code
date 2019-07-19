package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.text.TextUtils;
import android.widget.Toast;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.ap.a;
import com.viber.voip.av.e;
import com.viber.voip.schedule.l;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ap;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.z;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import java.util.concurrent.TimeUnit;

public class ap extends m
{
  private PreferenceScreen b;

  public ap(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramPreferenceScreen;
  }

  protected void a()
  {
    x localx1 = new x(this.a, x.a.d, d.z.o.c(), "WEB FLAGS: Debug");
    if (!TextUtils.isEmpty(d.z.o.d()));
    for (String str = d.z.o.d(); ; str = "Use Server")
    {
      f(localx1.a(str).a(this).a());
      f(new x(this.a, x.a.c, d.ax.s.c(), "Consume prods on del pkgs").b(d.ax.s.d()).a());
      f(new x(this.a, x.a.c, d.z.b.c(), "Enable URL change").b(d.z.b.d()).a());
      f(new x(this.a, x.a.d, d.z.d.c(), "set Market (stickers and games) base host").a(d.z.d.f()).a(this).a(com.viber.voip.ap.c().e()).a());
      f(new x(this.a, x.a.d, d.ap.a.c(), "set Vibes base host").a(d.ap.a.f()).a(this).a(com.viber.voip.ap.c().e()).a());
      f(new x(this.a, x.a.d, d.z.c.c(), "set Market API host").a(d.z.c.f()).a(this).a(com.viber.voip.ap.c().e()).a());
      f(new x(this.a, x.a.a, "reset_urls_key", "Reset stickers and games urls").a(this).a());
      f(new x(this.a, x.a.d, d.ad.y.c(), "Sticker packages notification url").a(d.ad.y.d()).a(d.ad.y.f()).a(this).a());
      f(new x(this.a, x.a.a, "reset_sticker_notification_json_key", "Reset sticker notification json url").a(this).a());
      f(new x(this.a, x.a.d, d.ax.m.c(), "Stickers json last modified date").a(d.ax.m.d()).a(d.ax.m.f()).a(this).a());
      f(new x(this.a, x.a.a, "run_stickers_json_checking_key", "Run stickers json checking").a(this).a());
      x localx2 = new x(this.a, x.a.b, d.z.e.c(), "Stickers & games update period").a(d.z.e.f()).a(new CharSequence[] { "24h", "1h", "10m", "5m", "1m" });
      CharSequence[] arrayOfCharSequence = new CharSequence[5];
      arrayOfCharSequence[0] = String.valueOf(TimeUnit.HOURS.toSeconds(24L));
      arrayOfCharSequence[1] = String.valueOf(TimeUnit.HOURS.toSeconds(1L));
      arrayOfCharSequence[2] = String.valueOf(TimeUnit.MINUTES.toSeconds(10L));
      arrayOfCharSequence[3] = String.valueOf(TimeUnit.MINUTES.toSeconds(5L));
      arrayOfCharSequence[4] = String.valueOf(TimeUnit.MINUTES.toSeconds(1L));
      f(localx2.b(arrayOfCharSequence).a(this).a());
      return;
    }
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("market_key");
    paramPreferenceGroup.c("Market (Debug options)");
  }

  public boolean a(Preference paramPreference)
  {
    boolean bool2;
    if (paramPreference.C().equals("reset_urls_key"))
    {
      d.z.d.e();
      com.viber.voip.ap.c().a();
      ((EditTextPreference)this.b.a(d.z.d.c())).a(d.z.d.d());
      ((EditTextPreference)this.b.a(d.z.c.c())).a(d.z.c.f());
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      if (paramPreference.C().equals("reset_sticker_notification_json_key"))
      {
        d.ad.y.e();
        Preference localPreference = this.b.a(d.ad.y.c());
        localPreference.b(d.ad.y.d());
        ((EditTextPreference)localPreference).a(d.ad.y.d());
        return true;
      }
      bool1 = paramPreference.C().equals("run_stickers_json_checking_key");
      bool2 = false;
    }
    while (!bool1);
    av.e.g.a().post(new Runnable()
    {
      public void run()
      {
        ViberApplication.getInstance().getDownloadValve().e(d.ad.y.d());
        new l().a(Bundle.EMPTY);
      }
    });
    Toast.makeText(this.a, "Checking stickers json was runned", 0).show();
    return true;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str1 = paramPreference.C();
    if (str1.equals(d.z.d.c()))
    {
      if (paramObject != null)
        com.viber.voip.ap.c().a();
      return true;
    }
    if (str1.equals(d.ap.a.c()))
    {
      if (paramObject != null)
        com.viber.voip.ap.c().a();
      return true;
    }
    if (str1.equals(d.z.c.c()))
    {
      if (paramObject != null)
        com.viber.voip.ap.c().a();
      return true;
    }
    if (str1.equals(d.ad.y.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    if (str1.equals(d.ax.m.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    if (d.z.e.c().equals(str1))
    {
      d.z.e.a((String)paramObject);
      p.a.b.c(ViberApplication.getApplication());
      ViberApplication.exit(null, true);
    }
    while (!d.z.o.c().equals(str1))
      return false;
    try
    {
      Integer.valueOf((String)paramObject);
      localObject = paramObject;
      d.z.o.a((String)localObject);
      Preference localPreference = this.b.a(d.z.o.c());
      if (TextUtils.isEmpty((String)localObject))
      {
        str2 = "Use server";
        localPreference.b(str2);
        return true;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Object localObject = d.z.o.f();
        continue;
        String str2 = (String)localObject;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ap
 * JD-Core Version:    0.6.2
 */