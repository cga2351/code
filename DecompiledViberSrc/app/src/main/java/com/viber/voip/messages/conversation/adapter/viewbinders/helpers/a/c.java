package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.l;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.b;
import com.viber.voip.messages.d;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.widget.FileIconView;

public class c extends b
{
  private final l b;

  public c(FileIconView paramFileIconView, l paraml)
  {
    super(paramFileIconView);
    this.b = paraml;
  }

  public void a()
  {
    dj.c(this.a, 8);
  }

  public void a(aa paramaa)
  {
    dj.c(this.a, 0);
    this.a.a(da.a(paramaa.o()), paramaa.a(), d.j);
  }

  public void b(aa paramaa)
  {
    this.b.f(paramaa);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a.c
 * JD-Core Version:    0.6.2
 */