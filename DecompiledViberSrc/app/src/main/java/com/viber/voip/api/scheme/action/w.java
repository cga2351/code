package com.viber.voip.api.scheme.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.i;
import com.viber.voip.apps.c;
import com.viber.voip.apps.model.AuthInfo;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.util.ViberActionRunner;

public class w extends f
{
  private static final Logger f = ViberEnv.getLogger();
  private final c g;
  private final AuthInfo h;

  public w(AuthInfo paramAuthInfo)
  {
    this.h = paramAuthInfo;
    this.g = new c();
  }

  private void a(String paramString, Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    Activity localActivity;
    if ((paramContext instanceof Activity))
    {
      localActivity = (Activity)paramContext;
      if ((localActivity != null) && (!localActivity.isFinishing()))
        break label74;
      localIntent.addFlags(268435456);
    }
    while (true)
    {
      localIntent.addCategory("android.intent.category.BROWSABLE");
      if (ViberActionRunner.a(localIntent, paramContext))
        paramContext.startActivity(localIntent);
      return;
      localActivity = null;
      break;
      label74: localActivity.overridePendingTransition(0, 0);
    }
  }

  public void a(Context paramContext, c.a parama)
  {
    if (!ViberApplication.isActivated())
    {
      if (4 == i.a().getStep())
        i.a().setStep(0, false);
      i.a().resumeActivation();
      parama.b();
      return;
    }
    parama.a();
    this.g.a(new x(this, paramContext, parama));
    this.g.a(this.h, paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.w
 * JD-Core Version:    0.6.2
 */