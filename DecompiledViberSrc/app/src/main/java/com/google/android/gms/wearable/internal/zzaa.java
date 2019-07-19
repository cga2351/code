package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;
import com.google.android.gms.wearable.CapabilityInfo;
import java.util.Map;

public final class zzaa extends CapabilityClient
{
  private final CapabilityApi zzbw = new zzo();

  public zzaa(Activity paramActivity, GoogleApi.Settings paramSettings)
  {
    super(paramActivity, paramSettings);
  }

  public zzaa(Context paramContext, GoogleApi.Settings paramSettings)
  {
    super(paramContext, paramSettings);
  }

  private final Task<Void> zza(ListenerHolder<CapabilityClient.OnCapabilityChangedListener> paramListenerHolder, CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return doRegisterEventListener(new zzaf(paramOnCapabilityChangedListener, paramArrayOfIntentFilter, paramListenerHolder, null), new zzag(paramOnCapabilityChangedListener, paramListenerHolder.getListenerKey(), null));
  }

  public final Task<Void> addListener(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, Uri paramUri, int paramInt)
  {
    Asserts.checkNotNull(paramOnCapabilityChangedListener, "listener must not be null");
    Asserts.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      IntentFilter localIntentFilter = zzgj.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", paramUri, paramInt);
      return zza(ListenerHolders.createListenerHolder(paramOnCapabilityChangedListener, getLooper(), "CapabilityListener"), paramOnCapabilityChangedListener, new IntentFilter[] { localIntentFilter });
    }
  }

  public final Task<Void> addListener(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, String paramString)
  {
    Asserts.checkNotNull(paramOnCapabilityChangedListener, "listener must not be null");
    Asserts.checkNotNull(paramString, "capability must not be null");
    IntentFilter localIntentFilter = zzgj.zzc("com.google.android.gms.wearable.CAPABILITY_CHANGED");
    String str1;
    if (!paramString.startsWith("/"))
    {
      String str4 = String.valueOf(paramString);
      if (str4.length() != 0)
        str1 = "/".concat(str4);
    }
    while (true)
    {
      localIntentFilter.addDataPath(str1, 0);
      IntentFilter[] arrayOfIntentFilter = { localIntentFilter };
      Looper localLooper = getLooper();
      String str2 = String.valueOf(str1);
      if (str2.length() != 0);
      for (String str3 = "CapabilityListener:".concat(str2); ; str3 = new String("CapabilityListener:"))
      {
        return zza(ListenerHolders.createListenerHolder(paramOnCapabilityChangedListener, localLooper, str3), new zzae(paramOnCapabilityChangedListener, str1), arrayOfIntentFilter);
        str1 = new String("/");
        break;
      }
      str1 = paramString;
    }
  }

  public final Task<Void> addLocalCapability(String paramString)
  {
    Asserts.checkNotNull(paramString, "capability must not be null");
    return PendingResultUtil.toVoidTask(this.zzbw.addLocalCapability(asGoogleApiClient(), paramString));
  }

  public final Task<Map<String, CapabilityInfo>> getAllCapabilities(int paramInt)
  {
    return PendingResultUtil.toTask(this.zzbw.getAllCapabilities(asGoogleApiClient(), paramInt), zzac.zzbx);
  }

  public final Task<CapabilityInfo> getCapability(String paramString, int paramInt)
  {
    Asserts.checkNotNull(paramString, "capability must not be null");
    return PendingResultUtil.toTask(this.zzbw.getCapability(asGoogleApiClient(), paramString, paramInt), zzab.zzbx);
  }

  public final Task<Boolean> removeListener(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener)
  {
    Asserts.checkNotNull(paramOnCapabilityChangedListener, "listener must not be null");
    return doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnCapabilityChangedListener, getLooper(), "CapabilityListener").getListenerKey());
  }

  public final Task<Boolean> removeListener(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, String paramString)
  {
    Asserts.checkNotNull(paramOnCapabilityChangedListener, "listener must not be null");
    Asserts.checkNotNull(paramString, "capability must not be null");
    String str1;
    if (!paramString.startsWith("/"))
    {
      String str4 = String.valueOf(paramString);
      if (str4.length() != 0)
        str1 = "/".concat(str4);
    }
    while (true)
    {
      Looper localLooper = getLooper();
      String str2 = String.valueOf(str1);
      if (str2.length() != 0);
      for (String str3 = "CapabilityListener:".concat(str2); ; str3 = new String("CapabilityListener:"))
      {
        return doUnregisterEventListener(ListenerHolders.createListenerHolder(paramOnCapabilityChangedListener, localLooper, str3).getListenerKey());
        str1 = new String("/");
        break;
      }
      str1 = paramString;
    }
  }

  public final Task<Void> removeLocalCapability(String paramString)
  {
    Asserts.checkNotNull(paramString, "capability must not be null");
    return PendingResultUtil.toVoidTask(this.zzbw.removeLocalCapability(asGoogleApiClient(), paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaa
 * JD-Core Version:    0.6.2
 */