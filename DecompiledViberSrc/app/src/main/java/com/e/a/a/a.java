package com.e.a.a;

import com.e.a.h;
import java.util.Collection;

class a
{
  public static String a(h paramh, Collection<h> paramCollection)
  {
    return "Unsupported JWS algorithm " + paramh + ", must be " + a(paramCollection);
  }

  private static String a(Collection paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object[] arrayOfObject = paramCollection.toArray();
    int i = 0;
    if (i >= arrayOfObject.length)
      return localStringBuilder.toString();
    if (i != 0)
    {
      if (i >= -1 + arrayOfObject.length)
        break label64;
      localStringBuilder.append(", ");
    }
    while (true)
    {
      localStringBuilder.append(arrayOfObject[i].toString());
      i++;
      break;
      label64: if (i == -1 + arrayOfObject.length)
        localStringBuilder.append(" or ");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.a.a
 * JD-Core Version:    0.6.2
 */