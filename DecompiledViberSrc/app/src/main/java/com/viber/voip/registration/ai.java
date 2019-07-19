package com.viber.voip.registration;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.m.b;
import com.viber.voip.m.c;
import com.viber.voip.util.cp;
import com.viber.voip.util.da;
import com.viber.voip.util.http.OkHttpClientFactory;
import com.viber.voip.util.t;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import okhttp3.Call;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ai
{
  private static final Logger a = ViberEnv.getLogger();

  private void a(CountDownLatch paramCountDownLatch)
  {
    try
    {
      paramCountDownLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public <RES> RES a(ag<RES> paramag)
    throws Exception
  {
    ar localar = new ar();
    String str = localar.a(paramag.b());
    OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
    Request.Builder localBuilder1 = new Request.Builder().url(paramag.a());
    FormBody.Builder localBuilder2 = new FormBody.Builder();
    localBuilder2.add("XMLDOC", str);
    Iterator localIterator = paramag.d().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBuilder2.add((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localBuilder1.post(localBuilder2.build());
    Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
    return localar.a(paramag.c(), localResponse.body());
  }

  public <RES> RES a(final ag<RES> paramag, t paramt)
    throws Exception
  {
    final Object[] arrayOfObject = (Object[])Array.newInstance(paramag.c(), 1);
    final Exception[] arrayOfException = new Exception[1];
    b localb = new b();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final ar localar = new ar();
    String str = localar.a(paramag.b());
    paramt.a(new t()
    {
      public void a()
      {
        this.a.b();
      }
    });
    a(localCountDownLatch);
    if (arrayOfException[0] != null)
      return null;
    return arrayOfObject[0];
  }

  public <RES> void a(Handler paramHandler, final ag<RES> paramag, final aj<RES> paramaj, final t paramt)
  {
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject2 = ai.this.a(paramag, paramt);
          localObject1 = localObject2;
          paramaj.a(localObject1);
          return;
        }
        catch (Exception localException)
        {
          while (true)
            Object localObject1 = null;
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ai
 * JD-Core Version:    0.6.2
 */