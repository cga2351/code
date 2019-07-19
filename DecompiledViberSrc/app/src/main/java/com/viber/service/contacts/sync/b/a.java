package com.viber.service.contacts.sync.b;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.p;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ci;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private Application b;
  private HardwareParameters c;
  private af d;
  private AccountManager e;

  public a(Application paramApplication)
  {
    this.b = paramApplication;
    this.c = ViberApplication.getInstance().getHardwareParameters();
    this.d = UserManager.from(paramApplication).getRegistrationValues();
    this.e = AccountManager.get(this.b);
  }

  private Account a(ci<Account> paramci)
  {
    for (Account localAccount : this.e.getAccountsByType("com.viber.voip"))
      if (paramci.apply(localAccount))
        return localAccount;
    return null;
  }

  private void a(Intent paramIntent, Account paramAccount)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      AccountAuthenticatorResponse localAccountAuthenticatorResponse = (AccountAuthenticatorResponse)paramIntent.getExtras().getParcelable("accountAuthenticatorResponse");
      Bundle localBundle = new Bundle();
      localBundle.putString("authAccount", paramAccount.name);
      localBundle.putString("accountType", "com.viber.voip");
      if (localAccountAuthenticatorResponse != null)
        localAccountAuthenticatorResponse.onResult(localBundle);
    }
  }

  private void a(String paramString)
  {
    Account[] arrayOfAccount = this.e.getAccountsByType(paramString);
    int i = arrayOfAccount.length;
    int j = 0;
    while (true)
    {
      Account localAccount;
      if (j < i)
        localAccount = arrayOfAccount[j];
      try
      {
        this.e.removeAccount(localAccount, null, null);
        label39: j++;
        continue;
        return;
      }
      catch (SecurityException localSecurityException)
      {
        break label39;
      }
    }
  }

  private boolean f()
  {
    if (d.p.g.a())
      return d.p.g.d();
    return true;
  }

  private boolean g()
  {
    if (d.p.i.d() != 4)
    {
      e();
      return true;
    }
    return false;
  }

  // ERROR //
  private Account h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/viber/service/contacts/sync/b/a:c	Lcom/viber/voip/registration/HardwareParameters;
    //   4: invokeinterface 153 1 0
    //   9: astore 5
    //   11: new 97	android/accounts/Account
    //   14: dup
    //   15: aload_0
    //   16: getfield 54	com/viber/service/contacts/sync/b/a:d	Lcom/viber/voip/registration/af;
    //   19: invokevirtual 157	com/viber/voip/registration/af:h	()Ljava/lang/String;
    //   22: ldc 65
    //   24: invokespecial 159	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 62	com/viber/service/contacts/sync/b/a:e	Landroid/accounts/AccountManager;
    //   32: aload_2
    //   33: aload 5
    //   35: aconst_null
    //   36: invokevirtual 163	android/accounts/AccountManager:addAccountExplicitly	(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   39: istore 6
    //   41: aload_2
    //   42: astore_3
    //   43: iload 6
    //   45: istore 4
    //   47: iload 4
    //   49: ifeq +21 -> 70
    //   52: aload_3
    //   53: ldc 165
    //   55: iconst_1
    //   56: invokestatic 171	android/content/ContentResolver:setSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;Z)V
    //   59: getstatic 136	com/viber/voip/settings/d$p:i	Lcom/viber/common/b/d;
    //   62: iconst_4
    //   63: invokevirtual 174	com/viber/common/b/d:a	(I)V
    //   66: lconst_0
    //   67: invokestatic 179	com/viber/voip/util/ViberActionRunner$p:b	(J)V
    //   70: iload 4
    //   72: ifeq +27 -> 99
    //   75: aload_3
    //   76: areturn
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_2
    //   80: getstatic 24	com/viber/service/contacts/sync/b/a:a	Lcom/viber/dexshared/Logger;
    //   83: aload_1
    //   84: ldc 181
    //   86: invokeinterface 186 3 0
    //   91: aload_2
    //   92: astore_3
    //   93: iconst_0
    //   94: istore 4
    //   96: goto -49 -> 47
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: goto -22 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   0	28	77	java/lang/Exception
    //   28	41	101	java/lang/Exception
  }

  private Account i()
  {
    return a(new ci()
    {
      public boolean a(Account paramAnonymousAccount)
      {
        return !paramAnonymousAccount.name.equals(this.a);
      }
    });
  }

  public void a()
  {
    a(null);
  }

  public void a(Intent paramIntent)
  {
    boolean bool = true;
    if (ViberApplication.isActivated())
    {
      this.d.a();
      if (ao.g());
    }
    else
    {
      d.p.g.a(bool);
      if (d())
        e();
    }
    while (true)
    {
      return;
      if (!f())
        break;
      if ((!d()) || (g()))
      {
        Account localAccount = h();
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getParcelable("accountAuthenticatorResponse") != null));
        while ((bool) && (localAccount != null))
        {
          a(paramIntent, localAccount);
          return;
          bool = false;
        }
      }
    }
    e();
  }

  public void b()
  {
    Account localAccount;
    if (f())
    {
      localAccount = i();
      if (localAccount != null);
    }
    else
    {
      return;
    }
    this.e.removeAccount(localAccount, new AccountManagerCallback()
    {
      public void run(AccountManagerFuture<Boolean> paramAnonymousAccountManagerFuture)
      {
        com.viber.service.contacts.sync.a.a().a(true);
      }
    }
    , null);
  }

  public Account c()
  {
    return a(new ci()
    {
      public boolean a(Account paramAnonymousAccount)
      {
        return paramAnonymousAccount.name.equals(this.a);
      }
    });
  }

  public boolean d()
  {
    Account[] arrayOfAccount = this.e.getAccountsByType(this.b.getString(R.string.ACCOUNT_TYPE));
    return (arrayOfAccount != null) && (arrayOfAccount.length > 0);
  }

  public void e()
  {
    a(this.b.getString(R.string.ACCOUNT_TYPE));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.b.a
 * JD-Core Version:    0.6.2
 */