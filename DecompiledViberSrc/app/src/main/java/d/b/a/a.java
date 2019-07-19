package d.b.a;

import d.d.b.h;
import org.jetbrains.annotations.NotNull;

public class a extends d.b.a
{
  public void a(@NotNull Throwable paramThrowable1, @NotNull Throwable paramThrowable2)
  {
    h.b(paramThrowable1, "cause");
    h.b(paramThrowable2, "exception");
    paramThrowable1.addSuppressed(paramThrowable2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.b.a.a
 * JD-Core Version:    0.6.2
 */