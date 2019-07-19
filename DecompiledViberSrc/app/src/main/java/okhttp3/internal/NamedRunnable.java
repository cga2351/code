package okhttp3.internal;

public abstract class NamedRunnable
  implements Runnable
{
  protected final String name;

  public NamedRunnable(String paramString, Object[] paramArrayOfObject)
  {
    this.name = Util.format(paramString, paramArrayOfObject);
  }

  protected abstract void execute();

  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.name);
    try
    {
      execute();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.NamedRunnable
 * JD-Core Version:    0.6.2
 */