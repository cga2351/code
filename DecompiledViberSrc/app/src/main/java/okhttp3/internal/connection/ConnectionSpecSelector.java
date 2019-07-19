package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

public final class ConnectionSpecSelector
{
  private final List<ConnectionSpec> connectionSpecs;
  private boolean isFallback;
  private boolean isFallbackPossible;
  private int nextModeIndex = 0;

  public ConnectionSpecSelector(List<ConnectionSpec> paramList)
  {
    this.connectionSpecs = paramList;
  }

  private boolean isFallbackPossible(SSLSocket paramSSLSocket)
  {
    for (int i = this.nextModeIndex; i < this.connectionSpecs.size(); i++)
      if (((ConnectionSpec)this.connectionSpecs.get(i)).isCompatible(paramSSLSocket))
        return true;
    return false;
  }

  public ConnectionSpec configureSecureSocket(SSLSocket paramSSLSocket)
    throws IOException
  {
    int i = this.nextModeIndex;
    int j = this.connectionSpecs.size();
    int k = i;
    ConnectionSpec localConnectionSpec;
    if (k < j)
    {
      localConnectionSpec = (ConnectionSpec)this.connectionSpecs.get(k);
      if (localConnectionSpec.isCompatible(paramSSLSocket))
        this.nextModeIndex = (k + 1);
    }
    while (true)
    {
      if (localConnectionSpec == null)
      {
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
        k++;
        break;
      }
      this.isFallbackPossible = isFallbackPossible(paramSSLSocket);
      Internal.instance.apply(localConnectionSpec, paramSSLSocket, this.isFallback);
      return localConnectionSpec;
      localConnectionSpec = null;
    }
  }

  public boolean connectionFailed(IOException paramIOException)
  {
    this.isFallback = true;
    if (!this.isFallbackPossible);
    while (((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof InterruptedIOException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)) || ((!(paramIOException instanceof SSLHandshakeException)) && (!(paramIOException instanceof SSLProtocolException))))
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.ConnectionSpecSelector
 * JD-Core Version:    0.6.2
 */