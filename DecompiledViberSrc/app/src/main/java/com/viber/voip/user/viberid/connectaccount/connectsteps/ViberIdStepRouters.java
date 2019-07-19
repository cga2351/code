package com.viber.voip.user.viberid.connectaccount.connectsteps;

public abstract interface ViberIdStepRouters
{
  public static abstract interface ViberIdBaseStepRouter
  {
    public abstract void closeViberIdConnect();

    public abstract void openEditInfo();
  }

  public static abstract interface ViberIdEmailStepRouter extends ViberIdStepRouters.ViberIdBaseStepRouter
  {
    public abstract void showEnterPasswordStep(String paramString, boolean paramBoolean);

    public abstract void showSetPasswordStep(String paramString, boolean paramBoolean);
  }

  public static abstract interface ViberIdPasswordStepRouter extends ViberIdStepRouters.ViberIdBaseStepRouter
  {
    public abstract void showEmailStep(String paramString);
  }

  public static abstract interface ViberIdStepRouter extends ViberIdStepRouters.ViberIdBaseStepRouter, ViberIdStepRouters.ViberIdEmailStepRouter, ViberIdStepRouters.ViberIdPasswordStepRouter
  {
    public abstract void showEnterPasswordStep(String paramString1, boolean paramBoolean, String paramString2);

    public abstract void showSetPasswordStep(String paramString1, boolean paramBoolean, String paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.connectsteps.ViberIdStepRouters
 * JD-Core Version:    0.6.2
 */