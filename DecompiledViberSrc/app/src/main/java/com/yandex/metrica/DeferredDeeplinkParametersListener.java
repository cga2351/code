package com.yandex.metrica;

import java.util.Map;

public abstract interface DeferredDeeplinkParametersListener
{
  public abstract void onError(Error paramError, String paramString);

  public abstract void onParametersLoaded(Map<String, String> paramMap);

  public static enum Error
  {
    private final String mDescription;

    static
    {
      Error[] arrayOfError = new Error[2];
      arrayOfError[0] = NOT_A_FIRST_LAUNCH;
      arrayOfError[1] = PARSE_ERROR;
    }

    private Error(String paramString)
    {
      this.mDescription = paramString;
    }

    public String getDescription()
    {
      return this.mDescription;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.DeferredDeeplinkParametersListener
 * JD-Core Version:    0.6.2
 */