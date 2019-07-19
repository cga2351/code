package com.e.a.c;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public enum f
{
  private final String i;

  static
  {
    f[] arrayOff = new f[8];
    arrayOff[0] = a;
    arrayOff[1] = b;
    arrayOff[2] = c;
    arrayOff[3] = d;
    arrayOff[4] = e;
    arrayOff[5] = f;
    arrayOff[6] = g;
    arrayOff[7] = h;
  }

  private f(String arg3)
  {
    Object localObject;
    if (localObject == null)
      throw new IllegalArgumentException("The key operation identifier must not be null");
    this.i = localObject;
  }

  public static Set<f> a(List<String> paramList)
    throws ParseException
  {
    if (paramList == null)
      return null;
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator = paramList.iterator();
    String str;
    do
    {
      if (!localIterator.hasNext())
        return localLinkedHashSet;
      str = (String)localIterator.next();
    }
    while (str == null);
    f[] arrayOff = values();
    int k = arrayOff.length;
    for (int m = 0; ; m++)
    {
      Object localObject;
      if (m >= k)
        localObject = null;
      do
      {
        if (localObject == null)
          break label111;
        localLinkedHashSet.add(localObject);
        break;
        localObject = arrayOff[m];
      }
      while (str.equals(((f)localObject).a()));
    }
    label111: throw new ParseException("Invalid JWK operation: " + str, 0);
  }

  public String a()
  {
    return this.i;
  }

  public String toString()
  {
    return a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.f
 * JD-Core Version:    0.6.2
 */