package com.viber.voip.settings.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.a;
import com.viber.common.b.b;
import com.viber.voip.R.xml;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.af;
import com.viber.voip.util.ViberActionRunner.ay;
import com.viber.voip.util.at;
import com.viber.voip.util.dv;
import com.viber.voip.util.upload.o;
import java.io.File;

public class u extends SettingsHeadersActivity.a
{
  public static void j()
  {
    d.af.a.e();
    d.af.b.e();
    d.ad.z.e();
  }

  public boolean a(Preference paramPreference)
  {
    if (d.ad.x.c().equals(paramPreference.C()))
    {
      ViberActionRunner.ay.a(getContext(), 1);
      return true;
    }
    return super.a(paramPreference);
  }

  public void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.settings_media, paramString);
  }

  public void i()
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b().d(a(d.ad.z.c()));
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("inner_screen")))
      switch (getArguments().getByte("inner_screen"))
      {
      default:
      case 3:
      }
    while (true)
    {
      localBundle.remove("inner_screen");
      return;
      ViberActionRunner.ay.a(getContext(), 6);
    }
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
    if (paramString.equals(d.af.b.c()))
      b(paramString, d.af.b.d());
    do
    {
      return;
      if (paramString.equals(d.af.a.c()))
      {
        b(paramString, d.af.a.d());
        return;
      }
    }
    while (!paramString.equals(d.ad.z.c()));
    File localFile = dv.a.a(getActivity());
    if (d.ad.z.d())
      at.e(localFile);
    while (true)
    {
      o.a(new File(localFile, ".nomedia").getPath());
      return;
      new File(localFile, ".nomedia").delete();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.u
 * JD-Core Version:    0.6.2
 */