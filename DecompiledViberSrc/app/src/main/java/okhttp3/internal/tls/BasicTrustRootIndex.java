package okhttp3.internal.tls;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class BasicTrustRootIndex
  implements TrustRootIndex
{
  private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts = new LinkedHashMap();

  public BasicTrustRootIndex(X509Certificate[] paramArrayOfX509Certificate)
  {
    int i = paramArrayOfX509Certificate.length;
    for (int j = 0; j < i; j++)
    {
      X509Certificate localX509Certificate = paramArrayOfX509Certificate[j];
      X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
      Object localObject = (Set)this.subjectToCaCerts.get(localX500Principal);
      if (localObject == null)
      {
        localObject = new LinkedHashSet(1);
        this.subjectToCaCerts.put(localX500Principal, localObject);
      }
      ((Set)localObject).add(localX509Certificate);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (((paramObject instanceof BasicTrustRootIndex)) && (((BasicTrustRootIndex)paramObject).subjectToCaCerts.equals(this.subjectToCaCerts)))
      return true;
    return false;
  }

  public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
  {
    X500Principal localX500Principal = paramX509Certificate.getIssuerX500Principal();
    Set localSet = (Set)this.subjectToCaCerts.get(localX500Principal);
    if (localSet == null)
      return null;
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      X509Certificate localX509Certificate = (X509Certificate)localIterator.next();
      PublicKey localPublicKey = localX509Certificate.getPublicKey();
      try
      {
        paramX509Certificate.verify(localPublicKey);
        return localX509Certificate;
      }
      catch (Exception localException)
      {
      }
    }
    return null;
  }

  public int hashCode()
  {
    return this.subjectToCaCerts.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.tls.BasicTrustRootIndex
 * JD-Core Version:    0.6.2
 */