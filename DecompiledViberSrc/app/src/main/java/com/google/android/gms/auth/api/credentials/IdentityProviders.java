package com.google.android.gms.auth.api.credentials;

import android.accounts.Account;
import com.google.android.gms.common.internal.Preconditions;

public final class IdentityProviders
{
  public static final String FACEBOOK = "https://www.facebook.com";
  public static final String GOOGLE = "https://accounts.google.com";
  public static final String LINKEDIN = "https://www.linkedin.com";
  public static final String MICROSOFT = "https://login.live.com";
  public static final String PAYPAL = "https://www.paypal.com";
  public static final String TWITTER = "https://twitter.com";
  public static final String YAHOO = "https://login.yahoo.com";

  public static final String getIdentityProviderForAccount(Account paramAccount)
  {
    Preconditions.checkNotNull(paramAccount, "account cannot be null");
    if ("com.google".equals(paramAccount.type))
      return "https://accounts.google.com";
    if ("com.facebook.auth.login".equals(paramAccount.type))
      return "https://www.facebook.com";
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.IdentityProviders
 * JD-Core Version:    0.6.2
 */