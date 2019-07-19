package com.vk.sdk;

import com.vk.sdk.api.VKError;

public abstract interface VKCallback<RESULT>
{
  public abstract void onError(VKError paramVKError);

  public abstract void onResult(RESULT paramRESULT);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.VKCallback
 * JD-Core Version:    0.6.2
 */