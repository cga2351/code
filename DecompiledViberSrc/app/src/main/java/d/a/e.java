package d.a;

import d.d.b.h;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

class e extends d
{
  public static final char a(@NotNull char[] paramArrayOfChar)
  {
    h.b(paramArrayOfChar, "receiver$0");
    switch (paramArrayOfChar.length)
    {
    default:
      throw ((Throwable)new IllegalArgumentException("Array has more than one element."));
    case 0:
      throw ((Throwable)new NoSuchElementException("Array is empty."));
    case 1:
    }
    return paramArrayOfChar[0];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.a.e
 * JD-Core Version:    0.6.2
 */