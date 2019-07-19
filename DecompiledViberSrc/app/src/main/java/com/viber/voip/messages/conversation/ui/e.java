package com.viber.voip.messages.conversation.ui;

import com.viber.common.b.d;
import com.viber.voip.R.id;
import com.viber.voip.messages.ui.MessageComposerView.b;
import com.viber.voip.messages.ui.MessageComposerView.e;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.messages.ui.x;
import com.viber.voip.settings.d.ax;

public class e
  implements MessageComposerView.e
{
  private ExpandablePanelLayout a;
  private x b;

  public e(ExpandablePanelLayout paramExpandablePanelLayout, x paramx)
  {
    this.a = paramExpandablePanelLayout;
    this.b = paramx;
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      this.a.a(paramInt, true);
    while (!this.a.b(paramInt))
      return;
    this.a.c();
  }

  public void a()
  {
    MessageComposerView.b localb = MessageComposerView.b.values()[d.ax.i.d()];
    switch (1.a[localb.ordinal()])
    {
    default:
      return;
    case 1:
      this.b.k();
      return;
    case 2:
      this.b.g();
      return;
    case 3:
      this.b.l();
      return;
    case 4:
    }
    this.b.m();
  }

  public void a(boolean paramBoolean)
  {
    a(R.id.options_menu_open_extra_section, paramBoolean);
  }

  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    a(R.id.options_menu_open_old_chat_extensions, paramBoolean1);
  }

  public void a(boolean paramBoolean, MessageComposerView.b paramb)
  {
    a(R.id.options_menu_open_stickers, paramBoolean);
    d.ax.i.a(paramb.ordinal());
  }

  public void b(boolean paramBoolean)
  {
    a(R.id.bot_keyboard, paramBoolean);
  }

  public void c(boolean paramBoolean)
  {
    a(R.id.options_menu_open_gallery, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.e
 * JD-Core Version:    0.6.2
 */