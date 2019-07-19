package android.support.constraint.a.a;

import android.support.constraint.a.f;
import android.support.constraint.a.h;
import java.util.ArrayList;

public class a extends g
{
  private int ad = 0;
  private ArrayList<j> ae = new ArrayList(4);
  private boolean af = true;

  public void a(int paramInt)
  {
    this.ad = paramInt;
  }

  public void a(android.support.constraint.a.e parame)
  {
    this.y[0] = this.q;
    this.y[2] = this.r;
    this.y[1] = this.s;
    this.y[3] = this.t;
    for (int i = 0; i < this.y.length; i++)
      this.y[i].f = parame.a(this.y[i]);
    c localc;
    d locald2;
    boolean bool;
    if ((this.ad >= 0) && (this.ad < 4))
    {
      localc = this.y[this.ad];
      int j = 0;
      while (true)
        if (j < this.ac)
        {
          locald2 = this.ab[j];
          if ((!this.af) && (!locald2.a()))
            j++;
          else if (((this.ad == 0) || (this.ad == 1)) && (locald2.I() == d.a.c))
            bool = true;
        }
    }
    while (true)
    {
      label172: label203: int k;
      label206: d locald1;
      if ((this.ad == 0) || (this.ad == 1))
      {
        if (j().I() == d.a.b)
          bool = false;
        k = 0;
        if (k >= this.ac)
          break label373;
        locald1 = this.ab[k];
        if ((this.af) || (locald1.a()))
          break label297;
      }
      while (true)
      {
        k++;
        break label206;
        if (((this.ad != 2) && (this.ad != 3)) || (locald2.J() != d.a.c))
          break;
        bool = true;
        break label172;
        if (j().J() != d.a.b)
          break label203;
        bool = false;
        break label203;
        label297: h localh = parame.a(locald1.y[this.ad]);
        locald1.y[this.ad].f = localh;
        if ((this.ad == 0) || (this.ad == 2))
          parame.b(localc.f, localh, bool);
        else
          parame.a(localc.f, localh, bool);
      }
      label373: if (this.ad == 0)
      {
        parame.c(this.s.f, this.q.f, 0, 6);
        if (!bool)
          parame.c(this.q.f, this.B.s.f, 0, 5);
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.ad != 1)
                break;
              parame.c(this.q.f, this.s.f, 0, 6);
            }
            while (bool);
            parame.c(this.q.f, this.B.q.f, 0, 5);
            return;
            if (this.ad != 2)
              break;
            parame.c(this.t.f, this.r.f, 0, 6);
          }
          while (bool);
          parame.c(this.r.f, this.B.t.f, 0, 5);
          return;
        }
        while (this.ad != 3);
        parame.c(this.r.f, this.t.f, 0, 6);
      }
      while (bool);
      parame.c(this.r.f, this.B.r.f, 0, 5);
      return;
      bool = false;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.af = paramBoolean;
  }

  public boolean a()
  {
    return true;
  }

  public void b()
  {
    super.b();
    this.ae.clear();
  }

  public void b(int paramInt)
  {
    if (this.B == null);
    while (!((e)this.B).q(2))
      return;
    j localj;
    switch (this.ad)
    {
    default:
      return;
    case 0:
      localj = this.q.a();
      label65: localj.b(5);
      if ((this.ad == 0) || (this.ad == 1))
      {
        this.r.a().a(null, 0.0F);
        this.t.a().a(null, 0.0F);
      }
      break;
    case 1:
    case 2:
    case 3:
    }
    d locald;
    while (true)
    {
      this.ae.clear();
      for (int i = 0; i < this.ac; i++)
      {
        locald = this.ab[i];
        if ((this.af) || (locald.a()))
          break label215;
      }
      localj = this.s.a();
      break label65;
      localj = this.r.a();
      break label65;
      localj = this.t.a();
      break label65;
      this.q.a().a(null, 0.0F);
      this.s.a().a(null, 0.0F);
    }
    label215: Object localObject;
    switch (this.ad)
    {
    default:
      localObject = null;
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (localObject != null)
    {
      this.ae.add(localObject);
      ((j)localObject).a(localj);
      break;
      localObject = locald.q.a();
      continue;
      localObject = locald.s.a();
      continue;
      localObject = locald.r.a();
      continue;
      localObject = locald.t.a();
    }
  }

  public void c()
  {
    float f1 = 3.4028235E+38F;
    j localj1;
    int j;
    Object localObject1;
    float f2;
    label62: j localj2;
    float f3;
    Object localObject2;
    switch (this.ad)
    {
    default:
    case 0:
      do
      {
        return;
        localj1 = this.q.a();
        int i = this.ae.size();
        j = 0;
        localObject1 = null;
        f2 = f1;
        if (j >= i)
          break;
        localj2 = (j)this.ae.get(j);
      }
      while (localj2.i != 1);
      if ((this.ad == 0) || (this.ad == 2))
      {
        if (localj2.f >= f2)
          break label345;
        f3 = localj2.f;
        localObject2 = localj2.e;
      }
      break;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      j++;
      f2 = f3;
      localObject1 = localObject2;
      break label62;
      localj1 = this.s.a();
      f1 = 0.0F;
      break;
      localj1 = this.r.a();
      break;
      localj1 = this.t.a();
      f1 = 0.0F;
      break;
      if (localj2.f > f2)
      {
        f3 = localj2.f;
        localObject2 = localj2.e;
        continue;
        if (android.support.constraint.a.e.a() != null)
        {
          f localf = android.support.constraint.a.e.a();
          localf.z = (1L + localf.z);
        }
        localj1.e = localObject1;
        localj1.f = f2;
        localj1.f();
        switch (this.ad)
        {
        default:
          return;
        case 0:
          this.s.a().a(localObject1, f2);
          return;
        case 1:
          this.q.a().a(localObject1, f2);
          return;
        case 2:
          this.t.a().a(localObject1, f2);
          return;
        case 3:
        }
        this.r.a().a(localObject1, f2);
      }
      else
      {
        label345: localObject2 = localObject1;
        f3 = f2;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.a
 * JD-Core Version:    0.6.2
 */