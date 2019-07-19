package com.adjust.sdk;

public abstract interface IRequestHandler
{
  public abstract void init(IActivityHandler paramIActivityHandler, IPackageHandler paramIPackageHandler);

  public abstract void sendPackage(ActivityPackage paramActivityPackage, int paramInt);

  public abstract void teardown();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.IRequestHandler
 * JD-Core Version:    0.6.2
 */