package com.viber.voip.backup.f;

import com.viber.voip.backup.c.c;
import com.viber.voip.backup.c.i;
import com.viber.voip.backup.f;
import com.viber.voip.backup.l;
import java.io.IOException;

public class h
  implements b
{
  private final com.google.a.a.b.a.a.b.a.a a;
  private final f b;
  private final String c;
  private final String d;

  public h(String paramString1, String paramString2, com.google.a.a.b.a.a.b.a.a parama, f paramf)
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
      com.viber.voip.backup.b.d locald = new com.viber.voip.backup.b.d(this.a, this.d, this.c);
      com.google.a.b.a.a.a locala1 = l.a(locald.a());
      if (locala1 != null)
      {
        com.google.a.b.a.a.a locala2 = locald.a(locala1);
        this.b.a(l.a(this.a.c(), locala2));
      }
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
 * Qualified Name:     com.viber.voip.backup.f.h
 * JD-Core Version:    0.6.2
 */