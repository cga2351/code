package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberApplication;
import com.viber.voip.phone.call.DialerPendingController;

public abstract class ca
{
  static Engine a(ViberApplication paramViberApplication)
  {
    return paramViberApplication.getEngine(false);
  }

  static EngineDelegatesManager a(Engine paramEngine)
  {
    return paramEngine.getDelegatesManager();
  }

  static Engine b(ViberApplication paramViberApplication)
  {
    return paramViberApplication.getEngine(true);
  }

  static DialerPendingController b(Engine paramEngine)
  {
    return paramEngine.getDialerPendingController();
  }

  static Im2Exchanger c(Engine paramEngine)
  {
    return paramEngine.getExchanger();
  }

  static PhoneController d(Engine paramEngine)
  {
    return paramEngine.getPhoneController();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ca
 * JD-Core Version:    0.6.2
 */