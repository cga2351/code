package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;

public class Credentials
{
  public static CredentialsClient getClient(Activity paramActivity)
  {
    return new CredentialsClient(paramActivity, CredentialsOptions.DEFAULT);
  }

  public static CredentialsClient getClient(Activity paramActivity, CredentialsOptions paramCredentialsOptions)
  {
    return new CredentialsClient(paramActivity, paramCredentialsOptions);
  }

  public static CredentialsClient getClient(Context paramContext)
  {
    return new CredentialsClient(paramContext, CredentialsOptions.DEFAULT);
  }

  public static CredentialsClient getClient(Context paramContext, CredentialsOptions paramCredentialsOptions)
  {
    return new CredentialsClient(paramContext, paramCredentialsOptions);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credentials
 * JD-Core Version:    0.6.2
 */