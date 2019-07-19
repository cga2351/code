package com.viber.voip.util.upload;

import com.viber.jni.EncryptionParams;

public class r
{
  public final ObjectId a;
  public final long b;
  public final String c;
  public final EncryptionParams d;
  public final r e;

  public r(ObjectId paramObjectId, long paramLong, String paramString, EncryptionParams paramEncryptionParams)
  {
    this(paramObjectId, paramLong, paramString, paramEncryptionParams, null);
  }

  public r(ObjectId paramObjectId, long paramLong, String paramString, EncryptionParams paramEncryptionParams, r paramr)
  {
    this.a = paramObjectId;
    this.b = paramLong;
    this.c = paramString;
    this.d = paramEncryptionParams;
    this.e = paramr;
  }

  public String toString()
  {
    return "UploadResult{objectId=" + this.a + ", fileSize=" + this.b + ", checksum='" + this.c + '\'' + ", encryptionParams=" + this.d + ", variantUploadResult=" + this.e + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.r
 * JD-Core Version:    0.6.2
 */