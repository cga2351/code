package com.viber.dexshared;

public abstract interface BillingHost
{
  public abstract Logger getBillingLogger(String paramString);

  public abstract String getInstallerPackageName();

  public abstract int getPreferredStoreIndex();

  public abstract String getRegNumberCanonized();

  public abstract String getResponseDesc(int paramInt);

  public abstract boolean isViberOutProduct(String paramString);

  public abstract void setIsViberOutProduct(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.dexshared.BillingHost
 * JD-Core Version:    0.6.2
 */