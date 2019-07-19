package com.my.target.common.a;

import com.my.target.dp;
import com.my.target.h;
import java.util.Iterator;
import java.util.List;

public final class c extends h<String>
{
  private int d;
  private final boolean e;

  private c(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.b = paramInt1;
    this.c = paramInt2;
    if (!this.a.endsWith(".m3u8"));
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      return;
    }
  }

  public static c a(String paramString, int paramInt1, int paramInt2)
  {
    return new c(paramString, paramInt1, paramInt2);
  }

  public static c a(List<c> paramList, int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    int k;
    if (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int j = localc.c();
      if ((localObject1 != null) && ((j > paramInt) || (i <= paramInt)) && ((j > paramInt) || (j <= i)) && ((j <= paramInt) || (j >= i)))
        break label126;
      localObject2 = localc;
      k = j;
    }
    while (true)
    {
      localObject1 = localObject2;
      i = k;
      break;
      dp.a("Accepted videoData quality = " + i + "p");
      return localObject1;
      label126: k = i;
      localObject2 = localObject1;
    }
  }

  public void c(int paramInt)
  {
    this.d = paramInt;
  }

  public boolean e()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.common.a.c
 * JD-Core Version:    0.6.2
 */