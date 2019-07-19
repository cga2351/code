package d.a;

import d.d.b.d;
import d.d.b.h;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g
  implements Serializable, Set
{
  public static final g a = new g();

  public int a()
  {
    return 0;
  }

  public boolean a(@NotNull Void paramVoid)
  {
    h.b(paramVoid, "element");
    return false;
  }

  public boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }

  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }

  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Void))
      return a((Void)paramObject);
    return false;
  }

  public boolean containsAll(@NotNull Collection paramCollection)
  {
    h.b(paramCollection, "elements");
    return paramCollection.isEmpty();
  }

  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Set)) && (((Set)paramObject).isEmpty());
  }

  public int hashCode()
  {
    return 0;
  }

  public boolean isEmpty()
  {
    return true;
  }

  @NotNull
  public Iterator iterator()
  {
    return (Iterator)f.a;
  }

  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }

  public boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }

  public boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }

  public final int size()
  {
    return a();
  }

  public Object[] toArray()
  {
    return d.a(this);
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return d.a(this, paramArrayOfT);
  }

  @NotNull
  public String toString()
  {
    return "[]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.a.g
 * JD-Core Version:    0.6.2
 */