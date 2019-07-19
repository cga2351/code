package com.viber.voip.analytics.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.appboy.AppboyFirebaseMessagingService;
import com.appboy.a.a.a;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import com.appboy.ui.inappmessage.InAppMessageOperation;
import com.appboy.ui.inappmessage.listeners.AppboyDefaultInAppMessageManagerListener;
import com.google.firebase.messaging.RemoteMessage;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.t;
import com.viber.voip.analytics.t.a;
import com.viber.voip.analytics.y;
import com.viber.voip.messages.a.d.d;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.actions.Action;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.da;
import com.viber.voip.util.dd;
import com.viber.voip.util.u;
import com.viber.voip.util.u.b;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

public class c extends com.viber.voip.analytics.a
  implements a
{
  private com.appboy.a c;
  private final a d;
  private final Application e;
  private final dagger.a<ab> f;
  private final com.viber.voip.analytics.e.e g;
  private final EventBus h;
  private final u.b<List<com.viber.voip.model.entity.h>, String[]> i = d.a;
  private final com.appboy.i j = e.a;
  private String k;

  public c(Application paramApplication, y paramy, EventBus paramEventBus, dagger.a<ab> parama, com.viber.voip.analytics.e.e parame)
  {
    super(paramy);
    this.e = paramApplication;
    this.f = parama;
    this.d = new a();
    this.h = paramEventBus;
    this.g = parame;
    paramApplication.registerActivityLifecycleCallbacks(this.d);
  }

  private void a(List<com.viber.voip.model.entity.h> paramList, int paramInt, Action<String[]> paramAction)
  {
    List localList = u.a(paramList, new l(paramInt));
    String[] arrayOfString = { "" };
    if (!u.a(localList))
      arrayOfString = (String[])this.i.transform(localList);
    paramAction.execute(arrayOfString);
  }

  private com.appboy.a g()
  {
    if (this.c == null)
    {
      this.c = h();
      if (this.c != null)
        if (!this.b)
          break label46;
    }
    label46: for (com.appboy.b.i locali = com.appboy.b.i.b; ; locali = com.appboy.b.i.c)
    {
      a(com.viber.voip.analytics.story.g.a(locali));
      return this.c;
    }
  }

  private com.appboy.a h()
  {
    com.appboy.a.a(f.a);
    a.a locala = new a.a();
    locala.a(true).a(ViberActionRunner.ab.a(i()));
    com.appboy.a.a(this.e, locala.a());
    com.appboy.a.a(this.j);
    return com.appboy.a.a(this.e);
  }

  private boolean i()
  {
    return new com.viber.voip.app.b(this.e, com.viber.voip.h.a.c()).a(this.e);
  }

  private void j()
  {
    int m = d.f.m.d();
    if (com.viber.voip.settings.f.a(m, 3, 1))
    {
      z localz = new z();
      long l1 = localz.a(1, 14) + localz.a(1, 1010);
      long l2 = localz.a(1, 2) + localz.a(1, 1009);
      long l3 = localz.a(1, 1008);
      long l4 = localz.e("conversations.flags & 16777216!= 0", null).size();
      if (l1 > 0L)
        a(com.viber.voip.analytics.story.g.b(Boolean.TRUE));
      if (l2 > 0L)
        a(com.viber.voip.analytics.story.g.c(Boolean.TRUE));
      if (l3 > 0L)
        a(com.viber.voip.analytics.story.g.a(Boolean.TRUE));
      if (l4 > 0L)
        a(com.viber.voip.analytics.story.g.e(Boolean.TRUE));
    }
    if (com.viber.voip.settings.f.a(m, 3, 2))
      com.viber.voip.analytics.story.k.b();
    if (com.viber.voip.settings.f.a(m, 3, 3))
    {
      a(com.viber.voip.analytics.story.g.j(d.bf.b.d()));
      a(com.viber.voip.analytics.story.g.f(Boolean.valueOf(d.f.c.d())));
    }
    d.f.m.a(3);
  }

  private void k()
  {
    if (!ao.f())
      l();
    com.viber.voip.analytics.story.k.a(0);
    com.viber.voip.analytics.story.k.d();
    com.viber.voip.analytics.story.k.h();
    boolean bool = d.f.q.d();
    if (bool)
      a(com.viber.voip.analytics.story.g.b(bool));
    long l = System.currentTimeMillis();
    if (l - d.f.n.d() > 86400000L)
    {
      com.viber.voip.analytics.story.k.c();
      d.f.n.a(l);
    }
  }

  private void l()
  {
    boolean bool = com.viber.voip.analytics.story.k.a();
    if (bool)
    {
      a(com.viber.voip.analytics.story.g.a(com.viber.voip.viberout.a.a().f()));
      a(com.viber.voip.analytics.story.g.a(bool));
    }
    String str1 = UserManager.from(this.e).getRegistrationValues().e();
    if (!da.a(str1))
      a(com.viber.voip.analytics.story.g.g(str1));
    String str2 = com.viber.voip.analytics.story.k.a(this.e);
    if (!da.a(str2))
      a(com.viber.voip.analytics.story.g.e(str2));
    String str3 = com.viber.voip.analytics.story.k.b(this.e);
    if (!da.a(str3))
      a(com.viber.voip.analytics.story.g.f(str3));
    com.viber.voip.analytics.story.k.e();
  }

  protected void b(RemoteMessage paramRemoteMessage)
  {
    AppboyFirebaseMessagingService.a(ViberApplication.getApplication(), paramRemoteMessage);
  }

  protected void b(String paramString)
  {
    if ((this.k != null) && (this.k.equals(paramString)));
    com.appboy.a locala;
    com.appboy.d locald;
    do
    {
      do
      {
        return;
        this.k = paramString;
        locala = g();
      }
      while (locala == null);
      locala.d(paramString);
      locald = locala.g();
    }
    while (locald == null);
    if (!d.ad.a.c.d().isEmpty())
      locald.f(ViberApplication.getInstance().getCurrentSystemLanguage());
    this.g.a(locala.i(), locald.a());
  }

  protected void c()
  {
    if (this.b)
    {
      com.appboy.a.c(this.e);
      if ((this.c != null) && (!da.a(this.k)))
        this.c.d(this.k);
      if ((this.c != null) && (this.c.g() != null))
        a(com.viber.voip.analytics.story.g.a(com.appboy.b.i.b));
      return;
    }
    if ((this.c != null) && (this.c.g() != null))
      a(com.viber.voip.analytics.story.g.a(com.appboy.b.i.c));
    com.appboy.a.d(this.e);
    com.appboy.a.b(this.e);
    this.c = null;
  }

  public boolean c(RemoteMessage paramRemoteMessage)
  {
    return b.a(this, paramRemoteMessage);
  }

  protected boolean c(com.viber.voip.analytics.story.e parame)
  {
    Map.Entry localEntry = parame.a(a.class);
    if ((localEntry == null) || (localEntry.getValue() == null))
      return false;
    com.appboy.a locala = g();
    if (locala != null)
      locala.a(localEntry.getValue().toString(), new com.appboy.e.b.a(new JSONObject(parame.a(a.class, t.a))));
    return true;
  }

  protected boolean c(com.viber.voip.analytics.story.j paramj)
  {
    Map.Entry localEntry = paramj.a(a.class);
    if (localEntry != null)
    {
      Object localObject = localEntry.getValue();
      com.appboy.a locala = g();
      if (locala == null);
      for (com.appboy.d locald = null; locald == null; locald = locala.g())
        return false;
      if ((localObject instanceof String[]))
      {
        String[] arrayOfString = (String[])localObject;
        if (arrayOfString.length == 0)
          return false;
        com.viber.voip.analytics.story.k.a locala2 = paramj.d();
        int m;
        int n;
        if ((locala2 != null) && ((locala2 instanceof com.viber.voip.analytics.story.k.b)))
        {
          m = arrayOfString.length;
          n = 0;
        }
        while (n < m)
        {
          String str = arrayOfString[n];
          locald.b((String)localEntry.getKey(), str);
          n++;
          continue;
          locald.a((String)localEntry.getKey(), arrayOfString);
        }
      }
      while (true)
      {
        return true;
        if ((localObject instanceof com.viber.voip.analytics.story.a))
        {
          com.viber.voip.analytics.story.a locala1 = (com.viber.voip.analytics.story.a)localObject;
          locald.a(new com.appboy.e.b.b(locala1.a(), locala1.b(), locala1.c(), locala1.d()));
        }
        else if ((localObject instanceof com.appboy.b.i))
        {
          com.appboy.b.i locali = (com.appboy.b.i)localObject;
          locald.b(locali);
          if (locali == com.appboy.b.i.c)
            locala.f();
        }
        else if ((localObject instanceof Boolean))
        {
          locald.a((String)localEntry.getKey(), ((Boolean)localObject).booleanValue());
        }
        else if ((localObject instanceof Integer))
        {
          locald.a((String)localEntry.getKey(), ((Integer)localObject).intValue());
        }
        else if ((localObject instanceof Float))
        {
          locald.a((String)localEntry.getKey(), ((Float)localObject).floatValue());
        }
        else if ((localObject instanceof Double))
        {
          locald.a((String)localEntry.getKey(), ((Double)localObject).doubleValue());
        }
        else if ((localObject instanceof Long))
        {
          locald.a((String)localEntry.getKey(), ((Long)localObject).longValue());
        }
        else if ((localObject instanceof String))
        {
          locald.a((String)localEntry.getKey(), (String)localObject);
        }
        else
        {
          if (!(localObject instanceof Date))
            break;
          long l = ((Date)localObject).getTime() / 1000L;
          locald.b((String)localEntry.getKey(), l);
        }
      }
      return false;
    }
    return false;
  }

  protected void d(com.viber.voip.analytics.story.e parame)
  {
    String str1 = (String)parame.c(a.class, "key_property_product_id");
    String str2 = (String)parame.c(a.class, "key_property_currency");
    BigDecimal localBigDecimal = (BigDecimal)parame.c(a.class, "key_property_price");
    int m = ((Integer)parame.c(a.class, "key_property_quantity")).intValue();
    com.appboy.e.b.a locala = new com.appboy.e.b.a(new JSONObject(parame.a(a.class, t.a.a)));
    com.appboy.a locala1 = g();
    if (locala1 != null)
      locala1.a(str1, str2, localBigDecimal, m, locala);
  }

  protected void e()
  {
    com.appboy.a.a(this.j);
    a locala = this.d;
    locala.getClass();
    dd.a(h.a(locala));
    if (this.h.isRegistered(this))
      this.h.unregister(this);
  }

  public boolean f()
  {
    return true;
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onConversationUpdateEvent(d.d paramd)
  {
    if ((com.viber.voip.messages.m.b(paramd.a)) && (!ao.f()) && (b()))
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = String.valueOf(2);
      arrayOfString[1] = String.valueOf(1);
      arrayOfString[2] = String.valueOf(3);
      List localList = ((ab)this.f.get()).a(arrayOfString);
      a(localList, 3, new i(this));
      a(localList, 1, new j(this));
      a(localList, 2, new k(this));
    }
  }

  protected void q_()
  {
    com.appboy.a.a(null);
    a locala = this.d;
    locala.getClass();
    dd.a(g.a(locala));
    k();
    j();
    com.viber.voip.analytics.story.k.i();
    if (!this.h.isRegistered(this))
      this.h.register(this);
  }

  class a extends com.appboy.c
  {
    private boolean b;
    private boolean c;
    private Activity d;
    private boolean e;
    private boolean f;
    private boolean g;

    a()
    {
      AppboyInAppMessageManager.getInstance().setCustomInAppMessageManagerListener(new AppboyDefaultInAppMessageManagerListener()
      {
        public InAppMessageOperation beforeInAppMessageDisplayed(com.appboy.e.b paramAnonymousb)
        {
          if ((d.f.a.d()) && (c.a.a(c.a.this)))
            return InAppMessageOperation.DISPLAY_NOW;
          return InAppMessageOperation.DISPLAY_LATER;
        }
      });
    }

    private void a(Activity paramActivity)
    {
      try
      {
        super.onActivityStarted(paramActivity);
        label5: this.c = true;
        return;
      }
      catch (Exception localException)
      {
        break label5;
      }
    }

    private void b(Activity paramActivity)
    {
      try
      {
        super.onActivityStopped(paramActivity);
        label5: if (this.d == paramActivity)
          this.c = false;
        return;
      }
      catch (Exception localException)
      {
        break label5;
      }
    }

    void a()
    {
      this.f = true;
      if (this.d != null)
      {
        if ((!this.c) && (this.e))
          a(this.d);
        if (!this.b)
          onActivityResumed(this.d);
      }
    }

    void b()
    {
      if (this.d != null)
      {
        if (this.c)
          b(this.d);
        if (this.b)
          onActivityPaused(this.d);
      }
      this.f = false;
    }

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if ((this.f) && ((!(paramActivity instanceof m)) || (((m)paramActivity).isInAppCampaignSupported())));
      try
      {
        super.onActivityCreated(paramActivity, paramBundle);
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public void onActivityDestroyed(Activity paramActivity)
    {
      if (this.f);
      try
      {
        super.onActivityDestroyed(paramActivity);
        label12: if (this.d == paramActivity)
          this.d = null;
        return;
      }
      catch (Exception localException)
      {
        break label12;
      }
    }

    public void onActivityPaused(Activity paramActivity)
    {
      if (this.b);
      try
      {
        super.onActivityPaused(paramActivity);
        label12: this.b = false;
        this.g = false;
        return;
      }
      catch (Exception localException)
      {
        break label12;
      }
    }

    public void onActivityResumed(Activity paramActivity)
    {
      if ((this.f) && ((paramActivity instanceof m)) && (((m)paramActivity).isInAppCampaignSupported()));
      try
      {
        super.onActivityResumed(paramActivity);
        this.g = true;
        AppboyInAppMessageManager.getInstance().requestDisplayInAppMessage();
        label43: this.b = true;
        return;
      }
      catch (Exception localException)
      {
        break label43;
      }
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      if (this.f);
      try
      {
        super.onActivitySaveInstanceState(paramActivity, paramBundle);
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public void onActivityStarted(Activity paramActivity)
    {
      this.d = paramActivity;
      this.e = true;
      if (this.f)
        a(paramActivity);
    }

    public void onActivityStopped(Activity paramActivity)
    {
      if (this.d == paramActivity)
        this.e = false;
      if (this.f)
        b(paramActivity);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.b.c
 * JD-Core Version:    0.6.2
 */