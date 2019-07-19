package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class BasicCertificateChainCleaner extends CertificateChainCleaner
{
  private static final int MAX_SIGNERS = 9;
  private final TrustRootIndex trustRootIndex;

  public BasicCertificateChainCleaner(TrustRootIndex paramTrustRootIndex)
  {
    this.trustRootIndex = paramTrustRootIndex;
  }

  private boolean verifySignature(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    if (!paramX509Certificate1.getIssuerDN().equals(paramX509Certificate2.getSubjectDN()))
      return false;
    try
    {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
    }
    return false;
  }

  public List<Certificate> clean(List<Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException
  {
    ArrayDeque localArrayDeque = new ArrayDeque(paramList);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localArrayDeque.removeFirst());
    int i = 0;
    int j = 0;
    if (i < 9)
    {
      X509Certificate localX509Certificate1 = (X509Certificate)localArrayList.get(-1 + localArrayList.size());
      X509Certificate localX509Certificate2 = this.trustRootIndex.findByIssuerAndSignature(localX509Certificate1);
      if (localX509Certificate2 != null)
      {
        if ((localArrayList.size() > 1) || (!localX509Certificate1.equals(localX509Certificate2)))
          localArrayList.add(localX509Certificate2);
        if (verifySignature(localX509Certificate2, localX509Certificate2))
          return localArrayList;
      }
      for (int k = 1; ; k = j)
      {
        i++;
        j = k;
        break;
        Iterator localIterator = localArrayDeque.iterator();
        X509Certificate localX509Certificate3;
        do
        {
          if (!localIterator.hasNext())
            break;
          localX509Certificate3 = (X509Certificate)localIterator.next();
        }
        while (!verifySignature(localX509Certificate1, localX509Certificate3));
        localIterator.remove();
        localArrayList.add(localX509Certificate3);
      }
      if (j != 0)
        return localArrayList;
      throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + localX509Certificate1);
    }
    throw new SSLPeerUnverifiedException("Certificate chain too long: " + localArrayList);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (((paramObject instanceof BasicCertificateChainCleaner)) && (((BasicCertificateChainCleaner)paramObject).trustRootIndex.equals(this.trustRootIndex)))
      return true;
    return false;
  }

  public int hashCode()
  {
    return this.trustRootIndex.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.tls.BasicCertificateChainCleaner
 * JD-Core Version:    0.6.2
 */