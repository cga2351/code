package com.viber.voip.notif.receivers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.text.TextUtils;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.n;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.c.b;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;

public class e
  implements d
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private final ai b;
  private final g c;

  e(ai paramai, g paramg)
  {
    this.b = paramai;
    this.c = paramg;
  }

  private void a(long paramLong1, long paramLong2, int paramInt, String paramString, CharSequence paramCharSequence)
  {
    MessageEntity localMessageEntity = new b(paramLong1, paramLong2, paramString, paramInt, 0).a(0, paramCharSequence.toString(), 0, null, 0);
    localMessageEntity.addExtraFlag(13);
    this.b.a(localMessageEntity, n.a(null, "Push"));
  }

  private void a(String paramString, int paramInt)
  {
    this.c.a(paramString, paramInt);
  }

  private void b(Intent paramIntent)
  {
    CharSequence localCharSequence = d(paramIntent);
    if (TextUtils.isEmpty(localCharSequence));
    MessageEntity localMessageEntity;
    int i;
    String str2;
    do
    {
      String str1;
      do
      {
        return;
        str1 = paramIntent.getStringExtra("member_id");
      }
      while (TextUtils.isEmpty(str1));
      a(paramIntent.getLongExtra("conversation_id", -1L), paramIntent.getLongExtra("group_id", -1L), paramIntent.getIntExtra("conversation_type", 0), str1, localCharSequence);
      localMessageEntity = (MessageEntity)paramIntent.getParcelableExtra("latest_message");
      i = paramIntent.getIntExtra("notification_id", 0);
      str2 = paramIntent.getStringExtra("notification_tag");
    }
    while (localMessageEntity == null);
    this.b.b(new aa(localMessageEntity));
    a(str2, i);
  }

  private void c(Intent paramIntent)
  {
    CharSequence localCharSequence = d(paramIntent);
    if (TextUtils.isEmpty(localCharSequence));
    long l;
    do
    {
      String str1;
      do
      {
        return;
        str1 = paramIntent.getStringExtra("member_id");
      }
      while (TextUtils.isEmpty(str1));
      a(0L, 0L, paramIntent.getIntExtra("conversation_type", 0), str1, localCharSequence);
      MessageEntity localMessageEntity = (MessageEntity)paramIntent.getParcelableExtra("latest_message");
      int i = paramIntent.getIntExtra("notification_id", 0);
      String str2 = paramIntent.getStringExtra("notification_tag");
      if (localMessageEntity != null)
      {
        this.b.b(new aa(localMessageEntity));
        a(str2, i);
      }
      l = paramIntent.getLongExtra("contact_id", -1L);
    }
    while (l <= 0L);
    this.c.a().a(l);
  }

  private CharSequence d(Intent paramIntent)
  {
    Bundle localBundle = RemoteInput.getResultsFromIntent(paramIntent);
    if (localBundle == null)
      return null;
    return localBundle.getCharSequence("remote_text_input");
  }

  public void a(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.viber.voip.action.INLINE_REPLY_MESSAGE_ACTION".equals(str))
      b(paramIntent);
    while (!"com.viber.voip.action.INLINE_SEND_MESSAGE_ACTION".equals(str))
      return;
    c(paramIntent);
  }

  public boolean a(String paramString)
  {
    return (paramString.equals("com.viber.voip.action.INLINE_REPLY_MESSAGE_ACTION")) || (paramString.equals("com.viber.voip.action.INLINE_SEND_MESSAGE_ACTION"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.receivers.e
 * JD-Core Version:    0.6.2
 */