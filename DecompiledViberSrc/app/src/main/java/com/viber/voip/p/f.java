package com.viber.voip.p;

import android.content.Context;
import com.viber.jni.Engine;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.ViberApplication;

class f extends a
{
  f(Context paramContext)
  {
    a(new g(paramContext));
  }

  public void a(boolean paramBoolean)
  {
    int i = b().getEngine(true).getDialerController().getPhoneState();
    if ((4 != i) && (3 != i))
      return;
    super.a(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.p.f
 * JD-Core Version:    0.6.2
 */