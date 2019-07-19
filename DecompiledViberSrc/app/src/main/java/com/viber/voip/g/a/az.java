package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.dialer.DialerCallInterruptionListener;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.calls.d;
import com.viber.voip.calls.e;
import com.viber.voip.phone.call.CallHandler;

public abstract class az
{
  static DialerPhoneStateListener a(EngineDelegatesManager paramEngineDelegatesManager)
  {
    return paramEngineDelegatesManager.getDialerPhoneStateListener();
  }

  static d a(ViberApplication paramViberApplication)
  {
    return e.a(paramViberApplication);
  }

  static CallHandler a(Engine paramEngine)
  {
    return paramEngine.getCallHandler();
  }

  static DialerController b(Engine paramEngine)
  {
    return paramEngine.getDialerController();
  }

  static DialerLocalCallStateListener b(EngineDelegatesManager paramEngineDelegatesManager)
  {
    return paramEngineDelegatesManager.getDialerLocalCallStateListener();
  }

  static DialerCallInterruptionListener c(EngineDelegatesManager paramEngineDelegatesManager)
  {
    return paramEngineDelegatesManager.getDialerCallInterruptionListener();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.az
 * JD-Core Version:    0.6.2
 */