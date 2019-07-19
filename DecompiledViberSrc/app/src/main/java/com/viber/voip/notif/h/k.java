package com.viber.voip.notif.h;

import android.support.v4.util.CircularArray;
import android.support.v4.util.LongSparseArray;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.SparseSet;

class k
{
  final CircularArray<m> a;
  final a b;
  private b c;

  k(int paramInt)
  {
    if (paramInt == 0);
    for (int i = 1; ; i = paramInt)
    {
      this.a = new CircularArray(i);
      this.b = new a(paramInt);
      return;
    }
  }

  private void a()
  {
    if ((this.c != null) && (this.c.a() == 1))
    {
      this.a.popFirst();
      this.a.addFirst(this.c.a(0));
    }
  }

  void a(o paramo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a();
        this.c = null;
      }
      if (this.c == null)
      {
        this.c = new b(paramo);
        this.a.addFirst(this.c);
      }
    }
    while (true)
    {
      if (paramBoolean3)
        a();
      a.a(this.b, paramo);
      return;
      this.c.a(paramo);
      continue;
      this.a.addFirst(paramo);
    }
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

    private void a(o paramo)
    {
      long l = paramo.c().getConversationId();
      this.a.add(l);
      SparseSet localSparseSet = (SparseSet)this.b.get(l);
      if (localSparseSet == null)
      {
        localSparseSet = new SparseSet();
        this.b.append(l, localSparseSet);
      }
      localSparseSet.add(paramo.i());
      this.c.add(paramo.i());
    }

    SparseSet a(LongSparseSet paramLongSparseSet)
    {
      SparseSet localSparseSet = new SparseSet();
      int i = paramLongSparseSet.size();
      for (int j = 0; j < i; j++)
        localSparseSet.addAll((SparseSet)this.b.get(paramLongSparseSet.get(j)));
      return localSparseSet;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.k
 * JD-Core Version:    0.6.2
 */