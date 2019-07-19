package d;

import d.d.a.a;
import d.d.b.h;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public final class p<T>
  implements d<T>, Serializable
{
  private a<? extends T> a;
  private Object b;

  public p(@NotNull a<? extends T> parama)
  {
    this.a = parama;
    this.b = n.a;
  }

  public T a()
  {
    if (this.b == n.a)
    {
      a locala = this.a;
      if (locala == null)
        h.a();
      this.b = locala.a();
      this.a = ((a)null);
    }
    return this.b;
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
 * Qualified Name:     d.p
 * JD-Core Version:    0.6.2
 */