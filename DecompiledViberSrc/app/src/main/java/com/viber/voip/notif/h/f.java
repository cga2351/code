package com.viber.voip.notif.h;

import android.support.v4.util.CircularArray;
import android.support.v4.util.LongSparseArray;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.SparseSet;
import java.util.List;

public class f
{
  private final dagger.a<ab> a;
  private final dagger.a<ak> b;
  private final dagger.a<l> c;
  private h.a d;

  public f(dagger.a<ab> parama, dagger.a<ak> parama1, dagger.a<l> parama2)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
    this.d = new h.a(0);
  }

  private h a(List<a> paramList)
  {
    return ((l)this.c.get()).a(paramList, this.a, this.b);
  }

  public CircularArray<g> a()
  {
    return b();
  }

  public CircularArray<g> a(LongSparseSet paramLongSparseSet)
  {
    return b();
  }

  public SparseSet a(long paramLong)
  {
    return (SparseSet)this.d.b.get(paramLong);
  }

  public boolean a(int paramInt)
  {
    return this.d.c.contains(paramInt);
  }

  public CircularArray<g> b()
  {
    h localh = a(((l)this.c.get()).a());
    this.d = localh.b;
    return localh.a;
  }

  public LongSparseSet c()
  {
    return this.d.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.f
 * JD-Core Version:    0.6.2
 */