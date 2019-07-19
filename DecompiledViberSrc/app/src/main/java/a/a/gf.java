package a.a;

import com.appboy.f.c;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class gf extends SSLSocketFactory
{
  private static final String a = c.a(gf.class);
  private SSLSocketFactory b;

  public gf()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS");
    localSSLContext.init(null, null, null);
    this.b = localSSLContext.getSocketFactory();
  }

  private Socket a(Socket paramSocket)
  {
    if ((paramSocket != null) && ((paramSocket instanceof SSLSocket)))
    {
      SSLSocket localSSLSocket = (SSLSocket)paramSocket;
      ArrayList localArrayList = new ArrayList();
      for (String str : localSSLSocket.getSupportedProtocols())
        if (!str.equals("SSLv3"))
          localArrayList.add(str);
      c.a(a, "Enabling SSL protocols: " + localArrayList);
      localSSLSocket.setEnabledProtocols((String[])localArrayList.toArray(new String[localArrayList.size()]));
    }
    return paramSocket;
  }

  public Socket createSocket()
  {
    return a(this.b.createSocket());
  }

  public Socket createSocket(String paramString, int paramInt)
  {
    return a(this.b.createSocket(paramString, paramInt));
  }

  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return a(this.b.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }

  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return a(this.b.createSocket(paramInetAddress, paramInt));
  }

  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return a(this.b.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }

  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return a(this.b.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }

  public String[] getDefaultCipherSuites()
  {
    return this.b.getDefaultCipherSuites();
  }

  public String[] getSupportedCipherSuites()
  {
    return this.b.getSupportedCipherSuites();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gf
 * JD-Core Version:    0.6.2
 */