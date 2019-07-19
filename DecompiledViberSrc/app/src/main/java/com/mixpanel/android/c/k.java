package com.mixpanel.android.c;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class k<T>
{
  private Set<T> a = new HashSet();

  public Set<T> a()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
      throw new RuntimeException("Can't remove an activity when not on the UI thread");
    return Collections.unmodifiableSet(this.a);
  }

  public void a(T paramT)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
      throw new RuntimeException("Can't remove an activity when not on the UI thread");
    this.a.remove(paramT);
  }

  public void b(T paramT)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
      throw new RuntimeException("Can't add an activity when not on the UI thread");
    this.a.add(paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.k
 * JD-Core Version:    0.6.2
 */