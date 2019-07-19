package com.viber.voip.messages.adapters.a.b;

import android.content.Context;
import android.widget.ImageView;
import com.viber.voip.R.attr;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class h extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private final Context a;
  private final ImageView b;

  public h(Context paramContext, ImageView paramImageView)
  {
    this.a = paramContext;
    this.b = paramImageView;
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    if (localConversationLoaderEntity.isAnonymous())
    {
      this.b.setImageDrawable(dc.g(this.a, R.attr.conversationsListItemShieldBadge));
      dj.c(this.b, true);
      return;
    }
    if (localConversationLoaderEntity.isSecret())
    {
      this.b.setImageDrawable(dc.g(this.a, R.attr.conversationsListItemSecretChatBadge));
      dj.c(this.b, true);
      return;
    }
    if (localConversationLoaderEntity.isOneToOneWithPublicAccount())
    {
      this.b.setImageDrawable(dc.g(this.a, R.attr.conversationsListItemBotChatBadge));
      dj.c(this.b, true);
      return;
    }
    dj.c(this.b, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.h
 * JD-Core Version:    0.6.2
 */