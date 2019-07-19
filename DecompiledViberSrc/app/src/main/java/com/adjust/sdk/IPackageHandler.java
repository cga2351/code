package com.adjust.sdk;

import android.content.Context;

public abstract interface IPackageHandler
{
  public abstract void addPackage(ActivityPackage paramActivityPackage);

  public abstract void closeFirstPackage(ResponseData paramResponseData, ActivityPackage paramActivityPackage);

  public abstract void flush();

  public abstract String getBasePath();

  public abstract String getGdprPath();

  public abstract void init(IActivityHandler paramIActivityHandler, Context paramContext, boolean paramBoolean);

  public abstract void pauseSending();

  public abstract void resumeSending();

  public abstract void sendFirstPackage();

  public abstract void sendNextPackage(ResponseData paramResponseData);

  public abstract void teardown();

  public abstract void updatePackages(SessionParameters paramSessionParameters);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.IPackageHandler
 * JD-Core Version:    0.6.2
 */