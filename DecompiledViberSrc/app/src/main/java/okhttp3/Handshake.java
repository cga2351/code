package okhttp3;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class Handshake
{
  private final CipherSuite cipherSuite;
  private final List<Certificate> localCertificates;
  private final List<Certificate> peerCertificates;
  private final TlsVersion tlsVersion;

  private Handshake(TlsVersion paramTlsVersion, CipherSuite paramCipherSuite, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.tlsVersion = paramTlsVersion;
    this.cipherSuite = paramCipherSuite;
    this.peerCertificates = paramList1;
    this.localCertificates = paramList2;
  }

  public static Handshake get(SSLSession paramSSLSession)
  {
    String str1 = paramSSLSession.getCipherSuite();
    if (str1 == null)
      throw new IllegalStateException("cipherSuite == null");
    CipherSuite localCipherSuite = CipherSuite.forJavaName(str1);
    String str2 = paramSSLSession.getProtocol();
    if (str2 == null)
      throw new IllegalStateException("tlsVersion == null");
    TlsVersion localTlsVersion = TlsVersion.forJavaName(str2);
    try
    {
      Certificate[] arrayOfCertificate3 = paramSSLSession.getPeerCertificates();
      arrayOfCertificate1 = arrayOfCertificate3;
      if (arrayOfCertificate1 != null)
      {
        localList1 = Util.immutableList(arrayOfCertificate1);
        Certificate[] arrayOfCertificate2 = paramSSLSession.getLocalCertificates();
        if (arrayOfCertificate2 == null)
          break label128;
        localList2 = Util.immutableList(arrayOfCertificate2);
        return new Handshake(localTlsVersion, localCipherSuite, localList1, localList2);
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      while (true)
      {
        Certificate[] arrayOfCertificate1 = null;
        continue;
        List localList1 = Collections.emptyList();
        continue;
        label128: List localList2 = Collections.emptyList();
      }
    }
  }

  public static Handshake get(TlsVersion paramTlsVersion, CipherSuite paramCipherSuite, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    if (paramTlsVersion == null)
      throw new NullPointerException("tlsVersion == null");
    if (paramCipherSuite == null)
      throw new NullPointerException("cipherSuite == null");
    return new Handshake(paramTlsVersion, paramCipherSuite, Util.immutableList(paramList1), Util.immutableList(paramList2));
  }

  public CipherSuite cipherSuite()
  {
    return this.cipherSuite;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof Handshake));
    Handshake localHandshake;
    do
    {
      return false;
      localHandshake = (Handshake)paramObject;
    }
    while ((!this.tlsVersion.equals(localHandshake.tlsVersion)) || (!this.cipherSuite.equals(localHandshake.cipherSuite)) || (!this.peerCertificates.equals(localHandshake.peerCertificates)) || (!this.localCertificates.equals(localHandshake.localCertificates)));
    return true;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (527 + this.tlsVersion.hashCode()) + this.cipherSuite.hashCode()) + this.peerCertificates.hashCode()) + this.localCertificates.hashCode();
  }

  public List<Certificate> localCertificates()
  {
    return this.localCertificates;
  }

  @Nullable
  public Principal localPrincipal()
  {
    if (!this.localCertificates.isEmpty())
      return ((X509Certificate)this.localCertificates.get(0)).getSubjectX500Principal();
    return null;
  }

  public List<Certificate> peerCertificates()
  {
    return this.peerCertificates;
  }

  @Nullable
  public Principal peerPrincipal()
  {
    if (!this.peerCertificates.isEmpty())
      return ((X509Certificate)this.peerCertificates.get(0)).getSubjectX500Principal();
    return null;
  }

  public TlsVersion tlsVersion()
  {
    return this.tlsVersion;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Handshake
 * JD-Core Version:    0.6.2
 */