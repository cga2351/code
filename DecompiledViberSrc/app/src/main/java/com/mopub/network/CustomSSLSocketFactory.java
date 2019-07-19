package com.mopub.network;

import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Reflection.MethodBuilder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class CustomSSLSocketFactory extends SSLSocketFactory
{
  private SSLSocketFactory a;

  @VisibleForTesting
  static void a(SSLCertificateSocketFactory paramSSLCertificateSocketFactory, SSLSocket paramSSLSocket, String paramString)
  {
    Preconditions.checkNotNull(paramSSLCertificateSocketFactory);
    Preconditions.checkNotNull(paramSSLSocket);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramSSLCertificateSocketFactory.setHostname(paramSSLSocket, paramString);
      return;
    }
    try
    {
      new Reflection.MethodBuilder(paramSSLSocket, "setHostname").addParam(String.class, paramString).execute();
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to call setHostname() on the socket" });
    }
  }

  private void a(Socket paramSocket)
  {
    if ((paramSocket instanceof SSLSocket))
    {
      SSLSocket localSSLSocket = (SSLSocket)paramSocket;
      localSSLSocket.setEnabledProtocols(localSSLSocket.getSupportedProtocols());
    }
  }

  private void a(Socket paramSocket, String paramString)
    throws IOException
  {
    Preconditions.checkNotNull(paramSocket);
    if (this.a == null)
      throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    if ((paramSocket instanceof SSLSocket))
    {
      SSLSocket localSSLSocket = (SSLSocket)paramSocket;
      a((SSLCertificateSocketFactory)this.a, localSSLSocket, paramString);
      a(localSSLSocket, paramString);
    }
  }

  @VisibleForTesting
  static void a(SSLSocket paramSSLSocket, String paramString)
    throws IOException
  {
    Preconditions.checkNotNull(paramSSLSocket);
    paramSSLSocket.startHandshake();
    if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSocket.getSession()))
      throw new SSLHandshakeException("Server Name Identification failed.");
  }

  public static CustomSSLSocketFactory getDefault(int paramInt)
  {
    CustomSSLSocketFactory localCustomSSLSocketFactory = new CustomSSLSocketFactory();
    localCustomSSLSocketFactory.a = SSLCertificateSocketFactory.getDefault(paramInt, null);
    return localCustomSSLSocketFactory;
  }

  public Socket createSocket()
    throws IOException
  {
    if (this.a == null)
      throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    Socket localSocket = this.a.createSocket();
    a(localSocket);
    return localSocket;
  }

  public Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    if (this.a == null)
      throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    Socket localSocket = this.a.createSocket(paramString, paramInt);
    a(localSocket);
    return localSocket;
  }

  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    if (this.a == null)
      throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    Socket localSocket = this.a.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    a(localSocket);
    return localSocket;
  }

  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    if (this.a == null)
      throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    Socket localSocket = this.a.createSocket(paramInetAddress, paramInt);
    a(localSocket);
    return localSocket;
  }

  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    if (this.a == null)
      throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    Socket localSocket = this.a.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    a(localSocket);
    return localSocket;
  }

  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (this.a == null)
      throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
    if (Build.VERSION.SDK_INT < 23)
    {
      if ((paramBoolean) && (paramSocket != null))
        paramSocket.close();
      Socket localSocket2 = this.a.createSocket(InetAddressUtils.getInetAddressByName(paramString), paramInt);
      a(localSocket2);
      a(localSocket2, paramString);
      return localSocket2;
    }
    Socket localSocket1 = this.a.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    a(localSocket1);
    return localSocket1;
  }

  public String[] getDefaultCipherSuites()
  {
    if (this.a == null)
      return new String[0];
    return this.a.getDefaultCipherSuites();
  }

  public String[] getSupportedCipherSuites()
  {
    if (this.a == null)
      return new String[0];
    return this.a.getSupportedCipherSuites();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.CustomSSLSocketFactory
 * JD-Core Version:    0.6.2
 */