package com.viber.voip.util.http;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Android4SSLSocketFactory extends SSLSocketFactory
{
  private static final Logger L = ViberEnv.getLogger();
  private final SSLSocketFactory mInternalSSLSocketFactory;

  public Android4SSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.mInternalSSLSocketFactory = paramSSLSocketFactory;
  }

  private Socket enableLatestTlsOnSocket(Socket paramSocket)
  {
    if ((paramSocket != null) && ((paramSocket instanceof SSLSocket)))
    {
      SSLSocket localSSLSocket = (SSLSocket)paramSocket;
      String[] arrayOfString = localSSLSocket.getEnabledProtocols();
      if (arrayOfString != null)
      {
        HashSet localHashSet = new HashSet(Arrays.asList(arrayOfString));
        localHashSet.add("TLSv1.1");
        localHashSet.add("TLSv1.2");
        localSSLSocket.setEnabledProtocols((String[])localHashSet.toArray(new String[localHashSet.size()]));
      }
    }
    return paramSocket;
  }

  public Socket createSocket()
    throws IOException
  {
    return enableLatestTlsOnSocket(this.mInternalSSLSocketFactory.createSocket());
  }

  public Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    return enableLatestTlsOnSocket(this.mInternalSSLSocketFactory.createSocket(paramString, paramInt));
  }

  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return enableLatestTlsOnSocket(this.mInternalSSLSocketFactory.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }

  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return enableLatestTlsOnSocket(this.mInternalSSLSocketFactory.createSocket(paramInetAddress, paramInt));
  }

  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return enableLatestTlsOnSocket(this.mInternalSSLSocketFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }

  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return enableLatestTlsOnSocket(this.mInternalSSLSocketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }

  public String[] getDefaultCipherSuites()
  {
    return this.mInternalSSLSocketFactory.getDefaultCipherSuites();
  }

  public String[] getSupportedCipherSuites()
  {
    return this.mInternalSSLSocketFactory.getSupportedCipherSuites();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.http.Android4SSLSocketFactory
 * JD-Core Version:    0.6.2
 */