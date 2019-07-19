package com.viber.voip.messages.conversation.ui.a;

import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.ab;

public class t
  implements ab
{
  private ab a;

  public void a(aa paramaa, int paramInt1, int paramInt2, ReplyButton paramReplyButton, String paramString)
  {
    if (this.a != null)
      this.a.a(paramaa, paramInt1, paramInt2, paramReplyButton, paramString);
  }

  public void a(ab paramab)
  {
    this.a = paramab;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.a.t
 * JD-Core Version:    0.6.2
 */