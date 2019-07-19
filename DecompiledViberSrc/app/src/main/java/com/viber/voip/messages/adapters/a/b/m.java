package com.viber.voip.messages.adapters.a.b;

import android.content.Context;
import android.widget.TextView;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;

public class m extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private final Context a;
  private final TextView b;

  public m(Context paramContext, TextView paramTextView)
  {
    this.a = paramContext;
    this.b = paramTextView;
  }

  private CharSequence a(ConversationLoaderEntity paramConversationLoaderEntity, com.viber.voip.messages.adapters.a.c.a parama)
  {
    CharSequence localCharSequence = paramConversationLoaderEntity.getSpannableTitleText();
    if (localCharSequence != null)
      return localCharSequence;
    String str;
    if (paramConversationLoaderEntity.isInBusinessInbox())
      str = this.a.getString(R.string.business_inbox);
    while (true)
    {
      paramConversationLoaderEntity.setSpannableTitleText(str);
      return str;
      if (paramConversationLoaderEntity.isVlnConversation())
        str = this.a.getString(R.string.vln_inbox);
      else
        str = "";
    }
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    this.b.setText(a(localConversationLoaderEntity, parama1));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.m
 * JD-Core Version:    0.6.2
 */