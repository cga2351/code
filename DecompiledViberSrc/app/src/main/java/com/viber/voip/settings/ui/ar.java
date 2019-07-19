package com.viber.voip.settings.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.b;
import com.viber.common.b.h;
import com.viber.voip.R.xml;
import com.viber.voip.ap;
import com.viber.voip.settings.d.bk;

public class ar extends SettingsHeadersActivity.a
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private CheckBoxPreference[] b;
  private String[] c;

  private void a(CheckBoxPreference paramCheckBoxPreference)
  {
    for (CheckBoxPreference localCheckBoxPreference : this.b)
      if (!localCheckBoxPreference.C().equals(paramCheckBoxPreference.C()))
        localCheckBoxPreference.f(false);
  }

  private void j()
  {
    String str = d.bk.a.d();
    CheckBoxPreference[] arrayOfCheckBoxPreference = this.b;
    int i = arrayOfCheckBoxPreference.length;
    for (int j = 0; ; j++)
      if (j < i)
      {
        CheckBoxPreference localCheckBoxPreference = arrayOfCheckBoxPreference[j];
        if (localCheckBoxPreference.y().equals(str))
        {
          a(localCheckBoxPreference);
          localCheckBoxPreference.f(true);
        }
      }
      else
      {
        return;
      }
  }

  private void k()
  {
    CheckBoxPreference[] arrayOfCheckBoxPreference = this.b;
    int i = arrayOfCheckBoxPreference.length;
    for (int j = 0; j < i; j++)
      arrayOfCheckBoxPreference[j].f(false);
  }

  protected void b(Bundle paramBundle, String paramString)
  {
    b(R.xml.viber_wallet_settings);
  }

  public void i()
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)a("dev_server");
    localCheckBoxPreference1.c(ap.c("FDD"));
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)a("int_server");
    localCheckBoxPreference2.c(ap.c("int"));
    CheckBoxPreference localCheckBoxPreference3 = (CheckBoxPreference)a("staging_server");
    localCheckBoxPreference3.c("https://wallet.staging.viber.com");
    CheckBoxPreference localCheckBoxPreference4 = (CheckBoxPreference)a("prod_server");
    localCheckBoxPreference4.c(ap.c("prod"));
    this.b = new CheckBoxPreference[] { localCheckBoxPreference1, localCheckBoxPreference2, localCheckBoxPreference3, localCheckBoxPreference4 };
    String[] arrayOfString = new String[4];
    arrayOfString[0] = ap.c("FDD");
    arrayOfString[1] = ap.c("int");
    arrayOfString[2] = "https://wallet.staging.viber.com";
    arrayOfString[3] = ap.c("prod");
    this.c = arrayOfString;
    EditTextPreference localEditTextPreference = (EditTextPreference)a("custom_server");
    localEditTextPreference.c(d.bk.a.d());
    localEditTextPreference.b(localEditTextPreference.b());
    localEditTextPreference.a(new Preference.b()
    {
      public boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        ar.a(ar.this);
        d.bk.a.a(String.valueOf(paramAnonymousObject));
        paramAnonymousPreference.b(String.valueOf(paramAnonymousObject));
        return true;
      }
    });
    j();
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
    for (int i = 0; ; i++)
      if (i < this.c.length)
      {
        CheckBoxPreference localCheckBoxPreference = this.b[i];
        if ((localCheckBoxPreference.C().equals(paramString)) && (localCheckBoxPreference.b()))
        {
          d.bk.a.a(this.c[i]);
          a(localCheckBoxPreference);
        }
      }
      else
      {
        return;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ar
 * JD-Core Version:    0.6.2
 */