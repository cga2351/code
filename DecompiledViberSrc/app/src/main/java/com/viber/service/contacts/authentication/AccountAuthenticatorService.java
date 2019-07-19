package com.viber.service.contacts.authentication;

import android.content.Intent;
import android.os.IBinder;
import com.viber.service.ViberService;

public class AccountAuthenticatorService extends ViberService
{
  private static a a;

  private a a()
  {
    if (a == null)
      a = new a(getApplication());
    return a;
  }

  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.accounts.AccountAuthenticator"))
      return a().getIBinder();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.authentication.AccountAuthenticatorService
 * JD-Core Version:    0.6.2
 */