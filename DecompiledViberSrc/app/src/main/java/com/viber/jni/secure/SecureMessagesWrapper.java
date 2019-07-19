package com.viber.jni.secure;

import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.Engine;
import com.viber.jni.GetMD5CryptedFileResult;
import com.viber.jni.controller.ConnectedCaller;
import com.viber.voip.ViberEnv;

public class SecureMessagesWrapper extends ConnectedCaller
  implements SecureMessagesController
{
  private static final Logger L = ViberEnv.getLogger();
  private final SecureMessagesController mSecureMessagesController;

  public SecureMessagesWrapper(Engine paramEngine, SecureMessagesController paramSecureMessagesController)
  {
    super(paramEngine);
    this.mSecureMessagesController = paramSecureMessagesController;
  }

  public boolean deleteAllSecurityInfo()
  {
    return this.mSecureMessagesController.deleteAllSecurityInfo();
  }

  public boolean handleCryptBufferFinish(int paramInt, EncryptionParams paramEncryptionParams)
  {
    return this.mSecureMessagesController.handleCryptBufferFinish(paramInt, paramEncryptionParams);
  }

  public boolean handleCryptBufferUpdate(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    return this.mSecureMessagesController.handleCryptBufferUpdate(paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramInt2, paramInt3);
  }

  public GetMD5CryptedFileResult handleGetMD5CryptedFile(String paramString)
  {
    return this.mSecureMessagesController.handleGetMD5CryptedFile(paramString);
  }

  public int handleGetSecureSessionInfo(final String paramString)
  {
    runOnConnect(paramString.hashCode(), new Runnable()
    {
      public void run()
      {
        SecureMessagesWrapper.this.mSecureMessagesController.handleGetSecureSessionInfo(paramString);
      }
    });
    return 0;
  }

  public int handleInitDecryptionContext(byte[] paramArrayOfByte)
  {
    return this.mSecureMessagesController.handleInitDecryptionContext(paramArrayOfByte);
  }

  public int handleInitEncryptionContext()
  {
    return this.mSecureMessagesController.handleInitEncryptionContext();
  }

  public int handleSetEncryptionContext(byte[] paramArrayOfByte)
  {
    return this.mSecureMessagesController.handleSetEncryptionContext(paramArrayOfByte);
  }

  public boolean isGroupSecure(long paramLong)
  {
    return this.mSecureMessagesController.isGroupSecure(paramLong);
  }

  public boolean isNullEncryptionParams(EncryptionParams paramEncryptionParams)
  {
    return this.mSecureMessagesController.isNullEncryptionParams(paramEncryptionParams);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.SecureMessagesWrapper
 * JD-Core Version:    0.6.2
 */