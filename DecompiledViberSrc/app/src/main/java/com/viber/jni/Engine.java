package com.viber.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.firebase.jobdispatcher.l.a;
import com.firebase.jobdispatcher.v;
import com.viber.common.d.i;
import com.viber.common.jni.NativeLibraryLoader;
import com.viber.dexshared.Logger;
import com.viber.jni.apps.AppsController;
import com.viber.jni.apps.AppsControllerCaller;
import com.viber.jni.apps.AppsControllerDelegate.UserAppsReceiver;
import com.viber.jni.apps.AppsUserAppsReceiverListener;
import com.viber.jni.banner.BannerController;
import com.viber.jni.banner.BannerControllerWrapper;
import com.viber.jni.block.BlockController;
import com.viber.jni.cdr.CdrDecorator;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.WebRtcDialerController;
import com.viber.jni.gcm.GcmController;
import com.viber.jni.gcm.GcmControllerCaller;
import com.viber.jni.group.GroupController;
import com.viber.jni.im2.Im2Dispatcher;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Im2ReceiverBase;
import com.viber.jni.im2.Im2ReceiverImpl;
import com.viber.jni.im2.Im2SenderImpl;
import com.viber.jni.like.LikeController;
import com.viber.jni.like.LikeControllerWrapper;
import com.viber.jni.memberid.MemberIdMigrationWrapper;
import com.viber.jni.ptt.VideoPttController;
import com.viber.jni.ptt.VideoPttControllerWrapper;
import com.viber.jni.publicaccount.PublicAccountConversationStatusController;
import com.viber.jni.publicaccount.PublicAccountConversationStatusWrapper;
import com.viber.jni.publicaccount.PublicAccountSubscribersCountController;
import com.viber.jni.publicaccount.PublicAccountSubscriptionController;
import com.viber.jni.publicaccount.PublicAccountSubscriptionCountControllerCaller;
import com.viber.jni.publicaccount.PublicAccountSubscriptionWrapper;
import com.viber.jni.publicgroup.PublicGroupController;
import com.viber.jni.publicgroup.PublicGroupControllerRetry;
import com.viber.jni.publicgroup.PublicGroupGetMessagesRetryListener;
import com.viber.jni.secure.DeviceManagerController;
import com.viber.jni.secure.DeviceManagerControllerWrapper;
import com.viber.jni.secure.SecureActivationController;
import com.viber.jni.secure.SecureActivationWrapper;
import com.viber.jni.secure.SecureMessagesController;
import com.viber.jni.secure.SecureMessagesWrapper;
import com.viber.jni.secure.TrustPeerController;
import com.viber.jni.secure.TrustPeerWrapper;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.jni.settings.SettingsController;
import com.viber.jni.settings.SettingsControllerCaller;
import com.viber.jni.settings.SettingsControllerDelegate;
import com.viber.jni.settings.SettingsControllerStorage;
import com.viber.jni.settings.SettingsListener;
import com.viber.jni.spam.UnknownNumberReportController;
import com.viber.jni.spam.UnknownNumberReportWrapper;
import com.viber.jni.wallet.WalletController;
import com.viber.service.ScheduledJobService;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.e.a.c;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.o.a;
import com.viber.voip.p;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallHandlerDialer;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.DialerPendingController;
import com.viber.voip.phone.conf.Im2ConferenceApi;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.pixie.PixieController.PixieReadyListener;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.settings.d.ad;
import com.viber.voip.sound.VideoSettingsController;
import com.viber.voip.user.OnlineUserActivityHelper;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.b;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.webrtc.videoengine.ViEVideoSupport;

public class Engine
{
  private static final Logger L = ViberEnv.getLogger();
  private static final String LIB_NAME = "libVoipEngineNative.so";
  private static final int PHONE_STATE_WATCHDOG_CHECK_TIMEOUT_MS = 30000;
  private ViberApplication mApplication;
  private AppsController mAppsController;
  private BannerController mBannerController;
  private CallHandler mCallHandler;
  private Set<CallHandler.CallInfoReadyListener> mCallInfoListeners = new HashSet();
  private CdrDecorator mCdrDecorator;
  private boolean mConnected = false;
  private ConnectivityMgr mConnectivityMgr = new ConnectivityMgr(null);
  private Context mContext;
  private DeviceManagerController mDeviceManagerController;
  private DialerController mDialerController;
  private DialerPendingController mDialerPendingController;
  private EngineBackend mEngineBackend;
  private EngineDelegatesManager mEngineDelegatesManager = new EngineDelegatesManager();
  private GcmController mGcmController;
  private GroupController mGroupController;
  private Im2Exchanger mIm2Exchanger;
  private boolean mInitializationStarted = false;
  private String mInitializeNumber = "";
  private boolean mInitialized = false;
  private Set<InitializedListener> mInitializedListeners = new HashSet();
  private LikeController mLikeController;
  private MemberIdMigrationWrapper mMemberIdMigrationController;
  private Object mMutexInitialization = new Object();
  private Object mMutexPostInitialization = new Object();
  private boolean mNetworkAvailable;
  private OnlineUserActivityHelper mOnlineUserActivityHelper;
  private PhoneControllerProxy mPhoneController;
  private ConnectionController mPhoneControllerConnection;
  private PhoneControllerHelper mPhoneControllerHelper;
  private SettingsController mPhoneControllerSettings;
  private PhoneControllerWrapperDelegate mPhoneControllerWrapperDelegate = new PhoneControllerWrapperDelegate(null);
  private PublicAccountConversationStatusController mPublicAccountConversationStatusController;
  private PublicAccountSubscribersCountController mPublicAccountSubscribersCountController;
  private PublicAccountSubscriptionController mPublicAccountSubscriptionController;
  private PublicGroupController mPublicGroupController;
  private cj mReachability;
  private boolean mReady = false;
  private Set<PhoneControllerReadyListener> mReadyListener = new HashSet();
  private SecureActivationController mSecureActivationController;
  private SecureMessagesController mSecureMessagesController;
  private ServiceStateDelegate.ServiceState mServiceState = ServiceStateDelegate.ServiceState.SERVICE_NOT_CONNECTED;
  private Im2ConferenceApi mSnConfManager;
  private TelephonyManager mTelephonyMgr;
  private TrustPeerController mTrustPeerController;
  private UnknownNumberReportWrapper mUnknownNumberReportController;
  private UserManager mUserMgr;
  private VideoPttController mVideoPttController;
  private VideoSettingsController mVideoSettingsController;
  PhoneStateListenerImpl phoneStateListener;
  private Runnable phoneStateListenerWatchdog = new Runnable()
  {
    public void run()
    {
      if (Engine.this.isGSMCallActive())
      {
        Engine.this.reschedulePhoneStateWatchdog(this);
        return;
      }
      Engine.this.dropPhoneStateWatchdog(this, true);
    }
  };
  private Handler watchDogHandler = av.a(av.e.g);

