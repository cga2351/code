package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public abstract interface GoogleSignInOptionsExtension
{

  @KeepForSdk
  public static final int FITNESS = 3;

  @KeepForSdk
  public static final int GAMES = 1;

  @KeepForSdk
  public abstract int getExtensionType();

  @KeepForSdk
  public abstract List<Scope> getImpliedScopes();

  public abstract Bundle toBundle();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
 * JD-Core Version:    0.6.2
 */