package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth-api.zzq;
import com.google.android.gms.tasks.Task;

public class CredentialsClient extends GoogleApi<Auth.AuthCredentialsOptions>
{
  CredentialsClient(Activity paramActivity, Auth.AuthCredentialsOptions paramAuthCredentialsOptions)
  {
    super(paramActivity, Auth.CREDENTIALS_API, paramAuthCredentialsOptions, new ApiExceptionMapper());
  }

  CredentialsClient(Context paramContext, Auth.AuthCredentialsOptions paramAuthCredentialsOptions)
  {
    super(paramContext, Auth.CREDENTIALS_API, paramAuthCredentialsOptions, new ApiExceptionMapper());
  }

  public Task<Void> delete(Credential paramCredential)
  {
    return PendingResultUtil.toVoidTask(Auth.CredentialsApi.delete(asGoogleApiClient(), paramCredential));
  }

  public Task<Void> disableAutoSignIn()
  {
    return PendingResultUtil.toVoidTask(Auth.CredentialsApi.disableAutoSignIn(asGoogleApiClient()));
  }

  public PendingIntent getHintPickerIntent(HintRequest paramHintRequest)
  {
    return zzq.zzc(getApplicationContext(), (Auth.AuthCredentialsOptions)getApiOptions(), paramHintRequest);
  }

  public Task<CredentialRequestResponse> request(CredentialRequest paramCredentialRequest)
  {
    return PendingResultUtil.toResponseTask(Auth.CredentialsApi.request(asGoogleApiClient(), paramCredentialRequest), new CredentialRequestResponse());
  }

  public Task<Void> save(Credential paramCredential)
  {
    return PendingResultUtil.toVoidTask(Auth.CredentialsApi.save(asGoogleApiClient(), paramCredential));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialsClient
 * JD-Core Version:    0.6.2
 */