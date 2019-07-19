package com.viber.jni;

public class PeerTrustState
{
  private boolean mBreached;
  private boolean mTrusted;

  public PeerTrustState(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mTrusted = paramBoolean1;
    this.mBreached = paramBoolean2;
  }

  public boolean isBreached()
  {
    return this.mBreached;
  }

  public boolean isTrusted()
  {
    return this.mTrusted;
  }

  public PeerTrustEnum toEnum()
  {
    if (!this.mTrusted)
      return PeerTrustEnum.SECURE_UNTRUSTED;
    if ((this.mTrusted) && (this.mBreached))
      return PeerTrustEnum.SECURE_TRUSTED_BREACH;
    return PeerTrustEnum.SECURE_TRUSTED;
  }

  public String toString()
  {
    return "PeerTrustState{trusted=" + this.mTrusted + ", breached=" + this.mBreached + '}';
  }

  public static enum PeerTrustEnum
  {
    static
    {
      PeerTrustEnum[] arrayOfPeerTrustEnum = new PeerTrustEnum[3];
      arrayOfPeerTrustEnum[0] = SECURE_TRUSTED;
      arrayOfPeerTrustEnum[1] = SECURE_TRUSTED_BREACH;
      arrayOfPeerTrustEnum[2] = SECURE_UNTRUSTED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PeerTrustState
 * JD-Core Version:    0.6.2
 */