package com.viber.voip.g.a;

import com.viber.voip.ap.a;
import com.viber.voip.util.http.OkHttpClientFactory;
import g.m;
import g.m.a;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient.Builder;

public abstract class fd
{
  @Singleton
  static com.viber.voip.api.a.b.a a(OkHttpClientFactory paramOkHttpClientFactory, ap.a parama)
  {
    OkHttpClient.Builder localBuilder = paramOkHttpClientFactory.createBuilder();
    return (com.viber.voip.api.a.b.a)new m.a().a(parama.ah + "/").a(g.a.a.a.a()).a(localBuilder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).build()).a().a(com.viber.voip.api.a.b.a.class);
  }

  @Singleton
  static com.viber.voip.api.a.a.a b(OkHttpClientFactory paramOkHttpClientFactory, ap.a parama)
  {
    OkHttpClient.Builder localBuilder = paramOkHttpClientFactory.createBuilder();
    localBuilder.addInterceptor(new com.viber.voip.api.a.a(parama.L, parama.M));
    return (com.viber.voip.api.a.a.a)new m.a().a(parama.K).a(g.a.a.a.a()).a(localBuilder.connectTimeout(20000L, TimeUnit.MILLISECONDS).readTimeout(20000L, TimeUnit.MILLISECONDS).writeTimeout(20000L, TimeUnit.MILLISECONDS).build()).a().a(com.viber.voip.api.a.a.a.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fd
 * JD-Core Version:    0.6.2
 */