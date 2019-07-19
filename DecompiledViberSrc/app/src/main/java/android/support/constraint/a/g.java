package android.support.constraint.a;

final class g
{
  static abstract interface a<T>
  {
    public abstract T a();

    public abstract void a(T[] paramArrayOfT, int paramInt);

    public abstract boolean a(T paramT);
  }

  static class b<T>
    implements g.a<T>
  {
    private final Object[] a;
    private int b;

    b(int paramInt)
    {
      if (paramInt <= 0)
        throw new IllegalArgumentException("The max pool size must be > 0");
      this.a = new Object[paramInt];
    }

    public T a()
    {
      if (this.b > 0)
      {
        int i = -1 + this.b;
        Object localObject = this.a[i];
        this.a[i] = null;
        this.b = (-1 + this.b);
        return localObject;
      }
      return null;
    }

    public void a(T[] paramArrayOfT, int paramInt)
    {
      if (paramInt > paramArrayOfT.length)
        paramInt = paramArrayOfT.length;
      for (int i = 0; i < paramInt; i++)
      {
        T ? = paramArrayOfT[i];
        if (this.b < this.a.length)
        {
          this.a[this.b] = ?;
          this.b = (1 + this.b);
        }
      }
    }

    public boolean a(T paramT)
    {
      if (this.b < this.a.length)
      {
        this.a[this.b] = paramT;
        this.b = (1 + this.b);
        return true;
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.g
 * JD-Core Version:    0.6.2
 */