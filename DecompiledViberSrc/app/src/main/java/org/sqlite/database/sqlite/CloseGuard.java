package org.sqlite.database.sqlite;

import android.util.Log;

public final class CloseGuard
{
  private static volatile boolean ENABLED = true;
  private static final CloseGuard NOOP = new CloseGuard();
  private static volatile Reporter REPORTER = new DefaultReporter(null);
  private Throwable allocationSite;

  public static CloseGuard get()
  {
    if (!ENABLED)
      return NOOP;
    return new CloseGuard();
  }

  public static Reporter getReporter()
  {
    return REPORTER;
  }

  public static void setEnabled(boolean paramBoolean)
  {
    ENABLED = paramBoolean;
  }

  public static void setReporter(Reporter paramReporter)
  {
    if (paramReporter == null)
      throw new NullPointerException("reporter == null");
    REPORTER = paramReporter;
  }

  public void close()
  {
    this.allocationSite = null;
  }

  public void open(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("closer == null");
    if ((this == NOOP) || (!ENABLED))
      return;
    this.allocationSite = new Throwable("Explicit termination method '" + paramString + "' not called");
  }

  public void warnIfOpen()
  {
    if ((this.allocationSite == null) || (!ENABLED))
      return;
    REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
  }

  private static final class DefaultReporter
    implements CloseGuard.Reporter
  {
    public void report(String paramString, Throwable paramThrowable)
    {
      Log.w(paramString, paramThrowable);
    }
  }

  public static abstract interface Reporter
  {
    public abstract void report(String paramString, Throwable paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.CloseGuard
 * JD-Core Version:    0.6.2
 */