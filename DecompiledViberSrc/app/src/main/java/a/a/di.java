package a.a;

import com.appboy.f.c;
import com.appboy.f.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public final class di
{
  private static final String a = c.a(di.class);
  private static final TimeZone b = TimeZone.getTimeZone("UTC");
  private static final EnumSet<gr> c = EnumSet.of(gr.a, gr.b, gr.c);

  public static long a()
  {
    return System.currentTimeMillis() / 1000L;
  }

  public static long a(Date paramDate)
  {
    return paramDate.getTime() / 1000L;
  }

  public static String a(Date paramDate, gr paramgr)
  {
    if (!c.contains(paramgr))
    {
      c.d(a, "Unsupported date format: " + paramgr + ". Defaulting to " + gr.b);
      paramgr = gr.b;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramgr.a(), Locale.US);
    localSimpleDateFormat.setTimeZone(b);
    return localSimpleDateFormat.format(paramDate);
  }

  public static Date a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3, 0, 0, 0);
  }

  public static Date a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    localGregorianCalendar.setTimeZone(b);
    return localGregorianCalendar.getTime();
  }

  public static Date a(long paramLong)
  {
    return new Date(1000L * paramLong);
  }

  public static Date a(String paramString, gr paramgr)
  {
    if (i.c(paramString))
    {
      c.d(a, "Null or blank date string received: " + paramString);
      return null;
    }
    if (!c.contains(paramgr))
    {
      c.d(a, "Unsupported date format. Returning null. Got date format: " + paramgr);
      return null;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramgr.a(), Locale.US);
    localSimpleDateFormat.setTimeZone(b);
    try
    {
      Date localDate = localSimpleDateFormat.parse(paramString);
      return localDate;
    }
    catch (Exception localException)
    {
      c.d(a, "Exception parsing date " + paramString + ". Returning null", localException);
    }
    return null;
  }

  public static double b()
  {
    return System.currentTimeMillis() / 1000.0D;
  }

  public static long c()
  {
    return System.currentTimeMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.di
 * JD-Core Version:    0.6.2
 */