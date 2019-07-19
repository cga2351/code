package com.viber.voip.settings.c;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.widget.Toast;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.c;
import com.viber.voip.apps.f.a;
import com.viber.voip.apps.model.AuthInfo;
import com.viber.voip.settings.d.w;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.ViberActionRunner.bg;

public class ah extends m
{
  private static final Logger c = ViberEnv.getLogger();
  f.a b = new f.a()
  {
    public void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
    {
      ah.a(ah.this).a(null);
      String str = Uri.parse(paramAnonymousString).getQueryParameter("token");
      ah.a(ah.this, str);
    }
  };
  private c d;
  private PreferenceScreen e;

  public ah(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
    this.e = paramPreferenceScreen;
    this.d = new c();
  }

  private void a(String paramString)
  {
    String str = Uri.parse(d.w.d.d()).buildUpon().appendQueryParameter("token", paramString).build().toString();
    GenericWebViewActivity.a(this.a, str, "token=" + paramString);
    Toast.makeText(this.a, str, 1).show();
  }

  private void d()
  {
    this.d.a(this.b);
    AuthInfo localAuthInfo = e();
    if (localAuthInfo == null)
      return;
    this.d.a(localAuthInfo);
    this.d.b(localAuthInfo);
  }

  private AuthInfo e()
  {
    AuthInfo localAuthInfo = new AuthInfo();
    try
    {
      localAuthInfo.setAppId(Integer.parseInt(d.w.a.d()));
      localAuthInfo.setScope(Integer.parseInt(d.w.c.d()));
      localAuthInfo.setIdentifier(d.w.b.d());
      return localAuthInfo;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      Toast.makeText(this.a, localNumberFormatException.getMessage(), 1).show();
    }
    return null;
  }

  private void f()
  {
    AuthInfo localAuthInfo = e();
    if (localAuthInfo == null)
      return;
    localAuthInfo.setAuthType(1);
    ViberActionRunner.bg.a(this.a, localAuthInfo);
  }

  protected void a()
  {
    f(new x(this.a, x.a.d, d.w.a.c(), "Game app Id").a(d.w.a.d()).a(d.w.a.f()).a(this).a());
    f(new x(this.a, x.a.d, d.w.b.c(), "Game identity").a(d.w.b.d()).a(d.w.b.f()).a(this).a());
    f(new x(this.a, x.a.d, d.w.c.c(), "Game permission").a(d.w.c.d()).a(d.w.c.f()).a(this).a());
    f(new x(this.a, x.a.d, d.w.d.c(), "Game URL (with http://)").a(d.w.d.d()).a(d.w.d.f()).a(this).a());
    f(new x(this.a, x.a.a, "open_game", "Open HTML5 game").a(this).a());
    f(new x(this.a, x.a.a, "webAuth", "Auth via ViberConnect").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("html5_key");
    paramPreferenceGroup.c("HTML5 POC (Debug options)");
  }

  public boolean a(Preference paramPreference)
  {
    String str = paramPreference.C();
    if (str.equals("open_game"))
    {
      d();
      return true;
    }
    if (str.equals("webAuth"))
      f();
    return false;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (str.equals(d.w.a.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    if (str.equals(d.w.b.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    if (str.equals(d.w.c.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    if (str.equals(d.w.d.c()))
    {
      paramPreference.b(paramObject.toString());
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.ah
 * JD-Core Version:    0.6.2
 */