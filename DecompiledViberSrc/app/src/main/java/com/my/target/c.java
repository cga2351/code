package com.my.target;

public class c
{
  private final int a;
  private final String b;

  private c()
  {
    this.a = -1;
    this.b = "none";
  }

  private c(String paramString, int paramInt)
  {
    this.b = paramString;
    this.a = paramInt;
  }

  public static c a()
  {
    return new c();
  }

  public static c a(String paramString)
  {
    int i = -1;
    label40: int j;
    switch (paramString.hashCode())
    {
    default:
      j = i;
    case 3387192:
    case 729267099:
    case 1430647483:
    }
    while (true)
      switch (j)
      {
      default:
        return null;
        if (!paramString.equals("none"))
          break label40;
        j = 0;
        continue;
        if (!paramString.equals("portrait"))
          break label40;
        j = 1;
        continue;
        if (!paramString.equals("landscape"))
          break label40;
        j = 2;
      case 1:
      case 0:
      case 2:
      }
    for (i = 1; ; i = 0)
      return new c(paramString, i);
  }

  public int b()
  {
    return this.a;
  }

  public String toString()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.c
 * JD-Core Version:    0.6.2
 */