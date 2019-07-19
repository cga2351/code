package org.greenrobot.eventbus.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExceptionToResourceMapping
{
  public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap();

  public ExceptionToResourceMapping addMapping(Class<? extends Throwable> paramClass, int paramInt)
  {
    this.throwableToMsgIdMap.put(paramClass, Integer.valueOf(paramInt));
    return this;
  }

  public Integer mapThrowable(Throwable paramThrowable)
  {
    int i = 20;
    Throwable localThrowable = paramThrowable;
    do
    {
      Integer localInteger = mapThrowableFlat(localThrowable);
      if (localInteger != null)
        return localInteger;
      localThrowable = localThrowable.getCause();
      i--;
    }
    while ((i > 0) && (localThrowable != paramThrowable) && (localThrowable != null));
    Log.d("EventBus", "No specific message resource ID found for " + paramThrowable);
    return null;
  }

  protected Integer mapThrowableFlat(Throwable paramThrowable)
  {
    Class localClass = paramThrowable.getClass();
    Integer localInteger = (Integer)this.throwableToMsgIdMap.get(localClass);
    Object localObject2;
    Object localObject1;
    Map.Entry localEntry;
    Object localObject3;
    if (localInteger == null)
    {
      localObject2 = null;
      Iterator localIterator = this.throwableToMsgIdMap.entrySet().iterator();
      localObject1 = localInteger;
      if (!localIterator.hasNext())
        break label129;
      localEntry = (Map.Entry)localIterator.next();
      localObject3 = (Class)localEntry.getKey();
      if ((!((Class)localObject3).isAssignableFrom(localClass)) || ((localObject2 != null) && (!localObject2.isAssignableFrom((Class)localObject3))))
        break label132;
    }
    for (Object localObject4 = (Integer)localEntry.getValue(); ; localObject4 = localObject1)
    {
      localObject2 = localObject3;
      localObject1 = localObject4;
      break;
      localObject1 = localInteger;
      label129: return localObject1;
      label132: localObject3 = localObject2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.util.ExceptionToResourceMapping
 * JD-Core Version:    0.6.2
 */