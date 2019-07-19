package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzr;

public class WorkAccount
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("WorkAccount.API", CLIENT_BUILDER, CLIENT_KEY);
  private static final Api.AbstractClientBuilder<zzr, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zzr> CLIENT_KEY = new Api.ClientKey();

  @Deprecated
  public static final WorkAccountApi WorkAccountApi = new zzh();

  static
  {
    CLIENT_BUILDER = new zzf();
  }

  public static WorkAccountClient getClient(Activity paramActivity)
  {
    return new WorkAccountClient(paramActivity);
  }

  public static WorkAccountClient getClient(Context paramContext)
  {
    return new WorkAccountClient(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.account.WorkAccount
 * JD-Core Version:    0.6.2
 */