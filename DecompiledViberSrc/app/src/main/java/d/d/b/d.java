package d.d.b;

import d.m;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d
{
  private static final Object[] a = new Object[0];

  @NotNull
  public static final Object[] a(@NotNull Collection<?> paramCollection)
  {
    h.b(paramCollection, "collection");
    int i = paramCollection.size();
    Object localObject1;
    if (i == 0)
      localObject1 = a;
    Iterator localIterator;
    int j;
    int k;
    do
    {
      return localObject1;
      localIterator = paramCollection.iterator();
      if (!localIterator.hasNext())
        return a;
      Object[] arrayOfObject1 = new Object[i];
      j = 0;
      localObject1 = arrayOfObject1;
      k = j + 1;
      localObject1[j] = localIterator.next();
      if (k < localObject1.length)
        break;
    }
    while (!localIterator.hasNext());
    int m = 1 + k * 3 >>> 1;
    if (m <= k)
    {
      if (k >= 2147483645)
        throw ((Throwable)new OutOfMemoryError());
      m = 2147483645;
    }
    Object localObject2 = Arrays.copyOf((Object[])localObject1, m);
    h.a(localObject2, "Arrays.copyOf(result, newSize)");
    while (true)
    {
      localObject1 = localObject2;
      j = k;
      break;
      if (!localIterator.hasNext())
      {
        Object[] arrayOfObject2 = Arrays.copyOf((Object[])localObject1, k);
        h.a(arrayOfObject2, "Arrays.copyOf(result, size)");
        return arrayOfObject2;
      }
      localObject2 = localObject1;
    }
  }

  @NotNull
  public static final Object[] a(@NotNull Collection<?> paramCollection, @Nullable Object[] paramArrayOfObject)
  {
    int i = 0;
    h.b(paramCollection, "collection");
    if (paramArrayOfObject == null)
      throw ((Throwable)new NullPointerException());
    int j = paramCollection.size();
    if (j == 0)
      if (paramArrayOfObject.length > 0)
        paramArrayOfObject[0] = null;
    Iterator localIterator;
    do
    {
      return paramArrayOfObject;
      localIterator = paramCollection.iterator();
      if (localIterator.hasNext())
        break;
    }
    while (paramArrayOfObject.length <= 0);
    paramArrayOfObject[0] = null;
    return paramArrayOfObject;
    if (j <= paramArrayOfObject.length)
      arrayOfObject1 = paramArrayOfObject;
    int k;
    while (true)
    {
      k = i + 1;
      arrayOfObject1[i] = localIterator.next();
      if (k < arrayOfObject1.length)
        break label221;
      if (localIterator.hasNext())
        break;
      return arrayOfObject1;
      localObject = Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
      if (localObject == null)
        throw new m("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      arrayOfObject1 = (Object[])localObject;
      i = 0;
    }
    m = 1 + k * 3 >>> 1;
    if (m <= k)
    {
      if (k >= 2147483645)
        throw ((Throwable)new OutOfMemoryError());
      m = 2147483645;
    }
    Object[] arrayOfObject1 = Arrays.copyOf(arrayOfObject1, m);
    h.a(arrayOfObject1, "Arrays.copyOf(result, newSize)");
    label221: 
    while (localIterator.hasNext())
    {
      Object localObject;
      int m;
      i = k;
      break;
    }
    if (arrayOfObject1 == paramArrayOfObject)
    {
      paramArrayOfObject[k] = null;
      return paramArrayOfObject;
    }
    Object[] arrayOfObject2 = Arrays.copyOf(arrayOfObject1, k);
    h.a(arrayOfObject2, "Arrays.copyOf(result, size)");
    return arrayOfObject2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.d
 * JD-Core Version:    0.6.2
 */