package com.viber.libnativehttp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Tls12SocketFactory extends SSLSocketFactory
{
  private final String[] TLS_V12_ONLY = { "TLSv1.2" };
  final SSLSocketFactory delegate;

  public Tls12SocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.delegate = paramSSLSocketFactory;
  }

  private Socket patch(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket))
      ((SSLSocket)paramSocket).setEnabledProtocols(this.TLS_V12_ONLY);
    return paramSocket;
  }

  public Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    return patch(this.delegate.createSocket(paramString, paramInt));
  }

  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    return patch(this.delegate.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }

  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return patch(this.delegate.createSocket(paramInetAddress, paramInt));
  }

  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return patch(this.delegate.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }

  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return patch(this.delegate.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }

  public String[] getDefaultCipherSuites()
  {
    return this.delegate.getDefaultCipherSuites();
  }

  public String[] getSupportedCipherSuites()
  {
    return this.delegate.getSupportedCipherSuites();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.Tls12SocketFactory
 * JD-Core Version:    0.6.2
 */