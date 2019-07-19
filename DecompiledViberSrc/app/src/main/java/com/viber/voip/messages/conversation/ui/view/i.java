package com.viber.voip.messages.conversation.ui.view;

import android.view.View;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.MessageEditText.a;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.mvp.core.j;

public abstract interface i extends j
{
  public abstract void a();

  public abstract void a(int paramInt1, int paramInt2, View paramView);

  public abstract void a(QuotedMessageData paramQuotedMessageData);

  public abstract void a(MessageEditText.a parama, boolean paramBoolean);

  public abstract void a(OpenShopChatPanelData paramOpenShopChatPanelData);

  public abstract void a(CharSequence paramCharSequence);

  public abstract void a(CharSequence paramCharSequence, boolean paramBoolean);

  public abstract void a(boolean paramBoolean);

  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);

  public abstract void b();

  public abstract void b(boolean paramBoolean);

  public abstract void c();

  public abstract void c(boolean paramBoolean);

  public abstract void d();

  public abstract void d(boolean paramBoolean);

  public abstract void e();

  public abstract void e(boolean paramBoolean);

  public abstract void f();

  public abstract void f(boolean paramBoolean);

  public abstract void g();

  public abstract void g(boolean paramBoolean);

  public abstract void h();

  public abstract void i();

  public abstract void j();

  public abstract void k();

  public abstract void l();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.i
 * JD-Core Version:    0.6.2
 */