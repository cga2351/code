package com.crashlytics.android.c;

class aw
{
  public final String a;
  public final String b;
  public final StackTraceElement[] c;
  public final aw d;

  public aw(Throwable paramThrowable, av paramav)
  {
    this.a = paramThrowable.getLocalizedMessage();
    this.b = paramThrowable.getClass().getName();
    this.c = paramav.a(paramThrowable.getStackTrace());
    Throwable localThrowable = paramThrowable.getCause();
    if (localThrowable != null);
    for (aw localaw = new aw(localThrowable, paramav); ; localaw = null)
    {
      this.d = localaw;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.aw
 * JD-Core Version:    0.6.2
 */