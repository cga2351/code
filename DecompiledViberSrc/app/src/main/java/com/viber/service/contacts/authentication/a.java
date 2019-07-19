package com.viber.service.contacts.authentication;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.p;

public class a extends AbstractAccountAuthenticator
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.service.contacts.sync.b.a b;

  public a(Application paramApplication)
  {
    super(paramApplication.getApplicationContext());
    this.b = new com.viber.service.contacts.sync.b.a(paramApplication);
  }

  public Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
    throws NetworkErrorException
  {
    Bundle localBundle = new Bundle();
    if (ao.g())
    {
      if (ViberApplication.isActivated())
        break label40;
      localBundle.putParcelable("intent", new Intent("com.viber.voip.action.DEFAULT"));
    }
    label40: 
    while (this.b.d())
      return localBundle;
    com.viber.service.contacts.sync.a.a().a(true);
    return localBundle;
  }

  public Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
  {
    return null;
  }

  public Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
  {
    return null;
  }

  public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount)
    throws NetworkErrorException
  {
    Bundle localBundle = super.getAccountRemovalAllowed(paramAccountAuthenticatorResponse, paramAccount);
    if ((localBundle != null) && (localBundle.containsKey("booleanResult")) && (!localBundle.containsKey("intent")) && (localBundle.getBoolean("booleanResult")))
    {
      if (ViberApplication.isActivated())
        d.p.g.a(false);
    }
    else
      return localBundle;
    d.p.g.e();
    return localBundle;
  }

  public Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    throws NetworkErrorException
  {
    return null;
  }

  public String getAuthTokenLabel(String paramString)
  {
    return null;
  }

  public Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
    throws NetworkErrorException
  {
    return null;
  }

  public Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.authentication.a
 * JD-Core Version:    0.6.2
 */