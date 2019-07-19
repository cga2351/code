package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder;

public final class CredentialsOptions extends Auth.AuthCredentialsOptions
{
  public static final CredentialsOptions DEFAULT = (CredentialsOptions)new Builder().zzc();

  private CredentialsOptions(Builder paramBuilder)
  {
    super(paramBuilder);
  }

  public static final class Builder extends Auth.AuthCredentialsOptions.Builder
  {
    public final CredentialsOptions build()
    {
      return new CredentialsOptions(this, null);
    }

    public final Builder forceEnableSaveDialog()
    {
      this.zzn = Boolean.valueOf(true);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialsOptions
 * JD-Core Version:    0.6.2
 */