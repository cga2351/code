package com.viber.voip.util;

import java.util.LinkedList;

public class au<E> extends LinkedList<E>
{
  private int a;

  public au(int paramInt)
  {
    this.a = paramInt;
  }

  public boolean add(E paramE)
  {
    super.add(paramE);
    while (size() > this.a)
      remove();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.au
 * JD-Core Version:    0.6.2
 */