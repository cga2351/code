package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKParser;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiModel;
import java.util.Locale;

public abstract class VKApiBase
{
  protected abstract String getMethodsGroup();

  protected VKRequest prepareRequest(String paramString, VKParameters paramVKParameters)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = getMethodsGroup();
    arrayOfObject[1] = paramString;
    return new VKRequest(String.format(localLocale, "%s.%s", arrayOfObject), paramVKParameters, null);
  }

  protected VKRequest prepareRequest(String paramString, VKParameters paramVKParameters, VKParser paramVKParser)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = getMethodsGroup();
    arrayOfObject[1] = paramString;
    VKRequest localVKRequest = new VKRequest(String.format(localLocale, "%s.%s", arrayOfObject), paramVKParameters);
    localVKRequest.setResponseParser(paramVKParser);
    return localVKRequest;
  }

  protected VKRequest prepareRequest(String paramString, VKParameters paramVKParameters, Class<? extends VKApiModel> paramClass)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = getMethodsGroup();
    arrayOfObject[1] = paramString;
    return new VKRequest(String.format(localLocale, "%s.%s", arrayOfObject), paramVKParameters, paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiBase
 * JD-Core Version:    0.6.2
 */