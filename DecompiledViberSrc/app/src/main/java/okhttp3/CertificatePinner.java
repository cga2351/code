package okhttp3;

import f.f;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;

public final class CertificatePinner
{
  public static final CertificatePinner DEFAULT = new Builder().build();

  @Nullable
  private final CertificateChainCleaner certificateChainCleaner;
  private final Set<Pin> pins;

  CertificatePinner(Set<Pin> paramSet, @Nullable CertificateChainCleaner paramCertificateChainCleaner)
  {
    this.pins = paramSet;
    this.certificateChainCleaner = paramCertificateChainCleaner;
  }

  public static String pin(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate))
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    return "sha256/" + sha256((X509Certificate)paramCertificate).b();
  }

  static f sha1(X509Certificate paramX509Certificate)
  {
    return f.a(paramX509Certificate.getPublicKey().getEncoded()).d();
  }

  static f sha256(X509Certificate paramX509Certificate)
  {
    return f.a(paramX509Certificate.getPublicKey().getEncoded()).e();
  }

  public void check(String paramString, List<Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    List localList = findMatchingPins(paramString);
    if (localList.isEmpty())
      return;
    if (this.certificateChainCleaner != null)
      paramList = this.certificateChainCleaner.clean(paramList, paramString);
    int i = paramList.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label237;
      X509Certificate localX509Certificate2 = (X509Certificate)paramList.get(j);
      int i2 = localList.size();
      int i3 = 0;
      Object localObject1 = null;
      Object localObject2 = null;
      if (i3 < i2)
      {
        Pin localPin2 = (Pin)localList.get(i3);
        if (localPin2.hashAlgorithm.equals("sha256/"))
        {
          if (localObject1 == null)
            localObject1 = sha256(localX509Certificate2);
          if (localPin2.hash.equals(localObject1))
            break;
        }
        do
        {
          Object localObject3 = localObject1;
          Object localObject4 = localObject2;
          i3++;
          localObject2 = localObject4;
          localObject1 = localObject3;
          break;
          if (!localPin2.hashAlgorithm.equals("sha1/"))
            break label200;
          if (localObject2 == null)
            localObject2 = sha1(localX509Certificate2);
        }
        while (!localPin2.hash.equals(localObject2));
        return;
        label200: throw new AssertionError("unsupported hashAlgorithm: " + localPin2.hashAlgorithm);
      }
    }
    label237: StringBuilder localStringBuilder = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    int k = paramList.size();
    for (int m = 0; m < k; m++)
    {
      X509Certificate localX509Certificate1 = (X509Certificate)paramList.get(m);
      localStringBuilder.append("\n    ").append(pin(localX509Certificate1)).append(": ").append(localX509Certificate1.getSubjectDN().getName());
    }
    localStringBuilder.append("\n  Pinned certificates for ").append(paramString).append(":");
    int n = localList.size();
    for (int i1 = 0; i1 < n; i1++)
    {
      Pin localPin1 = (Pin)localList.get(i1);
      localStringBuilder.append("\n    ").append(localPin1);
    }
    throw new SSLPeerUnverifiedException(localStringBuilder.toString());
  }

  public void check(String paramString, Certificate[] paramArrayOfCertificate)
    throws SSLPeerUnverifiedException
  {
    check(paramString, Arrays.asList(paramArrayOfCertificate));
  }

  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (((paramObject instanceof CertificatePinner)) && (Util.equal(this.certificateChainCleaner, ((CertificatePinner)paramObject).certificateChainCleaner)) && (this.pins.equals(((CertificatePinner)paramObject).pins)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  List<Pin> findMatchingPins(String paramString)
  {
    Object localObject = Collections.emptyList();
    Iterator localIterator = this.pins.iterator();
    while (localIterator.hasNext())
    {
      Pin localPin = (Pin)localIterator.next();
      if (localPin.matches(paramString))
      {
        if (((List)localObject).isEmpty())
          localObject = new ArrayList();
        ((List)localObject).add(localPin);
      }
    }
    return localObject;
  }

  public int hashCode()
  {
    if (this.certificateChainCleaner != null);
    for (int i = this.certificateChainCleaner.hashCode(); ; i = 0)
      return i * 31 + this.pins.hashCode();
  }

  CertificatePinner withCertificateChainCleaner(@Nullable CertificateChainCleaner paramCertificateChainCleaner)
  {
    if (Util.equal(this.certificateChainCleaner, paramCertificateChainCleaner))
      return this;
    return new CertificatePinner(this.pins, paramCertificateChainCleaner);
  }

  public static final class Builder
  {
    private final List<CertificatePinner.Pin> pins = new ArrayList();

    public Builder add(String paramString, String[] paramArrayOfString)
    {
      if (paramString == null)
        throw new NullPointerException("pattern == null");
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        this.pins.add(new CertificatePinner.Pin(paramString, str));
      }
      return this;
    }

    public CertificatePinner build()
    {
      return new CertificatePinner(new LinkedHashSet(this.pins), null);
    }
  }

  static final class Pin
  {
    private static final String WILDCARD = "*.";
    final String canonicalHostname;
    final f hash;
    final String hashAlgorithm;
    final String pattern;

    Pin(String paramString1, String paramString2)
    {
      this.pattern = paramString1;
      String str;
      if (paramString1.startsWith("*."))
      {
        str = HttpUrl.parse("http://" + paramString1.substring("*.".length())).host();
        this.canonicalHostname = str;
        if (!paramString2.startsWith("sha1/"))
          break label151;
        this.hashAlgorithm = "sha1/";
        this.hash = f.b(paramString2.substring("sha1/".length()));
      }
      while (true)
        if (this.hash == null)
        {
          throw new IllegalArgumentException("pins must be base64: " + paramString2);
          str = HttpUrl.parse("http://" + paramString1).host();
          break;
          label151: if (paramString2.startsWith("sha256/"))
          {
            this.hashAlgorithm = "sha256/";
            this.hash = f.b(paramString2.substring("sha256/".length()));
          }
          else
          {
            throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + paramString2);
          }
        }
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof Pin)) && (this.pattern.equals(((Pin)paramObject).pattern)) && (this.hashAlgorithm.equals(((Pin)paramObject).hashAlgorithm)) && (this.hash.equals(((Pin)paramObject).hash));
    }

    public int hashCode()
    {
      return 31 * (31 * (527 + this.pattern.hashCode()) + this.hashAlgorithm.hashCode()) + this.hash.hashCode();
    }

    boolean matches(String paramString)
    {
      if (this.pattern.startsWith("*."))
      {
        int i = paramString.indexOf('.');
        int j = -1 + (paramString.length() - i);
        int k = this.canonicalHostname.length();
        boolean bool1 = false;
        if (j == k)
        {
          boolean bool2 = paramString.regionMatches(false, i + 1, this.canonicalHostname, 0, this.canonicalHostname.length());
          bool1 = false;
          if (bool2)
            bool1 = true;
        }
        return bool1;
      }
      return paramString.equals(this.canonicalHostname);
    }

    public String toString()
    {
      return this.hashAlgorithm + this.hash.b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.CertificatePinner
 * JD-Core Version:    0.6.2
 */