package com.mopub.network;

import android.net.Uri;
import com.mopub.common.ClientMetadata;
import com.mopub.common.MoPub;
import com.mopub.common.privacy.AdvertisingId;
import com.mopub.common.privacy.MoPubIdentifier;
import com.mopub.volley.toolbox.HurlStack.UrlRewriter;

public class PlayServicesUrlRewriter
  implements HurlStack.UrlRewriter
{
  public static final String DO_NOT_TRACK_TEMPLATE = "mp_tmpl_do_not_track";
  public static final String UDID_TEMPLATE = "mp_tmpl_advertising_id";

  public String rewriteUrl(String paramString)
  {
    if ((!paramString.contains("mp_tmpl_advertising_id")) && (!paramString.contains("mp_tmpl_do_not_track")));
    ClientMetadata localClientMetadata;
    do
    {
      return paramString;
      localClientMetadata = ClientMetadata.getInstance();
    }
    while (localClientMetadata == null);
    AdvertisingId localAdvertisingId = localClientMetadata.getMoPubIdentifier().getAdvertisingInfo();
    String str1 = paramString.replace("mp_tmpl_advertising_id", Uri.encode(localAdvertisingId.getIdWithPrefix(MoPub.canCollectPersonalInformation())));
    if (localAdvertisingId.isDoNotTrack());
    for (String str2 = "1"; ; str2 = "0")
      return str1.replace("mp_tmpl_do_not_track", str2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.PlayServicesUrlRewriter
 * JD-Core Version:    0.6.2
 */