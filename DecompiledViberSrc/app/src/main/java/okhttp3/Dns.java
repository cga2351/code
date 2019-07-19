package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public abstract interface Dns
{
  public static final Dns SYSTEM = new Dns()
  {
    public List<InetAddress> lookup(String paramAnonymousString)
      throws UnknownHostException
    {
      if (paramAnonymousString == null)
        throw new UnknownHostException("hostname == null");
      try
      {
        List localList = Arrays.asList(InetAddress.getAllByName(paramAnonymousString));
        return localList;
      }
      catch (NullPointerException localNullPointerException)
      {
        UnknownHostException localUnknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + paramAnonymousString);
        localUnknownHostException.initCause(localNullPointerException);
        throw localUnknownHostException;
      }
    }
  };

  public abstract List<InetAddress> lookup(String paramString)
    throws UnknownHostException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Dns
 * JD-Core Version:    0.6.2
 */