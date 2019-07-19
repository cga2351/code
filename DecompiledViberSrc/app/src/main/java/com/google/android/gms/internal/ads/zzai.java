package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;

final class zzai extends zzaj
{
  private final zzas zzbp;

  zzai(zzas paramzzas)
  {
    this.zzbp = paramzzas;
  }

  public final zzar zza(zzr<?> paramzzr, Map<String, String> paramMap)
    throws IOException, zza
  {
    HttpResponse localHttpResponse;
    int i;
    ArrayList localArrayList;
    try
    {
      localHttpResponse = this.zzbp.zzb(paramzzr, paramMap);
      i = localHttpResponse.getStatusLine().getStatusCode();
      Header[] arrayOfHeader = localHttpResponse.getAllHeaders();
      localArrayList = new ArrayList(arrayOfHeader.length);
      int j = arrayOfHeader.length;
      for (int k = 0; k < j; k++)
      {
        Header localHeader = arrayOfHeader[k];
        localArrayList.add(new zzl(localHeader.getName(), localHeader.getValue()));
      }
    }
    catch (ConnectTimeoutException localConnectTimeoutException)
    {
      throw new SocketTimeoutException(localConnectTimeoutException.getMessage());
    }
    if (localHttpResponse.getEntity() == null)
      return new zzar(i, localArrayList);
    long l = localHttpResponse.getEntity().getContentLength();
    if ((int)l != l)
      throw new IOException(40 + "Response too large: " + l);
    return new zzar(i, localArrayList, (int)localHttpResponse.getEntity().getContentLength(), localHttpResponse.getEntity().getContent());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzai
 * JD-Core Version:    0.6.2
 */