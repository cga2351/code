package com.iab.omid.library.appnexus.adsession;

import com.iab.omid.library.appnexus.d.b;
import com.iab.omid.library.appnexus.d.e;
import org.json.JSONObject;

public class AdSessionConfiguration
{
  private final Owner a;
  private final Owner b;
  private final boolean c;

  private AdSessionConfiguration(Owner paramOwner1, Owner paramOwner2, boolean paramBoolean)
  {
    this.a = paramOwner1;
    if (paramOwner2 == null);
    for (this.b = Owner.NONE; ; this.b = paramOwner2)
    {
      this.c = paramBoolean;
      return;
    }
  }

  @Deprecated
  public static AdSessionConfiguration createAdSessionConfiguration(Owner paramOwner1, Owner paramOwner2)
  {
    return createAdSessionConfiguration(paramOwner1, paramOwner2, true);
  }

  public static AdSessionConfiguration createAdSessionConfiguration(Owner paramOwner1, Owner paramOwner2, boolean paramBoolean)
  {
    e.a(paramOwner1, "Impression owner is null");
    e.a(paramOwner1);
    return new AdSessionConfiguration(paramOwner1, paramOwner2, paramBoolean);
  }

  public boolean isNativeImpressionOwner()
  {
    return Owner.NATIVE == this.a;
  }

  public boolean isNativeVideoEventsOwner()
  {
    return Owner.NATIVE == this.b;
  }

  public JSONObject toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    b.a(localJSONObject, "impressionOwner", this.a);
    b.a(localJSONObject, "videoEventsOwner", this.b);
    b.a(localJSONObject, "isolateVerificationScripts", Boolean.valueOf(this.c));
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.AdSessionConfiguration
 * JD-Core Version:    0.6.2
 */