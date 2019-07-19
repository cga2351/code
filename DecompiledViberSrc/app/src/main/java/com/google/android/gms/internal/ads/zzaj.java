package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public abstract class zzaj
  implements zzas
{
  public abstract zzar zza(zzr<?> paramzzr, Map<String, String> paramMap)
    throws IOException, zza;

  @Deprecated
  public final HttpResponse zzb(zzr<?> paramzzr, Map<String, String> paramMap)
    throws IOException, zza
  {
    zzar localzzar = zza(paramzzr, paramMap);
    BasicHttpResponse localBasicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), localzzar.getStatusCode(), ""));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localzzar.zzq().iterator();
    while (localIterator.hasNext())
    {
      zzl localzzl = (zzl)localIterator.next();
      localArrayList.add(new BasicHeader(localzzl.getName(), localzzl.getValue()));
    }
    localBasicHttpResponse.setHeaders((Header[])localArrayList.toArray(new Header[localArrayList.size()]));
    InputStream localInputStream = localzzar.getContent();
    if (localInputStream != null)
    {
      BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
      localBasicHttpEntity.setContent(localInputStream);
      localBasicHttpEntity.setContentLength(localzzar.getContentLength());
      localBasicHttpResponse.setEntity(localBasicHttpEntity);
    }
    return localBasicHttpResponse;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaj
 * JD-Core Version:    0.6.2
 */