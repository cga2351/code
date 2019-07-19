package com.yandex.metrica;

public abstract interface AppMetricaDeviceIDListener
{
  public abstract void onError(Reason paramReason);

  public abstract void onLoaded(String paramString);

  public static enum Reason
  {
    static
    {
      NETWORK = new Reason("NETWORK", 1);
      INVALID_RESPONSE = new Reason("INVALID_RESPONSE", 2);
      Reason[] arrayOfReason = new Reason[3];
      arrayOfReason[0] = UNKNOWN;
      arrayOfReason[1] = NETWORK;
      arrayOfReason[2] = INVALID_RESPONSE;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.AppMetricaDeviceIDListener
 * JD-Core Version:    0.6.2
 */