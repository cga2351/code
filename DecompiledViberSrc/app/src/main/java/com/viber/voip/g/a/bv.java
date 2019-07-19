package com.viber.voip.g.a;

import android.app.Application;
import com.squareup.leakcanary.RefWatcher;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bv
  implements d<RefWatcher>
{
  private final Provider<Application> a;

  public bv(Provider<Application> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bv a(Provider<Application> paramProvider)
  {
    return new bv(paramProvider);
  }

  public RefWatcher a()
  {
    return (RefWatcher)h.a(bu.a((Application)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bv
 * JD-Core Version:    0.6.2
 */