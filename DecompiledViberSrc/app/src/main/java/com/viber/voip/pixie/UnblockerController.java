package com.viber.voip.pixie;

public abstract class UnblockerController
{
  public abstract void addListener(UnblockerControllerListener paramUnblockerControllerListener);

  public abstract void removeListener(UnblockerControllerListener paramUnblockerControllerListener);

  public abstract void updatePhoneNumber(String paramString);

  public static abstract interface UnblockerControllerListener
  {
    public abstract void onNetworkReadyToUse();

    public abstract void onUnblockerStatusUpdate(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.UnblockerController
 * JD-Core Version:    0.6.2
 */