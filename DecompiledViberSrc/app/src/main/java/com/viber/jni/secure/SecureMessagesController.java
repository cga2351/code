package com.viber.jni.secure;

import com.viber.jni.EncryptionParams;
import com.viber.jni.GetMD5CryptedFileResult;

public abstract interface SecureMessagesController
{
  public abstract boolean deleteAllSecurityInfo();

  public abstract boolean handleCryptBufferFinish(int paramInt, EncryptionParams paramEncryptionParams);

  public abstract boolean handleCryptBufferUpdate(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3);

  public abstract GetMD5CryptedFileResult handleGetMD5CryptedFile(String paramString);

  public abstract int handleGetSecureSessionInfo(String paramString);

  public abstract int handleInitDecryptionContext(byte[] paramArrayOfByte);

  public abstract int handleInitEncryptionContext();

  public abstract int handleSetEncryptionContext(byte[] paramArrayOfByte);

  public abstract boolean isGroupSecure(long paramLong);

  public abstract boolean isNullEncryptionParams(EncryptionParams paramEncryptionParams);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecureMessagesController
 * JD-Core Version:    0.6.2
 */