package com.viber.voip.messages.extensions;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.d.f;
import com.google.d.p;
import com.viber.common.b.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.messages.extensions.model.c.b;
import com.viber.voip.settings.d;
import com.viber.voip.settings.d.al;
import com.viber.voip.util.bj;
import com.viber.voip.util.da;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  static final long a = TimeUnit.DAYS.toMillis(7L);
  private static final Logger b = ViberEnv.getLogger();
  private final Handler c;
  private final b d;
  private final d.al e;
  private final com.viber.common.b.e f;
  private final com.viber.common.b.h g;
  private final com.viber.common.b.h h;
  private final com.viber.voip.util.i.e i;
  private final Runnable j = new Runnable()
  {
    public void run()
    {
      h.a(h.this);
    }
  };
  private final Runnable k = new Runnable()
  {
    public void run()
    {
      h.b(h.this);
    }
  };

  public h(Handler paramHandler, com.viber.common.b.e parame, com.viber.common.b.h paramh1, com.viber.common.b.h paramh2, c paramc)
  {
    this(paramHandler, new a(paramc), parame, paramh1, paramh2, new com.viber.voip.util.i.c());
  }

  public h(Handler paramHandler, b paramb, com.viber.common.b.e parame, com.viber.common.b.h paramh1, final com.viber.common.b.h paramh2, com.viber.voip.util.i.e parame1)
  {
    this.c = paramHandler;
    this.d = paramb;
    this.i = parame1;
    this.f = parame;
    this.g = paramh1;
    this.h = paramh2;
    this.e = new d.al(paramHandler, new a[] { paramh2 })
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        if (paramh2.c().equals(paramAnonymousa.c()))
          h.a(h.this, h.c(h.this));
      }
    };
  }

  private void a(Runnable paramRunnable)
  {
    this.c.removeCallbacks(paramRunnable);
    if (Looper.myLooper() == this.c.getLooper())
    {
      paramRunnable.run();
      return;
    }
    this.c.post(paramRunnable);
  }

  private void c()
  {
    if (this.i.a() - this.f.d() <= a)
      return;
    a(this.j);
  }

  private void d()
  {
    this.f.a(this.i.a());
    String[] arrayOfString = this.g.d().split(",");
    String str = da.b(this.h.d(), Locale.getDefault().getLanguage());
    if ((arrayOfString.length == 0) || (TextUtils.isEmpty(arrayOfString[0])));
    while (-2 != this.d.a(arrayOfString, str))
      return;
    this.f.e();
  }

  public void a()
  {
    d.a(this.e);
  }

  public void a(String paramString)
  {
    if (paramString != null);
    while (true)
    {
      String str = this.g.d();
      this.g.a(paramString);
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str)))
        a(this.j);
      return;
      paramString = "";
    }
  }

  public void b()
  {
    a(this.k);
  }

  public static class a
    implements h.b
  {
    private final c a;
    private f b;

    public a(c paramc)
    {
      this.a = paramc;
    }

    private f a()
    {
      if (this.b == null)
        this.b = new f();
      return this.b;
    }

    private void a(String paramString, String[] paramArrayOfString)
      throws JSONException, IOException
    {
      Request localRequest = new Request.Builder().get().url(paramString).build();
      JSONObject localJSONObject1 = new JSONObject(bj.a(ViberEnv.getOkHttpClientFactory().createClient().newCall(localRequest).execute().body().source().g())).getJSONObject("groups");
      ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
      HashSet localHashSet = new HashSet(paramArrayOfString.length);
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str);
        if ((!localHashSet.contains(str)) && (localJSONObject2.getString("result").equals("0")))
        {
          localHashSet.add(str);
          localArrayList.add((c.b)a().a(localJSONObject2.getJSONObject("group").toString(), c.b.class));
        }
      }
      this.a.a(localArrayList);
    }

    public int a(String[] paramArrayOfString, String paramString)
    {
      String str1 = ap.c().aO;
      String str2 = TextUtils.join(",", paramArrayOfString);
      String str3 = String.format(Locale.US, str1, new Object[] { str2, paramString });
      try
      {
        a(str3, paramArrayOfString);
        return 0;
      }
      catch (IOException localIOException)
      {
        return -2;
      }
      catch (p localp)
      {
        return -1;
      }
      catch (JSONException localJSONException)
      {
        label53: break label53;
      }
    }
  }

  public static abstract interface b
  {
    public abstract int a(String[] paramArrayOfString, String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.h
 * JD-Core Version:    0.6.2
 */