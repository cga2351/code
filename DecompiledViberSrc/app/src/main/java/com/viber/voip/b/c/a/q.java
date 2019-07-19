package com.viber.voip.b.c.a;

import android.content.Context;
import android.net.Uri;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.dv;
import java.io.File;

public class q extends d
{
  public q(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    super.a();
    File localFile = UserManager.from(this.c).getUserData().getImageFile(this.c);
    if (localFile != null)
      this.b.a(localFile.getAbsolutePath());
  }

  d.a f()
  {
    return new d.a()
    {
      public File a(String paramAnonymousString)
      {
        String str = Uri.parse(paramAnonymousString).getLastPathSegment();
        return dv.s.b(q.this.c, str, false);
      }
    };
  }

  d.a g()
  {
    return new d.a()
    {
      public File a(String paramAnonymousString)
      {
        return dv.s.b(q.this.c, paramAnonymousString, false);
      }
    };
  }

  File h()
  {
    return dv.s.a(this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.q
 * JD-Core Version:    0.6.2
 */