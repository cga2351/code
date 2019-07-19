package com.google.e.c.b;

import java.util.ArrayList;
import java.util.List;

public final class d
{
  private final a a;
  private final List<b> b;

  public d(a parama)
  {
    this.a = parama;
    this.b = new ArrayList();
    this.b.add(new b(parama, new int[] { 1 }));
  }

  private b a(int paramInt)
  {
    if (paramInt >= this.b.size())
    {
      b localb1 = (b)this.b.get(-1 + this.b.size());
      int i = this.b.size();
      b localb2 = localb1;
      for (int j = i; j <= paramInt; j++)
      {
        a locala = this.a;
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 1;
        arrayOfInt[1] = this.a.a(j - 1 + this.a.d());
        localb2 = localb2.b(new b(locala, arrayOfInt));
        this.b.add(localb2);
      }
    }
    return (b)this.b.get(paramInt);
  }

  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException("No error correction bytes");
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0)
      throw new IllegalArgumentException("No data bytes provided");
    b localb = a(paramInt);
    int[] arrayOfInt1 = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt1, 0, i);
    int[] arrayOfInt2 = new b(this.a, arrayOfInt1).a(paramInt, 1).c(localb)[1].a();
    int j = paramInt - arrayOfInt2.length;
    for (int k = 0; k < j; k++)
      paramArrayOfInt[(i + k)] = 0;
    System.arraycopy(arrayOfInt2, 0, paramArrayOfInt, i + j, arrayOfInt2.length);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.b.d
 * JD-Core Version:    0.6.2
 */