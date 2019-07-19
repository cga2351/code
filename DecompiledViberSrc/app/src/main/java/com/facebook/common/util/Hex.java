package com.facebook.common.util;

public class Hex
{
  private static final byte[] DIGITS;
  private static final char[] FIRST_CHAR;
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] SECOND_CHAR;

  static
  {
    FIRST_CHAR = new char[256];
    SECOND_CHAR = new char[256];
    for (int i = 0; i < 256; i++)
    {
      FIRST_CHAR[i] = HEX_DIGITS[(0xF & i >> 4)];
      SECOND_CHAR[i] = HEX_DIGITS[(i & 0xF)];
    }
    DIGITS = new byte[103];
    for (int j = 0; j <= 70; j++)
      DIGITS[j] = -1;
    int m;
    for (int k = 0; ; k = (byte)(k + 1))
    {
      m = 0;
      if (k >= 10)
        break;
      DIGITS[(k + 48)] = k;
    }
    while (m < 6)
    {
      DIGITS[(m + 65)] = ((byte)(m + 10));
      DIGITS[(m + 97)] = ((byte)(m + 10));
      m = (byte)(m + 1);
    }
  }

  public static String byte2Hex(int paramInt)
  {
    if ((paramInt > 255) || (paramInt < 0))
      throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
    return String.valueOf(FIRST_CHAR[paramInt]) + String.valueOf(SECOND_CHAR[paramInt]);
  }

  public static byte[] decodeHex(String paramString)
  {
    int i = 1;
    int j = paramString.length();
    if ((j & 0x1) != 0)
      throw new IllegalArgumentException("Odd number of characters.");
    byte[] arrayOfByte = new byte[j >> 1];
    int k = 0;
    int m = 0;
    int n;
    int i1;
    if (k < j)
    {
      n = k + 1;
      i1 = paramString.charAt(k);
      if (i1 <= 102);
    }
    while (true)
    {
      if (i != 0)
      {
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + paramString);
        int i2 = DIGITS[i1];
        if (i2 == -1)
          continue;
        k = n + 1;
        int i3 = paramString.charAt(n);
        if (i3 > 102)
          continue;
        int i4 = DIGITS[i3];
        if (i4 == -1)
          continue;
        arrayOfByte[m] = ((byte)(i4 | i2 << 4));
        m++;
        break;
      }
      return arrayOfByte;
      i = 0;
    }
  }

  public static String encodeHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
    int i = 0;
    int j = 0;
    while (true)
    {
      int k;
      if (i < paramArrayOfByte.length)
      {
        k = 0xFF & paramArrayOfByte[i];
        if ((k != 0) || (!paramBoolean));
      }
      else
      {
        return new String(arrayOfChar, 0, j);
      }
      int m = j + 1;
      arrayOfChar[j] = FIRST_CHAR[k];
      j = m + 1;
      arrayOfChar[m] = SECOND_CHAR[k];
      i++;
    }
  }

  public static byte[] hexStringToByteArray(String paramString)
  {
    return decodeHex(paramString.replaceAll(" ", ""));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.Hex
 * JD-Core Version:    0.6.2
 */