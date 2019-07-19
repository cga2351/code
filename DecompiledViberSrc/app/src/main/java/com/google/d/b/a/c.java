package com.google.d.b.a;

import com.google.d.d.b;
import com.google.d.f;
import com.google.d.u;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class c extends w<Date>
{
  public static final x a = new x()
  {
    public <T> w<T> a(f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == Date.class)
        return new c();
      return null;
    }
  };
  private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);

  private Date a(String paramString)
  {
    try
    {
      Date localDate3 = this.c.parse(paramString);
      localObject2 = localDate3;
      return localObject2;
    }
    catch (ParseException localParseException1)
    {
      try
      {
        Date localDate2 = this.b.parse(paramString);
        localObject2 = localDate2;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          Date localDate1 = com.google.d.b.a.a.a.a(paramString, new ParsePosition(0));
          Object localObject2 = localDate1;
        }
        catch (ParseException localParseException3)
        {
          throw new u(paramString, localParseException3);
        }
      }
    }
    finally
    {
    }
  }

  public Date a(com.google.d.d.a parama)
    throws IOException
  {
    if (parama.f() == b.i)
    {
      parama.j();
      return null;
    }
    return a(parama.h());
  }

  public void a(com.google.d.d.c paramc, Date paramDate)
    throws IOException
  {
    if (paramDate == null);
    try
    {
      paramc.f();
      while (true)
      {
        return;
        paramc.b(this.b.format(paramDate));
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.c
 * JD-Core Version:    0.6.2
 */