package com.viber.voip.b.c.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.backgrounds.o;
import com.viber.voip.settings.d.i;
import com.viber.voip.util.af;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.List;

public class b extends c
{
  private static final Logger d = ViberEnv.getLogger();

  public b(Context paramContext)
  {
    super(paramContext);
  }

  private void a(h paramh)
  {
    String str = paramh.d();
    if (TextUtils.isEmpty(str))
      return;
    this.b.a(Uri.parse(str).getPath());
  }

  public void a()
  {
    this.b = new f(new g(new a()));
  }

  protected void b()
  {
    if (this.a);
    while (true)
    {
      return;
      a(d.i.d);
      a(d.i.e);
      this.b.a(new o().a().getPath());
      com.viber.provider.b localb = d.a(this.c);
      try
      {
        Cursor localCursor2 = localb.a("conversations", new String[] { "background_portrait", "background_landscape" }, "background_portrait IS NOT NULL AND background_portrait != '' AND background_landscape IS NOT NULL AND background_landscape != ''", null, null, null, null);
        localCursor1 = localCursor2;
        try
        {
          if (localCursor1.moveToNext())
          {
            Uri localUri1 = Uri.parse(localCursor1.getString(0));
            Uri localUri2 = Uri.parse(localCursor1.getString(1));
            this.b.a(localUri1.getPath());
            this.b.a(localUri2.getPath());
          }
        }
        finally
        {
          af.a(localCursor1);
        }
        File localFile = dv.L.a(this.c);
        List localList = this.b.a(localFile);
        if (this.a)
          continue;
        this.b.a(localList);
        return;
      }
      finally
      {
        while (true)
          Cursor localCursor1 = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.b
 * JD-Core Version:    0.6.2
 */