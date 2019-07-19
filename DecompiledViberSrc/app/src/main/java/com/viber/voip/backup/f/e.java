package com.viber.voip.backup.f;

import com.viber.voip.backup.c.c;
import com.viber.voip.backup.c.i;
import com.viber.voip.backup.r;
import com.viber.voip.k.b;
import com.viber.voip.util.da;
import java.io.File;
import java.io.IOException;

public class e
  implements a
{
  private final com.google.a.a.b.a.a.b.a.a a;
  private final String b;
  private final String c;
  private String d;

  public e(String paramString1, String paramString2, String paramString3, com.google.a.a.b.a.a.b.a.a parama)
  {
    this.a = parama;
    this.c = paramString2;
    this.b = paramString3;
    this.d = paramString1;
  }

  public void a()
  {
  }

  public void a(File paramFile, r paramr)
    throws com.viber.voip.backup.c.d
  {
    if (da.a(this.d))
      throw new com.viber.voip.backup.c.d("Backup drive file id is null");
    try
    {
      new com.viber.voip.backup.b.d(this.a, this.c, this.b).a(this.d, paramFile, paramr);
      return;
    }
    catch (IOException localIOException)
    {
      throw new c(localIOException);
    }
    catch (b localb)
    {
      throw new i(localb);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.f.e
 * JD-Core Version:    0.6.2
 */