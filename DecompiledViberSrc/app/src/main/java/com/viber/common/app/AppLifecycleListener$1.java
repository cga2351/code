package com.viber.common.app;

import android.arch.lifecycle.e.a;
import android.arch.lifecycle.g;
import android.arch.lifecycle.o;
import java.util.Iterator;
import java.util.List;

class AppLifecycleListener$1
  implements g
{
  AppLifecycleListener$1(c paramc)
  {
  }

  private void a(List<c.a> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      ((c.a)localIterator.next()).onForegroundStateChanged(c.a(this.a));
  }

  @o(a=e.a.ON_PAUSE)
  public void onPause()
  {
    c.a(this.a, false);
    boolean bool = c.a(this.a);
    if (bool)
      c.b(this.a, false);
    List localList = c.b(this.a);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      ((c.a)localIterator.next()).onBackground();
    if (bool)
      a(localList);
  }

  @o(a=e.a.ON_RESUME)
  public void onResume()
  {
    c.a(this.a, false);
    boolean bool = c.a(this.a);
    int i = 0;
    if (!bool)
      i = 1;
    if (i != 0)
      c.b(this.a, true);
    List localList = c.b(this.a);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      ((c.a)localIterator.next()).onForeground();
    if (i != 0)
      a(localList);
  }

  @o(a=e.a.ON_STOP)
  public void onStop()
  {
    c.a(this.a, true);
    Iterator localIterator = c.b(this.a).iterator();
    while (localIterator.hasNext())
      ((c.a)localIterator.next()).onAppStopped();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.app.AppLifecycleListener.1
 * JD-Core Version:    0.6.2
 */