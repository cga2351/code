package com.viber.voip.analytics;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import com.google.firebase.messaging.RemoteMessage;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.desktop.HasDesktopDelegate;
import com.viber.jni.desktop.HasDesktopListener;
import com.viber.jni.remoteconfig.RemoteConfigDelegate;
import com.viber.jni.remoteconfig.RemoteConfigListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g.a.a;
import com.viber.voip.analytics.g.a.b;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.i.c.c;
import com.viber.voip.i.c.j;
import com.viber.voip.i.c.m;
import com.viber.voip.i.f.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.p;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.d.b;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile g b;
  private d.b A;
  private com.viber.voip.analytics.e.b c;
  private com.viber.voip.analytics.a.a d;
  private com.viber.voip.analytics.b.a e;
  private com.viber.voip.analytics.g.a f;
  private com.viber.voip.analytics.g.h g;
  private com.viber.voip.analytics.f.d h;
  private com.viber.voip.analytics.c.b i;
  private final com.viber.voip.analytics.e.e j;
  private final Set<p> k = new HashSet(5);
  private final Set<w> l = new HashSet(3);
  private final Map<String, Object> m = new ArrayMap(20);
  private com.viber.voip.analytics.d.c n;
  private boolean o;
  private c p;
  private com.viber.voip.analytics.e.f q;
  private Handler r;
  private d s;
  private com.viber.voip.analytics.story.o t;
  private long u;
  private PhoneController v;
  private final SharedPreferences.OnSharedPreferenceChangeListener w;
  private SharedPreferences.OnSharedPreferenceChangeListener x;
  private final SharedPreferences.OnSharedPreferenceChangeListener y;
  private f.a z;

  private g()
  {
    com.viber.common.b.a[] arrayOfa1 = new com.viber.common.b.a[1];
    arrayOfa1[0] = d.f.c;
    this.w = new d.al(arrayOfa1)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        g.a(g.this);
      }
    };
    com.viber.common.b.a[] arrayOfa2 = new com.viber.common.b.a[1];
    arrayOfa2[0] = d.bf.b;
    this.x = new d.al(arrayOfa2)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        g.this.a(com.viber.voip.analytics.story.g.j(d.bf.b.d()));
      }
    };
    com.viber.common.b.a[] arrayOfa3 = new com.viber.common.b.a[1];
    arrayOfa3[0] = d.p.v;
    this.y = new d.al(arrayOfa3)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        com.viber.voip.analytics.story.k.b();
      }
    };
    this.z = new h(this);
    this.A = new d.b()
    {
      public void onAppStopped()
      {
        com.viber.voip.util.i.c(this);
      }

      public void onBackground()
      {
        com.viber.voip.util.i.a(this);
      }

      public void onForeground()
      {
        g.this.a(com.viber.voip.analytics.story.l.b.a());
      }

      public void onForegroundStateChanged(boolean paramAnonymousBoolean)
      {
        com.viber.voip.util.i.a(this, paramAnonymousBoolean);
      }
    };
    com.viber.voip.e.a.e.b().a("APP START", "AnalyticsManager init");
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    this.v = localViberApplication.getEngine(false).getPhoneController();
    this.i = new com.viber.voip.analytics.c.b();
    this.t = new com.viber.voip.analytics.story.o(this, true);
    this.j = new com.viber.voip.analytics.e.e(d.f.s);
    this.r = av.a(av.e.g);
    com.viber.common.b.g localg = com.viber.common.b.j.b();
    l();
    RemoteConfigListener localRemoteConfigListener = ViberApplication.getInstance().getEngine(false).getDelegatesManager().getRemoteConfigListener();
    UserManager localUserManager = localViberApplication.getUserManager();
    a(localUserManager);
    this.s = new d(localUserManager, localRemoteConfigListener);
    this.s.a();
    this.p = new c(localUserManager, localRemoteConfigListener);
    this.p.a();
    com.viber.voip.e.a.e.b().a("APP START", "AnalyticsManager initAppBoyAnalytics");
    a(localApplication, localUserManager, localRemoteConfigListener);
    com.viber.voip.e.a.e.b().b("APP START", "AnalyticsManager initAppBoyAnalytics");
    com.viber.voip.e.a.e.b().a("APP START", "AnalyticsManager initWasabi");
    a(localApplication, localg, localViberApplication.getLocationManager(), com.viber.common.permission.c.a(localApplication), localUserManager, localRemoteConfigListener);
    this.q = new com.viber.voip.analytics.e.f(this.f.k(), d.f.u);
    com.viber.voip.e.a.e.b().b("APP START", "AnalyticsManager initWasabi");
    com.viber.voip.e.a.e.b().b("APP START", "AnalyticsManager initAppBoyAnalytics");
    av.a(av.e.b).postDelayed(new i(this, localViberApplication, localApplication, localUserManager), 5000L);
    com.viber.voip.e.a.e.b().b("APP START", "AnalyticsManager init");
    o();
    this.u = System.currentTimeMillis();
  }

  public static g a()
  {
    if ((b == null) && (com.viber.voip.o.a.a() == com.viber.voip.o.a.a));
    try
    {
      if ((b == null) && (com.viber.voip.o.a.a() == com.viber.voip.o.a.a))
        b = new g();
      return b;
    }
    finally
    {
    }
  }

  private void a(Application paramApplication, UserManager paramUserManager, RemoteConfigListener paramRemoteConfigListener)
  {
    com.viber.voip.analytics.b.a locala = this.e;
    y localy = new y();
    if ((locala instanceof r))
      localy = new y(((r)locala).c());
    this.e = new com.viber.voip.analytics.b.c(paramApplication, localy, com.viber.voip.h.a.b(), new com.viber.voip.g.b.b()
    {
      protected ab a()
      {
        return ab.b();
      }
    }
    , this.j);
    a(this.e);
    a(new b(paramUserManager, paramRemoteConfigListener));
  }

  private void a(Context paramContext)
  {
    com.viber.voip.analytics.e.b localb = this.c;
    y localy1 = new y();
    if ((localb instanceof com.viber.voip.analytics.e.a));
    for (y localy2 = new y(((com.viber.voip.analytics.e.a)localb).c()); ; localy2 = localy1)
    {
      this.c = new com.viber.voip.analytics.e.c(paramContext, localy2, this.j, new com.viber.voip.analytics.e.d(k()));
      a(this.p);
      return;
    }
  }

  private void a(Context paramContext, com.viber.common.b.g paramg, com.viber.voip.messages.extras.b.a parama, com.viber.common.permission.c paramc, UserManager paramUserManager, RemoteConfigListener paramRemoteConfigListener)
  {
    com.viber.voip.analytics.g.b localb = new com.viber.voip.analytics.g.b(paramContext, paramg, new y(), parama, paramc, av.e.f.a(), this.v);
    this.f = localb;
    this.g = localb;
    a(new e(paramUserManager, paramRemoteConfigListener));
  }

  private void a(ViberApplication paramViberApplication, Context paramContext, UserManager paramUserManager)
  {
    try
    {
      if (!this.o)
      {
        a(paramContext);
        b(paramContext);
        b(paramViberApplication, paramContext, paramUserManager);
        m();
        this.o = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(final com.viber.voip.analytics.a.h paramh)
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        g.b(g.this).a(paramh);
      }
    });
  }

  private void a(a parama)
  {
    p localp = parama.e();
    if ((parama.b() != null) && (!da.a(parama.d())))
    {
      if (!parama.b().booleanValue())
        break label63;
      localp.a(parama.d());
    }
    synchronized (this.k)
    {
      this.k.add(localp);
      return;
      label63: localp.a();
    }
  }

  private void a(w paramw)
  {
    b(paramw);
    synchronized (this.l)
    {
      this.l.add(paramw);
      return;
    }
  }

  private void a(UserManager paramUserManager)
  {
    j localj = new j(this);
    ViberApplication.getInstance().getEngine(false).getDelegatesManager().getHasDesktopListener().registerDelegate(new HasDesktopDelegate[] { localj });
    com.viber.voip.util.d.c(this.A);
    com.viber.voip.settings.d.a(this.w);
    com.viber.voip.settings.d.a(this.x);
    com.viber.voip.settings.d.a(this.y);
    this.n = new com.viber.voip.analytics.d.d(c().c(), paramUserManager.getUserData(), false);
  }

  private void b(Context paramContext)
  {
    com.viber.voip.analytics.f.d locald = this.h;
    y localy1 = new y();
    if ((locald instanceof r));
    for (y localy2 = new y(((r)locald).c()); ; localy2 = localy1)
    {
      this.h = new com.viber.voip.analytics.f.e(paramContext, localy2);
      a(this.s);
      return;
    }
  }

  private void b(ViberApplication paramViberApplication, Context paramContext, UserManager paramUserManager)
  {
    boolean bool = this.d instanceof com.viber.voip.analytics.a.k;
    List localList = null;
    if (bool)
      localList = ((com.viber.voip.analytics.a.k)this.d).c();
    this.d = new com.viber.voip.analytics.a.b(paramContext, k.a, com.viber.voip.h.a.b(), paramViberApplication.getEngine(false).getExchanger());
    a(this.d);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Uri localUri = (Uri)localIterator.next();
        this.d.a(localUri);
      }
    }
  }

  private void b(w paramw)
  {
    boolean bool = d.f.c.d();
    if (paramw.f())
      if ((!bool) && (!c.j.b.e()))
        break label39;
    label39: for (bool = true; ; bool = false)
    {
      paramw.a(bool);
      return;
    }
  }

  private void c(final com.viber.voip.analytics.story.e parame)
  {
    this.r.post(new Runnable()
    {
      public void run()
      {
        if (parame.c().isEmpty())
          ViberApplication.getInstance().logToCrashlytics(new IllegalArgumentException("No trackers are assigned to event " + parame.getClass().getSimpleName()));
        while (true)
        {
          return;
          Iterator localIterator = parame.c().iterator();
          while (localIterator.hasNext())
          {
            Class localClass = (Class)localIterator.next();
            ((p)g.this.a(localClass)).a(parame);
          }
        }
      }
    });
  }

  @Deprecated
  private boolean c(String paramString)
  {
    boolean bool1 = da.a(paramString);
    boolean bool2 = false;
    if (!bool1);
    try
    {
      String str = new JSONObject(paramString).getString("adType");
      if (!str.equalsIgnoreCase("banner"))
      {
        boolean bool3 = str.equalsIgnoreCase("native");
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      return bool2;
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }

  private void l()
  {
    this.c = new com.viber.voip.analytics.e.a(new y(), d.f.b);
    this.d = new com.viber.voip.analytics.a.k();
    this.h = new com.viber.voip.analytics.f.c(new y(), d.f.b);
    this.e = new com.viber.voip.analytics.b.n(new y());
  }

  private void m()
  {
    if (!d.f.h.d())
    {
      d.f.h.a(true);
      if (!dc.a())
        break label47;
    }
    label47: for (String str = "1"; ; str = "0")
    {
      ViberApplication.getInstance().getEngine(false).getCdrController().handleClientTrackingReport(8, str, null);
      return;
    }
  }

  private void n()
  {
    a(com.viber.voip.analytics.story.g.f(Boolean.valueOf(d.f.c.d())));
    synchronized (this.l)
    {
      Iterator localIterator = this.l.iterator();
      if (localIterator.hasNext())
        b((w)localIterator.next());
    }
  }

  private void o()
  {
    c.j.b.a(this.z);
  }

  private String p()
  {
    String str = this.f.g();
    if (c(str))
      return str;
    return "";
  }

  public <T> T a(Class<T> paramClass)
  {
    if (paramClass == com.viber.voip.analytics.e.b.class)
      return paramClass.cast(this.c);
    if (paramClass == com.viber.voip.analytics.a.a.class)
      return paramClass.cast(this.d);
    if (paramClass == com.viber.voip.analytics.b.a.class)
      return paramClass.cast(this.e);
    if (paramClass == com.viber.voip.analytics.f.d.class)
      return paramClass.cast(this.h);
    if (paramClass == com.viber.voip.analytics.c.a.class)
      return paramClass.cast(this.i);
    if (paramClass == com.viber.voip.analytics.g.a.class)
      return paramClass.cast(this.f);
    throw new IllegalArgumentException("Unknown tracker: " + paramClass.getSimpleName());
  }

  public <T> T a(String paramString)
  {
    synchronized (this.m)
    {
      Object localObject2 = this.m.get(paramString);
      return localObject2;
    }
  }

  public String a(a.a parama, boolean paramBoolean)
  {
    return this.f.a(parama, paramBoolean);
  }

  public void a(ArrayMap<com.viber.voip.analytics.story.f, com.viber.voip.analytics.e.g> paramArrayMap)
  {
    this.r.post(new o(this, paramArrayMap));
  }

  public void a(s params)
  {
    if ((params instanceof com.viber.voip.analytics.a.h))
    {
      a((com.viber.voip.analytics.a.h)params);
      return;
    }
    ViberApplication localViberApplication = ViberApplication.getInstance();
    if (params == null);
    for (String str = "Track NULL event"; ; str = "Track unknown event " + params.getClass().getSimpleName())
    {
      localViberApplication.logToCrashlytics(new IllegalArgumentException(str));
      return;
    }
  }

  public void a(com.viber.voip.analytics.story.e parame)
  {
    c(parame);
  }

  public void a(com.viber.voip.analytics.story.j paramj)
  {
    this.r.post(new l(this, paramj));
  }

  public <T> void a(String paramString, com.viber.voip.util.d.b<T, T> paramb)
  {
    synchronized (this.m)
    {
      Object localObject2 = paramb.apply(this.m.get(paramString));
      this.m.put(paramString, localObject2);
      return;
    }
  }

  public void a(String paramString, Object paramObject)
  {
    synchronized (this.m)
    {
      this.m.put(paramString, paramObject);
      return;
    }
  }

  public void a(List<com.viber.voip.analytics.story.j> paramList)
  {
    this.r.post(new m(this, paramList));
  }

  public void a(boolean paramBoolean)
  {
    if ((this.o) && (!paramBoolean))
      synchronized (this.k)
      {
        Iterator localIterator = this.k.iterator();
        if (localIterator.hasNext())
          ((p)localIterator.next()).a();
      }
  }

  public boolean a(RemoteMessage paramRemoteMessage)
  {
    return this.e.c(paramRemoteMessage);
  }

  public boolean a(a.a parama)
  {
    return this.f.a(parama);
  }

  public boolean a(a.a parama, String paramString)
  {
    return this.f.a(parama, paramString);
  }

  public boolean a(a.b paramb)
  {
    return this.f.b(paramb);
  }

  public com.viber.voip.analytics.g.h b()
  {
    return this.g;
  }

  public <T> T b(String paramString)
  {
    synchronized (this.m)
    {
      Object localObject2 = this.m.remove(paramString);
      return localObject2;
    }
  }

  public void b(RemoteMessage paramRemoteMessage)
  {
    this.e.a(paramRemoteMessage);
  }

  public void b(com.viber.voip.analytics.story.e parame)
  {
    if (parame.c().isEmpty())
      ViberApplication.getInstance().logToCrashlytics(new IllegalArgumentException("No trackers are assigned to event " + parame.getClass().getSimpleName()));
    while (true)
    {
      return;
      Iterator localIterator = parame.c().iterator();
      while (localIterator.hasNext())
        ((p)a((Class)localIterator.next())).b(parame);
    }
  }

  public void b(com.viber.voip.analytics.story.j paramj)
  {
    this.r.post(new n(this, paramj));
  }

  public boolean b(a.b paramb)
  {
    return this.f.a(paramb);
  }

  public com.viber.voip.analytics.story.o c()
  {
    return this.t;
  }

  public void d()
  {
    this.f.r_();
  }

  public boolean e()
  {
    return c(p());
  }

  public String f()
  {
    return this.f.i();
  }

  public String g()
  {
    return this.f.j();
  }

  public com.viber.voip.analytics.d.c h()
  {
    return this.n;
  }

  public long i()
  {
    return this.u;
  }

  public String j()
  {
    return this.f.h();
  }

  public com.viber.voip.analytics.e.f k()
  {
    return this.q;
  }

  abstract class a
    implements RemoteConfigDelegate, f.a, Runnable
  {
    protected final Logger a = ViberEnv.getLogger(getClass());
    protected final Handler b;
    final UserManager c;
    private Boolean e;
    private String f;

    a(UserManager paramRemoteConfigListener, RemoteConfigListener arg3)
    {
      this.c = paramRemoteConfigListener;
      this.b = av.a(av.e.b);
      Object localObject;
      localObject.registerDelegate(new Runnable[] { this });
      c.m.a.a(this);
    }

    private boolean a(String paramString)
    {
      return (this.f == null) || (!this.f.equals(paramString));
    }

    protected void a()
    {
      this.b.removeCallbacks(this);
      this.b.postDelayed(this, 300L);
    }

    Boolean b()
    {
      return this.e;
    }

    protected abstract boolean c();

    protected abstract String d();

    protected abstract p e();

    public void onConfigChange(String paramString)
    {
      a();
    }

    public void onFeatureStateChanged(com.viber.voip.i.f paramf)
    {
      a();
    }

    public void run()
    {
      boolean bool1 = c.m.a.e();
      boolean bool2 = c();
      boolean bool3;
      String str;
      if ((!bool1) && (bool2))
      {
        bool3 = true;
        str = d();
        if ((this.e == null) || (this.e.booleanValue() != bool3) || (a(str)))
          break label61;
      }
      label61: p localp;
      do
      {
        do
        {
          return;
          bool3 = false;
          break;
        }
        while (da.a(str));
        this.f = str;
        this.e = Boolean.valueOf(bool3);
        localp = e();
      }
      while (localp == null);
      if (bool3)
      {
        localp.a(this.f);
        return;
      }
      localp.a();
    }
  }

  class b extends g.a
  {
    b(UserManager paramRemoteConfigListener, RemoteConfigListener arg3)
    {
      super(paramRemoteConfigListener, localRemoteConfigListener);
      c.c.b.a(this);
    }

    protected boolean c()
    {
      return (com.viber.common.d.a.a()) && (c.c.b.e());
    }

    protected String d()
    {
      return this.c.getRegistrationValues().t();
    }

    protected p e()
    {
      return g.d(g.this);
    }
  }

  public class c extends g.a
  {
    c(UserManager paramRemoteConfigListener, RemoteConfigListener arg3)
    {
      super(paramRemoteConfigListener, localRemoteConfigListener);
      c.c.a.a(this);
    }

    private boolean a(String paramString)
    {
      return (!ViberApplication.isActivated()) || (da.a(paramString));
    }

    protected boolean c()
    {
      return c.c.a.e();
    }

    protected String d()
    {
      String str = this.c.getRegistrationValues().k();
      if (a(str))
        str = "anonymous_user";
      return str;
    }

    protected p e()
    {
      return g.c(g.this);
    }
  }

  class d extends g.a
  {
    d(UserManager paramRemoteConfigListener, RemoteConfigListener arg3)
    {
      super(paramRemoteConfigListener, localRemoteConfigListener);
      c.c.d.a(this);
    }

    protected boolean c()
    {
      return true;
    }

    protected String d()
    {
      return "non-empty";
    }

    protected p e()
    {
      return g.f(g.this);
    }
  }

  class e extends g.a
  {
    e(UserManager paramRemoteConfigListener, RemoteConfigListener arg3)
    {
      super(paramRemoteConfigListener, localRemoteConfigListener);
      c.c.c.a(this);
    }

    protected boolean c()
    {
      return true;
    }

    protected String d()
    {
      return this.c.getRegistrationValues().t();
    }

    protected p e()
    {
      return g.e(g.this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.g
 * JD-Core Version:    0.6.2
 */