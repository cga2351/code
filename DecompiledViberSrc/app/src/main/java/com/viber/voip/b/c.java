package com.viber.voip.b;

public abstract interface c<K, V>
{
  public abstract void evictAll();

  public abstract V get(K paramK);

  public abstract V put(K paramK, V paramV);

  public abstract V remove(K paramK);

  public abstract int size();

  public abstract void trimToSize(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c
 * JD-Core Version:    0.6.2
 */