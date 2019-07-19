package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

final class zzbex extends SSLSocketFactory
{
  private SSLSocketFactory zzegq = (SSLSocketFactory)SSLSocketFactory.getDefault();

  zzbex(zzbew paramzzbew)
  {
  }

  private final Socket zzb(Socket paramSocket)
    throws SocketException
  {
    if (zzbew.zza(this.zzegr) > 0)
      paramSocket.setReceiveBufferSize(zzbew.zza(this.zzegr));
    zzbew.zza(this.zzegr, paramSocket);
    return paramSocket;
  }

  public final Socket createSocket(String paramString, int paramInt)
    throws IOException
  {
    return zzb(this.zzegq.createSocket(paramString, paramInt));
  }

  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return zzb(this.zzegq.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }

  public final Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return zzb(this.zzegq.createSocket(paramInetAddress, paramInt));
  }

  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return zzb(this.zzegq.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }

  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return zzb(this.zzegq.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }

  public final String[] getDefaultCipherSuites()
  {
    return this.zzegq.getDefaultCipherSuites();
  }

  public final String[] getSupportedCipherSuites()
  {
    return this.zzegq.getSupportedCipherSuites();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbex
 * JD-Core Version:    0.6.2
 */