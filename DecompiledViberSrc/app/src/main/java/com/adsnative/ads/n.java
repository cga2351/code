package com.adsnative.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.adsnative.b.c;
import com.adsnative.b.f;
import com.adsnative.c.e;
import com.adsnative.c.l;
import com.adsnative.c.m;
import com.adsnative.c.m.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;

public class n
{
  private final j a;
  private final Double b;
  private final Double c;
  private final Set<String> d;
  private final Set<String> e;
  private final Set<String> f;
  private final g g;
  private final Context h;
  private final Context i;
  private final e j;
  private final h k;
  private p l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private c q;

  public n(Context paramContext, c paramc, i parami, j paramj)
  {
    this.h = paramContext.getApplicationContext();
    this.i = paramContext;
    this.b = paramc.e();
    this.q = paramc;
    this.c = parami.b();
    this.a = paramj;
    this.d = new HashSet();
    ArrayList localArrayList1 = paramc.g();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      this.d.addAll(localArrayList1);
    this.e = new HashSet();
    ArrayList localArrayList2 = paramc.h();
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      this.e.addAll(localArrayList2);
    this.f = new HashSet();
    ArrayList localArrayList3 = paramc.i();
    if ((localArrayList3 != null) && (localArrayList3.size() > 0))
      this.f.addAll(localArrayList3);
    this.g = new g(paramContext);
    this.p = false;
    this.a.a(new d.a()
    {
    });
    this.j = e.a(paramContext);
    this.k = new h(this.i);
    this.k.a(new h.c()
    {
      private boolean b = false;
      private boolean c = false;
      private boolean d = false;
      private Map<String, JSONArray> e = n.this.A();

      public void a()
      {
        if (!this.b)
        {
          com.adsnative.c.i.b("NativeAdUnit -> MediaViewTrackersListener -> VideoImpressed()");
          Iterator localIterator = n.this.x().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            new n.c(n.this, str).execute(new String[0]);
          }
          this.b = true;
        }
      }

      public void a(String paramAnonymousString)
      {
        com.adsnative.c.i.b("NativeAdUnit -> MediaViewTrackersListener -> videoQuartiles() : " + paramAnonymousString);
        if ("100".equals(paramAnonymousString))
        {
          Iterator localIterator = n.this.B().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            new n.c(n.this, str).execute(new String[0]);
          }
        }
        if ((this.e != null) && (this.e.size() > 0))
        {
          JSONArray localJSONArray = (JSONArray)this.e.get(paramAnonymousString);
          if ((localJSONArray != null) && (localJSONArray.length() > 0))
            for (int i = 0; i < localJSONArray.length(); i++)
              new n.c(n.this, localJSONArray.optString(i)).execute(new String[0]);
        }
      }

      public void b()
      {
        if (!this.c)
        {
          com.adsnative.c.i.b("NativeAdUnit -> MediaViewTrackersListener -> videoOnStart()");
          Iterator localIterator = n.this.y().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            new n.c(n.this, str).execute(new String[0]);
          }
          this.c = true;
        }
      }

