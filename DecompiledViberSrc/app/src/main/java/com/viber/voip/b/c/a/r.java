package com.viber.voip.b.c.a;

import android.content.Context;
import android.net.Uri;
import com.viber.voip.util.dv;
import java.io.File;

public class r extends d
{
  public r(Context paramContext)
  {
    super(paramContext);
  }

  d.a f()
  {
    return new d.a()
    {
      public File a(String paramAnonymousString)
      {
        String str = Uri.parse(paramAnonymousString).getLastPathSegment();
        return dv.t.b(r.this.c, str, false);
      }
    };
  }

  d.a g()
  {
    return new d.a()
    {
      public File a(String paramAnonymousString)
      {
        return dv.t.b(r.this.c, paramAnonymousString, false);
      }
    };
  }

  File h()
  {
    return dv.t.a(this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.r
 * JD-Core Version:    0.6.2
 */