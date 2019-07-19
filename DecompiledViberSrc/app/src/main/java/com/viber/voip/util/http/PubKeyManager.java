package com.viber.voip.util.http;

import android.util.Base64;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class PubKeyManager
  implements X509TrustManager
{
  private static String EquifaxSecureCA;
  private static String VeriSignClass3PublicPrimaryCertificationAuthority_G5;
  private static HashSet<String> allowedPK;
  private static String thawtePrimaryRootCA;

  static
  {
    if (!PubKeyManager.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      thawtePrimaryRootCA = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArKDw+4BZ1JzHpM+doVlzCRBFDA0sbmjxbFtIaElZN/wLMxnCd3/MEC2VNBzm600JpxzSuMmXNgK3idQkXwbAzESUlI0CYm/rWt0RjSiaXISQEHoNvXRmL2o4oOLVVETrHQefB7pv7un9Tgsp9T6EoAHxnKv4HH6JpOih2HFlDaNRe+680iJgDblbnd+6/FFbC6+Ysuku6QToYofeK8jXTsFMZB7dz4dYukpPymgHHRydSsbVL5HMfHFyHMXAZ+sy/cmSXJTahcCbv1N9Kwn0jJ2RH5dqUsveCTakd9h7h1BE1T5uKWn7OUkmHgmlgHtALevoJ4XJ/mH9fuZ8lx3VnQIDAQAB";
      VeriSignClass3PublicPrimaryCertificationAuthority_G5 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAryQICCl6NZ5gDKrnSztO3Hy8PEUcuyvg/ikC+VcIo2SFFSf18a3IMYldIugqqqZCs4/4uVW3sbdLs/6PfgdX7O9D22ZiFWHPYA2k2N744MNiCD1UE+tJyllUhSblK48bn+v1oZHCM0nYQ2NqUkvSj+hwUU3RiWl7x3D2s9wSdNt7XUtW05a/FXehsPSiJfKvHJJnGOX0BgTvkLnkAOTdOrUZ/wK69Dzu4IvrN4vs9Nes8vbwPa/ddZEzGR0cQMt0JBkhk9kU/qwqUseP1QRJ5I1jR4g8aYPL/ke9K35PxZWuDp3U0UPAZ3PjFAh+5T+fc7gzCs9dPzSHloruU+glFQIDAQAB";
      EquifaxSecureCA = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBXbFYZwhi7qCaLR8IbZEUaJgKHv7aBG8ThGIhw9F8zp8F4LgB8E407OKKlQRkrPFrU18Fs8tngL9CAo7+3QEJ7OEAFE/8+/AM3UO6WyvhH4BwmRVXkxbxD5dqt8JoIxzMTVkwrFEeO68r1u5jRXvF2V9Q0uNQDzqI578U/eDHuQIDAQAB";
      allowedPK = new HashSet();
      allowedPK.add(thawtePrimaryRootCA);
      allowedPK.add(VeriSignClass3PublicPrimaryCertificationAuthority_G5);
      allowedPK.add(EquifaxSecureCA);
      return;
    }
  }

  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    assert (paramArrayOfX509Certificate != null);
    if (paramArrayOfX509Certificate == null)
      throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
    if (paramArrayOfX509Certificate.length <= 0)
      throw new IllegalArgumentException("checkServerTrusted: X509Certificate is empty");
    try
    {
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance("X509");
      localTrustManagerFactory.init((KeyStore)null);
      TrustManager[] arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
      int i = arrayOfTrustManager.length;
      for (int j = 0; j < i; j++)
        ((X509TrustManager)arrayOfTrustManager[j]).checkServerTrusted(paramArrayOfX509Certificate, paramString);
    }
    catch (Exception localException)
    {
      throw new CertificateException(localException);
    }
    int k = paramArrayOfX509Certificate.length;
    int m = 0;
    if (m < k)
    {
      String str = Base64.encodeToString(paramArrayOfX509Certificate[m].getPublicKey().getEncoded(), 2);
      if (!allowedPK.contains(str));
    }
    for (int n = 1; ; n = 0)
    {
      if (n == 0)
      {
        throw new CertificateException("checkServerTrusted: Expected public keys: " + allowedPK.toArray()[0].toString());
        m++;
        break;
      }
      return;
    }
  }

  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.http.PubKeyManager
 * JD-Core Version:    0.6.2
 */