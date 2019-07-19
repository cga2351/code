package d;

import d.d.a.a;
import d.d.b.h;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class l<T>
  implements d<T>, Serializable
{
  private a<? extends T> a;
  private volatile Object b;
  private final Object c;

  public l(@NotNull a<? extends T> parama, @Nullable Object paramObject)
  {
    this.a = parama;
    this.b = n.a;
    if (paramObject != null);
    while (true)
    {
      this.c = paramObject;
      return;
      paramObject = this;
    }
  }

  public T a()
  {
    Object localObject1 = this.b;
    if (localObject1 != n.a)
      return localObject1;
    synchronized (this.c)
    {
      Object localObject4 = this.b;
      n localn = n.a;
      if (localObject4 != localn)
        return localObject4;
      a locala = this.a;
      if (locala == null)
        h.a();
      Object localObject5 = locala.a();
      this.b = localObject5;
      this.a = ((a)null);
      localObject4 = localObject5;
    }
  }

  public boolean b()
  {
    return this.b != n.a;
  }

  @NotNull
  public String toString()
  {
    if (b())
      return String.valueOf(a());
    return "Lazy value not initialized yet.";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.l
 * JD-Core Version:    0.6.2
 */