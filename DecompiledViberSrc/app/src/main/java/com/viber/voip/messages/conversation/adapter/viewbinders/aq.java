package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.d.b;

public class aq extends com.viber.voip.ui.g.e<a, i>
{
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<TextView> a;
  private CharSequence b;

  public aq(com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<TextView> parame)
  {
    this.a = parame;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if (!localaa.bD());
    while (true)
    {
      return;
      QuotedMessageData localQuotedMessageData = localaa.bC();
      CharSequence localCharSequence = localQuotedMessageData.getCachedAuthorName();
      String str;
      if (localCharSequence == null)
      {
        str = parami.U().a(localQuotedMessageData.getMemberId(), localaa.A(), parami.h());
        localQuotedMessageData.setCachedAuthorName(str);
      }
      for (Object localObject = str; this.b != localObject; localObject = localCharSequence)
      {
        this.b = ((CharSequence)localObject);
        ((TextView)this.a.b()).setText((CharSequence)localObject);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.aq
 * JD-Core Version:    0.6.2
 */