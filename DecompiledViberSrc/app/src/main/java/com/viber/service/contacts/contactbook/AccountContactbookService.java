package com.viber.service.contacts.contactbook;

import android.content.Intent;
import android.os.IBinder;
import com.viber.service.ViberService;

public class AccountContactbookService extends ViberService
{
  private static final Object a = new Object();
  private static a b = null;

  public IBinder onBind(Intent paramIntent)
  {
    return b.getSyncAdapterBinder();
  }

  public void onCreate()
  {
    synchronized (a)
    {
      if (b == null)
        b = new a(getApplicationContext(), true);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.contactbook.AccountContactbookService
 * JD-Core Version:    0.6.2
 */