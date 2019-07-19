package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.text.Html;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.common.b.h;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.provider.messages.b.c.e;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.h;
import com.viber.voip.i.f;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.a;
import com.viber.voip.messages.k;
import com.viber.voip.notif.g;
import com.viber.voip.permissions.e;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.PhoneApp;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.bd;
import com.viber.voip.settings.d.j;
import com.viber.voip.settings.d.l;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.at;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.ViberActionRunner.ax;
import com.viber.voip.util.af;
import com.viber.voip.util.bq;
import com.viber.voip.util.bq.g;
import com.viber.voip.util.cj;
import com.viber.voip.util.cv;
import com.viber.voip.widget.LongSummaryCheckbBoxPreference;
import org.webrtc.videoengine.EngineDelegate;
import org.webrtc.videoengine.EngineDelegate.VideoEngineEventSubscriber;

public class c extends SettingsHeadersActivity.a
  implements m.c
{
  private static final Logger b = ViberEnv.getLogger();
  private com.viber.common.permission.c c;
  private com.viber.common.permission.b d;
  private k e;
  private EngineDelegate.VideoEngineEventSubscriber f;

  public c()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(115);
    this.d = new e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        new com.viber.voip.util.o(c.this.getActivity()).execute(new Void[0]);
      }
    };
    this.f = new EngineDelegate.VideoEngineEventSubscriber()
    {
      public void onAvailableFeatures(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3, boolean paramAnonymousBoolean4)
      {
      }

      public void onFailure(int paramAnonymousInt)
      {
      }

      public void onStartRecvVideo(int paramAnonymousInt)
      {
      }

      public void onStartSendVideo()
      {
      }

      public void onStopRecvVideo(int paramAnonymousInt)
      {
      }

      public void onStopSendVideo()
      {
      }
    };
  }

  private void a(LongSummaryCheckbBoxPreference paramLongSummaryCheckbBoxPreference)
  {
    if (paramLongSummaryCheckbBoxPreference.b());
    for (int i = R.string.pref_proximity_turn_off_summary_on; ; i = R.string.pref_proximity_turn_off_summary_off)
    {
      paramLongSummaryCheckbBoxPreference.b(Html.fromHtml(getString(i)));
      return;
    }
  }

  public static void j()
  {
    d.r.B.e();
    d.m.f.e();
    d.m.k.e();
    d.r.a.e();
  }

  private void k()
  {
    if (d.r.B.d())
    {
      d.l.e.a(false);
      return;
    }
    p.e().a(new ViberDialogHandlers.at()).a(getActivity());
  }

  private void l()
  {
    if (getActivity() != null)
      g.a(getActivity()).h();
  }

  private void m()
  {
    if (!o())
      return;
    bq.b(getActivity()).a(780, null, c.e.a, null, null, null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        boolean bool1 = true;
        try
        {
          Preference localPreference1 = c.this.i.a(d.r.c.c());
          boolean bool2;
          Preference localPreference2;
          if ((!af.b(paramAnonymousCursor)) && (paramAnonymousCursor.getCount() > 0))
          {
            bool2 = bool1;
            localPreference1.a(bool2);
            localPreference2 = c.this.i.a(d.r.d.c());
            if ((af.b(paramAnonymousCursor)) || (paramAnonymousCursor.getCount() <= 0))
              break label100;
          }
          while (true)
          {
            localPreference2.a(bool1);
            return;
            bool2 = false;
            break;
            label100: bool1 = false;
          }
        }
        finally
        {
          af.a(paramAnonymousCursor);
        }
      }
    }
    , true);
  }

  private void n()
  {
    LongSummaryCheckbBoxPreference localLongSummaryCheckbBoxPreference = (LongSummaryCheckbBoxPreference)this.i.a(d.m.f.c());
    if (localLongSummaryCheckbBoxPreference != null)
      localLongSummaryCheckbBoxPreference.b(Html.fromHtml(getString(R.string.pref_viber_in_calls_description)));
  }

  private boolean o()
  {
    return (d.j.m.d()) && (b().a(d.r.c.c()) != null);
  }

  public boolean a(Preference paramPreference)
  {
    boolean bool1 = true;
    boolean bool3;
    if (d.m.f.c().equals(paramPreference.C()))
    {
      boolean bool2 = ((CheckBoxPreference)paramPreference).b();
      if (!cj.a(bool1))
      {
        CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)paramPreference;
        if (bool2)
          break label59;
        bool3 = bool1;
        localCheckBoxPreference.f(bool3);
        bool1 = false;
      }
    }
    label59: 
    do
    {
      do
      {
        return bool1;
        bool3 = false;
        break;
        if (!d.r.c.c().equals(paramPreference.C()))
          break label144;
      }
      while ((!com.viber.voip.util.upload.o.b(bool1)) || (!com.viber.voip.util.upload.o.a(bool1)));
      if (this.c.a(n.n))
      {
        new com.viber.voip.util.o(getActivity()).execute(new Void[0]);
        return bool1;
      }
      this.c.a(this, 115, n.n);
      return bool1;
      if (d.r.d.c().equals(paramPreference.C()))
      {
        t.b().a(this).b(this);
        return bool1;
      }
      if (d.m.k.c().equals(paramPreference.C()))
      {
        ViberApplication.getInstance().getPhoneApp().initProximityHelper();
        a((LongSummaryCheckbBoxPreference)paramPreference);
        return bool1;
      }
      if (!d.r.B.c().equals(paramPreference.C()))
        break label248;
    }
    while (!ViberApplication.getInstance().getMessagesManager().w().b());
    label144: k();
    return bool1;
    label248: if (getString(R.string.pref_translate_lang_key).equals(paramPreference.C()))
    {
      ViberActionRunner.ax.a(this, 107, d.bd.d.d(), -1L);
      return bool1;
    }
    return super.a(paramPreference);
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_call_messages, paramString);
  }

  public void i()
  {
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)a(d.m.f.c());
    if ((localCheckBoxPreference != null) && (localCheckBoxPreference.b() != d.m.f.f()))
    {
      localCheckBoxPreference.f(d.m.f.f());
      localCheckBoxPreference.a(false);
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 107) && (paramInt2 == -1))
      d.bd.d.a(paramIntent.getStringExtra("selected_lang"));
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!o())
      b().d(a(d.r.c.c()));
    this.c = com.viber.common.permission.c.a(getActivity());
    if (ao.f())
    {
      b().d(a(d.m.f.c()));
      b().d(a(d.r.B.c()));
    }
    if (!c.h.e.e())
      b().d(a(getString(R.string.pref_translate_lang_key)));
    LongSummaryCheckbBoxPreference localLongSummaryCheckbBoxPreference = (LongSummaryCheckbBoxPreference)a(d.m.k.c());
    if (!d.m.k.a())
    {
      d.m.k.e();
      localLongSummaryCheckbBoxPreference.f(d.m.k.d());
    }
    localLongSummaryCheckbBoxPreference.a(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ad.e().a(c.this.getActivity());
      }
    });
    ((CheckBoxPreference)a(d.r.a.c())).f(d.r.a.d());
    this.e = ViberApplication.getInstance().getMessagesManager();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    DialogCode localDialogCode = (DialogCode)paramm.c();
    switch (6.a[localDialogCode.ordinal()])
    {
    default:
    case 1:
    }
    do
      return;
    while (paramInt != -1);
    this.e.c().a(new ai.a()
    {
      public void a()
      {
        c.a(c.this);
        c.b(c.this);
        cv.a().f();
        com.viber.voip.messages.controller.manager.o.a().a(null, 0, false, true);
      }
    });
  }

  public void onPause()
  {
    super.onPause();
    EngineDelegate.removeEventSubscriber(this.f);
  }

  public void onResume()
  {
    super.onResume();
    m();
    n();
    a((LongSummaryCheckbBoxPreference)this.i.a(d.m.k.c()));
    EngineDelegate.addEventSubscriber(this.f);
  }

  public void onStart()
  {
    super.onStart();
    this.c.a(this.d);
  }

  public void onStop()
  {
    super.onStop();
    this.c.b(this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.c
 * JD-Core Version:    0.6.2
 */