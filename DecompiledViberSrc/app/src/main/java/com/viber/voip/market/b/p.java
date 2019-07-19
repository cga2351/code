package com.viber.voip.market.b;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class p
{
  private static final Logger a = ViberEnv.getLogger();

  public void a(final String paramString)
  {
    av.e.f.a().post(new Runnable()
    {
      public void run()
      {
        try
        {
          OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
          Request.Builder localBuilder1 = new Request.Builder().url(paramString);
          localBuilder1.method("POST", null);
          localBuilder1.post(RequestBody.create(null, new byte[0]));
          localBuilder.build().newCall(localBuilder1.build()).execute().body().string();
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.p
 * JD-Core Version:    0.6.2
 */