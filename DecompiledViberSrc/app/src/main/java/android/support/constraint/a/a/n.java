package android.support.constraint.a.a;

import android.support.constraint.a.c;
import java.util.ArrayList;

public class n extends d
{
  protected ArrayList<d> al = new ArrayList();

  public void F()
  {
    super.F();
    if (this.al == null);
    while (true)
    {
      return;
      int i = this.al.size();
      for (int j = 0; j < i; j++)
      {
        d locald = (d)this.al.get(j);
        locald.b(s(), t());
        if (!(locald instanceof e))
          locald.F();
      }
    }
  }

  public void O()
  {
    F();
    if (this.al == null);
    while (true)
    {
      return;
      int i = this.al.size();
      for (int j = 0; j < i; j++)
      {
        d locald = (d)this.al.get(j);
        if ((locald instanceof n))
          ((n)locald).O();
      }
    }
  }

  public e U()
  {
    d locald1 = j();
    e locale;
    Object localObject;
    if ((this instanceof e))
    {
      locale = (e)this;
      localObject = locald1;
    }
    while (true)
    {
      d locald2;
      if (localObject != null)
      {
        locald2 = ((d)localObject).j();
        if ((localObject instanceof e))
        {
          locale = (e)localObject;
          localObject = locald2;
        }
      }
      else
      {
        return locale;
        localObject = locald2;
        continue;
        localObject = locald1;
        locale = null;
      }
    }
  }

  public void V()
  {
    this.al.clear();
  }

  public void a(c paramc)
  {
    super.a(paramc);
    int i = this.al.size();
    for (int j = 0; j < i; j++)
      ((d)this.al.get(j)).a(paramc);
  }

  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    int i = this.al.size();
    for (int j = 0; j < i; j++)
      ((d)this.al.get(j)).b(u(), v());
  }

  public void c(d paramd)
  {
    this.al.add(paramd);
    if (paramd.j() != null)
      ((n)paramd.j()).d(paramd);
    paramd.a(this);
  }

  public void d(d paramd)
  {
    this.al.remove(paramd);
    paramd.a(null);
  }

  public void f()
  {
    this.al.clear();
    super.f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.n
 * JD-Core Version:    0.6.2
 */