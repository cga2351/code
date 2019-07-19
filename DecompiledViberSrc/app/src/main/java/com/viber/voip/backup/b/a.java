package com.viber.voip.backup.b;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.r;
import com.viber.voip.util.h.d;

public class a
  implements d
{
  private static final Logger a = ViberEnv.getLogger();
  private int b;
  private final long c;
  private r d;

  public a(long paramLong, r paramr)
  {
    this.c = paramLong;
    this.d = paramr;
  }

  public void a(long paramLong)
  {
    if (this.d != null)
    {
      int i = (int)(100.0F * ((float)paramLong / (float)this.c));
      if (i > this.b)
      {
        this.d.a(i);
        this.b = i;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.b.a
 * JD-Core Version:    0.6.2
 */