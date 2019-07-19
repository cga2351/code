package com.viber.voip.ads.b.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.ListAdapter;
import com.appnexus.opensdk.mediatednativead.AdMobNativeSettings;
import com.viber.jni.cdr.CdrConst.AdTypes;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.a.a.y.a;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.b.c.b.a;
import com.viber.voip.ads.b.c.c.a.a;
import com.viber.voip.ads.s;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo.Item;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.util.cj;
import com.viber.voip.util.d.b;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class f extends com.viber.voip.ads.b.c.c<com.viber.voip.ads.b.c.c.c>
  implements com.viber.voip.ads.b.c.b.a.d, e, d.b
{
  private static final com.viber.common.a.e i = ViberEnv.getLogger();
  private final com.viber.voip.util.i.c A;
  private final com.viber.voip.analytics.story.g.a B;
  private final Handler C;
  private final com.viber.voip.i.f D;
  private long E;
  protected final cj h;
  private final ICdrController j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private s p;
  private Map<String, List<Integer>> q;
  private com.viber.voip.ads.h r;
  private PhoneController s;
  private Context t;
  private com.viber.voip.ads.b.c.b.a.c u;
  private final Set<b> v = new HashSet();
  private final Set<c> w = new CopyOnWriteArraySet();
  private final String x;
  private final com.viber.common.permission.c y;
  private final com.viber.voip.messages.extras.b.a z;

  f(Context paramContext, com.viber.voip.ads.b.b.b.c paramc, c.a parama, com.viber.voip.i.f paramf1, com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama1, Handler paramHandler1, Handler paramHandler2, PhoneController paramPhoneController, ICdrController paramICdrController, com.viber.voip.ads.b.c.c.a.a<com.viber.voip.ads.b.c.c.c> parama2, String paramString, cj paramcj, com.viber.common.permission.c paramc1, com.viber.voip.messages.extras.b.a parama3, com.viber.voip.util.i.c paramc2, com.viber.voip.analytics.story.g.a parama4, com.viber.voip.i.f paramf2, s params, com.viber.voip.ads.h paramh)
  {
    super(paramc, parama, paramf1, parama1, paramHandler2, parama2);
    this.h = paramcj;
    this.j = paramICdrController;
    this.x = paramString;
    this.y = paramc1;
    this.z = parama3;
    this.A = paramc2;
    this.B = parama4;
    this.D = paramf2;
    com.viber.voip.util.d.b(this, paramHandler1);
    this.q = new HashMap();
    this.p = params;
    this.C = paramHandler1;
    this.t = paramContext;
    this.r = paramh;
    this.r.a(1);
    this.s = paramPhoneController;
    AdMobNativeSettings.setEnableAppInstallAd(true);
    AdMobNativeSettings.setEnableContentAd(true);
  }

  private void a(int paramInt)
  {
    long l1 = this.s.generateSequence();
    this.j.handleReportAdsDisplay(l1, "", 1, 0, "", 1, paramInt, 1, "", "", "", g());
  }

  private void a(com.viber.voip.ads.b.b.b.a parama, int paramInt1, int paramInt2)
  {
    long l1 = this.s.generateSequence();
    String str1 = parama.f();
    int i1 = parama.z();
    String str2 = parama.j();
    int i2 = CdrConst.AdTypes.fromAdType(parama.g());
    int i3 = parama.a();
    String str3 = parama.h();
    String str4 = parama.y();
    String str5 = this.x;
    int i4 = g();
    this.j.handleReportAdsClick(l1, paramInt1, str1, i1, paramInt2, str2, i2, i3, str3, str4, str5, i4);
  }

  private void b(com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> parama)
  {
    if (parama == null)
      return;
    com.viber.voip.ads.b.b.b.a locala = b();
    if (locala != null)
    {
      parama.a((com.viber.voip.ads.b.c.c.a)this.f.a(locala));
      return;
    }
    parama.a();
  }

  private void b(String paramString, int paramInt)
  {
    List localList = (List)this.q.get(paramString);
    if (localList == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(paramInt));
      this.q.put(paramString, localArrayList);
      return;
    }
    localList.add(Integer.valueOf(paramInt));
  }

  private boolean c(b.a parama, com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> parama1)
  {
    boolean bool = true;
    if (this.b.a(this.a) == 0)
    {
      b(parama1);
      bool = false;
    }
    do
    {
      return bool;
      if (this.k)
      {
        b(parama1);
        return false;
      }
      if (this.l)
      {
        b(parama1);
        return false;
      }
      com.viber.voip.ads.b.b.b.a locala = b();
      if (locala != null)
      {
        if (!locala.b())
        {
          if (parama1 != null)
            parama1.a((com.viber.voip.ads.b.c.c.a)this.f.a(locala));
          return false;
        }
        if (this.o)
        {
          c();
          return bool;
        }
        if (parama1 != null)
          parama1.a((com.viber.voip.ads.b.c.c.a)this.f.a(locala));
        return false;
      }
    }
    while (b(parama, parama1));
    return false;
  }

  private void d(com.viber.voip.ads.b.b.b.a parama, int paramInt)
  {
    long l1 = this.s.generateSequence();
    String str1 = parama.f();
    int i1 = parama.z();
    String str2 = parama.j();
    int i2 = CdrConst.AdTypes.fromAdType(parama.g());
    int i3 = parama.a();
    String str3 = parama.h();
    String str4 = parama.y();
    String str5 = this.x;
    int i4 = g();
    this.j.handleReportAdsDisplay(l1, str1, i1, paramInt, str2, i2, 0, i3, str3, str4, str5, i4);
  }

  private boolean n()
  {
    com.viber.voip.ads.b.b.b.a locala = b();
    if ((locala != null) && (locala.b()));
    for (int i1 = 1; (this.D.e()) && (!this.m) && (i1 == 0); i1 = 0)
      return true;
    return false;
  }

  private void o()
  {
    String str1 = this.h.d();
    long l1 = Math.round((this.A.a() - this.E) / 1000.0D);
    String str2 = "";
    com.viber.voip.ads.b.b.b.a locala = b();
    if (locala != null)
      str2 = locala.h();
    this.B.a(this.a.a(), l1, str1, str2, this.n);
  }

  private void p()
  {
    this.o = false;
  }

  private void q()
  {
    boolean bool = true;
    if (n())
    {
      if (b() != null);
      this.o = bool;
      this.k = false;
      this.l = false;
      this.m = false;
      if (b() == null)
        break label91;
    }
    while (true)
    {
      this.n = bool;
      Iterator localIterator = this.w.iterator();
      while (localIterator.hasNext())
        ((c)localIterator.next()).N_();
      c();
      break;
      label91: bool = false;
    }
  }

  private void r()
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).z_();
  }

  private void s()
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).b();
  }

  private void t()
  {
    com.viber.voip.ads.b.b.b.a locala = b();
    v();
    if (locala != null)
      u().a(locala.c());
  }

  private s u()
  {
    return this.p;
  }

  private void v()
  {
    this.q.clear();
  }

  protected com.viber.voip.ads.b.b.a.c a(com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> parama)
  {
    return new a(this, parama, this.C, this.e);
  }

  protected com.viber.voip.ads.b.c.b.a.c a(RecyclerView paramRecyclerView, RecyclerView.Adapter paramAdapter)
  {
    return null;
  }

  protected com.viber.voip.ads.b.c.b.a.c a(ViberListView paramViberListView, ListAdapter paramListAdapter)
  {
    return new com.viber.voip.ads.b.c.b.a.b(this, paramViberListView, paramListAdapter);
  }

  public void a(com.viber.voip.ads.b.b.b.a parama, int paramInt)
  {
    if (!a(parama.f(), 2))
    {
      u().a(parama.d());
      b(parama.f(), 2);
      a(parama, 1, paramInt);
    }
  }

  public void a(b.a parama, com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> parama1)
  {
    if (!c(parama, parama1))
      return;
    super.a(parama, parama1);
  }

  public void a(b paramb)
  {
    this.v.add(paramb);
  }

  public void a(c paramc)
  {
    this.w.add(paramc);
  }

  protected boolean a()
  {
    com.viber.voip.ads.b.b.b.a locala = b();
    if (locala == null);
    while (locala.b())
      return false;
    return true;
  }

  protected boolean a(com.viber.voip.ads.b.b.b.b paramb, com.viber.voip.ads.b.b.a.c paramc)
  {
    com.viber.voip.ads.h localh;
    int i1;
    int i2;
    String str1;
    int i3;
    if ((paramb.c() == 2) || (paramb.c() == 5))
    {
      localh = this.r;
      i1 = paramb.a();
      i2 = g();
      str1 = paramb.b();
      i3 = paramb.d();
      if (paramb.c() != 5)
        break label76;
    }
    label76: for (String str2 = this.x; ; str2 = "")
    {
      localh.a(i1, i2, str1, i3, str2, 0);
      return false;
    }
  }

  public boolean a(String paramString, int paramInt)
  {
    return (this.q.containsKey(paramString)) && (((List)this.q.get(paramString)).contains(Integer.valueOf(paramInt)));
  }

  public void b(RecyclerView paramRecyclerView, RecyclerView.Adapter paramAdapter)
  {
    if (this.u != null)
      this.u.h();
    this.u = a(paramRecyclerView, paramAdapter);
  }

  public void b(com.viber.voip.ads.b.b.b.a parama, int paramInt)
  {
    c();
    this.k = true;
    a(parama, 2, paramInt);
    r();
  }

  public void b(b paramb)
  {
    this.v.remove(paramb);
  }

  public void b(c paramc)
  {
    this.w.remove(paramc);
  }

  public void b(ViberListView paramViberListView, ListAdapter paramListAdapter)
  {
    if (this.u != null)
      this.u.h();
    this.u = a(paramViberListView, paramListAdapter);
  }

  protected boolean b(com.viber.voip.ads.b.b.b.a parama)
  {
    if ((parama instanceof com.viber.voip.ads.b.a.b.a.a))
    {
      v();
      bool2 = ((com.viber.voip.ads.b.a.b.a.a)parama).n();
      i5 = parama.a();
      if ((i5 == 5) && (!bool2))
      {
        i6 = 1;
        localh2 = this.r;
        i7 = g();
        str3 = parama.y();
        if (i5 != 5)
          break label102;
        str4 = this.x;
        if (i6 == 0)
          break label109;
        i8 = 2;
        localh2.a(0, i7, str3, i5, str4, i8);
      }
    }
    label102: label109: 
    while (!(parama instanceof com.viber.voip.ads.b.a.b.a.b))
      while (true)
      {
        boolean bool2;
        int i5;
        com.viber.voip.ads.h localh2;
        int i7;
        String str3;
        return false;
        int i6 = 0;
        continue;
        String str4 = "";
        continue;
        int i8 = 0;
      }
    v();
    boolean bool1 = ((com.viber.voip.ads.b.a.b.a.b)parama).n();
    int i1 = parama.a();
    int i2;
    com.viber.voip.ads.h localh1;
    int i3;
    String str1;
    String str2;
    if ((i1 == 5) && (!bool1))
    {
      i2 = 1;
      localh1 = this.r;
      i3 = g();
      str1 = parama.y();
      if (i1 != 5)
        break label211;
      str2 = this.x;
      label180: if (i2 == 0)
        break label218;
    }
    label211: label218: for (int i4 = 2; ; i4 = 0)
    {
      localh1.a(0, i3, str1, i1, str2, i4);
      return false;
      i2 = 0;
      break;
      str2 = "";
      break label180;
    }
  }

  protected boolean b(b.a parama, com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> parama1)
  {
    boolean bool = true;
    if (!this.h.b())
    {
      this.l = bool;
      b(parama1);
      bool = false;
    }
    return bool;
  }

  public void c(com.viber.voip.ads.b.b.b.a parama, int paramInt)
  {
    if (!a(parama.f(), 1))
    {
      b(parama.f(), 1);
      d(parama, paramInt);
      u().a(parama.e());
    }
  }

  protected void f()
  {
    this.E = this.A.a();
  }

  protected abstract int g();

  protected Location h()
  {
    boolean bool = this.y.a(new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
    Location localLocation = null;
    if (bool)
      localLocation = this.z.b(0);
    return localLocation;
  }

  protected void i()
  {
    String str = this.h.d();
    long l1 = Math.round((this.A.a() - this.E) / 1000.0D);
    this.B.a(this.a.a(), l1, str);
  }

  public boolean j()
  {
    return this.k;
  }

  public void k()
  {
    if (this.u != null)
      this.u.g();
  }

  public void l()
  {
    if (this.u != null)
      this.u.i();
  }

  public void m()
  {
    if (this.u != null)
    {
      this.u.h();
      this.u = null;
    }
  }

  public void onAppStopped()
  {
    q();
  }

  public void onBackground()
  {
    com.viber.voip.util.i.a(this);
  }

  public void onForeground()
  {
    com.viber.voip.util.i.b(this);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
      p();
  }

  @SuppressLint({"WrongConstant"})
  public void p_()
  {
    com.viber.voip.ads.b.b.b.a locala = b();
    if (locala != null)
    {
      new OpenUrlAction(dx.a(this.t, locala.c(), locala.f(), locala.i(), locala.h(), locala.y(), g()).toString()).execute(this.t, null);
      c();
      s();
    }
  }

  private static class a
    implements com.viber.voip.ads.b.b.a.c
  {
    private WeakReference<f> a;
    private WeakReference<com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c>> b;
    private com.viber.voip.ads.b.c.c.c c;
    private final Handler d;
    private final Handler e;

    a(f paramf, com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> parama, Handler paramHandler1, Handler paramHandler2)
    {
      this.a = new WeakReference(paramf);
      this.b = new WeakReference(parama);
      this.d = paramHandler1;
      this.e = paramHandler2;
    }

    private void a(com.viber.voip.ads.b.b.b.a parama, y.a parama1, PublicAccountsAdsMetaInfo paramPublicAccountsAdsMetaInfo)
    {
      f localf = (f)this.a.get();
      com.viber.voip.ads.b.c.a locala = (com.viber.voip.ads.b.c.a)this.b.get();
      if (locala == null);
      while (localf == null)
        return;
      if (!da.a(parama1.a))
      {
        if (paramPublicAccountsAdsMetaInfo != null)
          try
          {
            if ((paramPublicAccountsAdsMetaInfo.items != null) && (paramPublicAccountsAdsMetaInfo.items.length > 0))
            {
              PublicAccountsAdsMetaInfo.Item localItem = paramPublicAccountsAdsMetaInfo.items[0];
              if (!da.a(localItem.imageUrl))
              {
                String str1 = com.viber.voip.util.e.e.a(Uri.parse(localItem.imageUrl));
                String str2 = localItem.title;
                String str3 = localItem.text;
                if ((!da.a(str1)) && (!da.a(str2)) && (!da.a(str3)))
                {
                  this.d.post(new h(locala, localf, parama));
                  f.e(localf);
                  f.a(localf, true);
                  f.d(localf);
                  return;
                }
              }
            }
          }
          catch (Exception localException)
          {
            f.a(localf, 3);
          }
        while (true)
        {
          f.b(localf, true);
          Handler localHandler = this.d;
          locala.getClass();
          localHandler.post(i.a(locala));
          return;
          paramPublicAccountsAdsMetaInfo = com.viber.voip.banner.e.a.d(parama1.a);
          break;
          f.a(localf, 1);
        }
      }
      if (parama1.b == 1);
      for (int i = 2; ; i = 4)
      {
        f.a(localf, i);
        break;
      }
    }

    public void a()
    {
    }

    public void a(com.viber.voip.ads.b.b.b.a parama)
    {
      f localf = (f)this.a.get();
      com.viber.voip.ads.b.c.a locala = (com.viber.voip.ads.b.c.a)this.b.get();
      if (locala == null);
      do
      {
        do
          return;
        while (localf == null);
        if ((parama instanceof com.viber.voip.ads.b.a.b.a.a))
        {
          this.c = ((com.viber.voip.ads.b.c.c.c)f.a(localf).a(parama));
          locala.a(this.c);
          return;
        }
        if ((parama instanceof com.viber.voip.ads.b.a.b.a.b))
        {
          this.c = ((com.viber.voip.ads.b.c.c.c)f.b(localf).a(parama));
          locala.a(this.c);
          return;
        }
        if ((parama instanceof com.viber.voip.ads.b.a.b.c.b))
        {
          com.viber.voip.ads.b.a.b.c.b localb = (com.viber.voip.ads.b.a.b.c.b)parama;
          this.e.post(new g(this, parama, localb));
          return;
        }
      }
      while (!(parama instanceof com.viber.voip.ads.b.a.b.b.a));
      locala.a((com.viber.voip.ads.b.c.c.a)f.c(localf).a(parama));
    }

    public void a(com.viber.voip.ads.b.b.b.b paramb)
    {
      com.viber.voip.ads.b.c.a locala = (com.viber.voip.ads.b.c.a)this.b.get();
      if (locala == null)
        return;
      locala.a();
    }

    public void b()
    {
    }

    public void c()
    {
      if ((this.c != null) && (this.c.l() != null))
        this.c.l().a();
    }

    public void d()
    {
      f localf = (f)this.a.get();
      if (localf == null)
        return;
      f.a(localf, true);
      f.d(localf);
    }
  }

  public static abstract interface b
  {
    public abstract void b();

    public abstract void z_();
  }

  public static abstract interface c
  {
    public abstract void N_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.b.f
 * JD-Core Version:    0.6.2
 */