package com.viber.voip.messages.controller.a;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.ArraySet;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.av;
import java.util.List;
import java.util.Set;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final d c;
  private final ab d;
  private final dagger.a<bs> e;
  private final o f;
  private final Handler g;
  private final boolean h;
  private final com.viber.common.b.d i;
  private final com.viber.common.b.b j;
  private final boolean k;

  public a(Context paramContext, d paramd, ab paramab, dagger.a<bs> parama, o paramo, Handler paramHandler, boolean paramBoolean1, com.viber.common.b.d paramd1, com.viber.common.b.b paramb, boolean paramBoolean2)
  {
    this.b = paramContext;
    this.c = paramd;
    this.d = paramab;
    this.e = parama;
    this.f = paramo;
    this.g = paramHandler;
    this.h = paramBoolean1;
    this.i = paramd1;
    this.j = paramb;
    this.k = paramBoolean2;
  }

  private int a(int paramInt)
  {
    if (!b())
      paramInt = 0;
    do
    {
      return paramInt;
      if (av.c(paramInt, 4))
        paramInt = av.a(paramInt, 0);
    }
    while (!av.c(paramInt, 5));
    return av.a(paramInt, 1);
  }

  private void d()
  {
    int m = this.i.d();
    int n = f();
    if (m == n);
    ArraySet localArraySet;
    do
    {
      List localList;
      int i1;
      do
      {
        return;
        this.i.a(n);
        localList = this.d.e();
        i1 = localList.size();
      }
      while (i1 == 0);
      localArraySet = new ArraySet(i1);
      this.d.a(new c(this, i1, localList, localArraySet));
    }
    while (localArraySet.size() <= 0);
    this.f.a(localArraySet, 0, false, false);
  }

  private void e()
  {
    if ((!b()) || (!this.j.d()));
    while (!this.d.F())
      return;
    com.viber.voip.messages.b.a((bs)this.e.get(), this.b);
    this.j.a(false);
  }

  private int f()
  {
    if (this.h);
    for (int m = 1; ; m = 0)
      return m * 31 + this.c.a().getItemsHashCode();
  }

  public void a()
  {
    if (this.k)
      return;
    this.g.post(new b(this));
  }

  public boolean a(int paramInt, h paramh)
  {
    boolean bool1 = av.d(paramInt, 1024);
    int m;
    int i5;
    int i6;
    if ((bool1) && (!av.d(paramInt, 1048576)))
    {
      m = 1;
      if ((paramh.am()) || (m == paramh.aj()))
        break label267;
      i5 = paramh.ai();
      if (!b())
        break label199;
      i6 = 0;
      label56: if (m == 0)
        break label205;
      paramh.n(av.a(i5, i6));
    }
    label72: label91: label225: label244: for (boolean bool2 = true; ; bool2 = false)
    {
      int n;
      int i4;
      if ((bool1) && (!av.d(paramInt, 2097152)))
      {
        n = 1;
        if (n == paramh.ak())
          break label260;
        i4 = paramh.ai();
        if (n == 0)
          break label225;
        paramh.n(av.a(i4, 2));
      }
      label121: for (boolean bool3 = true; ; bool3 = bool2)
      {
        int i1 = 0;
        if (bool1)
        {
          boolean bool4 = av.d(paramInt, 8);
          i1 = 0;
          if (!bool4)
            i1 = 1;
        }
        if (i1 != paramh.al())
        {
          int i2 = paramh.ai();
          if (b());
          for (int i3 = 1; ; i3 = 5)
          {
            if (i1 == 0)
              break label244;
            paramh.n(av.a(i2, i3));
            return true;
            m = 0;
            break;
            i6 = 4;
            break label56;
            paramh.n(av.b(i5, i6));
            break label72;
            n = 0;
            break label91;
            paramh.n(av.b(i4, 2));
            break label121;
          }
          paramh.n(av.b(i2, i3));
          return true;
        }
        return bool3;
      }
    }
  }

  public boolean a(h paramh)
  {
    int m = paramh.ai();
    paramh.n(a(m));
    return m != paramh.ai();
  }

  public boolean b()
  {
    return (!this.k) && (this.h);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.a.a
 * JD-Core Version:    0.6.2
 */