      public void c()
      {
        if (!this.d)
        {
          com.adsnative.c.i.b("NativeAdUnit -> MediaViewTrackersListener -> videoClickThrough()");
          Iterator localIterator = n.this.z().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            new n.c(n.this, str).execute(new String[0]);
          }
          this.d = true;
        }
      }
    });
    this.k.a((HashMap)A());
    this.k.a((ArrayList)B());
    this.l = null;
  }

  private void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = 0;
      if (i1 < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i1);
        if (d(localView));
        while (true)
        {
          i1++;
          break;
          a(localView, paramOnClickListener);
        }
      }
    }
    else
    {
      paramView.setOnClickListener(paramOnClickListener);
    }
  }

  private void a(final View paramView, final ae paramae, String paramString)
  {
    if (paramae == null)
      throw new NullPointerException("SpinningProgressView is null");
    if ((r() == null) && (paramString == null))
      return;
    if (paramView != null)
      paramae.a(paramView);
    m localm = new m(EnumSet.of(l.a, l.c, l.d), new m.a()
    {
      private void a()
      {
        if (paramView != null)
          paramae.a();
      }

      public void a(String paramAnonymousString, l paramAnonymousl)
      {
        a();
      }

      public void b(String paramAnonymousString, l paramAnonymousl)
      {
        a();
      }
    });
    if (paramString != null)
    {
      localm.a(this.h, paramString);
      return;
    }
    localm.a(this.h, r());
  }

  private void a(ViewGroup paramViewGroup)
  {
    for (int i1 = 0; i1 < paramViewGroup.getChildCount(); i1++)
    {
      View localView = paramViewGroup.getChildAt(i1);
      if ((localView instanceof LinearLayout))
        h.a(((LinearLayout)localView).getChildAt(0));
    }
  }

  private boolean d(View paramView)
  {
    return (paramView != null) && (paramView.getId() == h.a) && ("video".equals(t())) && (g() != null);
  }

  public final Map<String, JSONArray> A()
  {
    return new HashMap(this.a.n());
  }

  public final List<String> B()
  {
    return new ArrayList(this.a.o());
  }

  public int C()
  {
    return this.a.D();
  }

  public int D()
  {
    return this.a.B();
  }

  public int E()
  {
    return this.a.C();
  }

  public boolean F()
  {
    return this.a.H();
  }

  public View G()
  {
    return this.a.F();
  }

  public View H()
  {
    return this.a.G();
  }

  public boolean I()
  {
    return this.a.I();
  }

  public void J()
  {
    if ((M()) || (O()))
      return;
    Iterator localIterator = l().iterator();
    while (localIterator.hasNext())
      new c((String)localIterator.next()).execute(new String[0]);
    this.n = true;
  }

  public void K()
  {
    if (O())
      return;
    this.a.K();
    this.p = true;
  }

  public boolean L()
  {
    return this.m;
  }

  public boolean M()
  {
    return this.n;
  }

  public boolean N()
  {
    return this.o;
  }

  public boolean O()
  {
    return this.p;
  }

  public String a()
  {
    return this.a.b();
  }

  public void a(View paramView)
  {
    if (O())
      return;
    if (!I())
      a(paramView, new a());
    this.a.a(paramView);
  }

  void a(View paramView, ae paramae)
  {
    if (paramae == null)
      throw new NullPointerException();
    if (O());
    while (true)
    {
      return;
      if (!N())
      {
        Iterator localIterator = m().iterator();
        while (localIterator.hasNext())
          new c((String)localIterator.next()).execute(new String[0]);
      }
      this.o = true;
      if ((paramView != null) && (paramView.getParent() != null))
        a((ViewGroup)paramView.getParent());
      this.a.b(paramView);
      if (this.l != null);
      for (boolean bool = this.l.b(this); !bool; bool = false)
      {
        a(paramView, paramae, null);
        return;
      }
    }
  }

  public final void a(p paramp)
  {
    this.l = paramp;
  }

  public String b()
  {
    return this.a.c();
  }

  public void b(View paramView)
  {
    if ((L()) || (O()))
      return;
    Iterator localIterator = k().iterator();
    while (localIterator.hasNext())
      new c((String)localIterator.next()).execute(new String[0]);
    this.a.J();
    if (this.l != null)
      this.l.a();
    this.m = true;
  }

  public String c()
  {
    return this.a.d();
  }

  public void c(View paramView)
  {
    a(paramView, new ae(this.h));
  }

  public Drawable d()
  {
    return this.a.e();
  }

  public String e()
  {
    return this.a.f();
  }

  public Drawable f()
  {
    return this.a.g();
  }

  public String g()
  {
    return this.a.j();
  }

  public String h()
  {
    return this.a.p();
  }

  public String i()
  {
    return this.a.r();
  }

  public String j()
  {
    return this.a.s();
  }

  public final List<String> k()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.d);
    localHashSet.addAll(this.a.u());
    return new ArrayList(localHashSet);
  }

  public final List<String> l()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.e);
    localHashSet.addAll(this.a.v());
    return new ArrayList(localHashSet);
  }

  public final List<String> m()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.f);
    localHashSet.addAll(this.a.w());
    return new ArrayList(localHashSet);
  }

  public final List<String> n()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.q.j());
    localHashSet.addAll(this.a.x());
    return new ArrayList(localHashSet);
  }

  public final List<String> o()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.q.k());
    localHashSet.addAll(this.a.y());
    return new ArrayList(localHashSet);
  }

  public void p()
  {
    Iterator localIterator = n().iterator();
    while (localIterator.hasNext())
      new c((String)localIterator.next()).execute(new String[0]);
  }

  public void q()
  {
    Iterator localIterator = o().iterator();
    while (localIterator.hasNext())
      new c((String)localIterator.next()).execute(new String[0]);
  }

  public String r()
  {
    return this.a.z();
  }

  public String s()
  {
    if ((this.a.A() != null) && (!this.a.A().equals("")))
      return this.a.A();
    return "";
  }

  public String t()
  {
    return this.a.q();
  }

  public Double u()
  {
    return this.b;
  }

  public Double v()
  {
    return this.c;
  }

  public String w()
  {
    return this.a.t();
  }

  public final List<String> x()
  {
    return new ArrayList(this.a.k());
  }

  public final List<String> y()
  {
    return new ArrayList(this.a.l());
  }

  public final List<String> z()
  {
    return new ArrayList(this.a.m());
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      n.this.c(paramView);
    }
  }

  public static enum b
  {
    public static final Set<String> s;
    public final String q;
    public final boolean r;

    static
    {
      int i1 = 0;
      a = new b("TITLE", 0, "title", false);
      b = new b("SUMMARY", 1, "summary", false);
      c = new b("MAIN_IMAGE", 2, "imageSrc", false);
      d = new b("ICON_IMAGE", 3, "brandImageUrl", false);
      e = new b("STAR_RATING", 4, "starRating", false);
      f = new b("VIDEO", 5, "video", false);
      g = new b("TRACKING_URLS", 6, "trackingUrls", true);
      h = new b("LANDING_URL", 7, "landingUrl", false);
      i = new b("CALL_TO_ACTION", 8, "ctaTitle", false);
      j = new b("PROMOTED_BY_TAG", 9, "promotedByTag", false);
      k = new b("PROMOTED_BY", 10, "promotedBy", false);
      l = new b("HTML", 11, "html", false);
      m = new b("EMBED_URL", 12, "embedUrl", false);
      n = new b("PRIVACY", 13, "privacy", false);
      o = new b("VAST_URL", 14, "vastUrl", false);
      p = new b("TYPE", 15, "type", true);
      b[] arrayOfb1 = new b[16];
      arrayOfb1[0] = a;
      arrayOfb1[1] = b;
      arrayOfb1[2] = c;
      arrayOfb1[3] = d;
      arrayOfb1[4] = e;
      arrayOfb1[5] = f;
      arrayOfb1[6] = g;
      arrayOfb1[7] = h;
      arrayOfb1[8] = i;
      arrayOfb1[9] = j;
      arrayOfb1[10] = k;
      arrayOfb1[11] = l;
      arrayOfb1[12] = m;
      arrayOfb1[13] = n;
      arrayOfb1[14] = o;
      arrayOfb1[15] = p;
      t = arrayOfb1;
      s = new HashSet();
      b[] arrayOfb2 = values();
      int i2 = arrayOfb2.length;
      while (i1 < i2)
      {
        b localb = arrayOfb2[i1];
        if (localb.r)
          s.add(localb.q);
        i1++;
      }
    }

    private b(String paramString, boolean paramBoolean)
    {
      this.q = paramString;
      this.r = paramBoolean;
    }

    public static b a(String paramString)
    {
      for (b localb : values())
        if (localb.q.equals(paramString))
          return localb;
      return null;
    }
  }

  private class c extends AsyncTask<String, Void, Boolean>
  {
    private final String b;
    private final f c;

    public c(String arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = f.a(n.a(n.this));
    }

    protected Boolean a(String[] paramArrayOfString)
    {
      try
      {
        Boolean localBoolean = new Boolean(this.c.a(n.a(n.this), this.b));
        return localBoolean;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        com.adsnative.c.i.e("ClientProtocolException firing the tracking url: " + localClientProtocolException.getMessage());
        return Boolean.valueOf(false);
      }
      catch (IOException localIOException)
      {
        while (true)
          com.adsnative.c.i.e("IOException firing the tracking url: " + localIOException.getMessage());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          com.adsnative.c.i.e("IllegalArgumentException firing the tracking url: " + localIllegalArgumentException.getMessage());
      }
      catch (Exception localException)
      {
        while (true)
          com.adsnative.c.i.e("Unknown Exception firing the tracking url: " + localException.getMessage());
      }
    }

    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      if (!paramBoolean.booleanValue())
        com.adsnative.c.i.e("Failed to fire the tracking url: " + this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.n
 * JD-Core Version:    0.6.2
 */