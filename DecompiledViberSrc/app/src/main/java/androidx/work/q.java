package androidx.work;

import androidx.work.impl.b.j;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class q
{
  private UUID a;
  private j b;
  private Set<String> c;

  protected q(UUID paramUUID, j paramj, Set<String> paramSet)
  {
    this.a = paramUUID;
    this.b = paramj;
    this.c = paramSet;
  }

  public String a()
  {
    return this.a.toString();
  }

  public j b()
  {
    return this.b;
  }

  public Set<String> c()
  {
    return this.c;
  }

  public static abstract class a<B extends a, W extends q>
  {
    boolean a = false;
    UUID b = UUID.randomUUID();
    j c;
    Set<String> d = new HashSet();

    a(Class<? extends ListenableWorker> paramClass)
    {
      this.c = new j(this.b.toString(), paramClass.getName());
      a(paramClass.getName());
    }

    public final B a(c paramc)
    {
      this.c.j = paramc;
      return c();
    }

    public final B a(e parame)
    {
      this.c.e = parame;
      return c();
    }

    public final B a(String paramString)
    {
      this.d.add(paramString);
      return c();
    }

    abstract B c();

    abstract W d();

    public final W e()
    {
      q localq = d();
      this.b = UUID.randomUUID();
      this.c = new j(this.c);
      this.c.a = this.b.toString();
      return localq;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.q
 * JD-Core Version:    0.6.2
 */