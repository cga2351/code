package com.viber.voip.ads;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.bg;
import com.viber.voip.util.cj;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;

public class t
  implements s
{
  private static final Logger a = ViberEnv.getLogger();
  private static final int b = (int)TimeUnit.SECONDS.toMillis(3L);
  private Context c;
  private Handler d;
  private Queue<String> e = new LinkedBlockingQueue(256);

  public t(Context paramContext, Handler paramHandler)
  {
    this.c = paramContext.getApplicationContext();
    this.d = paramHandler;
  }

  private void a(String paramString)
  {
    if (!cj.b(this.c))
    {
      this.e.offer(paramString);
      return;
    }
    try
    {
      OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder().readTimeout(b, TimeUnit.MILLISECONDS).connectTimeout(b, TimeUnit.MILLISECONDS);
      Request.Builder localBuilder1 = new Request.Builder().url(paramString);
      localBuilder1.header("User-Agent", bg.a());
      localBuilder.build().newCall(localBuilder1.build()).execute();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(String[] paramArrayOfString)
  {
    this.d.post(new a(paramArrayOfString));
  }

  private class a
    implements Runnable
  {
    String[] a;

    a(String[] arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    private void a()
    {
      ArrayList localArrayList = new ArrayList(t.a(t.this));
      t.a(t.this).clear();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        t.a(t.this, str);
      }
    }

    private void b()
    {
      for (String str : this.a)
        t.a(t.this, str);
    }

    public void run()
    {
      a();
      b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.t
 * JD-Core Version:    0.6.2
 */