package okhttp3;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;

public final class JavaNetAuthenticator
  implements Authenticator
{
  private InetAddress getConnectToInetAddress(Proxy paramProxy, HttpUrl paramHttpUrl)
    throws IOException
  {
    if ((paramProxy != null) && (paramProxy.type() != Proxy.Type.DIRECT))
      return ((InetSocketAddress)paramProxy.address()).getAddress();
    return InetAddress.getByName(paramHttpUrl.host());
  }

  public Request authenticate(Route paramRoute, Response paramResponse)
    throws IOException
  {
    List localList = paramResponse.challenges();
    Request localRequest = paramResponse.request();
    HttpUrl localHttpUrl = localRequest.url();
    if (paramResponse.code() == 407);
    Proxy localProxy;
    Challenge localChallenge;
    for (int i = 1; ; i = 0)
    {
      localProxy = paramRoute.proxy();
      int j = localList.size();
      for (int k = 0; ; k++)
      {
        if (k >= j)
          break label271;
        localChallenge = (Challenge)localList.get(k);
        if ("Basic".equalsIgnoreCase(localChallenge.scheme()))
          break;
      }
    }
    PasswordAuthentication localPasswordAuthentication;
    label154: String str1;
    Request.Builder localBuilder;
    if (i != 0)
    {
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)localProxy.address();
      localPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(localInetSocketAddress.getHostName(), getConnectToInetAddress(localProxy, localHttpUrl), localInetSocketAddress.getPort(), localHttpUrl.scheme(), localChallenge.realm(), localChallenge.scheme(), localHttpUrl.url(), Authenticator.RequestorType.PROXY);
      if (localPasswordAuthentication == null)
        break label262;
      str1 = Credentials.basic(localPasswordAuthentication.getUserName(), new String(localPasswordAuthentication.getPassword()), localChallenge.charset());
      localBuilder = localRequest.newBuilder();
      if (i == 0)
        break label264;
    }
    label262: label264: for (String str2 = "Proxy-Authorization"; ; str2 = "Authorization")
    {
      return localBuilder.header(str2, str1).build();
      localPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(localHttpUrl.host(), getConnectToInetAddress(localProxy, localHttpUrl), localHttpUrl.port(), localHttpUrl.scheme(), localChallenge.realm(), localChallenge.scheme(), localHttpUrl.url(), Authenticator.RequestorType.SERVER);
      break label154;
      break;
    }
    label271: return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.JavaNetAuthenticator
 * JD-Core Version:    0.6.2
 */