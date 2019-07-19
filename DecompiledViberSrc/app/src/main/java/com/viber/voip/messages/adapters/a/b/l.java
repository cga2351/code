package com.viber.voip.messages.adapters.a.b;

import android.content.Context;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.cg;
import com.viber.voip.util.dc;

public class l extends e<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a>
{
  private final Context a;
  private final TextView b;

  public l(Context paramContext, TextView paramTextView)
  {
    this.a = paramContext;
    this.b = paramTextView;
  }

  public void a(com.viber.voip.messages.adapters.a.a parama, com.viber.voip.messages.adapters.a.c.a parama1)
  {
    super.a(parama, parama1);
    ConversationLoaderEntity localConversationLoaderEntity = parama.a();
    if (localConversationLoaderEntity.isInBusinessInbox())
      this.b.setText(this.a.getString(R.string.business_inbox_description));
    while (!localConversationLoaderEntity.isVlnConversation())
      return;
    String str = cg.a(this.a, parama.a().getToNumber());
    this.b.setText(str);
    this.b.setTextColor(dc.d(this.a, R.attr.textPrimaryColor));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.l
 * JD-Core Version:    0.6.2
 */