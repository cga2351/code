package com.viber.voip.backup.g;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.File;

public class d
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private c b;
  private final Context c;
  private final String d;
  private final String e;

  public d(Context paramContext, String paramString1, String paramString2)
  {
    this.c = paramContext;
    this.e = paramString1;
    this.d = paramString2;
  }

  private void e()
    throws com.viber.voip.backup.c.d
  {
    if (this.b == null)
      this.b = new c(this.c, this.e, this.d);
  }

  public void a()
    throws com.viber.voip.backup.c.d
  {
    e();
    this.b.b();
  }

  public File b()
    throws com.viber.voip.backup.c.d
  {
    e();
    return this.b.a();
  }

  public void c()
    throws com.viber.voip.backup.c.d
  {
    e();
    this.b.c();
  }

  public void d()
    throws com.viber.voip.backup.c.d
  {
    e();
    this.b.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.g.d
 * JD-Core Version:    0.6.2
 */