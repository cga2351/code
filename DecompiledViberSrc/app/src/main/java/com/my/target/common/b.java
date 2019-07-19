package com.my.target.common;

import com.my.target.al;
import com.my.target.dp;

public final class b extends al
{
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      a("g");
      dp.a("gender param removed");
      return;
    case 0:
    case 1:
    case 2:
    }
    dp.a("gender param is set to " + paramInt);
    a("g", String.valueOf(paramInt));
  }

  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      dp.a("age param set to " + paramInt);
      a("a", String.valueOf(paramInt));
      return;
    }
    dp.a("age param removed");
    a("a");
  }

  public void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.common.b
 * JD-Core Version:    0.6.2
 */