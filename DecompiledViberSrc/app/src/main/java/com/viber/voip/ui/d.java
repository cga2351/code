package com.viber.voip.ui;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class d
{
  private final Set<a> mCallbacks = Collections.newSetFromMap(new WeakHashMap());

  private a[] copyCallbacks()
  {
    synchronized (this.mCallbacks)
    {
      a[] arrayOfa = (a[])this.mCallbacks.toArray(new a[this.mCallbacks.size()]);
      return arrayOfa;
    }
  }

  private boolean hasCallback(a parama)
  {
    if (parama == null)
      return false;
    synchronized (this.mCallbacks)
    {
      boolean bool = this.mCallbacks.contains(parama);
      return bool;
    }
  }

  public abstract void hideAlertWindow();

  public boolean isAlertWindowPendingVisible()
  {
    return isAlertWindowVisible();
  }

  public abstract boolean isAlertWindowVisible();

  protected final void notifyOnClick()
  {
    for (a locala : copyCallbacks())
      if (hasCallback(locala))
        locala.c();
  }

  protected final void notifyOnVisibilityChanged(boolean paramBoolean)
  {
    a[] arrayOfa = copyCallbacks();
    int i = arrayOfa.length;
    int j = 0;
    if (j < i)
    {
      a locala = arrayOfa[j];
      if (hasCallback(locala))
      {
        if (!paramBoolean)
          break label49;
        locala.a();
      }
      while (true)
      {
        j++;
        break;
        label49: locala.b();
      }
    }
  }

  public final void registerCallback(a parama)
  {
    synchronized (this.mCallbacks)
    {
      this.mCallbacks.add(parama);
      return;
    }
  }

  public abstract void showAlertWindow();

  public final void unregisterCallback(a parama)
  {
    synchronized (this.mCallbacks)
    {
      this.mCallbacks.remove(parama);
      return;
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.d
 * JD-Core Version:    0.6.2
 */