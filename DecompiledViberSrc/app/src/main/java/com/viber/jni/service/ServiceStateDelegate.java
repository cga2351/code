package com.viber.jni.service;

public abstract interface ServiceStateDelegate
{
  public abstract void onServiceStateChanged(int paramInt);

  public static enum ServiceState
  {
    static
    {
      NO_INTERNET = new ServiceState("NO_INTERNET", 2);
      CONNECTING = new ServiceState("CONNECTING", 3);
      ServiceState[] arrayOfServiceState = new ServiceState[4];
      arrayOfServiceState[0] = SERVICE_CONNECTED;
      arrayOfServiceState[1] = SERVICE_NOT_CONNECTED;
      arrayOfServiceState[2] = NO_INTERNET;
      arrayOfServiceState[3] = CONNECTING;
    }

    public static ServiceState resolveEnum(int paramInt)
    {
      return values()[paramInt];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.service.ServiceStateDelegate
 * JD-Core Version:    0.6.2
 */