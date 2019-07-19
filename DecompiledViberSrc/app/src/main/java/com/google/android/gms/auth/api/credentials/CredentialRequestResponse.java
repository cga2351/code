package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Response;

public class CredentialRequestResponse extends Response<CredentialRequestResult>
{
  public Credential getCredential()
  {
    return ((CredentialRequestResult)getResult()).getCredential();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequestResponse
 * JD-Core Version:    0.6.2
 */