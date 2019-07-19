package com.viber.voip.settings.ui;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.l;
import android.util.AttributeSet;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.pixie.PixieControllerNativeImpl;
import com.viber.voip.pixie.ProxySettings;
import com.viber.voip.pixie.ProxySettingsHolder;
import com.viber.voip.ui.ViberEditText;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class ProxySettingsPreference extends Preference
{
  private static final Logger g = ViberEnv.getLogger();
  ViberEditText a;
  ViberEditText b;
  ViberEditText c;
  ViberEditText d;
  ViberEditText e;
  ViberEditText f;

  public ProxySettingsPreference(Context paramContext)
  {
    super(paramContext);
    b();
  }

  public ProxySettingsPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  public ProxySettingsPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }

  private void b()
  {
    c(R.layout.proxy_settings_layout);
  }

  private void e()
  {
    ProxySettings localProxySettings = ProxySettingsHolder.obtain();
    if (!da.a(localProxySettings.url))
      this.a.setText(localProxySettings.url);
    if (localProxySettings.port != 0)
      this.d.setText(String.valueOf(localProxySettings.port));
    if (!da.a(localProxySettings.username))
      this.b.setText(localProxySettings.username);
    if (!da.a(localProxySettings.password))
      this.c.setText(localProxySettings.password);
    if (!da.a(localProxySettings.serverName))
      this.e.setText(localProxySettings.serverName);
    if (!da.a(localProxySettings.key))
      this.f.setText(localProxySettings.key);
    a(localProxySettings.type);
  }

  public void a(l paraml)
  {
    this.a = ((ViberEditText)paraml.a(R.id.socks5_url));
    this.b = ((ViberEditText)paraml.a(R.id.socks5_username));
    this.c = ((ViberEditText)paraml.a(R.id.socks5_password));
    this.d = ((ViberEditText)paraml.a(R.id.socks5_port));
    this.e = ((ViberEditText)paraml.a(R.id.gq_server_name));
    this.f = ((ViberEditText)paraml.a(R.id.gq_key));
    e();
  }

  public void a(String paramString)
  {
    boolean bool1 = "gq".equals(paramString);
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    dj.b(this.e, bool2);
    dj.b(this.f, bool2);
  }

  public boolean a(ProxySettings paramProxySettings)
  {
    if (!paramProxySettings.enabled);
    String str;
    do
    {
      return true;
      str = this.a.getText().toString();
    }
    while ((!da.a(str)) && (str.length() < 256));
    return false;
  }

  public void b(ProxySettings paramProxySettings)
  {
    try
    {
      int j = Integer.parseInt(this.d.getText().toString());
      i = j;
      ProxySettingsHolder.update(new ProxySettings(paramProxySettings.type, this.a.getText().toString(), this.b.getText().toString(), this.c.getText().toString(), i, false, paramProxySettings.encryptionMethod, this.e.getText().toString(), this.f.getText().toString(), paramProxySettings.enabled));
      PixieControllerNativeImpl.getInstance().startProxy();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        int i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ProxySettingsPreference
 * JD-Core Version:    0.6.2
 */