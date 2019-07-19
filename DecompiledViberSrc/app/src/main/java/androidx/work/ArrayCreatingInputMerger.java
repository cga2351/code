package androidx.work;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ArrayCreatingInputMerger extends h
{
  private Object a(Object paramObject)
  {
    Object localObject = Array.newInstance(paramObject.getClass(), 1);
    Array.set(localObject, 0, paramObject);
    return localObject;
  }

  private Object a(Object paramObject1, Object paramObject2)
  {
    int i = Array.getLength(paramObject1);
    int j = Array.getLength(paramObject2);
    Object localObject = Array.newInstance(paramObject1.getClass().getComponentType(), i + j);
    System.arraycopy(paramObject1, 0, localObject, 0, i);
    System.arraycopy(paramObject2, 0, localObject, i, j);
    return localObject;
  }

  private Object b(Object paramObject1, Object paramObject2)
  {
    Object localObject = Array.newInstance(paramObject1.getClass(), 2);
    Array.set(localObject, 0, paramObject1);
    Array.set(localObject, 1, paramObject2);
    return localObject;
  }

  private Object c(Object paramObject1, Object paramObject2)
  {
    int i = Array.getLength(paramObject1);
    Object localObject = Array.newInstance(paramObject2.getClass(), i + 1);
    System.arraycopy(paramObject1, 0, localObject, 0, i);
    Array.set(localObject, i, paramObject2);
    return localObject;
  }

  public e a(List<e> paramList)
  {
    e.a locala = new e.a();
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramList.iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((e)localIterator1.next()).a().entrySet().iterator();
      label59: String str;
      Object localObject1;
      Class localClass1;
      Object localObject2;
      if (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        str = (String)localEntry.getKey();
        localObject1 = localEntry.getValue();
        localClass1 = localObject1.getClass();
        localObject2 = localHashMap.get(str);
        if (localObject2 != null)
          break label157;
        if (!localClass1.isArray())
          break label146;
      }
      while (true)
      {
        localHashMap.put(str, localObject1);
        break label59;
        break;
        label146: localObject1 = a(localObject1);
        continue;
        label157: Class localClass2 = localObject2.getClass();
        if (localClass2.equals(localClass1))
        {
          if (localClass2.isArray())
            localObject1 = a(localObject2, localObject1);
          else
            localObject1 = b(localObject2, localObject1);
        }
        else if ((localClass2.isArray()) && (localClass2.getComponentType().equals(localClass1)))
        {
          localObject1 = c(localObject2, localObject1);
        }
        else
        {
          if ((!localClass1.isArray()) || (!localClass1.getComponentType().equals(localClass2)))
            break label276;
          localObject1 = c(localObject1, localObject2);
        }
      }
      label276: throw new IllegalArgumentException();
    }
    locala.a(localHashMap);
    return locala.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.ArrayCreatingInputMerger
 * JD-Core Version:    0.6.2
 */