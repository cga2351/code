package com.google.e.h.a;

import com.google.e.c.b.c;
import java.util.Map;

public final class e
{
  private final c a = new c(com.google.e.c.b.a.e);

  private com.google.e.c.e a(a parama, Map<com.google.e.e, ?> paramMap)
    throws com.google.e.g, com.google.e.d
  {
    j localj = parama.b();
    f localf = parama.a().a();
    b[] arrayOfb = b.a(parama.c(), localj, localf);
    int i = arrayOfb.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfb[j].a();
      j++;
    }
    byte[] arrayOfByte1 = new byte[k];
    int m = arrayOfb.length;
    int n = 0;
    int i3;
    for (int i1 = 0; n < m; i1 = i3)
    {
      b localb = arrayOfb[n];
      byte[] arrayOfByte2 = localb.b();
      int i2 = localb.a();
      a(arrayOfByte2, i2);
      i3 = i1;
      int i4 = 0;
      while (i4 < i2)
      {
        int i5 = i3 + 1;
        arrayOfByte1[i3] = arrayOfByte2[i4];
        i4++;
        i3 = i5;
      }
      n++;
    }
    return d.a(arrayOfByte1, localj, localf, paramMap);
  }

  private void a(byte[] paramArrayOfByte, int paramInt)
    throws com.google.e.d
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    int[] arrayOfInt = new int[j];
    for (int k = 0; k < j; k++)
      arrayOfInt[k] = (0xFF & paramArrayOfByte[k]);
    int m = paramArrayOfByte.length - paramInt;
    try
    {
      this.a.a(arrayOfInt, m);
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)arrayOfInt[i]);
        i++;
      }
    }
    catch (com.google.e.c.b.e locale)
    {
      throw com.google.e.d.a();
    }
  }

  // ERROR //
  public com.google.e.c.e a(com.google.e.c.b paramb, Map<com.google.e.e, ?> paramMap)
    throws com.google.e.g, com.google.e.d
  {
    // Byte code:
    //   0: new 30	com/google/e/h/a/a
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 76	com/google/e/h/a/a:<init>	(Lcom/google/e/c/b;)V
    //   8: astore_3
    //   9: aload_0
    //   10: aload_3
    //   11: aload_2
    //   12: invokespecial 78	com/google/e/h/a/e:a	(Lcom/google/e/h/a/a;Ljava/util/Map;)Lcom/google/e/c/e;
    //   15: astore 11
    //   17: aload 11
    //   19: areturn
    //   20: astore 10
    //   22: aload 10
    //   24: astore 5
    //   26: aconst_null
    //   27: astore 4
    //   29: aload_3
    //   30: invokevirtual 81	com/google/e/h/a/a:d	()V
    //   33: aload_3
    //   34: iconst_1
    //   35: invokevirtual 84	com/google/e/h/a/a:a	(Z)V
    //   38: aload_3
    //   39: invokevirtual 34	com/google/e/h/a/a:b	()Lcom/google/e/h/a/j;
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 37	com/google/e/h/a/a:a	()Lcom/google/e/h/a/g;
    //   47: pop
    //   48: aload_3
    //   49: invokevirtual 86	com/google/e/h/a/a:e	()V
    //   52: aload_0
    //   53: aload_3
    //   54: aload_2
    //   55: invokespecial 78	com/google/e/h/a/e:a	(Lcom/google/e/h/a/a;Ljava/util/Map;)Lcom/google/e/c/e;
    //   58: astore 9
    //   60: aload 9
    //   62: new 88	com/google/e/h/a/i
    //   65: dup
    //   66: iconst_1
    //   67: invokespecial 90	com/google/e/h/a/i:<init>	(Z)V
    //   70: invokevirtual 95	com/google/e/c/e:a	(Ljava/lang/Object;)V
    //   73: aload 9
    //   75: areturn
    //   76: astore 6
    //   78: aload 5
    //   80: ifnull +14 -> 94
    //   83: aload 5
    //   85: athrow
    //   86: astore 4
    //   88: aconst_null
    //   89: astore 5
    //   91: goto -62 -> 29
    //   94: aload 4
    //   96: ifnull +6 -> 102
    //   99: aload 4
    //   101: athrow
    //   102: aload 6
    //   104: athrow
    //   105: astore 6
    //   107: goto -29 -> 78
    //
    // Exception table:
    //   from	to	target	type
    //   9	17	20	com/google/e/g
    //   29	73	76	com/google/e/g
    //   9	17	86	com/google/e/d
    //   29	73	105	com/google/e/d
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a.e
 * JD-Core Version:    0.6.2
 */