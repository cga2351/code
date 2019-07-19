package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

final class g extends ScheduledThreadPoolExecutor
{
  private g()
  {
    super(1, new ThreadPoolExecutor.DiscardPolicy());
  }

  static g a()
  {
    return a.a();
  }

  private static final class a
  {
    private static final g a = new g(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.g
 * JD-Core Version:    0.6.2
 */