package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

final class zzb<T> extends zzn<Status>
{
  private T zzaw;
  private ListenerHolder<T> zzax;
  private zzc<T> zzay;

  private zzb(GoogleApiClient paramGoogleApiClient, T paramT, ListenerHolder<T> paramListenerHolder, zzc<T> paramzzc)
  {
    super(paramGoogleApiClient);
    this.zzaw = Preconditions.checkNotNull(paramT);
    this.zzax = ((ListenerHolder)Preconditions.checkNotNull(paramListenerHolder));
    this.zzay = ((zzc)Preconditions.checkNotNull(paramzzc));
  }

  static <T> PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, zzc<T> paramzzc, T paramT)
  {
    return paramGoogleApiClient.enqueue(new zzb(paramGoogleApiClient, paramT, paramGoogleApiClient.registerListener(paramT), paramzzc));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzb
 * JD-Core Version:    0.6.2
 */