package com.adjust.sdk;

import java.util.HashMap;
import java.util.Map;

public class SessionParameters
{
  Map<String, String> callbackParameters;
  Map<String, String> partnerParameters;

  public SessionParameters deepCopy()
  {
    SessionParameters localSessionParameters = new SessionParameters();
    if (this.callbackParameters != null)
      localSessionParameters.callbackParameters = new HashMap(this.callbackParameters);
    if (this.partnerParameters != null)
      localSessionParameters.partnerParameters = new HashMap(this.partnerParameters);
    return localSessionParameters;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    SessionParameters localSessionParameters;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localSessionParameters = (SessionParameters)paramObject;
      if (!Util.equalObject(this.callbackParameters, localSessionParameters.callbackParameters))
        return false;
    }
    while (Util.equalObject(this.partnerParameters, localSessionParameters.partnerParameters));
    return false;
  }

  public int hashCode()
  {
    return 37 * (629 + Util.hashObject(this.callbackParameters)) + Util.hashObject(this.partnerParameters);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.SessionParameters
 * JD-Core Version:    0.6.2
 */