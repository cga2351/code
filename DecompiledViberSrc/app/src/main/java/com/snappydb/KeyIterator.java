package com.snappydb;

import java.io.Closeable;

public abstract interface KeyIterator extends Closeable
{
  public abstract Iterable<String[]> byBatch(int paramInt);

  public abstract void close();

  public abstract boolean hasNext();

  public abstract String[] next(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.snappydb.KeyIterator
 * JD-Core Version:    0.6.2
 */