package com.adjust.sdk;

public abstract interface ISdkClickHandler
{
  public abstract void init(IActivityHandler paramIActivityHandler, boolean paramBoolean);

  public abstract void pauseSending();

  public abstract void resumeSending();

  public abstract void sendReftagReferrers();

  public abstract void sendSdkClick(ActivityPackage paramActivityPackage);

  public abstract void teardown();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ISdkClickHandler
 * JD-Core Version:    0.6.2
 */