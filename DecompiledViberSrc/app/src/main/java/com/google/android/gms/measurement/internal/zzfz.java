package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzfz extends SSLSocket
{
  private final SSLSocket zzauv;

  zzfz(zzfy paramzzfy, SSLSocket paramSSLSocket)
  {
    this.zzauv = paramSSLSocket;
  }

  public final void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.zzauv.addHandshakeCompletedListener(paramHandshakeCompletedListener);
  }

  public final void bind(SocketAddress paramSocketAddress)
    throws IOException
  {
    this.zzauv.bind(paramSocketAddress);
  }

  public final void close()
    throws IOException
  {
    try
    {
      this.zzauv.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void connect(SocketAddress paramSocketAddress)
    throws IOException
  {
    this.zzauv.connect(paramSocketAddress);
  }

  public final void connect(SocketAddress paramSocketAddress, int paramInt)
    throws IOException
  {
    this.zzauv.connect(paramSocketAddress, paramInt);
  }

  public final boolean equals(Object paramObject)
  {
    return this.zzauv.equals(paramObject);
  }

  public final SocketChannel getChannel()
  {
    return this.zzauv.getChannel();
  }

  public final boolean getEnableSessionCreation()
  {
    return this.zzauv.getEnableSessionCreation();
  }

  public final String[] getEnabledCipherSuites()
  {
    return this.zzauv.getEnabledCipherSuites();
  }

  public final String[] getEnabledProtocols()
  {
    return this.zzauv.getEnabledProtocols();
  }

  public final InetAddress getInetAddress()
  {
    return this.zzauv.getInetAddress();
  }

  public final InputStream getInputStream()
    throws IOException
  {
    return this.zzauv.getInputStream();
  }

  public final boolean getKeepAlive()
    throws SocketException
  {
    return this.zzauv.getKeepAlive();
  }

  public final InetAddress getLocalAddress()
  {
    return this.zzauv.getLocalAddress();
  }

  public final int getLocalPort()
  {
    return this.zzauv.getLocalPort();
  }

  public final SocketAddress getLocalSocketAddress()
  {
    return this.zzauv.getLocalSocketAddress();
  }

  public final boolean getNeedClientAuth()
  {
    return this.zzauv.getNeedClientAuth();
  }

  public final boolean getOOBInline()
    throws SocketException
  {
    return this.zzauv.getOOBInline();
  }

  public final OutputStream getOutputStream()
    throws IOException
  {
    return this.zzauv.getOutputStream();
  }

  public final int getPort()
  {
    return this.zzauv.getPort();
  }

  public final int getReceiveBufferSize()
    throws SocketException
  {
    try
    {
      int i = this.zzauv.getReceiveBufferSize();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final SocketAddress getRemoteSocketAddress()
  {
    return this.zzauv.getRemoteSocketAddress();
  }

  public final boolean getReuseAddress()
    throws SocketException
  {
    return this.zzauv.getReuseAddress();
  }

  public final int getSendBufferSize()
    throws SocketException
  {
    try
    {
      int i = this.zzauv.getSendBufferSize();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final SSLSession getSession()
  {
    return this.zzauv.getSession();
  }

  public final int getSoLinger()
    throws SocketException
  {
    return this.zzauv.getSoLinger();
  }

  public final int getSoTimeout()
    throws SocketException
  {
    try
    {
      int i = this.zzauv.getSoTimeout();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String[] getSupportedCipherSuites()
  {
    return this.zzauv.getSupportedCipherSuites();
  }

  public final String[] getSupportedProtocols()
  {
    return this.zzauv.getSupportedProtocols();
  }

  public final boolean getTcpNoDelay()
    throws SocketException
  {
    return this.zzauv.getTcpNoDelay();
  }

  public final int getTrafficClass()
    throws SocketException
  {
    return this.zzauv.getTrafficClass();
  }

  public final boolean getUseClientMode()
  {
    return this.zzauv.getUseClientMode();
  }

  public final boolean getWantClientAuth()
  {
    return this.zzauv.getWantClientAuth();
  }

  public final boolean isBound()
  {
    return this.zzauv.isBound();
  }

  public final boolean isClosed()
  {
    return this.zzauv.isClosed();
  }

  public final boolean isConnected()
  {
    return this.zzauv.isConnected();
  }

  public final boolean isInputShutdown()
  {
    return this.zzauv.isInputShutdown();
  }

  public final boolean isOutputShutdown()
  {
    return this.zzauv.isOutputShutdown();
  }

  public final void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.zzauv.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
  }

  public final void sendUrgentData(int paramInt)
    throws IOException
  {
    this.zzauv.sendUrgentData(paramInt);
  }

  public final void setEnableSessionCreation(boolean paramBoolean)
  {
    this.zzauv.setEnableSessionCreation(paramBoolean);
  }

  public final void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    this.zzauv.setEnabledCipherSuites(paramArrayOfString);
  }

  public final void setEnabledProtocols(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (Arrays.asList(paramArrayOfString).contains("SSLv3")))
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(this.zzauv.getEnabledProtocols()));
      if (localArrayList.size() > 1)
        localArrayList.remove("SSLv3");
      paramArrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    this.zzauv.setEnabledProtocols(paramArrayOfString);
  }

  public final void setKeepAlive(boolean paramBoolean)
    throws SocketException
  {
    this.zzauv.setKeepAlive(paramBoolean);
  }

  public final void setNeedClientAuth(boolean paramBoolean)
  {
    this.zzauv.setNeedClientAuth(paramBoolean);
  }

  public final void setOOBInline(boolean paramBoolean)
    throws SocketException
  {
    this.zzauv.setOOBInline(paramBoolean);
  }

  public final void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzauv.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }

  public final void setReceiveBufferSize(int paramInt)
    throws SocketException
  {
    try
    {
      this.zzauv.setReceiveBufferSize(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setReuseAddress(boolean paramBoolean)
    throws SocketException
  {
    this.zzauv.setReuseAddress(paramBoolean);
  }

  public final void setSendBufferSize(int paramInt)
    throws SocketException
  {
    try
    {
      this.zzauv.setSendBufferSize(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setSoLinger(boolean paramBoolean, int paramInt)
    throws SocketException
  {
    this.zzauv.setSoLinger(paramBoolean, paramInt);
  }

  public final void setSoTimeout(int paramInt)
    throws SocketException
  {
    try
    {
      this.zzauv.setSoTimeout(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setTcpNoDelay(boolean paramBoolean)
    throws SocketException
  {
    this.zzauv.setTcpNoDelay(paramBoolean);
  }

  public final void setTrafficClass(int paramInt)
    throws SocketException
  {
    this.zzauv.setTrafficClass(paramInt);
  }

  public final void setUseClientMode(boolean paramBoolean)
  {
    this.zzauv.setUseClientMode(paramBoolean);
  }

  public final void setWantClientAuth(boolean paramBoolean)
  {
    this.zzauv.setWantClientAuth(paramBoolean);
  }

  public final void shutdownInput()
    throws IOException
  {
    this.zzauv.shutdownInput();
  }

  public final void shutdownOutput()
    throws IOException
  {
    this.zzauv.shutdownOutput();
  }

  public final void startHandshake()
    throws IOException
  {
    this.zzauv.startHandshake();
  }

  public final String toString()
  {
    return this.zzauv.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfz
 * JD-Core Version:    0.6.2
 */