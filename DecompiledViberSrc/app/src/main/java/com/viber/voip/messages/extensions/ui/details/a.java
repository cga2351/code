package com.viber.voip.messages.extensions.ui.details;

import android.net.Uri;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.Map;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.mvp.core.j;

public abstract interface a extends j
{
  public abstract void a();

  public abstract void a(Map paramMap);

  public abstract void a(BotReplyRequest paramBotReplyRequest);

  public abstract void a(i parami, boolean paramBoolean);

  public abstract void a(String paramString);

  public abstract void a(String paramString, Uri paramUri);

  public abstract void a(String paramString, BotReplyRequest paramBotReplyRequest);

  public abstract void a(boolean paramBoolean);

  public abstract void b();

  public abstract void b(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.details.a
 * JD-Core Version:    0.6.2
 */