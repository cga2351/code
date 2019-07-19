package com.viber.voip.market.b;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.a.i;
import com.viber.voip.analytics.g;
import com.viber.voip.apps.h;
import com.viber.voip.apps.h.a;
import com.viber.voip.billing.b.m;
import com.viber.voip.settings.d.g;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.f;
import com.viber.voip.util.cc;
import com.viber.voip.util.da;
import java.util.List;
import java.util.Set;

public class n
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(com.viber.voip.apps.b paramb, String paramString)
  {
    a(paramb, paramString, null);
  }

  public static void a(com.viber.voip.apps.b paramb, String paramString1, String paramString2)
  {
    g.a().a(i.j(paramb.c()));
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    if (localEngine.isInitialized())
      localEngine.getCdrController().handleReportGameRedirect(paramb.a(), paramString1, 0);
    if (cc.a().contains(paramb.f()))
    {
      if ((!da.a(paramString2)) && (paramString2.startsWith("vb" + paramb.a() + "://")))
      {
        localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        localIntent.addFlags(268435456);
        if (ViberActionRunner.a(localIntent, null));
      }
      for (Intent localIntent = cc.a(paramb.f()); ; localIntent = cc.a(paramb.f()))
      {
        if (localIntent != null)
          ViberApplication.getApplication().startActivity(localIntent);
        return;
      }
    }
    if ((paramb.k()) || (d.g.d.d()))
    {
      com.viber.voip.billing.b.a().a(paramb.a(), paramString1, new b.m()
      {
        public void a(String paramAnonymousString)
        {
          Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
          localIntent.addFlags(268435456);
          ViberApplication.getApplication().startActivity(localIntent);
        }
      });
      return;
    }
    ViberActionRunner.f.a(ViberApplication.getApplication(), paramb.f());
  }

  public void a(String paramString1, final String paramString2)
  {
    int i = Integer.parseInt(paramString1);
    UserManager.from(ViberApplication.getApplication()).getAppsController().a(i, true, new h.a()
    {
      private boolean c = false;

      public void onAppInfoFailed()
      {
      }

      public void onAppInfoReady(List<com.viber.voip.apps.b> paramAnonymousList, boolean paramAnonymousBoolean)
      {
        com.viber.voip.apps.b localb;
        if (paramAnonymousList.isEmpty())
        {
          localb = null;
          if (!paramAnonymousBoolean)
            break label54;
          if (localb != null)
          {
            this.c = true;
            if (localb.i())
              n.a(localb, paramString2);
          }
        }
        label54: 
        while ((this.c) || (localb == null) || (!localb.i()))
        {
          return;
          localb = (com.viber.voip.apps.b)paramAnonymousList.get(0);
          break;
        }
        n.a(localb, paramString2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.n
 * JD-Core Version:    0.6.2
 */