package com.viber.voip.messages.conversation.adapter.e;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.widget.b;

public class o
{
  private final i a;
  private final x b;
  private final long[] c;

  public o(i parami, x paramx, long[] paramArrayOfLong)
  {
    this.a = parami;
    this.b = paramx;
    this.c = paramArrayOfLong;
  }

  public void a(b paramb, aa paramaa)
  {
    paramb.a(false, this.c);
    if (a(paramaa))
    {
      paramb.a();
      return;
    }
    paramb.b();
  }

  public boolean a(aa paramaa)
  {
    return (this.a.q()) || ((paramaa.aE()) && (this.b.a(paramaa)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.o
 * JD-Core Version:    0.6.2
 */