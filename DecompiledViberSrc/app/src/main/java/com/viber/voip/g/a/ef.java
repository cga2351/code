package com.viber.voip.g.a;

import com.viber.voip.util.http.OkHttpClientFactory;
import dagger.a.d;
import dagger.a.h;

public final class ef
  implements d<OkHttpClientFactory>
{
  private static final ef a = new ef();

  public static ef b()
  {
    return a;
  }

  public OkHttpClientFactory a()
  {
    return (OkHttpClientFactory)h.a(ec.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ef
 * JD-Core Version:    0.6.2
 */