package com.google.android.gms.internal.auth-api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

public final class zzq
{
  public static PendingIntent zzc(Context paramContext, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, HintRequest paramHintRequest)
  {
    Preconditions.checkNotNull(paramContext, "context must not be null");
    Preconditions.checkNotNull(paramHintRequest, "request must not be null");
    if (paramAuthCredentialsOptions == null);
    Intent localIntent = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", null);
    SafeParcelableSerializer.serializeToIntentExtra(paramHintRequest, localIntent, "com.google.android.gms.credentials.HintRequest");
    return PendingIntent.getActivity(paramContext, 2000, localIntent, 134217728);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzq
 * JD-Core Version:    0.6.2
 */