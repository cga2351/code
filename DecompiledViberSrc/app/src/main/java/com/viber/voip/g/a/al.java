package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.backup.auto.a;
import com.viber.voip.backup.auto.d;
import com.viber.voip.backup.f;
import com.viber.voip.backup.g;
import com.viber.voip.backup.h;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.j;
import com.viber.voip.util.cj;
import javax.inject.Singleton;

public abstract class al
{
  static a a(Context paramContext, g paramg, cj paramcj)
  {
    com.viber.voip.backup.auto.b localb = new com.viber.voip.backup.auto.b(d.j.k);
    d locald = new d(d.j.j);
    return new a(paramContext, paramcj, new com.viber.voip.backup.b(paramContext, d.j.g, localb, locald, p.a.a), localb, locald, new com.viber.voip.backup.auto.c(paramg, localb, locald), new com.viber.voip.util.i.c());
  }

  @Singleton
  static com.viber.voip.backup.c a(Context paramContext, Engine paramEngine, g paramg)
  {
    com.viber.voip.backup.c localc = new com.viber.voip.backup.c(paramContext, paramEngine);
    paramg.b(localc);
    return localc;
  }

  static g a()
  {
    return g.a();
  }

  @Singleton
  static h a(Context paramContext, g paramg, f paramf, Handler paramHandler, Engine paramEngine)
  {
    h localh = new h(paramContext, paramg, paramf, paramHandler);
    localh.a(paramEngine);
    return localh;
  }

  static f b()
  {
    return f.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.al
 * JD-Core Version:    0.6.2
 */