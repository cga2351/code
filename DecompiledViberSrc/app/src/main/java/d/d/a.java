package d.d;

import d.d.b.h;
import d.m;
import org.jetbrains.annotations.NotNull;

public final class a
{
  @NotNull
  public static final <T> Class<T> a(@NotNull d.f.b<T> paramb)
  {
    h.b(paramb, "receiver$0");
    Object localObject = ((d.d.b.b)paramb).a();
    if (!((Class)localObject).isPrimitive())
    {
      if (localObject == null)
        throw new m("null cannot be cast to non-null type java.lang.Class<T>");
    }
    else
    {
      String str = ((Class)localObject).getName();
      if (str == null);
      while (localObject == null)
      {
        throw new m("null cannot be cast to non-null type java.lang.Class<T>");
        switch (str.hashCode())
        {
        default:
          break;
        case -1325958191:
          if (str.equals("double"))
            localObject = Double.class;
          break;
        case 64711720:
          if (str.equals("boolean"))
            localObject = Boolean.class;
          break;
        case 3625364:
          if (str.equals("void"))
            localObject = Void.class;
          break;
        case 3039496:
          if (str.equals("byte"))
            localObject = Byte.class;
          break;
        case 3052374:
          if (str.equals("char"))
            localObject = Character.class;
          break;
        case 109413500:
          if (str.equals("short"))
            localObject = Short.class;
          break;
        case 97526364:
          if (str.equals("float"))
            localObject = Float.class;
          break;
        case 104431:
          if (str.equals("int"))
            localObject = Integer.class;
          break;
        case 3327612:
          if (str.equals("long"))
            localObject = Long.class;
          break;
        }
      }
    }
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.a
 * JD-Core Version:    0.6.2
 */