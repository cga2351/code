package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  private final Set<a> a = new HashSet();

  public Set<a> a()
  {
    return this.a;
  }

  public void a(Uri paramUri, boolean paramBoolean)
  {
    a locala = new a(paramUri, paramBoolean);
    this.a.add(locala);
  }

  public int b()
  {
    return this.a.size();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    d locald = (d)paramObject;
    return this.a.equals(locald.a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public static final class a
  {
    private final Uri a;
    private final boolean b;

    a(Uri paramUri, boolean paramBoolean)
    {
      this.a = paramUri;
      this.b = paramBoolean;
    }

    public Uri a()
    {
      return this.a;
    }

    public boolean b()
    {
      return this.b;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
      }
      while ((this.b == locala.b) && (this.a.equals(locala.a)));
      return false;
    }

    public int hashCode()
    {
      int i = 31 * this.a.hashCode();
      if (this.b);
      for (int j = 1; ; j = 0)
        return j + i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.d
 * JD-Core Version:    0.6.2
 */