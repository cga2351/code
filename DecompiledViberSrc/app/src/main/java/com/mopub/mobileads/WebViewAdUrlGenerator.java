package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.ExternalViewabilitySessionManager.ViewabilityVendor;

public class WebViewAdUrlGenerator extends AdUrlGenerator
{
  private final boolean f;

  public WebViewAdUrlGenerator(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.f = paramBoolean;
  }

  public String generateUrlString(String paramString)
  {
    a(paramString, "/m/ad");
    m("6");
    a(ClientMetadata.getInstance(this.a));
    a(true);
    b(this.f);
    l(ExternalViewabilitySessionManager.ViewabilityVendor.getEnabledVendorKey());
    return g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.WebViewAdUrlGenerator
 * JD-Core Version:    0.6.2
 */