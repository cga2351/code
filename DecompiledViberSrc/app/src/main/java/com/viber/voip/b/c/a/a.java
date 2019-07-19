package com.viber.voip.b.c.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.messages.controller.manager.k;
import com.viber.voip.sound.ptt.PttUtils;
import com.viber.voip.util.af;
import com.viber.voip.util.at;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.List;

public class a extends c
{
  private static final Logger d = ViberEnv.getLogger();
  private final k e;

  public a(Context paramContext, k paramk)
  {
    super(paramContext);
    this.e = paramk;
  }

  private b f()
  {
    return d.a(this.c);
  }

  private void g()
  {
    String str1 = this.e.j();
    if (!da.a(str1))
    {
      String str2 = Uri.parse(str1).getPath();
      boolean bool = da.a(str2);
      File localFile = null;
      if (!bool)
        localFile = new File(str2);
      if (at.a(localFile))
        this.b.a(localFile.getAbsolutePath());
    }
  }

  public void a()
  {
    this.b = new f(new g(new com.viber.voip.b.c.a.a.a()), 256);
    this.b.b(true);
  }

  protected void b()
  {
    if (this.a);
    while (true)
    {
      return;
      g();
      try
      {
        Cursor localCursor2 = f().a("messages", new String[] { "extra_uri", "extra_mime" }, "extra_mime = 2 OR extra_mime = 1009", null, null, null, null, null);
        localCursor1 = localCursor2;
        while (true)
        {
          String str1;
          int i;
          try
          {
            if (!localCursor1.moveToNext())
              break;
            str1 = localCursor1.getString(0);
            if ((str1 == null) || (da.a(str1)))
              continue;
            i = localCursor1.getInt(1);
            if (2 == i)
            {
              localFile = PttUtils.generateLegacyPttFile(str1, this.c);
              if ((localFile == null) || (!localFile.exists()))
                continue;
              this.b.a(localFile.getAbsolutePath());
              continue;
            }
          }
          finally
          {
            af.a(localCursor1);
          }
          if (1009 != i)
            break label226;
          String str2 = Uri.parse(str1).getPath();
          if (da.a(str2))
            break label226;
          localFile = new File(str2);
        }
        af.a(localCursor1);
        List localList = this.b.a(dv.w.a(this.c));
        if (this.a)
          continue;
        this.b.a(localList);
        return;
      }
      finally
      {
        while (true)
        {
          Cursor localCursor1 = null;
          continue;
          label226: File localFile = null;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.a
 * JD-Core Version:    0.6.2
 */