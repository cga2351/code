package com.viber.voip.notif.h;

import android.support.v4.util.CircularArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.SparseSet;
import dagger.a;
import java.util.List;

public class e
{
  private static final Logger a = ViberEnv.getLogger();
  private SparseSet b = new SparseSet();
  private LongSparseSet c = new LongSparseSet();
  private final a<l> d;

  public e(a<l> parama)
  {
    this.d = parama;
  }

  private CircularArray<d> d()
  {
    List localList = ((l)this.d.get()).c();
    SparseSet localSparseSet = new SparseSet(this.b.size());
    localSparseSet.addAll(this.b);
    this.b.clear();
    int i = localList.size();
    int j = localSparseSet.size();
    if (i == 0);
    CircularArray localCircularArray;
    for (int k = 1; ; k = i)
    {
      localCircularArray = new CircularArray(k);
      for (int m = 0; m < i; m++)
      {
        d locald = (d)localList.get(m);
        int n = locald.hashCode();
        this.b.add(n);
        this.c.add(locald.a());
        if ((j == 0) || (!localSparseSet.contains(n)))
          localCircularArray.addLast(locald);
      }
    }
    return localCircularArray;
  }

  public CircularArray<d> a()
  {
    return b();
  }

  public CircularArray<d> a(LongSparseSet paramLongSparseSet)
  {
    this.b.clear();
    this.c.clear();
    return d();
  }

  public CircularArray<d> b()
  {
    return d();
  }

  public LongSparseSet c()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.e
 * JD-Core Version:    0.6.2
 */