package twitter4j.internal.async;

public abstract interface Dispatcher
{
  public abstract void invokeLater(Runnable paramRunnable);

  public abstract void shutdown();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.async.Dispatcher
 * JD-Core Version:    0.6.2
 */