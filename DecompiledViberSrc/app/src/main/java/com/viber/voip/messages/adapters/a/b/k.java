package com.viber.voip.messages.adapters.a.b;

import android.widget.ImageView;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;

public class k extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private ImageView a;

  public k(ImageView paramImageView)
  {
    this.a = paramImageView;
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    if (localConversationLoaderEntity.isInBusinessInbox())
    {
      this.a.setImageResource(R.drawable.ic_chat_list_business_inbox);
      return;
    }
    if (localConversationLoaderEntity.isVlnConversation())
    {
      this.a.setImageResource(R.drawable.ic_list_item_vln_inbox);
      return;
    }
    this.a.setImageResource(R.drawable.generic_image_sixty_x_sixty);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.k
 * JD-Core Version:    0.6.2
 */