package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class pn extends SSLSocketFactory
{
  private final SSLSocketFactory a;

  private pn(SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = paramSSLSocketFactory;
  }

  public static SSLSocketFactory a()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLSv1");
      try
      {
        localSSLContext.init(null, null, null);
        return new pn(localSSLContext.getSocketFactory());
      }
      catch (KeyManagementException localKeyManagementException)
      {
        while (true)
          new Object[1][0] = localKeyManagementException.getMessage();
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "TLSv1";
      arrayOfObject[1] = localNoSuchAlgorithmException.getMessage();
    }
    return null;
  }

  private static String[] a(SSLSocketFactory paramSSLSocketFactory)
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramSSLSocketFactory.getDefaultCipherSuites()));
    localArrayList.remove("TLS_RSA_WITH_AES_128_CBC_SHA");
    localArrayList.add(0, "TLS_RSA_WITH_AES_128_CBC_SHA");
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  public final Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    Socket localSocket = this.a.createSocket(paramString, paramInt);
    String[] arrayOfString = a(this.a);
    ((SSLSocket)localSocket).setEnabledCipherSuites(arrayOfString);
    return localSocket;
  }

  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    Socket localSocket = this.a.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    String[] arrayOfString = a(this.a);
    ((SSLSocket)localSocket).setEnabledCipherSuites(arrayOfString);
    return localSocket;
  }

  public final Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    Socket localSocket = this.a.createSocket(paramInetAddress, paramInt);
    String[] arrayOfString = a(this.a);
    ((SSLSocket)localSocket).setEnabledCipherSuites(arrayOfString);
    return localSocket;
  }

  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    Socket localSocket = this.a.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    String[] arrayOfString = a(this.a);
    ((SSLSocket)localSocket).setEnabledCipherSuites(arrayOfString);
    return localSocket;
  }

  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    Socket localSocket = this.a.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    String[] arrayOfString = a(this.a);
    ((SSLSocket)localSocket).setEnabledCipherSuites(arrayOfString);
    return localSocket;
  }

  public final String[] getDefaultCipherSuites()
  {
    return a(this.a);
  }

  public final String[] getSupportedCipherSuites()
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(this.a.getSupportedCipherSuites()));
    localArrayList.remove("TLS_RSA_WITH_AES_128_CBC_SHA");
    localArrayList.add(0, "TLS_RSA_WITH_AES_128_CBC_SHA");
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.pn
 * JD-Core Version:    0.6.2
 */