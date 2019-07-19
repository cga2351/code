package com.viber.voip.viberout.a;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.voip.api.a.b.a.c;
import com.viber.voip.api.a.b.a.e;
import com.viber.voip.api.a.b.a.f;
import com.viber.voip.api.a.b.a.g;
import com.viber.voip.api.a.b.a.j;
import com.viber.voip.api.a.b.a.m;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.util.bp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

public class t
{
  private final Handler a;
  private final Handler b;
  private final com.viber.voip.api.a.b.a c;
  private final com.viber.voip.registration.af d;
  private final com.viber.voip.billing.af e;
  private final Resources f;
  private final d g;
  private List<c> h;

  @Inject
  public t(Handler paramHandler1, Handler paramHandler2, com.viber.voip.api.a.b.a parama, com.viber.voip.registration.af paramaf, com.viber.voip.billing.af paramaf1, d paramd, Resources paramResources)
  {
    this.a = paramHandler1;
    this.b = paramHandler2;
    this.c = parama;
    this.g = paramd;
    this.d = paramaf;
    this.e = paramaf1;
    this.f = paramResources;
  }

  private String a()
  {
    return bp.a(this.f).getLanguage();
  }

  public void a(a parama)
  {
    this.a.post(new w(this, parama));
  }

  public void a(final b paramb)
  {
    if (com.viber.voip.util.u.a(this.h))
    {
      this.c.a(a()).a(new g.d()
      {
        public void a(g.b<f> paramAnonymousb, g.l<f> paramAnonymousl)
        {
          f localf = (f)paramAnonymousl.b();
          if (localf == null)
            paramb.a();
          do
          {
            return;
            if (localf.a() == 1)
            {
              List localList = Arrays.asList(localf.b());
              t.a(t.this, localList);
              paramb.a(localList);
              return;
            }
            if (localf.a() == 105)
            {
              paramb.a();
              return;
            }
          }
          while (localf.a() != 0);
          paramb.a();
        }

        public void a(g.b<f> paramAnonymousb, Throwable paramAnonymousThrowable)
        {
          paramb.a();
        }
      });
      return;
    }
    paramb.a(this.h);
  }

  public void a(String paramString, c paramc)
  {
    this.a.post(new u(this, paramString, paramc));
  }

  public void b(String paramString, c paramc)
  {
    this.a.post(new v(this, paramString, paramc));
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(com.viber.voip.api.a.b.a.l paraml, List<com.viber.voip.api.a.b.a.b> paramList);

    public abstract void b();
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(List<c> paramList);
  }

  public static abstract interface c
  {
    public abstract void a();

    public abstract void a(List<j> paramList, List<com.viber.voip.api.a.b.a.d> paramList1, List<m> paramList2);

    public abstract void b();
  }

  public static class d
  {
    private final HardwareParameters a;
    private final com.viber.voip.registration.af b;
    private final a c;
    private final h d;
    private final h e;
    private final h f;

    public d(HardwareParameters paramHardwareParameters, com.viber.voip.registration.af paramaf, a parama, h paramh1, h paramh2, h paramh3)
    {
      this.a = paramHardwareParameters;
      this.b = paramaf;
      this.c = parama;
      this.d = paramh1;
      this.e = paramh2;
      this.f = paramh3;
    }

    public a a()
    {
      return new a();
    }

    public a a(String paramString)
    {
      // Byte code:
      //   0: new 43	com/viber/voip/viberout/a/t$d$1
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 44	com/viber/voip/viberout/a/t$d$1:<init>	(Lcom/viber/voip/viberout/a/t$d;)V
      //   8: aload_1
      //   9: invokevirtual 46	com/viber/voip/viberout/a/t$d$1:b	(Ljava/lang/String;)Lcom/viber/voip/viberout/a/t$d$a;
      //   12: areturn
    }

    public class a
    {
      final Map<String, String> b = new HashMap();
      String c;
      String d;
      String e;
      boolean f = true;

      public a()
      {
      }

      public a a(String paramString)
      {
        this.c = paramString;
        return this;
      }

      public void a()
      {
        d();
        c();
      }

      public a b(String paramString)
      {
        this.d = paramString;
        return this;
      }

      public Map<String, String> b()
      {
        this.b.clear();
        a();
        return this.b;
      }

      public a c(String paramString)
      {
        this.e = paramString;
        return this;
      }

      public void c()
      {
        this.b.put("top_free_calls", TextUtils.join(",", t.d.a(t.d.this).c()));
        this.b.put("top_countries", TextUtils.join(",", t.d.a(t.d.this).a()));
        this.b.put("top_vo_calls", TextUtils.join(",", t.d.a(t.d.this).b()));
      }

      public void d()
      {
        this.b.put("phone", t.d.b(t.d.this).g());
        this.b.put("mcc", t.d.c(t.d.this).getMCC());
        this.b.put("mnc", t.d.c(t.d.this).getMNC());
        this.b.put("sim_mcc", t.d.c(t.d.this).getSimMCC());
        this.b.put("sim_mnc", t.d.c(t.d.this).getSimMNC());
        this.b.put("lang", this.e);
        this.b.put("cc", t.d.b(t.d.this).e());
        if (!TextUtils.isEmpty(this.c))
          this.b.put("referral", this.c);
        if (!TextUtils.isEmpty(this.d))
          this.b.put("dest_cc", this.d);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.t
 * JD-Core Version:    0.6.2
 */