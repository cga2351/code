package d.c;

import java.io.Closeable;
import org.jetbrains.annotations.Nullable;

public final class a
{
  public static final void a(@Nullable Closeable paramCloseable, @Nullable Throwable paramThrowable)
  {
    if (paramCloseable == null)
      return;
    if (paramThrowable == null)
    {
      paramCloseable.close();
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a.a(paramThrowable, localThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.c.a
 * JD-Core Version:    0.6.2
 */