package com.viber.voip.api.scheme.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.i;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.pixie.PixieController.PixieReadyListener;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.dz;

public class y extends aa
{
  private static final Logger f = ViberEnv.getLogger();
  private final Intent g;
  private final boolean h;

  public y(Intent paramIntent)
  {
    this(paramIntent, false);
  }

  public y(Intent paramIntent, boolean paramBoolean)
  {
    this.g = paramIntent;
    this.h = paramBoolean;
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    if (ViberApplication.isActivated())
    {
      Activity localActivity;
      if ((paramContext instanceof Activity))
      {
        localActivity = (Activity)paramContext;
        if ((localActivity != null) && (!localActivity.isFinishing()))
          break label55;
        paramIntent.addFlags(268435456);
      }
      while (true)
      {
        if (ViberActionRunner.a(paramIntent, paramContext))
          paramContext.startActivity(paramIntent);
        return;
        localActivity = null;
        break;
        label55: localActivity.overridePendingTransition(0, 0);
      }
    }
    if (4 == i.a().getStep())
      i.a().setStep(0, false);
    i.a().resumeActivation();
  }

  public static void b(Context paramContext, final Intent paramIntent)
  {
    ViberEnv.getPixieController().addReadyListener(new PixieController.PixieReadyListener()
    {
      public void onReady()
      {
        dz.a(this.a, paramIntent);
      }
    });
  }

  void a(Context paramContext)
  {
    if (this.g == null)
      return;
    if (this.h)
    {
      b(paramContext, this.g);
      return;
    }
    a(paramContext, this.g);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.y
 * JD-Core Version:    0.6.2
 */