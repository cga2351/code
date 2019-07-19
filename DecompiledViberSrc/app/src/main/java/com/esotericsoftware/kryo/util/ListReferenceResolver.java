package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import java.util.ArrayList;

public class ListReferenceResolver
  implements ReferenceResolver
{
  protected Kryo kryo;
  protected final ArrayList seenObjects = new ArrayList();

  public int addWrittenObject(Object paramObject)
  {
    int i = this.seenObjects.size();
    this.seenObjects.add(paramObject);
    return i;
  }

  public Object getReadObject(Class paramClass, int paramInt)
  {
    return this.seenObjects.get(paramInt);
  }

  public int getWrittenId(Object paramObject)
  {
    int i = 0;
    int j = this.seenObjects.size();
    while (i < j)
    {
      if (this.seenObjects.get(i) == paramObject)
        return i;
      i++;
    }
    return -1;
  }

  public int nextReadId(Class paramClass)
  {
    int i = this.seenObjects.size();
    this.seenObjects.add(null);
    return i;
  }

  public void reset()
  {
    this.seenObjects.clear();
  }

  public void setKryo(Kryo paramKryo)
  {
    this.kryo = paramKryo;
  }

  public void setReadObject(int paramInt, Object paramObject)
  {
    this.seenObjects.set(paramInt, paramObject);
  }

  public boolean useReferences(Class paramClass)
  {
    return !Util.isWrapperClass(paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.util.ListReferenceResolver
 * JD-Core Version:    0.6.2
 */