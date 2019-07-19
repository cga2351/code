package com.viber.voip.backgrounds.c;

import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backgrounds.g;
import com.viber.voip.backgrounds.m;
import com.viber.voip.backgrounds.p;
import com.viber.voip.util.at;
import com.viber.voip.util.bj;
import java.io.File;

public class d
  implements Runnable
{
  private static final Logger a = ViberEnv.getLogger();
  private p b;
  private final a c;
  private volatile boolean d = false;
  private int e;

  public d(p paramp, a parama)
  {
    this.b = paramp;
    if (paramp == null)
      throw new IllegalArgumentException("defaultBackground must be not null");
    this.c = parama;
    if (paramp != null)
      this.e = paramp.a;
  }

  public void a()
  {
    this.d = true;
  }

  public void run()
  {
    if (this.d)
      return;
    int i = g.a;
    String str1 = m.a(this.b.a, i, this.b.d());
    String str2 = this.b.h.getPath();
    String str3 = str2 + ".tmp";
    boolean bool = new File(this.b.h.getPath()).exists();
    if (!bool)
    {
      at.d(new File(this.b.h.getPath()));
      if (!this.b.c())
        break label209;
    }
    try
    {
      com.viber.voip.backgrounds.b.b(this.b);
      while (true)
      {
        label128: bool = new File(this.b.h.getPath()).exists();
        if ((!bool) || (!bj.a(this.b.i)));
        try
        {
          com.viber.voip.backgrounds.b.a().a(this.b);
          label178: Uri[] arrayOfUri = com.viber.voip.backgrounds.b.a().a(ViberApplication.getApplication(), this.b);
          this.c.a(this.e, arrayOfUri);
          return;
          label209: com.viber.voip.util.upload.b localb = new com.viber.voip.util.upload.b(str1, str2, str3);
          try
          {
            localb.f();
          }
          catch (com.viber.voip.util.upload.b.a locala)
          {
          }
          continue;
          this.c.a(this.e);
          return;
        }
        catch (Exception localException)
        {
          break label178;
        }
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label128;
    }
    catch (com.viber.voip.backgrounds.b.a locala1)
    {
      break label128;
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt, Uri[] paramArrayOfUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.c.d
 * JD-Core Version:    0.6.2
 */