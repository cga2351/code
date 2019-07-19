package com.viber.jni;

public class GetMD5CryptedFileResult
{
  private String mChecksum;
  private byte[] mKey;

  public GetMD5CryptedFileResult(byte[] paramArrayOfByte, String paramString)
  {
    this.mKey = paramArrayOfByte;
    this.mChecksum = paramString;
  }

  public String getChecksum()
  {
    return this.mChecksum;
  }

  public byte[] getKey()
  {
    return this.mKey;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.GetMD5CryptedFileResult
 * JD-Core Version:    0.6.2
 */