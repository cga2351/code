package com.viber.voip.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.im2.CUpdateLanguageMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.language.LanguageUpdateDelegate;
import com.viber.jni.language.LanguageUpdateListener;
import com.viber.jni.service.ServiceStateDelegate;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.service.ServiceStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.a.g.a;
import com.viber.voip.messages.a.g.b;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.util.bp;
import com.viber.voip.util.da;
import com.viber.voip.vln.e;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class a
  implements LanguageUpdateDelegate, ServiceStateDelegate
{
  private static final Logger c = ViberEnv.getLogger();
  volatile b a;
  BroadcastReceiver b = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.intent.action.LOCALE_CHANGED"))
      {
        paramAnonymousContext.getResources().getConfiguration().locale.getLanguage();
        a.a(a.this, paramAnonymousContext.getResources().getConfiguration(), null);
      }
    }
  };
  private final Context d;
  private final Engine e;
  private final ConnectionController f;
  private String g;
  private String h;
  private String i;
  private String j;
  private EventBus k;
  private com.viber.voip.analytics.story.g.a l;
  private final e m;

  public a(String paramString, Context paramContext, Engine paramEngine, EventBus paramEventBus, com.viber.voip.analytics.story.g.a parama, e parame)
  {
    this.d = paramContext;
    this.e = paramEngine;
    this.f = paramEngine.getConnectionController();
    this.m = parame;
    this.d.registerReceiver(this.b, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    Handler localHandler = av.e.a.a();
    paramEngine.getDelegatesManager().getLanguageUpdateListener().registerDelegate(this, localHandler);
    paramEngine.getDelegatesManager().getServiceStateListener().registerDelegate(this, localHandler);
    this.k = paramEventBus;
    this.l = parama;
    this.k.register(this);
    Configuration localConfiguration = this.d.getResources().getConfiguration();
    this.g = d.ad.a.a.d();
    this.h = d.ad.a.b.d();
    this.i = paramString;
    a(localConfiguration, null);
  }

  private void a(Configuration paramConfiguration, String paramString)
  {
    String str = c();
    if (!paramConfiguration.locale.getLanguage().equals(str))
    {
      Locale localLocale = bp.c(str);
      Locale.setDefault(localLocale);
      paramConfiguration.locale = localLocale;
      Resources localResources = this.d.getResources();
      Resources.getSystem().updateConfiguration(paramConfiguration, localResources.getDisplayMetrics());
      localResources.updateConfiguration(paramConfiguration, localResources.getDisplayMetrics());
      this.a = null;
    }
    if ((this.j != null) && (!str.equals(this.j)) && (paramString != null))
      this.l.a(this.j, str, this.i, ao.f(), paramString);
    if (this.j != null)
      if (!str.equals(this.j))
      {
        this.k.post(new g.a(str));
        b();
        b(str);
        a(str);
      }
    while (true)
    {
      this.j = str;
      d();
      return;
      b(str);
    }
  }

  private void a(String paramString)
  {
    Language localLanguage = com.viber.voip.messages.translation.a.b.a(this.d, paramString);
    if (localLanguage == null)
    {
      ViberApplication.getInstance().logToCrashlytics("Unable to find UI language " + paramString);
      return;
    }
    this.l.i(localLanguage.getLanguage());
  }

  private void b()
  {
    this.m.b(true);
    this.m.a(true);
  }

  private void b(Configuration paramConfiguration)
  {
    this.i = paramConfiguration.locale.getLanguage();
    a(paramConfiguration, "OS Language");
  }

  private void b(String paramString)
  {
    Language localLanguage = com.viber.voip.messages.translation.a.b.a(this.d, paramString);
    if (localLanguage == null)
    {
      ViberApplication.getInstance().logToCrashlytics("Unable to find UI language " + paramString);
      return;
    }
    this.l.j(localLanguage.getLanguage());
  }

  private String c()
  {
    String str = d.ad.a.c.d();
    if (!da.a(str))
      return str;
    return this.i;
  }

  private void d()
  {
    final String str = c();
    if (str.equals(this.g));
    while (com.viber.voip.o.a.a() != com.viber.voip.o.a.a)
      return;
    if (!ao.f())
    {
      this.g = str;
      this.h = this.i;
      this.e.addInitializedListener(new Engine.InitializedListener()
      {
        public void initialized(Engine paramAnonymousEngine)
        {
          a.a(a.this).removeInitializedListener(this);
          if (!a.b(a.this).isConnected())
          {
            a.a(a.this, d.ad.a.a.d());
            a.b(a.this, d.ad.a.b.d());
            return;
          }
          CUpdateLanguageMsg localCUpdateLanguageMsg = new CUpdateLanguageMsg(a.c(a.this), str);
          a.a(a.this).getExchanger().handleCUpdateLanguageMsg(localCUpdateLanguageMsg);
        }
      });
      return;
    }
    d.ad.a.a.a(str);
    d.ad.a.b.a(this.i);
  }

  public b a(Context paramContext)
  {
    b localb = this.a;
    if (localb == null)
    {
      localb = new b(bp.c(paramContext));
      this.a = localb;
    }
    return localb;
  }

  public String a()
  {
    return this.i;
  }

  public void a(Configuration paramConfiguration)
  {
    if ((com.viber.common.d.a.k()) && (com.viber.voip.o.a.a() == com.viber.voip.o.a.a))
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.d(bp.a(paramConfiguration)));
    b(this.d.getResources().getConfiguration());
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onLanguageSelectedInSettings(g.b paramb)
  {
    Configuration localConfiguration = this.d.getResources().getConfiguration();
    if (paramb.b);
    for (String str = "URL Scheme"; ; str = "Settigns Screen")
    {
      a(localConfiguration, str);
      return;
    }
  }

  public void onServiceStateChanged(int paramInt)
  {
    if (ServiceStateDelegate.ServiceState.resolveEnum(paramInt) == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED)
      d();
  }

  public void onUpdateLanguage(int paramInt)
  {
    if (paramInt == 1)
    {
      d.ad.a.a.a(this.g);
      d.ad.a.b.a(this.h);
      return;
    }
    this.g = d.ad.a.a.d();
    this.h = d.ad.a.b.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.l.a
 * JD-Core Version:    0.6.2
 */