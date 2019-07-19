package com.viber.provider.messages.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.provider.e;
import com.viber.voip.ViberEnv;

public abstract class a extends e
{
  private static final Logger b = ViberEnv.getLogger();

  protected a(Context paramContext)
  {
    super(paramContext, "viber_messages");
  }

  protected void a(b paramb, int paramInt1, int paramInt2)
  {
    paramb.a("DROP TABLE IF EXISTS groups");
    paramb.a("DROP TABLE IF EXISTS threads");
    paramb.a("DROP TABLE IF EXISTS msgs");
    paramb.a("DROP TABLE IF EXISTS msgthreads");
    paramb.a("DROP TABLE IF EXISTS messages");
    paramb.a("DROP TABLE IF EXISTS participants");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.a.a
 * JD-Core Version:    0.6.2
 */