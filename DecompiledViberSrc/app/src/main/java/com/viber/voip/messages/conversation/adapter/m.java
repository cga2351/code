package com.viber.voip.messages.conversation.adapter;

import com.viber.voip.messages.conversation.ac;
import java.util.HashMap;
import java.util.Map;

public class m
{
  private ac a;
  private Map<Integer, s> b;
  private int c;
  private int[] d;
  private int e;
  private int[] f;

  public m(ac paramac)
  {
    this.a = paramac;
    this.b = new HashMap();
  }

  private boolean c(int paramInt)
  {
    return (this.d != null) && (paramInt >= this.d[0]) && (paramInt < this.d[1]);
  }

  private boolean d(int paramInt)
  {
    return (this.f != null) && (paramInt >= this.f[0]) && (paramInt < this.f[1]);
  }

  public int a()
  {
    return this.c;
  }

  public void a(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.c;
    arrayOfInt[1] = (paramInt + this.c);
    this.f = arrayOfInt;
    this.c = (paramInt + this.c);
  }

  public void a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.c;
    arrayOfInt[1] = (paramInt1 + this.c);
    this.d = arrayOfInt;
    this.e = paramInt2;
    this.c = (paramInt1 + this.c);
  }

  public void a(s params)
  {
    Map localMap = this.b;
    int i = this.c;
    this.c = (i + 1);
    localMap.put(Integer.valueOf(i), params);
  }

  public s b(int paramInt)
  {
    Object localObject = (s)this.b.get(Integer.valueOf(paramInt));
    if ((localObject == null) && (this.a != null) && (this.a.getCount() > 0))
    {
      if (!c(paramInt))
        break label78;
      localObject = this.a.e(paramInt - this.d[0]);
    }
    while (true)
    {
      if (localObject == null)
        localObject = new q(8);
      return localObject;
      label78: if (d(paramInt))
        localObject = this.a.e(paramInt - this.f[0] + this.e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.m
 * JD-Core Version:    0.6.2
 */