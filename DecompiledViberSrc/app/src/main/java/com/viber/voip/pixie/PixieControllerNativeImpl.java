package com.viber.voip.pixie;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.pixie.jni.UnblockerControllerDelegate;
import com.viber.voip.pixie.jni.UnblockerControllerFacade;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.ActivationController.c;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.util.da;
import com.viber.voip.util.dz;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PixieControllerNativeImpl
  implements PixieController, UnblockerController.UnblockerControllerListener
{
  private static final Logger L = ViberEnv.getLogger();
  private static PixieControllerNativeImpl mInstance;
  private HashSet<String> frontDomains = new HashSet(Arrays.asList(new String[] { "api.mixpanel.com", "app.adjust.com", "decide.mixpanel.com", "dev.appboy.com", "e.crashlytics.com", "graph.facebook.com", "media.giphy.com", "reports.crashlytics.com", "settings.crashlytics.com", "venetia.iad.appboy.com" }));
  private Handler handler = av.a(av.e.b);
  private int initStatus = -1;
  private UnblockerControllerDelegate mDelegate = new UnblockerControllerDelegate();
  private boolean mIsOkayToAccessNetwork;
  private int mLocalProxiePort;
  private UnblockerControllerFacade mNativeController = UnblockerControllerFacade.newInstance();
  private Proxy mProxy;
  private Set<PixieController.PixieReadyListener> mReadyListeners = new HashSet();
  private Engine.InitializedListener mStartPixieOnPhoneControllerInit = new Engine.InitializedListener()
  {
    public void initialized(Engine paramAnonymousEngine)
    {
      paramAnonymousEngine.getPhoneController().setPixieMode(1);
    }
  };
  private Engine.InitializedListener mStopPixieOnPhoneControllerInit = new Engine.InitializedListener()
  {
    public void initialized(Engine paramAnonymousEngine)
    {
      paramAnonymousEngine.getPhoneController().setPixieMode(0);
    }
  };
  private boolean mUnblockerWasStarted = false;
  private boolean mUseLocalProxy;
  private boolean reportedVpnState = false;
  private int unblockerStatus = UnblockerDefines.UnblockerStatus.UNBLOCKER_STATUS_UNDEFINED;

  private PixieControllerNativeImpl()
  {
    this.mDelegate.addListener(this);
    this.mLocalProxiePort = UnblockerDefines.UNBLOCKER_DEFAULT_PORT;
  }

  private void disableProxy()
  {
    ProxySelector localProxySelector = ProxySelector.getDefault();
    if ((localProxySelector instanceof PixieProxySelector))
      ((PixieProxySelector)localProxySelector).redirect(false);
    this.mUseLocalProxy = false;
    this.mProxy = null;
  }

  private void enableProxy(int paramInt)
  {
    updateFrontDomains();
    this.mProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", paramInt));
    ProxySelector.setDefault(new PixieProxySelector(this.mProxy, this.frontDomains));
    this.mUseLocalProxy = true;
    this.mLocalProxiePort = paramInt;
  }

  @Deprecated
  public static PixieControllerNativeImpl getInstance()
  {
    try
    {
      if (mInstance == null)
        mInstance = new PixieControllerNativeImpl();
      PixieControllerNativeImpl localPixieControllerNativeImpl = mInstance;
      return localPixieControllerNativeImpl;
    }
    finally
    {
    }
  }

  private static int getPixieForceMode()
  {
    return 0;
  }

  private static boolean isServerProcess()
  {
    return com.viber.voip.o.a.a() == com.viber.voip.o.a.a;
  }

  private void notifyItsOkayToUseNetwork()
  {
    synchronized (this.mReadyListeners)
    {
      this.mIsOkayToAccessNetwork = true;
      final HashSet localHashSet = new HashSet(this.mReadyListeners);
      this.mReadyListeners.clear();
      this.handler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localHashSet.iterator();
          while (localIterator.hasNext())
            ((PixieController.PixieReadyListener)localIterator.next()).onReady();
        }
      });
      return;
    }
  }

  private void startProxyIfEnabled()
  {
    ProxySettings localProxySettings = ProxySettingsHolder.obtain();
    int i = -1;
    if ("socks5".equals(localProxySettings.type))
      i = UnblockerDefines.EUnblockerType.UNBLOCKER_SOCKS5;
    while (true)
    {
      setProxy(i, UnblockerDefines.SocksInfo.fromProxySettings(localProxySettings), localProxySettings.udp);
      return;
      if ("ss".equals(localProxySettings.type))
        i = UnblockerDefines.EUnblockerType.UNBLOCKER_SS;
      else if ("gq".equals(localProxySettings.type))
        i = UnblockerDefines.EUnblockerType.UNBLOCKER_GOQUIET;
    }
  }

  private void updateFrontDomains()
  {
    String[] arrayOfString = this.mNativeController.getDomains();
    if (arrayOfString == null);
    while (true)
    {
      return;
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = arrayOfString[j];
        this.frontDomains.add(str);
      }
    }
  }

  public void addReadyListener(PixieController.PixieReadyListener paramPixieReadyListener)
  {
    synchronized (this.mReadyListeners)
    {
      boolean bool = this.mIsOkayToAccessNetwork;
      if (!bool)
        this.mReadyListeners.add(paramPixieReadyListener);
      if (bool)
        paramPixieReadyListener.onReady();
      return;
    }
  }

  public void addRedirect(String paramString1, String paramString2)
  {
    if (this.mNativeController != null)
      this.mNativeController.AddRedirect(paramString1, paramString2);
  }

  public int getLocalProxyPort()
  {
    return this.mLocalProxiePort;
  }

  public int getPixieMode()
  {
    if (!isEnabled())
      return 0;
    return 1;
  }

  public int getPixiePort()
  {
    return this.mLocalProxiePort;
  }

  public Proxy getProxy()
  {
    return this.mProxy;
  }

  public String getUnblockerInfo()
  {
    return this.mNativeController.getUnblockerInfo();
  }

  public void init()
  {
    if ((isServerProcess()) && (this.initStatus < 0))
    {
      ViberApplication localViberApplication = ViberApplication.getInstance();
      final ActivationController localActivationController = localViberApplication.getActivationController();
      String str1 = localActivationController.getRegNumberCanonized();
      HardwareParameters localHardwareParameters = localViberApplication.getHardwareParameters();
      String str2 = localHardwareParameters.getSimMNC();
      String str3 = localHardwareParameters.getMCC();
      String str4 = localHardwareParameters.getMNC();
      String str5 = localHardwareParameters.getSimMCC();
      String str6 = dz.a();
      int i = ap.c().aC;
      String str7 = ap.c().I;
      String str8 = localHardwareParameters.getUdid();
      this.initStatus = this.mNativeController.Init(this.mDelegate, str1, str2, str5, str6, str8, str3, str4, i, getPixieForceMode(), false, str7);
      if (da.a(str1))
        localActivationController.registerActivationStateListener(new ActivationController.c()
        {
          public void onActivationStateChange(int paramAnonymousInt)
          {
            if (paramAnonymousInt == 8)
            {
              localActivationController.unregisterActivationStateListener(this);
              String str = localActivationController.getRegNumberCanonized();
              PixieControllerNativeImpl.this.mNativeController.UpdatePhoneNumber(str);
            }
          }
        });
      startProxyIfEnabled();
    }
  }

  public boolean isEnabled()
  {
    return this.mUseLocalProxy;
  }

  public void onAppForeground()
  {
    if (!this.mUnblockerWasStarted);
    boolean bool;
    do
    {
      return;
      bool = com.viber.voip.pixie.a.a.a(ViberApplication.getApplication());
    }
    while (this.reportedVpnState == bool);
    this.mNativeController.UpdateGeoInfo();
    this.reportedVpnState = bool;
  }

  public void onNetworkReadyToUse()
  {
    notifyItsOkayToUseNetwork();
  }

  public void onUnblockerStatusUpdate(int paramInt1, int paramInt2)
  {
    if (!com.viber.common.d.a.g())
      ViberApplication.getInstance().logToCrashlytics("onUnblockerStatusUpdate status: " + paramInt1);
    this.unblockerStatus = paramInt1;
    this.mLocalProxiePort = paramInt2;
    this.mUnblockerWasStarted = this.mNativeController.ShouldCheckGeoInfo();
    if (this.unblockerStatus == UnblockerDefines.UnblockerStatus.UNBLOCKER_STATUS_ON)
    {
      enableProxy(this.mLocalProxiePort);
      ViberApplication.getInstance().getEngine(false).removeInitializedListener(this.mStartPixieOnPhoneControllerInit);
      ViberApplication.getInstance().getEngine(false).removeInitializedListener(this.mStopPixieOnPhoneControllerInit);
      ViberApplication.getInstance().getEngine(false).addInitializedListener(this.mStartPixieOnPhoneControllerInit);
    }
    while (true)
    {
      if (this.unblockerStatus == UnblockerDefines.UnblockerStatus.UNBLOCKER_STATUS_ON)
        av.a(av.e.g).post(new Runnable()
        {
          public void run()
          {
            try
            {
              ViberApplication localViberApplication = ViberApplication.getInstance();
              if (com.viber.voip.pixie.a.a.a(ViberApplication.getApplication()))
                localViberApplication.logToCrashlytics(new RuntimeException("Vpn is active , mcc = " + localViberApplication.getHardwareParameters().getMCC()));
              return;
            }
            catch (Throwable localThrowable)
            {
            }
          }
        });
      return;
      disableProxy();
      ViberApplication.getInstance().getEngine(false).removeInitializedListener(this.mStartPixieOnPhoneControllerInit);
      ViberApplication.getInstance().getEngine(false).removeInitializedListener(this.mStopPixieOnPhoneControllerInit);
      ViberApplication.getInstance().getEngine(false).addInitializedListener(this.mStopPixieOnPhoneControllerInit);
    }
  }

  public void removeReadyListener(PixieController.PixieReadyListener paramPixieReadyListener)
  {
    synchronized (this.mReadyListeners)
    {
      this.mReadyListeners.remove(paramPixieReadyListener);
      return;
    }
  }

  public void setProxy(int paramInt, UnblockerDefines.SocksInfo paramSocksInfo, boolean paramBoolean)
  {
    this.mNativeController.setProxy(paramInt, paramSocksInfo, paramBoolean);
  }

  public void setPushConfig(String paramString)
  {
    this.mNativeController.SetPushConfig(paramString);
  }

  public void startProxy()
  {
    startProxyIfEnabled();
  }

  public boolean useLocalProxy()
  {
    return this.mUseLocalProxy;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.PixieControllerNativeImpl
 * JD-Core Version:    0.6.2
 */