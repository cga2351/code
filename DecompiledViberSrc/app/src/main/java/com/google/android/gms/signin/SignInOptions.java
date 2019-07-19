package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class SignInOptions
  implements Api.ApiOptions.Optional
{
  public static final SignInOptions DEFAULT = new SignInOptions(false, false, null, false, null, false, null, null);
  private final boolean zaaa = false;
  private final String zaab = null;
  private final String zaac = null;
  private final boolean zars = false;
  private final boolean zart = false;
  private final Long zaru = null;
  private final Long zarv = null;
  private final boolean zay = false;

  static
  {
    new zaa();
  }

  private SignInOptions(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, String paramString2, boolean paramBoolean4, Long paramLong1, Long paramLong2)
  {
  }

  public final Long getAuthApiSignInModuleVersion()
  {
    return this.zaru;
  }

  public final String getHostedDomain()
  {
    return this.zaac;
  }

  public final Long getRealClientLibraryVersion()
  {
    return this.zarv;
  }

  public final String getServerClientId()
  {
    return this.zaab;
  }

  public final boolean isForceCodeForRefreshToken()
  {
    return this.zaaa;
  }

  public final boolean isIdTokenRequested()
  {
    return this.zay;
  }

  public final boolean isOfflineAccessRequested()
  {
    return this.zars;
  }

  public final boolean waitForAccessTokenRefresh()
  {
    return this.zart;
  }

  public static final class zaa
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.SignInOptions
 * JD-Core Version:    0.6.2
 */