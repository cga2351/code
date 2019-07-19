package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public class Hex
{
  private static final char[] zzgw = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] zzgx = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };

  @KeepForSdk
  public static String bytesToStringUppercase(byte[] paramArrayOfByte)
  {
    return bytesToStringUppercase(paramArrayOfByte, false);
  }

  @KeepForSdk
  public static String bytesToStringUppercase(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder(i << 1);
    for (int j = 0; (j < i) && ((!paramBoolean) || (j != i - 1) || ((0xFF & paramArrayOfByte[j]) != 0)); j++)
    {
      localStringBuilder.append(zzgw[((0xF0 & paramArrayOfByte[j]) >>> 4)]);
      localStringBuilder.append(zzgw[(0xF & paramArrayOfByte[j])]);
    }
    return localStringBuilder.toString();
  }

  @KeepForSdk
  public static byte[] stringToBytes(String paramString)
    throws IllegalArgumentException
  {
    int i = paramString.length();
    if (i % 2 != 0)
      throw new IllegalArgumentException("Hex string has odd number of characters");
    byte[] arrayOfByte = new byte[i / 2];
    for (int j = 0; j < i; j += 2)
      arrayOfByte[(j / 2)] = ((byte)Integer.parseInt(paramString.substring(j, j + 2), 16));
    return arrayOfByte;
  }

  public static String zza(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar = new char[paramArrayOfByte.length << 1];
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = 0xFF & paramArrayOfByte[i];
      int m = j + 1;
      arrayOfChar[j] = zzgx[(k >>> 4)];
      j = m + 1;
      arrayOfChar[m] = zzgx[(k & 0xF)];
      i++;
    }
    return new String(arrayOfChar);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.Hex
 * JD-Core Version:    0.6.2
 */