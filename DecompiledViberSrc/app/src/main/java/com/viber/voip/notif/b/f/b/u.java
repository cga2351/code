package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.dg;

class u
  implements h
{
  public String a(Context paramContext, m paramm)
  {
    return dg.a(paramm.c().getMessageInfo().getPin());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.u
 * JD-Core Version:    0.6.2
 */