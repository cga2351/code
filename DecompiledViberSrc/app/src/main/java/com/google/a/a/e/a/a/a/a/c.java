package com.google.a.a.e.a.a.a.a;

import java.io.IOException;
import java.util.Iterator;

public class c
{
  private final String a;

  private c(String paramString)
  {
    this.a = ((String)e.a(paramString));
  }

  public static c a(char paramChar)
  {
    return new c(String.valueOf(paramChar));
  }

  public <A extends Appendable> A a(A paramA, Iterator<?> paramIterator)
    throws IOException
  {
    e.a(paramA);
    if (paramIterator.hasNext())
    {
      paramA.append(a(paramIterator.next()));
      while (paramIterator.hasNext())
      {
        paramA.append(this.a);
        paramA.append(a(paramIterator.next()));
      }
    }
    return paramA;
  }

  CharSequence a(Object paramObject)
  {
    e.a(paramObject);
    if ((paramObject instanceof CharSequence))
      return (CharSequence)paramObject;
    return paramObject.toString();
  }

  public final String a(Iterable<?> paramIterable)
  {
    return a(paramIterable.iterator());
  }

  public final String a(Iterator<?> paramIterator)
  {
    return a(new StringBuilder(), paramIterator).toString();
  }

  public final StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    try
    {
      a(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.e.a.a.a.a.c
 * JD-Core Version:    0.6.2
 */