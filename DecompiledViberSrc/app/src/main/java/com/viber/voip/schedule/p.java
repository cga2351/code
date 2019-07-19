package com.viber.voip.schedule;

import android.content.Context;
import android.os.Bundle;
import com.viber.backup.a.d;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.settings.d.l;
import com.viber.voip.user.UserManager;

public class p
{
  private static final Logger a = ViberEnv.getLogger();

  public static Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
      localBundle.putBundle("operation_params", paramBundle);
    return localBundle;
  }

  public static Bundle a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null)
      paramBundle = new Bundle(1);
    paramBundle.putBoolean("re_schedule", paramBoolean);
    return a(paramBundle);
  }

  public static f a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return new c();
    case 1:
      return new l();
    case 2:
      return new n();
    case 3:
      return new j();
    case 6:
      return new m();
    case 4:
      return new k();
    case 5:
      ViberApplication localViberApplication = ViberApplication.getInstance();
      return new a(localViberApplication.getUserManager().getAppsController(), localViberApplication.getMessagesManager().c());
    case 7:
      long l = d.l.d.f();
      return new b(new bs(paramContext.getApplicationContext()), l, new com.viber.voip.util.i.c());
    case 8:
      return new q();
    case 9:
    }
    return new i();
  }

  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return "backup";
    case 1:
      return "json_stickers";
    case 2:
      return "engagement_conversation";
    case 3:
      return "json_engagement_stickers";
    case 6:
      return "json_viber_id_promo_stickers";
    case 4:
      return "json_say_hi_engagement_config";
    case 5:
      return "apps_info_sync";
    case 7:
      return "autoclean_business_inbox";
    case 8:
      return "upload_keychain_to_fallback_storage";
    case 9:
    }
    return "chatex_suggestions_json";
  }

  private static void a()
  {
    final l locall = new l();
    boolean bool1 = locall.b().a();
    final j localj = new j();
    final boolean bool2 = localj.b().a();
    final k localk = new k();
    final boolean bool3 = localk.b().a();
    final m localm = new m();
    final boolean bool4 = localm.b().a();
    if ((!bool1) || (!bool2) || (!bool3) || (!bool4))
    {
      final ConnectionListener localConnectionListener = ViberApplication.getInstance().getEngine(false).getDelegatesManager().getConnectionListener();
      localConnectionListener.registerDelegate(new ConnectionDelegate()
      {
        public void onConnect()
        {
          if (!this.a)
            locall.a(Bundle.EMPTY);
          if (!bool2)
            localj.a(Bundle.EMPTY);
          if (!bool4)
            localm.a(Bundle.EMPTY);
          if (!bool3)
            localk.a(Bundle.EMPTY);
          localConnectionListener.removeDelegate(this);
        }

        public void onConnectionStateChange(int paramAnonymousInt)
        {
        }
      }
      , av.e.g.a());
    }
  }

  public static void a(Context paramContext)
  {
    a[] arrayOfa = a.values();
    int i = arrayOfa.length;
    int j = 0;
    if (j < i)
    {
      a locala = arrayOfa[j];
      if (locala == a.a);
      while (true)
      {
        j++;
        break;
        if ((locala != a.c) && (locala != a.j))
          if (locala == a.i)
            d.a(paramContext).a();
          else
            locala.a(paramContext);
      }
    }
    a();
    g.a();
  }

  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 1;
    case 0:
    }
    return 2;
  }

  private static String b(int paramInt, long paramLong)
  {
    String str = a(paramInt);
    if (paramLong > 0L)
      str = str + "_" + paramLong;
    return str;
  }

  public static enum a
  {
    public int k;

    static
    {
      a[] arrayOfa = new a[10];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
    }

    private a(int paramInt)
    {
      this.k = paramInt;
    }

    private void a(Context paramContext, int paramInt, String paramString)
    {
      if (p.b(paramInt) == 1)
      {
        e.a(paramContext, paramString);
        return;
      }
      u.a(paramString);
    }

    public void a(Context paramContext)
    {
      a(paramContext, Bundle.EMPTY, false);
    }

    public void a(Context paramContext, long paramLong)
    {
      a(paramContext, this.k, p.a(this.k, paramLong));
    }

    public void a(Context paramContext, long paramLong, Bundle paramBundle, boolean paramBoolean)
    {
      if (p.b(this.k) == 1)
      {
        e.a(paramContext, this.k, p.a(this.k, paramLong), paramBundle, paramBoolean);
        return;
      }
      u.a(this.k, p.a(this.k, paramLong), paramBundle, paramBoolean);
    }

    public void a(Context paramContext, Bundle paramBundle, boolean paramBoolean)
    {
      a(paramContext, 0L, paramBundle, paramBoolean);
    }

    public void b(Context paramContext)
    {
      a(paramContext, Bundle.EMPTY, true);
    }

    public void c(Context paramContext)
    {
      a(paramContext, this.k, p.a(this.k));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.p
 * JD-Core Version:    0.6.2
 */