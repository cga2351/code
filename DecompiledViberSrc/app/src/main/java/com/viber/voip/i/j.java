package com.viber.voip.i;

import android.os.SystemClock;
import android.text.TextUtils;
import com.viber.common.b.b;
import com.viber.common.b.i;
import com.viber.dexshared.Logger;
import com.viber.jni.remoteconfig.RemoteConfigDelegate;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.a.a.a;
import com.viber.voip.flatbuffers.model.a.a.b;
import com.viber.voip.flatbuffers.model.a.a.c;
import com.viber.voip.flatbuffers.model.a.a.d;
import com.viber.voip.flatbuffers.model.a.a.e;
import com.viber.voip.flatbuffers.model.a.a.e.a;
import com.viber.voip.flatbuffers.model.a.a.f;
import com.viber.voip.flatbuffers.model.a.a.g;
import com.viber.voip.flatbuffers.model.a.a.h;
import com.viber.voip.flatbuffers.model.a.a.i;
import com.viber.voip.flatbuffers.model.a.a.j;
import com.viber.voip.settings.d.ab;
import com.viber.voip.settings.d.at;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.d.n;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.d.t;
import com.viber.voip.settings.d.v;
import com.viber.voip.settings.d.z;
import com.viber.voip.util.da;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.Subscribe;

