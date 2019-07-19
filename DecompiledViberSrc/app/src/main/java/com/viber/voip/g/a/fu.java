package com.viber.voip.g.a;

import android.content.Context;
import androidx.work.p;
import com.google.d.f;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.contacts.c.d.n;
import com.viber.voip.registration.ActivationController;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fu
  implements d<com.viber.voip.j.a.a.c>
{
  private final ft a;
  private final Provider<Context> b;
  private final Provider<p> c;
  private final Provider<ActivationController> d;
  private final Provider<com.viber.common.permission.c> e;
  private final Provider<ICdrController> f;
  private final Provider<f> g;
  private final Provider<n> h;

  public fu(ft paramft, Provider<Context> paramProvider, Provider<p> paramProvider1, Provider<ActivationController> paramProvider2, Provider<com.viber.common.permission.c> paramProvider3, Provider<ICdrController> paramProvider4, Provider<f> paramProvider5, Provider<n> paramProvider6)
  {
    this.a = paramft;
    this.b = paramProvider;
    this.c = paramProvider1;
    this.d = paramProvider2;
    this.e = paramProvider3;
    this.f = paramProvider4;
    this.g = paramProvider5;
    this.h = paramProvider6;
  }

  public static fu a(ft paramft, Provider<Context> paramProvider, Provider<p> paramProvider1, Provider<ActivationController> paramProvider2, Provider<com.viber.common.permission.c> paramProvider3, Provider<ICdrController> paramProvider4, Provider<f> paramProvider5, Provider<n> paramProvider6)
  {
    return new fu(paramft, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }

  public com.viber.voip.j.a.a.c a()
  {
    return (com.viber.voip.j.a.a.c)h.a(this.a.a((Context)this.b.get(), dagger.a.c.b(this.c), dagger.a.c.b(this.d), dagger.a.c.b(this.e), dagger.a.c.b(this.f), dagger.a.c.b(this.g), dagger.a.c.b(this.h)), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fu
 * JD-Core Version:    0.6.2
 */