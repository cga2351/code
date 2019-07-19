package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.f;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras
  implements f
{
  private final HashMap<String, Object> zzeod = new HashMap();

  public final Object getExtra(String paramString)
  {
    return this.zzeod.get(paramString);
  }

  public final void setExtra(String paramString, Object paramObject)
  {
    this.zzeod.put(paramString, paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventExtras
 * JD-Core Version:    0.6.2
 */