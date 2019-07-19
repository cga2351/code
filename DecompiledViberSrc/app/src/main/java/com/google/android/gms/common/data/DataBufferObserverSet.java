package com.google.android.gms.common.data;

import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet
  implements DataBufferObserver, DataBufferObserver.Observable
{
  private HashSet<DataBufferObserver> zall = new HashSet();

  public final void addObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.zall.add(paramDataBufferObserver);
  }

  public final void clear()
  {
    this.zall.clear();
  }

  public final boolean hasObservers()
  {
    return !this.zall.isEmpty();
  }

  public final void onDataChanged()
  {
    Iterator localIterator = this.zall.iterator();
    while (localIterator.hasNext())
      ((DataBufferObserver.Observable)localIterator.next()).onDataChanged();
  }

  public final void onDataRangeChanged(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zall.iterator();
    while (localIterator.hasNext())
      ((DataBufferObserver.Observable)localIterator.next()).onDataRangeChanged(paramInt1, paramInt2);
  }

  public final void onDataRangeInserted(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zall.iterator();
    while (localIterator.hasNext())
      ((DataBufferObserver.Observable)localIterator.next()).onDataRangeInserted(paramInt1, paramInt2);
  }

  public final void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.zall.iterator();
    while (localIterator.hasNext())
      ((DataBufferObserver.Observable)localIterator.next()).onDataRangeMoved(paramInt1, paramInt2, paramInt3);
  }

  public final void onDataRangeRemoved(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zall.iterator();
    while (localIterator.hasNext())
      ((DataBufferObserver.Observable)localIterator.next()).onDataRangeRemoved(paramInt1, paramInt2);
  }

  public final void removeObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.zall.remove(paramDataBufferObserver);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferObserverSet
 * JD-Core Version:    0.6.2
 */