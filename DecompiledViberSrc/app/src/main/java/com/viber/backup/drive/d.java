package com.viber.backup.drive;

import com.google.a.a.b.a.a.b.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.b.b;
import com.viber.voip.backup.b.b.a;
import com.viber.voip.util.da;

public class d
  implements b.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.backup.a.d b;
  private final b c;

  public d(com.viber.backup.a.d paramd, b paramb)
  {
    this.b = paramd;
    this.c = paramb;
  }

  public void a()
  {
    this.c.a();
    this.b.h();
  }

  public void a(String paramString)
  {
    if (da.a(this.c.b().c(), paramString))
      return;
    if (da.a(paramString))
      this.b.b(true);
    while (true)
    {
      this.b.h();
      return;
      this.b.c(true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.drive.d
 * JD-Core Version:    0.6.2
 */