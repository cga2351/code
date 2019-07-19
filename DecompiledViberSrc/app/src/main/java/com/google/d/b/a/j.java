package com.google.d.b.a;

import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.f;
import com.google.d.u;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class j extends w<java.sql.Date>
{
  public static final x a = new x()
  {
    public <T> w<T> a(f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == java.sql.Date.class)
        return new j();
      return null;
    }
  };
  private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

  public java.sql.Date a(com.google.d.d.a parama)
    throws IOException
  {
    try
    {
      java.sql.Date localDate;
      if (parama.f() == b.i)
      {
        parama.j();
        localDate = null;
      }
      while (true)
      {
        return localDate;
        try
        {
          localDate = new java.sql.Date(this.b.parse(parama.h()).getTime());
        }
        catch (ParseException localParseException)
        {
          throw new u(localParseException);
        }
      }
    }
    finally
    {
    }
  }

  public void a(c paramc, java.sql.Date paramDate)
    throws IOException
  {
    Object localObject2;
    if (paramDate == null)
      localObject2 = null;
    try
    {
      while (true)
      {
        paramc.b((String)localObject2);
        return;
        String str = this.b.format(paramDate);
        localObject2 = str;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.j
 * JD-Core Version:    0.6.2
 */