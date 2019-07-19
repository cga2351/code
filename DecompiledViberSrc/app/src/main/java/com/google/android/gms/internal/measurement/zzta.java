package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzta<E> extends AbstractList<E>
  implements zzuu<E>
{
  private boolean zzbtn = true;

  public void add(int paramInt, E paramE)
  {
    zzua();
    super.add(paramInt, paramE);
  }

  public boolean add(E paramE)
  {
    zzua();
    return super.add(paramE);
  }

  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    zzua();
    return super.addAll(paramInt, paramCollection);
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    zzua();
    return super.addAll(paramCollection);
  }

  public void clear()
  {
    zzua();
    super.clear();
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!(paramObject instanceof List))
        return false;
      if (!(paramObject instanceof RandomAccess))
        return super.equals(paramObject);
      List localList = (List)paramObject;
      int i = size();
      if (i != localList.size())
        return false;
      for (int j = 0; j < i; j++)
        if (!get(j).equals(localList.get(j)))
          return false;
    }
  }

  public int hashCode()
  {
    int i = size();
    int j = 1;
    for (int k = 0; k < i; k++)
      j = j * 31 + get(k).hashCode();
    return j;
  }

  public E remove(int paramInt)
  {
    zzua();
    return super.remove(paramInt);
  }

  public boolean remove(Object paramObject)
  {
    zzua();
    return super.remove(paramObject);
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    zzua();
    return super.removeAll(paramCollection);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    zzua();
    return super.retainAll(paramCollection);
  }

  public E set(int paramInt, E paramE)
  {
    zzua();
    return super.set(paramInt, paramE);
  }

  public final void zzsw()
  {
    this.zzbtn = false;
  }

  public boolean zztz()
  {
    return this.zzbtn;
  }

  protected final void zzua()
  {
    if (!this.zzbtn)
      throw new UnsupportedOperationException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzta
 * JD-Core Version:    0.6.2
 */