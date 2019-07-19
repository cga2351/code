package org.webrtc;

import javax.annotation.Nullable;

public final class PeerConnectionDependencies
{
  private final PeerConnection.Observer observer;
  private final SSLCertificateVerifier sslCertificateVerifier;

  private PeerConnectionDependencies(PeerConnection.Observer paramObserver, SSLCertificateVerifier paramSSLCertificateVerifier)
  {
    this.observer = paramObserver;
    this.sslCertificateVerifier = paramSSLCertificateVerifier;
  }

  public static Builder builder(PeerConnection.Observer paramObserver)
  {
    return new Builder(paramObserver, null);
  }

  PeerConnection.Observer getObserver()
  {
    return this.observer;
  }

  @Nullable
  SSLCertificateVerifier getSSLCertificateVerifier()
  {
    return this.sslCertificateVerifier;
  }

  public static class Builder
  {
    private PeerConnection.Observer observer;
    private SSLCertificateVerifier sslCertificateVerifier;

    private Builder(PeerConnection.Observer paramObserver)
    {
      this.observer = paramObserver;
    }

    public PeerConnectionDependencies createPeerConnectionDependencies()
    {
      return new PeerConnectionDependencies(this.observer, this.sslCertificateVerifier, null);
    }

    public Builder setSSLCertificateVerifier(SSLCertificateVerifier paramSSLCertificateVerifier)
    {
      this.sslCertificateVerifier = paramSSLCertificateVerifier;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.PeerConnectionDependencies
 * JD-Core Version:    0.6.2
 */