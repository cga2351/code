package com.viber.voip.backup.f;

import com.google.a.a.b.a.a.b.a.a;
import com.viber.voip.backup.c.c;
import com.viber.voip.backup.c.i;
import com.viber.voip.backup.l;
import java.io.IOException;

public class f
  implements b
{
  private final a a;
  private final com.viber.voip.backup.f b;
  private final String c;
  private final String d;

  public f(String paramString1, String paramString2, a parama, com.viber.voip.backup.f paramf)
  {
    this.d = paramString1;
    this.a = parama;
    this.c = paramString2;
    this.b = paramf;
  }

  public void a()
  {
  }

  public void b()
    throws com.viber.voip.backup.c.d
  {
    try
    {
      com.google.a.b.a.a.b localb1 = new com.viber.voip.backup.b.d(this.a, this.d, this.c).a();
      this.b.a(l.a(this.a.c(), l.a(localb1)));
      return;
    }
    catch (IOException localIOException)
    {
      throw new c(localIOException);
    }
    catch (com.viber.voip.k.b localb)
    {
      throw new i(localb);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.f.f
 * JD-Core Version:    0.6.2
 */