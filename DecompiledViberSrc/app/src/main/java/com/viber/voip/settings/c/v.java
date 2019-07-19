package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.m.a;
import com.viber.voip.contacts.c.f.b.c;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.a;
import com.viber.voip.model.j;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.cd;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class v extends m
{
  public v(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  private void a(final boolean paramBoolean)
  {
    ViberApplication.getInstance().getContactManager().c().a(new m.a()
    {
      public void a(boolean paramAnonymousBoolean, a paramAnonymousa)
      {
        if (paramAnonymousa != null)
        {
          j localj = (j)paramAnonymousa.s().iterator().next();
          ViberApplication.getInstance().getContactManager().d().a(new Member(localj.a(), localj.c()), "", "android", paramBoolean);
        }
      }
    });
  }

  protected void a()
  {
    f(new x(this.a, x.a.a, "key_create_contact_join_notification", "Create contact join notification").a(this).a());
    f(new x(this.a, x.a.a, "key_create_contact_rejoin_notification", "Create contact rejoin notification").a(this).a());
    x localx1 = new x(this.a, x.a.a, "number_of_sent_engagement_sticker_packs_reset", "Reset engagement stickers");
    Locale localLocale = Locale.ENGLISH;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(d.r.o.d());
    f(localx1.a(String.format(localLocale, "\"Engagement Stickers\" received %d times", arrayOfObject)).a(this).a());
    x localx2 = new x(this.a, x.a.b, d.p.n.c(), "Engagement: expritation period").a(d.p.n.f()).a(new CharSequence[] { "48h", "5m", "2m", "1m" });
    CharSequence[] arrayOfCharSequence1 = new CharSequence[4];
    arrayOfCharSequence1[0] = String.valueOf(TimeUnit.HOURS.toSeconds(48L));
    arrayOfCharSequence1[1] = String.valueOf(TimeUnit.MINUTES.toSeconds(5L));
    arrayOfCharSequence1[2] = String.valueOf(TimeUnit.MINUTES.toSeconds(2L));
    arrayOfCharSequence1[3] = String.valueOf(TimeUnit.MINUTES.toSeconds(1L));
    f(localx2.b(arrayOfCharSequence1).a(this).a());
    f(new x(this.a, x.a.d, d.p.o.c(), "Set Engagement JSON url").a(d.p.o.f()).a());
    x localx3 = new x(this.a, x.a.b, d.p.p.c(), "Engagement JSON sync period").a(d.p.p.f()).a(new CharSequence[] { "24h", "1h", "5m", "1m" });
    CharSequence[] arrayOfCharSequence2 = new CharSequence[4];
    arrayOfCharSequence2[0] = String.valueOf(TimeUnit.HOURS.toSeconds(24L));
    arrayOfCharSequence2[1] = String.valueOf(TimeUnit.HOURS.toSeconds(1L));
    arrayOfCharSequence2[2] = String.valueOf(TimeUnit.MINUTES.toSeconds(5L));
    arrayOfCharSequence2[3] = String.valueOf(TimeUnit.MINUTES.toSeconds(1L));
    f(localx3.b(arrayOfCharSequence2).a(this).a());
    x localx4 = new x(this.a, x.a.a, "key_participants_emid_mapping_finished", "Participants emid mapping completed:");
    if (cd.a());
    for (String str = "Yes"; ; str = "No")
    {
      f(localx4.a(str).a());
      return;
    }
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("contacts_debug_key");
    paramPreferenceGroup.c("Contacts");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("key_create_contact_join_notification"))
      a(false);
    do
    {
      return false;
      if (str.equals("key_create_contact_rejoin_notification"))
      {
        a(true);
        return false;
      }
    }
    while (!str.equals("number_of_sent_engagement_sticker_packs_reset"));
    d.r.o.e();
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (d.p.n.c().equals(str))
    {
      d.p.n.a((String)paramObject);
      ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c(d.p.n.d()));
      p.a.d.c(ViberApplication.getApplication());
      av.a(av.e.a).postDelayed(w.a, 2000L);
    }
    while (true)
    {
      return false;
      if (d.p.p.c().equals(str))
      {
        d.p.p.a((String)paramObject);
        ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c(d.p.p.d()));
        p.a.d.c(ViberApplication.getApplication());
        ViberApplication.exit(null, true);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.v
 * JD-Core Version:    0.6.2
 */