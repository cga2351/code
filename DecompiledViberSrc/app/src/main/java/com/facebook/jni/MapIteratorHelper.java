package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@DoNotStrip
public class MapIteratorHelper
{

  @DoNotStrip
  private final Iterator<Map.Entry> mIterator;

  @Nullable
  @DoNotStrip
  private Object mKey;

  @Nullable
  @DoNotStrip
  private Object mValue;

  @DoNotStrip
  public MapIteratorHelper(Map paramMap)
  {
    this.mIterator = paramMap.entrySet().iterator();
  }

  @DoNotStrip
  boolean hasNext()
  {
    if (this.mIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)this.mIterator.next();
      this.mKey = localEntry.getKey();
      this.mValue = localEntry.getValue();
      return true;
    }
    this.mKey = null;
    this.mValue = null;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.MapIteratorHelper
 * JD-Core Version:    0.6.2
 */