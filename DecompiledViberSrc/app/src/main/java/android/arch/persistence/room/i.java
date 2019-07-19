package android.arch.persistence.room;

import android.arch.persistence.a.f;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class i
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final e b;
  private volatile f c;

  public i(e parame)
  {
    this.b = parame;
  }

  private f a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c == null)
        this.c = d();
      return this.c;
    }
    return d();
  }

  private f d()
  {
    String str = a();
    return this.b.a(str);
  }

  protected abstract String a();

  public void a(f paramf)
  {
    if (paramf == this.c)
      this.a.set(false);
  }

  protected void b()
  {
    this.b.e();
  }

  public f c()
  {
    b();
    return a(this.a.compareAndSet(false, true));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.i
 * JD-Core Version:    0.6.2
 */