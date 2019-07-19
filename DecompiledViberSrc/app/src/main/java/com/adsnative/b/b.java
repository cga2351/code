package com.adsnative.b;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import com.adsnative.a.a.a;
import com.adsnative.a.d.a;
import com.adsnative.ads.aa;
import com.adsnative.ads.ab;
import com.adsnative.ads.e;
import com.adsnative.ads.f;
import com.adsnative.ads.j;
import com.adsnative.ads.n;
import com.adsnative.ads.o;
import com.adsnative.ads.v;
import com.adsnative.ads.w;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  static final o a = new o()
  {
    public void a(f paramAnonymousf)
    {
    }

    public void a(n paramAnonymousn)
    {
      paramAnonymousn.K();
    }

    public void b(f paramAnonymousf)
    {
    }
  };
  private final WeakReference<Context> b;
  private Map<String, String> c;
  private Map<String, ArrayList<String>> d;
  private String e;
  private List<String> f;
  private Map<String, String> g;
  private Context h;
  private com.adsnative.c.b i;
  private o j;
  private String k;
  private String l;
  private Location m;
  private ab n;
  private v o;
  private com.adsnative.ads.i p;
  private boolean q = true;

  public b(String paramString, aa paramaa, Context paramContext)
  {
    this.e = paramString;
    if (paramaa != null)
      if (paramaa.a() != null)
      {
        this.f = paramaa.a();
        if (paramaa.b() == null)
          break label141;
        this.c = paramaa.b();
        label48: if (paramaa.c() == null)
          break label155;
        this.d = paramaa.c();
        label63: this.m = paramaa.d();
        this.q = paramaa.e();
      }
    while (true)
    {
      this.g = new HashMap();
      this.h = paramContext;
      this.i = new com.adsnative.c.b(paramContext);
      this.j = a;
      this.b = new WeakReference(paramContext);
      return;
      this.f = new ArrayList();
      break;
      label141: this.c = new HashMap();
      break label48;
      label155: this.d = new HashMap();
      break label63;
      this.f = new ArrayList();
      this.c = new HashMap();
    }
  }

  private void a(final c paramc)
  {
    final Context localContext = d();
    if (localContext == null)
      return;
    a.a local3 = new a.a()
    {
      public void a(e paramAnonymouse)
      {
        String str;
        if (paramc.f() != null)
          str = paramc.f();
        while (true)
        {
          com.adsnative.c.i.e("onNativeAdFailed for '" + str + "' with ErrorCode '" + paramAnonymouse.toString() + "'");
          try
          {
            if (paramc.a())
            {
              b.a(b.this, paramc);
              return;
              str = "AdsNative";
            }
            else
            {
              b.d(b.this).a(new f("All networks returned NO-FILL"));
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            b.d(b.this).a(new f("JSONException: " + paramc.f()));
          }
        }
      }

      public void a(j paramAnonymousj)
      {
        Context localContext = b.this.d();
        if (localContext == null)
          return;
        b.d(b.this).a(new n(localContext, paramc, b.c(b.this), paramAnonymousj));
      }
    };
    d.a local4 = new d.a()
    {
      public void a(com.adsnative.ads.b.a paramAnonymousa)
      {
        w localw = new w(localContext, paramc, b.c(b.this), paramAnonymousa, b.e(b.this).b(), b.e(b.this).c(), b.f(b.this));
        if (!b.e(b.this).d().booleanValue())
        {
          localw.a();
          return;
        }
        b.f(b.this).b(localw);
      }

      public void a(e paramAnonymouse)
      {
        String str;
        if (paramc.f() != null)
          str = paramc.f();
        while (true)
        {
          com.adsnative.c.i.e("onBannerAdFailed for '" + str + "' with ErrorCode '" + paramAnonymouse.toString() + "'");
          try
          {
            if (paramc.a())
            {
              b.a(b.this, paramc);
              return;
              str = "AdsNative";
            }
            else
            {
              b.d(b.this).b(new f("All networks returned NO-FILL"));
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            b.d(b.this).b(new f("JSONException: " + paramc.f()));
          }
        }
      }
    };
    if (this.n != null)
    {
      if (paramc.c().equalsIgnoreCase("banner"))
      {
        if ((this.n.a().equalsIgnoreCase("banner")) || (this.n.a().equalsIgnoreCase("all")))
        {
          com.adsnative.a.b.a(localContext, paramc, local4);
          return;
        }
        local3.a(e.s);
        return;
      }
      if ((paramc.c().equalsIgnoreCase("story")) || (paramc.c().equalsIgnoreCase("video")))
      {
        if ((this.n.a().equalsIgnoreCase("all")) || (this.n.a().equalsIgnoreCase("native")))
        {
          com.adsnative.a.b.a(localContext, paramc, local3);
          return;
        }
        local4.a(e.t);
        return;
      }
      if ((this.n.a().equalsIgnoreCase("all")) || (this.n.a().equalsIgnoreCase("native")))
      {
        com.adsnative.a.b.a(localContext, paramc, local3);
        return;
      }
      local4.a(e.t);
      return;
    }
    com.adsnative.a.b.a(localContext, paramc, local3);
  }

  private void a(String paramString)
  {
    this.k = paramString;
  }

  private void b(String paramString)
  {
    this.l = paramString;
  }

  private b i()
  {
    return this;
  }

  private boolean j()
  {
    return this.q;
  }

  public void a()
  {
    if (j())
    {
      new com.adsnative.c.d(this.h)
      {
        protected void a(Map<String, String> paramAnonymousMap)
        {
          super.onPostExecute(paramAnonymousMap);
          if ((paramAnonymousMap != null) && (paramAnonymousMap.size() > 0))
          {
            b.a(b.this, (String)paramAnonymousMap.get("uuid"));
            b.b(b.this, (String)paramAnonymousMap.get("dnt"));
          }
          while (true)
          {
            new b.a(b.this, b.a(b.this), b.b(b.this)).execute(new String[0]);
            return;
            b.a(b.this, "");
            b.b(b.this, "0");
          }
        }
      }
      .execute(new Void[0]);
      return;
    }
    a("");
    b("0");
    new a(i(), this.i).execute(new String[0]);
  }

  public void a(ab paramab)
  {
    this.n = paramab;
  }

  public void a(com.adsnative.ads.i parami)
  {
    this.p = parami;
  }

  public void a(o paramo)
  {
    this.j = paramo;
  }

  public void a(v paramv)
  {
    this.o = paramv;
  }

  public Location b()
  {
    return this.m;
  }

  public void c()
  {
    this.b.clear();
    this.j = a;
  }

  Context d()
  {
    Context localContext = (Context)this.b.get();
    if (localContext == null)
    {
      c();
      com.adsnative.c.i.b("Weak reference to Activity Context in AdRequest became null. This instance of AdRequest is destroyed and no more requests will be processed.");
    }
    return localContext;
  }

  public String e()
  {
    return this.e;
  }

  public Map<String, String> f()
  {
    return this.c;
  }

  public int g()
  {
    return this.c.size();
  }

  public Map<String, ArrayList<String>> h()
  {
    return this.d;
  }

  private class a extends AsyncTask<String, Void, c>
  {
    private b b;
    private com.adsnative.c.b c;
    private String d;

    public a(b paramb, com.adsnative.c.b arg3)
    {
      this.b = paramb;
      Object localObject;
      this.c = localObject;
    }

    protected c a(String[] paramArrayOfString)
    {
      d locald = new d(this.b, b.g(b.this), b.h(b.this), this.c, b.i(b.this));
      try
      {
        String str2 = locald.a();
        str1 = str2;
        if (str1 == null);
      }
      catch (IOException localIOException)
      {
        try
        {
          c localc = new c(new JSONObject(str1));
          return localc;
          localIOException = localIOException;
          com.adsnative.c.i.e("IOException in AdRequest for NativeAdAPI : " + localIOException.getMessage());
          this.d = "Internet connection problem";
          String str1 = null;
        }
        catch (JSONException localJSONException)
        {
          com.adsnative.c.i.e("JSONException in AdRequest for NativeAdAPI : " + localJSONException.getMessage());
          this.d = "AdResponse JSON Exception";
        }
      }
      return null;
    }

    protected void a(f paramf)
    {
      b.d(b.this).a(paramf);
      b.d(b.this).b(paramf);
    }

    protected void a(c paramc)
    {
      super.onPostExecute(paramc);
      if (this.d != null)
        a(new f(this.d));
      do
      {
        do
          return;
        while (paramc == null);
        if (paramc.d().equalsIgnoreCase("OK"))
        {
          b.a(b.this, paramc);
          return;
        }
      }
      while (!paramc.d().equalsIgnoreCase("FAIL"));
      a(paramc.l());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.b.b
 * JD-Core Version:    0.6.2
 */