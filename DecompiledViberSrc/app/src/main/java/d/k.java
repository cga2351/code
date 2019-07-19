package d;

import d.d.a.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;

final class k<T>
  implements d<T>, Serializable
{
  public static final a a = new a(null);
  private static final AtomicReferenceFieldUpdater<k<?>, Object> e = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "c");
  private volatile a<? extends T> b;
  private volatile Object c;
  private final Object d;

  public k(@NotNull a<? extends T> parama)
  {
    this.b = parama;
    this.c = n.a;
    this.d = n.a;
  }

  public T a()
  {
    Object localObject1 = this.c;
    if (localObject1 != n.a)
      return localObject1;
    a locala = this.b;
    if (locala != null)
    {
      Object localObject2 = locala.a();
      if (e.compareAndSet(this, n.a, localObject2))
      {
        this.b = ((a)null);
        return localObject2;
      }
    }
    return this.c;
  }

  public boolean b()
  {
    return this.c != n.a;
  }

  @NotNull
  public String toString()
  {
    if (b())
      return String.valueOf(a());
    return "Lazy value not initialized yet.";
  }

  public static final class a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.k
 * JD-Core Version:    0.6.2
 */