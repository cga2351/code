package f;

import java.io.UnsupportedEncodingException;

final class b
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] b = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };

  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a);
  }

  private static String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[4 * ((2 + paramArrayOfByte1.length) / 3)];
    int j = paramArrayOfByte1.length - paramArrayOfByte1.length % 3;
    int k = 0;
    while (i < j)
    {
      int i5 = k + 1;
      arrayOfByte[k] = paramArrayOfByte2[((0xFF & paramArrayOfByte1[i]) >> 2)];
      int i6 = i5 + 1;
      arrayOfByte[i5] = paramArrayOfByte2[((0x3 & paramArrayOfByte1[i]) << 4 | (0xFF & paramArrayOfByte1[(i + 1)]) >> 4)];
      int i7 = i6 + 1;
      arrayOfByte[i6] = paramArrayOfByte2[((0xF & paramArrayOfByte1[(i + 1)]) << 2 | (0xFF & paramArrayOfByte1[(i + 2)]) >> 6)];
      k = i7 + 1;
      arrayOfByte[i7] = paramArrayOfByte2[(0x3F & paramArrayOfByte1[(i + 2)])];
      i += 3;
    }
    switch (paramArrayOfByte1.length % 3)
    {
    default:
    case 1:
    case 2:
    }
    try
    {
      while (true)
      {
        String str = new String(arrayOfByte, "US-ASCII");
        return str;
        int i2 = k + 1;
        arrayOfByte[k] = paramArrayOfByte2[((0xFF & paramArrayOfByte1[j]) >> 2)];
        int i3 = i2 + 1;
        arrayOfByte[i2] = paramArrayOfByte2[((0x3 & paramArrayOfByte1[j]) << 4)];
        int i4 = i3 + 1;
        arrayOfByte[i3] = 61;
        (i4 + 1);
        arrayOfByte[i4] = 61;
        continue;
        int m = k + 1;
        arrayOfByte[k] = paramArrayOfByte2[((0xFF & paramArrayOfByte1[j]) >> 2)];
        int n = m + 1;
        arrayOfByte[m] = paramArrayOfByte2[((0x3 & paramArrayOfByte1[j]) << 4 | (0xFF & paramArrayOfByte1[(j + 1)]) >> 4)];
        int i1 = n + 1;
        arrayOfByte[n] = paramArrayOfByte2[((0xF & paramArrayOfByte1[(j + 1)]) << 2)];
        (i1 + 1);
        arrayOfByte[i1] = 61;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }

  public static byte[] a(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte1;
    int j;
    int k;
    int m;
    int n;
    label78: int i6;
    int i7;
    label111: int i8;
    int i9;
    int i10;
    if (i > 0)
    {
      int i13 = paramString.charAt(i - 1);
      if ((i13 == 61) || (i13 == 10) || (i13 == 13) || (i13 == 32) || (i13 == 9));
    }
    else
    {
      arrayOfByte1 = new byte[(int)(6L * i / 8L)];
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      if (j >= i)
        break label338;
      i6 = paramString.charAt(j);
      if ((i6 < 65) || (i6 > 90))
        break label204;
      i7 = i6 - 65;
      i8 = k << 6 | (byte)i7;
      i9 = m + 1;
      if (i9 % 4 != 0)
        break label461;
      int i11 = n + 1;
      arrayOfByte1[n] = ((byte)(i8 >> 16));
      int i12 = i11 + 1;
      arrayOfByte1[i11] = ((byte)(i8 >> 8));
      i10 = i12 + 1;
      arrayOfByte1[i12] = ((byte)i8);
    }
    while (true)
    {
      j++;
      n = i10;
      m = i9;
      k = i8;
      break label78;
      i--;
      break;
      label204: if ((i6 >= 97) && (i6 <= 122))
      {
        i7 = i6 - 71;
        break label111;
      }
      if ((i6 >= 48) && (i6 <= 57))
      {
        i7 = i6 + 4;
        break label111;
      }
      if ((i6 == 43) || (i6 == 45))
      {
        i7 = 62;
        break label111;
      }
      if ((i6 == 47) || (i6 == 95))
      {
        i7 = 63;
        break label111;
      }
      if ((i6 != 10) && (i6 != 13) && (i6 != 32))
      {
        if (i6 == 9)
        {
          i8 = k;
          i9 = m;
          i10 = n;
        }
        else
        {
          return null;
          label338: int i1 = m % 4;
          if (i1 == 1)
            return null;
          if (i1 == 2)
          {
            int i4 = k << 12;
            int i5 = n + 1;
            arrayOfByte1[n] = ((byte)(i4 >> 16));
            n = i5;
          }
          while (n == arrayOfByte1.length)
          {
            return arrayOfByte1;
            if (i1 == 3)
            {
              int i2 = k << 6;
              int i3 = n + 1;
              arrayOfByte1[n] = ((byte)(i2 >> 16));
              n = i3 + 1;
              arrayOfByte1[i3] = ((byte)(i2 >> 8));
            }
          }
          byte[] arrayOfByte2 = new byte[n];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, n);
          return arrayOfByte2;
          label461: i10 = n;
        }
      }
      else
      {
        i8 = k;
        i9 = m;
        i10 = n;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.b
 * JD-Core Version:    0.6.2
 */