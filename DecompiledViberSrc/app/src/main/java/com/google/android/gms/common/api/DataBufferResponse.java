package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

@KeepForSdk
public class DataBufferResponse<T, R extends AbstractDataBuffer<T>,  extends Result> extends Response<R>
  implements DataBuffer<T>
{
  @KeepForSdk
  public DataBufferResponse()
  {
  }

  @KeepForSdk
  public DataBufferResponse(R paramR)
  {
    super(paramR);
  }

  public void close()
  {
    ((AbstractDataBuffer)getResult()).close();
  }

  public T get(int paramInt)
  {
    return ((AbstractDataBuffer)getResult()).get(paramInt);
  }

  public int getCount()
  {
    return ((AbstractDataBuffer)getResult()).getCount();
  }

  public Bundle getMetadata()
  {
    return ((AbstractDataBuffer)getResult()).getMetadata();
  }

  public boolean isClosed()
  {
    return ((AbstractDataBuffer)getResult()).isClosed();
  }

  public Iterator<T> iterator()
  {
    return ((AbstractDataBuffer)getResult()).iterator();
  }

  public void release()
  {
    ((AbstractDataBuffer)getResult()).release();
  }

  public Iterator<T> singleRefIterator()
  {
    return ((AbstractDataBuffer)getResult()).singleRefIterator();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.DataBufferResponse
 * JD-Core Version:    0.6.2
 */