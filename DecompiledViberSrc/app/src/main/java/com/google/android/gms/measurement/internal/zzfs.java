package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzfs
{
  final Context zzri;

  @VisibleForTesting
  public zzfs(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    Context localContext = paramContext.getApplicationContext();
    Preconditions.checkNotNull(localContext);
    this.zzri = localContext;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfs
 * JD-Core Version:    0.6.2
 */