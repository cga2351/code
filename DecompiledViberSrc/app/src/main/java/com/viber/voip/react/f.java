package com.viber.voip.react;

import com.facebook.react.modules.network.OkHttpClientProvider;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.http.OkHttpClientFactory.Type;
import okhttp3.OkHttpClient;

public class f
{
  public static void a()
  {
    OkHttpClientProvider.setOkHttpClientFactory(new com.facebook.react.modules.network.OkHttpClientFactory()
    {
      public OkHttpClient createNewNetworkModuleClient()
      {
        return ViberEnv.getOkHttpClientFactory().createClient(OkHttpClientFactory.Type.REACT);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.react.f
 * JD-Core Version:    0.6.2
 */