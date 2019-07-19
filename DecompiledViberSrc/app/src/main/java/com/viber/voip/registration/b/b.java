package com.viber.voip.registration.b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.jni.secure.SecurePrimaryActivationDelegate;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.notif.e.m;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.c.aa.a;
import com.viber.voip.util.ViberActionRunner.aw;

public class b
  implements SecurePrimaryActivationDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final d c;
  private final m d;

  public b(Context paramContext, d paramd, m paramm)
  {
    this.b = paramContext;
    this.c = paramd;
    this.d = paramm;
  }

  public void onSecureSecondaryDeviceActivated(byte[] paramArrayOfByte, int paramInt)
  {
    if (a.o())
      this.d.e();
  }

  @SuppressLint({"MissingPermission"})
  public void onSecureSecondaryRequest(int paramInt)
  {
    ActivationController localActivationController = ViberApplication.getInstance().getActivationController();
    if (localActivationController.getStep() == 8)
    {
      if (aa.a.a(paramInt))
        this.c.d();
      if (a.o())
      {
        this.d.d();
        return;
      }
      ViberActionRunner.aw.a(this.b, null, "QR Code");
      return;
    }
    localActivationController.markSecondaryActivationRequested();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.b.b
 * JD-Core Version:    0.6.2
 */