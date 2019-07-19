package dagger.android;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.a.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

public final class c<T>
  implements b<T>
{
  private final Map<Class<? extends T>, Provider<b.b<? extends T>>> a;

  @Inject
  c(Map<Class<? extends T>, Provider<b.b<? extends T>>> paramMap)
  {
    this.a = paramMap;
  }

  private String c(T paramT)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if (localClass.isInstance(paramT))
        localArrayList.add(localClass.getCanonicalName());
    }
    Collections.sort(localArrayList);
    if (localArrayList.isEmpty())
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramT.getClass().getCanonicalName();
      return String.format("No injector factory bound for Class<%s>", arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = paramT.getClass().getCanonicalName();
    arrayOfObject1[1] = localArrayList;
    return String.format("No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?", arrayOfObject1);
  }

  public void a(T paramT)
  {
    if (!b(paramT))
      throw new IllegalArgumentException(c(paramT));
  }

  @CanIgnoreReturnValue
  public boolean b(T paramT)
  {
    Provider localProvider = (Provider)this.a.get(paramT.getClass());
    if (localProvider == null)
      return false;
    b.b localb = (b.b)localProvider.get();
    try
    {
      ((b)h.a(localb.b(paramT), "%s.create(I) should not return null.", localb.getClass())).a(paramT);
      return true;
    }
    catch (ClassCastException localClassCastException)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localb.getClass().getCanonicalName();
      arrayOfObject[1] = paramT.getClass().getCanonicalName();
      throw new a(String.format("%s does not implement AndroidInjector.Factory<%s>", arrayOfObject), localClassCastException);
    }
  }

  public static final class a extends RuntimeException
  {
    a(String paramString, ClassCastException paramClassCastException)
    {
      super(paramClassCastException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.android.c
 * JD-Core Version:    0.6.2
 */