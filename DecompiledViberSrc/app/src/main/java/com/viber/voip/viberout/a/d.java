package com.viber.voip.viberout.a;

import com.viber.jni.controller.PhoneController;
import com.viber.voip.contacts.c.d.m;
import javax.inject.Provider;

public final class d
  implements dagger.a.d<a>
{
  private final Provider<com.viber.voip.calls.d> a;
  private final Provider<m> b;
  private final Provider<PhoneController> c;

  public d(Provider<com.viber.voip.calls.d> paramProvider, Provider<m> paramProvider1, Provider<PhoneController> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static d a(Provider<com.viber.voip.calls.d> paramProvider, Provider<m> paramProvider1, Provider<PhoneController> paramProvider2)
  {
    return new d(paramProvider, paramProvider1, paramProvider2);
  }

  public a a()
  {
    return new a((com.viber.voip.calls.d)this.a.get(), (m)this.b.get(), (PhoneController)this.c.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.d
 * JD-Core Version:    0.6.2
 */