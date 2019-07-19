package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.c.b;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;

public class as extends com.viber.voip.ui.g.e<a, i>
{
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<TextView> a;
  private CharSequence b;

  public as(com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<TextView> parame)
  {
    this.a = parame;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if (!localaa.bD());
    TextView localTextView;
    CharSequence localCharSequence;
    do
    {
      return;
      QuotedMessageData localQuotedMessageData = localaa.bC();
      localTextView = (TextView)this.a.b();
      localCharSequence = localQuotedMessageData.getCachedSpannableText();
      if (localCharSequence == null)
      {
        localCharSequence = b.a(localTextView.getResources(), localQuotedMessageData, parami.V(), parami.U(), localaa.A(), parami.h(), true, true);
        localQuotedMessageData.setCachedSpannableText(localCharSequence);
      }
    }
    while (this.b == localCharSequence);
    this.b = localCharSequence;
    localTextView.setText(localCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.as
 * JD-Core Version:    0.6.2
 */