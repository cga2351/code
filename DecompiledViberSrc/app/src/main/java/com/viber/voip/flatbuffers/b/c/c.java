package com.viber.voip.flatbuffers.b.c;

import android.content.Context;
import com.viber.voip.flatbuffers.R.raw;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;

public class c
  implements com.viber.voip.flatbuffers.b.d<MsgInfo>
{
  private final String a;

  public c(Context paramContext)
  {
    this.a = com.viber.voip.flatbuffers.model.util.a.a(paramContext, R.raw.msginfo_scheme);
  }

  public com.viber.voip.flatbuffers.b.a<MsgInfo> a()
  {
    return new b(this.a);
  }

  public com.viber.voip.flatbuffers.b.b<MsgInfo> b()
  {
    return new d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.c.c
 * JD-Core Version:    0.6.2
 */