package com.my.target.common;

public class c
{
  private static Boolean a;
  private static boolean b;

  public static boolean a()
  {
    return (a == null) || (a.booleanValue());
  }

  public static boolean b()
  {
    return a != null;
  }

  public static boolean c()
  {
    return b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.common.c
 * JD-Core Version:    0.6.2
 */