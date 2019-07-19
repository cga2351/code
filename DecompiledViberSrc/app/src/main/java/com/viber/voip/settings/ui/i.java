package com.viber.voip.settings.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.xml;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backgrounds.m;
import com.viber.voip.backgrounds.o;
import com.viber.voip.settings.d.bc;
import com.viber.voip.settings.d.i;
import com.viber.voip.ui.j.av;
import com.viber.voip.ui.j.ax;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.PreferenceWithImage;
import javax.inject.Inject;

public class i extends SettingsHeadersActivity.a
{
  private static final Logger f = ViberEnv.getLogger();

  @Inject
  com.viber.voip.app.b b;

  @Inject
  dagger.a<av> c;

  @Inject
  dagger.a<com.viber.voip.analytics.story.g.a> d;

  @Inject
  ICdrController e;
  private w g;

  private void a(Activity paramActivity, ax paramax)
  {
    if (d.bc.a.d().equals(paramax.a()))
      return;
    com.viber.voip.backgrounds.b.a().c();
    d.bc.a.a(paramax.a());
    ((av)this.c.get()).a(paramax);
    ((com.viber.voip.analytics.story.g.a)this.d.get()).a(paramax);
    if (dc.a());
    for (String str = "1"; ; str = "0")
    {
      this.e.handleClientTrackingReport(8, str, null);
      if (paramActivity == null)
        break;
      paramActivity.recreate();
      return;
    }
  }

  private void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null);
    do
    {
      return;
      paramActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          String str1 = d.i.d.d();
          if (m.d(str1));
          for (String str2 = new o().a(false).toString(); ; str2 = str1)
          {
            PreferenceWithImage localPreferenceWithImage = (PreferenceWithImage)i.this.a(d.i.f.c());
            if (localPreferenceWithImage != null)
            {
              localPreferenceWithImage.a(str2);
              localPreferenceWithImage.b(str2);
            }
            return;
          }
        }
      });
    }
    while ((!ViberApplication.isTablet(paramActivity)) || (!paramBoolean));
    com.viber.voip.backgrounds.b.a().d();
  }

  public static void j()
  {
    d.bc.a.e();
    ((av)ViberApplication.getInstance().getThemeController().get()).a(ax.a(d.bc.a.d()));
    l();
  }

  private void k()
  {
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)a(d.bc.b.c());
    if (localCheckBoxPreference != null)
      localCheckBoxPreference.f(d.bc.a.d().equals(ax.b.a()));
  }

  private static void l()
  {
    d.i.f.e();
    com.viber.voip.backgrounds.b.a().c();
  }

  public boolean a(Preference paramPreference)
  {
    if (d.i.f.c().equals(paramPreference.C()))
    {
      Intent localIntent = new Intent("com.viber.voip.action.BACKGROUND_GALLERY");
      localIntent.putExtra("has_background", false);
      localIntent.putExtra("opened_from_settings", true);
      getActivity().startActivityForResult(localIntent, 2004);
      return true;
    }
    return super.a(paramPreference);
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_display, paramString);
  }

  public void i()
  {
    a(getActivity(), true);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 2004))
    {
      if (paramIntent.getExtras() == null)
        break label75;
      Uri localUri1 = Uri.parse(paramIntent.getStringExtra("portraitUri"));
      Uri localUri2 = Uri.parse(paramIntent.getStringExtra("landscapeUri"));
      com.viber.voip.backgrounds.b.a().a(-1, localUri1.toString(), localUri2.toString());
      a(getActivity(), true);
    }
    while (true)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label75: if ("remove_conversation_background".equals(paramIntent.getAction()))
        l();
    }
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.b.a(getActivity()))
      b().d(a(d.bc.b.c()));
  }

  public void onResume()
  {
    super.onResume();
    k();
    a(getActivity(), false);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
    if (paramString.equals(d.i.d.c()))
      a(getActivity(), true);
    while (!paramString.equals(d.bc.b.c()))
      return;
    if (d.bc.b.d());
    for (ax localax = ax.b; ; localax = ax.a)
    {
      a(getActivity(), localax);
      if (!com.viber.common.d.a.j())
        break;
      dj.b(getActivity(), dc.b());
      return;
    }
  }

  public void onStop()
  {
    super.onStop();
    if (this.g != null)
      this.g.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.i
 * JD-Core Version:    0.6.2
 */