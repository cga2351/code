package com.viber.voip.notif.h;

import android.support.v4.util.CircularArray;
import android.support.v4.util.LongSparseArray;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.SparseSet;

class h
{
  final CircularArray<g> a;
  final a b;

  h(int paramInt)
  {
    if (paramInt == 0);
    for (int i = 1; ; i = paramInt)
    {
      this.a = new CircularArray(i);
      this.b = new a(paramInt);
      return;
    }
  }

  void a(g paramg)
  {
    this.a.addLast(paramg);
    a.a(this.b, paramg);
  }

  static class a
  {
    final LongSparseSet a;
    final LongSparseArray<SparseSet> b;
    final SparseSet c;

    a(int paramInt)
    {
      this.a = new LongSparseSet(paramInt);
      this.b = new LongSparseArray(paramInt);
      this.c = new SparseSet(paramInt);
    }

    private void a(g paramg)
    {
      a locala = paramg.a();
      int i = locala.e();
      LongSparseSet localLongSparseSet = locala.b();
      this.c.add(i);
      int j = localLongSparseSet.size();
      for (int k = 0; k < j; k++)
      {
        long l = localLongSparseSet.get(k);
        this.a.add(l);
        SparseSet localSparseSet = (SparseSet)this.b.get(l);
        if (localSparseSet == null)
        {
          localSparseSet = new SparseSet();
          this.b.put(l, localSparseSet);
        }
        localSparseSet.add(i);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.h
 * JD-Core Version:    0.6.2
 */