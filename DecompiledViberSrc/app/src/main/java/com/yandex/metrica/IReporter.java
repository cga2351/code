package com.yandex.metrica;

import com.yandex.metrica.a.a;
import java.util.Map;

public abstract interface IReporter
{
  public abstract void pauseSession();

  public abstract void reportError(String paramString, Throwable paramThrowable);

  public abstract void reportEvent(String paramString);

  public abstract void reportEvent(String paramString1, String paramString2);

  public abstract void reportEvent(String paramString, Map<String, Object> paramMap);

  public abstract void reportRevenue(Revenue paramRevenue);

  public abstract void reportUnhandledException(Throwable paramThrowable);

  public abstract void reportUserProfile(a parama);

  public abstract void resumeSession();

  public abstract void sendEventsBuffer();

  public abstract void setStatisticsSending(boolean paramBoolean);

  public abstract void setUserProfileID(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.IReporter
 * JD-Core Version:    0.6.2
 */