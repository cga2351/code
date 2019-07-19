package com.google.e.c;

import com.google.e.g;
import java.util.HashMap;
import java.util.Map;

public enum d
{
  private static final Map<Integer, d> B;
  private static final Map<String, d> C;
  private final int[] D;
  private final String[] E;

  static
  {
    A = new d("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    d[] arrayOfd1 = new d[27];
    arrayOfd1[0] = a;
    arrayOfd1[1] = b;
    arrayOfd1[2] = c;
    arrayOfd1[3] = d;
    arrayOfd1[4] = e;
    arrayOfd1[5] = f;
    arrayOfd1[6] = g;
    arrayOfd1[7] = h;
    arrayOfd1[8] = i;
    arrayOfd1[9] = j;
    arrayOfd1[10] = k;
    arrayOfd1[11] = l;
    arrayOfd1[12] = m;
    arrayOfd1[13] = n;
    arrayOfd1[14] = o;
    arrayOfd1[15] = p;
    arrayOfd1[16] = q;
    arrayOfd1[17] = r;
    arrayOfd1[18] = s;
    arrayOfd1[19] = t;
    arrayOfd1[20] = u;
    arrayOfd1[21] = v;
    arrayOfd1[22] = w;
    arrayOfd1[23] = x;
    arrayOfd1[24] = y;
    arrayOfd1[25] = z;
    arrayOfd1[26] = A;
    F = arrayOfd1;
    B = new HashMap();
    C = new HashMap();
    for (d locald : values())
    {
      for (int i7 : locald.D)
        B.put(Integer.valueOf(i7), locald);
      C.put(locald.name(), locald);
      for (String str : locald.E)
        C.put(str, locald);
    }
  }

  private d(int paramInt)
  {
    this(new int[] { paramInt }, new String[0]);
  }

  private d(int paramInt, String[] paramArrayOfString)
  {
    this.D = new int[] { paramInt };
    this.E = paramArrayOfString;
  }

  private d(int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    this.D = paramArrayOfInt;
    this.E = paramArrayOfString;
  }

  public static d a(int paramInt)
    throws g
  {
    if ((paramInt < 0) || (paramInt >= 900))
      throw g.a();
    return (d)B.get(Integer.valueOf(paramInt));
  }

  public static d a(String paramString)
  {
    return (d)C.get(paramString);
  }

  public int a()
  {
    return this.D[0];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.d
 * JD-Core Version:    0.6.2
 */