  public Engine(Context paramContext, ViberApplication paramViberApplication)
  {
    com.viber.voip.e.a.e.b().a("APP START", "engine create");
    this.mContext = paramContext;
    this.mApplication = paramViberApplication;
    this.mPhoneControllerHelper = new PhoneControllerHelper(new PhoneControllerHelper.Host()
    {
      public void exit()
      {
      }
    });
    this.mEngineBackend = new NativeEngineBridge(this.mPhoneControllerHelper, new NativeEngineBridge.Host()
    {
      public void ensureInitialized()
      {
        if (!Engine.this.isReady())
        {
          if (Looper.getMainLooper().getThread() == Thread.currentThread())
            Engine.this.onUninitializedAccessFromMainThread();
          Engine.this.init();
        }
      }
    });
    this.mPhoneController = new PhoneControllerProxy(this, this.mEngineBackend);
    addReadyListener(this.mPhoneController);
    this.mPhoneControllerConnection = this.mEngineBackend;
    this.mVideoPttController = new VideoPttControllerWrapper(this.mEngineBackend);
    this.mTrustPeerController = new TrustPeerWrapper(this.mEngineBackend);
    this.mSecureMessagesController = new SecureMessagesWrapper(this, this.mEngineBackend);
    this.mSecureActivationController = new SecureActivationWrapper(this.mEngineBackend);
    this.mGroupController = this.mEngineBackend;
    this.mPublicGroupController = new PublicGroupControllerRetry(this.mEngineBackend);
    this.mLikeController = new LikeControllerWrapper(this.mEngineBackend);
    this.mEngineDelegatesManager.mPublicGroupGetMessagesListener = new PublicGroupGetMessagesRetryListener((PublicGroupControllerRetry)this.mPublicGroupController);
    Im2Dispatcher localIm2Dispatcher = new Im2Dispatcher();
    this.mIm2Exchanger = new Im2Exchanger(new Im2SenderImpl(this.mEngineBackend), localIm2Dispatcher);
    this.mEngineDelegatesManager.mIm2JniReceiver = new Im2ReceiverImpl(localIm2Dispatcher);
    this.mPhoneControllerSettings = buildSettingsController();
    this.mTelephonyMgr = ((TelephonyManager)this.mContext.getSystemService("phone"));
    this.mReachability = cj.a(this.mContext);
    ConnectionListener localConnectionListener = this.mEngineDelegatesManager.getConnectionListener();
    ConnectionDelegate[] arrayOfConnectionDelegate = new ConnectionDelegate[1];
    arrayOfConnectionDelegate[0] = this.mPhoneControllerWrapperDelegate;
    localConnectionListener.registerDelegate(arrayOfConnectionDelegate);
    registerDelegate(this.mPhoneControllerWrapperDelegate);
    this.mSnConfManager = new Im2ConferenceApi(this.mIm2Exchanger, this.mEngineBackend);
    Im2Exchanger localIm2Exchanger = this.mIm2Exchanger;
    Im2ReceiverBase[] arrayOfIm2ReceiverBase = new Im2ReceiverBase[1];
    arrayOfIm2ReceiverBase[0] = this.mSnConfManager;
    localIm2Exchanger.registerDelegate(arrayOfIm2ReceiverBase);
    this.mCallHandler = new CallHandler(this.mContext, this.mApplication, this.mEngineBackend, this.mEngineBackend, this.mTrustPeerController, this.mEngineDelegatesManager, this.mSnConfManager);
    this.mCallHandler.addCallInfoReadyListener(new CallHandler.CallInfoReadyListener()
    {
      public void onCallInfoReady(final CallInfo paramAnonymousCallInfo)
      {
        av.a(av.e.a).post(new Runnable()
        {
          public void run()
          {
            synchronized (Engine.this.mCallInfoListeners)
            {
              Iterator localIterator = Engine.this.mCallInfoListeners.iterator();
              if (localIterator.hasNext())
                ((CallHandler.CallInfoReadyListener)localIterator.next()).onCallInfoReady(paramAnonymousCallInfo);
            }
          }
        });
      }
    });
    addReadyListener(this.mCallHandler);
    this.mAppsController = buildAppsController(this.mEngineBackend);
    this.mBannerController = new BannerControllerWrapper(this.mEngineBackend);
    this.mDeviceManagerController = new DeviceManagerControllerWrapper(this, this.mEngineBackend);
    this.mUnknownNumberReportController = new UnknownNumberReportWrapper(this, this.mEngineBackend);
    this.mMemberIdMigrationController = new MemberIdMigrationWrapper(this, this.mEngineBackend);
    this.mVideoSettingsController = new VideoSettingsController();
    this.mCdrDecorator = new CdrDecorator(this, this.mEngineBackend);
    addInitializedListener(this.mVideoSettingsController);
    this.mUserMgr = new UserManager(getAppsController());
    this.mOnlineUserActivityHelper = new OnlineUserActivityHelper(this.mEngineBackend, this, this.mEngineDelegatesManager, this.mApplication.getAppBackgroundChecker(), o.a(), this.mApplication);
    this.mPublicAccountConversationStatusController = new PublicAccountConversationStatusWrapper(this.mEngineBackend);
    this.mPublicAccountSubscriptionController = new PublicAccountSubscriptionWrapper(this.mEngineBackend)
    {
    };
    this.mPublicAccountSubscribersCountController = new PublicAccountSubscriptionCountControllerCaller(this, this.mEngineBackend);
    this.mGcmController = new GcmControllerCaller(this, this.mEngineBackend);
    com.viber.voip.e.a.e.b().b("APP START", "engine create");
  }

  private AppsController buildAppsController(EngineBackend paramEngineBackend)
  {
    AppsControllerCaller localAppsControllerCaller = new AppsControllerCaller(this, paramEngineBackend, this.mEngineDelegatesManager.getAppsUserAppsReceiverListener());
    this.mEngineDelegatesManager.getAppsUserAppsReceiverListener().registerDelegate(new AppsControllerDelegate.UserAppsReceiver[] { localAppsControllerCaller });
    return localAppsControllerCaller;
  }

