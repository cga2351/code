package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.text.format.DateFormat;
import com.viber.common.b.d;
import com.viber.common.b.e;
import com.viber.common.b.h;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.f.a;
import com.viber.voip.settings.d.bl;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.co;
import com.viber.voip.ui.dialogs.t;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ai extends m
{
  public ai(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, d.bl.a.c(), "IVM heart shape start date").a(DateFormat.format("dd-MM-yyyy HH:mm:ss zzzz", d.bl.a.d()).toString()).a(this).a());
    x localx1 = new x(this.a, x.a.b, d.bl.c.c(), "IVM heart shape end date").a(DateFormat.format("dd-MM-yyyy HH:mm:ss zzzz", d.bl.b.d()).toString()).a(d.bl.c.f()).a(new CharSequence[] { "5d", "1d", "5m", "1m" });
    CharSequence[] arrayOfCharSequence1 = new CharSequence[4];
    arrayOfCharSequence1[0] = String.valueOf(TimeUnit.DAYS.toMillis(5L));
    arrayOfCharSequence1[1] = String.valueOf(TimeUnit.DAYS.toMillis(1L));
    arrayOfCharSequence1[2] = String.valueOf(TimeUnit.MINUTES.toMillis(5L));
    arrayOfCharSequence1[3] = String.valueOf(TimeUnit.MINUTES.toMillis(1L));
    f(localx1.b(arrayOfCharSequence1).a(this).a());
    x localx2 = new x(this.a, x.a.b, "key_ivm_duration", "IVM max duration").a(String.valueOf(d.bl.e.d())).a(String.valueOf(d.bl.e.f())).a(new CharSequence[] { "20 sec", "30 sec", "40 sec", "50 sec", "60 sec" });
    CharSequence[] arrayOfCharSequence2 = new CharSequence[5];
    arrayOfCharSequence2[0] = String.valueOf(TimeUnit.SECONDS.toMillis(20L));
    arrayOfCharSequence2[1] = String.valueOf(TimeUnit.SECONDS.toMillis(30L));
    arrayOfCharSequence2[2] = String.valueOf(TimeUnit.SECONDS.toMillis(40L));
    arrayOfCharSequence2[3] = String.valueOf(TimeUnit.SECONDS.toMillis(50L));
    arrayOfCharSequence2[4] = String.valueOf(TimeUnit.SECONDS.toMillis(60L));
    f(localx2.b(arrayOfCharSequence2).a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("ivm_key");
    paramPreferenceGroup.c("IVM");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (d.bl.a.c().equals(str))
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(d.bl.a.d());
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.set(10, 0);
      localCalendar2.set(12, 0);
      localCalendar2.set(13, 0);
      localCalendar2.set(14, 0);
      Calendar localCalendar3 = Calendar.getInstance();
      localCalendar3.setTimeInMillis(localCalendar2.getTimeInMillis());
      localCalendar3.set(1, 100 + localCalendar2.get(1));
      t.a(localCalendar1.get(5), localCalendar1.get(2), localCalendar1.get(1), localCalendar2.getTimeInMillis(), localCalendar3.getTimeInMillis()).a(new ViberDialogHandlers.co()).d();
    }
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (d.bl.c.c().equals(str))
    {
      long l = d.bl.a.d();
      d.bl.b.a(l + Long.parseLong((String)paramObject));
      d.bl.c.a((String)paramObject);
      ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c(d.bl.c.d()));
    }
    while (true)
    {
      return false;
      if ("key_ivm_duration".equals(str))
      {
        d.bl.e.a(Integer.valueOf((String)paramObject).intValue());
        ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c(String.valueOf(d.bl.e.d())));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ai
 * JD-Core Version:    0.6.2
 */