package com.viber.voip.contacts.c.d;

import android.os.Handler;
import com.viber.common.b.d;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.model.entity.x;
import java.util.Collection;
import java.util.Set;

public class l extends a<x>
{
  private final g h;

  public l(Im2Exchanger paramIm2Exchanger, d paramd, g paramg, PhoneController paramPhoneController, Handler paramHandler)
  {
    super(paramIm2Exchanger, paramd, paramPhoneController, paramHandler);
    this.h = paramg;
  }

  protected void a(Set<x> paramSet)
  {
    this.h.a(paramSet);
  }

  protected Collection<x> d()
  {
    return this.h.c().b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.l
 * JD-Core Version:    0.6.2
 */