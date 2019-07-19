package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.tasks.Task;

public class WorkAccountClient extends GoogleApi<Api.ApiOptions.NoOptions>
{
  private final WorkAccountApi zzac = new zzh();

  WorkAccountClient(Activity paramActivity)
  {
    super(paramActivity, WorkAccount.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }

  WorkAccountClient(Context paramContext)
  {
    super(paramContext, WorkAccount.API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
  }

  public Task<Account> addWorkAccount(String paramString)
  {
    return PendingResultUtil.toTask(this.zzac.addWorkAccount(asGoogleApiClient(), paramString), new zzg(this));
  }

  public Task<Void> removeWorkAccount(Account paramAccount)
  {
    return PendingResultUtil.toVoidTask(this.zzac.removeWorkAccount(asGoogleApiClient(), paramAccount));
  }

  public Task<Void> setWorkAuthenticatorEnabled(boolean paramBoolean)
  {
    return PendingResultUtil.toVoidTask(this.zzac.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), paramBoolean));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.account.WorkAccountClient
 * JD-Core Version:    0.6.2
 */