package com.viber.voip.settings.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.h;
import com.viber.common.d.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.c;
import com.viber.voip.notif.g;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.d.p;
import com.viber.voip.ui.dialogs.o;
import com.viber.voip.util.ViberActionRunner.am;
import com.viber.voip.util.ViberActionRunner.q;
import com.viber.voip.util.da;
import com.viber.voip.widget.GlobalNotificationCheckBoxPreference;
import java.io.IOException;

public class v extends SettingsHeadersActivity.a
{
  private static final Logger b = ViberEnv.getLogger();
  private String c;
  private String d;
  private int e = 0;
  private MediaPlayer f;

  private void a(Intent paramIntent, int paramInt)
  {
    try
    {
      startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
    }
  }

  private void a(Preference paramPreference, String paramString)
  {
    if (paramString != null)
      try
      {
        Uri localUri = Uri.parse(paramString);
        a(getActivity(), localUri);
        Ringtone localRingtone = RingtoneManager.getRingtone(getActivity(), localUri);
        if ((localRingtone != null) && (!da.a(localUri.toString())))
          paramPreference.b(localRingtone.getTitle(getActivity()));
        while (d.m.c.c().equals(paramPreference.C()))
        {
          this.c = paramString;
          return;
          paramPreference.b(getString(R.string.pref_notification_silent));
        }
      }
      catch (Exception localException)
      {
        if (da.a(paramString))
        {
          paramPreference.b(getString(R.string.pref_notification_silent));
          return;
          this.d = paramString;
          return;
        }
        if (this.e == 0)
          o.c().c(this);
        this.e = (1 + this.e);
        c(paramPreference);
        return;
      }
    this.d = null;
    this.c = null;
    c(paramPreference);
  }

  private void c(Preference paramPreference)
  {
    if (this.e > 3)
    {
      d.m.a.e();
      this.e = 0;
      return;
    }
    paramPreference.b(null);
    if (d.m.c.c().equals(paramPreference.C()))
    {
      if (this.c != null);
      for (String str2 = this.c; ; str2 = d.m.c.f())
      {
        this.c = null;
        d.m.c.a(str2);
        this.e = 0;
        return;
      }
    }
    if (this.d != null);
    for (String str1 = this.d; ; str1 = d.ag.i.f())
    {
      this.d = null;
      d.ag.i.a(str1);
      break;
    }
  }

  public static void j()
  {
    d.ag.b.e();
    d.p.b.e();
    d.ag.d.e();
    d.ag.a.e();
    d.ag.c.e();
    d.m.a.e();
    d.ag.h.e();
    d.m.c.e();
    d.ag.i.e();
    d.m.b.e();
  }

  private void k()
  {
    if (this.f != null)
    {
      this.f.reset();
      this.f.release();
      this.f = null;
    }
  }

  private void l()
  {
    boolean bool = d.ag.d.d();
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.i.a(d.ag.c.c());
    if (localCheckBoxPreference != null)
      localCheckBoxPreference.a(bool);
  }

  private void m()
  {
    a(this.i.a(d.m.c.c()), d.m.c.d());
    if (!a.m())
    {
      String str = d.ag.i.c();
      a(this.i.a(str), d.ag.i.d());
    }
  }

  private void n()
  {
    boolean bool1 = g.a(requireActivity()).i();
    GlobalNotificationCheckBoxPreference localGlobalNotificationCheckBoxPreference = (GlobalNotificationCheckBoxPreference)a(d.ag.j.c());
    if (!bool1);
    for (boolean bool2 = true; ; bool2 = false)
    {
      localGlobalNotificationCheckBoxPreference.b(bool2);
      return;
    }
  }

  public void a(Context paramContext, Uri paramUri)
    throws IOException
  {
    if (paramUri.toString().startsWith("content://settings/system/"))
      return;
    if (((paramUri.getPath() != null) && (paramUri.getPath().endsWith(".mp4"))) || (paramUri.getPath().endsWith(".avi")) || (paramUri.getPath().endsWith(".mkv")) || (paramUri.getPath().endsWith(".flv")))
      throw new IllegalArgumentException("Illegal RingtoneUri:" + paramUri);
    k();
    this.f = new MediaPlayer();
    this.f.setDataSource(paramContext, paramUri);
    this.f.setAudioStreamType(-1);
    this.f.prepare();
    k();
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (d.m.c.c().equals(str))
    {
      a(((ViberRingtoneCompatPreference)paramPreference).e(), 100);
      return true;
    }
    if (d.ag.i.c().equals(str))
    {
      if (a.m())
      {
        ViberActionRunner.am.a(getActivity(), c.a.h.b());
        return true;
      }
      a(((ViberRingtoneCompatPreference)paramPreference).e(), 101);
      return true;
    }
    if (d.ag.j.c().equals(str))
    {
      startActivity(ViberActionRunner.q.a(getActivity()));
      return true;
    }
    return super.a(paramPreference);
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_notifications, paramString);
  }

  public void i()
  {
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default:
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    case 100:
    case 101:
    }
    do
    {
      return;
      ((ViberRingtoneCompatPreference)a(d.m.c.c())).a(paramInt2, paramIntent);
      return;
    }
    while (a.m());
    ((ViberRingtoneCompatPreference)a(d.ag.i.c())).a(paramInt2, paramIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!a.a())
      this.i.d(a(d.m.b.c()));
    if (a.o())
    {
      this.i.d(a(d.ag.c.c()));
      this.i.d(a(d.ag.a.c()));
    }
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
    if (paramString.equals(d.ag.b.c()))
      b(paramString, d.ag.b.d());
    do
    {
      return;
      if (paramString.equals(d.p.b.c()))
      {
        b(paramString, d.p.b.d());
        return;
      }
      if (paramString.equals(d.ag.a.c()))
      {
        b(paramString, d.ag.a.d());
        return;
      }
      if (paramString.equals(d.ag.d.c()))
      {
        b(paramString, d.ag.d.d());
        l();
        return;
      }
      if (paramString.equals(d.ag.c.c()))
      {
        b(paramString, d.ag.c.d());
        return;
      }
      if (paramString.equals(d.m.a.c()))
      {
        b(paramString, d.m.a.d());
        return;
      }
      if (paramString.equals(d.m.b.c()))
      {
        b(paramString, d.m.b.d());
        return;
      }
      if (paramString.equals(d.m.c.c()))
      {
        a(this.i.a(paramString), d.m.c.d());
        return;
      }
    }
    while ((!paramString.equals(d.ag.i.c())) || (a.m()));
    a(this.i.a(paramString), d.ag.i.d());
  }

  public void onStart()
  {
    super.onStart();
    l();
    m();
    n();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.v
 * JD-Core Version:    0.6.2
 */