package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;

public final class zzo
  implements CapabilityApi
{
  private static PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return zzb.zza(paramGoogleApiClient, new zzt(paramArrayOfIntentFilter), paramCapabilityListener);
  }

  public final PendingResult<Status> addCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    Asserts.checkNotNull(paramString, "capability must not be null");
    zzv localzzv = new zzv(paramCapabilityListener, paramString);
    IntentFilter localIntentFilter = zzgj.zzc("com.google.android.gms.wearable.CAPABILITY_CHANGED");
    String str1;
    if (!paramString.startsWith("/"))
    {
      String str2 = String.valueOf(paramString);
      if (str2.length() != 0)
        str1 = "/".concat(str2);
    }
    while (true)
    {
      localIntentFilter.addDataPath(str1, 0);
      return zza(paramGoogleApiClient, localzzv, new IntentFilter[] { localIntentFilter });
      str1 = new String("/");
      continue;
      str1 = paramString;
    }
  }

  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, Uri paramUri, int paramInt)
  {
    Asserts.checkNotNull(paramUri, "uri must not be null");
    if ((paramInt == 0) || (paramInt == 1));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid filter type");
      return zza(paramGoogleApiClient, paramCapabilityListener, new IntentFilter[] { zzgj.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", paramUri, paramInt) });
    }
  }

  public final PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.enqueue(new zzr(this, paramGoogleApiClient, paramString));
  }

  public final PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    int i = 1;
    if ((paramInt == 0) || (paramInt == i));
    while (true)
    {
      Preconditions.checkArgument(i);
      return paramGoogleApiClient.enqueue(new zzq(this, paramGoogleApiClient, paramInt));
      i = 0;
    }
  }

  public final PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient paramGoogleApiClient, String paramString, int paramInt)
  {
    int i = 1;
    if ((paramInt == 0) || (paramInt == i));
    while (true)
    {
      Preconditions.checkArgument(i);
      return paramGoogleApiClient.enqueue(new zzp(this, paramGoogleApiClient, paramString, paramInt));
      i = 0;
    }
  }

  public final PendingResult<Status> removeCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    return paramGoogleApiClient.enqueue(new zzz(paramGoogleApiClient, new zzv(paramCapabilityListener, paramString), null));
  }

  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener)
  {
    return paramGoogleApiClient.enqueue(new zzz(paramGoogleApiClient, paramCapabilityListener, null));
  }

  public final PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.enqueue(new zzs(this, paramGoogleApiClient, paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzo
 * JD-Core Version:    0.6.2
 */