package com.adjust.sdk;

public abstract interface IAttributionHandler
{
  public abstract void checkSdkClickResponse(SdkClickResponseData paramSdkClickResponseData);

  public abstract void checkSessionResponse(SessionResponseData paramSessionResponseData);

  public abstract void getAttribution();

  public abstract void init(IActivityHandler paramIActivityHandler, ActivityPackage paramActivityPackage, boolean paramBoolean);

  public abstract void pauseSending();

  public abstract void resumeSending();

  public abstract void teardown();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.IAttributionHandler
 * JD-Core Version:    0.6.2
 */