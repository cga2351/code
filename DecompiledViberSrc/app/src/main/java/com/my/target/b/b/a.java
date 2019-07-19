package com.my.target.b.b;

import android.content.Context;
import android.view.View;
import com.my.target.b.a.b.a;
import com.my.target.bb;
import com.my.target.bh;
import com.my.target.bi;
import com.my.target.bz.a;
import com.my.target.dp;
import com.my.target.i;
import com.my.target.q;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private final com.my.target.c.a a;
  private final ArrayList<com.my.target.b.c.a.b> b = new ArrayList();
  private final a c = new a((byte)0);
  private final com.my.target.b.c.a.a d;
  private final bb e = bb.a();
  private final com.my.target.b.a.b f;
  private final bh g;
  private final bz.a h;
  private boolean i;

  private a(com.my.target.c.a parama, com.my.target.b.c.a.a parama1)
  {
    this.a = parama;
    this.d = parama1;
    this.f = com.my.target.b.a.b.a(parama1, new b(this));
    float f1 = parama1.E();
    if (f1 == 1.0F);
    for (this.g = bh.a; ; this.g = bh.a((int)(f1 * 1000.0F)))
    {
      this.h = new c(this.c, this.g, this.f);
      return;
    }
  }

  public static a a(com.my.target.c.a parama, com.my.target.b.c.a.a parama1)
  {
    return new a(parama, parama1);
  }

  private void a(i parami, View paramView)
  {
    if (parami != null)
    {
      Context localContext = paramView.getContext();
      if (localContext != null)
        this.e.a(parami, localContext);
    }
    com.my.target.c.a.a locala = this.a.a();
    if (locala != null)
      locala.b(this.a);
  }

  public final void a()
  {
    this.f.f();
    this.g.b(this.c);
  }

  final void a(View paramView)
  {
    dp.a("Click received by native ad");
    if (paramView != null)
      a(this.d, paramView);
  }

  final void a(View paramView, int paramInt)
  {
    dp.a("Click on native card received");
    List localList = this.d.G();
    if ((paramInt >= 0) && (paramInt < localList.size()))
      a((com.my.target.b.c.a.b)localList.get(paramInt), paramView);
    q localq = this.d.y();
    Context localContext = paramView.getContext();
    if (localContext != null)
      bi.a(localq.a("click"), localContext);
  }

  public final void a(View paramView, List<View> paramList, int paramInt)
  {
    a();
    this.f.a(paramView, paramList, this.h, paramInt);
    if (((!this.i) || (this.f.c() == 1)) && ((this.f.i()) || (this.f.b())))
      this.g.a(this.c);
  }

  final void a(View paramView, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    for (int k = 0; k < j; k++)
    {
      int m = paramArrayOfInt[k];
      com.my.target.b.c.a.b localb = (com.my.target.b.c.a.b)this.d.G().get(m);
      if ((this.i) && (!this.b.contains(localb)))
      {
        if (localb != null)
        {
          q localq = localb.y();
          Context localContext = paramView.getContext();
          if (localContext != null)
            bi.a(localq.a("playbackStarted"), localContext);
        }
        this.b.add(localb);
      }
    }
  }

  final void b()
  {
    int j = this.f.d();
    Context localContext = this.f.a();
    if ((j == -1) || (localContext == null))
    {
      this.g.b(this.c);
      this.f.e();
    }
    do
    {
      return;
      if ((this.i) && (this.f.c() != 1))
      {
        this.g.b(this.c);
        this.f.g();
        return;
      }
      if (j == 1)
      {
        if (!this.i)
        {
          this.i = true;
          bi.a(this.d.y().a("playbackStarted"), localContext);
          com.my.target.c.a.a locala = this.a.a();
          if (locala != null)
            locala.c(this.a);
          int k = this.f.c();
          if ((k == 2) || (k == 3))
          {
            int[] arrayOfInt = this.f.h();
            if (arrayOfInt != null)
            {
              int m = arrayOfInt.length;
              for (int n = 0; n < m; n++)
              {
                int i1 = arrayOfInt[n];
                com.my.target.b.c.a.b localb = (com.my.target.b.c.a.b)this.d.G().get(i1);
                if ((this.i) && (!this.b.contains(localb)) && (localb != null))
                {
                  bi.a(localb.y().a("playbackStarted"), localContext);
                  this.b.add(localb);
                }
              }
            }
          }
        }
        if (this.f.c() == 1)
        {
          this.f.a(true);
          return;
        }
        this.g.b(this.c);
        this.f.g();
        return;
      }
    }
    while (this.f.c() != 1);
    this.f.a(false);
  }

  final void c()
  {
    com.my.target.c.a.a locala = this.a.a();
    if (locala != null)
      locala.f(this.a);
  }

  final void d()
  {
    com.my.target.c.a.a locala = this.a.a();
    if (locala != null)
      locala.e(this.a);
  }

  final void e()
  {
    com.my.target.c.a.a locala = this.a.a();
    if (locala != null)
      locala.d(this.a);
  }

  private final class a
    implements Runnable
  {
    private a()
    {
    }

    public final void run()
    {
      a.this.b();
    }
  }

  public static final class b
    implements b.a
  {
    private final a a;

    b(a parama)
    {
      this.a = parama;
    }

    public final void a()
    {
      this.a.e();
    }

    public final void a(View paramView, int paramInt)
    {
      this.a.a(paramView, paramInt);
    }

    public final void a(View paramView, int[] paramArrayOfInt)
    {
      this.a.a(paramView, paramArrayOfInt);
    }

    public final void b()
    {
      this.a.d();
    }

    public final void c()
    {
      this.a.c();
    }

    public final void onClick(View paramView)
    {
      this.a.a(paramView);
    }
  }

  private static final class c
    implements bz.a
  {
    private final a.a a;
    private final bh b;
    private final com.my.target.b.a.b c;

    c(a.a parama, bh parambh, com.my.target.b.a.b paramb)
    {
      this.a = parama;
      this.b = parambh;
      this.c = paramb;
    }

    public final void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.b.a(this.a);
        return;
      }
      this.c.a(false);
      this.b.b(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.b.a
 * JD-Core Version:    0.6.2
 */