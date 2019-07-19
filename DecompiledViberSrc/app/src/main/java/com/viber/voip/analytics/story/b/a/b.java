package com.viber.voip.analytics.story.b.a;

import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.story.b.c;
import com.viber.voip.registration.af;
import dagger.a.d;
import javax.inject.Provider;

public final class b
  implements d<a>
{
  private final Provider<c> a;
  private final Provider<PhoneController> b;
  private final Provider<af> c;

  public b(Provider<c> paramProvider, Provider<PhoneController> paramProvider1, Provider<af> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static b a(Provider<c> paramProvider, Provider<PhoneController> paramProvider1, Provider<af> paramProvider2)
  {
    return new b(paramProvider, paramProvider1, paramProvider2);
  }

  public a a()
  {
    return new a((c)this.a.get(), (PhoneController)this.b.get(), (af)this.c.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.a.b
 * JD-Core Version:    0.6.2
 */