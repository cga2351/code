package com.viber.voip.settings.ui;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.c.a;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.b;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.settings.SettingsController;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.d.c;
import com.viber.voip.analytics.g;
import com.viber.voip.block.BlockListActivity;
import com.viber.voip.contacts.ui.HiddenChatsSettingsActivity;
import com.viber.voip.gdpr.d;
import com.viber.voip.i.c.j;
import com.viber.voip.i.f;
import com.viber.voip.messages.extras.a.e.a;
import com.viber.voip.messages.extras.a.e.d;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.au;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.d.v;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.ViberActionRunner.bl;
import java.io.Serializable;
import javax.inject.Inject;

public class y extends SettingsHeadersActivity.a
  implements m.c, al.a
{
  static volatile PendingIntent b;
  private static final Logger f = ViberEnv.getLogger();

  @Inject
  Handler c;

  @Inject
  g d;

  @Inject
  ICdrController e;
  private SettingsController g;
  private boolean h;
  private e.a j;
  private al k;

  private static void a(long paramLong, Activity paramActivity)
  {
    long l = paramLong + 86400000L;
    try
    {
      AlarmManager localAlarmManager = (AlarmManager)paramActivity.getSystemService("alarm");
      if (b == null)
        b = PendingIntent.getBroadcast(paramActivity, 0, new Intent("com.viber.voip.action.SETTINGS_CHANGE_CHECK"), 134217728);
      while (true)
      {
        localAlarmManager.set(0, l, b);
        d.bf.h.a(true);
        return;
        localAlarmManager.cancel(b);
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void b(Runnable paramRunnable)
  {
    this.c.post(new aa(this, paramRunnable));
  }

  public static void j()
  {
    SettingsController localSettingsController = ViberApplication.getInstance().getEngine(true).getSettingsController();
    d.bf.j.e();
    d.bf.g.e();
    localSettingsController.handleChangeLastOnlineSettings(1);
    d.ag.f.e();
    localSettingsController.handleChangeReadNotificationsSettings(1);
    d.ad.r.e();
    d.ad.V.e();
    if (!ao.f())
      d.c();
  }

  private void k()
  {
    b(d.bf.j.c(), d.bf.j.d());
  }

  private void l()
  {
    if (getActivity() != null)
      getActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          com.viber.voip.messages.extras.a.e locale = ViberApplication.getInstance().getFacebookManager();
          String str1 = locale.e();
          Preference localPreference = y.this.a(d.au.a.c());
          if (locale.b() != e.d.d);
          for (String str2 = y.this.getString(R.string.pref_twitter_summary_connected, new Object[] { str1 }); ; str2 = y.this.getString(R.string.facebook_setting_summary_for_auth))
          {
            localPreference.b(str2);
            return;
          }
        }
      });
  }

  public void a(String paramString, boolean paramBoolean)
  {
    b(paramString, paramBoolean);
  }

  public boolean a(Preference paramPreference)
  {
    if (d.bf.j.c().equals(paramPreference.C()))
    {
      long l = d.bf.g.d();
      boolean bool2 = ((CheckBoxPreference)paramPreference).b();
      if (System.currentTimeMillis() - l < 86400000L)
      {
        a locala = new a(l);
        t.f().a(this).a(locala).b(this);
        CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)paramPreference;
        if (!bool2);
        for (boolean bool3 = true; ; bool3 = false)
        {
          localCheckBoxPreference.f(bool3);
          return true;
        }
      }
      SettingsController localSettingsController2 = this.g;
      int m = 0;
      if (bool2)
        m = 1;
      localSettingsController2.handleChangeLastOnlineSettings(m);
      d.bf.g.a(System.currentTimeMillis());
      return true;
    }
    if (d.ag.f.c().equals(paramPreference.C()))
    {
      boolean bool1 = ((CheckBoxPreference)paramPreference).b();
      SettingsController localSettingsController1 = this.g;
      int i = 0;
      if (bool1)
        i = 1;
      localSettingsController1.handleChangeReadNotificationsSettings(i);
      return true;
    }
    if (d.au.a.c().equals(paramPreference.C()))
    {
      final com.viber.voip.messages.extras.a.e locale = ViberApplication.getInstance().getFacebookManager();
      if (locale.b() != e.d.d)
      {
        String str = locale.e();
        new c.a(getActivity()).b(getString(R.string.facebook_change_user_msg, new Object[] { str })).b(R.string.cancel_btn_text, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.dismiss();
          }
        }).a(R.string.facebook_change_account_btn, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.dismiss();
            locale.a();
            y.a(y.this, new e.a()
            {
              public void onAuthorizationCanceled()
              {
                y.a(y.this);
              }

              public void onAuthorizationSuccess(boolean paramAnonymous2Boolean)
              {
                y.a(y.this);
              }

              public void onFacebookProfileStored()
              {
                y.a(y.this);
              }
            });
            locale.a(y.this.getActivity(), y.b(y.this));
          }
        }).c();
        return true;
      }
      this.j = new e.a()
      {
        public void onFacebookProfileStored()
        {
          y.a(y.this);
        }
      };
      locale.a(getActivity(), this.j);
      return true;
    }
    if (d.ad.s.c().equals(paramPreference.C()))
      ViberActionRunner.bl.b(getActivity());
    while (true)
    {
      return super.a(paramPreference);
      if (d.ad.r.c().equals(paramPreference.C()))
      {
        if (((CheckBoxPreference)paramPreference).b())
          break;
        b(new z(this, paramPreference));
        return true;
      }
      if (getString(R.string.pref_block_list_key).equals(paramPreference.C()))
        startActivity(new Intent("com.viber.voip.action.BLOCK_LIST"));
      else if (getString(R.string.pref_hidden_chats_key).equals(paramPreference.C()))
        startActivity(new Intent("com.viber.voip.action.HIDDEN_CHATS"));
      else if (getString(R.string.pref_clear_trusted_contacts_key).equals(paramPreference.C()))
        startActivity(new Intent("com.viber.voip.action.TRUSTED_CONTACTS"));
      else if (getString(R.string.pref_personal_data_key).equals(paramPreference.C()))
        startActivity(new Intent("com.viber.voip.action.PERSONAL_DATA_SETTINGS"));
    }
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_privacy, paramString);
  }

  public void i()
  {
    if (getActivity() != null)
      l();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ViberApplication.getInstance().getFacebookManager().a(getActivity(), paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.k = new al(this, this);
    this.g = ViberApplication.getInstance().getEngine(false).getSettingsController();
    this.h = d.bf.k.d();
    if (ao.f())
    {
      b().d(a(d.bf.j.c()));
      b().d(a(d.ag.f.c()));
      b().d(a(d.p.d.c()));
      b().d(a(d.ad.r.c()));
      b().d(a(d.r.b.c()));
      b().d(a(d.ad.t.c()));
      b().d(a(d.ad.V.c()));
      boolean bool1 = c.j.c.e();
      boolean bool2 = c.j.b.e();
      if (((!bool1) && (!bool2)) || (ao.f()))
        b().d(a(d.v.c.c()));
      if ((bool2) || (bool1) || (ao.f()))
        b().d(a(d.f.b.c()));
      if ((!ao.f()) && (getArguments() != null) && (getArguments().containsKey("inner_screen")))
        switch (getArguments().getByte("inner_screen"))
        {
        default:
        case 1:
        case 2:
        }
    }
    while (true)
    {
      getArguments().remove("inner_screen");
      return;
      if (this.h)
        break;
      b().d(a(d.r.b.c()));
      break;
      startActivity(new Intent(getActivity(), HiddenChatsSettingsActivity.class));
      continue;
      startActivity(new Intent(getActivity(), BlockListActivity.class));
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    ViberApplication.getInstance().getFacebookManager().a(this.j);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D410)) && (paramInt == -1))
    {
      a(((a)paramm.d()).a, getActivity());
      return;
    }
    if (paramm.a(DialogCode.D1025a))
    {
      this.d.h().a(true);
      return;
    }
    this.k.onDialogAction(paramm, paramInt);
  }

  public void onResume()
  {
    super.onResume();
    l();
    k();
    this.k.a();
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
    if (paramString.equals(d.bf.j.c()))
    {
      b(paramString, d.bf.j.d());
      CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)this.i.a(paramString);
      if ((localCheckBoxPreference2 != null) && (!localCheckBoxPreference2.z()))
        a(d.bf.j.c()).a(true);
    }
    CheckBoxPreference localCheckBoxPreference1;
    do
    {
      return;
      if (!paramString.equals(d.ag.f.c()))
        break;
      b(paramString, d.ag.f.d());
      localCheckBoxPreference1 = (CheckBoxPreference)this.i.a(paramString);
    }
    while ((localCheckBoxPreference1 == null) || (localCheckBoxPreference1.z()));
    a(d.ag.f.c()).a(true);
    return;
    if (d.ad.V.c().equals(paramString))
    {
      if (d.ad.V.d());
      for (String str = "1"; ; str = "0")
      {
        this.e.handleClientTrackingReport(4, str, null);
        return;
      }
    }
    this.k.onSharedPreferenceChanged(paramSharedPreferences, paramString);
  }

  private static class a
    implements Serializable
  {
    long a;

    public a(long paramLong)
    {
      this.a = paramLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.y
 * JD-Core Version:    0.6.2
 */