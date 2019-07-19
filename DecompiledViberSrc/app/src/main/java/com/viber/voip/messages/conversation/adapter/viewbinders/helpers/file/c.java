package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file;

import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.i;
import com.viber.voip.messages.d;
import com.viber.voip.util.at;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.widget.FileIconView;
import com.viber.voip.widget.FileIconView.e;

public class c extends b
{
  private final i b;

  public c(FileIconView paramFileIconView, i parami)
  {
    super(paramFileIconView);
    this.b = parami;
  }

  public void a()
  {
    b().a();
  }

  public void a(aa paramaa)
  {
    dj.c(this.a, 0);
    d locald = com.viber.voip.messages.c.a(at.d(paramaa.bz().getFileName()));
    this.a.a(da.a(paramaa.o()), paramaa.a(), locald);
  }

  public void b(aa paramaa)
  {
    this.b.d(paramaa);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.c
 * JD-Core Version:    0.6.2
 */