package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
public class DataBufferIterator<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> zalj;
  protected int zalk;

  public DataBufferIterator(DataBuffer<T> paramDataBuffer)
  {
    this.zalj = ((DataBuffer)Preconditions.checkNotNull(paramDataBuffer));
    this.zalk = -1;
  }

  public boolean hasNext()
  {
    return this.zalk < -1 + this.zalj.getCount();
  }

  public T next()
  {
    if (!hasNext())
    {
      int j = this.zalk;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + j);
    }
    DataBuffer localDataBuffer = this.zalj;
    int i = 1 + this.zalk;
    this.zalk = i;
    return localDataBuffer.get(i);
  }

  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferIterator
 * JD-Core Version:    0.6.2
 */