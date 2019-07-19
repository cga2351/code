package com.vk.sdk.api.methods;

import com.vk.sdk.api.VKRequest;

public class VKApiCaptcha extends VKApiBase
{
  public VKRequest force()
  {
    return prepareRequest("force", null);
  }

  protected String getMethodsGroup()
  {
    return "captcha";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.methods.VKApiCaptcha
 * JD-Core Version:    0.6.2
 */