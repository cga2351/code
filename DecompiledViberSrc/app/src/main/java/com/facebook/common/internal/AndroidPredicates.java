package com.facebook.common.internal;

public class AndroidPredicates
{
  public static <T> Predicate<T> False()
  {
    return new Predicate()
    {
      public boolean apply(T paramAnonymousT)
      {
        return false;
      }
    };
  }

  public static <T> Predicate<T> True()
  {
    return new Predicate()
    {
      public boolean apply(T paramAnonymousT)
      {
        return true;
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.AndroidPredicates
 * JD-Core Version:    0.6.2
 */