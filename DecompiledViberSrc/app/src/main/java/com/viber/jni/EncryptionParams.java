package com.viber.jni;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Arrays;

public class EncryptionParams
{
  private static final int BASE64_PARAMS = 19;
  private static final char BASE64_SEPARATOR = '|';
  public static final int CONTENT_IS_ENCRYPTED = 1;
  private static final int FLAGS_SIZE = 4;
  public static final int KEY_SIZE = 16;
  public static final int TAG_SIZE = 16;
  private int flags;
  private byte[] key;
  private byte[] tag;

  public EncryptionParams()
  {
    this.key = null;
    this.tag = null;
    this.flags = 0;
  }

  public EncryptionParams(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    this.key = paramArrayOfByte1;
    this.tag = paramArrayOfByte2;
    this.flags = paramInt;
  }

  public static boolean contentIsEncrypted(EncryptionParams paramEncryptionParams)
  {
    return (paramEncryptionParams != null) && ((0x1 & paramEncryptionParams.flags) != 0);
  }

  public static String serializeEncryptionParams(EncryptionParams paramEncryptionParams)
  {
    if (paramEncryptionParams == null)
      return null;
    byte[] arrayOfByte = new byte[36];
    arrayOfByte[0] = ((byte)(0xFF & paramEncryptionParams.flags >> 0));
    arrayOfByte[1] = ((byte)(0xFF & paramEncryptionParams.flags >> 8));
    arrayOfByte[2] = ((byte)(0xFF & paramEncryptionParams.flags >> 16));
    arrayOfByte[3] = ((byte)(0xFF & paramEncryptionParams.flags >> 24));
    System.arraycopy(paramEncryptionParams.key, 0, arrayOfByte, 4, 16);
    System.arraycopy(paramEncryptionParams.tag, 0, arrayOfByte, 20, 16);
    return Base64.encodeToString(arrayOfByte, 19);
  }

  public static EncryptionParams unserializeCrossPlatformEncryptionParams(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    int i;
    do
    {
      return null;
      arrayOfByte1 = Base64.decode(paramString, 19);
      arrayOfByte2 = new byte[16];
      arrayOfByte3 = new byte[16];
      i = arrayOfByte1[0] << 0 | arrayOfByte1[1] << 8 | arrayOfByte1[2] << 16 | arrayOfByte1[3] << 24;
    }
    while ((i & 0x1) == 0);
    System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, 16);
    System.arraycopy(arrayOfByte1, 20, arrayOfByte3, 0, 16);
    return new EncryptionParams(arrayOfByte2, arrayOfByte3, i);
  }

  public static EncryptionParams unserializeEncryptionParams(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    if (paramString.indexOf('|') > 0)
      return unserializeLegacyEncryptionParams(paramString);
    return unserializeCrossPlatformEncryptionParams(paramString);
  }

  private static EncryptionParams unserializeLegacyEncryptionParams(String paramString)
  {
    int i = paramString.indexOf('|');
    String str1 = paramString.substring(0, i);
    int j = paramString.indexOf('|', i + 1);
    if (j > 0)
    {
      String str3 = paramString.substring(i + 1, j);
      String str4 = paramString.substring(j + 1);
      return new EncryptionParams(Base64.decode(str1, 19), Base64.decode(str3, 19), Base64.decode(str4, 19)[0]);
    }
    String str2 = paramString.substring(i + 1);
    return new EncryptionParams(Base64.decode(str1, 19), Base64.decode(str2, 19), 1);
  }

  public int getFlags()
  {
    return this.flags;
  }

  public byte[] getKey()
  {
    return this.key;
  }

  public byte[] getTag()
  {
    return this.tag;
  }

  public String toString()
  {
    if ((this.key != null) && (this.tag != null))
      return serializeEncryptionParams(this);
    String str1;
    if (this.key != null)
    {
      str1 = Arrays.toString(this.key);
      if (this.tag == null)
        break label101;
    }
    label101: for (String str2 = Arrays.toString(this.tag); ; str2 = "none")
    {
      return "EncryptionParams [key=" + str1 + ", tag=" + str2 + ", flags= " + this.flags + "]";
      str1 = "none";
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.EncryptionParams
 * JD-Core Version:    0.6.2
 */