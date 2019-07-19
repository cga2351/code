package com.google.android.exoplayer2.g;

import java.util.PriorityQueue;

public final class u
{
  private final Object a;
  private final PriorityQueue<Integer> b;
  private int c;

  public void a(int paramInt)
  {
    synchronized (this.a)
    {
      this.b.add(Integer.valueOf(paramInt));
      this.c = Math.max(this.c, paramInt);
      return;
    }
  }

  public void b(int paramInt)
  {
    synchronized (this.a)
    {
      this.b.remove(Integer.valueOf(paramInt));
      if (this.b.isEmpty())
      {
        i = -2147483648;
        this.c = i;
        this.a.notifyAll();
        return;
      }
      int i = ((Integer)ag.a(this.b.peek())).intValue();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.u
 * JD-Core Version:    0.6.2
 */