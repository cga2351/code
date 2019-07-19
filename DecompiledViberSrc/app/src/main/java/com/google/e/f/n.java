package com.google.e.f;

import com.google.e.j;
import com.google.e.o;
import java.util.EnumMap;
import java.util.Map;

final class n
{
  private static final int[] a = { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
  private final int[] b = new int[4];
  private final StringBuilder c = new StringBuilder();

  private static int a(int paramInt)
    throws j
  {
    for (int i = 0; i < 10; i++)
      if (paramInt == a[i])
        return i;
    throw j.a();
  }

  private static int a(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = 0;
    for (int k = i - 2; k >= 0; k -= 2)
      j += '￐' + paramCharSequence.charAt(k);
    int m = j * 3;
    for (int n = i - 1; n >= 0; n -= 2)
      m += '￐' + paramCharSequence.charAt(n);
    return m * 3 % 10;
  }

  private static Map<o, Object> a(String paramString)
  {
    if (paramString.length() != 5);
    String str;
    do
    {
      return null;
      str = b(paramString);
    }
    while (str == null);
    EnumMap localEnumMap = new EnumMap(o.class);
    localEnumMap.put(o.f, str);
    return localEnumMap;
  }

  private static String b(String paramString)
  {
    String str1;
    String str2;
    int j;
    switch (paramString.charAt(0))
    {
    default:
      str1 = "";
      int i = Integer.parseInt(paramString.substring(1));
      str2 = String.valueOf(i / 100);
      j = i % 100;
      if (j >= 10)
        break;
    case '0':
    case '5':
    case '9':
    }
    for (String str3 = "0" + j; ; str3 = String.valueOf(j))
    {
      return str1 + str2 + '.' + str3;
      str1 = "£";
      break;
      str1 = "$";
      break;
      if ("90000".equals(paramString))
        return null;
      if ("99991".equals(paramString))
        return "0.00";
      if ("99990".equals(paramString))
        return "Used";
      str1 = "";
      break;
    }
  }

  int a(com.google.e.c.a parama, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws j
  {
    int[] arrayOfInt = this.b;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = parama.a();
    int j = paramArrayOfInt[1];
    int k = 0;
    int m = 0;
    while ((k < 5) && (j < i))
    {
      int i1 = p.a(parama, arrayOfInt, j, p.e);
      paramStringBuilder.append((char)(48 + i1 % 10));
      int i2 = arrayOfInt.length;
      int i3 = 0;
      while (i3 < i2)
      {
        int i4 = j + arrayOfInt[i3];
        i3++;
        j = i4;
      }
      if (i1 >= 10)
        m |= 1 << 4 - k;
      if (k != 4)
        j = parama.d(parama.c(j));
      k++;
    }
    if (paramStringBuilder.length() != 5)
      throw j.a();
    int n = a(m);
    if (a(paramStringBuilder.toString()) != n)
      throw j.a();
    return j;
  }

  com.google.e.n a(int paramInt, com.google.e.c.a parama, int[] paramArrayOfInt)
    throws j
  {
    StringBuilder localStringBuilder = this.c;
    localStringBuilder.setLength(0);
    int i = a(parama, paramArrayOfInt, localStringBuilder);
    String str = localStringBuilder.toString();
    Map localMap = a(str);
    com.google.e.p[] arrayOfp = new com.google.e.p[2];
    arrayOfp[0] = new com.google.e.p((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt);
    arrayOfp[1] = new com.google.e.p(i, paramInt);
    com.google.e.n localn = new com.google.e.n(str, null, arrayOfp, com.google.e.a.q);
    if (localMap != null)
      localn.a(localMap);
    return localn;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.n
 * JD-Core Version:    0.6.2
 */