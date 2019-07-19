package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class Storage
{
  private static final Lock zaaj = new ReentrantLock();

  @GuardedBy("sLk")
  private static Storage zaak;
  private final Lock zaal = new ReentrantLock();

  @GuardedBy("mLk")
  private final SharedPreferences zaam;

  @VisibleForTesting
  private Storage(Context paramContext)
  {
    this.zaam = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }

  @KeepForSdk
  public static Storage getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    zaaj.lock();
    try
    {
      if (zaak == null)
        zaak = new Storage(paramContext.getApplicationContext());
      Storage localStorage = zaak;
      return localStorage;
    }
    finally
    {
      zaaj.unlock();
    }
  }

  private final void zaa(String paramString1, String paramString2)
  {
    this.zaal.lock();
    try
    {
      this.zaam.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      this.zaal.unlock();
    }
  }

  private static String zab(String paramString1, String paramString2)
  {
    return 1 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + paramString1 + ":" + paramString2;
  }

  @Nullable
  @VisibleForTesting
  private final GoogleSignInAccount zad(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    String str;
    do
    {
      return null;
      str = zaf(zab("googleSignInAccount", paramString));
    }
    while (str == null);
    try
    {
      GoogleSignInAccount localGoogleSignInAccount = GoogleSignInAccount.zaa(str);
      return localGoogleSignInAccount;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  @Nullable
  @VisibleForTesting
  private final GoogleSignInOptions zae(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    String str;
    do
    {
      return null;
      str = zaf(zab("googleSignInOptions", paramString));
    }
    while (str == null);
    try
    {
      GoogleSignInOptions localGoogleSignInOptions = GoogleSignInOptions.zab(str);
      return localGoogleSignInOptions;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  @Nullable
  private final String zaf(String paramString)
  {
    this.zaal.lock();
    try
    {
      String str = this.zaam.getString(paramString, null);
      return str;
    }
    finally
    {
      this.zaal.unlock();
    }
  }

  private final void zag(String paramString)
  {
    this.zaal.lock();
    try
    {
      this.zaam.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      this.zaal.unlock();
    }
  }

  @KeepForSdk
  public void clear()
  {
    this.zaal.lock();
    try
    {
      this.zaam.edit().clear().apply();
      return;
    }
    finally
    {
      this.zaal.unlock();
    }
  }

  @Nullable
  @KeepForSdk
  public GoogleSignInAccount getSavedDefaultGoogleSignInAccount()
  {
    return zad(zaf("defaultGoogleSignInAccount"));
  }

  @Nullable
  @KeepForSdk
  public GoogleSignInOptions getSavedDefaultGoogleSignInOptions()
  {
    return zae(zaf("defaultGoogleSignInAccount"));
  }

  @Nullable
  @KeepForSdk
  public String getSavedRefreshToken()
  {
    return zaf("refreshToken");
  }

  @KeepForSdk
  public void saveDefaultGoogleSignInAccount(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    zaa("defaultGoogleSignInAccount", paramGoogleSignInAccount.zab());
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zab();
    zaa(zab("googleSignInAccount", str), paramGoogleSignInAccount.zac());
    zaa(zab("googleSignInOptions", str), paramGoogleSignInOptions.zae());
  }

  public final void zaf()
  {
    String str = zaf("defaultGoogleSignInAccount");
    zag("defaultGoogleSignInAccount");
    if (!TextUtils.isEmpty(str))
    {
      zag(zab("googleSignInAccount", str));
      zag(zab("googleSignInOptions", str));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.Storage
 * JD-Core Version:    0.6.2
 */