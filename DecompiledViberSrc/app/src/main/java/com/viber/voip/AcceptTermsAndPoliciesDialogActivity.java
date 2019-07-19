package com.viber.voip;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.viber.common.b.h;
import com.viber.common.dialogs.BaseRemoteViberDialogsActivity;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.g;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.bp;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class AcceptTermsAndPoliciesDialogActivity extends BaseRemoteViberDialogsActivity
  implements com.viber.voip.ui.c.a
{
  private String a;
  private c b;

  protected c a()
  {
    return new g(this, (av)ViberApplication.getInstance().getThemeController().get());
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
    this.b = a();
    this.b.b(getIntent());
    super.onCreate(paramBundle);
    dc.a(this);
    this.a = d.ad.a.c.d();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.b.a(paramIntent, null);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.b.a(getIntent(), paramBundle);
  }

  protected void onResume()
  {
    this.b.a();
    super.onResume();
    bp.a(this, this.a);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.b.a(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.AcceptTermsAndPoliciesDialogActivity
 * JD-Core Version:    0.6.2
 */