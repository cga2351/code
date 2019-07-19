package com.google.a.a.b.a.a.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.google.a.a.f.z;

public final class a
{
  private final AccountManager a;

  public a(AccountManager paramAccountManager)
  {
    this.a = ((AccountManager)z.a(paramAccountManager));
  }

  public a(Context paramContext)
  {
    this(AccountManager.get(paramContext));
  }

  public Account a(String paramString)
  {
    if (paramString != null)
      for (Account localAccount : a())
        if (paramString.equals(localAccount.name))
          return localAccount;
    return null;
  }

  public Account[] a()
  {
    return this.a.getAccountsByType("com.google");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.b.a.a.a.a
 * JD-Core Version:    0.6.2
 */