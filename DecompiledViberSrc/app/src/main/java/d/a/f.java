package d.a;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

public final class f
  implements ListIterator
{
  public static final f a = new f();

  @NotNull
  public Void a()
  {
    throw ((Throwable)new NoSuchElementException());
  }

  @NotNull
  public Void b()
  {
    throw ((Throwable)new NoSuchElementException());
  }

  public boolean hasNext()
  {
    return false;
  }

  public boolean hasPrevious()
  {
    return false;
  }

  public int nextIndex()
  {
    return 0;
  }

  public int previousIndex()
  {
    return -1;
  }

  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.a.f
 * JD-Core Version:    0.6.2
 */