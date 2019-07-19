package com.viber.voip.vln;

import android.app.Application;
import android.os.Handler;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.viber.voip.p;
import com.viber.voip.react.ReactContextManager.Params;
import com.viber.voip.react.d;
import com.viber.voip.settings.d.aq;
import com.viber.voip.util.bx;
import org.greenrobot.eventbus.EventBus;

public class f
  implements d
{
  private com.viber.voip.react.e a;
  private h b;
  private final bx c;
  private final Handler d;
  private final EventBus e;
  private final com.viber.voip.analytics.g f;

  public f(bx parambx, Handler paramHandler, EventBus paramEventBus, com.viber.voip.analytics.g paramg)
  {
    this.c = parambx;
    this.d = paramHandler;
    this.e = paramEventBus;
    this.f = paramg;
  }

  private ReactInstanceManager a(Application paramApplication, ReactPackage paramReactPackage)
  {
    ReactInstanceManagerBuilder localReactInstanceManagerBuilder = ReactInstanceManager.builder();
    localReactInstanceManagerBuilder.setApplication(paramApplication).setJSMainModulePath("index").addPackage(paramReactPackage).addPackage(new MainReactPackage()).addPackage(new com.BV.LinearGradient.a()).addPackage(new com.reactnativecommunity.webview.a()).addPackage(new com.swmansion.gesturehandler.react.e()).addPackage(new com.reactnativecommunity.asyncstorage.c());
    com.microsoft.codepush.react.a.b(p.e());
    localReactInstanceManagerBuilder.setBundleAssetName("vln.bundle");
    if (d.aq.d.d())
      localReactInstanceManagerBuilder.setUseDeveloperSupport(true);
    localReactInstanceManagerBuilder.setInitialLifecycleState(LifecycleState.BEFORE_RESUME);
    return localReactInstanceManagerBuilder.build();
  }

  private h c(ReactContextManager.Params paramParams)
  {
    String str1;
    if (this.b == null)
    {
      if (paramParams.getMemberId() == null)
        break label57;
      str1 = paramParams.getMemberId();
      if (paramParams.getRegPhoneCanonized() == null)
        break label63;
    }
    label57: label63: for (String str2 = paramParams.getRegPhoneCanonized(); ; str2 = "")
    {
      this.b = new h(this.c, this.f, str1, str2);
      return this.b;
      str1 = "";
      break;
    }
  }

  public com.viber.voip.react.e a(Application paramApplication, ReactContextManager.Params paramParams)
  {
    if ((this.a == null) || (paramParams.shouldReconfigureReactInstanceManager()))
    {
      h localh = c(paramParams);
      this.a = new g(a(paramApplication, localh), localh, this.d, this.e);
    }
    return this.a;
  }

  public com.viber.voip.react.g<com.viber.voip.react.b> a(ReactContextManager.Params paramParams)
  {
    return c(paramParams);
  }

  public com.viber.voip.react.c b(ReactContextManager.Params paramParams)
  {
    return c(paramParams);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.f
 * JD-Core Version:    0.6.2
 */