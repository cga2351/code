package com.viber.service;

import com.viber.jni.dialer.DialerController;
import com.viber.voip.phone.call.CallHandler;
import dagger.a;
import dagger.b;

public final class f
  implements b<ViberPhoneService>
{
  public static void a(ViberPhoneService paramViberPhoneService, a<CallHandler> parama)
  {
    paramViberPhoneService.a = parama;
  }

  public static void b(ViberPhoneService paramViberPhoneService, a<DialerController> parama)
  {
    paramViberPhoneService.b = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.f
 * JD-Core Version:    0.6.2
 */