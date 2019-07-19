package com.viber.voip.registration.b;

import com.viber.dexshared.Logger;
import com.viber.jni.secure.MustSecureDelegate;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.ActivationController;

public class a
  implements MustSecureDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final ActivationController b = ViberApplication.getInstance().getActivationController();

  public void onMustSecure()
  {
    if (this.b.isActivationCompleted())
      this.b.setStep(16, ViberApplication.getInstance().isOnForeground());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.b.a
 * JD-Core Version:    0.6.2
 */