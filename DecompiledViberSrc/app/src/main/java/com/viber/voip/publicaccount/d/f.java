package com.viber.voip.publicaccount.d;

public final class f
{
  public static boolean a(char paramChar)
  {
    return (d(paramChar)) || (c(paramChar));
  }

  public static boolean b(char paramChar)
  {
    return (d(paramChar)) && (Character.getType(paramChar) != 12);
  }

  private static boolean c(char paramChar)
  {
    return (paramChar == '©') || (paramChar == '®') || (paramChar == '℗') || (paramChar == '™') || (paramChar == '℠');
  }

  private static boolean d(char paramChar)
  {
    int i = Character.getType(paramChar);
    return (i != 18) && (i != 19) && (i != 28);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.d.f
 * JD-Core Version:    0.6.2
 */