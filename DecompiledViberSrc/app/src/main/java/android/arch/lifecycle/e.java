package android.arch.lifecycle;

public abstract class e
{
  public abstract b a();

  public abstract void a(g paramg);

  public abstract void b(g paramg);

  public static enum a
  {
    static
    {
      ON_RESUME = new a("ON_RESUME", 2);
      ON_PAUSE = new a("ON_PAUSE", 3);
      ON_STOP = new a("ON_STOP", 4);
      ON_DESTROY = new a("ON_DESTROY", 5);
      ON_ANY = new a("ON_ANY", 6);
      a[] arrayOfa = new a[7];
      arrayOfa[0] = ON_CREATE;
      arrayOfa[1] = ON_START;
      arrayOfa[2] = ON_RESUME;
      arrayOfa[3] = ON_PAUSE;
      arrayOfa[4] = ON_STOP;
      arrayOfa[5] = ON_DESTROY;
      arrayOfa[6] = ON_ANY;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[5];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
    }

    public boolean a(b paramb)
    {
      return compareTo(paramb) >= 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.e
 * JD-Core Version:    0.6.2
 */