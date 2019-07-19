package com.mopub.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.volley.AuthFailureError;

@SuppressLint({"MissingPermission"})
public class AndroidAuthenticator
  implements Authenticator
{
  private final AccountManager a;
  private final Account b;
  private final String c;
  private final boolean d;

  AndroidAuthenticator(AccountManager paramAccountManager, Account paramAccount, String paramString, boolean paramBoolean)
  {
    this.a = paramAccountManager;
    this.b = paramAccount;
    this.c = paramString;
    this.d = paramBoolean;
  }

  public AndroidAuthenticator(Context paramContext, Account paramAccount, String paramString)
  {
    this(paramContext, paramAccount, paramString, false);
  }

  public AndroidAuthenticator(Context paramContext, Account paramAccount, String paramString, boolean paramBoolean)
  {
    this(AccountManager.get(paramContext), paramAccount, paramString, paramBoolean);
  }

  public Account getAccount()
  {
    return this.b;
  }

  public String getAuthToken()
    throws AuthFailureError
  {
    AccountManagerFuture localAccountManagerFuture = this.a.getAuthToken(this.b, this.c, this.d, null, null);
    Bundle localBundle;
    try
    {
      localBundle = (Bundle)localAccountManagerFuture.getResult();
      boolean bool1 = localAccountManagerFuture.isDone();
      str = null;
      if (!bool1)
        break label110;
      boolean bool2 = localAccountManagerFuture.isCancelled();
      str = null;
      if (bool2)
        break label110;
      if (localBundle.containsKey("intent"))
        throw new AuthFailureError((Intent)localBundle.getParcelable("intent"));
    }
    catch (Exception localException)
    {
      throw new AuthFailureError("Error while retrieving auth token", localException);
    }
    String str = localBundle.getString("authtoken");
    label110: if (str == null)
      throw new AuthFailureError("Got null auth token for type: " + this.c);
    return str;
  }

  public String getAuthTokenType()
  {
    return this.c;
  }

  public void invalidateAuthToken(String paramString)
  {
    this.a.invalidateAuthToken(this.b.type, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.AndroidAuthenticator
 * JD-Core Version:    0.6.2
 */