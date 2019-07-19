package com.viber.voip.vln;

import android.os.Handler;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.viber.common.b.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.a.g.a;
import com.viber.voip.react.e;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.bc;
import com.viber.voip.settings.d.f;
import com.viber.voip.ui.j.ax;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class g extends e
{
  private static final Logger a = ViberEnv.getLogger();
  private final h b;
  private d.al c;
  private d.al d;
  private EventBus e;

  public g(ReactInstanceManager paramReactInstanceManager, h paramh, Handler paramHandler, EventBus paramEventBus)
  {
    super(paramReactInstanceManager);
    this.b = paramh;
    this.e = paramEventBus;
    a[] arrayOfa1 = new a[4];
    arrayOfa1[0] = d.f.b;
    arrayOfa1[1] = d.f.c;
    arrayOfa1[2] = d.f.d;
    arrayOfa1[3] = d.f.e;
    this.c = new d.al(paramHandler, arrayOfa1)
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        WritableNativeMap localWritableNativeMap = new WritableNativeMap();
        localWritableNativeMap.putString("privacyFlags", String.valueOf(com.viber.voip.gdpr.d.a()));
        g.a(g.this).a("privacyFlags", localWritableNativeMap);
      }
    };
    a[] arrayOfa2 = new a[1];
    arrayOfa2[0] = d.bc.a;
    this.d = new d.al(paramHandler, arrayOfa2)
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        WritableNativeMap localWritableNativeMap = new WritableNativeMap();
        localWritableNativeMap.putString("mode", i.a(ax.a(d.bc.a.d())));
        g.a(g.this).a("appearance", localWritableNativeMap);
      }
    };
  }

  public void c()
  {
    super.c();
    com.viber.voip.settings.d.a(this.c);
    com.viber.voip.settings.d.a(this.d);
    this.e.register(this);
  }

  public void d()
  {
    super.d();
    com.viber.voip.settings.d.b(this.c);
    com.viber.voip.settings.d.b(this.d);
    this.e.unregister(this);
  }

  @Subscribe
  public void onLanguageChanged(g.a parama)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.g
 * JD-Core Version:    0.6.2
 */