package com.google.d.b.a;

import com.google.d.d.b;
import com.google.d.d.c;
import com.google.d.f;
import com.google.d.u;
import com.google.d.w;
import com.google.d.x;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class k extends w<Time>
{
  public static final x a = new x()
  {
    public <T> w<T> a(f paramAnonymousf, com.google.d.c.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == Time.class)
        return new k();
      return null;
    }
  };
  private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

  public Time a(com.google.d.d.a parama)
    throws IOException
  {
    try
    {
      Time localTime;
      if (parama.f() == b.i)
      {
        parama.j();
        localTime = null;
      }
      while (true)
      {
        return localTime;
        try
        {
          localTime = new Time(this.b.parse(parama.h()).getTime());
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

  public void a(c paramc, Time paramTime)
    throws IOException
  {
    Object localObject2;
    if (paramTime == null)
      localObject2 = null;
    try
    {
      while (true)
      {
        paramc.b((String)localObject2);
        return;
        String str = this.b.format(paramTime);
        localObject2 = str;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.k
 * JD-Core Version:    0.6.2
 */