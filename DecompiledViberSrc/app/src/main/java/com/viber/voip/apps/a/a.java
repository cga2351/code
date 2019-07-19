package com.viber.voip.apps.a;

import com.viber.dexshared.Logger;
import com.viber.jni.CGetAppDetails;
import com.viber.jni.apps.AppsControllerDelegate.AppsDelegate;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.c;
import com.viber.voip.apps.f;
import com.viber.voip.apps.g;
import com.viber.voip.apps.h;
import com.viber.voip.apps.h.a;
import com.viber.voip.block.a.a;
import com.viber.voip.block.a.b;
import com.viber.voip.block.k;
import com.viber.voip.block.k.a;
import com.viber.voip.block.k.b;
import com.viber.voip.block.k.c;
import com.viber.voip.settings.d.g;
import java.util.ArrayList;
import java.util.List;

public class a
  implements AppsControllerDelegate.AppsDelegate
{
  public static final Logger a = ViberEnv.getLogger();
  public f b = g.a();
  private com.viber.voip.block.a c = new com.viber.voip.block.a();
  private h d;

  public a(h paramh)
  {
    this.d = paramh;
  }

  public void onAppsApiSupported()
  {
    d.g.a.a(true);
  }

  public void onAuthenticateAppReply(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt1 == 0)
    {
      this.d.a(paramInt2, null);
      if (this.c.b(paramInt2))
        com.viber.voip.block.b.a().b(paramInt2);
      boolean bool = d.g.a.d();
      i = 0;
      if (!bool)
        onAppsApiSupported();
    }
    while (true)
    {
      String str = c.a(paramInt2, i, paramString);
      this.b.a(paramInt1, paramInt2, str);
      return;
      i = 1;
    }
  }

  public void onBlockAppReply(int paramInt1, int paramInt2)
  {
    final a.b localb;
    if (paramInt1 == 0)
    {
      localb = this.c.a(paramInt2);
      if ((localb instanceof a.a))
      {
        if (!localb.c)
          break label48;
        com.viber.voip.block.b.a().b().a(new k.c()
        {
          public void a(k.b paramAnonymousb)
          {
            if ((paramAnonymousb instanceof k.a))
            {
              a.a locala = (a.a)localb;
              ((k.a)paramAnonymousb).a(locala.a, locala.b);
            }
          }
        });
      }
    }
    return;
    label48: com.viber.voip.block.b.a().b().a(new k.c()
    {
      public void a(k.b paramAnonymousb)
      {
        if ((paramAnonymousb instanceof k.a))
        {
          a.a locala = (a.a)localb;
          ((k.a)paramAnonymousb).b(locala.a, locala.b);
        }
      }
    });
  }

  public void onGetAppDetails(CGetAppDetails[] paramArrayOfCGetAppDetails, int paramInt1, int paramInt2)
  {
    this.d.onGetAppDetails(paramArrayOfCGetAppDetails, paramInt1, paramInt2);
  }

  public void onGetUserAppsReply(int[] paramArrayOfInt, final int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      ArrayList localArrayList = new ArrayList();
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++)
        localArrayList.add(Integer.valueOf(paramArrayOfInt[j]));
      this.d.a(localArrayList, true, new h.a()
      {
        public void onAppInfoFailed()
        {
          a.this.b.a(paramInt1, null, true);
        }

        public void onAppInfoReady(List<com.viber.voip.apps.b> paramAnonymousList, boolean paramAnonymousBoolean)
        {
          a.this.b.a(paramInt1, paramAnonymousList, paramAnonymousBoolean);
        }
      });
      return;
    }
    this.b.a(paramInt1, null, true);
  }

  public void onUnregisterAppReply(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return;
    case 0:
    case 5:
    }
    this.b.a(paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.apps.a.a
 * JD-Core Version:    0.6.2
 */