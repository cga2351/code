package com.viber.jni.secure;

public abstract interface TrustPeerDelegate
{
  public static abstract interface CallsDelegate
  {
    public abstract void onSecureCallStateChange(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString);
  }

  public static abstract interface MessagesDelegate
  {
    public abstract void onPeerIdentityBreached(String paramString1, String paramString2, String paramString3);
  }

  public static class SecureCallStateFlag
  {
    public static final int NO_SECURE_CALL = 0;
    public static final int SECURE_CALL_ENCRYPTED = 1;
    public static final int SECURE_CALL_PEER_CHANGED = 2;
    public static final int SECURE_CALL_TRUSTED_NUMBER = 4;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.TrustPeerDelegate
 * JD-Core Version:    0.6.2
 */