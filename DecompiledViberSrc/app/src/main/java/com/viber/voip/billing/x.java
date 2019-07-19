package com.viber.voip.billing;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;

public class x
{
  private static final Logger a = b.a(x.class);

  public static String a(String paramString1, String paramString2)
  {
    return ViberApplication.getInstance().getEngine(true).getPhoneController().encodeCurrency(paramString2, paramString1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.x
 * JD-Core Version:    0.6.2
 */