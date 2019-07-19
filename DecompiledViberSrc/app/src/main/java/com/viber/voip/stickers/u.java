package com.viber.voip.stickers;

import android.os.Handler;
import android.support.v4.util.CircularIntArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.ProductId;
import com.viber.voip.settings.d.ax;
import com.viber.voip.stickers.entity.c;
import com.viber.voip.stickers.entity.c.a;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class u
{
  private static final Logger a = ViberEnv.getLogger();
  private Handler b;
  private com.viber.voip.stickers.b.a c;
  private boolean d;
  private long e;

  public u(Handler paramHandler, com.viber.voip.stickers.b.a parama)
  {
    this.b = paramHandler;
    this.c = parama;
    this.d = false;
  }

  public static com.viber.voip.market.g a(int paramInt)
    throws IOException
  {
    com.viber.voip.market.g localg = com.viber.voip.market.g.a(ProductId.fromStickerPackageId(paramInt));
    if ((localg == null) || (da.a(localg.c)) || (localg.f == null) || (localg.f.length == 0))
    {
      String str1 = com.viber.voip.stickers.c.g.g(paramInt);
      OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
      Request.Builder localBuilder1 = new Request.Builder().url(str1);
      String str2 = localBuilder.build().newCall(localBuilder1.build()).execute().body().string();
      if (str2 != null)
        localg = com.viber.voip.market.g.a(str2);
    }
    return localg;
  }

  public static long b(int paramInt)
  {
    try
    {
      String str = com.viber.voip.stickers.c.g.a(paramInt, p.a);
      OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
      Request.Builder localBuilder1 = new Request.Builder().url(str).head();
      Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
      if (localResponse.body().contentLength() != -1L)
      {
        long l = localResponse.body().contentLength();
        return l;
      }
    }
    catch (Exception localException)
    {
      com.viber.voip.analytics.f.a.a("StickerPackageSyncInfoManager.loadStickerPackageWeight", localException);
    }
    return 0L;
  }

  private static c b(int paramInt, boolean paramBoolean)
    throws IOException
  {
    com.viber.voip.market.g localg = a(paramInt);
    if (localg == null)
      return null;
    c localc = new c();
    localc.b(localg.c);
    if (paramBoolean)
    {
      localc.c(localg.d);
      localc.a(localg.f);
      if (!localg.e.equalsIgnoreCase(com.viber.voip.market.g.a))
        break label81;
    }
    label81: for (c.a locala = c.a.b; ; locala = c.a.a)
    {
      localc.a(locala);
      localc.a(b(paramInt));
      return localc;
    }
  }

  public void a(CircularIntArray paramCircularIntArray)
  {
  }

  public boolean a()
  {
    return d.ax.g.d();
  }

  public void b(final CircularIntArray paramCircularIntArray)
  {
    if ((!this.d) && (!paramCircularIntArray.isEmpty()) && (cj.b(ViberApplication.getApplication())) && (System.currentTimeMillis() - this.e > 600000L))
    {
      this.d = true;
      this.b.post(new Runnable()
      {
        public void run()
        {
          boolean bool = u.this.a();
          int i = paramCircularIntArray.size();
          int j = 0;
          while (true)
          {
            int k;
            if (j < i)
              k = paramCircularIntArray.get(j);
            try
            {
              com.viber.voip.stickers.entity.a locala = i.a().g(k);
              if (locala != null)
                if ((bool) || (!locala.t()))
                {
                  c localc1 = u.a(k, locala.h());
                  if (localc1 != null)
                  {
                    localc1.a(u.b(k));
                    u.a(u.this).a(k, localc1);
                  }
                }
                else if ((!locala.h()) && (locala.q() == 0L))
                {
                  c localc2 = ((com.viber.voip.stickers.entity.b)locala).y();
                  if (localc2 != null)
                  {
                    localc2.a(u.b(k));
                    break label210;
                    if (u.this.a())
                      d.ax.g.a(false);
                    u.a(u.this, System.currentTimeMillis());
                    u.a(u.this, false);
                    u.this.a(paramCircularIntArray);
                    return;
                  }
                }
              label210: j++;
            }
            catch (IOException localIOException)
            {
              break label210;
            }
          }
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.u
 * JD-Core Version:    0.6.2
 */