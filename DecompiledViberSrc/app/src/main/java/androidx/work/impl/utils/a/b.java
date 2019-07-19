package androidx.work.impl.utils.a;

import java.util.concurrent.Executor;

 enum b
  implements Executor
{
  static
  {
    b[] arrayOfb = new b[1];
    arrayOfb[0] = a;
  }

  public void execute(Runnable paramRunnable)
  {
    paramRunnable.run();
  }

  public String toString()
  {
    return "DirectExecutor";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.a.b
 * JD-Core Version:    0.6.2
 */