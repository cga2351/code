package twitter4j.internal.http;

import java.util.Map;

public abstract interface HttpClientWrapperConfiguration extends HttpClientConfiguration
{
  public abstract Map<String, String> getRequestHeaders();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.HttpClientWrapperConfiguration
 * JD-Core Version:    0.6.2
 */