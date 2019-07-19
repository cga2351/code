package twitter4j.auth;

import java.io.ObjectStreamException;
import java.io.Serializable;
import twitter4j.internal.http.HttpRequest;

public class NullAuthorization
  implements Serializable, Authorization
{
  private static NullAuthorization SINGLETON = new NullAuthorization();
  private static final long serialVersionUID = -8748173338942663960L;

  public static NullAuthorization getInstance()
  {
    return SINGLETON;
  }

  private Object readResolve()
    throws ObjectStreamException
  {
    return SINGLETON;
  }

  public boolean equals(Object paramObject)
  {
    return SINGLETON == paramObject;
  }

  public String getAuthorizationHeader(HttpRequest paramHttpRequest)
  {
    return null;
  }

  public boolean isEnabled()
  {
    return false;
  }

  public String toString()
  {
    return "NullAuthentication{SINGLETON}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.auth.NullAuthorization
 * JD-Core Version:    0.6.2
 */