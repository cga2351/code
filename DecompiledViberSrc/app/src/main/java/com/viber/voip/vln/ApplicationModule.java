package com.viber.voip.vln;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.e.a.c;
import com.viber.voip.e.a.e;
import com.viber.voip.gdpr.d;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.aq;
import com.viber.voip.settings.d.az;
import com.viber.voip.settings.d.bc;
import com.viber.voip.settings.d.f;
import com.viber.voip.ui.j.ax;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bp;
import com.viber.voip.util.bx;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ApplicationModule extends ReactContextBaseJavaModule
{
  private static final Logger L = ViberEnv.getLogger();
  private static final String MODULE_NAME = "App";
  public static final String SERVER_TYPE_FDD = "fdd";
  public static final String SERVER_TYPE_INT = "integration";
  public static final String SERVER_TYPE_PROD = "production";
  public static final String SERVER_TYPE_STAGING = "staging";
  private static final String SYSTEM_ID = "Android";
  private final String mMemberId;
  private final bx mMixpanelUtil;
  private final com.viber.voip.react.b mReactCallback;

  public ApplicationModule(ReactApplicationContext paramReactApplicationContext, String paramString, bx parambx, com.viber.voip.react.b paramb)
  {
    super(paramReactApplicationContext);
    this.mMemberId = paramString;
    this.mMixpanelUtil = parambx;
    this.mReactCallback = paramb;
  }

  private String getEnv()
  {
    String str = d.az.a.d();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 3449687:
    case 104431:
    case 69446:
    case -1897523141:
    }
    while (true)
      switch (i)
      {
      default:
        return "integration";
        if (str.equals("prod"))
        {
          i = 0;
          continue;
          if (str.equals("int"))
          {
            i = 1;
            continue;
            if (str.equals("FDD"))
            {
              i = 2;
              continue;
              if (str.equals("staging"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    return "production";
    return "integration";
    return "fdd";
    return "staging";
  }

  private String getGoogleAdId()
  {
    if (!d.f.d.d())
      return "";
    try
    {
      String str = AdvertisingIdClient.getAdvertisingIdInfo(ViberApplication.getApplication()).getId();
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  @ReactMethod
  public void close()
  {
    this.mReactCallback.b();
  }

  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ENV", getEnv());
    localHashMap.put("VERSION", p.d());
    localHashMap.put("BASE_URL_API", d.aq.b.d());
    localHashMap.put("SYSTEM", "Android");
    localHashMap.put("LANGUAGE", bp.a(Locale.getDefault()));
    localHashMap.put("COUNTRY", UserManager.from(ViberApplication.getApplication()).getRegistrationValues().e());
    localHashMap.put("MCC", ViberApplication.getInstance().getHardwareParameters().getMCC());
    localHashMap.put("MNC", ViberApplication.getInstance().getHardwareParameters().getMNC());
    localHashMap.put("SIM_MCC", ViberApplication.getInstance().getHardwareParameters().getSimMCC());
    localHashMap.put("SIM_MNC", ViberApplication.getInstance().getHardwareParameters().getSimMNC());
    localHashMap.put("ADVERTISING_ID", getGoogleAdId());
    localHashMap.put("PRIVACY_FLAGS", String.valueOf(d.a()));
    localHashMap.put("MEMBER_ID", this.mMemberId);
    localHashMap.put("BUILD_NUMBER", p.f());
    localHashMap.put("OS_VERSION", Build.VERSION.RELEASE);
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("BRAND", Build.BRAND);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("CARRIER", this.mMixpanelUtil.d());
    localHashMap.put("RADIO", this.mMixpanelUtil.c());
    localHashMap.put("WIFI", this.mMixpanelUtil.e());
    localHashMap.put("HAS_NFC", Boolean.valueOf(this.mMixpanelUtil.a()));
    localHashMap.put("HAS_TELEPHONE", Boolean.valueOf(this.mMixpanelUtil.b()));
    localHashMap.put("APPEARANCE_MODE", i.a(ax.a(d.bc.a.d())));
    return localHashMap;
  }

  @ReactMethod
  public void getInitialURL(Promise paramPromise)
  {
    paramPromise.resolve(this.mReactCallback.c());
  }

  public String getName()
  {
    return "App";
  }

  @ReactMethod
  public void onCoreLoadedDebug()
  {
    e.b().b("react", "start application");
  }

  @ReactMethod
  public void onReady()
  {
    this.mReactCallback.a();
  }

  @ReactMethod
  public void onRenderedDebug()
  {
    e.b().b("react", "load view");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.ApplicationModule
 * JD-Core Version:    0.6.2
 */