package com.viber.voip.messages.conversation.ui;

import com.viber.voip.bot.item.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.ab;

public class bs
  implements a
{
  private final ab a;
  private aa b;
  private int c;
  private int d;

  public bs(ab paramab)
  {
    this.a = paramab;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(aa paramaa)
  {
    this.b = paramaa;
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton)
  {
    this.a.a(this.b, this.c, this.d, paramReplyButton, paramString);
  }

  public void b(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bs
 * JD-Core Version:    0.6.2
 */