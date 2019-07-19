package com.viber.voip.contacts.c.d;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.f.b.f;
import com.viber.voip.g.b.b;

public class d
  implements g.b
{
  private static final Logger a = ViberEnv.getLogger();
  private final b<f> b;
  private final com.viber.common.b.d c;
  private final Handler d;

  public d(com.viber.common.b.d paramd, Handler paramHandler, b<f> paramb)
  {
    this.c = paramd;
    this.d = paramHandler;
    this.b = paramb;
  }

  public void a()
  {
    this.d.post(new e(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.d
 * JD-Core Version:    0.6.2
 */