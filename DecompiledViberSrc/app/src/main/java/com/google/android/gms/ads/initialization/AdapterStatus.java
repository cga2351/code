package com.google.android.gms.ads.initialization;

public abstract interface AdapterStatus
{
  public abstract String getDescription();

  public abstract State getInitializationState();

  public abstract int getLatency();

  public static enum State
  {
    static
    {
      State[] arrayOfState = new State[2];
      arrayOfState[0] = NOT_READY;
      arrayOfState[1] = READY;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.initialization.AdapterStatus
 * JD-Core Version:    0.6.2
 */