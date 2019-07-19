package okhttp3.internal.http;

public final class HttpMethod
{
  public static boolean invalidatesCache(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE")) || (paramString.equals("MOVE"));
  }

  public static boolean permitsRequestBody(String paramString)
  {
    return (!paramString.equals("GET")) && (!paramString.equals("HEAD"));
  }

  public static boolean redirectsToGet(String paramString)
  {
    return !paramString.equals("PROPFIND");
  }

  public static boolean redirectsWithBody(String paramString)
  {
    return paramString.equals("PROPFIND");
  }

  public static boolean requiresRequestBody(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")) || (paramString.equals("PROPPATCH")) || (paramString.equals("REPORT"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.HttpMethod
 * JD-Core Version:    0.6.2
 */