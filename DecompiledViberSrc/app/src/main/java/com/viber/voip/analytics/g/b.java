package com.viber.voip.analytics.g;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.ArraySet;
import android.support.v4.util.Pair;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.y;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.i.m;
import com.viber.voip.i.n;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bj;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.b;
import com.viber.voip.util.da;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class b extends com.viber.voip.analytics.a
  implements a, h
{
  private final Context c;
  private final j d;
  private f e;
  private com.viber.common.b.g f;
  private HashMap<String, g> g;
  private String h;
  private PhoneController i;
  private f j;
  private f k;
  private final f l;
  private final a m;
  private final g n;
  private final Handler o;
  private final ArraySet<h.a> p = new ArraySet();
  private cj.b q = new cj.b()
  {
    public void backgroundDataChanged(boolean paramAnonymousBoolean)
    {
    }

    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != -1) && (!da.a(b.c(b.this).a())))
        b.d(b.this);
    }

    public void wifiConnectivityChanged()
    {
    }
  };

  public b(Context paramContext, com.viber.common.b.g paramg, y paramy, com.viber.voip.messages.extras.b.a parama, com.viber.common.permission.c paramc, Handler paramHandler, PhoneController paramPhoneController)
  {
    super(paramy);
    this.d = new j(parama, paramc, UserManager.from(paramContext));
    this.f = paramg;
    this.c = paramContext.getApplicationContext();
    this.g = new HashMap();
    this.n = new g();
    this.o = paramHandler;
    this.i = paramPhoneController;
    this.e = new f("appNexus", "");
    this.j = new f("viberNewsSony", "");
    this.k = new f("viberNewsZen", "");
    this.l = new f("MixpanelProxy", "");
    m();
    n();
    this.m = new a(a.a.i.a(), "Original");
    this.g.put("MoreScreenProductsOrder", this.m);
    cj.a(this.c).a(this.q);
  }

  private File a(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "wasabi_cache.json");
  }

  private void a(g.b paramb)
  {
    g localg = (g)this.g.get(paramb.b);
    if (localg != null)
    {
      localg.c(paramb);
      localg.b();
    }
  }

  private boolean a(com.viber.voip.analytics.story.e parame, String paramString)
  {
    Map.Entry localEntry = parame.b(h.class, "wasabi_experiments_key");
    if ((localEntry == null) || (localEntry.getValue() == null))
      return false;
    a.a[] arrayOfa = (a.a[])localEntry.getValue();
    int i1 = arrayOfa.length;
    int i2 = 0;
    if (i2 < i1)
    {
      a.a locala = arrayOfa[i2];
      if (!((g)this.g.get(locala.a())).d());
      while (true)
      {
        i2++;
        break;
        this.o.post(new c(this, locala, paramString));
      }
    }
    return true;
  }

  private g.c e(boolean paramBoolean)
  {
    File localFile = a(this.c);
    String str;
    if (paramBoolean)
      str = p();
    while (str == null)
    {
      return null;
      try
      {
        str = this.n.a(this.d.b(), this.d.c());
        if (str != null)
        {
          FileWriter localFileWriter = new FileWriter(localFile);
          localFileWriter.write(str);
          localFileWriter.close();
          if ((!da.a(str)) && (!da.a(str, this.h)))
            this.i.handleUpdateClientConfiguration(str);
        }
      }
      catch (Exception localException)
      {
        return null;
      }
    }
    this.h = str;
    return this.n.a(str);
  }

  private void m()
  {
    a.b[] arrayOfb = a.b.values();
    int i1 = arrayOfb.length;
    int i2 = 0;
    if (i2 < i1)
    {
      a.b localb = arrayOfb[i2];
      if (localb.b())
        new c(localb.a(), localb.c());
      while (true)
      {
        i2++;
        break;
        new b(localb.a());
      }
    }
  }

  private void n()
  {
    for (a.a locala : a_)
      this.g.put(locala.a(), new f(locala.a(), ""));
  }

  private void o()
  {
    av.a(av.e.g).post(f.a);
  }

  private String p()
  {
    File localFile = a(this.c);
    try
    {
      if (!localFile.exists())
        return null;
      String str = bj.a(new FileInputStream(localFile));
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String a(a.a parama, boolean paramBoolean)
  {
    g localg = (g)this.g.get(parama.a());
    if (paramBoolean)
      this.o.post(new d(this, parama));
    if ((localg instanceof f))
      return (String)((f)localg).b();
    if ((localg instanceof a))
      return (String)((a)localg).b();
    return "";
  }

  public void a(h.a parama)
  {
    synchronized (this.p)
    {
      this.p.add(parama);
      return;
    }
  }

  public boolean a(a.a parama)
  {
    return (this.g.get(parama.a()) != null) && (((g)this.g.get(parama.a())).d());
  }

  public boolean a(a.a parama, String paramString)
  {
    try
    {
      String str = this.n.a(parama, paramString, this.d.b());
      boolean bool = false;
      if (str != null)
        bool = true;
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean a(a.b paramb)
  {
    return ((g)this.g.get(paramb.a())).d();
  }

  protected void b(String paramString)
  {
    this.d.a(paramString);
  }

  public void b(boolean paramBoolean)
  {
    g.c localc;
    try
    {
      localc = e(paramBoolean);
      if (localc == null)
        break label342;
      synchronized (this.p)
      {
        Iterator localIterator1 = this.p.iterator();
        if (localIterator1.hasNext())
          ((h.a)localIterator1.next()).a(paramBoolean);
      }
    }
    finally
    {
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.g.keySet());
    int i3;
    for (int i1 = 0; ; i1++)
    {
      int i2 = localc.a.size();
      i3 = 0;
      if (i1 >= i2)
        break;
      g.d locald = (g.d)localc.a.get(i1);
      a(locald);
      localHashSet.remove(locald.b);
    }
    while (i3 < localc.b.size())
    {
      g.a locala = (g.a)localc.b.get(i3);
      a(locala);
      localHashSet.remove(locala.b);
      i3++;
    }
    Iterator localIterator2 = localHashSet.iterator();
    while (localIterator2.hasNext())
    {
      String str = (String)localIterator2.next();
      g localg = (g)this.g.get(str);
      localg.c();
      localg.b();
    }
    while (true)
    {
      m.p();
      n.p();
      synchronized (this.p)
      {
        Iterator localIterator3 = this.p.iterator();
        if (localIterator3.hasNext())
          ((h.a)localIterator3.next()).b(paramBoolean);
      }
      label342: return;
      if (paramBoolean);
    }
  }

  public boolean b(a.b paramb)
  {
    g localg = (g)this.g.get(paramb.a());
    if ((localg instanceof d))
      return ((d)localg).a();
    return false;
  }

  public void c(boolean paramBoolean)
  {
    av.a(av.e.g).post(new e(this, paramBoolean));
  }

  protected boolean c(com.viber.voip.analytics.story.e parame)
  {
    Map.Entry localEntry = parame.a(h.class);
    if ((localEntry == null) || (!(localEntry.getValue() instanceof CharSequence)) || (da.a((CharSequence)localEntry.getValue())))
      return false;
    return a(parame, (String)localEntry.getValue());
  }

  protected boolean c(com.viber.voip.analytics.story.j paramj)
  {
    return false;
  }

  protected void d(com.viber.voip.analytics.story.e parame)
  {
    Map.Entry localEntry = parame.b(h.class, "key_property_product_id");
    if ((localEntry == null) || (!(localEntry.getValue() instanceof CharSequence)) || (da.a((CharSequence)localEntry.getValue())))
      return;
    a(parame, (String)localEntry.getValue());
  }

  protected void e()
  {
  }

  public String g()
  {
    return (String)this.e.b();
  }

  public String h()
  {
    if (this.h == null)
      this.h = p();
    return this.h;
  }

  public String i()
  {
    if (com.viber.common.d.a.g())
      return (String)this.j.b();
    return "";
  }

  public String j()
  {
    if (com.viber.common.d.a.g())
      return (String)this.k.b();
    return "";
  }

  public String k()
  {
    return (String)this.l.b();
  }

  protected void q_()
  {
    o();
  }

  public void r_()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
      ((g)localIterator.next()).c();
  }

  private class a extends b.g<String>
  {
    public a(String paramString1, String arg3)
    {
      super(paramString1, localObject);
    }

    protected String a(com.viber.common.b.g paramg, String paramString)
    {
      return paramg.a(paramString, null);
    }

    protected String a(g.b paramb)
    {
      return paramb.c;
    }

    protected void a(String paramString1, com.viber.common.b.g paramg, String paramString2)
    {
      paramg.b(paramString2, paramString1);
    }
  }

  private class b extends b.g<Boolean>
    implements b.d
  {
    public b(String arg2)
    {
      super(str, Boolean.valueOf(false));
    }

    protected Boolean a(com.viber.common.b.g paramg, String paramString)
    {
      return Boolean.valueOf(paramg.a(paramString, false));
    }

    protected Boolean a(g.b paramb)
    {
      return Boolean.valueOf(paramb.a());
    }

    protected void a(Boolean paramBoolean, com.viber.common.b.g paramg, String paramString)
    {
      paramg.b(paramString, paramBoolean.booleanValue());
    }

    public boolean a()
    {
      return ((Boolean)b()).booleanValue();
    }
  }

  private class c extends b.g<Pair<Boolean, String>>
    implements b.e
  {
    private String e;

    public c(String paramString1, String arg3)
    {
      super(paramString1, new Pair(Boolean.valueOf(false), ""));
      Object localObject;
      this.e = localObject;
    }

    protected Pair<Boolean, String> a(com.viber.common.b.g paramg, String paramString)
    {
      boolean bool = paramg.a(paramString, false);
      String str = paramg.a(this.e, "");
      return new Pair(Boolean.valueOf(bool), str);
    }

    protected Pair<Boolean, String> a(g.b paramb)
    {
      return new Pair(Boolean.valueOf(paramb.a()), paramb.d);
    }

    protected void a(Pair<Boolean, String> paramPair, com.viber.common.b.g paramg, String paramString)
    {
      paramg.b(paramString, ((Boolean)paramPair.first).booleanValue());
      paramg.b(this.e, (String)paramPair.second);
    }

    public boolean a()
    {
      return ((Boolean)((Pair)b()).first).booleanValue();
    }

    protected void c(com.viber.common.b.g paramg, String paramString)
    {
      paramg.b(paramString);
      paramg.b(this.e);
    }

    protected boolean d(com.viber.common.b.g paramg, String paramString)
    {
      return (paramg.a(paramString)) && (paramg.a(this.e));
    }
  }

  private static abstract interface d
  {
    public abstract boolean a();
  }

  private static abstract interface e extends b.d
  {
  }

  private class f extends b.g<String>
  {
    public f(String paramString1, String arg3)
    {
      super(paramString1, localObject);
    }

    protected String a(com.viber.common.b.g paramg, String paramString)
    {
      return paramg.a(paramString, null);
    }

    protected String a(g.b paramb)
    {
      if ((paramb.d == null) && ((paramb instanceof g.a)))
      {
        if (paramb.a())
          return (String)this.c;
        return null;
      }
      return paramb.d;
    }

    protected void a(String paramString1, com.viber.common.b.g paramg, String paramString2)
    {
      paramg.b(paramString2, paramString1);
    }
  }

  public abstract class g<T>
  {
    private volatile T a;
    public final String b;
    public final T c;

    public g(T arg2)
    {
      Object localObject1;
      this.b = localObject1;
      Object localObject2;
      this.c = localObject2;
      b.a(b.this).put(localObject1, this);
    }

    private String a()
    {
      return "wasabi_cache_" + this.b;
    }

    protected abstract void a(T paramT, com.viber.common.b.g paramg, String paramString);

    public T b()
    {
      Object localObject = this.a;
      if (localObject == null)
      {
        localObject = b(b.b(b.this), a());
        if (localObject == null)
          localObject = this.c;
        this.a = localObject;
      }
      return localObject;
    }

    protected abstract T b(com.viber.common.b.g paramg, String paramString);

    protected abstract T b(g.b paramb);

    public void c()
    {
      c(b.b(b.this), a());
      this.a = this.c;
    }

    protected void c(com.viber.common.b.g paramg, String paramString)
    {
      paramg.b(paramString);
    }

    public void c(g.b paramb)
    {
      Object localObject = b(paramb);
      String str = a();
      if (localObject == null)
        c(b.b(b.this), str);
      while (true)
      {
        if (localObject == null)
          localObject = this.c;
        this.a = localObject;
        return;
        a(localObject, b.b(b.this), str);
      }
    }

    public boolean d()
    {
      return d(b.b(b.this), a());
    }

    protected boolean d(com.viber.common.b.g paramg, String paramString)
    {
      return paramg.a(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.g.b
 * JD-Core Version:    0.6.2
 */