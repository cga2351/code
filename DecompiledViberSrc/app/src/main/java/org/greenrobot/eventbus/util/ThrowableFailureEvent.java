package org.greenrobot.eventbus.util;

public class ThrowableFailureEvent
  implements HasExecutionScope
{
  private Object executionContext;
  protected final boolean suppressErrorUi;
  protected final Throwable throwable;

  public ThrowableFailureEvent(Throwable paramThrowable)
  {
    this.throwable = paramThrowable;
    this.suppressErrorUi = false;
  }

  public ThrowableFailureEvent(Throwable paramThrowable, boolean paramBoolean)
  {
    this.throwable = paramThrowable;
    this.suppressErrorUi = paramBoolean;
  }

  public Object getExecutionScope()
  {
    return this.executionContext;
  }

  public Throwable getThrowable()
  {
    return this.throwable;
  }

  public boolean isSuppressErrorUi()
  {
    return this.suppressErrorUi;
  }

  public void setExecutionScope(Object paramObject)
  {
    this.executionContext = paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.util.ThrowableFailureEvent
 * JD-Core Version:    0.6.2
 */