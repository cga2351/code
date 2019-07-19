package com.viber.a;

import com.viber.a.a.b;
import com.viber.voip.ViberApplication;
import java.io.PrintWriter;
import java.io.StringWriter;

public class a
  implements Thread.UncaughtExceptionHandler
{
  private static a b;
  private Thread.UncaughtExceptionHandler a;

  public static a a()
  {
    if (b == null)
      b = new a();
    return b;
  }

  public void a(String paramString, int paramInt)
  {
    if (-123 != paramInt)
    {
      RuntimeException localRuntimeException = new RuntimeException("crashed here (native trace should follow after the Java trace)");
      localRuntimeException.printStackTrace();
      StringWriter localStringWriter = new StringWriter();
      localRuntimeException.printStackTrace(new PrintWriter(localStringWriter));
      String str1 = localStringWriter.toString();
      String str2 = str1 + paramString;
      c().a(str2);
      ViberApplication.getInstance().logToCrashlytics(localRuntimeException);
    }
  }

  public void b()
  {
    this.a = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
    b.a().a(ViberApplication.getApplication());
  }

  public b c()
  {
    return b.a();
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    b.a().a(paramThread, paramThrowable);
    this.a.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.a.a
 * JD-Core Version:    0.6.2
 */