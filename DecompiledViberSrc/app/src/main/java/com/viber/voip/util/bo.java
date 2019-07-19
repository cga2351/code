package com.viber.voip.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class bo<L, P>
{
  private final P VOID_PARAMS = null;
  private final Set<L> mListeners = Collections.newSetFromMap(new WeakHashMap());
  private final a<L, P> mNotificationHook;
  private final b<L, P> mRegistrationHook;

  public bo(a<L, P> parama)
  {
    this.mRegistrationHook = null;
    this.mNotificationHook = parama;
  }

  public bo(b<L, P> paramb, a<L, P> parama)
  {
    this.mRegistrationHook = paramb;
    this.mNotificationHook = parama;
  }

  private boolean hasListener(L paramL)
  {
    synchronized (this.mListeners)
    {
      boolean bool = this.mListeners.contains(paramL);
      return bool;
    }
  }

  public void notifyListeners()
  {
    notifyListeners(this.VOID_PARAMS);
  }

  public void notifyListeners(P paramP)
  {
    synchronized (this.mListeners)
    {
      ArrayList localArrayList = new ArrayList(this.mListeners);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 != null) && (hasListener(localObject2)))
          this.mNotificationHook.onNotify(this, localObject2, paramP);
      }
    }
  }

  public void registerListener(L paramL)
  {
    if (paramL == null);
    while (true)
    {
      return;
      synchronized (this.mListeners)
      {
        this.mListeners.add(paramL);
        if (this.mRegistrationHook == null)
          continue;
        this.mRegistrationHook.onRegister(this, paramL);
        return;
      }
    }
  }

  public void unregisterListener(L paramL)
  {
    if (paramL == null)
      return;
    synchronized (this.mListeners)
    {
      this.mListeners.remove(paramL);
      return;
    }
  }

  public static abstract interface a<L, P>
  {
    public abstract void onNotify(bo<L, P> parambo, L paramL, P paramP);
  }

  public static abstract interface b<L, P>
  {
    public abstract void onRegister(bo<L, P> parambo, L paramL);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bo
 * JD-Core Version:    0.6.2
 */