package com.viber.voip.t;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;

public final class a
  implements Logger
{
  public String a()
  {
    return "releaseLog";
  }

  public void a(String paramString, Object[] paramArrayOfObject)
  {
  }

  public void a(Throwable paramThrowable, String paramString)
  {
    ViberApplication.getInstance().logToCrashlytics(paramString);
    ViberApplication.getInstance().logToCrashlytics(paramThrowable);
  }

  public void a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
  }

  public void b(String paramString, Object[] paramArrayOfObject)
  {
  }

  public void b(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
  }

  public void c(String paramString, Object[] paramArrayOfObject)
  {
  }

  public void d(String paramString, Object[] paramArrayOfObject)
  {
  }

  public void e(String paramString, Object[] paramArrayOfObject)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.t.a
 * JD-Core Version:    0.6.2
 */