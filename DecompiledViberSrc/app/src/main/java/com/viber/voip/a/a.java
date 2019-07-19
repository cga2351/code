package com.viber.voip.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.i;
import com.viber.voip.apps.b;
import com.viber.voip.apps.c;
import com.viber.voip.apps.f.a;
import com.viber.voip.apps.h.a;
import com.viber.voip.apps.model.AuthInfo;
import com.viber.voip.settings.d.h;
import com.viber.voip.user.UserManager;
import java.util.List;

public final class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile a b;
  private final c c = new c();
  private final com.viber.voip.apps.h d;
  private boolean e = false;

  private a(Context paramContext)
  {
    this.d = UserManager.from(paramContext).getAppsController();
  }

  public static a a(Context paramContext)
  {
    if (b == null);
    try
    {
      if (b == null)
        b = new a(paramContext);
      return b;
    }
    finally
    {
    }
  }

  private boolean a()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void b()
  {
    try
    {
      this.e = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void c()
  {
    try
    {
      this.e = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean);
    try
    {
      boolean bool = TextUtils.isEmpty(d.h.a.d());
      if (!bool);
      while (true)
      {
        return;
        if (!a())
        {
          b();
          final AuthInfo localAuthInfo = i.e(com.viber.common.c.a.a.a.a(902, 7, "app902sys1"));
          this.c.a(localAuthInfo);
          this.d.a(localAuthInfo.getAppId(), true, new h.a()
          {
            public void onAppInfoFailed()
            {
              a.a(a.this);
            }

            public void onAppInfoReady(List<b> paramAnonymousList, boolean paramAnonymousBoolean)
            {
              if (paramAnonymousList.isEmpty())
              {
                a.a(a.this);
                return;
              }
              a.b(a.this).a(new f.a()
              {
                public void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String)
                {
                  a.b(a.this).a(null);
                  if ((paramAnonymous2Int1 == 0) && (!TextUtils.isEmpty(paramAnonymous2String)))
                  {
                    Uri localUri = Uri.parse(paramAnonymous2String);
                    if (("vb902".equals(localUri.getScheme())) && ("auth-result".equals(localUri.getAuthority())))
                    {
                      String str1 = localUri.getQueryParameter("authorized");
                      String str2 = localUri.getQueryParameter("token");
                      if ((!TextUtils.isEmpty(str1)) && (TextUtils.isDigitsOnly(str1)) && (Integer.parseInt(str1) == 0) && (!TextUtils.isEmpty(str2)))
                        d.h.a.a(str2);
                    }
                  }
                  a.a(a.this);
                }
              });
              a.b(a.this).b(localAuthInfo);
            }
          });
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.a.a
 * JD-Core Version:    0.6.2
 */