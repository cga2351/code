package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES;
  public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final ConnectionSpec MODERN_TLS;

  @Nullable
  final String[] cipherSuites;
  final boolean supportsTlsExtensions;
  final boolean tls;

  @Nullable
  final String[] tlsVersions;

  static
  {
    CipherSuite[] arrayOfCipherSuite = new CipherSuite[13];
    arrayOfCipherSuite[0] = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    arrayOfCipherSuite[1] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    arrayOfCipherSuite[2] = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    arrayOfCipherSuite[3] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    arrayOfCipherSuite[4] = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    arrayOfCipherSuite[5] = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    arrayOfCipherSuite[6] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    arrayOfCipherSuite[7] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    arrayOfCipherSuite[8] = CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256;
    arrayOfCipherSuite[9] = CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384;
    arrayOfCipherSuite[10] = CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA;
    arrayOfCipherSuite[11] = CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA;
    arrayOfCipherSuite[12] = CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    APPROVED_CIPHER_SUITES = arrayOfCipherSuite;
    Builder localBuilder1 = new Builder(true).cipherSuites(APPROVED_CIPHER_SUITES);
    TlsVersion[] arrayOfTlsVersion1 = new TlsVersion[4];
    arrayOfTlsVersion1[0] = TlsVersion.TLS_1_3;
    arrayOfTlsVersion1[1] = TlsVersion.TLS_1_2;
    arrayOfTlsVersion1[2] = TlsVersion.TLS_1_1;
    arrayOfTlsVersion1[3] = TlsVersion.TLS_1_0;
    MODERN_TLS = localBuilder1.tlsVersions(arrayOfTlsVersion1).supportsTlsExtensions(true).build();
    Builder localBuilder2 = new Builder(MODERN_TLS);
    TlsVersion[] arrayOfTlsVersion2 = new TlsVersion[1];
    arrayOfTlsVersion2[0] = TlsVersion.TLS_1_0;
    COMPATIBLE_TLS = localBuilder2.tlsVersions(arrayOfTlsVersion2).supportsTlsExtensions(true).build();
  }

  ConnectionSpec(Builder paramBuilder)
  {
    this.tls = paramBuilder.tls;
    this.cipherSuites = paramBuilder.cipherSuites;
    this.tlsVersions = paramBuilder.tlsVersions;
    this.supportsTlsExtensions = paramBuilder.supportsTlsExtensions;
  }

  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.cipherSuites != null)
    {
      arrayOfString1 = Util.intersect(CipherSuite.ORDER_BY_NAME, paramSSLSocket.getEnabledCipherSuites(), this.cipherSuites);
      if (this.tlsVersions == null)
        break label112;
    }
    label112: for (String[] arrayOfString2 = Util.intersect(Util.NATURAL_ORDER, paramSSLSocket.getEnabledProtocols(), this.tlsVersions); ; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = paramSSLSocket.getSupportedCipherSuites();
      int i = Util.indexOf(CipherSuite.ORDER_BY_NAME, arrayOfString3, "TLS_FALLBACK_SCSV");
      if ((paramBoolean) && (i != -1))
        arrayOfString1 = Util.concat(arrayOfString1, arrayOfString3[i]);
      return new Builder(this).cipherSuites(arrayOfString1).tlsVersions(arrayOfString2).build();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }

  void apply(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    ConnectionSpec localConnectionSpec = supportedSpec(paramSSLSocket, paramBoolean);
    if (localConnectionSpec.tlsVersions != null)
      paramSSLSocket.setEnabledProtocols(localConnectionSpec.tlsVersions);
    if (localConnectionSpec.cipherSuites != null)
      paramSSLSocket.setEnabledCipherSuites(localConnectionSpec.cipherSuites);
  }

  @Nullable
  public List<CipherSuite> cipherSuites()
  {
    if (this.cipherSuites != null)
      return CipherSuite.forJavaNames(this.cipherSuites);
    return null;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec));
    ConnectionSpec localConnectionSpec;
    do
    {
      return false;
      if (paramObject == this)
        return true;
      localConnectionSpec = (ConnectionSpec)paramObject;
    }
    while ((this.tls != localConnectionSpec.tls) || ((this.tls) && ((!Arrays.equals(this.cipherSuites, localConnectionSpec.cipherSuites)) || (!Arrays.equals(this.tlsVersions, localConnectionSpec.tlsVersions)) || (this.supportsTlsExtensions != localConnectionSpec.supportsTlsExtensions))));
    return true;
  }

  public int hashCode()
  {
    int i = 17;
    int j;
    if (this.tls)
    {
      j = 31 * (31 * (527 + Arrays.hashCode(this.cipherSuites)) + Arrays.hashCode(this.tlsVersions));
      if (!this.supportsTlsExtensions)
        break label51;
    }
    label51: for (int k = 0; ; k = 1)
    {
      i = k + j;
      return i;
    }
  }

  public boolean isCompatible(SSLSocket paramSSLSocket)
  {
    if (!this.tls);
    while (((this.tlsVersions != null) && (!Util.nonEmptyIntersection(Util.NATURAL_ORDER, this.tlsVersions, paramSSLSocket.getEnabledProtocols()))) || ((this.cipherSuites != null) && (!Util.nonEmptyIntersection(CipherSuite.ORDER_BY_NAME, this.cipherSuites, paramSSLSocket.getEnabledCipherSuites()))))
      return false;
    return true;
  }

  public boolean isTls()
  {
    return this.tls;
  }

  public boolean supportsTlsExtensions()
  {
    return this.supportsTlsExtensions;
  }

  @Nullable
  public List<TlsVersion> tlsVersions()
  {
    if (this.tlsVersions != null)
      return TlsVersion.forJavaNames(this.tlsVersions);
    return null;
  }

  public String toString()
  {
    if (!this.tls)
      return "ConnectionSpec()";
    String str1;
    if (this.cipherSuites != null)
    {
      str1 = cipherSuites().toString();
      if (this.tlsVersions == null)
        break label92;
    }
    label92: for (String str2 = tlsVersions().toString(); ; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
      str1 = "[all enabled]";
      break;
    }
  }

  public static final class Builder
  {

    @Nullable
    String[] cipherSuites;
    boolean supportsTlsExtensions;
    boolean tls;

    @Nullable
    String[] tlsVersions;

    public Builder(ConnectionSpec paramConnectionSpec)
    {
      this.tls = paramConnectionSpec.tls;
      this.cipherSuites = paramConnectionSpec.cipherSuites;
      this.tlsVersions = paramConnectionSpec.tlsVersions;
      this.supportsTlsExtensions = paramConnectionSpec.supportsTlsExtensions;
    }

    Builder(boolean paramBoolean)
    {
      this.tls = paramBoolean;
    }

    public Builder allEnabledCipherSuites()
    {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections");
      this.cipherSuites = null;
      return this;
    }

    public Builder allEnabledTlsVersions()
    {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections");
      this.tlsVersions = null;
      return this;
    }

    public ConnectionSpec build()
    {
      return new ConnectionSpec(this);
    }

    public Builder cipherSuites(String[] paramArrayOfString)
    {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections");
      if (paramArrayOfString.length == 0)
        throw new IllegalArgumentException("At least one cipher suite is required");
      this.cipherSuites = ((String[])paramArrayOfString.clone());
      return this;
    }

    public Builder cipherSuites(CipherSuite[] paramArrayOfCipherSuite)
    {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections");
      String[] arrayOfString = new String[paramArrayOfCipherSuite.length];
      for (int i = 0; i < paramArrayOfCipherSuite.length; i++)
        arrayOfString[i] = paramArrayOfCipherSuite[i].javaName;
      return cipherSuites(arrayOfString);
    }

    public Builder supportsTlsExtensions(boolean paramBoolean)
    {
      if (!this.tls)
        throw new IllegalStateException("no TLS extensions for cleartext connections");
      this.supportsTlsExtensions = paramBoolean;
      return this;
    }

    public Builder tlsVersions(String[] paramArrayOfString)
    {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections");
      if (paramArrayOfString.length == 0)
        throw new IllegalArgumentException("At least one TLS version is required");
      this.tlsVersions = ((String[])paramArrayOfString.clone());
      return this;
    }

    public Builder tlsVersions(TlsVersion[] paramArrayOfTlsVersion)
    {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections");
      String[] arrayOfString = new String[paramArrayOfTlsVersion.length];
      for (int i = 0; i < paramArrayOfTlsVersion.length; i++)
        arrayOfString[i] = paramArrayOfTlsVersion[i].javaName;
      return tlsVersions(arrayOfString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.ConnectionSpec
 * JD-Core Version:    0.6.2
 */