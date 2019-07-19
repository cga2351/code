package c.b.a.a;

import c.b.a.a.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  private static final k.b l = new k.b().b("NA");
  private static final Pattern o = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*)+");
  private static final Pattern p = Pattern.compile("[- ]");
  private static final Pattern q = Pattern.compile(" ");
  private String a = "";
  private StringBuilder b = new StringBuilder();
  private String c = "";
  private StringBuilder d = new StringBuilder();
  private StringBuilder e = new StringBuilder();
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private final j j;
  private String k;
  private k.b m;
  private k.b n;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private StringBuilder u = new StringBuilder();
  private boolean v = false;
  private String w = "";
  private StringBuilder x = new StringBuilder();
  private List<k.a> y = new ArrayList();
  private c z = new c(64);

  b(j paramj, String paramString)
  {
    this.j = paramj;
    this.k = paramString;
    this.n = a(this.k);
    this.m = this.n;
  }

  private k.b a(String paramString)
  {
    int i1 = this.j.c(paramString);
    String str = this.j.b(i1);
    k.b localb = this.j.b(str);
    if (localb != null)
      return localb;
    return l;
  }

  private String a(char paramChar, boolean paramBoolean)
  {
    this.d.append(paramChar);
    if (paramBoolean)
      this.s = this.d.length();
    String str2;
    if (!b(paramChar))
    {
      this.f = false;
      this.g = true;
      if (this.f)
        break label127;
      if (!this.g)
        break label78;
      str2 = this.d.toString();
    }
    label78: label127: String str1;
    do
    {
      return str2;
      paramChar = b(paramChar, paramBoolean);
      break;
      if (j())
      {
        if (k())
          return d();
      }
      else if (e())
      {
        this.u.append(' ');
        return d();
      }
      return this.d.toString();
      switch (this.e.length())
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (this.i)
      {
        if (k())
          this.i = false;
        return this.u + this.x.toString();
        return this.d.toString();
        if (j())
        {
          this.i = true;
        }
        else
        {
          this.w = i();
          return f();
        }
      }
      if (this.y.size() <= 0)
        break label325;
      str1 = c(paramChar);
      str2 = b();
    }
    while (str2.length() > 0);
    c(this.x.toString());
    if (c())
      return g();
    if (this.f)
      return d(str1);
    return this.d.toString();
    label325: return f();
  }

  private String a(String paramString1, String paramString2)
  {
    Matcher localMatcher = this.z.a(paramString1).matcher("999999999999999");
    localMatcher.find();
    String str = localMatcher.group();
    if (str.length() < this.x.length())
      return "";
    return str.replaceAll(paramString1, paramString2).replaceAll("9", " ");
  }

  private boolean a(k.a parama)
  {
    String str1 = parama.a();
    this.b.setLength(0);
    String str2 = a(str1, parama.b());
    int i1 = str2.length();
    boolean bool = false;
    if (i1 > 0)
    {
      this.b.append(str2);
      bool = true;
    }
    return bool;
  }

  private char b(char paramChar, boolean paramBoolean)
  {
    if (paramChar == '+')
      this.e.append(paramChar);
    while (true)
    {
      if (paramBoolean)
        this.t = this.e.length();
      return paramChar;
      paramChar = Character.forDigit(Character.digit(paramChar, 10), 10);
      this.e.append(paramChar);
      this.x.append(paramChar);
    }
  }

  private void b(String paramString)
  {
    int i1;
    if ((this.h) && (this.w.length() == 0))
    {
      i1 = 1;
      if ((i1 == 0) || (this.n.v() <= 0))
        break label181;
    }
    label181: for (List localList = this.n.u(); ; localList = this.n.s())
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        k.a locala = (k.a)localIterator.next();
        if (((this.w.length() <= 0) || (!j.a(locala.d())) || (locala.e()) || (locala.f())) && ((this.w.length() != 0) || (this.h) || (j.a(locala.d())) || (locala.e())) && (o.matcher(locala.b()).matches()))
          this.y.add(locala);
      }
      i1 = 0;
      break;
    }
    c(paramString);
  }

  private boolean b(char paramChar)
  {
    return (Character.isDigit(paramChar)) || ((this.d.length() == 1) && (j.a.matcher(Character.toString(paramChar)).matches()));
  }

  private String c(char paramChar)
  {
    Matcher localMatcher = q.matcher(this.b);
    if (localMatcher.find(this.r))
    {
      String str = localMatcher.replaceFirst(Character.toString(paramChar));
      this.b.replace(0, str.length(), str);
      this.r = localMatcher.start();
      return this.b.substring(0, 1 + this.r);
    }
    if (this.y.size() == 1)
      this.f = false;
    this.c = "";
    return this.d.toString();
  }

  private void c(String paramString)
  {
    int i1 = -3 + paramString.length();
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      k.a locala = (k.a)localIterator.next();
      if (locala.c() != 0)
      {
        int i2 = Math.min(i1, -1 + locala.c());
        if (!this.z.a(locala.a(i2)).matcher(paramString).lookingAt())
          localIterator.remove();
      }
    }
  }

  private boolean c()
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      k.a locala = (k.a)localIterator.next();
      String str = locala.a();
      if (this.c.equals(str))
        return false;
      if (a(locala))
      {
        this.c = str;
        this.v = p.matcher(locala.d()).find();
        this.r = 0;
        return true;
      }
      localIterator.remove();
    }
    this.f = false;
    return false;
  }

  private String d()
  {
    this.f = true;
    this.i = false;
    this.y.clear();
    this.r = 0;
    this.b.setLength(0);
    this.c = "";
    return f();
  }

  private String d(String paramString)
  {
    int i1 = this.u.length();
    if ((this.v) && (i1 > 0) && (this.u.charAt(i1 - 1) != ' '))
      return new String(this.u) + ' ' + paramString;
    return this.u + paramString;
  }

  private boolean e()
  {
    if (this.w.length() > 0)
    {
      this.x.insert(0, this.w);
      int i1 = this.u.lastIndexOf(this.w);
      this.u.setLength(i1);
    }
    boolean bool1 = this.w.equals(i());
    boolean bool2 = false;
    if (!bool1)
      bool2 = true;
    return bool2;
  }

  private String f()
  {
    if (this.x.length() >= 3)
    {
      b(this.x.toString());
      String str = b();
      if (str.length() > 0)
        return str;
      if (c())
        return g();
      return this.d.toString();
    }
    return d(this.x.toString());
  }

  private String g()
  {
    int i1 = this.x.length();
    if (i1 > 0)
    {
      String str = "";
      for (int i2 = 0; i2 < i1; i2++)
        str = c(this.x.charAt(i2));
      if (this.f)
        return d(str);
      return this.d.toString();
    }
    return this.u.toString();
  }

  private boolean h()
  {
    return (this.n.l() == 1) && (this.x.charAt(0) == '1') && (this.x.charAt(1) != '0') && (this.x.charAt(1) != '1');
  }

  private String i()
  {
    int i1 = 1;
    if (h())
    {
      this.u.append('1').append(' ');
      this.h = i1;
    }
    while (true)
    {
      String str = this.x.substring(0, i1);
      this.x.delete(0, i1);
      return str;
      if (this.n.p())
      {
        Matcher localMatcher = this.z.a(this.n.q()).matcher(this.x);
        if ((localMatcher.lookingAt()) && (localMatcher.end() > 0))
        {
          this.h = i1;
          i1 = localMatcher.end();
          this.u.append(this.x.substring(0, i1));
        }
      }
      else
      {
        i1 = 0;
      }
    }
  }

  private boolean j()
  {
    Matcher localMatcher = this.z.a("\\+|" + this.n.m()).matcher(this.e);
    if (localMatcher.lookingAt())
    {
      this.h = true;
      int i1 = localMatcher.end();
      this.x.setLength(0);
      this.x.append(this.e.substring(i1));
      this.u.setLength(0);
      this.u.append(this.e.substring(0, i1));
      if (this.e.charAt(0) != '+')
        this.u.append(' ');
      return true;
    }
    return false;
  }

  private boolean k()
  {
    if (this.x.length() == 0);
    StringBuilder localStringBuilder;
    int i1;
    do
    {
      return false;
      localStringBuilder = new StringBuilder();
      i1 = this.j.a(this.x, localStringBuilder);
    }
    while (i1 == 0);
    this.x.setLength(0);
    this.x.append(localStringBuilder);
    String str1 = this.j.b(i1);
    if ("001".equals(str1))
      this.n = this.j.a(i1);
    while (true)
    {
      String str2 = Integer.toString(i1);
      this.u.append(str2).append(' ');
      this.w = "";
      return true;
      if (!str1.equals(this.k))
        this.n = a(str1);
    }
  }

  public String a(char paramChar)
  {
    this.a = a(paramChar, false);
    return this.a;
  }

  public void a()
  {
    this.a = "";
    this.d.setLength(0);
    this.e.setLength(0);
    this.b.setLength(0);
    this.r = 0;
    this.c = "";
    this.u.setLength(0);
    this.w = "";
    this.x.setLength(0);
    this.f = true;
    this.g = false;
    this.t = 0;
    this.s = 0;
    this.h = false;
    this.i = false;
    this.y.clear();
    this.v = false;
    if (!this.n.equals(this.m))
      this.n = a(this.k);
  }

  String b()
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      k.a locala = (k.a)localIterator.next();
      Matcher localMatcher = this.z.a(locala.a()).matcher(this.x);
      if (localMatcher.matches())
      {
        this.v = p.matcher(locala.d()).find();
        return d(localMatcher.replaceAll(locala.b()));
      }
    }
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.b
 * JD-Core Version:    0.6.2
 */