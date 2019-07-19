package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class o
{
  private UUID a;
  private a b;
  private e c;
  private Set<String> d;

  public o(UUID paramUUID, a parama, e parame, List<String> paramList)
  {
    this.a = paramUUID;
    this.b = parama;
    this.c = parame;
    this.d = new HashSet(paramList);
  }

  public a a()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    o localo;
    boolean bool3;
    do
    {
      a locala1;
      a locala2;
      do
      {
        boolean bool4;
        do
        {
          Class localClass1;
          Class localClass2;
          do
          {
            do
            {
              return bool2;
              bool2 = false;
            }
            while (paramObject == null);
            localClass1 = getClass();
            localClass2 = paramObject.getClass();
            bool2 = false;
          }
          while (localClass1 != localClass2);
          localo = (o)paramObject;
          if (this.a == null)
            break;
          bool4 = this.a.equals(localo.a);
          bool2 = false;
        }
        while (!bool4);
        locala1 = this.b;
        locala2 = localo.b;
        bool2 = false;
      }
      while (locala1 != locala2);
      if (this.c == null)
        break label156;
      bool3 = this.c.equals(localo.c);
      bool2 = false;
    }
    while (!bool3);
    label122: if (this.d != null)
      bool1 = this.d.equals(localo.d);
    while (true)
    {
      return bool1;
      if (localo.a == null)
        break;
      return false;
      label156: if (localo.c == null)
        break label122;
      return false;
      if (localo.d != null)
        bool1 = false;
    }
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.a != null)
    {
      i = this.a.hashCode();
      int j = i * 31;
      if (this.b == null)
        break label105;
      k = this.b.hashCode();
      m = 31 * (k + j);
      if (this.c == null)
        break label110;
    }
    label105: label110: for (int n = this.c.hashCode(); ; n = 0)
    {
      int i1 = 31 * (n + m);
      Set localSet = this.d;
      int i2 = 0;
      if (localSet != null)
        i2 = this.d.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  public String toString()
  {
    return "WorkInfo{mId='" + this.a + '\'' + ", mState=" + this.b + ", mOutputData=" + this.c + ", mTags=" + this.d + '}';
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
    }

    public boolean a()
    {
      return (this == c) || (this == d) || (this == f);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.o
 * JD-Core Version:    0.6.2
 */