package com.viber.voip.settings.c;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.registration.changephonenumber.CarrierChangedSplashActivity;
import com.viber.voip.settings.d.k;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.util.ViberActionRunner.j;
import com.viber.voip.util.ViberActionRunner.q;
import com.viber.voip.util.ViberActionRunner.z;
import com.viber.voip.util.dj;

public class l extends m
{
  private final Fragment b;
  private View c;

  public l(Context paramContext, PreferenceScreen paramPreferenceScreen, Fragment paramFragment)
  {
    super(paramContext, paramPreferenceScreen);
    this.b = paramFragment;
  }

  private void d()
  {
    if (this.b.getActivity() == null);
    final ViewGroup localViewGroup;
    do
    {
      do
      {
        return;
        localViewGroup = (ViewGroup)this.b.getView();
      }
      while (localViewGroup == null);
      if (this.c == null)
        this.c = this.b.getLayoutInflater().inflate(R.layout.notifications_off_baner_layout, localViewGroup, false);
    }
    while (dj.a(this.c, localViewGroup));
    localViewGroup.addView(this.c);
    this.c.findViewById(R.id.close_btn).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localViewGroup.removeView(l.a(l.this));
      }
    });
    this.c.findViewById(R.id.enable_btn).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = paramAnonymousView.getContext();
        localContext.startActivity(ViberActionRunner.q.a(localContext));
      }
    });
  }

  protected void a()
  {
    f(new x(this.a, x.a.c, d.k.e.c(), "Notifications off").a("1min banner and splash close delay").a(Boolean.valueOf(d.k.e.f())).a());
    f(new x(this.a, x.a.a, "pref_show_notifications_off_splash", "Initiate \"Notification are off\" splash").a(this).a());
    f(new x(this.a, x.a.a, "pref_show_notifications_off_banner", "Initiate \"Notification are off\" banner").a(this).a());
    f(new x(this.a, x.a.a, d.k.g.c(), "Reset \"Notifications off\" banner appears counter").a(this).a());
    f(new x(this.a, x.a.c, d.k.i.c(), "Show checkbox when splash appears").a(this).a());
    f(new x(this.a, x.a.a, "pref_carrier_changed_splash", "Initiate \"Carrier changed\" splash").a(this).a());
    f(new x(this.a, x.a.a, "pref_show_blocked_splash", "Show user blocked splash banner").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("banners_key");
    paramPreferenceGroup.c("Banners (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (d.k.e.c().equals(str))
    {
      boolean bool2 = ((CheckBoxPreference)paramPreference).b();
      d.k.e.a(bool2);
    }
    while (true)
    {
      return super.a(paramPreference);
      if ("pref_show_notifications_off_splash".equals(str))
      {
        ViberActionRunner.z.a(this.a, true);
      }
      else if ("pref_show_notifications_off_banner".equals(str))
      {
        d();
      }
      else if (d.k.i.c().equals(str))
      {
        boolean bool1 = ((CheckBoxPreference)paramPreference).b();
        d.k.i.a(bool1);
      }
      else if (d.k.g.c().equals(str))
      {
        d.k.g.e();
      }
      else if ("pref_carrier_changed_splash".equals(str))
      {
        Intent localIntent = new Intent(this.a, CarrierChangedSplashActivity.class);
        this.a.startActivity(localIntent);
      }
      else if ("pref_show_blocked_splash".equals(str))
      {
        ViberActionRunner.j.b(this.a, "google.com");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.l
 * JD-Core Version:    0.6.2
 */