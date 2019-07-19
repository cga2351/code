package com.e.a.d;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class g
{
  public static List<a> a(e.a.b.a parama)
    throws ParseException
  {
    LinkedList localLinkedList = new LinkedList();
    for (int i = 0; ; i++)
    {
      if (i >= parama.size())
        return localLinkedList;
      Object localObject = parama.get(i);
      if (localObject == null)
        throw new ParseException("The X.509 certificate at position " + i + " must not be null", 0);
      if (!(localObject instanceof String))
        throw new ParseException("The X.509 certificate at position " + i + " must be encoded as a Base64 string", 0);
      localLinkedList.add(new a((String)localObject));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.d.g
 * JD-Core Version:    0.6.2
 */