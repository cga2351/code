package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder mDataHolder;

  @KeepForSdk
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.mDataHolder = paramDataHolder;
  }

  @Deprecated
  public final void close()
  {
    release();
  }

  public abstract T get(int paramInt);

  public int getCount()
  {
    if (this.mDataHolder == null)
      return 0;
    return this.mDataHolder.getCount();
  }

  public Bundle getMetadata()
  {
    return this.mDataHolder.getMetadata();
  }

  @Deprecated
  public boolean isClosed()
  {
    return (this.mDataHolder == null) || (this.mDataHolder.isClosed());
  }

  public Iterator<T> iterator()
  {
    return new DataBufferIterator(this);
  }

  public void release()
  {
    if (this.mDataHolder != null)
      this.mDataHolder.close();
  }

  public Iterator<T> singleRefIterator()
  {
    return new SingleRefDataBufferIterator(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.AbstractDataBuffer
 * JD-Core Version:    0.6.2
 */