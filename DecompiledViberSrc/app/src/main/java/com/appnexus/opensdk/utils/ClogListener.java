package com.appnexus.opensdk.utils;

public abstract class ClogListener
{
  public abstract LOG_LEVEL getLogLevel();

  public abstract void onReceiveMessage(LOG_LEVEL paramLOG_LEVEL, String paramString1, String paramString2);

  public abstract void onReceiveMessage(LOG_LEVEL paramLOG_LEVEL, String paramString1, String paramString2, Throwable paramThrowable);

  public static enum LOG_LEVEL
  {
    static
    {
      D = new LOG_LEVEL("D", 1);
      I = new LOG_LEVEL("I", 2);
      W = new LOG_LEVEL("W", 3);
      E = new LOG_LEVEL("E", 4);
      LOG_LEVEL[] arrayOfLOG_LEVEL = new LOG_LEVEL[5];
      arrayOfLOG_LEVEL[0] = V;
      arrayOfLOG_LEVEL[1] = D;
      arrayOfLOG_LEVEL[2] = I;
      arrayOfLOG_LEVEL[3] = W;
      arrayOfLOG_LEVEL[4] = E;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.ClogListener
 * JD-Core Version:    0.6.2
 */