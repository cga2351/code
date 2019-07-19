package com.mopub.nativeads;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.MoPub;

class e extends AdUrlGenerator
{
  private String f;
  private String g;

  e(Context paramContext)
  {
    super(paramContext);
  }

  private void i()
  {
    if (!TextUtils.isEmpty(this.g))
      b("MAGIC_NO", this.g);
  }

  private void j()
  {
    if (!TextUtils.isEmpty(this.f))
      b("assets", this.f);
  }

  e a(int paramInt)
  {
    this.g = String.valueOf(paramInt);
    return this;
  }

  e a(RequestParameters paramRequestParameters)
  {
    boolean bool;
    if (paramRequestParameters != null)
    {
      bool = MoPub.canCollectPersonalInformation();
      if (!bool)
        break label59;
    }
    label59: for (String str = paramRequestParameters.getUserDataKeywords(); ; str = null)
    {
      this.d = str;
      Location localLocation = null;
      if (bool)
        localLocation = paramRequestParameters.getLocation();
      this.e = localLocation;
      this.c = paramRequestParameters.getKeywords();
      this.f = paramRequestParameters.getDesiredAssets();
      return this;
    }
  }

  public String generateUrlString(String paramString)
  {
    a(paramString, "/m/ad");
    a(ClientMetadata.getInstance(this.a));
    j();
    i();
    return g();
  }

  public e withAdUnitId(String paramString)
  {
    this.b = paramString;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.e
 * JD-Core Version:    0.6.2
 */