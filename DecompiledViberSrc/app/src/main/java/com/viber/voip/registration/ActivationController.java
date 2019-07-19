package com.viber.voip.registration;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.LocaleListCompat;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.group.GroupController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.settings.b.e.a.a;
import com.viber.voip.settings.d.af;
import com.viber.voip.settings.d.at;
import com.viber.voip.settings.d.b;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.j;
import com.viber.voip.settings.d.r;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.au;
import com.viber.voip.util.ViberActionRunner.bd;
import com.viber.voip.util.bp;
import com.viber.voip.util.cc;
import com.viber.voip.util.cg;
import com.viber.voip.util.cj;
import com.viber.voip.util.cv;
import com.viber.voip.util.da;
import com.viber.voip.util.n;
import com.viber.voip.util.z;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActivationController
{
  public static final int ACTIVATION_DEFAULT_STEP = 4;
  public static final int ACTIVATION_STEP_ACTIVATION = 1;
  public static final int ACTIVATION_STEP_COMPLETE = 8;
  public static final int ACTIVATION_STEP_COMPLETE_FAST_REG = 3;
  public static final int ACTIVATION_STEP_COMPLETE_SECURE_REG = 13;
  public static final int ACTIVATION_STEP_COMPLETE_USUAL_REG = 2;
  public static final int ACTIVATION_STEP_NEW_USER = 5;
  public static final int ACTIVATION_STEP_REGISTRATION = 0;
  public static final int ACTIVATION_STEP_RESTORE_SHOW = 20;
  public static final int ACTIVATION_STEP_RESTORE_WAITING_BACKUP_INFO = 19;
  public static final int ACTIVATION_STEP_SECURE_ACTIVATION = 9;
  public static final int ACTIVATION_STEP_SECURE_ACTIVATION_DIALOG = 16;
  public static final int ACTIVATION_STEP_SECURE_ACTIVATION_POPUP = 10;
  public static final int ACTIVATION_STEP_SECURE_SET_USER_DATA = 15;
  public static final int ACTIVATION_STEP_SECURE_SUCCESS = 11;
  public static final int ACTIVATION_STEP_SECURE_SUCCESS_POPUP = 12;
  public static final int ACTIVATION_STEP_SET_USER_DATA = 7;
  public static final int ACTIVATION_STEP_SPLASH = 4;
  public static final int ACTIVATION_STEP_UPDATE_USER_DETAILS_FINISHED = 18;
  public static final String EXTRA_ACTIVATION_CODE = "activation_code";
  public static final String EXTRA_IS_CAME_FROM_SECONDARY_ACTIVATION = "came_from_secondary";
  public static boolean IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE = false;
  private static final Logger L = ViberEnv.getLogger();
  public static final String STATUS_ALREADY_ACTIVATED = "109";
  public static final String STATUS_INCORRECT_NUMBER = "104";
  public static final String STATUS_OTHER_SYSTEM_UDID = "102";
  public static final String STATUS_PHONE_NUMBER_TOO_LONG = "122";
  public static final String STATUS_PHONE_NUMBER_TOO_SHORT = "121";
  public static final String STATUS_PRIMARY_DEVICE_REQUIRED = "114";
  public static final String STATUS_SECONDARY_DEVICE_PRIMARY_UPGRADE = "115";
  protected static final String STATUS_SECONDARY_UDID_ALREADY_IN_USE = "119";
  static final String STATUS_SMS_LIMIT_EXCEEDED = "123";
  public static final String STATUS_TOKEN_AUTH_FAILED = "118";
  public static final String STATUS_UDID_NOT_FOUND = "107";
  private static ActivationController sInstance;
  private ActivationCode activationCode;
  private b activationSource;
  private ViberApplication app;
  private boolean mAutoDismissTzintukCall;
  private Handler mBackgroundExecutor;
  private Context mContext;
  private boolean mIsRegistrationMadeViaTzintuk;
  private final dagger.a<com.viber.voip.analytics.story.f.d> mLazyOnboardingTracker;
  private w mRegisterTask;
  private final af mRegistrationValues;
  private final com.viber.voip.backup.s mRestoreAfterRegistrationController;
  private boolean mSecondaryActivationRequested;
  private Set<c> mStateChangeListeners = new HashSet();
  private final UserData mUserData;
  private final ap mUserInfoDuringRegistrationFetcher;
  private final UserManager mUserManager;

  static
  {
    if (!com.viber.common.d.a.n());
    for (boolean bool = true; ; bool = false)
    {
      IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE = bool;
      return;
    }
  }

  private ActivationController(Context paramContext, ViberApplication paramViberApplication, Handler paramHandler, UserManager paramUserManager, com.viber.voip.backup.s params, dagger.a<com.viber.voip.analytics.story.f.d> parama)
  {
    this.mContext = paramContext;
    this.app = paramViberApplication;
    this.mBackgroundExecutor = paramHandler;
    this.mUserManager = paramUserManager;
    this.mRegistrationValues = this.mUserManager.getRegistrationValues();
    this.mUserData = this.mUserManager.getUserData();
    this.mRestoreAfterRegistrationController = params;
    this.mRestoreAfterRegistrationController.a(this);
    this.mLazyOnboardingTracker = parama;
    this.mUserInfoDuringRegistrationFetcher = new ap(this.mRestoreAfterRegistrationController, this.mBackgroundExecutor, this.app, d.bf.p);
  }

  private void clearSensitiveData(Context paramContext, ViberApplication paramViberApplication, Activity paramActivity, boolean paramBoolean, Runnable paramRunnable)
  {
    paramViberApplication.setActivated(false);
    paramViberApplication.getContactManager().g();
    paramViberApplication.getContactManager().f().a();
    com.viber.voip.block.b.a().c();
    com.viber.voip.api.a.a().e();
    com.viber.service.contacts.sync.a.a().d();
    com.viber.voip.rakuten.a.a().k();
    ao.a(ViberApplication.isTablet(paramActivity));
    com.viber.voip.notif.g.a(paramContext).h();
    paramViberApplication.getFacebookManager().a();
    paramViberApplication.getVKManager().a();
    paramViberApplication.getWalletController().a();
    new com.viber.voip.banner.d(paramActivity).b();
    clearUserDedicatedData(paramContext);
    if (paramBoolean)
    {
      ab.b().u();
      com.viber.voip.stickers.i.a().a(false, paramRunnable);
    }
    while (paramRunnable == null)
      return;
    paramRunnable.run();
  }

  private void clearUserDedicatedData(Context paramContext)
  {
    com.viber.voip.backup.g.b localb = new com.viber.voip.backup.g.b();
    try
    {
      localb.a(paramContext, 1).d();
      localb.a(paramContext, 3).d();
      label30: com.viber.voip.util.e.e.a(paramContext).b(this.mUserData.getImage());
      this.mUserManager.clear();
      com.viber.voip.model.a.b.e();
      com.viber.voip.settings.d.a();
      com.viber.voip.memberid.d.a();
      ViberApplication.preferences().a();
      return;
    }
    catch (com.viber.voip.backup.c.d locald)
    {
      break label30;
    }
  }

  private void continueWelcomeFlowAfterRegistration()
  {
    ArrayList localArrayList = new ArrayList(2);
    Intent localIntent = new Intent("com.viber.voip.action.DEFAULT");
    localIntent.putExtra("fresh_start", true);
    localIntent.putExtra("need_ask_all_permissions_at_fresh_start", true);
    localIntent.putExtra("secondary_activation_requested", this.mSecondaryActivationRequested);
    localIntent.addFlags(268435456);
    localArrayList.add(localIntent);
    String str = e.a.t.d();
    if (!da.a(str))
    {
      Uri localUri = Uri.parse(str);
      d.at.d.a(1);
      d.at.c.a(1);
      e.a.t.e();
      localArrayList.add(new Intent("android.intent.action.VIEW").setData(localUri).addFlags(268435456));
      localIntent.removeExtra("need_ask_all_permissions_at_fresh_start");
    }
    this.mContext.startActivities((Intent[])localArrayList.toArray(new Intent[0]));
  }

  public static ActivationController getInstance(Context paramContext, ViberApplication paramViberApplication, Handler paramHandler, UserManager paramUserManager, com.viber.voip.backup.s params, dagger.a<com.viber.voip.analytics.story.f.d> parama)
  {
    if (sInstance == null);
    try
    {
      if (sInstance == null)
        sInstance = new ActivationController(paramContext, paramViberApplication, paramHandler, paramUserManager, params, parama);
      return sInstance;
    }
    finally
    {
    }
  }

  private void handleDeferredDeepLink()
  {
    String str = e.a.t.d();
    if (da.a(str))
      return;
    e.a.t.e();
    Intent localIntent = new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).addFlags(268435456);
    this.mContext.startActivity(localIntent);
  }

  private void notifyActivationStateListeners(int paramInt)
  {
    synchronized (this.mStateChangeListeners)
    {
      HashSet localHashSet = new HashSet(this.mStateChangeListeners);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((c)localIterator.next()).onActivationStateChange(paramInt);
    }
  }

  private void reportShouldRegisterWrongParams()
  {
    L.a(new IllegalArgumentException("ShouldRegister_wrongParams"), "");
  }

  private void showSplashScreen()
  {
    clearAllRegValues();
    ViberActionRunner.bd.a(this.mContext);
  }

  private void trackDeactivation()
  {
    if (ViberApplication.isActivated())
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.g);
  }

  void checkNetworkConnection()
    throws com.viber.voip.m.a
  {
    if (!cj.b(this.mContext))
      throw new com.viber.voip.m.a("Active network is not connected");
  }

  public void clearAllRegValues()
  {
    this.mRegistrationValues.o();
  }

  public void clearState()
  {
    setStep(4, false);
    if (ViberApplication.isTablet(this.mContext))
      ao.a(true);
  }

  public void deActivateAndExit(Activity paramActivity, boolean paramBoolean)
  {
    trackDeactivation();
    clearSensitiveData(ViberApplication.getApplication(), ViberApplication.getInstance(), paramActivity, true, new c(this, paramActivity, paramBoolean));
  }

  public void deactivatedFromServer(Runnable paramRunnable)
  {
    trackDeactivation();
    clearSensitiveData(ViberApplication.getApplication(), ViberApplication.getInstance(), null, false, paramRunnable);
  }

  ActivationCode getActivationCode()
  {
    return this.activationCode;
  }

  public String getAlphaCountryCode()
  {
    return this.mRegistrationValues.e();
  }

  public String getCountry()
  {
    return this.mUserManager.getRegistrationValues().c();
  }

  public String getCountryCode()
  {
    return this.mUserManager.getRegistrationValues().b();
  }

  public int getCountryCodeInt()
  {
    return this.mRegistrationValues.d();
  }

  public String getDeviceKey()
  {
    return this.mRegistrationValues.a().e();
  }

  public String getKeyChainDeviceKey()
  {
    ao localao = this.mRegistrationValues.a();
    if (ao.f());
    for (ao.b localb = ao.b.c; ; localb = ao.b.a)
      return localao.a(localb);
  }

  public byte getKeyChainDeviceKeySource()
  {
    return this.mRegistrationValues.a().h();
  }

  public String getKeyChainUDID()
  {
    ao localao = this.mRegistrationValues.a();
    if (ao.f());
    for (ao.b localb = ao.b.d; ; localb = ao.b.b)
      return localao.a(localb);
  }

  public String getRegNumber()
  {
    return this.mRegistrationValues.f();
  }

  public String getRegNumberCanonized()
  {
    return this.mRegistrationValues.g();
  }

  public int getStep()
  {
    return e.a.r.d();
  }

  public boolean isActivationCompleted()
  {
    return getStep() == 8;
  }

  public boolean isAutoDismissTzintukCall()
  {
    return this.mAutoDismissTzintukCall;
  }

  public boolean isRegistrationMadeViaTzintuk()
  {
    return this.mIsRegistrationMadeViaTzintuk;
  }

  public boolean isSecureActivation()
  {
    return (getStep() == 16) || (getStep() == 10);
  }

  public void markSecondaryActivationRequested()
  {
    this.mSecondaryActivationRequested = true;
  }

  public void registerActivationStateListener(c paramc)
  {
    synchronized (this.mStateChangeListeners)
    {
      this.mStateChangeListeners.add(paramc);
      return;
    }
  }

  public void removeRegistrationCallback()
  {
    if (this.mRegisterTask != null)
      this.mRegisterTask.a();
  }

  public void reportActivationParams(String paramString)
  {
    try
    {
      String str8 = getDeviceKey();
      if (str8 != null)
      {
        String str9 = z.a(str8);
        str10 = str9;
        str1 = str10;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        String str10;
        String str1;
        label25: String str6 = ao.j();
        String str7;
        if (str6 != null)
          str7 = z.a(str6);
        for (str2 = str7; ; str2 = "")
        {
          if (!ao.f())
            break label189;
          str3 = e.a.a.c.d();
          String str4 = ao.i();
          String str5 = getKeyChainUDID();
          if (c.a.a.a.c.i())
          {
            com.crashlytics.android.a.a("key", str1);
            com.crashlytics.android.a.a("udid", str3);
            com.crashlytics.android.a.a("keyOnInit", str2);
            com.crashlytics.android.a.a("udidOnInit", str4);
            com.crashlytics.android.a.a("keychainUdid", str5);
          }
          if ((!da.a(str1, str2)) || (!da.a(str3, str4)))
            break label200;
          L.a(new Exception(paramString), "");
          return;
          str10 = "";
          break;
          localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
          str1 = "Invalid";
          break label25;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        while (true)
        {
          String str2 = "Invalid";
          continue;
          label189: String str3 = e.a.l.d();
        }
        label200: reportShouldRegisterWrongParams();
      }
    }
  }

  void resetActivationCode()
  {
    this.activationCode = null;
    this.activationSource = null;
  }

  protected void resetViberData()
  {
    com.viber.service.contacts.sync.a.a().d();
    cv.a().g();
    this.app.getContactManager().g();
    d.r.h.e();
    d.r.C.a(System.currentTimeMillis());
    d.f.h.a(true);
    setCameFromSecondaryActivation(false);
    com.viber.voip.memberid.d.a();
  }

  public void restoreLastRegisteredCodeNumber()
  {
    d.b.a.d();
    if (da.a(d.b.b.d()))
      av.a(av.e.b).post(new Runnable()
      {
        public void run()
        {
          s.c();
        }
      });
  }

  public void resumeActivation()
  {
    int i = getStep();
    if ((i == 8) && (!ViberApplication.isActivated()))
    {
      clearState();
      i = getStep();
      L.a(new Exception("ACTIVATION_STEP_COMPLETE when app is not activated."), "");
    }
    int j = i;
    switch (j)
    {
    case 6:
    case 14:
    case 17:
    default:
      return;
    case 4:
      this.app.getCountryCodeManager().d();
      showSplashScreen();
      RegistrationReminderMessageReceiver.a(this.mContext);
      return;
    case 0:
      ViberActionRunner.au.c(this.mContext);
      resetViberData();
      RegistrationReminderMessageReceiver.a(this.mContext);
      return;
    case 9:
    case 11:
      ViberActionRunner.au.c(this.mContext);
      this.app.getMessagesManager().c().a(null);
      return;
    case 12:
      d.r.h.e();
      d.r.i.e();
      Engine localEngine = ViberApplication.getInstance().getEngine(false);
      if (localEngine.getPhoneController().isConnected())
        localEngine.getGroupController().handleRecoverPublicAccounts();
      ViberApplication.getInstance().getMessagesManager().e().a(this.mRegistrationValues.l(), null, false);
      this.app.setActivated(true);
    case 10:
    case 16:
      this.mContext.startActivity(new Intent(this.mContext, AuthSecondaryActivity.class).addFlags(268435456));
      return;
    case 1:
      ViberActionRunner.au.b(this.activationCode, this.mContext);
      this.activationCode = null;
      RegistrationReminderMessageReceiver.a(this.mContext);
      this.app.getMessagesManager().c().a(null);
      return;
    case 3:
      this.app.getMessagesManager().c().a(null);
    case 13:
      d.b.d.a(com.viber.voip.registration.c.e.d.a());
    case 2:
      setActivatedSimSerial();
      this.app.setActivated(true);
      this.app.getContactManager().b();
      if (com.viber.common.d.a.k())
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.d(bp.a(ViberApplication.getApplication().getResources().getConfiguration())));
      boolean bool;
      if (this.activationSource == b.c)
      {
        d.b.d.a(com.viber.voip.registration.c.e.b.a());
        if ((!com.viber.voip.registration.c.e.d.a().equals(d.b.d.d())) && (!ao.f()))
          d.b.f.a(System.currentTimeMillis());
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.a);
        this.activationSource = null;
        ((com.viber.voip.analytics.story.f.d)this.mLazyOnboardingTracker.get()).a(d.bf.o.d(), this.mRegistrationValues.c(), LocaleListCompat.getDefault().get(0));
        String str = this.mUserManager.getRegistrationValues().e();
        List localList = Arrays.asList(new String[] { "IN", "PH", "VN", "MM", "NP", "TH", "ID", "MY", "PK", "LK", "BD" });
        d.af.c.a(localList.contains(str));
        e.a.n.a(System.currentTimeMillis());
        if (j == 2)
          com.viber.voip.analytics.story.k.a(1);
        com.viber.voip.backup.s locals = this.mRestoreAfterRegistrationController;
        if (j != 3)
          break label756;
        bool = true;
        locals.a(bool);
        if (j != 13)
          break label762;
      }
      for (int k = 11; ; k = 7)
      {
        setStep(k, true);
        return;
        if ((this.activationSource != b.a) && (this.activationSource != b.d) && (this.activationSource == null))
          break;
        d.b.d.a(com.viber.voip.registration.c.e.a.a());
        break;
        bool = false;
        break label689;
      }
    case 5:
      ViberActionRunner.au.a(e.a.o.d(), this.mContext);
      return;
    case 7:
    case 15:
      this.mUserInfoDuringRegistrationFetcher.a();
      ViberActionRunner.au.c(this.mContext);
      return;
    case 18:
      this.mRestoreAfterRegistrationController.a();
      return;
    case 19:
      ViberActionRunner.au.c(this.mContext);
      return;
    case 20:
      label689: label756: label762: ViberActionRunner.au.c(this.mContext);
      return;
    case 8:
    }
    ViberActionRunner.au.c(this.mContext);
    if (!com.viber.voip.backup.f.b().e().isBackupExists())
      com.viber.voip.analytics.story.k.a(8);
    d.j.i.a(cc.b());
    continueWelcomeFlowAfterRegistration();
    com.viber.voip.stickers.i.a().a(true);
  }

  public void resumeActivationWithDeepLink(Uri paramUri)
  {
    e.a.t.a(paramUri.toString());
    ViberActionRunner.b(this.mContext, ViberActionRunner.b(this.mContext));
  }

  public void saveKeychainParamsOnConnect()
  {
    try
    {
      String str2 = getKeyChainDeviceKey();
      String str3;
      if (str2 != null)
        str3 = z.a(str2);
      for (str1 = str3; ; str1 = "")
      {
        if (c.a.a.a.c.i())
        {
          com.crashlytics.android.a.a("keyOnConnect", str1);
          com.crashlytics.android.a.a("keychainUdidOnConnect", getKeyChainUDID());
        }
        return;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
        String str1 = "Invalid";
    }
  }

  void setActivatedSimSerial()
  {
    boolean bool = com.viber.common.permission.c.a(this.mContext).a(new String[] { "android.permission.READ_PHONE_STATE" });
    String str = null;
    if (bool)
      str = cg.a(this.mContext);
    if (str == null)
      str = "";
    e.a.p.a(str);
  }

  void setActivationCode(ActivationCode paramActivationCode)
  {
    this.activationCode = paramActivationCode;
    this.activationSource = paramActivationCode.source;
  }

  void setActivationStepToPref(int paramInt)
  {
    e.a.r.a(paramInt);
  }

  public void setAutoDismissTzintukCall(boolean paramBoolean)
  {
    this.mAutoDismissTzintukCall = paramBoolean;
  }

  void setCameFromSecondaryActivation(boolean paramBoolean)
  {
    e.a.o.a(paramBoolean);
  }

  public void setDeviceKey(String paramString)
  {
    this.mRegistrationValues.a().a(paramString);
  }

  public void setKeyChainDeviceKey(String paramString)
  {
    ao localao = this.mRegistrationValues.a();
    if (ao.f());
    for (ao.b localb = ao.b.c; ; localb = ao.b.a)
    {
      localao.a(localb, paramString);
      return;
    }
  }

  public void setKeyChainUDID(String paramString)
  {
    ao localao = this.mRegistrationValues.a();
    if (ao.f());
    for (ao.b localb = ao.b.d; ; localb = ao.b.b)
    {
      localao.a(localb, paramString);
      return;
    }
  }

  public void setMid(String paramString)
  {
    this.mRegistrationValues.a(paramString);
  }

  public void setStep(int paramInt, boolean paramBoolean)
  {
    if (ViberApplication.isActivated())
      if (n.a(paramInt, new int[] { 4, 1, 0 }))
        L.a(new IllegalStateException("Set activation step when activated. Step " + paramInt), "");
    setActivationStepToPref(paramInt);
    notifyActivationStateListeners(paramInt);
    if (paramBoolean)
      resumeActivation();
    while (paramInt != 8)
      return;
    handleDeferredDeepLink();
  }

  public void startRegistration(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, com.viber.voip.analytics.story.f.d paramd, w.a parama, byte paramByte)
  {
    this.mIsRegistrationMadeViaTzintuk = paramBoolean;
    this.mRegisterTask = new w(paramString1, paramString2, paramString3, paramString4, paramBoolean, paramd, parama, paramByte);
    this.mRegisterTask.execute(new String[0]);
  }

  public void storeRegNumberCanonized(String paramString)
  {
    this.mRegistrationValues.e(paramString);
  }

  public void storeRegValues(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mRegistrationValues.a(paramString1, paramString2, paramString3, paramString4);
  }

  public void unregisterActivationStateListener(c paramc)
  {
    synchronized (this.mStateChangeListeners)
    {
      this.mStateChangeListeners.remove(paramc);
      return;
    }
  }

  public static class ActivationCode
    implements Parcelable
  {
    public static final Parcelable.Creator<ActivationCode> CREATOR = new Parcelable.Creator()
    {
      public ActivationController.ActivationCode a(Parcel paramAnonymousParcel)
      {
        return new ActivationController.ActivationCode(paramAnonymousParcel);
      }

      public ActivationController.ActivationCode[] a(int paramAnonymousInt)
      {
        return new ActivationController.ActivationCode[paramAnonymousInt];
      }
    };
    public final String code;
    public final ActivationController.b source;

    protected ActivationCode(Parcel paramParcel)
    {
      this.code = paramParcel.readString();
      this.source = ActivationController.b.values()[paramParcel.readInt()];
    }

    public ActivationCode(String paramString, ActivationController.b paramb)
    {
      this.code = paramString;
      this.source = paramb;
    }

    public static boolean isEmpty(ActivationCode paramActivationCode)
    {
      return (paramActivationCode == null) || (da.a(paramActivationCode.code));
    }

    public int describeContents()
    {
      return 0;
    }

    public String toString()
    {
      return "ActivationCode{code='" + this.code + '\'' + ", source=" + this.source + '}';
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.code);
      paramParcel.writeInt(this.source.ordinal());
    }
  }

  public static abstract interface a
  {
    public abstract void a(ActivationController.ActivationCode paramActivationCode);
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[5];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
    }
  }

  public static abstract interface c
  {
    public abstract void onActivationStateChange(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ActivationController
 * JD-Core Version:    0.6.2
 */