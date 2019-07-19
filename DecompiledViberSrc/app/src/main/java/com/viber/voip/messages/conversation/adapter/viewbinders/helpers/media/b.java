package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media;

import android.content.Context;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.util.cj;
import com.viber.voip.util.upload.s;

public class b
{
  private final ai a;
  private final Context b;

  public b(ai paramai, Context paramContext)
  {
    this.a = paramai;
    this.b = paramContext;
  }

  public boolean a(aa paramaa)
  {
    if ((paramaa.aH()) || (paramaa.aM()));
    for (int i = 1; i != 0; i = 0)
      return bk.a(this.b, paramaa.bz().getFileSize(), paramaa.aT(), paramaa.Z());
    return bk.a(this.b);
  }

  public boolean b(aa paramaa)
  {
    String str = paramaa.B();
    if ((s.a(str)) || (!cj.a(true)) || (paramaa.f() == -2))
      return false;
    this.a.a(paramaa.a(), str);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.b
 * JD-Core Version:    0.6.2
 */