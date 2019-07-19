package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;
import dagger.a;

class j
  implements h
{
  private final a<ai> a;
  private final a<b> b;

  j(a<ai> parama, a<b> parama1)
  {
    this.a = parama;
    this.b = parama1;
  }

  public String a(Context paramContext, m paramm)
  {
    com.viber.voip.model.entity.h localh = paramm.e();
    return dg.a(paramm.c().getMessageInfo().getPin(), paramm.c().getSpans(), (ai)this.a.get(), (b)this.b.get(), localh.j(), localh.p(), false).toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.j
 * JD-Core Version:    0.6.2
 */