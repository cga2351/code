package com.viber.voip.registration;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.registration.c.l;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.t;

public class DeactivateSecondaryActivity extends ViberFragmentActivity
  implements m.c, n.a
{
  private static final Logger a = ViberEnv.getLogger();
  private n b;
  private ActivationController c;

  private void a()
  {
    t.c().a(this).a(this);
  }

  private void b(String paramString)
  {
    ad.h().a(this).a(paramString).a(this);
  }

  private void c()
  {
    z.a(getSupportFragmentManager(), DialogCode.D_PROGRESS);
  }

  private void d()
  {
    this.c.deActivateAndExit(this, false);
  }

  public void a(l paraml)
  {
    if (paraml == null)
    {
      c();
      ad.h().a(this).a(this);
      return;
    }
    if ((paraml.f()) || ("107".equals(paraml.g())))
    {
      d();
      return;
    }
    c();
    b(paraml.h());
  }

  public void a(String paramString)
  {
    c();
    if (paramString.equals("CONNECTION_PROBLEM"))
      ad.a().d();
    finish();
  }

  public void b()
  {
    ad.a(R.string.dialog_deactivation_progress).b(false).a(this);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ViberApplication localViberApplication = ViberApplication.getInstance();
    Engine localEngine = localViberApplication.getEngine(false);
    this.b = new n(localEngine.getDelegatesManager().getSecureTokenListener(), localEngine.getPhoneController(), getApplicationContext(), this);
    this.c = localViberApplication.getActivationController();
    setContentView(R.layout.transparent_ac);
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.b.b();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    DialogCode localDialogCode = (DialogCode)paramm.c();
    switch (1.a[localDialogCode.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
      do
      {
        do
        {
          return;
          if (paramInt != -1)
            break;
          this.b.a();
        }
        while (isFinishing());
        paramm.dismiss();
        return;
        if (paramInt == -2)
        {
          if (!isFinishing())
            paramm.dismiss();
          finish();
          return;
        }
      }
      while (paramInt != -3);
      if (!isFinishing())
        paramm.dismiss();
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.contact_support_link))));
      finish();
      return;
    case 4:
    }
    finish();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a();
  }

  public void onPause()
  {
    super.onPause();
    this.b.b();
    finish();
  }

  protected void onStart()
  {
    super.onStart();
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.DeactivateSecondaryActivity
 * JD-Core Version:    0.6.2
 */