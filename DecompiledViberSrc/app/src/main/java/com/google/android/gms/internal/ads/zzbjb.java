package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzbjb
{
  private final String method;
  public final Uri uri;
  public final String url;
  public final Map<String, String> zzab;

  @TargetApi(21)
  public zzbjb(WebResourceRequest paramWebResourceRequest)
  {
    this(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.getUrl(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
  }

  public zzbjb(String paramString)
  {
    this(paramString, Uri.parse(paramString), null, null);
  }

  private zzbjb(String paramString1, Uri paramUri, @Nullable String paramString2, @Nullable Map<String, String> paramMap)
  {
    this.url = paramString1;
    this.uri = paramUri;
    if (paramString2 == null)
      paramString2 = "GET";
    this.method = paramString2;
    if (paramMap == null)
      paramMap = Collections.emptyMap();
    this.zzab = paramMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbjb
 * JD-Core Version:    0.6.2
 */