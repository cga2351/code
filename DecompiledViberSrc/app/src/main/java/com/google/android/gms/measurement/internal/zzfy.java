package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class zzfy extends SSLSocketFactory
{
  private final SSLSocketFactory zzauu;

  zzfy()
  {
    this(HttpsURLConnection.getDefaultSSLSocketFactory());
  }

  private zzfy(SSLSocketFactory paramSSLSocketFactory)
  {
    this.zzauu = paramSSLSocketFactory;
  }

  private final SSLSocket zza(SSLSocket paramSSLSocket)
  {
    return new zzfz(this, paramSSLSocket);
  }

  public final Socket createSocket()
    throws IOException
  {
    return zza((SSLSocket)this.zzauu.createSocket());
  }

  public final Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    return zza((SSLSocket)this.zzauu.createSocket(paramString, paramInt));
  }

  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return zza((SSLSocket)this.zzauu.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }

  public final Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return zza((SSLSocket)this.zzauu.createSocket(paramInetAddress, paramInt));
  }

  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return zza((SSLSocket)this.zzauu.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }

  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return zza((SSLSocket)this.zzauu.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }

  public final String[] getDefaultCipherSuites()
  {
    return this.zzauu.getDefaultCipherSuites();
  }

  public final String[] getSupportedCipherSuites()
  {
    return this.zzauu.getSupportedCipherSuites();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfy
 * JD-Core Version:    0.6.2
 */