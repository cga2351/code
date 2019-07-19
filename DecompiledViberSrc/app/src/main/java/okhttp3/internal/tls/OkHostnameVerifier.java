package okhttp3.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class OkHostnameVerifier
  implements HostnameVerifier
{
  private static final int ALT_DNS_NAME = 2;
  private static final int ALT_IPA_NAME = 7;
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

  public static List<String> allSubjectAltNames(X509Certificate paramX509Certificate)
  {
    List localList1 = getSubjectAltNames(paramX509Certificate, 7);
    List localList2 = getSubjectAltNames(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList1.size() + localList2.size());
    localArrayList.addAll(localList1);
    localArrayList.addAll(localList2);
    return localArrayList;
  }

  private static List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Collection localCollection = paramX509Certificate.getSubjectAlternativeNames();
      if (localCollection == null)
        return Collections.emptyList();
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localIterator.next();
        if ((localList != null) && (localList.size() >= 2))
        {
          Integer localInteger = (Integer)localList.get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            String str = (String)localList.get(1);
            if (str != null)
              localArrayList.add(str);
          }
        }
      }
    }
    catch (CertificateParsingException localCertificateParsingException)
    {
      return Collections.emptyList();
    }
    return localArrayList;
  }

  private boolean verifyHostname(String paramString, X509Certificate paramX509Certificate)
  {
    String str = paramString.toLowerCase(Locale.US);
    Iterator localIterator = getSubjectAltNames(paramX509Certificate, 2).iterator();
    while (localIterator.hasNext())
      if (verifyHostname(str, (String)localIterator.next()))
        return true;
    return false;
  }

  private boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate)
  {
    List localList = getSubjectAltNames(paramX509Certificate, 7);
    int i = localList.size();
    for (int j = 0; j < i; j++)
      if (paramString.equalsIgnoreCase((String)localList.get(j)))
        return true;
    return false;
  }

  public boolean verify(String paramString, X509Certificate paramX509Certificate)
  {
    if (Util.verifyAsIpAddress(paramString))
      return verifyIpAddress(paramString, paramX509Certificate);
    return verifyHostname(paramString, paramX509Certificate);
  }

  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException localSSLException)
    {
    }
    return false;
  }

  public boolean verifyHostname(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString1.startsWith(".")) || (paramString1.endsWith("..")));
    int i;
    do
    {
      String str2;
      do
      {
        String str1;
        do
        {
          do
            return false;
          while ((paramString2 == null) || (paramString2.length() == 0) || (paramString2.startsWith(".")) || (paramString2.endsWith("..")));
          if (!paramString1.endsWith("."))
            paramString1 = paramString1 + '.';
          if (!paramString2.endsWith("."))
            paramString2 = paramString2 + '.';
          str1 = paramString2.toLowerCase(Locale.US);
          if (!str1.contains("*"))
            return paramString1.equals(str1);
        }
        while ((!str1.startsWith("*.")) || (str1.indexOf('*', 1) != -1) || (paramString1.length() < str1.length()) || ("*.".equals(str1)));
        str2 = str1.substring(1);
      }
      while (!paramString1.endsWith(str2));
      i = paramString1.length() - str2.length();
    }
    while ((i > 0) && (paramString1.lastIndexOf('.', i - 1) != -1));
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.tls.OkHostnameVerifier
 * JD-Core Version:    0.6.2
 */