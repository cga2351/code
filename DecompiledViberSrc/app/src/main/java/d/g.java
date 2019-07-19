package d;

import d.d.a.a;
import d.d.b.h;
import org.jetbrains.annotations.NotNull;

class g
{
  @NotNull
  public static final <T> d<T> a(@NotNull i parami, @NotNull a<? extends T> parama)
  {
    h.b(parami, "mode");
    h.b(parama, "initializer");
    switch (f.$EnumSwitchMapping$0[parami.ordinal()])
    {
    default:
      throw new j();
    case 1:
      return (d)new l(parama, null, 2, null);
    case 2:
      return (d)new k(parama);
    case 3:
    }
    return (d)new p(parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.g
 * JD-Core Version:    0.6.2
 */