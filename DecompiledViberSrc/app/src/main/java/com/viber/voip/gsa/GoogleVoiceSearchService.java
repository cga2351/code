package com.viber.voip.gsa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.h;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.j;

public class GoogleVoiceSearchService extends SearchActionVerificationClientService
{
  private static final Logger a = ViberEnv.getLogger();

  public boolean a(Intent paramIntent, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean);
    String str1;
    String str2;
    String str3;
    do
    {
      return false;
      paramIntent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_NAME");
      str1 = paramIntent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
      str2 = paramIntent.getStringExtra("android.intent.extra.TEXT");
      str3 = paramIntent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI");
    }
    while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    com.viber.voip.model.entity.g localg = ViberApplication.getInstance().getContactManager().c().a(str1);
    j localj = localg.a(str1);
    if ((localg != null) && (localj != null))
    {
      MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.b(0L, localj.a(), 0, 0).a(0, str2, 0, null, 0);
      ViberApplication.getInstance().getMessagesManager().c().a(localMessageEntity, null);
    }
    if (!TextUtils.isEmpty(str3))
    {
      long l = Long.parseLong(Uri.parse(str3).getLastPathSegment());
      ContactsContract.Contacts.markAsContacted(getContentResolver(), l);
    }
    return true;
  }

  public boolean b()
  {
    return false;
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new b(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new a(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gsa.GoogleVoiceSearchService
 * JD-Core Version:    0.6.2
 */