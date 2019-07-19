package com.viber.voip.messages.conversation.ui.view.a.c;

import com.viber.voip.banner.notificationsoff.f.b;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.af;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.util.ag;

public abstract interface f extends f.b, com.viber.voip.mvp.core.j
{
  public abstract void J_();

  public abstract void a(Pin paramPin);

  public abstract void a(Pin paramPin, com.viber.voip.messages.conversation.ui.j paramj);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, af paramaf, boolean paramBoolean);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, OngoingConferenceCallModel paramOngoingConferenceCallModel);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, Runnable paramRunnable);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, String paramString);

  public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean);

  public abstract void a(String paramString);

  public abstract void a(boolean paramBoolean);

  public abstract void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean);

  @ag
  public abstract boolean b(ConversationAlertView.a parama);

  public abstract void c(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void d(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void e();

  public abstract void e(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void f();

  public abstract void f(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void g();

  public abstract void g(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void h(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void i();

  public abstract void i(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void j();

  public abstract void j(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

  public abstract void k();

  public abstract void l();

  public abstract void m();

  public abstract void n();

  public abstract void o();

  public abstract void p();

  public abstract void q();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.a.c.f
 * JD-Core Version:    0.6.2
 */