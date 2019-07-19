package com.viber.voip.notif.d;

import android.content.Context;
import android.support.v4.util.CircularArray;
import com.viber.common.d.a;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f;

public class d extends c
{
  private final c a;
  private final CircularArray<a> b;
  private final String c;
  private final com.viber.voip.notif.c h;

  public d(c paramc, CircularArray<a> paramCircularArray, String paramString, com.viber.voip.notif.c paramc1)
  {
    this.a = paramc;
    this.b = paramCircularArray;
    this.c = paramString;
    this.h = paramc1;
  }

  private void a(o paramo)
  {
    this.a.a(paramo.a(this.c, true));
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      ((a)this.b.get(j)).a.a(paramo.a(this.c));
  }

  private CircularArray<e.b> b(Context paramContext, j paramj)
  {
    CircularArray localCircularArray = new CircularArray(this.b.size());
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      localCircularArray.addLast(((a)this.b.get(j)).a.a(paramContext, paramj, this.h));
    return localCircularArray;
  }

  public String R_()
  {
    return this.a.R_();
  }

  public int a()
  {
    return this.a.a();
  }

  public int b()
  {
    return this.a.b();
  }

  e.b b(Context paramContext, j paramj, com.viber.voip.notif.c paramc)
  {
    if (a.c())
    {
      a(paramj.b());
      final e.b localb = this.a.a(paramContext, paramj, paramc);
      return new e.b()
      {
        public k a(f paramAnonymousf)
        {
          return a(paramAnonymousf, null, d.a(d.this).R_(), d.a(d.this).a());
        }

        public k a(f paramAnonymousf, e.a paramAnonymousa)
        {
          return a(paramAnonymousf, paramAnonymousa, d.a(d.this).R_(), d.a(d.this).a());
        }

        public k a(f paramAnonymousf, e.a paramAnonymousa, String paramAnonymousString, int paramAnonymousInt)
        {
          int i = this.a.size();
          k localk = new k(i + 1);
          for (int j = 0; j < i; j++)
          {
            d.a locala = (d.a)d.b(d.this).get(-1 + (i - j));
            ((e.b)this.a.get(-1 + (i - j))).a(paramAnonymousf, paramAnonymousa, paramAnonymousString, locala.b);
            localk.a(paramAnonymousString, locala.b);
          }
          localk.a(localb.a(paramAnonymousf, paramAnonymousa, paramAnonymousString, paramAnonymousInt));
          return localk;
        }
      };
    }
    return this.a.a(paramContext, paramj, paramc);
  }

  public CharSequence b(Context paramContext)
  {
    return this.a.b(paramContext);
  }

  public CharSequence b_(Context paramContext)
  {
    return this.a.b_(paramContext);
  }

  public com.viber.voip.notif.c d()
  {
    return this.a.d();
  }

  public l g(Context paramContext)
  {
    return this.a.g(paramContext);
  }

  public static class a
  {
    final c a;
    final int b;

    public a(c paramc, int paramInt)
    {
      this.a = paramc;
      this.b = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.d
 * JD-Core Version:    0.6.2
 */