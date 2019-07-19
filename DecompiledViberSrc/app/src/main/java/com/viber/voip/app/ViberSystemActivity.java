package com.viber.voip.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.viber.common.b.h;
import com.viber.common.dialogs.BaseRemoteViberDialogsActivity;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.o;
import com.viber.voip.banner.e;
import com.viber.voip.banner.f;
import com.viber.voip.g.b.b;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.bp;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class ViberSystemActivity extends BaseRemoteViberDialogsActivity
  implements com.viber.voip.ui.c.a
{
  private String a;
  private e b;
  private c c;

  protected c a()
  {
    return new com.viber.voip.ui.c.g(this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(bp.c(paramContext));
  }

  public AppCompatActivity getActivity()
  {
    return this;
  }

  public int getDefaultTheme()
  {
    return dj.c(this);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.c = a();
    this.c.b(getIntent());
    super.onCreate(paramBundle);
    dc.a(this);
    this.b = f.a(this, new b()
    {
      protected com.viber.voip.analytics.story.g.a a()
      {
        return com.viber.voip.analytics.g.a().c().c();
      }
    });
    this.b.m();
    this.a = d.ad.a.c.d();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.b.n();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.c.a(paramIntent, null);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.c.a(getIntent(), paramBundle);
  }

  protected void onResume()
  {
    this.c.a();
    super.onResume();
    bp.a(this, this.a);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.c.a(paramBundle);
  }

  protected void onStart()
  {
    super.onStart();
    this.b.c();
  }

  protected void onStop()
  {
    super.onStop();
    this.b.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.app.ViberSystemActivity
 * JD-Core Version:    0.6.2
 */