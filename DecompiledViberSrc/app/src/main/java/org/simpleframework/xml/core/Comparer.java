package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class Comparer
{
  private static final String NAME = "name";
  private final String[] ignore;

  public Comparer()
  {
    this(new String[] { "name" });
  }

  public Comparer(String[] paramArrayOfString)
  {
    this.ignore = paramArrayOfString;
  }

  private boolean isIgnore(Method paramMethod)
  {
    String str = paramMethod.getName();
    String[] arrayOfString1 = this.ignore;
    boolean bool = false;
    String[] arrayOfString2;
    int i;
    if (arrayOfString1 != null)
    {
      arrayOfString2 = this.ignore;
      i = arrayOfString2.length;
    }
    for (int j = 0; ; j++)
    {
      bool = false;
      if (j < i)
      {
        if (str.equals(arrayOfString2[j]))
          bool = true;
      }
      else
        return bool;
    }
  }

  public boolean equals(Annotation paramAnnotation1, Annotation paramAnnotation2)
    throws Exception
  {
    Class localClass1 = paramAnnotation1.annotationType();
    Class localClass2 = paramAnnotation2.annotationType();
    Method[] arrayOfMethod = localClass1.getDeclaredMethods();
    int i;
    if (localClass1.equals(localClass2))
      i = arrayOfMethod.length;
    for (int j = 0; j < i; j++)
    {
      Method localMethod = arrayOfMethod[j];
      if ((!isIgnore(localMethod)) && (!localMethod.invoke(paramAnnotation1, new Object[0]).equals(localMethod.invoke(paramAnnotation2, new Object[0]))))
        return false;
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Comparer
 * JD-Core Version:    0.6.2
 */