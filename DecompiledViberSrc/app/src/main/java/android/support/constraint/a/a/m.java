package android.support.constraint.a.a;

import java.util.ArrayList;

public class m
{
  private int a;
  private int b;
  private int c;
  private int d;
  private ArrayList<a> e = new ArrayList();

  public m(d paramd)
  {
    this.a = paramd.m();
    this.b = paramd.n();
    this.c = paramd.o();
    this.d = paramd.q();
    ArrayList localArrayList = paramd.E();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      c localc = (c)localArrayList.get(j);
      this.e.add(new a(localc));
    }
  }

  public void a(d paramd)
  {
    this.a = paramd.m();
    this.b = paramd.n();
    this.c = paramd.o();
    this.d = paramd.q();
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((a)this.e.get(j)).a(paramd);
  }

  public void b(d paramd)
  {
    paramd.f(this.a);
    paramd.g(this.b);
    paramd.h(this.c);
    paramd.i(this.d);
    int i = this.e.size();
    for (int j = 0; j < i; j++)
      ((a)this.e.get(j)).b(paramd);
  }

  static class a
  {
    private c a;
    private c b;
    private int c;
    private c.b d;
    private int e;

    public a(c paramc)
    {
      this.a = paramc;
      this.b = paramc.g();
      this.c = paramc.e();
      this.d = paramc.f();
      this.e = paramc.h();
    }

    public void a(d paramd)
    {
      this.a = paramd.a(this.a.d());
      if (this.a != null)
      {
        this.b = this.a.g();
        this.c = this.a.e();
        this.d = this.a.f();
        this.e = this.a.h();
        return;
      }
      this.b = null;
      this.c = 0;
      this.d = c.b.b;
      this.e = 0;
    }

    public void b(d paramd)
    {
      paramd.a(this.a.d()).a(this.b, this.c, this.d, this.e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.m
 * JD-Core Version:    0.6.2
 */