package com.viber.jni.im2;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.ControllerListener;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.HashSet;

abstract class Im2DispatcherBase
{
  private static final Logger L = ViberEnv.getLogger();
  protected HashMap<Class<? extends Im2ReceiverBase>, DelegateRegistrator> mReceiverToRegistratorMap = new HashMap();
  protected HashMap<Class<? extends Im2ReceiverBase>, DelegateRegistrator[]> mRegistratorMap = new HashMap();

  private void findRegistrators(Class<?> paramClass, HashSet<DelegateRegistrator> paramHashSet)
  {
    Class[] arrayOfClass = paramClass.getInterfaces();
    int i = arrayOfClass.length;
    int j = 0;
    if (j < i)
    {
      Class localClass2 = arrayOfClass[j];
      if (localClass2 == Im2ReceiverBase.class)
      {
        DelegateRegistrator localDelegateRegistrator = (DelegateRegistrator)this.mReceiverToRegistratorMap.get(paramClass);
        L.b("  " + paramClass, new Object[0]);
        if (localDelegateRegistrator == null)
          throw new RuntimeException("Registrator not found for delegate class " + paramClass);
        paramHashSet.add(localDelegateRegistrator);
      }
      while (true)
      {
        j++;
        break;
        findRegistrators(localClass2, paramHashSet);
      }
    }
    Class localClass1 = paramClass.getSuperclass();
    if ((localClass1 != null) && (localClass1 != Object.class))
      findRegistrators(localClass1, paramHashSet);
  }

  private DelegateRegistrator[] getRegistrators(Class<? extends Im2ReceiverBase> paramClass)
  {
    DelegateRegistrator[] arrayOfDelegateRegistrator1 = (DelegateRegistrator[])this.mRegistratorMap.get(paramClass);
    if (arrayOfDelegateRegistrator1 == null)
    {
      if (paramClass == Im2ReceiverBase.class)
        throw new IllegalArgumentException("Registering Im2ReceiverBase is prohibited");
      DelegateRegistrator[] arrayOfDelegateRegistrator2;
      try
      {
        L.b("Registrators for " + paramClass + " not cached, searching...", new Object[0]);
        HashSet localHashSet = new HashSet();
        findRegistrators(paramClass, localHashSet);
        arrayOfDelegateRegistrator2 = (DelegateRegistrator[])localHashSet.toArray(new DelegateRegistrator[localHashSet.size()]);
        if (arrayOfDelegateRegistrator2.length == 0)
          throw new IllegalStateException("No registrators found for " + paramClass);
      }
      finally
      {
      }
      this.mRegistratorMap.put(paramClass, arrayOfDelegateRegistrator2);
      return arrayOfDelegateRegistrator2;
    }
    L.b("Found cached registrators for " + paramClass, new Object[0]);
    return arrayOfDelegateRegistrator1;
  }

  public void registerDelegate(Im2ReceiverBase paramIm2ReceiverBase, Handler paramHandler)
  {
    DelegateRegistrator[] arrayOfDelegateRegistrator = getRegistrators(paramIm2ReceiverBase.getClass());
    int i = arrayOfDelegateRegistrator.length;
    for (int j = 0; j < i; j++)
      arrayOfDelegateRegistrator[j].reg(paramIm2ReceiverBase, paramHandler);
  }

  public void registerDelegate(Im2ReceiverBase[] paramArrayOfIm2ReceiverBase)
  {
    int i = paramArrayOfIm2ReceiverBase.length;
    for (int j = 0; j < i; j++)
    {
      Im2ReceiverBase localIm2ReceiverBase = paramArrayOfIm2ReceiverBase[j];
      DelegateRegistrator[] arrayOfDelegateRegistrator = getRegistrators(localIm2ReceiverBase.getClass());
      int k = arrayOfDelegateRegistrator.length;
      for (int m = 0; m < k; m++)
        arrayOfDelegateRegistrator[m].reg(localIm2ReceiverBase);
    }
  }

  public void removeDelegate(Im2ReceiverBase paramIm2ReceiverBase)
  {
    DelegateRegistrator[] arrayOfDelegateRegistrator = getRegistrators(paramIm2ReceiverBase.getClass());
    int i = arrayOfDelegateRegistrator.length;
    for (int j = 0; j < i; j++)
      arrayOfDelegateRegistrator[j].unreg(paramIm2ReceiverBase);
  }

  private static abstract interface DelegateRegistrator
  {
    public abstract void reg(Im2ReceiverBase paramIm2ReceiverBase);

    public abstract void reg(Im2ReceiverBase paramIm2ReceiverBase, Handler paramHandler);

    public abstract void unreg(Im2ReceiverBase paramIm2ReceiverBase);
  }

  protected static class DispatcherBase<D> extends ControllerListener<D>
    implements Im2DispatcherBase.DelegateRegistrator
  {
    public void reg(Im2ReceiverBase paramIm2ReceiverBase)
    {
      registerDelegate(new Object[] { paramIm2ReceiverBase });
    }

    public void reg(Im2ReceiverBase paramIm2ReceiverBase, Handler paramHandler)
    {
      registerDelegate(paramIm2ReceiverBase, paramHandler);
    }

    public void unreg(Im2ReceiverBase paramIm2ReceiverBase)
    {
      removeDelegate(paramIm2ReceiverBase);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Im2DispatcherBase
 * JD-Core Version:    0.6.2
 */