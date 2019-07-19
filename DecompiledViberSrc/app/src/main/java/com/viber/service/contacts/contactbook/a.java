package com.viber.service.contacts.contactbook;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class a extends AbstractThreadedSyncAdapter
{
  private static final Logger a = ViberEnv.getLogger();

  public a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }

  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.contactbook.a
 * JD-Core Version:    0.6.2
 */