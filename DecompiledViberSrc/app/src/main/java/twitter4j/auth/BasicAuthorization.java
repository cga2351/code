package twitter4j.auth;

import java.io.Serializable;
import twitter4j.internal.http.BASE64Encoder;
import twitter4j.internal.http.HttpRequest;

public class BasicAuthorization
  implements Serializable, Authorization
{
  private static final long serialVersionUID = -5861104407848415060L;
  private String basic;
  private String password;
  private String userId;

  public BasicAuthorization(String paramString1, String paramString2)
  {
    this.userId = paramString1;
    this.password = paramString2;
    this.basic = encodeBasicAuthenticationString();
  }

  private String encodeBasicAuthenticationString()
  {
    if ((this.userId != null) && (this.password != null))
      return "Basic " + BASE64Encoder.encode(new StringBuilder().append(this.userId).append(":").append(this.password).toString().getBytes());
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof BasicAuthorization))
      return false;
    BasicAuthorization localBasicAuthorization = (BasicAuthorization)paramObject;
    return this.basic.equals(localBasicAuthorization.basic);
  }

  public String getAuthorizationHeader(HttpRequest paramHttpRequest)
  {
    return this.basic;
  }

  public String getPassword()
  {
    return this.password;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public int hashCode()
  {
    return this.basic.hashCode();
  }

  public boolean isEnabled()
  {
    return true;
  }

  public String toString()
  {
    return "BasicAuthorization{userId='" + this.userId + '\'' + ", password='**********''" + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.auth.BasicAuthorization
 * JD-Core Version:    0.6.2
 */