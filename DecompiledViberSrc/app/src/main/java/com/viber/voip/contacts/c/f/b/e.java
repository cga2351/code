package com.viber.voip.contacts.c.f.b;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncAdapterType;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class e
{
  private static final Logger a = ViberEnv.getLogger();

  public static boolean a(Context paramContext)
  {
    AccountManager localAccountManager = AccountManager.get(paramContext.getApplicationContext());
    while (true)
    {
      int j;
      int k;
      try
      {
        SyncAdapterType[] arrayOfSyncAdapterType = ContentResolver.getSyncAdapterTypes();
        int i = arrayOfSyncAdapterType.length;
        j = 0;
        boolean bool1 = false;
        if (j < i)
        {
          SyncAdapterType localSyncAdapterType = arrayOfSyncAdapterType[j];
          Account[] arrayOfAccount = localAccountManager.getAccountsByType(localSyncAdapterType.accountType);
          k = 0;
          if (k >= arrayOfAccount.length)
            break label153;
          if (ContentResolver.getIsSyncable(arrayOfAccount[k], localSyncAdapterType.authority) > 0)
          {
            m = 1;
            boolean bool2 = ContentResolver.isSyncActive(arrayOfAccount[k], localSyncAdapterType.authority);
            boolean bool3 = ContentResolver.isSyncPending(arrayOfAccount[k], localSyncAdapterType.authority);
            if ((m == 0) || (!bool2) || (bool3))
              break label147;
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        a.a(localRuntimeException, "isExternalSyncActive(): the ContentService should always be reachable");
        return false;
      }
      int m = 0;
      continue;
      label147: k++;
      continue;
      label153: j++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b.e
 * JD-Core Version:    0.6.2
 */