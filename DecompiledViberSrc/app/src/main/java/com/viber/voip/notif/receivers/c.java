package com.viber.voip.notif.receivers;

import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.g;

public class c
  implements d
{
  private static final Logger a = ViberEnv.getLogger();
  private final ai b;
  private final g c;

  c(ai paramai, g paramg)
  {
    this.b = paramai;
    this.c = paramg;
  }

  private void a(String paramString, int paramInt)
  {
    this.c.a(paramString, paramInt);
  }

  public void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("notification_id", 0);
    String str = paramIntent.getStringExtra("notification_tag");
    MessageEntity localMessageEntity = (MessageEntity)paramIntent.getParcelableExtra("message_entity");
    if (localMessageEntity == null)
      return;
    this.b.a(localMessageEntity.getConversationId(), localMessageEntity.getConversationType(), false);
    this.b.a(new aa(localMessageEntity));
    a(str, i);
  }

  public boolean a(String paramString)
  {
    return paramString.equals("com.viber.voip.action.MARK_AS_READ");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.receivers.c
 * JD-Core Version:    0.6.2
 */