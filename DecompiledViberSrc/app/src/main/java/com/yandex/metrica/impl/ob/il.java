package com.yandex.metrica.impl.ob;

import java.util.concurrent.Executor;

public class il
  implements Executor
{
  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable != null)
      paramRunnable.run();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.il
 * JD-Core Version:    0.6.2
 */