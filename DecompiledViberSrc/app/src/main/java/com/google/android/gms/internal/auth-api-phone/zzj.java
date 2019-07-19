package com.google.android.gms.internal.auth-api-phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.Task;

public final class zzj extends SmsRetrieverClient
{
  public zzj(Activity paramActivity)
  {
    super(paramActivity);
  }

  public zzj(Context paramContext)
  {
    super(paramContext);
  }

  public final Task<Void> startSmsRetriever()
  {
    return doWrite(new zzk(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api-phone.zzj
 * JD-Core Version:    0.6.2
 */