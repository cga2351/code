package com.viber.voip.backup.d;

import com.viber.voip.model.entity.u;

public class c
{
  private static int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramInt | 0x200;
    if (paramBoolean1)
      i = 0xFFFFFFEF & (i | 0x20);
    while (!paramBoolean2)
      return i;
    return i | 0x40;
  }

  public static int a(u paramu)
  {
    return a(paramu.n, paramu.d(), paramu.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.c
 * JD-Core Version:    0.6.2
 */