public class j
  implements RemoteConfigDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.MINUTES.toMillis(20L);
  private final com.viber.voip.messages.extensions.h c;
  private final com.viber.voip.notif.h d;
  private final com.viber.voip.messages.extensions.c e;
  private long f = -1L;
  private int g = 0;

  public j(com.viber.voip.messages.extensions.h paramh, com.viber.voip.notif.h paramh1, com.viber.voip.messages.extensions.c paramc)
  {
    this.c = paramh;
    this.d = paramh1;
    this.e = paramc;
  }

  private com.viber.voip.flatbuffers.model.a.a a(String paramString)
  {
    int i = 0;
    while (true)
      try
      {
        com.viber.voip.flatbuffers.model.a.a locala = (com.viber.voip.flatbuffers.model.a.a)com.viber.voip.flatbuffers.b.e.d().a().a(paramString);
        return locala;
      }
      catch (Throwable localThrowable)
      {
        if (i >= 5)
        {
          a.a(localThrowable, null);
          return null;
        }
        a.a(localThrowable, "retry: " + i);
        SystemClock.sleep(100L);
        i++;
      }
  }

  private void a(a.d paramd)
  {
    if (paramd == null);
    do
    {
      return;
      boolean bool = paramd.a();
      c.g.a.a(bool);
    }
    while (c.g.a.h() != 2147483647);
    d.m.w.a(paramd.b());
  }

  private void a(com.viber.voip.flatbuffers.model.a.a parama)
  {
    b(parama);
  }

  private void b(com.viber.voip.flatbuffers.model.a.a parama)
  {
    c(parama);
    d(parama);
    f(parama);
    g(parama);
    e(parama);
    h(parama);
    i(parama);
    j(parama);
  }

  private void c(com.viber.voip.flatbuffers.model.a.a parama)
  {
    a.f localf = parama.a();
    if (localf != null)
    {
      c.b.a.a(localf.d());
      c.i.a.a(localf.i());
      c.m.a.a(localf.f());
      c.c.a.a(localf.g());
      c.c.b.a(localf.h());
      c.a.a.a(localf.j());
      c.h.d.a(localf.k());
      d.r.n.a(new HashSet(localf.e()));
      c.h.c.a(localf.a());
      c.n.a.a(localf.b());
      c.o.a.a(localf.c());
      Integer localInteger1 = localf.l();
      if (localInteger1 == null)
        break label237;
      d.z.n.a(String.valueOf(localInteger1));
    }
    while (true)
    {
      Integer localInteger2 = localf.m();
      if ((localInteger2 != null) && (localInteger2.intValue() > 0))
        d.v.g.a(localInteger2.intValue());
      c.j.b.a(localf.o());
      c.j.a.a(localf.n());
      Boolean localBoolean = localf.p();
      if (localBoolean != null)
        this.d.a(localBoolean.booleanValue());
      c.p.a.a(localf.r());
      a(localf.q());
      return;
      label237: d.z.n.e();
    }
  }

  private void d(com.viber.voip.flatbuffers.model.a.a parama)
  {
    a.i locali = parama.c();
    int i;
    a.h localh;
    int j;
    label46: com.viber.common.b.h localh1;
    if ((locali != null) && (!da.a(locali.a())))
    {
      i = 1;
      localh = parama.g();
      if ((localh == null) || (da.a(localh.a())))
        break label113;
      j = 1;
      boolean bool;
      if (i == 0)
      {
        bool = false;
        if (j == 0);
      }
      else
      {
        bool = true;
      }
      c.h.b.a(bool);
      if ((bool) && (c.h.b.h() == 2147483647))
      {
        localh1 = d.r.p;
        if (i == 0)
          break label119;
      }
    }
    label113: label119: for (String str = locali.a(); ; str = localh.a())
    {
      localh1.a(str);
      return;
      i = 0;
      break;
      j = 0;
      break label46;
    }
  }

  private void e(com.viber.voip.flatbuffers.model.a.a parama)
  {
    a.b localb = parama.e();
    if (localb == null)
      return;
    c.h.a.a(localb.a());
    if (localb.b().isEmpty())
    {
      this.c.a("");
      this.e.a(Collections.emptyList());
    }
    while (true)
    {
      d.n.j.a(localb.c());
      return;
      String str = TextUtils.join(",", localb.b());
      this.c.a(str);
    }
  }

  private void f(com.viber.voip.flatbuffers.model.a.a parama)
  {
    a.g localg = parama.b();
    a.a locala;
    f localf;
    if (localg == null)
    {
      locala = parama.d();
      localf = c.l.b;
      if (locala != null)
        break label101;
    }
    label99: label101: for (int i = 0; ; i = locala.a())
    {
      localf.a(i);
      return;
      if (d.ab.a.d());
      while (true)
      {
        if (d.ab.b.d())
          break label99;
        String str2 = localg.b();
        if (da.a(str2))
          break;
        d.ab.d.a(str2);
        break;
        String str1 = localg.a();
        if (!da.a(str1))
          d.ab.c.a(str1);
      }
      break;
    }
  }

  private void g(com.viber.voip.flatbuffers.model.a.a parama)
  {
    a.a locala = parama.d();
    if (locala != null)
    {
      c.b.e.a(locala.c());
      c.b.b.a(locala.b());
      c.b.f.a(locala.d());
      c.b.c.a(locala.e());
      c.b.d.a(locala.f());
      c.b.g.a(locala.g());
      c.b.p.a(locala.h());
    }
  }

  private void h(com.viber.voip.flatbuffers.model.a.a parama)
  {
    a.j localj = parama.f();
    if (localj != null)
      c.e.a.a(localj.a());
  }

  private void i(com.viber.voip.flatbuffers.model.a.a parama)
  {
    int i = 1;
    a.e locale = parama.h();
    if (locale != null)
    {
      a.e.a locala = locale.a();
      if (locala != null)
      {
        c.i.b.a(i);
        if (locala.a());
        while (true)
        {
          d.t.a.a(i);
          d.t.b.a(locala.b());
          return;
          int j = 0;
        }
      }
      c.i.b.a(false);
      return;
    }
    c.i.b.a(false);
  }

  private void j(com.viber.voip.flatbuffers.model.a.a parama)
  {
    a.c localc = parama.i();
    if (localc == null)
      return;
    c.f.a.a(localc.a());
    c.f.b.a(localc.b());
    c.f.c.a(localc.c());
    c.f.d.a(localc.d());
  }

  @Subscribe
  public void onClearPrefsEvent(com.viber.voip.settings.a parama)
  {
    try
    {
      this.f = -1L;
      this.g = 0;
      return;
    }
    finally
    {
    }
  }

  public void onConfigChange(String paramString)
  {
    long l = System.currentTimeMillis();
    if (paramString != null);
    try
    {
      if ((this.g == paramString.hashCode()) && (l - this.f < b))
        return;
      com.viber.voip.e.a.e.b().a("SYNC", "RemoteConfig onConfigChange");
      com.viber.voip.flatbuffers.model.a.a locala = a(paramString);
      com.viber.voip.e.a.e.b().a("SYNC", "RemoteConfig onConfigChange", "parse");
      if (locala != null)
      {
        this.f = l;
        this.g = paramString.hashCode();
        a(locala);
        d.at.a.a(0);
      }
      this.c.b();
      com.viber.voip.e.a.e.b().b("SYNC", "RemoteConfig onConfigChange");
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.j
 * JD-Core Version:    0.6.2
 */