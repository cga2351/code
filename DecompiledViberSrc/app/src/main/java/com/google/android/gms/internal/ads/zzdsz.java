package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzdsz<E> extends AbstractList<E>
{
  private static final zzdtb zzcp = zzdtb.zzm(zzdsz.class);
  List<E> zzhtv;
  Iterator<E> zzhtw;

  public zzdsz(List<E> paramList, Iterator<E> paramIterator)
  {
    this.zzhtv = paramList;
    this.zzhtw = paramIterator;
  }

  public E get(int paramInt)
  {
    if (this.zzhtv.size() > paramInt)
      return this.zzhtv.get(paramInt);
    if (this.zzhtw.hasNext())
    {
      this.zzhtv.add(this.zzhtw.next());
      return get(paramInt);
    }
    throw new NoSuchElementException();
  }

  public Iterator<E> iterator()
  {
    return new zzdta(this);
  }

  public int size()
  {
    zzcp.zzhc("potentially expensive size() call");
    zzcp.zzhc("blowup running");
    while (this.zzhtw.hasNext())
      this.zzhtv.add(this.zzhtw.next());
    return this.zzhtv.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsz
 * JD-Core Version:    0.6.2
 */