package org.webrtc;

public abstract interface SSLCertificateVerifier
{
  @CalledByNative
  public abstract boolean verify(byte[] paramArrayOfByte);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.SSLCertificateVerifier
 * JD-Core Version:    0.6.2
 */