package com.esotericsoftware.kryo;

import java.util.HashMap;
import java.util.Map;

public class Generics
{
  private Generics parentScope;
  private Map<String, Class> typeVar2class;

  public Generics()
  {
    this.typeVar2class = new HashMap();
    this.parentScope = null;
  }

  public Generics(Generics paramGenerics)
  {
    this.typeVar2class = new HashMap();
    this.parentScope = paramGenerics;
  }

  public Generics(Map<String, Class> paramMap)
  {
    this.typeVar2class = new HashMap(paramMap);
    this.parentScope = null;
  }

  public void add(String paramString, Class paramClass)
  {
    this.typeVar2class.put(paramString, paramClass);
  }

  public Class getConcreteClass(String paramString)
  {
    Class localClass = (Class)this.typeVar2class.get(paramString);
    if ((localClass == null) && (this.parentScope != null))
      localClass = this.parentScope.getConcreteClass(paramString);
    return localClass;
  }

  public Map<String, Class> getMappings()
  {
    return this.typeVar2class;
  }

  public Generics getParentScope()
  {
    return this.parentScope;
  }

  public void resetParentScope()
  {
    this.parentScope = null;
  }

  public void setParentScope(Generics paramGenerics)
  {
    if (this.parentScope != null)
      throw new IllegalStateException("Parent scope can be set just once");
    this.parentScope = paramGenerics;
  }

  public String toString()
  {
    return this.typeVar2class.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.Generics
 * JD-Core Version:    0.6.2
 */