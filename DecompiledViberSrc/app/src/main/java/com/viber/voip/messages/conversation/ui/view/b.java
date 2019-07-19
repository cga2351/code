package com.viber.voip.messages.conversation.ui.view;

import android.view.View;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.ui.expanel.d;
import com.viber.voip.mvp.core.j;
import com.viber.voip.stickers.entity.a;

public abstract interface b extends j
{
  public abstract void a();

  public abstract void a(int paramInt);

  public abstract void a(int paramInt1, int paramInt2, View paramView);

  public abstract void a(BotReplyConfig paramBotReplyConfig);

  public abstract void a(BotReplyConfig paramBotReplyConfig, d paramd);

  public abstract void a(BotReplyConfig paramBotReplyConfig, String paramString, boolean paramBoolean);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, int paramInt, String paramString2);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString1, String paramString2, int paramInt, String paramString3);

  public abstract void a(a parama);

  public abstract int b();

  public abstract void b(int paramInt);

  public abstract void c();

  public abstract void c(int paramInt);

  public abstract void d();

  public abstract void e();

  public abstract void f();

  public abstract void g();

  public abstract void h();

  public abstract void i();

  public abstract void j();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b
 * JD-Core Version:    0.6.2
 */