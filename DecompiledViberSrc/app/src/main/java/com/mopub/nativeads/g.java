package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;

class g extends BaseUrlGenerator
{
  private final Context a;
  private String b;

  public g(Context paramContext)
  {
    this.a = paramContext;
  }

  private void a(String paramString)
  {
    b("id", paramString);
  }

  private void b(String paramString)
  {
    b("nv", paramString);
  }

  public String generateUrlString(String paramString)
  {
    a(paramString, "/m/pos");
    a(this.b);
    m("1");
    ClientMetadata localClientMetadata = ClientMetadata.getInstance(this.a);
    b(localClientMetadata.getSdkVersion());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = localClientMetadata.getDeviceManufacturer();
    arrayOfString[1] = localClientMetadata.getDeviceModel();
    arrayOfString[2] = localClientMetadata.getDeviceProduct();
    a(arrayOfString);
    n(localClientMetadata.getAppVersion());
    h();
    return g();
  }

  public g withAdUnitId(String paramString)
  {
    this.b = paramString;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.g
 * JD-Core Version:    0.6.2
 */