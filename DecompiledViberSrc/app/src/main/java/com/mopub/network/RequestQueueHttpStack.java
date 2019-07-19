package com.mopub.network;

import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.AuthFailureError;
import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HttpResponse;
import com.mopub.volley.toolbox.HurlStack;
import com.mopub.volley.toolbox.HurlStack.UrlRewriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;

public class RequestQueueHttpStack extends HurlStack
{
  private final String a;

  public RequestQueueHttpStack(String paramString)
  {
    this(paramString, null);
  }

  public RequestQueueHttpStack(String paramString, HurlStack.UrlRewriter paramUrlRewriter)
  {
    this(paramString, paramUrlRewriter, null);
  }

  public RequestQueueHttpStack(String paramString, HurlStack.UrlRewriter paramUrlRewriter, SSLSocketFactory paramSSLSocketFactory)
  {
    super(paramUrlRewriter, paramSSLSocketFactory);
    this.a = paramString;
  }

  public HttpResponse executeRequest(Request<?> paramRequest, Map<String, String> paramMap)
    throws IOException, AuthFailureError
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
      paramMap = new TreeMap();
    paramMap.put(ResponseHeader.USER_AGENT.getKey(), this.a);
    return super.executeRequest(paramRequest, paramMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.RequestQueueHttpStack
 * JD-Core Version:    0.6.2
 */