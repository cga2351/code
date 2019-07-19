package com.google.d.b.a;

import com.google.d.d.b;
import com.google.d.i;
import com.google.d.l;
import com.google.d.m;
import com.google.d.o;
import com.google.d.r;
import com.google.d.u;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class n
{
  public static final w<String> A = new w()
  {
    public String a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      b localb = paramAnonymousa.f();
      if (localb == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      if (localb == b.h)
        return Boolean.toString(paramAnonymousa.i());
      return paramAnonymousa.h();
    }

    public void a(com.google.d.d.c paramAnonymousc, String paramAnonymousString)
      throws IOException
    {
      paramAnonymousc.b(paramAnonymousString);
    }
  };
  public static final w<BigDecimal> B = new w()
  {
    public BigDecimal a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      try
      {
        BigDecimal localBigDecimal = new BigDecimal(paramAnonymousa.h());
        return localBigDecimal;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new u(localNumberFormatException);
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, BigDecimal paramAnonymousBigDecimal)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousBigDecimal);
    }
  };
  public static final w<BigInteger> C = new w()
  {
    public BigInteger a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      try
      {
        BigInteger localBigInteger = new BigInteger(paramAnonymousa.h());
        return localBigInteger;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new u(localNumberFormatException);
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, BigInteger paramAnonymousBigInteger)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousBigInteger);
    }
  };
  public static final x D = a(String.class, A);
  public static final w<StringBuilder> E = new w()
  {
    public StringBuilder a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      return new StringBuilder(paramAnonymousa.h());
    }

    public void a(com.google.d.d.c paramAnonymousc, StringBuilder paramAnonymousStringBuilder)
      throws IOException
    {
      if (paramAnonymousStringBuilder == null);
      for (String str = null; ; str = paramAnonymousStringBuilder.toString())
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x F = a(StringBuilder.class, E);
  public static final w<StringBuffer> G = new w()
  {
    public StringBuffer a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      return new StringBuffer(paramAnonymousa.h());
    }

    public void a(com.google.d.d.c paramAnonymousc, StringBuffer paramAnonymousStringBuffer)
      throws IOException
    {
      if (paramAnonymousStringBuffer == null);
      for (String str = null; ; str = paramAnonymousStringBuffer.toString())
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x H = a(StringBuffer.class, G);
  public static final w<URL> I = new w()
  {
    public URL a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
        paramAnonymousa.j();
      String str;
      do
      {
        return null;
        str = paramAnonymousa.h();
      }
      while ("null".equals(str));
      return new URL(str);
    }

    public void a(com.google.d.d.c paramAnonymousc, URL paramAnonymousURL)
      throws IOException
    {
      if (paramAnonymousURL == null);
      for (String str = null; ; str = paramAnonymousURL.toExternalForm())
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x J = a(URL.class, I);
  public static final w<URI> K = new w()
  {
    public URI a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
        paramAnonymousa.j();
      while (true)
      {
        return null;
        try
        {
          String str = paramAnonymousa.h();
          if ("null".equals(str))
            continue;
          URI localURI = new URI(str);
          return localURI;
        }
        catch (URISyntaxException localURISyntaxException)
        {
          throw new m(localURISyntaxException);
        }
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, URI paramAnonymousURI)
      throws IOException
    {
      if (paramAnonymousURI == null);
      for (String str = null; ; str = paramAnonymousURI.toASCIIString())
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x L = a(URI.class, K);
  public static final w<InetAddress> M = new w()
  {
    public InetAddress a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      return InetAddress.getByName(paramAnonymousa.h());
    }

    public void a(com.google.d.d.c paramAnonymousc, InetAddress paramAnonymousInetAddress)
      throws IOException
    {
      if (paramAnonymousInetAddress == null);
      for (String str = null; ; str = paramAnonymousInetAddress.getHostAddress())
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x N = b(InetAddress.class, M);
  public static final w<UUID> O = new w()
  {
    public UUID a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      return UUID.fromString(paramAnonymousa.h());
    }

    public void a(com.google.d.d.c paramAnonymousc, UUID paramAnonymousUUID)
      throws IOException
    {
      if (paramAnonymousUUID == null);
      for (String str = null; ; str = paramAnonymousUUID.toString())
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x P = a(UUID.class, O);
  public static final w<Currency> Q = new w()
  {
    public Currency a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      return Currency.getInstance(paramAnonymousa.h());
    }

    public void a(com.google.d.d.c paramAnonymousc, Currency paramAnonymousCurrency)
      throws IOException
    {
      paramAnonymousc.b(paramAnonymousCurrency.getCurrencyCode());
    }
  }
  .a();
  public static final x R = a(Currency.class, Q);
  public static final x S = new x()
  {
    public <T> w<T> a(com.google.d.f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() != Timestamp.class)
        return null;
      return new w()
      {
        public Timestamp a(com.google.d.d.a paramAnonymous2a)
          throws IOException
        {
          Date localDate = (Date)this.a.b(paramAnonymous2a);
          if (localDate != null)
            return new Timestamp(localDate.getTime());
          return null;
        }

        public void a(com.google.d.d.c paramAnonymous2c, Timestamp paramAnonymous2Timestamp)
          throws IOException
        {
          this.a.a(paramAnonymous2c, paramAnonymous2Timestamp);
        }
      };
    }
  };
  public static final w<Calendar> T = new w()
  {
    public Calendar a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      int i = 0;
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      paramAnonymousa.c();
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      while (paramAnonymousa.f() != b.d)
      {
        String str = paramAnonymousa.g();
        int i2 = paramAnonymousa.m();
        if ("year".equals(str))
          i1 = i2;
        else if ("month".equals(str))
          n = i2;
        else if ("dayOfMonth".equals(str))
          m = i2;
        else if ("hourOfDay".equals(str))
          k = i2;
        else if ("minute".equals(str))
          j = i2;
        else if ("second".equals(str))
          i = i2;
      }
      paramAnonymousa.d();
      return new GregorianCalendar(i1, n, m, k, j, i);
    }

    public void a(com.google.d.d.c paramAnonymousc, Calendar paramAnonymousCalendar)
      throws IOException
    {
      if (paramAnonymousCalendar == null)
      {
        paramAnonymousc.f();
        return;
      }
      paramAnonymousc.d();
      paramAnonymousc.a("year");
      paramAnonymousc.a(paramAnonymousCalendar.get(1));
      paramAnonymousc.a("month");
      paramAnonymousc.a(paramAnonymousCalendar.get(2));
      paramAnonymousc.a("dayOfMonth");
      paramAnonymousc.a(paramAnonymousCalendar.get(5));
      paramAnonymousc.a("hourOfDay");
      paramAnonymousc.a(paramAnonymousCalendar.get(11));
      paramAnonymousc.a("minute");
      paramAnonymousc.a(paramAnonymousCalendar.get(12));
      paramAnonymousc.a("second");
      paramAnonymousc.a(paramAnonymousCalendar.get(13));
      paramAnonymousc.e();
    }
  };
  public static final x U = b(Calendar.class, GregorianCalendar.class, T);
  public static final w<Locale> V = new w()
  {
    public Locale a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      StringTokenizer localStringTokenizer = new StringTokenizer(paramAnonymousa.h(), "_");
      if (localStringTokenizer.hasMoreElements());
      for (String str1 = localStringTokenizer.nextToken(); ; str1 = null)
      {
        if (localStringTokenizer.hasMoreElements());
        for (String str2 = localStringTokenizer.nextToken(); ; str2 = null)
        {
          if (localStringTokenizer.hasMoreElements());
          for (String str3 = localStringTokenizer.nextToken(); ; str3 = null)
          {
            if ((str2 == null) && (str3 == null))
              return new Locale(str1);
            if (str3 == null)
              return new Locale(str1, str2);
            return new Locale(str1, str2, str3);
          }
        }
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, Locale paramAnonymousLocale)
      throws IOException
    {
      if (paramAnonymousLocale == null);
      for (String str = null; ; str = paramAnonymousLocale.toString())
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x W = a(Locale.class, V);
  public static final w<l> X = new w()
  {
    public l a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      switch (n.30.a[paramAnonymousa.f().ordinal()])
      {
      default:
        throw new IllegalArgumentException();
      case 3:
        return new r(paramAnonymousa.h());
      case 1:
        return new r(new com.google.d.b.f(paramAnonymousa.h()));
      case 2:
        return new r(Boolean.valueOf(paramAnonymousa.i()));
      case 4:
        paramAnonymousa.j();
        return com.google.d.n.a;
      case 5:
        i locali = new i();
        paramAnonymousa.a();
        while (paramAnonymousa.e())
          locali.a(a(paramAnonymousa));
        paramAnonymousa.b();
        return locali;
      case 6:
      }
      o localo = new o();
      paramAnonymousa.c();
      while (paramAnonymousa.e())
        localo.a(paramAnonymousa.g(), a(paramAnonymousa));
      paramAnonymousa.d();
      return localo;
    }

    public void a(com.google.d.d.c paramAnonymousc, l paramAnonymousl)
      throws IOException
    {
      if ((paramAnonymousl == null) || (paramAnonymousl.j()))
      {
        paramAnonymousc.f();
        return;
      }
      if (paramAnonymousl.i())
      {
        r localr = paramAnonymousl.m();
        if (localr.p())
        {
          paramAnonymousc.a(localr.a());
          return;
        }
        if (localr.o())
        {
          paramAnonymousc.a(localr.f());
          return;
        }
        paramAnonymousc.b(localr.b());
        return;
      }
      if (paramAnonymousl.g())
      {
        paramAnonymousc.b();
        Iterator localIterator2 = paramAnonymousl.l().iterator();
        while (localIterator2.hasNext())
          a(paramAnonymousc, (l)localIterator2.next());
        paramAnonymousc.c();
        return;
      }
      if (paramAnonymousl.h())
      {
        paramAnonymousc.d();
        Iterator localIterator1 = paramAnonymousl.k().o().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          paramAnonymousc.a((String)localEntry.getKey());
          a(paramAnonymousc, (l)localEntry.getValue());
        }
        paramAnonymousc.e();
        return;
      }
      throw new IllegalArgumentException("Couldn't write " + paramAnonymousl.getClass());
    }
  };
  public static final x Y = b(l.class, X);
  public static final x Z = new x()
  {
    public <T> w<T> a(com.google.d.f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
    {
      Class localClass = paramAnonymousa.getRawType();
      if ((!Enum.class.isAssignableFrom(localClass)) || (localClass == Enum.class))
        return null;
      if (!localClass.isEnum())
        localClass = localClass.getSuperclass();
      return new n.a(localClass);
    }
  };
  public static final w<Class> a = new w()
  {
    public Class a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    public void a(com.google.d.d.c paramAnonymousc, Class paramAnonymousClass)
      throws IOException
    {
      if (paramAnonymousClass == null)
      {
        paramAnonymousc.f();
        return;
      }
      throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + paramAnonymousClass.getName() + ". Forgot to register a type adapter?");
    }
  };
  public static final x b = a(Class.class, a);
  public static final w<BitSet> c = new w()
  {
    public BitSet a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      BitSet localBitSet = new BitSet();
      paramAnonymousa.a();
      b localb = paramAnonymousa.f();
      int i = 0;
      if (localb != b.b)
      {
        boolean bool;
        switch (n.30.a[localb.ordinal()])
        {
        default:
          throw new u("Invalid bitset value type: " + localb);
        case 1:
          if (paramAnonymousa.m() != 0)
            bool = true;
          break;
        case 2:
        case 3:
        }
        while (true)
        {
          if (bool)
            localBitSet.set(i);
          i++;
          localb = paramAnonymousa.f();
          break;
          bool = false;
          continue;
          bool = paramAnonymousa.i();
          continue;
          String str = paramAnonymousa.h();
          try
          {
            int j = Integer.parseInt(str);
            if (j != 0)
              bool = true;
            else
              bool = false;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            throw new u("Error: Expecting: bitset number value (1, 0), Found: " + str);
          }
        }
      }
      paramAnonymousa.b();
      return localBitSet;
    }

    public void a(com.google.d.d.c paramAnonymousc, BitSet paramAnonymousBitSet)
      throws IOException
    {
      if (paramAnonymousBitSet == null)
      {
        paramAnonymousc.f();
        return;
      }
      paramAnonymousc.b();
      int i = 0;
      if (i < paramAnonymousBitSet.length())
      {
        if (paramAnonymousBitSet.get(i));
        for (int j = 1; ; j = 0)
        {
          paramAnonymousc.a(j);
          i++;
          break;
        }
      }
      paramAnonymousc.c();
    }
  };
  public static final x d = a(BitSet.class, c);
  public static final w<Boolean> e = new w()
  {
    public Boolean a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      if (paramAnonymousa.f() == b.f)
        return Boolean.valueOf(Boolean.parseBoolean(paramAnonymousa.h()));
      return Boolean.valueOf(paramAnonymousa.i());
    }

    public void a(com.google.d.d.c paramAnonymousc, Boolean paramAnonymousBoolean)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousBoolean);
    }
  };
  public static final w<Boolean> f = new w()
  {
    public Boolean a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      return Boolean.valueOf(paramAnonymousa.h());
    }

    public void a(com.google.d.d.c paramAnonymousc, Boolean paramAnonymousBoolean)
      throws IOException
    {
      if (paramAnonymousBoolean == null);
      for (String str = "null"; ; str = paramAnonymousBoolean.toString())
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x g = a(Boolean.TYPE, Boolean.class, e);
  public static final w<Number> h = new w()
  {
    public Number a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      try
      {
        Byte localByte = Byte.valueOf((byte)paramAnonymousa.m());
        return localByte;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new u(localNumberFormatException);
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousNumber);
    }
  };
  public static final x i = a(Byte.TYPE, Byte.class, h);
  public static final w<Number> j = new w()
  {
    public Number a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      try
      {
        Short localShort = Short.valueOf((short)paramAnonymousa.m());
        return localShort;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new u(localNumberFormatException);
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousNumber);
    }
  };
  public static final x k = a(Short.TYPE, Short.class, j);
  public static final w<Number> l = new w()
  {
    public Number a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      try
      {
        Integer localInteger = Integer.valueOf(paramAnonymousa.m());
        return localInteger;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new u(localNumberFormatException);
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousNumber);
    }
  };
  public static final x m = a(Integer.TYPE, Integer.class, l);
  public static final w<AtomicInteger> n = new w()
  {
    public AtomicInteger a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      try
      {
        AtomicInteger localAtomicInteger = new AtomicInteger(paramAnonymousa.m());
        return localAtomicInteger;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new u(localNumberFormatException);
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, AtomicInteger paramAnonymousAtomicInteger)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousAtomicInteger.get());
    }
  }
  .a();
  public static final x o = a(AtomicInteger.class, n);
  public static final w<AtomicBoolean> p = new w()
  {
    public AtomicBoolean a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      return new AtomicBoolean(paramAnonymousa.i());
    }

    public void a(com.google.d.d.c paramAnonymousc, AtomicBoolean paramAnonymousAtomicBoolean)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousAtomicBoolean.get());
    }
  }
  .a();
  public static final x q = a(AtomicBoolean.class, p);
  public static final w<AtomicIntegerArray> r = new w()
  {
    public AtomicIntegerArray a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      ArrayList localArrayList = new ArrayList();
      paramAnonymousa.a();
      while (paramAnonymousa.e())
        try
        {
          localArrayList.add(Integer.valueOf(paramAnonymousa.m()));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new u(localNumberFormatException);
        }
      paramAnonymousa.b();
      int i = localArrayList.size();
      AtomicIntegerArray localAtomicIntegerArray = new AtomicIntegerArray(i);
      for (int j = 0; j < i; j++)
        localAtomicIntegerArray.set(j, ((Integer)localArrayList.get(j)).intValue());
      return localAtomicIntegerArray;
    }

    public void a(com.google.d.d.c paramAnonymousc, AtomicIntegerArray paramAnonymousAtomicIntegerArray)
      throws IOException
    {
      paramAnonymousc.b();
      int i = 0;
      int j = paramAnonymousAtomicIntegerArray.length();
      while (i < j)
      {
        paramAnonymousc.a(paramAnonymousAtomicIntegerArray.get(i));
        i++;
      }
      paramAnonymousc.c();
    }
  }
  .a();
  public static final x s = a(AtomicIntegerArray.class, r);
  public static final w<Number> t = new w()
  {
    public Number a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      try
      {
        Long localLong = Long.valueOf(paramAnonymousa.l());
        return localLong;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new u(localNumberFormatException);
      }
    }

    public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousNumber);
    }
  };
  public static final w<Number> u = new w()
  {
    public Number a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      return Float.valueOf((float)paramAnonymousa.k());
    }

    public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousNumber);
    }
  };
  public static final w<Number> v = new w()
  {
    public Number a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      return Double.valueOf(paramAnonymousa.k());
    }

    public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousNumber);
    }
  };
  public static final w<Number> w = new w()
  {
    public Number a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      b localb = paramAnonymousa.f();
      switch (n.30.a[localb.ordinal()])
      {
      case 2:
      case 3:
      default:
        throw new u("Expecting number, got: " + localb);
      case 4:
        paramAnonymousa.j();
        return null;
      case 1:
      }
      return new com.google.d.b.f(paramAnonymousa.h());
    }

    public void a(com.google.d.d.c paramAnonymousc, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousc.a(paramAnonymousNumber);
    }
  };
  public static final x x = a(Number.class, w);
  public static final w<Character> y = new w()
  {
    public Character a(com.google.d.d.a paramAnonymousa)
      throws IOException
    {
      if (paramAnonymousa.f() == b.i)
      {
        paramAnonymousa.j();
        return null;
      }
      String str = paramAnonymousa.h();
      if (str.length() != 1)
        throw new u("Expecting character, got: " + str);
      return Character.valueOf(str.charAt(0));
    }

    public void a(com.google.d.d.c paramAnonymousc, Character paramAnonymousCharacter)
      throws IOException
    {
      if (paramAnonymousCharacter == null);
      for (String str = null; ; str = String.valueOf(paramAnonymousCharacter))
      {
        paramAnonymousc.b(str);
        return;
      }
    }
  };
  public static final x z = a(Character.TYPE, Character.class, y);

  public static <TT> x a(com.google.d.c.a<TT> parama, final w<TT> paramw)
  {
    return new x()
    {
      public <T> w<T> a(com.google.d.f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.equals(this.a))
          return paramw;
        return null;
      }
    };
  }

  public static <TT> x a(Class<TT> paramClass, final w<TT> paramw)
  {
    return new x()
    {
      public <T> w<T> a(com.google.d.f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
      {
        if (paramAnonymousa.getRawType() == this.a)
          return paramw;
        return null;
      }

      public String toString()
      {
        return "Factory[type=" + this.a.getName() + ",adapter=" + paramw + "]";
      }
    };
  }

  public static <TT> x a(Class<TT> paramClass1, final Class<TT> paramClass2, final w<? super TT> paramw)
  {
    return new x()
    {
      public <T> w<T> a(com.google.d.f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
      {
        Class localClass = paramAnonymousa.getRawType();
        if ((localClass == this.a) || (localClass == paramClass2))
          return paramw;
        return null;
      }

      public String toString()
      {
        return "Factory[type=" + paramClass2.getName() + "+" + this.a.getName() + ",adapter=" + paramw + "]";
      }
    };
  }

  public static <T1> x b(Class<T1> paramClass, final w<T1> paramw)
  {
    return new x()
    {
      public <T2> w<T2> a(com.google.d.f paramAnonymousf, com.google.d.c.a<T2> paramAnonymousa)
      {
        final Class localClass = paramAnonymousa.getRawType();
        if (!this.a.isAssignableFrom(localClass))
          return null;
        return new w()
        {
          public void a(com.google.d.d.c paramAnonymous2c, T1 paramAnonymous2T1)
            throws IOException
          {
            n.29.this.b.a(paramAnonymous2c, paramAnonymous2T1);
          }

          public T1 b(com.google.d.d.a paramAnonymous2a)
            throws IOException
          {
            Object localObject = n.29.this.b.b(paramAnonymous2a);
            if ((localObject != null) && (!localClass.isInstance(localObject)))
              throw new u("Expected a " + localClass.getName() + " but was " + localObject.getClass().getName());
            return localObject;
          }
        };
      }

      public String toString()
      {
        return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + paramw + "]";
      }
    };
  }

  public static <TT> x b(Class<TT> paramClass, final Class<? extends TT> paramClass1, final w<? super TT> paramw)
  {
    return new x()
    {
      public <T> w<T> a(com.google.d.f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
      {
        Class localClass = paramAnonymousa.getRawType();
        if ((localClass == this.a) || (localClass == paramClass1))
          return paramw;
        return null;
      }

      public String toString()
      {
        return "Factory[type=" + this.a.getName() + "+" + paramClass1.getName() + ",adapter=" + paramw + "]";
      }
    };
  }

  private static final class a<T extends Enum<T>> extends w<T>
  {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();

    public a(Class<T> paramClass)
    {
      try
      {
        for (Enum localEnum : (Enum[])paramClass.getEnumConstants())
        {
          String str1 = localEnum.name();
          com.google.d.a.c localc = (com.google.d.a.c)paramClass.getField(str1).getAnnotation(com.google.d.a.c.class);
          if (localc != null)
          {
            str1 = localc.a();
            for (String str2 : localc.b())
              this.a.put(str2, localEnum);
          }
          String str3 = str1;
          this.a.put(str3, localEnum);
          this.b.put(localEnum, str3);
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        throw new AssertionError(localNoSuchFieldException);
      }
    }

    public T a(com.google.d.d.a parama)
      throws IOException
    {
      if (parama.f() == b.i)
      {
        parama.j();
        return null;
      }
      return (Enum)this.a.get(parama.h());
    }

    public void a(com.google.d.d.c paramc, T paramT)
      throws IOException
    {
      if (paramT == null);
      for (String str = null; ; str = (String)this.b.get(paramT))
      {
        paramc.b(str);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.n
 * JD-Core Version:    0.6.2
 */