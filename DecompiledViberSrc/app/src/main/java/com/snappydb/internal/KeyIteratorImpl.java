package com.snappydb.internal;

import android.util.Log;
import com.snappydb.KeyIterator;
import com.snappydb.SnappydbException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class KeyIteratorImpl
  implements KeyIterator
{
  private final DBImpl db;
  private final String endPrefix;
  private boolean isNextValid;
  private long ptr;
  private final boolean reverse;

  protected KeyIteratorImpl(DBImpl paramDBImpl, long paramLong, String paramString, boolean paramBoolean)
  {
    this.db = paramDBImpl;
    this.ptr = paramLong;
    this.endPrefix = paramString;
    this.reverse = paramBoolean;
    this.isNextValid = paramDBImpl.__iteratorIsValid(paramLong, paramString, paramBoolean);
  }

  public Iterable<String[]> byBatch(int paramInt)
  {
    return new BatchIterableImpl(paramInt, null);
  }

  public void close()
  {
    if (this.ptr != 0L)
      this.db.__iteratorClose(this.ptr);
    this.ptr = 0L;
    this.isNextValid = false;
  }

  protected void finalize()
    throws Throwable
  {
    if (this.ptr != 0L)
    {
      Log.w("KeyIterator", "SnappyDB iterators must be closed");
      close();
    }
    super.finalize();
  }

  public boolean hasNext()
  {
    return this.isNextValid;
  }

  public String[] next(int paramInt)
  {
    if (!this.isNextValid)
      throw new NoSuchElementException();
    try
    {
      String[] arrayOfString = this.db.__iteratorNextArray(this.ptr, this.endPrefix, this.reverse, paramInt);
      this.isNextValid = this.db.__iteratorIsValid(this.ptr, this.endPrefix, this.reverse);
      if (!this.isNextValid)
        close();
      return arrayOfString;
    }
    catch (SnappydbException localSnappydbException)
    {
      throw new RuntimeException(localSnappydbException);
    }
  }

  private class BatchIterableImpl
    implements Iterable<String[]>, Iterator<String[]>
  {
    private int size;

    private BatchIterableImpl(int arg2)
    {
      int i;
      this.size = i;
    }

    public boolean hasNext()
    {
      return KeyIteratorImpl.this.hasNext();
    }

    public Iterator<String[]> iterator()
    {
      return this;
    }

    public String[] next()
    {
      return KeyIteratorImpl.this.next(this.size);
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.snappydb.internal.KeyIteratorImpl
 * JD-Core Version:    0.6.2
 */