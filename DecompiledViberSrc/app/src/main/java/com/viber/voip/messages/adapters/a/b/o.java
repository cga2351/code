package com.viber.voip.messages.adapters.a.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;

public class o extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private final ImageView a;

  public o(ImageView paramImageView)
  {
    this.a = paramImageView;
  }

  private int a(ConversationLoaderEntity paramConversationLoaderEntity)
  {
    int i = 2;
    if (paramConversationLoaderEntity.getMessageStatus() != i)
      i = 0;
    while (paramConversationLoaderEntity.isMessageRead())
      return i;
    return 1;
  }

  private Drawable a(int paramInt, com.viber.voip.messages.adapters.a.c.a parama)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return parama.D();
    case 1:
      return parama.E();
    case 2:
    }
    return parama.F();
  }

  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return "sent";
    case 1:
      return "delivered";
    case 2:
    }
    return "seen";
  }

  public void a()
  {
    super.a();
    dj.b(this.a, false);
    this.a.setContentDescription(null);
    this.a.setVisibility(8);
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    if ((localConversationLoaderEntity.isIncoming()) || (localConversationLoaderEntity.isCall()) || (localConversationLoaderEntity.isNotificationLast()) || (localConversationLoaderEntity.isDeletedMessageNotification()) || (localConversationLoaderEntity.hasMessageDraft()));
    for (int i = 1; i != 0; i = 0)
    {
      this.a.setImageDrawable(null);
      this.a.setContentDescription(null);
      dj.b(this.a, false);
      return;
    }
    int j = a(localConversationLoaderEntity);
    this.a.setImageDrawable(a(j, parama1));
    this.a.setContentDescription(a(j));
    dj.b(this.a, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.o
 * JD-Core Version:    0.6.2
 */