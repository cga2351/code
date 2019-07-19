package com.adsnative.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.adsnative.a.a.b;
import com.adsnative.c.e.b;
import com.adsnative.c.e.c;
import com.adsnative.c.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class d
  implements j
{
  private final Set<String> A = new HashSet();
  private final Set<String> B = new HashSet();
  private final Set<String> C = new HashSet();
  private String D;
  private String E;
  private String F;
  private View G;
  private View H;
  private int I = 1000;
  private final Map<String, Object> J = new HashMap();
  private boolean K;
  private boolean L;
  private a a;
  private String b;
  private String c;
  private String d;
  private Drawable e;
  private String f;
  private Drawable g;
  private Double h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private Set<String> n;
  private Set<String> o;
  private Set<String> p;
  private Map<String, JSONArray> q;
  private Set<String> r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private final Set<String> y = new HashSet();
  private final Set<String> z = new HashSet();

  public static void a(Context paramContext, List<String> paramList, final a.b paramb)
    throws IOException
  {
    com.adsnative.c.e locale = com.adsnative.c.e.a(paramContext);
    AtomicInteger localAtomicInteger = new AtomicInteger(paramList.size());
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    e.c local1 = new e.c()
    {
      public void a()
      {
        i.d("Failed to download a native ad image");
        boolean bool = localAtomicBoolean.getAndSet(true);
        this.a.decrementAndGet();
        if (!bool)
          paramb.a(e.c);
      }

      public void a(e.b paramAnonymousb)
      {
        if ((paramAnonymousb.a() != null) && (this.a.decrementAndGet() == 0) && (!localAtomicBoolean.get()))
          paramb.a(paramAnonymousb);
      }
    };
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      String str;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (TextUtils.isEmpty(str))
        {
          localAtomicBoolean.set(true);
          paramb.a(e.c);
        }
      }
      else
      {
        return;
      }
      locale.a(str, local1);
    }
  }

  public final String A()
  {
    return this.E;
  }

  public final int B()
  {
    return 50;
  }

  public final int C()
  {
    return 1;
  }

  public final int D()
  {
    return this.I;
  }

  public final Map<String, Object> E()
  {
    return new HashMap(this.J);
  }

  public final View F()
  {
    return this.G;
  }

  public final View G()
  {
    return this.H;
  }

  public final boolean H()
  {
    return this.L;
  }

  public final boolean I()
  {
    return this.K;
  }

  public void J()
  {
  }

  public void K()
  {
  }

  public void a(View paramView)
  {
  }

  public final void a(a parama)
  {
    this.a = parama;
  }

  public void a(Double paramDouble)
  {
    if (paramDouble == null)
    {
      this.h = null;
      return;
    }
    if ((paramDouble.doubleValue() >= 0.0D) && (paramDouble.doubleValue() <= 5.0D))
    {
      this.h = paramDouble;
      return;
    }
    i.d("Ignoring attempt to set invalid star rating (" + paramDouble + "). Must be between " + 0.0D + " and " + 5.0D + ".");
  }

  public final void a(String paramString)
  {
    this.b = paramString;
  }

  public final void a(String paramString, Object paramObject)
  {
    if (paramString == null)
      return;
    this.J.put(paramString, paramObject);
  }

  public void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      String str;
      for (int i1 = 0; ; i1++)
      {
        if (i1 < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.optJSONObject(i1);
          if (localJSONObject == null)
            break label99;
          str = localJSONObject.optString("url");
        }
        while ((str != null) && (!str.isEmpty()))
        {
          if (!"native".equalsIgnoreCase(this.k))
            break label154;
          if (str.endsWith(".mp4"))
          {
            this.m = str;
            i.b("VIDEO ASSETS -> videoSource1 : " + this.m);
            return;
            label99: str = (String)paramJSONArray.opt(i1);
          }
          else if (i1 == 0)
          {
            this.m = str;
            i.b("VIDEO ASSETS -> videoSource2 : " + this.m);
          }
        }
      }
      label154: this.m = str;
      i.b("VIDEO ASSETS -> videoSource3 : " + this.m);
      return;
    }
    i.e("videoSources is null");
  }

  public void a(JSONObject paramJSONObject)
  {
    int i1 = 0;
    if ((paramJSONObject == null) || (paramJSONObject.length() <= 0))
      i.e("videoTrackingUrls is null");
    JSONArray localJSONArray4;
    do
    {
      JSONObject localJSONObject1;
      do
      {
        return;
        JSONArray localJSONArray1 = paramJSONObject.optJSONArray("impression");
        if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
        {
          this.n = new HashSet();
          for (int i4 = 0; i4 < localJSONArray1.length(); i4++)
            this.n.add(localJSONArray1.optString(i4));
          i.b("VIDEO ASSETS -> videoImpression : " + this.n.toString());
        }
        JSONArray localJSONArray2 = paramJSONObject.optJSONArray("view");
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
        {
          this.o = new HashSet();
          for (int i3 = 0; i3 < localJSONArray2.length(); i3++)
            this.o.add(localJSONArray2.optString(i3));
          i.b("VIDEO ASSETS -> videoView : " + this.o.toString());
        }
        JSONArray localJSONArray3 = paramJSONObject.optJSONArray("clickThrough");
        if ((localJSONArray3 != null) && (localJSONArray3.length() > 0))
        {
          this.p = new HashSet();
          for (int i2 = 0; i2 < localJSONArray3.length(); i2++)
            this.p.add(localJSONArray3.optString(i2));
          i.b("VIDEO ASSETS -> videoClickThrough : " + this.p.toString());
        }
        localJSONObject1 = paramJSONObject.optJSONObject("duration");
        if ((localJSONObject1 != null) && (localJSONObject1.has("percentage")))
        {
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("percentage");
          if (localJSONObject2 != null)
          {
            this.q = new HashMap();
            Iterator localIterator = localJSONObject2.keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              this.q.put(str, localJSONObject2.optJSONArray(str));
            }
            i.b("VIDEO ASSETS -> videoPercentage : " + this.q.toString());
          }
        }
      }
      while ((localJSONObject1 == null) || (!localJSONObject1.has("complete")));
      localJSONArray4 = localJSONObject1.optJSONArray("complete");
    }
    while ((localJSONArray4 == null) || (localJSONArray4.length() <= 0));
    this.r = new HashSet();
    while (i1 < localJSONArray4.length())
    {
      this.r.add(localJSONArray4.optString(i1));
      i1++;
    }
    i.b("VIDEO ASSETS -> videoComplete : " + this.r.toString());
  }

  public final String b()
  {
    return this.b;
  }

  public void b(View paramView)
  {
  }

  public final void b(String paramString)
  {
    this.c = paramString;
  }

  public final String c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }

  public final String d()
  {
    return this.d;
  }

  public void d(String paramString)
  {
    this.f = paramString;
  }

  public final Drawable e()
  {
    return this.e;
  }

  public void e(String paramString)
  {
    if (paramString == null)
    {
      this.i = null;
      return;
    }
    this.i = paramString;
  }

  public final String f()
  {
    return this.f;
  }

  public void f(String paramString)
  {
    if (paramString == null)
    {
      this.j = null;
      return;
    }
    this.j = paramString;
  }

  public final Drawable g()
  {
    return this.g;
  }

  public void g(String paramString)
  {
    if (paramString != null)
    {
      this.k = paramString;
      i.b("VIDEO ASSETS -> videoEmbedType : " + this.k);
      return;
    }
    i.e("videoEmbedType is null");
  }

  public final String h()
  {
    return this.i;
  }

  public void h(String paramString)
  {
    if (paramString != null)
    {
      this.l = paramString;
      i.b("VIDEO ASSETS -> videoExperience : " + this.l);
      return;
    }
    i.e("videoExperience is null");
  }

  public final String i()
  {
    return this.j;
  }

  public void i(String paramString)
  {
    this.t = paramString;
  }

  public final String j()
  {
    return this.m;
  }

  public void j(String paramString)
  {
    this.s = paramString;
  }

  public final Set<String> k()
  {
    if (this.n != null)
      return new HashSet(this.n);
    return new HashSet();
  }

  public void k(String paramString)
  {
    this.F = paramString;
  }

  public final Set<String> l()
  {
    if (this.o != null)
      return new HashSet(this.o);
    return new HashSet();
  }

  public void l(String paramString)
  {
    this.u = paramString;
  }

  public final Set<String> m()
  {
    if (this.p != null)
      return new HashSet(this.p);
    return new HashSet();
  }

  public void m(String paramString)
  {
    this.v = paramString;
  }

  public final Map<String, JSONArray> n()
  {
    if (this.q != null)
      return new HashMap(this.q);
    return new HashMap();
  }

  public void n(String paramString)
  {
    this.w = paramString;
  }

  public final Set<String> o()
  {
    if (this.r != null)
      return new HashSet(this.r);
    return new HashSet();
  }

  public void o(String paramString)
  {
    this.x = paramString;
  }

  public String p()
  {
    return this.s;
  }

  public void p(String paramString)
  {
    if (paramString == null)
      return;
    this.y.add(paramString);
  }

  public final String q()
  {
    return this.F;
  }

  public void q(String paramString)
  {
    if (paramString == null)
      return;
    this.z.add(paramString);
  }

  public String r()
  {
    return this.v;
  }

  public void r(String paramString)
  {
    if (paramString == null)
      return;
    this.A.add(paramString);
  }

  public String s()
  {
    return this.w;
  }

  public void s(String paramString)
  {
    if (paramString == null)
      return;
    this.B.add(paramString);
  }

  public String t()
  {
    return this.x;
  }

  public void t(String paramString)
  {
    if (paramString == null)
      return;
    this.C.add(paramString);
  }

  public final Set<String> u()
  {
    return new HashSet(this.y);
  }

  public void u(String paramString)
  {
    this.D = paramString;
  }

  public final Set<String> v()
  {
    return new HashSet(this.z);
  }

  public void v(String paramString)
  {
    this.E = paramString;
  }

  public final Set<String> w()
  {
    return new HashSet(this.A);
  }

  public final Set<String> x()
  {
    return new HashSet(this.B);
  }

  public final Set<String> y()
  {
    return new HashSet(this.C);
  }

  public final String z()
  {
    return this.D;
  }

  protected static abstract interface a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.d
 * JD-Core Version:    0.6.2
 */