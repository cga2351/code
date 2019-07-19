package com.viber.jni.secure;

import com.viber.jni.PeerTrustState;

public abstract interface TrustPeerController
{
  public abstract String[] getBreachedPeersList();

  public abstract String[] getTrustedPeersList();

  public abstract int handleClearSecureCallStorage();

  public abstract void handleSecureCallVerified(int paramInt, byte[] paramArrayOfByte);

  public abstract boolean handleTrustPeer(String paramString, boolean paramBoolean);

  public abstract PeerTrustState isPeerTrusted(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.TrustPeerController
 * JD-Core Version:    0.6.2
 */