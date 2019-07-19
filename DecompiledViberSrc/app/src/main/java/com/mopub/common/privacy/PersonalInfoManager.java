package com.mopub.common.privacy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.ConsentLogEvent;
import com.mopub.common.util.ManifestUtils;
import com.mopub.mobileads.MoPubConversionTracker;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.network.MoPubRequestQueue;
import com.mopub.network.MultiAdResponse;
import com.mopub.network.MultiAdResponse.ServerOverrideListener;
import com.mopub.network.Networking;
import com.mopub.volley.VolleyError;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PersonalInfoManager
{
  private final Context a;
  private final Set<ConsentStatusChangeListener> b;
  private final c c;
  private final ConsentDialogController d;
  private final MoPubConversionTracker e;
  private final SyncRequest.Listener f;
  private MultiAdResponse.ServerOverrideListener g;
  private SdkInitializationListener h;
  private long i = 300000L;
  private Long j;
  private ConsentStatus k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;

  public PersonalInfoManager(Context paramContext, String paramString, SdkInitializationListener paramSdkInitializationListener)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    this.a = paramContext.getApplicationContext();
    this.b = Collections.synchronizedSet(new HashSet());
    this.f = new b(null);
    this.g = new a(null);
    MultiAdResponse.setServerOverrideListener(this.g);
    this.d = new ConsentDialogController(this.a);
    this.c = new c(this.a, paramString);
    this.e = new MoPubConversionTracker(this.a);
    MoPubIdentifier.AdvertisingIdChangeListener local1 = new MoPubIdentifier.AdvertisingIdChangeListener()
    {
      public void onIdChanged(AdvertisingId paramAnonymousAdvertisingId1, AdvertisingId paramAnonymousAdvertisingId2)
      {
        Preconditions.checkNotNull(paramAnonymousAdvertisingId1);
        Preconditions.checkNotNull(paramAnonymousAdvertisingId2);
        if ((paramAnonymousAdvertisingId1.isDoNotTrack()) && (paramAnonymousAdvertisingId2.isDoNotTrack()));
        do
        {
          return;
          if ((!paramAnonymousAdvertisingId1.isDoNotTrack()) && (paramAnonymousAdvertisingId2.isDoNotTrack()))
          {
            PersonalInfoManager.a(PersonalInfoManager.this, ConsentStatus.DNT, ConsentChangeReason.DENIED_BY_DNT_ON);
            PersonalInfoManager.this.requestSync(true);
            return;
          }
          if ((paramAnonymousAdvertisingId1.isDoNotTrack()) && (!paramAnonymousAdvertisingId2.isDoNotTrack()))
          {
            if (ConsentStatus.EXPLICIT_NO.equals(PersonalInfoManager.a(PersonalInfoManager.this).l()))
            {
              PersonalInfoManager.a(PersonalInfoManager.this, ConsentStatus.EXPLICIT_NO, ConsentChangeReason.DNT_OFF);
              return;
            }
            PersonalInfoManager.a(PersonalInfoManager.this, ConsentStatus.UNKNOWN, ConsentChangeReason.DNT_OFF);
            return;
          }
        }
        while ((TextUtils.isEmpty(paramAnonymousAdvertisingId2.b)) || (paramAnonymousAdvertisingId2.a().equals(PersonalInfoManager.a(PersonalInfoManager.this).j())) || (!ConsentStatus.EXPLICIT_YES.equals(PersonalInfoManager.a(PersonalInfoManager.this).c())));
        PersonalInfoManager.a(PersonalInfoManager.this).b(null);
        PersonalInfoManager.a(PersonalInfoManager.this).l(null);
        PersonalInfoManager.a(PersonalInfoManager.this, ConsentStatus.UNKNOWN, ConsentChangeReason.IFA_CHANGED);
      }
    };
    this.h = paramSdkInitializationListener;
    MoPubIdentifier localMoPubIdentifier = ClientMetadata.getInstance(this.a).getMoPubIdentifier();
    localMoPubIdentifier.setIdChangeListener(local1);
    localMoPubIdentifier.a(b());
  }

  private void a(ConsentStatus paramConsentStatus, ConsentChangeReason paramConsentChangeReason)
  {
    a(paramConsentStatus, paramConsentChangeReason.getReason());
  }

  private void a(final ConsentStatus paramConsentStatus1, final ConsentStatus paramConsentStatus2, final boolean paramBoolean)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext())
      {
        final ConsentStatusChangeListener localConsentStatusChangeListener = (ConsentStatusChangeListener)localIterator.next();
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            localConsentStatusChangeListener.onConsentStateChange(paramConsentStatus1, paramConsentStatus2, paramBoolean);
          }
        });
      }
    }
  }

  @VisibleForTesting
  static boolean a(boolean paramBoolean1, Boolean paramBoolean, boolean paramBoolean2, Long paramLong, long paramLong1, String paramString, boolean paramBoolean3)
  {
    boolean bool = true;
    if (paramBoolean1)
      bool = false;
    do
    {
      do
      {
        do
          return bool;
        while (paramBoolean == null);
        if (!paramBoolean.booleanValue())
          return false;
      }
      while (paramBoolean2);
      if ((paramBoolean3) && (TextUtils.isEmpty(paramString)))
        return false;
    }
    while ((paramLong == null) || (SystemClock.uptimeMillis() - paramLong.longValue() > paramLong1));
    return false;
  }

  private SdkInitializationListener b()
  {
    return new SdkInitializationListener()
    {
      public void onInitializationFinished()
      {
        MoPubLog.log(MoPubLog.ConsentLogEvent.CUSTOM, new Object[] { "MoPubIdentifier initialized." });
        AdvertisingId localAdvertisingId = ClientMetadata.getInstance(PersonalInfoManager.b(PersonalInfoManager.this)).getMoPubIdentifier().getAdvertisingInfo();
        if (!PersonalInfoManager.a(PersonalInfoManager.c(PersonalInfoManager.this), PersonalInfoManager.this.gdprApplies(), false, PersonalInfoManager.d(PersonalInfoManager.this), PersonalInfoManager.e(PersonalInfoManager.this), PersonalInfoManager.a(PersonalInfoManager.this).j(), localAdvertisingId.isDoNotTrack()))
          if (PersonalInfoManager.f(PersonalInfoManager.this) != null)
          {
            PersonalInfoManager.f(PersonalInfoManager.this).onInitializationFinished();
            PersonalInfoManager.a(PersonalInfoManager.this, null);
          }
        while (true)
        {
          new MoPubConversionTracker(PersonalInfoManager.b(PersonalInfoManager.this)).reportAppOpen(true);
          return;
          PersonalInfoManager.this.a();
        }
      }
    };
  }

  @VisibleForTesting
  void a()
  {
    MoPubLog.log(MoPubLog.ConsentLogEvent.SYNC_ATTEMPTED, new Object[0]);
    this.k = this.c.c();
    this.l = true;
    this.j = Long.valueOf(SystemClock.uptimeMillis());
    SyncUrlGenerator localSyncUrlGenerator = new SyncUrlGenerator(this.a, this.k.getValue());
    localSyncUrlGenerator.withAdUnitId(this.c.b()).withUdid(this.c.j()).withLastChangedMs(this.c.k()).withLastConsentStatus(this.c.d()).withConsentChangeReason(this.c.g()).withConsentedVendorListVersion(this.c.getConsentedVendorListVersion()).withConsentedPrivacyPolicyVersion(this.c.getConsentedPrivacyPolicyVersion()).withCachedVendorListIabHash(this.c.f()).withExtras(this.c.getExtras()).withGdprApplies(gdprApplies()).withForceGdprApplies(this.c.isForceGdprApplies());
    if (this.m)
    {
      this.n = true;
      localSyncUrlGenerator.withForceGdprAppliesChanged(Boolean.valueOf(true));
    }
    SyncRequest localSyncRequest = new SyncRequest(this.a, localSyncUrlGenerator.generateUrlString(Constants.HOST), this.f);
    Networking.getRequestQueue(this.a).add(localSyncRequest);
  }

  void a(ConsentStatus paramConsentStatus)
  {
    Preconditions.checkNotNull(paramConsentStatus);
    switch (6.a[paramConsentStatus.ordinal()])
    {
    default:
      MoPubLog.ConsentLogEvent localConsentLogEvent = MoPubLog.ConsentLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Invalid consent status: " + paramConsentStatus + ". This is a bug with the use of changeConsentStateFromDialog.");
      MoPubLog.log(localConsentLogEvent, arrayOfObject);
      return;
    case 1:
      a(paramConsentStatus, ConsentChangeReason.GRANTED_BY_USER);
      requestSync(true);
      return;
    case 2:
    }
    a(paramConsentStatus, ConsentChangeReason.DENIED_BY_USER);
    requestSync(true);
  }

  @VisibleForTesting
  void a(ConsentStatus paramConsentStatus, String paramString)
  {
    Preconditions.checkNotNull(paramConsentStatus);
    Preconditions.checkNotNull(paramString);
    ConsentStatus localConsentStatus = this.c.c();
    if (localConsentStatus.equals(paramConsentStatus))
    {
      MoPubLog.ConsentLogEvent localConsentLogEvent2 = MoPubLog.ConsentLogEvent.CUSTOM;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = ("Consent status is already " + localConsentStatus + ". Not doing a state transition.");
      MoPubLog.log(localConsentLogEvent2, arrayOfObject2);
      return;
    }
    this.c.l("" + Calendar.getInstance().getTimeInMillis());
    this.c.j(paramString);
    this.c.a(paramConsentStatus);
    if ((ConsentStatus.POTENTIAL_WHITELIST.equals(paramConsentStatus)) || ((!ConsentStatus.POTENTIAL_WHITELIST.equals(localConsentStatus)) && (ConsentStatus.EXPLICIT_YES.equals(paramConsentStatus))))
    {
      this.c.h(this.c.getCurrentPrivacyPolicyVersion());
      this.c.g(this.c.getCurrentVendorListVersion());
      this.c.i(this.c.getCurrentVendorListIabFormat());
    }
    if ((ConsentStatus.DNT.equals(paramConsentStatus)) || (ConsentStatus.EXPLICIT_NO.equals(paramConsentStatus)) || (ConsentStatus.UNKNOWN.equals(paramConsentStatus)))
    {
      this.c.h(null);
      this.c.g(null);
      this.c.i(null);
    }
    if (ConsentStatus.EXPLICIT_YES.equals(paramConsentStatus))
      this.c.k(ClientMetadata.getInstance(this.a).getMoPubIdentifier().getAdvertisingInfo().a());
    if (ConsentStatus.DNT.equals(paramConsentStatus))
      this.c.c(localConsentStatus);
    this.c.b(false);
    this.c.a();
    boolean bool = canCollectPersonalInformation();
    if (bool)
    {
      ClientMetadata.getInstance(this.a).repopulateCountryData();
      if (this.e.shouldTrack())
        this.e.reportAppOpen(false);
    }
    MoPubLog.ConsentLogEvent localConsentLogEvent1 = MoPubLog.ConsentLogEvent.UPDATED;
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = localConsentStatus;
    arrayOfObject1[1] = paramConsentStatus;
    arrayOfObject1[2] = Boolean.valueOf(canCollectPersonalInformation());
    arrayOfObject1[3] = paramString;
    MoPubLog.log(localConsentLogEvent1, arrayOfObject1);
    a(localConsentStatus, paramConsentStatus, bool);
  }

  public boolean canCollectPersonalInformation()
  {
    boolean bool = true;
    Boolean localBoolean = gdprApplies();
    if (localBoolean == null)
      bool = false;
    while ((!localBoolean.booleanValue()) || ((getPersonalInfoConsentStatus().equals(ConsentStatus.EXPLICIT_YES)) && (!ClientMetadata.getInstance(this.a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())))
      return bool;
    return false;
  }

  public void forceGdprApplies()
  {
    if (this.c.isForceGdprApplies())
      return;
    boolean bool1 = canCollectPersonalInformation();
    this.c.c(true);
    this.m = true;
    this.c.a();
    boolean bool2 = canCollectPersonalInformation();
    if (bool1 != bool2)
      a(this.c.c(), this.c.c(), bool2);
    requestSync(true);
  }

  public Boolean gdprApplies()
  {
    if (this.c.isForceGdprApplies())
      return Boolean.valueOf(true);
    return this.c.i();
  }

  public ConsentData getConsentData()
  {
    return new c(this.a, this.c.b());
  }

  public ConsentStatus getPersonalInfoConsentStatus()
  {
    return this.c.c();
  }

  public void grantConsent()
  {
    if (ClientMetadata.getInstance(this.a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())
    {
      MoPubLog.log(MoPubLog.ConsentLogEvent.CUSTOM, new Object[] { "Cannot grant consent because Do Not Track is on." });
      return;
    }
    if (this.c.e())
      a(ConsentStatus.EXPLICIT_YES, ConsentChangeReason.GRANTED_BY_WHITELISTED_PUB);
    while (true)
    {
      requestSync(true);
      return;
      MoPubLog.log(MoPubLog.ConsentLogEvent.CUSTOM, new Object[] { "You do not have approval to use the grantConsent API. Please reach out to your account teams or support@mopub.com for more information." });
      a(ConsentStatus.POTENTIAL_WHITELIST, ConsentChangeReason.GRANTED_BY_NOT_WHITELISTED_PUB);
    }
  }

  public boolean isConsentDialogReady()
  {
    return this.d.b();
  }

  public void loadConsentDialog(final ConsentDialogListener paramConsentDialogListener)
  {
    MoPubLog.log(MoPubLog.ConsentLogEvent.LOAD_ATTEMPTED, new Object[0]);
    ManifestUtils.checkGdprActivitiesDeclared(this.a);
    if (ClientMetadata.getInstance(this.a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())
      if (paramConsentDialogListener != null)
        new Handler().post(new Runnable()
        {
          public void run()
          {
            MoPubLog.ConsentLogEvent localConsentLogEvent = MoPubLog.ConsentLogEvent.LOAD_FAILED;
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = Integer.valueOf(MoPubErrorCode.DO_NOT_TRACK.getIntCode());
            arrayOfObject[1] = MoPubErrorCode.DO_NOT_TRACK;
            MoPubLog.log(localConsentLogEvent, arrayOfObject);
            paramConsentDialogListener.onConsentDialogLoadFailed(MoPubErrorCode.DO_NOT_TRACK);
          }
        });
    Boolean localBoolean;
    do
    {
      return;
      localBoolean = gdprApplies();
      if ((localBoolean == null) || (localBoolean.booleanValue()))
        break;
    }
    while (paramConsentDialogListener == null);
    new Handler().post(new Runnable()
    {
      public void run()
      {
        MoPubLog.ConsentLogEvent localConsentLogEvent = MoPubLog.ConsentLogEvent.LOAD_FAILED;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(MoPubErrorCode.GDPR_DOES_NOT_APPLY.getIntCode());
        arrayOfObject[1] = MoPubErrorCode.GDPR_DOES_NOT_APPLY;
        MoPubLog.log(localConsentLogEvent, arrayOfObject);
        paramConsentDialogListener.onConsentDialogLoadFailed(MoPubErrorCode.GDPR_DOES_NOT_APPLY);
      }
    });
    return;
    this.d.a(paramConsentDialogListener, localBoolean, this.c);
  }

  public void requestSync(boolean paramBoolean)
  {
    if (!MoPub.isSdkInitialized());
    AdvertisingId localAdvertisingId;
    do
    {
      return;
      localAdvertisingId = ClientMetadata.getInstance(this.a).getMoPubIdentifier().getAdvertisingInfo();
    }
    while (!a(this.l, gdprApplies(), paramBoolean, this.j, this.i, this.c.j(), localAdvertisingId.isDoNotTrack()));
    a();
  }

  public void revokeConsent()
  {
    if (ClientMetadata.getInstance(this.a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())
    {
      MoPubLog.log(MoPubLog.ConsentLogEvent.CUSTOM, new Object[] { "Cannot revoke consent because Do Not Track is on." });
      return;
    }
    a(ConsentStatus.EXPLICIT_NO, ConsentChangeReason.DENIED_BY_PUB);
    requestSync(true);
  }

  public void setAllowLegitimateInterest(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public boolean shouldAllowLegitimateInterest()
  {
    return this.o;
  }

  public boolean shouldShowConsentDialog()
  {
    if ((gdprApplies() == null) || (!gdprApplies().booleanValue()));
    while (ClientMetadata.getInstance(this.a).getMoPubIdentifier().getAdvertisingInfo().isDoNotTrack())
      return false;
    if ((this.c.h()) && (this.c.c().equals(ConsentStatus.EXPLICIT_YES)))
      return true;
    return this.c.c().equals(ConsentStatus.UNKNOWN);
  }

  public boolean showConsentDialog()
  {
    return this.d.a();
  }

  public void subscribeConsentStatusChangeListener(ConsentStatusChangeListener paramConsentStatusChangeListener)
  {
    if (paramConsentStatusChangeListener == null)
      return;
    this.b.add(paramConsentStatusChangeListener);
  }

  public void unsubscribeConsentStatusChangeListener(ConsentStatusChangeListener paramConsentStatusChangeListener)
  {
    this.b.remove(paramConsentStatusChangeListener);
  }

  private class a
    implements MultiAdResponse.ServerOverrideListener
  {
    private a()
    {
    }

    public void onForceExplicitNo(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        PersonalInfoManager.a(PersonalInfoManager.this, ConsentStatus.EXPLICIT_NO, ConsentChangeReason.REVOKED_BY_SERVER);
        return;
      }
      PersonalInfoManager.this.a(ConsentStatus.EXPLICIT_NO, paramString);
    }

    public void onForceGdprApplies()
    {
      PersonalInfoManager.this.forceGdprApplies();
    }

    public void onInvalidateConsent(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        PersonalInfoManager.a(PersonalInfoManager.this, ConsentStatus.UNKNOWN, ConsentChangeReason.REACQUIRE_BY_SERVER);
        return;
      }
      PersonalInfoManager.this.a(ConsentStatus.UNKNOWN, paramString);
    }

    public void onReacquireConsent(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
        PersonalInfoManager.a(PersonalInfoManager.this).j(paramString);
      PersonalInfoManager.a(PersonalInfoManager.this).b(true);
      PersonalInfoManager.a(PersonalInfoManager.this).a();
    }
  }

  private class b
    implements SyncRequest.Listener
  {
    private b()
    {
    }

    public void onErrorResponse(VolleyError paramVolleyError)
    {
      int i;
      if ((paramVolleyError instanceof MoPubNetworkError))
      {
        i = ((MoPubNetworkError)paramVolleyError).getReason().ordinal();
        if (!(paramVolleyError instanceof MoPubNetworkError))
          break label127;
      }
      label127: for (String str = paramVolleyError.getMessage(); ; str = MoPubErrorCode.UNSPECIFIED.toString())
      {
        MoPubLog.ConsentLogEvent localConsentLogEvent = MoPubLog.ConsentLogEvent.SYNC_FAILED;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(i);
        arrayOfObject[1] = str;
        MoPubLog.log(localConsentLogEvent, arrayOfObject);
        PersonalInfoManager.c(PersonalInfoManager.this, false);
        if (PersonalInfoManager.f(PersonalInfoManager.this) != null)
        {
          MoPubLog.log(MoPubLog.ConsentLogEvent.CUSTOM, new Object[] { "Personal Info Manager initialization finished but ran into errors." });
          PersonalInfoManager.f(PersonalInfoManager.this).onInitializationFinished();
          PersonalInfoManager.a(PersonalInfoManager.this, null);
        }
        return;
        i = MoPubErrorCode.UNSPECIFIED.getIntCode();
        break;
      }
    }

    public void onSuccess(SyncResponse paramSyncResponse)
    {
      MoPubLog.log(MoPubLog.ConsentLogEvent.SYNC_COMPLETED, new Object[0]);
      boolean bool1 = PersonalInfoManager.this.canCollectPersonalInformation();
      if (PersonalInfoManager.a(PersonalInfoManager.this).i() == null)
        PersonalInfoManager.a(PersonalInfoManager.this).a(Boolean.valueOf(paramSyncResponse.isGdprRegion()));
      if (paramSyncResponse.isForceGdprApplies())
      {
        PersonalInfoManager.a(PersonalInfoManager.this, true);
        PersonalInfoManager.a(PersonalInfoManager.this).c(true);
        boolean bool2 = PersonalInfoManager.this.canCollectPersonalInformation();
        if (bool1 != bool2)
          PersonalInfoManager.a(PersonalInfoManager.this, PersonalInfoManager.a(PersonalInfoManager.this).c(), PersonalInfoManager.a(PersonalInfoManager.this).c(), bool2);
      }
      PersonalInfoManager.a(PersonalInfoManager.this).b(PersonalInfoManager.g(PersonalInfoManager.this));
      PersonalInfoManager.a(PersonalInfoManager.this).a(paramSyncResponse.isWhitelisted());
      PersonalInfoManager.a(PersonalInfoManager.this).a(paramSyncResponse.getCurrentVendorListVersion());
      PersonalInfoManager.a(PersonalInfoManager.this).b(paramSyncResponse.getCurrentVendorListLink());
      PersonalInfoManager.a(PersonalInfoManager.this).c(paramSyncResponse.getCurrentPrivacyPolicyVersion());
      PersonalInfoManager.a(PersonalInfoManager.this).d(paramSyncResponse.getCurrentPrivacyPolicyLink());
      String str1 = paramSyncResponse.getCurrentVendorListIabHash();
      String str2 = paramSyncResponse.getCurrentVendorListIabFormat();
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals(PersonalInfoManager.a(PersonalInfoManager.this).f())) && (!TextUtils.isEmpty(str2)))
      {
        PersonalInfoManager.a(PersonalInfoManager.this).e(str2);
        PersonalInfoManager.a(PersonalInfoManager.this).f(str1);
      }
      String str3 = paramSyncResponse.a();
      if (!TextUtils.isEmpty(str3))
        PersonalInfoManager.a(PersonalInfoManager.this).setExtras(str3);
      String str4 = paramSyncResponse.getConsentChangeReason();
      if (paramSyncResponse.isForceExplicitNo())
        PersonalInfoManager.h(PersonalInfoManager.this).onForceExplicitNo(str4);
      while (true)
      {
        String str5 = paramSyncResponse.getCallAgainAfterSecs();
        if (!TextUtils.isEmpty(str5));
        try
        {
          long l = Long.parseLong(str5);
          if (l > 0L)
            PersonalInfoManager.a(PersonalInfoManager.this, l * 1000L);
          while (true)
          {
            if (!ConsentStatus.EXPLICIT_YES.equals(PersonalInfoManager.g(PersonalInfoManager.this)))
              PersonalInfoManager.a(PersonalInfoManager.this).k(null);
            if (PersonalInfoManager.i(PersonalInfoManager.this))
            {
              PersonalInfoManager.a(PersonalInfoManager.this, false);
              PersonalInfoManager.b(PersonalInfoManager.this, false);
            }
            PersonalInfoManager.a(PersonalInfoManager.this).a();
            PersonalInfoManager.c(PersonalInfoManager.this, false);
            if ((ConsentStatus.POTENTIAL_WHITELIST.equals(PersonalInfoManager.g(PersonalInfoManager.this))) && (PersonalInfoManager.a(PersonalInfoManager.this).e()))
            {
              PersonalInfoManager.a(PersonalInfoManager.this, ConsentStatus.EXPLICIT_YES, ConsentChangeReason.GRANTED_BY_WHITELISTED_PUB);
              PersonalInfoManager.this.requestSync(true);
            }
            if (PersonalInfoManager.f(PersonalInfoManager.this) != null)
            {
              PersonalInfoManager.f(PersonalInfoManager.this).onInitializationFinished();
              PersonalInfoManager.a(PersonalInfoManager.this, null);
            }
            return;
            if (paramSyncResponse.isInvalidateConsent())
            {
              PersonalInfoManager.h(PersonalInfoManager.this).onInvalidateConsent(str4);
              break;
            }
            if (!paramSyncResponse.isReacquireConsent())
              break;
            PersonalInfoManager.h(PersonalInfoManager.this).onReacquireConsent(str4);
            break;
            MoPubLog.ConsentLogEvent localConsentLogEvent = MoPubLog.ConsentLogEvent.CUSTOM;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = ("callAgainAfterSecs is not positive: " + str5);
            MoPubLog.log(localConsentLogEvent, arrayOfObject);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          while (true)
            MoPubLog.log(MoPubLog.ConsentLogEvent.CUSTOM, new Object[] { "Unable to parse callAgainAfterSecs. Ignoring value" });
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.PersonalInfoManager
 * JD-Core Version:    0.6.2
 */