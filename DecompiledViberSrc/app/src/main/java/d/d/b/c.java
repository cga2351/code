package d.d.b;

import d.d.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c
  implements b, d.f.b<Object>
{

  @NotNull
  private final Class<?> a;

  public c(@NotNull Class<?> paramClass)
  {
    this.a = paramClass;
  }

  @NotNull
  public Class<?> a()
  {
    return this.a;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof c)) && (h.a(a.a(this), a.a((d.f.b)paramObject)));
  }

  public int hashCode()
  {
    return a.a(this).hashCode();
  }

  @NotNull
  public String toString()
  {
    return a().toString() + " (Kotlin reflection is not available)";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.c
 * JD-Core Version:    0.6.2
 */