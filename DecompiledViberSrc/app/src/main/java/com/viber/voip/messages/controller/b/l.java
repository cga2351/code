package com.viber.voip.messages.controller.b;

import android.content.Context;
import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.voip.registration.af;

public abstract class l extends PhoneControllerDelegateAdapter
  implements ServiceStateDelegate
{
  protected Context a;
  protected Engine b;
  protected af c;

  protected l(Context paramContext, af paramaf)
  {
    this.a = paramContext;
    this.c = paramaf;
  }

  public void a(Engine paramEngine)
  {
    this.b = paramEngine;
  }

  public void onServiceStateChanged(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.l
 * JD-Core Version:    0.6.2
 */