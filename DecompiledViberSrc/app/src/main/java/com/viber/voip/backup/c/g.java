package com.viber.voip.backup.c;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.IOException;

public abstract class g
  implements e
{
  private static Logger a = ViberEnv.getLogger();

  protected abstract void a(com.google.a.a.b.a.a.b.a.c paramc);

  protected abstract void a(com.google.a.a.b.a.a.b.a.d paramd);

  protected abstract void a(i parami);

  protected abstract void a(IOException paramIOException);

  public final void b(d paramd)
  {
    if ((paramd instanceof c))
    {
      Exception localException = ((c)paramd).a();
      if ((localException instanceof com.google.a.a.b.a.a.b.a.c))
      {
        a((com.google.a.a.b.a.a.b.a.c)localException);
        return;
      }
      if ((localException instanceof com.google.a.a.b.a.a.b.a.d))
      {
        a((com.google.a.a.b.a.a.b.a.d)localException);
        return;
      }
      a((IOException)localException);
      return;
    }
    if ((paramd instanceof i))
    {
      a((i)paramd);
      return;
    }
    c(paramd);
  }

  protected abstract void c(d paramd);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.c.g
 * JD-Core Version:    0.6.2
 */