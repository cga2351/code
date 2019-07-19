package com.viber.voip;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import c.a.a.a.i;
import com.viber.common.a.a.a;
import com.viber.common.b.j;
import com.viber.common.dialogs.x;
import com.viber.common.dialogs.y;
import com.viber.common.jni.NativeLibraryLoader;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.jni.NativeFilesLoaderLibraries;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.l.d;
import com.viber.voip.i.c.m;
import com.viber.voip.settings.d.f;
import com.viber.voip.util.bp;
import java.util.Locale;

public class bk
{
  public static String a;
  private static boolean b = false;
  private static Context c;

  public static String a()
  {
    return a;
  }

  public static void a(Context paramContext)
  {
    try
    {
      if (!b)
      {
        a = paramContext.getResources().getConfiguration().locale.getLanguage();
        System.currentTimeMillis();
        b(paramContext);
        b = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static void a(Context paramContext, com.viber.voip.g.b.b<com.crashlytics.android.a> paramb, com.viber.voip.g.b.b<com.crashlytics.android.a.b> paramb1)
  {
    com.viber.voip.e.a.e.b().a("APP START", "initCrashlytics");
    ViberEnv.getLogger();
    if ((c.m.a.e()) || (paramb1 != null));
    try
    {
      i[] arrayOfi2 = new i[3];
      arrayOfi2[0] = ((i)paramb.get());
      arrayOfi2[1] = new com.crashlytics.android.ndk.c();
      arrayOfi2[2] = ((i)paramb1.get());
      c.a.a.a.c.a(paramContext, arrayOfi2);
      while (true)
      {
        new com.viber.voip.g.b.c(bm.a);
        label86: com.viber.voip.e.a.e.b().b("APP START", "initCrashlytics");
        return;
        i[] arrayOfi1 = new i[2];
        arrayOfi1[0] = ((i)paramb.get());
        arrayOfi1[1] = new com.crashlytics.android.ndk.c();
        c.a.a.a.c.a(paramContext, arrayOfi1);
      }
    }
    catch (Throwable localThrowable)
    {
      break label86;
    }
  }

  private static void a(com.viber.common.a.a parama)
  {
    ViberEnv.getLoggerFactory().init(c, parama);
  }

  public static Context b()
  {
    return c;
  }

  private static void b(Context paramContext)
  {
    c = paramContext;
    j.a(c, "com.viber.voip.ViberPrefs", new com.viber.voip.settings.e());
    com.viber.voip.h.a.a();
    com.viber.voip.g.b.b local1 = new com.viber.voip.g.b.b(false, true)
    {
      protected com.crashlytics.android.a a()
      {
        return new com.crashlytics.android.a();
      }
    };
    com.viber.voip.o.a.a(paramContext);
    ViberEnv.init(new bj());
    d();
    com.viber.voip.react.f.a();
    com.viber.voip.e.a.e.a();
    com.viber.voip.e.a.c localc = com.viber.voip.e.a.e.b();
    localc.a("APP START", "total");
    localc.a("APP START", "ViberSetup");
    localc.a("APP START", "NativeLibraryLoader");
    NativeLibraryLoader.init(paramContext, NativeLibraryLoader.convertLibrarySizesFromSimpleArray(NativeFilesLoaderLibraries.libSizes), ViberEnv.getLogger("[NativeLibraryLoader]"));
    localc.b("APP START", "NativeLibraryLoader");
    ViberApplication.preferences(paramContext);
    y.a(bp.c(c.getApplicationContext()));
    com.viber.common.app.c.a();
    if (d.f.c.d());
    for (com.viber.voip.g.b.b local2 = new com.viber.voip.g.b.b(false, true)
    {
      protected com.crashlytics.android.a.b a()
      {
        return new com.crashlytics.android.a.b();
      }
    }
    ; ; local2 = null)
    {
      com.viber.voip.g.b.c localc1 = new com.viber.voip.g.b.c(new bl(localc));
      a(paramContext, local1, local2);
      com.viber.deviceinfo.a.a(paramContext);
      localc.a("APP START", "lazyInitDependencies.get()");
      localc1.a();
      localc.b("APP START", "lazyInitDependencies.get()");
      localc.b("APP START", "ViberSetup");
      return;
    }
  }

  private static void d()
  {
    a(new a.a().a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bk
 * JD-Core Version:    0.6.2
 */