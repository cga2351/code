package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Iterator;
import javax.annotation.Nullable;

@DoNotStrip
public class IteratorHelper
{

  @Nullable
  @DoNotStrip
  private Object mElement;
  private final Iterator mIterator;

  @DoNotStrip
  public IteratorHelper(Iterable paramIterable)
  {
    this.mIterator = paramIterable.iterator();
  }

  @DoNotStrip
  public IteratorHelper(Iterator paramIterator)
  {
    this.mIterator = paramIterator;
  }

  @DoNotStrip
  boolean hasNext()
  {
    if (this.mIterator.hasNext())
    {
      this.mElement = this.mIterator.next();
      return true;
    }
    this.mElement = null;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.IteratorHelper
 * JD-Core Version:    0.6.2
 */