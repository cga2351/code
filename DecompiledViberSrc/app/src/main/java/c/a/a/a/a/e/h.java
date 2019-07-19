package c.a.a.a.a.e;

import c.a.a.a.c;
import c.a.a.a.l;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class h
  implements X509TrustManager
{
  private static final X509Certificate[] a = new X509Certificate[0];
  private final TrustManager[] b = a(parami);
  private final i c;
  private final long d;
  private final List<byte[]> e = new LinkedList();
  private final Set<X509Certificate> f = Collections.synchronizedSet(new HashSet());

  public h(i parami, g paramg)
  {
    this.c = parami;
    this.d = paramg.d();
    for (String str : paramg.c())
      this.e.add(a(str));
  }

  private void a(X509Certificate[] paramArrayOfX509Certificate)
    throws CertificateException
  {
    if ((this.d != -1L) && (System.currentTimeMillis() - this.d > 15552000000L))
    {
      c.g().d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.d) + " millis vs " + 15552000000L + " millis) falling back to system trust.");
      return;
    }
    X509Certificate[] arrayOfX509Certificate = a.a(paramArrayOfX509Certificate, this.c);
    int i = arrayOfX509Certificate.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label117;
      if (a(arrayOfX509Certificate[j]))
        break;
    }
    label117: throw new CertificateException("No valid pins found in chain!");
  }

  private void a(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    TrustManager[] arrayOfTrustManager = this.b;
    int i = arrayOfTrustManager.length;
    for (int j = 0; j < i; j++)
      ((X509TrustManager)arrayOfTrustManager[j]).checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }

  private boolean a(X509Certificate paramX509Certificate)
    throws CertificateException
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("SHA1").digest(paramX509Certificate.getPublicKey().getEncoded());
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = Arrays.equals((byte[])localIterator.next(), arrayOfByte);
        if (bool)
          return true;
      }
      return false;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new CertificateException(localNoSuchAlgorithmException);
    }
  }

  private byte[] a(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i / 2];
    for (int j = 0; j < i; j += 2)
      arrayOfByte[(j / 2)] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16)));
    return arrayOfByte;
  }

  private TrustManager[] a(i parami)
  {
    try
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
      localTrustManagerFactory.init(parami.a);
      TrustManager[] arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
      return arrayOfTrustManager;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
    catch (KeyStoreException localKeyStoreException)
    {
      throw new AssertionError(localKeyStoreException);
    }
  }

  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    throw new CertificateException("Client certificates not supported!");
  }

  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    if (this.f.contains(paramArrayOfX509Certificate[0]))
      return;
    a(paramArrayOfX509Certificate, paramString);
    a(paramArrayOfX509Certificate);
    this.f.add(paramArrayOfX509Certificate[0]);
  }

  public X509Certificate[] getAcceptedIssuers()
  {
    return a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.e.h
 * JD-Core Version:    0.6.2
 */