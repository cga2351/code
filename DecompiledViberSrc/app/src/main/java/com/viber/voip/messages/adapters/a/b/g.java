package com.viber.voip.messages.adapters.a.b;

import android.widget.TextView;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;

public class g<T extends com.viber.voip.messages.adapters.a.a> extends e<T, com.viber.voip.messages.adapters.a.c.a>
{
  private final TextView a;

  public g(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void a(T paramT, com.viber.voip.messages.adapters.a.c.a parama)
  {
    super.a(paramT, parama);
    ConversationLoaderEntity localConversationLoaderEntity = paramT.a();
    int i;
    if (((localConversationLoaderEntity.isGroupBehavior()) || (localConversationLoaderEntity.isPublicAccount())) && (localConversationLoaderEntity.isMuteConversation()) && (!localConversationLoaderEntity.isSnoozedConversation()) && (!localConversationLoaderEntity.isNotJoinedCommunity()))
    {
      i = 1;
      if (((!localConversationLoaderEntity.isGroupBehavior()) && (!localConversationLoaderEntity.isPublicAccount())) || (!localConversationLoaderEntity.isSnoozedConversation()))
        break label137;
    }
    int k;
    label137: for (int j = 1; ; j = 0)
    {
      if ((!localConversationLoaderEntity.isVerified()) && (!localConversationLoaderEntity.isNonreplyableConversation()))
      {
        boolean bool = localConversationLoaderEntity.isSystemConversation();
        k = 0;
        if (!bool);
      }
      else
      {
        k = 1;
      }
      if ((k == 0) || (i == 0))
        break label143;
      this.a.setCompoundDrawablesWithIntrinsicBounds(null, null, parama.l(), null);
      return;
      i = 0;
      break;
    }
    label143: if (k != 0)
    {
      this.a.setCompoundDrawablesWithIntrinsicBounds(null, null, parama.i(), null);
      return;
    }
    if (i != 0)
    {
      this.a.setCompoundDrawablesWithIntrinsicBounds(null, null, parama.j(), null);
      return;
    }
    if (j != 0)
    {
      this.a.setCompoundDrawablesWithIntrinsicBounds(null, null, parama.k(), null);
      return;
    }
    this.a.setCompoundDrawables(null, null, null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.g
 * JD-Core Version:    0.6.2
 */