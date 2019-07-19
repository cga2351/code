package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import java.util.ArrayList;

public class MapReferenceResolver
  implements ReferenceResolver
{
  protected Kryo kryo;
  protected final ArrayList readObjects = new ArrayList();
  protected final IdentityObjectIntMap writtenObjects = new IdentityObjectIntMap();

  public int addWrittenObject(Object paramObject)
  {
    int i = this.writtenObjects.size;
    this.writtenObjects.put(paramObject, i);
    return i;
  }

  public Object getReadObject(Class paramClass, int paramInt)
  {
    return this.readObjects.get(paramInt);
  }

  public int getWrittenId(Object paramObject)
  {
    return this.writtenObjects.get(paramObject, -1);
  }

  public int nextReadId(Class paramClass)
  {
    int i = this.readObjects.size();
    this.readObjects.add(null);
    return i;
  }

  public void reset()
  {
    this.readObjects.clear();
    this.writtenObjects.clear();
  }

  public void setKryo(Kryo paramKryo)
  {
    this.kryo = paramKryo;
  }

  public void setReadObject(int paramInt, Object paramObject)
  {
    this.readObjects.set(paramInt, paramObject);
  }

  public boolean useReferences(Class paramClass)
  {
    return !Util.isWrapperClass(paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.util.MapReferenceResolver
 * JD-Core Version:    0.6.2
 */