package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

class LabelKey
{
  private final Class label;
  private final String name;
  private final Class owner;
  private final Class type;

  public LabelKey(Contact paramContact, Annotation paramAnnotation)
  {
    this.owner = paramContact.getDeclaringClass();
    this.label = paramAnnotation.annotationType();
    this.name = paramContact.getName();
    this.type = paramContact.getType();
  }

  private boolean equals(LabelKey paramLabelKey)
  {
    boolean bool;
    if (paramLabelKey == this)
      bool = true;
    Class localClass5;
    Class localClass6;
    do
    {
      Class localClass3;
      Class localClass4;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          return bool;
          localClass1 = paramLabelKey.label;
          localClass2 = this.label;
          bool = false;
        }
        while (localClass1 != localClass2);
        localClass3 = paramLabelKey.owner;
        localClass4 = this.owner;
        bool = false;
      }
      while (localClass3 != localClass4);
      localClass5 = paramLabelKey.type;
      localClass6 = this.type;
      bool = false;
    }
    while (localClass5 != localClass6);
    return paramLabelKey.name.equals(this.name);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof LabelKey))
      return equals((LabelKey)paramObject);
    return false;
  }

  public int hashCode()
  {
    return this.name.hashCode() ^ this.owner.hashCode();
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = this.owner;
    return String.format("key '%s' for %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.LabelKey
 * JD-Core Version:    0.6.2
 */