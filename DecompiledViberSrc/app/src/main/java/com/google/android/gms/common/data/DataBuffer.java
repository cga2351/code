package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract interface DataBuffer<T> extends Releasable, Iterable<T>
{
  @Deprecated
  public abstract void close();

  public abstract T get(int paramInt);

  public abstract int getCount();

  @KeepForSdk
  public abstract Bundle getMetadata();

  @Deprecated
  public abstract boolean isClosed();

  public abstract Iterator<T> iterator();

  public abstract void release();

  public abstract Iterator<T> singleRefIterator();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBuffer
 * JD-Core Version:    0.6.2
 */