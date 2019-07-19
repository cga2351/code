package com.viber.voip.api.a;

import java.io.IOException;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class a
  implements Interceptor
{
  private final String a;

  public a(String paramString1, String paramString2)
  {
    this.a = Credentials.basic(paramString1, paramString2);
  }

  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    return paramChain.proceed(paramChain.request().newBuilder().header("Authorization", this.a).build());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.a.a
 * JD-Core Version:    0.6.2
 */