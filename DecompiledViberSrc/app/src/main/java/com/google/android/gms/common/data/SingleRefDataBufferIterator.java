package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.NoSuchElementException;

@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T>
{
  private T zamf;

  public SingleRefDataBufferIterator(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }

  public T next()
  {
    if (!hasNext())
    {
      int i = this.zalk;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    this.zalk = (1 + this.zalk);
    if (this.zalk == 0)
    {
      this.zamf = this.zalj.get(0);
      if (!(this.zamf instanceof DataBufferRef))
      {
        String str = String.valueOf(this.zamf.getClass());
        throw new IllegalStateException(44 + String.valueOf(str).length() + "DataBuffer reference of type " + str + " is not movable");
      }
    }
    else
    {
      ((DataBufferRef)this.zamf).zag(this.zalk);
    }
    return this.zamf;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.SingleRefDataBufferIterator
 * JD-Core Version:    0.6.2
 */