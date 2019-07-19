package com.viber.voip.backup.f;

import com.viber.voip.backup.b.e;
import com.viber.voip.backup.c.i;
import com.viber.voip.backup.f;
import com.viber.voip.backup.l;
import com.viber.voip.backup.r;
import com.viber.voip.k.b;
import java.io.File;
import java.io.IOException;

public class g
  implements c
{
  private final com.google.a.a.b.a.a.b.a.a a;
  private final f b;
  private final String c;
  private final String d;
  private final e e;

  public g(String paramString1, String paramString2, com.google.a.a.b.a.a.b.a.a parama, f paramf, e parame)
  {
    this.a = parama;
    this.d = paramString1;
    this.c = paramString2;
    this.b = paramf;
    this.e = parame;
  }

  public void a()
  {
  }

  public void a(File paramFile, r paramr)
    throws com.viber.voip.backup.c.d
  {
    try
    {
      com.viber.voip.backup.b.d locald = new com.viber.voip.backup.b.d(this.a, this.d, this.c);
      com.google.a.b.a.a.a locala1 = l.a(locald.a());
      if (locala1 != null);
      for (String str = locala1.e(); ; str = null)
      {
        com.google.a.b.a.a.a locala2 = locald.a(str, paramFile, paramr, this.e);
        this.b.a(l.a(this.a.c(), locala2));
        return;
      }
    }
    catch (IOException localIOException)
    {
      throw new com.viber.voip.backup.c.c(localIOException);
    }
    catch (b localb)
    {
      throw new i(localb);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.f.g
 * JD-Core Version:    0.6.2
 */