package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.j;
import com.viber.common.b.b;
import com.viber.common.b.e;
import com.viber.common.dialogs.h.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.l;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.dialogs.ad;
import java.util.concurrent.TimeUnit;

public class o extends m
{
  private final j b;
  private final bs c;

  public o(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    this.c = new bs(paramContext);
    this.b = paramPreferenceScreen.L();
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.l.b.c(), "Can send promotion message").a(Boolean.valueOf(d.l.b.f())).a(this).a());
    f(new x(this.a, x.a.a, "key_business_inbox_promotion_message", "Send promotion message").a(d.l.b.d()).a(this).a());
    x localx1 = new x(this.a, x.a.b, "key_debug_business_inbox_autoclean_period", "Autoclean period").a(String.valueOf(d.l.c.f())).a(new CharSequence[] { "24h", "1h", "5m", "1m" });
    CharSequence[] arrayOfCharSequence1 = new CharSequence[4];
    arrayOfCharSequence1[0] = String.valueOf(TimeUnit.HOURS.toSeconds(24L));
    arrayOfCharSequence1[1] = String.valueOf(TimeUnit.HOURS.toSeconds(1L));
    arrayOfCharSequence1[2] = String.valueOf(TimeUnit.MINUTES.toSeconds(5L));
    arrayOfCharSequence1[3] = String.valueOf(TimeUnit.MINUTES.toSeconds(1L));
    f(localx1.b(arrayOfCharSequence1).a(this).a());
    x localx2 = new x(this.a, x.a.b, "key_debug_business_inbox_autoclean_max_message_age", "Autoclean max unread message age").a(String.valueOf(d.l.d.f())).a(new CharSequence[] { "30d", "1d", "10m", "3m", "1m", "30s", "15s" });
    CharSequence[] arrayOfCharSequence2 = new CharSequence[7];
    arrayOfCharSequence2[0] = String.valueOf(TimeUnit.DAYS.toMillis(30L));
    arrayOfCharSequence2[1] = String.valueOf(TimeUnit.DAYS.toMillis(1L));
    arrayOfCharSequence2[2] = String.valueOf(TimeUnit.MINUTES.toMillis(10L));
    arrayOfCharSequence2[3] = String.valueOf(TimeUnit.MINUTES.toMillis(3L));
    arrayOfCharSequence2[4] = String.valueOf(TimeUnit.MINUTES.toMillis(1L));
    arrayOfCharSequence2[5] = String.valueOf(TimeUnit.SECONDS.toMillis(30L));
    arrayOfCharSequence2[6] = String.valueOf(TimeUnit.SECONDS.toMillis(15L));
    f(localx2.b(arrayOfCharSequence2).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("business_inbox_key");
    paramPreferenceGroup.c("Business Inbox");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if ("key_business_inbox_promotion_message".equals(str))
      av.a(av.e.d).post(new p(this));
    while (true)
    {
      return false;
      if (d.l.b.c().equals(str))
        this.b.a("key_business_inbox_promotion_message").a(d.l.b.d());
    }
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    if ("key_debug_business_inbox_autoclean_period".equals(paramPreference.C()))
    {
      ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c((String)paramObject));
      d.l.c.a(Long.parseLong((String)paramObject));
      p.a.h.c(this.a);
      ad.t().d();
    }
    while (true)
    {
      return super.a(paramPreference, paramObject);
      if ("key_debug_business_inbox_autoclean_max_message_age".equals(paramPreference.C()))
      {
        ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c((String)paramObject));
        d.l.d.a(Long.parseLong((String)paramObject));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.o
 * JD-Core Version:    0.6.2
 */