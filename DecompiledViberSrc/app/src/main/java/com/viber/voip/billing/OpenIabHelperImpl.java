package com.viber.voip.billing;

import com.viber.dexshared.OpenIabHelper;

public class OpenIabHelperImpl
  implements OpenIabHelper
{
  public String getDefaultProvider()
  {
    return OpenIabHelperWrapper.getPreferredProvider();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.OpenIabHelperImpl
 * JD-Core Version:    0.6.2
 */