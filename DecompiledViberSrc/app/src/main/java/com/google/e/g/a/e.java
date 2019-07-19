package com.google.e.g.a;

import com.google.e.c.d;
import com.google.e.g;
import com.google.e.g.c;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

final class e
{
  private static final char[] a = { 59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39 };
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94 };
  private static final Charset c = Charset.forName("ISO-8859-1");
  private static final BigInteger[] d = new BigInteger[16];

  static
  {
    d[0] = BigInteger.ONE;
    BigInteger localBigInteger = BigInteger.valueOf(900L);
    d[1] = localBigInteger;
    for (int i = 2; i < d.length; i++)
      d[i] = d[(i - 1)].multiply(localBigInteger);
  }

  private static int a(int paramInt1, int[] paramArrayOfInt, Charset paramCharset, int paramInt2, StringBuilder paramStringBuilder)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i2;
    long l2;
    int[] arrayOfInt;
    int i3;
    int i5;
    int i6;
    if (paramInt1 == 901)
    {
      i2 = 0;
      l2 = 0L;
      arrayOfInt = new int[6];
      i3 = 0;
      int i4 = paramInt2 + 1;
      i5 = paramArrayOfInt[paramInt2];
      i6 = i4;
    }
    while (true)
    {
      int i9;
      int i10;
      if ((i6 < paramArrayOfInt[0]) && (i3 == 0))
      {
        i9 = i2 + 1;
        arrayOfInt[i2] = i5;
        l2 = l2 * 900L + i5;
        i10 = i6 + 1;
        i5 = paramArrayOfInt[i6];
        if ((i5 == 900) || (i5 == 901) || (i5 == 902) || (i5 == 924) || (i5 == 928) || (i5 == 923) || (i5 == 922))
        {
          int i11 = i10 - 1;
          i3 = 1;
          i6 = i11;
          i2 = i9;
        }
        else if ((i9 % 5 == 0) && (i9 > 0))
        {
          for (int i12 = 0; i12 < 6; i12++)
            localByteArrayOutputStream.write((byte)(int)(l2 >> 8 * (5 - i12)));
          l2 = 0L;
          i6 = i10;
          i2 = 0;
        }
      }
      else
      {
        if ((i6 == paramArrayOfInt[0]) && (i5 < 900))
        {
          int i8 = i2 + 1;
          arrayOfInt[i2] = i5;
          i2 = i8;
        }
        for (int i7 = 0; i7 < i2; i7++)
          localByteArrayOutputStream.write((byte)arrayOfInt[i7]);
        paramInt2 = i6;
        do
        {
          paramStringBuilder.append(new String(localByteArrayOutputStream.toByteArray(), paramCharset));
          return paramInt2;
        }
        while (paramInt1 != 924);
        int i = 0;
        long l1 = 0L;
        int j = 0;
        label502: label506: 
        while (true)
        {
          int k = paramArrayOfInt[0];
          if ((paramInt2 >= k) || (j != 0))
            break;
          int m = paramInt2 + 1;
          int n = paramArrayOfInt[paramInt2];
          if (n < 900)
          {
            i++;
            l1 = l1 * 900L + n;
            paramInt2 = m;
          }
          while (true)
          {
            if ((i % 5 != 0) || (i <= 0))
              break label506;
            int i1 = 0;
            while (true)
              if (i1 < 6)
              {
                localByteArrayOutputStream.write((byte)(int)(l1 >> 8 * (5 - i1)));
                i1++;
                continue;
                if ((n != 900) && (n != 901) && (n != 902) && (n != 924) && (n != 928) && (n != 923) && (n != 922))
                  break label502;
                paramInt2 = m - 1;
                j = 1;
                break;
              }
            l1 = 0L;
            i = 0;
            break;
            paramInt2 = m;
          }
        }
        i2 = i9;
        i6 = i10;
      }
    }
  }

  private static int a(int[] paramArrayOfInt, int paramInt, c paramc)
    throws g
  {
    if (paramInt + 2 > paramArrayOfInt[0])
      throw g.a();
    int[] arrayOfInt1 = new int[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfInt1[i] = paramArrayOfInt[paramInt];
      i++;
      paramInt++;
    }
    paramc.a(Integer.parseInt(a(arrayOfInt1, 2)));
    StringBuilder localStringBuilder = new StringBuilder();
    int j = a(paramArrayOfInt, paramInt, localStringBuilder);
    paramc.a(localStringBuilder.toString());
    if (paramArrayOfInt[j] == 923)
    {
      k = j + 1;
      arrayOfInt2 = new int[paramArrayOfInt[0] - k];
      m = 0;
      j = k;
      n = 0;
      while ((j < paramArrayOfInt[0]) && (n == 0))
      {
        i1 = j + 1;
        i2 = paramArrayOfInt[j];
        if (i2 < 900)
        {
          i3 = m + 1;
          arrayOfInt2[m] = i2;
          m = i3;
          j = i1;
        }
        else
        {
          switch (i2)
          {
          default:
            throw g.a();
          case 922:
          }
          paramc.a(true);
          j = i1 + 1;
          n = 1;
        }
      }
      paramc.a(Arrays.copyOf(arrayOfInt2, m));
    }
    while (paramArrayOfInt[j] != 922)
    {
      int k;
      int[] arrayOfInt2;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      return j;
    }
    paramc.a(true);
    return j + 1;
  }

  private static int a(int[] paramArrayOfInt, int paramInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt1 = new int[2 * (paramArrayOfInt[0] - paramInt)];
    int[] arrayOfInt2 = new int[2 * (paramArrayOfInt[0] - paramInt)];
    int i = 0;
    int j = 0;
    while ((paramInt < paramArrayOfInt[0]) && (i == 0))
    {
      int k = paramInt + 1;
      int m = paramArrayOfInt[paramInt];
      if (m < 900)
      {
        arrayOfInt1[j] = (m / 30);
        arrayOfInt1[(j + 1)] = (m % 30);
        j += 2;
        paramInt = k;
      }
      else
      {
        switch (m)
        {
        default:
          paramInt = k;
          break;
        case 900:
          int n = j + 1;
          arrayOfInt1[j] = 900;
          j = n;
          paramInt = k;
          break;
        case 901:
        case 902:
        case 922:
        case 923:
        case 924:
        case 928:
          paramInt = k - 1;
          i = 1;
          break;
        case 913:
          arrayOfInt1[j] = 913;
          paramInt = k + 1;
          arrayOfInt2[j] = paramArrayOfInt[k];
          j++;
        }
      }
    }
    a(arrayOfInt1, arrayOfInt2, j, paramStringBuilder);
    return paramInt;
  }

  static com.google.e.c.e a(int[] paramArrayOfInt, String paramString)
    throws g
  {
    StringBuilder localStringBuilder = new StringBuilder(2 * paramArrayOfInt.length);
    Charset localCharset = c;
    int i = 2;
    int j = paramArrayOfInt[1];
    c localc = new c();
    if (i < paramArrayOfInt[0])
    {
      int k;
      switch (j)
      {
      default:
        k = a(paramArrayOfInt, i - 1, localStringBuilder);
      case 900:
      case 901:
      case 924:
      case 913:
      case 902:
      case 927:
      case 926:
      case 925:
      case 928:
      case 922:
      case 923:
      }
      while (true)
        if (k < paramArrayOfInt.length)
        {
          i = k + 1;
          j = paramArrayOfInt[k];
          break;
          k = a(paramArrayOfInt, i, localStringBuilder);
          continue;
          k = a(j, paramArrayOfInt, localCharset, i, localStringBuilder);
          continue;
          k = i + 1;
          localStringBuilder.append((char)paramArrayOfInt[i]);
          continue;
          k = b(paramArrayOfInt, i, localStringBuilder);
          continue;
          k = i + 1;
          localCharset = Charset.forName(d.a(paramArrayOfInt[i]).name());
          continue;
          k = i + 2;
          continue;
          k = i + 1;
          continue;
          k = a(paramArrayOfInt, i, localc);
          continue;
          throw g.a();
        }
      throw g.a();
    }
    if (localStringBuilder.length() == 0)
      throw g.a();
    com.google.e.c.e locale = new com.google.e.c.e(null, localStringBuilder.toString(), null, paramString);
    locale.a(localc);
    return locale;
  }

  private static String a(int[] paramArrayOfInt, int paramInt)
    throws g
  {
    BigInteger localBigInteger = BigInteger.ZERO;
    for (int i = 0; i < paramInt; i++)
      localBigInteger = localBigInteger.add(d[(-1 + (paramInt - i))].multiply(BigInteger.valueOf(paramArrayOfInt[i])));
    String str = localBigInteger.toString();
    if (str.charAt(0) != '1')
      throw g.a();
    return str.substring(1);
  }

  private static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, StringBuilder paramStringBuilder)
  {
    Object localObject1 = a.a;
    Object localObject2 = a.a;
    int i = 0;
    int j;
    char c1;
    if (i < paramInt)
    {
      j = paramArrayOfInt1[i];
      int k = 1.a[localObject1.ordinal()];
      c1 = '\000';
      switch (k)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    }
    while (true)
    {
      if (c1 != 0)
        paramStringBuilder.append(c1);
      i++;
      break;
      if (j < 26)
      {
        c1 = (char)(j + 65);
      }
      else if (j == 26)
      {
        c1 = ' ';
      }
      else if (j == 27)
      {
        localObject1 = a.b;
        c1 = '\000';
      }
      else if (j == 28)
      {
        localObject1 = a.c;
        c1 = '\000';
      }
      else if (j == 29)
      {
        a locala4 = a.f;
        Object localObject6 = localObject1;
        localObject1 = locala4;
        localObject2 = localObject6;
        c1 = '\000';
      }
      else if (j == 913)
      {
        paramStringBuilder.append((char)paramArrayOfInt2[i]);
        c1 = '\000';
      }
      else
      {
        c1 = '\000';
        if (j == 900)
        {
          localObject1 = a.a;
          c1 = '\000';
          continue;
          if (j < 26)
          {
            c1 = (char)(j + 97);
          }
          else if (j == 26)
          {
            c1 = ' ';
          }
          else if (j == 27)
          {
            a locala3 = a.e;
            Object localObject5 = localObject1;
            localObject1 = locala3;
            localObject2 = localObject5;
            c1 = '\000';
          }
          else if (j == 28)
          {
            localObject1 = a.c;
            c1 = '\000';
          }
          else if (j == 29)
          {
            a locala2 = a.f;
            Object localObject4 = localObject1;
            localObject1 = locala2;
            localObject2 = localObject4;
            c1 = '\000';
          }
          else if (j == 913)
          {
            paramStringBuilder.append((char)paramArrayOfInt2[i]);
            c1 = '\000';
          }
          else
          {
            c1 = '\000';
            if (j == 900)
            {
              localObject1 = a.a;
              c1 = '\000';
              continue;
              if (j < 25)
              {
                c1 = b[j];
              }
              else if (j == 25)
              {
                localObject1 = a.d;
                c1 = '\000';
              }
              else if (j == 26)
              {
                c1 = ' ';
              }
              else if (j == 27)
              {
                localObject1 = a.b;
                c1 = '\000';
              }
              else if (j == 28)
              {
                localObject1 = a.a;
                c1 = '\000';
              }
              else if (j == 29)
              {
                a locala1 = a.f;
                Object localObject3 = localObject1;
                localObject1 = locala1;
                localObject2 = localObject3;
                c1 = '\000';
              }
              else if (j == 913)
              {
                paramStringBuilder.append((char)paramArrayOfInt2[i]);
                c1 = '\000';
              }
              else
              {
                c1 = '\000';
                if (j == 900)
                {
                  localObject1 = a.a;
                  c1 = '\000';
                  continue;
                  if (j < 29)
                  {
                    c1 = a[j];
                  }
                  else if (j == 29)
                  {
                    localObject1 = a.a;
                    c1 = '\000';
                  }
                  else if (j == 913)
                  {
                    paramStringBuilder.append((char)paramArrayOfInt2[i]);
                    c1 = '\000';
                  }
                  else
                  {
                    c1 = '\000';
                    if (j == 900)
                    {
                      localObject1 = a.a;
                      c1 = '\000';
                      continue;
                      if (j < 26)
                      {
                        c1 = (char)(j + 65);
                        localObject1 = localObject2;
                      }
                      else if (j == 26)
                      {
                        c1 = ' ';
                        localObject1 = localObject2;
                      }
                      else if (j == 900)
                      {
                        localObject1 = a.a;
                        c1 = '\000';
                        continue;
                        if (j < 29)
                        {
                          c1 = a[j];
                          localObject1 = localObject2;
                        }
                        else if (j == 29)
                        {
                          localObject1 = a.a;
                          c1 = '\000';
                        }
                        else if (j == 913)
                        {
                          paramStringBuilder.append((char)paramArrayOfInt2[i]);
                          localObject1 = localObject2;
                          c1 = '\000';
                        }
                        else if (j == 900)
                        {
                          localObject1 = a.a;
                          c1 = '\000';
                        }
                      }
                      else
                      {
                        localObject1 = localObject2;
                        c1 = '\000';
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  private static int b(int[] paramArrayOfInt, int paramInt, StringBuilder paramStringBuilder)
    throws g
  {
    int[] arrayOfInt = new int[15];
    int i = 0;
    int j = 0;
    label172: 
    while (true)
    {
      int k;
      int m;
      if ((paramInt < paramArrayOfInt[0]) && (i == 0))
      {
        k = paramInt + 1;
        m = paramArrayOfInt[paramInt];
        if (k == paramArrayOfInt[0])
          i = 1;
        if (m < 900)
        {
          arrayOfInt[j] = m;
          j++;
          paramInt = k;
        }
      }
      while (true)
      {
        if (((j % 15 != 0) && (m != 902) && (i == 0)) || (j <= 0))
          break label172;
        paramStringBuilder.append(a(arrayOfInt, j));
        j = 0;
        break;
        if ((m == 900) || (m == 901) || (m == 924) || (m == 928) || (m == 923) || (m == 922))
        {
          paramInt = k - 1;
          i = 1;
          continue;
          return paramInt;
        }
        else
        {
          paramInt = k;
        }
      }
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.e
 * JD-Core Version:    0.6.2
 */