  private SettingsController buildSettingsController()
  {
    SettingsControllerCaller localSettingsControllerCaller = new SettingsControllerCaller(this.mEngineBackend, this.mPhoneControllerConnection);
    addReadyListener(localSettingsControllerCaller);
    SettingsControllerStorage localSettingsControllerStorage = new SettingsControllerStorage(localSettingsControllerCaller);
    this.mEngineDelegatesManager.getConnectionListener().registerDelegate(new ConnectionDelegate[] { localSettingsControllerStorage });
    this.mEngineDelegatesManager.getSettingsListener().registerDelegate(new SettingsControllerDelegate[] { localSettingsControllerStorage });
    return localSettingsControllerStorage;
  }

  @SuppressLint({"SdCardPath"})
  private String getApplicationDataDir()
  {
    try
    {
      String str = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).applicationInfo.dataDir;
      return str;
    }
    catch (Exception localException)
    {
    }
    return "/data/data/" + this.mContext.getPackageName();
  }

  private void initCallHandlerDialer()
  {
    CallHandlerDialer localCallHandlerDialer = new CallHandlerDialer(this, this.mEngineBackend, getCallHandler());
    this.mDialerController = localCallHandlerDialer;
    this.mDialerPendingController = localCallHandlerDialer;
  }

  private void initPhoneStateListener()
  {
    this.phoneStateListener = new PhoneStateListenerImpl(null);
    try
    {
      Class localClass = this.mTelephonyMgr.getClass();
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = PhoneStateListener.class;
      arrayOfClass[1] = Integer.TYPE;
      arrayOfClass[2] = Integer.TYPE;
      Method localMethod = localClass.getDeclaredMethod("listenGemini", arrayOfClass);
      TelephonyManager localTelephonyManager1 = this.mTelephonyMgr;
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = this.phoneStateListener;
      arrayOfObject1[1] = Integer.valueOf(32);
      arrayOfObject1[2] = Integer.valueOf(0);
      localMethod.invoke(localTelephonyManager1, arrayOfObject1);
      TelephonyManager localTelephonyManager2 = this.mTelephonyMgr;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = this.phoneStateListener;
      arrayOfObject2[1] = Integer.valueOf(32);
      arrayOfObject2[2] = Integer.valueOf(1);
      localMethod.invoke(localTelephonyManager2, arrayOfObject2);
      return;
    }
    catch (Exception localException)
    {
      this.mTelephonyMgr.listen(this.phoneStateListener, 32);
    }
  }

  private boolean isInitializedWithNumber(String paramString)
  {
    return (this.mInitialized) && (!TextUtils.isEmpty(this.mInitializeNumber)) && (this.mInitializeNumber.equals(paramString));
  }

  private void notifyServiceStateChanged(ServiceStateDelegate.ServiceState paramServiceState)
  {
    if (this.mServiceState != paramServiceState)
    {
      this.mServiceState = paramServiceState;
      this.mEngineDelegatesManager.onServiceStateChanged(paramServiceState.ordinal());
    }
  }

  // ERROR //
  private void postInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 166	com/viber/jni/Engine:mInitializationStarted	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 130	com/viber/jni/Engine:mMutexPostInitialization	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 166	com/viber/jni/Engine:mInitializationStarted	Z
    //   19: ifeq +11 -> 30
    //   22: aload_1
    //   23: monitorexit
    //   24: return
    //   25: astore_2
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 166	com/viber/jni/Engine:mInitializationStarted	Z
    //   35: aload_1
    //   36: monitorexit
    //   37: invokestatic 692	com/viber/common/d/a:g	()Z
    //   40: ifne +13 -> 53
    //   43: aload_0
    //   44: getfield 215	com/viber/jni/Engine:mApplication	Lcom/viber/voip/ViberApplication;
    //   47: ldc_w 694
    //   50: invokevirtual 698	com/viber/voip/ViberApplication:logToCrashlytics	(Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 215	com/viber/jni/Engine:mApplication	Lcom/viber/voip/ViberApplication;
    //   57: invokevirtual 702	com/viber/voip/ViberApplication:getHardwareParameters	()Lcom/viber/voip/registration/HardwareParameters;
    //   60: astore_3
    //   61: aload_0
    //   62: getfield 215	com/viber/jni/Engine:mApplication	Lcom/viber/voip/ViberApplication;
    //   65: invokevirtual 706	com/viber/voip/ViberApplication:getActivationController	()Lcom/viber/voip/registration/ActivationController;
    //   68: astore 4
    //   70: invokestatic 709	com/viber/voip/ViberApplication:isActivated	()Z
    //   73: istore 5
    //   75: iload 5
    //   77: ifeq +771 -> 848
    //   80: aload 4
    //   82: invokevirtual 714	com/viber/voip/registration/ActivationController:getDeviceKey	()Ljava/lang/String;
    //   85: astore 56
    //   87: aload 56
    //   89: invokestatic 719	com/viber/voip/registration/ao:c	(Ljava/lang/String;)V
    //   92: aload 56
    //   94: ifnull +746 -> 840
    //   97: aload 56
    //   99: invokestatic 724	com/viber/voip/util/z:b	(Ljava/lang/String;)[B
    //   102: astore 6
    //   104: aload 56
    //   106: ifnonnull +23 -> 129
    //   109: getstatic 122	com/viber/jni/Engine:L	Lcom/viber/dexshared/Logger;
    //   112: new 726	java/lang/IllegalStateException
    //   115: dup
    //   116: ldc_w 728
    //   119: invokespecial 730	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   122: ldc 158
    //   124: invokeinterface 735 3 0
    //   129: aload_3
    //   130: invokeinterface 740 1 0
    //   135: astore 16
    //   137: aload 16
    //   139: invokestatic 724	com/viber/voip/util/z:b	(Ljava/lang/String;)[B
    //   142: astore 18
    //   144: aload 16
    //   146: invokestatic 742	com/viber/voip/registration/ao:b	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: getfield 215	com/viber/jni/Engine:mApplication	Lcom/viber/voip/ViberApplication;
    //   153: invokevirtual 746	com/viber/voip/ViberApplication:getFcmTokenController	()Lcom/viber/voip/fcm/c;
    //   156: invokevirtual 750	com/viber/voip/fcm/c:b	()Ljava/lang/String;
    //   159: astore 19
    //   161: aload_0
    //   162: getfield 215	com/viber/jni/Engine:mApplication	Lcom/viber/voip/ViberApplication;
    //   165: invokevirtual 754	com/viber/voip/ViberApplication:getContactManager	()Lcom/viber/voip/contacts/c/d/g;
    //   168: invokeinterface 760 1 0
    //   173: invokeinterface 764 1 0
    //   178: i2s
    //   179: istore 20
    //   181: aload 4
    //   183: invokevirtual 767	com/viber/voip/registration/ActivationController:getCountryCodeInt	()I
    //   186: i2s
    //   187: istore 21
    //   189: aload 4
    //   191: invokevirtual 770	com/viber/voip/registration/ActivationController:getAlphaCountryCode	()Ljava/lang/String;
    //   194: astore 22
    //   196: aload 4
    //   198: invokevirtual 773	com/viber/voip/registration/ActivationController:getRegNumberCanonized	()Ljava/lang/String;
    //   201: astore 23
    //   203: aload 23
    //   205: invokestatic 672	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   208: ifeq +23 -> 231
    //   211: aload 4
    //   213: invokevirtual 776	com/viber/voip/registration/ActivationController:getRegNumber	()Ljava/lang/String;
    //   216: astore 55
    //   218: aload_0
    //   219: getfield 242	com/viber/jni/Engine:mPhoneController	Lcom/viber/jni/PhoneControllerProxy;
    //   222: iload 21
    //   224: aload 55
    //   226: invokevirtual 780	com/viber/jni/PhoneControllerProxy:canonizePhoneNumberForCountryCode	(ILjava/lang/String;)Ljava/lang/String;
    //   229: astore 23
    //   231: invokestatic 784	com/viber/voip/ViberEnv:getPixieController	()Lcom/viber/voip/pixie/PixieController;
    //   234: astore 24
    //   236: invokestatic 787	com/viber/voip/registration/ao:f	()Z
    //   239: ifeq +762 -> 1001
    //   242: iconst_1
    //   243: istore 25
    //   245: invokestatic 792	com/viber/deviceinfo/a:a	()Lcom/viber/deviceinfo/a;
    //   248: invokevirtual 794	com/viber/deviceinfo/a:d	()Ljava/lang/String;
    //   251: astore 26
    //   253: invokestatic 792	com/viber/deviceinfo/a:a	()Lcom/viber/deviceinfo/a;
    //   256: invokevirtual 796	com/viber/deviceinfo/a:c	()Z
    //   259: istore 27
    //   261: aload_0
    //   262: getfield 433	com/viber/jni/Engine:mCdrDecorator	Lcom/viber/jni/cdr/CdrDecorator;
    //   265: aload 26
    //   267: invokevirtual 799	com/viber/jni/cdr/CdrDecorator:setAdvertisingId	(Ljava/lang/String;)V
    //   270: invokestatic 802	com/viber/voip/memberid/d:c	()Z
    //   273: ifne +734 -> 1007
    //   276: iconst_1
    //   277: istore 28
    //   279: iconst_0
    //   280: newarray int
    //   282: invokestatic 808	com/viber/jni/ExcludeFeatures:exclude	([I)[B
    //   285: astore 29
    //   287: aconst_null
    //   288: invokestatic 812	com/viber/voip/ViberApplication:isTablet	(Landroid/content/Context;)Z
    //   291: istore 30
    //   293: iload 30
    //   295: ifeq +16 -> 311
    //   298: iconst_1
    //   299: newarray int
    //   301: dup
    //   302: iconst_0
    //   303: bipush 29
    //   305: iastore
    //   306: invokestatic 808	com/viber/jni/ExcludeFeatures:exclude	([I)[B
    //   309: astore 29
    //   311: invokestatic 817	com/viber/voip/ap:c	()Lcom/viber/voip/ap$a;
    //   314: getfield 822	com/viber/voip/ap$a:a	Lcom/viber/jni/ClientEnvConfig;
    //   317: astore 31
    //   319: new 824	com/viber/jni/FeatureList
    //   322: dup
    //   323: invokespecial 825	com/viber/jni/FeatureList:<init>	()V
    //   326: ldc_w 827
    //   329: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   332: ldc_w 833
    //   335: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   338: ldc_w 835
    //   341: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   344: ldc_w 837
    //   347: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   350: ldc_w 839
    //   353: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   356: ldc_w 841
    //   359: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   362: ldc_w 843
    //   365: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   368: ldc_w 845
    //   371: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   374: ldc_w 847
    //   377: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   380: astore 32
    //   382: iload 30
    //   384: ifne +12 -> 396
    //   387: aload 32
    //   389: ldc_w 849
    //   392: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   395: pop
    //   396: invokestatic 853	com/viber/voip/util/cd:a	()Z
    //   399: ifeq +12 -> 411
    //   402: aload 32
    //   404: ldc_w 855
    //   407: invokevirtual 831	com/viber/jni/FeatureList:addFeature	(Ljava/lang/String;)Lcom/viber/jni/FeatureList;
    //   410: pop
    //   411: aload_0
    //   412: getfield 213	com/viber/jni/Engine:mContext	Landroid/content/Context;
    //   415: invokestatic 860	com/viber/voip/notif/g:a	(Landroid/content/Context;)Lcom/viber/voip/notif/g;
    //   418: invokevirtual 863	com/viber/voip/notif/g:i	()Z
    //   421: ifeq +592 -> 1013
    //   424: iconst_2
    //   425: istore 33
    //   427: invokestatic 868	com/viber/voip/analytics/g:a	()Lcom/viber/voip/analytics/g;
    //   430: invokevirtual 871	com/viber/voip/analytics/g:j	()Ljava/lang/String;
    //   433: astore 34
    //   435: aload_0
    //   436: getfield 215	com/viber/jni/Engine:mApplication	Lcom/viber/voip/ViberApplication;
    //   439: invokevirtual 456	com/viber/voip/ViberApplication:getAppBackgroundChecker	()Lcom/viber/voip/util/d;
    //   442: invokevirtual 875	com/viber/voip/util/d:b	()Z
    //   445: ifeq +574 -> 1019
    //   448: iconst_0
    //   449: istore 35
    //   451: getstatic 881	com/viber/voip/util/dv:w	Lcom/viber/voip/util/dv;
    //   454: aload_0
    //   455: getfield 213	com/viber/jni/Engine:mContext	Landroid/content/Context;
    //   458: invokevirtual 884	com/viber/voip/util/dv:a	(Landroid/content/Context;)Ljava/io/File;
    //   461: invokevirtual 889	java/io/File:getPath	()Ljava/lang/String;
    //   464: astore 36
    //   466: aload_0
    //   467: getfield 142	com/viber/jni/Engine:mEngineDelegatesManager	Lcom/viber/jni/EngineDelegatesManager;
    //   470: astore 37
    //   472: aload 24
    //   474: invokeinterface 894 1 0
    //   479: istore 38
    //   481: aload 24
    //   483: invokeinterface 897 1 0
    //   488: istore 39
    //   490: invokestatic 817	com/viber/voip/ap:c	()Lcom/viber/voip/ap$a;
    //   493: getfield 900	com/viber/voip/ap$a:aC	I
    //   496: istore 40
    //   498: iload 27
    //   500: ifeq +7 -> 507
    //   503: ldc 158
    //   505: astore 26
    //   507: new 902	com/viber/jni/PhoneControllerInitializer
    //   510: dup
    //   511: aload 18
    //   513: aload 6
    //   515: aload 19
    //   517: sipush 4096
    //   520: iload 20
    //   522: aload 22
    //   524: iload 21
    //   526: aload 23
    //   528: aload 36
    //   530: aload 37
    //   532: iload 25
    //   534: iload 35
    //   536: iload 38
    //   538: iload 39
    //   540: iload 40
    //   542: aload 26
    //   544: invokestatic 906	com/viber/voip/registration/o:b	()I
    //   547: getstatic 910	com/viber/voip/p:a	Ljava/lang/String;
    //   550: iload 28
    //   552: aload 29
    //   554: iload 33
    //   556: aload 31
    //   558: aload 32
    //   560: invokespecial 913	com/viber/jni/PhoneControllerInitializer:<init>	([B[BLjava/lang/String;ISLjava/lang/String;SLjava/lang/String;Ljava/lang/String;Lcom/viber/jni/PhoneControllerDelegate;IIIIILjava/lang/String;ILjava/lang/String;Z[BILcom/viber/jni/ClientEnvConfig;Lcom/viber/jni/FeatureList;)V
    //   563: astore 41
    //   565: new 600	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 601	java/lang/StringBuilder:<init>	()V
    //   572: aload_0
    //   573: getfield 213	com/viber/jni/Engine:mContext	Landroid/content/Context;
    //   576: invokevirtual 917	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   579: getfield 920	android/content/pm/ApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   582: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc_w 922
    //   588: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc 10
    //   593: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: astore 42
    //   601: ldc 10
    //   603: invokestatic 928	com/viber/common/jni/NativeLibraryLoader:getDefChecksum	(Ljava/lang/String;)J
    //   606: lstore 43
    //   608: aload 41
    //   610: getfield 932	com/viber/jni/PhoneControllerInitializer:_clientEnvConfig	Landroid/os/Bundle;
    //   613: ldc_w 934
    //   616: aload 42
    //   618: invokevirtual 939	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: aload 41
    //   623: getfield 932	com/viber/jni/PhoneControllerInitializer:_clientEnvConfig	Landroid/os/Bundle;
    //   626: ldc_w 941
    //   629: lload 43
    //   631: invokevirtual 945	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   634: aload_0
    //   635: getfield 213	com/viber/jni/Engine:mContext	Landroid/content/Context;
    //   638: invokestatic 348	com/viber/voip/util/cj:a	(Landroid/content/Context;)Lcom/viber/voip/util/cj;
    //   641: invokevirtual 947	com/viber/voip/util/cj:a	()I
    //   644: istore 45
    //   646: aload 41
    //   648: getfield 932	com/viber/jni/PhoneControllerInitializer:_clientEnvConfig	Landroid/os/Bundle;
    //   651: ldc_w 949
    //   654: iload 45
    //   656: invokestatic 952	com/viber/voip/util/cj:a	(I)I
    //   659: invokevirtual 956	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   662: aload 41
    //   664: getfield 932	com/viber/jni/PhoneControllerInitializer:_clientEnvConfig	Landroid/os/Bundle;
    //   667: ldc_w 958
    //   670: new 600	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 601	java/lang/StringBuilder:<init>	()V
    //   677: invokestatic 962	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   680: invokevirtual 968	android/app/Application:getFilesDir	()Ljava/io/File;
    //   683: invokevirtual 971	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   686: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: ldc_w 973
    //   692: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokevirtual 939	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: aload 41
    //   703: getfield 932	com/viber/jni/PhoneControllerInitializer:_clientEnvConfig	Landroid/os/Bundle;
    //   706: ldc_w 975
    //   709: aload 34
    //   711: invokevirtual 939	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload_0
    //   715: getfield 225	com/viber/jni/Engine:mPhoneControllerHelper	Lcom/viber/jni/PhoneControllerHelper;
    //   718: aload 41
    //   720: invokevirtual 979	com/viber/jni/PhoneControllerHelper:Init	(Lcom/viber/jni/PhoneControllerInitializer;)I
    //   723: pop
    //   724: getstatic 981	com/viber/voip/av$e:b	Lcom/viber/voip/av$e;
    //   727: invokestatic 178	com/viber/voip/av:a	(Lcom/viber/voip/av$e;)Landroid/os/Handler;
    //   730: new 983	com/viber/jni/Engine$$Lambda$0
    //   733: dup
    //   734: aload_0
    //   735: invokespecial 984	com/viber/jni/Engine$$Lambda$0:<init>	(Lcom/viber/jni/Engine;)V
    //   738: invokevirtual 990	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   741: pop
    //   742: aload_0
    //   743: getfield 350	com/viber/jni/Engine:mReachability	Lcom/viber/voip/util/cj;
    //   746: aload_0
    //   747: getfield 137	com/viber/jni/Engine:mConnectivityMgr	Lcom/viber/jni/Engine$ConnectivityMgr;
    //   750: invokevirtual 993	com/viber/voip/util/cj:a	(Lcom/viber/voip/util/cj$b;)V
    //   753: aload_0
    //   754: invokespecial 996	com/viber/jni/Engine:scheduleKeepAliveJob	()V
    //   757: aload_0
    //   758: getfield 154	com/viber/jni/Engine:mInitializedListeners	Ljava/util/Set;
    //   761: astore 49
    //   763: aload 49
    //   765: monitorenter
    //   766: aload_0
    //   767: iconst_1
    //   768: putfield 164	com/viber/jni/Engine:mInitialized	Z
    //   771: aload_0
    //   772: aload 23
    //   774: putfield 160	com/viber/jni/Engine:mInitializeNumber	Ljava/lang/String;
    //   777: new 149	java/util/HashSet
    //   780: dup
    //   781: aload_0
    //   782: getfield 154	com/viber/jni/Engine:mInitializedListeners	Ljava/util/Set;
    //   785: invokespecial 999	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   788: astore 51
    //   790: aload_0
    //   791: getfield 154	com/viber/jni/Engine:mInitializedListeners	Ljava/util/Set;
    //   794: invokeinterface 1004 1 0
    //   799: aload 49
    //   801: monitorexit
    //   802: aload 51
    //   804: invokeinterface 1008 1 0
    //   809: astore 52
    //   811: aload 52
    //   813: invokeinterface 1013 1 0
    //   818: ifeq +215 -> 1033
    //   821: aload 52
    //   823: invokeinterface 1017 1 0
    //   828: checkcast 1019	com/viber/jni/Engine$InitializedListener
    //   831: aload_0
    //   832: invokeinterface 1022 2 0
    //   837: goto -26 -> 811
    //   840: iconst_0
    //   841: newarray byte
    //   843: astore 6
    //   845: goto -741 -> 104
    //   848: bipush 32
    //   850: newarray byte
    //   852: astore 6
    //   854: goto -725 -> 129
    //   857: astore 7
    //   859: aconst_null
    //   860: astore 8
    //   862: aload 7
    //   864: astore 9
    //   866: iload 5
    //   868: ifeq +60 -> 928
    //   871: aload 8
    //   873: ifnull +111 -> 984
    //   876: aload 8
    //   878: invokestatic 1025	com/viber/voip/util/z:a	(Ljava/lang/String;)Ljava/lang/String;
    //   881: astore 15
    //   883: aload 15
    //   885: astore 13
    //   887: getstatic 122	com/viber/jni/Engine:L	Lcom/viber/dexshared/Logger;
    //   890: new 726	java/lang/IllegalStateException
    //   893: dup
    //   894: new 600	java/lang/StringBuilder
    //   897: dup
    //   898: invokespecial 601	java/lang/StringBuilder:<init>	()V
    //   901: ldc_w 1027
    //   904: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload 13
    //   909: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: invokevirtual 610	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: invokespecial 730	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   918: aload 9
    //   920: invokevirtual 1030	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   923: invokeinterface 735 3 0
    //   928: aload_0
    //   929: getfield 242	com/viber/jni/Engine:mPhoneController	Lcom/viber/jni/PhoneControllerProxy;
    //   932: invokevirtual 1033	com/viber/jni/PhoneControllerProxy:disconnect	()V
    //   935: aload_0
    //   936: getfield 215	com/viber/jni/Engine:mApplication	Lcom/viber/voip/ViberApplication;
    //   939: iconst_0
    //   940: invokevirtual 1037	com/viber/voip/ViberApplication:setActivated	(Z)V
    //   943: new 1039	android/content/Intent
    //   946: dup
    //   947: ldc_w 1041
    //   950: invokespecial 1042	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   953: astore 10
    //   955: aload 10
    //   957: ldc_w 1044
    //   960: iconst_1
    //   961: invokevirtual 1048	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   964: pop
    //   965: aload 10
    //   967: ldc_w 1049
    //   970: invokevirtual 1053	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   973: pop
    //   974: aload_0
    //   975: getfield 213	com/viber/jni/Engine:mContext	Landroid/content/Context;
    //   978: aload 10
    //   980: invokevirtual 1057	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   983: return
    //   984: ldc 158
    //   986: astore 13
    //   988: goto -101 -> 887
    //   991: astore 14
    //   993: ldc_w 1059
    //   996: astore 13
    //   998: goto -111 -> 887
    //   1001: iconst_0
    //   1002: istore 25
    //   1004: goto -759 -> 245
    //   1007: iconst_0
    //   1008: istore 28
    //   1010: goto -731 -> 279
    //   1013: iconst_1
    //   1014: istore 33
    //   1016: goto -589 -> 427
    //   1019: iconst_1
    //   1020: istore 35
    //   1022: goto -571 -> 451
    //   1025: astore 50
    //   1027: aload 49
    //   1029: monitorexit
    //   1030: aload 50
    //   1032: athrow
    //   1033: invokestatic 692	com/viber/common/d/a:g	()Z
    //   1036: ifne -1029 -> 7
    //   1039: aload_0
    //   1040: getfield 215	com/viber/jni/Engine:mApplication	Lcom/viber/voip/ViberApplication;
    //   1043: ldc_w 1061
    //   1046: invokevirtual 698	com/viber/voip/ViberApplication:logToCrashlytics	(Ljava/lang/String;)V
    //   1049: return
    //   1050: astore 48
    //   1052: goto -295 -> 757
    //   1055: astore 17
    //   1057: aload 17
    //   1059: astore 9
    //   1061: aload 16
    //   1063: astore 8
    //   1065: goto -199 -> 866
    //
    // Exception table:
    //   from	to	target	type
    //   15	24	25	finally
    //   26	28	25	finally
    //   30	37	25	finally
    //   129	137	857	java/lang/Exception
    //   876	883	991	java/security/NoSuchAlgorithmException
    //   766	802	1025	finally
    //   1027	1030	1025	finally
    //   753	757	1050	java/lang/Exception
    //   137	144	1055	java/lang/Exception
  }

  private ServiceStateDelegate.ServiceState resolveServiceState()
  {
    if (this.mConnected)
      return ServiceStateDelegate.ServiceState.SERVICE_CONNECTED;
    if (this.mNetworkAvailable)
      return ServiceStateDelegate.ServiceState.SERVICE_NOT_CONNECTED;
    return ServiceStateDelegate.ServiceState.NO_INTERNET;
  }

  private void scheduleKeepAliveJob()
  {
    com.firebase.jobdispatcher.e locale = this.mApplication.getFirebaseJobDispatcher();
    int i = (int)(p.b() / 1000L);
    locale.a(locale.a().a(ScheduledJobService.class).a("keep_alive").a(2).b(true).a(true).a(v.a(i, (int)(1.1D * i))).j());
  }

  private boolean shouldSkipConnect()
  {
    return this.mApplication.shouldBlockAllActivities();
  }

  public void addCallInfoListener(CallHandler.CallInfoReadyListener paramCallInfoReadyListener)
  {
    synchronized (this.mCallInfoListeners)
    {
      if (getCurrentCall() != null)
        paramCallInfoReadyListener.onCallInfoReady(getCurrentCall());
      this.mCallInfoListeners.add(paramCallInfoReadyListener);
      return;
    }
  }

  public void addInitializedListener(InitializedListener paramInitializedListener)
  {
    synchronized (this.mInitializedListeners)
    {
      if (this.mInitialized)
      {
        i = 1;
        if (i != 0)
          paramInitializedListener.initialized(this);
        return;
      }
      this.mInitializedListeners.add(paramInitializedListener);
      int i = 0;
    }
  }

  public void addLoadedListener(LoadedListener paramLoadedListener)
  {
    addReadyListener(paramLoadedListener);
    addInitializedListener(paramLoadedListener);
  }

  public void addReadyListener(PhoneControllerReadyListener paramPhoneControllerReadyListener)
  {
    synchronized (this.mReadyListener)
    {
      if (this.mReady)
      {
        i = 1;
        if (i != 0)
          paramPhoneControllerReadyListener.ready(this.mPhoneController);
        return;
      }
      this.mReadyListener.add(paramPhoneControllerReadyListener);
      int i = 0;
    }
  }

  public void dropPhoneStateWatchdog(Runnable paramRunnable, boolean paramBoolean)
  {
    this.watchDogHandler.removeCallbacks(paramRunnable);
    if (!paramBoolean)
      return;
    this.mPhoneController.handleGSMStateChange(0);
  }

  public AppsController getAppsController()
  {
    return this.mAppsController;
  }

  public BannerController getBannerController()
  {
    return this.mBannerController;
  }

  public BlockController getBlockController()
  {
    return this.mEngineBackend;
  }

  public CallHandler getCallHandler()
  {
    return this.mCallHandler;
  }

  @Deprecated
  public ICdrController getCdrController()
  {
    return this.mCdrDecorator;
  }

  public ConnectionController getConnectionController()
  {
    return this.mPhoneControllerConnection;
  }

  public CallInfo getCurrentCall()
  {
    if (this.mCallHandler != null)
      return this.mCallHandler.getCallInfo();
    return null;
  }

  public EngineDelegatesManager getDelegatesManager()
  {
    return this.mEngineDelegatesManager;
  }

  public DeviceManagerController getDeviceManagerController()
  {
    return this.mDeviceManagerController;
  }

  @Deprecated
  public DialerController getDialerController()
  {
    if (this.mDialerController == null)
      initCallHandlerDialer();
    return this.mDialerController;
  }

  @Deprecated
  public DialerController getDialerControllerNowrap()
  {
    return this.mEngineBackend;
  }

  public DialerPendingController getDialerPendingController()
  {
    if (this.mDialerController == null)
      initCallHandlerDialer();
    return this.mDialerPendingController;
  }

  public Im2Exchanger getExchanger()
  {
    return this.mIm2Exchanger;
  }

  public GcmController getGcmController()
  {
    return this.mGcmController;
  }

  public GroupController getGroupController()
  {
    return this.mGroupController;
  }

  public LikeController getLikeController()
  {
    return this.mLikeController;
  }

  public MemberIdMigrationWrapper getMemberIdMigrationController()
  {
    return this.mMemberIdMigrationController;
  }

  @Deprecated
  public OnlineUserActivityHelper getOnlineUserActivityHelper()
  {
    return this.mOnlineUserActivityHelper;
  }

  @Deprecated
  public PhoneController getPhoneController()
  {
    return this.mPhoneController;
  }

  public PublicAccountConversationStatusController getPublicAccountConversationStatusController()
  {
    return this.mPublicAccountConversationStatusController;
  }

  public PublicAccountSubscribersCountController getPublicAccountSubscribersCountController()
  {
    return this.mPublicAccountSubscribersCountController;
  }

  public PublicAccountSubscriptionController getPublicAccountSubscriptionController()
  {
    return this.mPublicAccountSubscriptionController;
  }

  public PublicGroupController getPublicGroupController()
  {
    return this.mPublicGroupController;
  }

  public SecureActivationController getSecureActivationController()
  {
    return this.mSecureActivationController;
  }

  public SecureMessagesController getSecureMessagesController()
  {
    return this.mSecureMessagesController;
  }

  public long getServerDeltaTime()
  {
    return d.ad.R.d();
  }

  public ServiceStateDelegate.ServiceState getServiceState()
  {
    return this.mServiceState;
  }

  public SettingsController getSettingsController()
  {
    return this.mPhoneControllerSettings;
  }

  @Deprecated
  public TrustPeerController getTrustPeerController()
  {
    return this.mTrustPeerController;
  }

  public UnknownNumberReportController getUnknownNumberReportController()
  {
    return this.mUnknownNumberReportController;
  }

  public UserManager getUserManager()
  {
    return this.mUserMgr;
  }

  public VideoPttController getVideoPttController()
  {
    return this.mVideoPttController;
  }

  public WalletController getWalletController()
  {
    return this.mEngineBackend;
  }

  public WebRtcDialerController getWebRtcDialerController()
  {
    return this.mEngineBackend;
  }

  public void init()
  {
    if (!this.mReady)
    {
      try
      {
        if (!this.mReady)
        {
          this.mApplication.preEngineInit(this);
          if (this.mReady)
            return;
          com.viber.voip.e.a.e.b().a("APP START", "engine initService ready");
          this.mReady = loadLibrary();
          if (this.mReady)
            break label86;
          com.viber.voip.e.a.e.b().b("APP START", "engine initService ready");
          return;
        }
      }
      finally
      {
      }
      return;
      label86: synchronized (this.mReadyListener)
      {
        final HashSet localHashSet = new HashSet(this.mReadyListener);
        this.mReadyListener.clear();
        av.e.b.a().post(new Runnable()
        {
          public void run()
          {
            com.viber.voip.e.a.e.b().b("APP START", "engine initService ready");
            Iterator localIterator = localHashSet.iterator();
            while (localIterator.hasNext())
              ((PhoneControllerReadyListener)localIterator.next()).ready(Engine.this.mPhoneController);
          }
        });
        return;
      }
    }
  }

  public void initService()
  {
    if (!this.mReady)
      init();
    if (!this.mInitialized)
      ViberEnv.getPixieController().addReadyListener(new PixieController.PixieReadyListener()
      {
        public void onReady()
        {
          if (!Engine.this.mInitialized)
            synchronized (Engine.this.mMutexInitialization)
            {
              if (!Engine.this.mInitialized)
              {
                i.a();
                Engine.this.postInit();
              }
              return;
            }
        }
      });
  }

  public boolean isGSMCallActive()
  {
    return this.mTelephonyMgr.getCallState() != 0;
  }

  public boolean isInitialized()
  {
    return this.mInitialized;
  }

  public boolean isReady()
  {
    return this.mReady;
  }

  protected boolean loadLibrary()
  {
    boolean bool = true;
    try
    {
      if ((!this.mReady) && (a.a() == a.a))
      {
        com.viber.voip.e.a.e.b().a("APP START", "engine loadLibrary");
        LibraryPrerequisiteSetup.setup(DeviceFlagsManager.WEAK_DEVICE, getApplicationDataDir());
      }
      while (true)
      {
        try
        {
          NativeLibraryLoader.loadLibrary("ViberRTC", true);
          NativeLibraryLoader.loadLibrary("VoipEngineNative", true);
          this.mReady = true;
          ViEVideoSupport.init();
          com.viber.voip.e.a.e.b().b("APP START", "engine loadLibrary");
          return bool;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          L.a(localUnsatisfiedLinkError, "Unable to load library: ");
          com.viber.voip.e.a.e.b().b("APP START", "engine loadLibrary");
          bool = false;
          continue;
        }
        bool = this.mReady;
      }
    }
    finally
    {
    }
  }

  void onUninitializedAccessFromMainThread()
  {
    RuntimeException localRuntimeException = new RuntimeException("Uninitialized engine access from UI thread");
    L.a(localRuntimeException, "OOPS");
  }

  public void reInitService()
  {
    if (!this.mInitialized)
      initService();
    ActivationController localActivationController;
    String str1;
    do
    {
      return;
      localActivationController = this.mApplication.getActivationController();
      str1 = localActivationController.getRegNumberCanonized();
    }
    while (isInitializedWithNumber(str1));
    int i = (short)localActivationController.getCountryCodeInt();
    String str2 = localActivationController.getAlphaCountryCode();
    getPhoneController().disconnect();
    getPhoneController().changePhoneNumberInfo(i, str2, str1);
    getPhoneController().connect();
  }

  public void registerDelegate(PhoneControllerDelegate paramPhoneControllerDelegate)
  {
    this.mEngineDelegatesManager.registerDelegate(new PhoneControllerDelegate[] { paramPhoneControllerDelegate });
  }

  public void registerDelegate(PhoneControllerDelegate paramPhoneControllerDelegate, Handler paramHandler)
  {
    this.mEngineDelegatesManager.registerDelegate(paramPhoneControllerDelegate, paramHandler);
  }

  public void removeCallInfoListener(CallHandler.CallInfoReadyListener paramCallInfoReadyListener)
  {
    try
    {
      this.mCallInfoListeners.remove(paramCallInfoReadyListener);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void removeDelegate(PhoneControllerDelegate paramPhoneControllerDelegate)
  {
    this.mEngineDelegatesManager.removeDelegate(paramPhoneControllerDelegate);
  }

  public void removeInitializedListener(InitializedListener paramInitializedListener)
  {
    synchronized (this.mInitializedListeners)
    {
      this.mInitializedListeners.remove(paramInitializedListener);
      return;
    }
  }

  public void removeReadyListener(PhoneControllerReadyListener paramPhoneControllerReadyListener)
  {
    synchronized (this.mReadyListener)
    {
      this.mReadyListener.remove(paramPhoneControllerReadyListener);
      return;
    }
  }

  public void reschedulePhoneStateWatchdog(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      paramRunnable = this.phoneStateListenerWatchdog;
    dropPhoneStateWatchdog(paramRunnable, false);
    this.watchDogHandler.postDelayed(paramRunnable, 30000L);
  }

  private class ConnectivityMgr
    implements cj.b
  {
    private ConnectivityMgr()
    {
    }

    public void backgroundDataChanged(boolean paramBoolean)
    {
    }

    public void connectivityChanged(int paramInt1, int paramInt2)
    {
      int i = cj.a(paramInt1);
      Engine.this.mPhoneController.handleConnectivityChange(i);
      if (paramInt1 == -1)
      {
        Engine.access$802(Engine.this, false);
        Engine.access$602(Engine.this, false);
        return;
      }
      Engine.access$802(Engine.this, true);
    }

    public void wifiConnectivityChanged()
    {
      if (Engine.this.shouldSkipConnect())
        return;
      Engine.this.mPhoneController.testConnection(2);
      Engine.this.mPhoneController.handleConnectivityChange(1);
    }
  }

  public static abstract interface InitializedListener
  {
    public abstract void initialized(Engine paramEngine);
  }

  public static abstract interface LoadedListener extends Engine.InitializedListener, PhoneControllerReadyListener
  {
  }

  private class PhoneControllerWrapperDelegate extends PhoneControllerDelegateAdapter
    implements ConnectionDelegate
  {
    private boolean isFirstConnectReceived = false;
    private int prevConnectionState = -1;

    private PhoneControllerWrapperDelegate()
    {
    }

    public void onConnect()
    {
      if (this.isFirstConnectReceived)
      {
        this.isFirstConnectReceived = false;
        Engine.this.mApplication.getActivationController().saveKeychainParamsOnConnect();
      }
    }

    public void onConnectionStateChange(int paramInt)
    {
      int i = 1;
      if (this.prevConnectionState == paramInt)
        return;
      this.prevConnectionState = paramInt;
      if (paramInt == i)
      {
        Engine.this.notifyServiceStateChanged(ServiceStateDelegate.ServiceState.CONNECTING);
        return;
      }
      Engine localEngine = Engine.this;
      if (paramInt == 3);
      while (true)
      {
        Engine.access$602(localEngine, i);
        Engine.this.notifyServiceStateChanged(Engine.access$700(Engine.this));
        return;
        i = 0;
      }
    }

    public void onLBServerTime(long paramLong)
    {
      long l = System.currentTimeMillis() - paramLong;
      d.ad.R.a(l);
    }
  }

  private class PhoneStateListenerImpl extends PhoneStateListener
  {
    private PhoneStateListenerImpl()
    {
    }

    public void onCallStateChanged(final int paramInt, String paramString)
    {
      super.onCallStateChanged(paramInt, paramString);
      Engine.this.mEngineDelegatesManager.onGSMStateChange(paramInt, paramString);
      Engine.this.mEngineDelegatesManager.getHandler().post(new Runnable()
      {
        public void run()
        {
          if ((paramInt != 0) && (Engine.this.isGSMCallActive()))
          {
            Engine.this.mPhoneController.handleGSMStateChange(1);
            Engine.this.reschedulePhoneStateWatchdog(null);
            return;
          }
          Engine.this.mPhoneController.handleGSMStateChange(0);
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.Engine
 * JD-Core Version:    0.6.2
 */