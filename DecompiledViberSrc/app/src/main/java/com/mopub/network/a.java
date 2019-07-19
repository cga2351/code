package com.mopub.network;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.MoPubError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class a
{
  Long a = null;
  private AdResponse b;

  a(AdResponse paramAdResponse)
  {
    Preconditions.checkNotNull(paramAdResponse);
    this.b = paramAdResponse;
  }

  private a a(MoPubError paramMoPubError)
  {
    if (paramMoPubError == null)
      return a.AD_LOADED;
    switch (paramMoPubError.getIntCode())
    {
    default:
      return a.INVALID_DATA;
    case 0:
      return a.AD_LOADED;
    case 2:
      return a.TIMEOUT;
    case 1:
    }
    return a.MISSING_ADAPTER;
  }

  private List<String> a(List<String> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.a == null))
      return null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((String)localIterator.next()).replace("%%LOAD_DURATION_MS%%", String.valueOf(SystemClock.uptimeMillis() - this.a.longValue())).replace("%%LOAD_RESULT%%", Uri.encode(paramString)));
    return localArrayList;
  }

  void a(Context paramContext)
  {
    if (paramContext == null);
    String str;
    do
    {
      return;
      str = this.b.getBeforeLoadUrl();
    }
    while (TextUtils.isEmpty(str));
    this.a = Long.valueOf(SystemClock.uptimeMillis());
    TrackingRequest.makeTrackingHttpRequest(str, paramContext);
  }

  void a(Context paramContext, MoPubError paramMoPubError)
  {
    if ((paramContext == null) || (this.a == null))
      return;
    a locala = a(paramMoPubError);
    TrackingRequest.makeTrackingHttpRequest(a(this.b.getAfterLoadUrls(), a.a(locala)), paramContext);
  }

  void b(Context paramContext)
  {
    if ((paramContext == null) || (this.a == null))
      return;
    TrackingRequest.makeTrackingHttpRequest(a(this.b.getAfterLoadSuccessUrls(), a.a(a.AD_LOADED)), paramContext);
  }

  void b(Context paramContext, MoPubError paramMoPubError)
  {
    if ((paramContext == null) || (this.a == null))
      return;
    a locala = a(paramMoPubError);
    TrackingRequest.makeTrackingHttpRequest(a(this.b.getAfterLoadFailUrls(), a.a(locala)), paramContext);
  }

  static enum a
  {
    private final String a;

    static
    {
      INVALID_DATA = new a("INVALID_DATA", 3, "invalid_data");
      a[] arrayOfa = new a[4];
      arrayOfa[0] = AD_LOADED;
      arrayOfa[1] = MISSING_ADAPTER;
      arrayOfa[2] = TIMEOUT;
      arrayOfa[3] = INVALID_DATA;
    }

    private a(String paramString)
    {
      this.a = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.a
 * JD-Core Version:    0.6.2
 */