package com.viber.voip.messages.conversation.ui.b;

import com.viber.voip.bot.item.a;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;

public abstract interface ad extends a
{
  public abstract void a(ConferenceInfo paramConferenceInfo, boolean paramBoolean);

  public abstract void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton);

  public abstract void a(String paramString1, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, String paramString2, int paramInt);

  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);

  public abstract void b(boolean paramBoolean);

  public abstract void b_(boolean paramBoolean);

  public abstract void c_(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.ad
 * JD-Core Version:    0.6.2
 */