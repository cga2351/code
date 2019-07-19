package com.viber.voip.settings.ui;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.dialogs.h.a;
import com.viber.voip.R.array;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.R.xml;
import com.viber.voip.pixie.ProxySettings;
import com.viber.voip.pixie.ProxySettingsHolder;
import com.viber.voip.ui.dialogs.f;

public class ac extends SettingsHeadersActivity.a
{
  private ListPreference b;
  private ListPreference c;
  private ProxySettings d;
  private String[] e;
  private String[] f;
  private CheckBoxPreference g;
  private ProxySettingsPreference h;

  private void a(String paramString)
  {
    this.d = new ProxySettings(paramString, this.d.url, this.d.username, this.d.password, this.d.port, this.d.udp, this.d.encryptionMethod, this.d.serverName, this.d.key, this.d.enabled);
    k();
    m();
    j();
  }

  private void a(boolean paramBoolean)
  {
    this.d = new ProxySettings(this.d.type, this.d.url, this.d.username, this.d.password, this.d.port, this.d.udp, this.d.encryptionMethod, this.d.serverName, this.d.key, paramBoolean);
  }

  private void b(String paramString)
  {
    this.d = new ProxySettings(this.d.type, this.d.url, this.d.username, this.d.password, this.d.port, this.d.udp, paramString, this.d.serverName, this.d.key, this.d.enabled);
    l();
  }

  private void j()
  {
    this.h.a(this.d.type);
  }

  private void k()
  {
    String str = this.e[java.util.Arrays.asList(ProxySettings.TYPES).indexOf(this.d.type)];
    this.c.b(str);
  }

  private void l()
  {
    String str = this.f[java.util.Arrays.asList(ProxySettings.ENCRYPTION_METHODS).indexOf(this.d.encryptionMethod)];
    this.b.b(str);
  }

  private void m()
  {
    if (("ss".equals(this.d.type)) || ("gq".equals(this.d.type)));
    for (boolean bool = true; ; bool = false)
    {
      this.b.b(bool);
      return;
    }
  }

  protected void b(Bundle paramBundle, String paramString)
  {
    a(R.xml.proxy_settings, paramString);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    if ((paramBundle != null) && (paramBundle.containsKey("proxy_settings")));
    for (this.d = ((ProxySettings)paramBundle.getSerializable("proxy_settings")); ; this.d = ProxySettingsHolder.obtain())
    {
      this.g = ((CheckBoxPreference)a(getString(R.string.proxy_enabled_key)));
      this.g.f(this.d.enabled);
      this.e = getResources().getStringArray(R.array.proxy_type_entries);
      this.c = ((ListPreference)a(getString(R.string.proxy_type_key)));
      this.c.b(this.d.type);
      this.c.a(this.e);
      this.c.b(ProxySettings.TYPES);
      k();
      this.f = getResources().getStringArray(R.array.proxy_encryption_method_entries);
      this.b = ((ListPreference)a(getString(R.string.proxy_encryption_method_key)));
      this.b.b(this.d.encryptionMethod);
      this.b.a(this.f);
      this.b.b(ProxySettings.ENCRYPTION_METHODS);
      this.h = ((ProxySettingsPreference)a("proxy_settings"));
      l();
      m();
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    return localView;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    ProxySettingsPreference localProxySettingsPreference;
    if (paramMenuItem.getItemId() == R.id.menu_done)
    {
      localProxySettingsPreference = (ProxySettingsPreference)a("proxy_settings");
      if (!localProxySettingsPreference.a(this.d))
        f.f().b(this);
    }
    else
    {
      return super.onOptionsItemSelected(paramMenuItem);
    }
    localProxySettingsPreference.b(this.d);
    getActivity().finish();
    return true;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("proxy_settings", this.d);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (this.g.C().equals(paramString))
      a(this.g.b());
    while (true)
    {
      super.onSharedPreferenceChanged(paramSharedPreferences, paramString);
      return;
      if (this.c.C().equals(paramString))
        a(this.c.p());
      else if (this.b.C().equals(paramString))
        b(this.b.p());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ac
 * JD-Core Version:    0.6.2
 */