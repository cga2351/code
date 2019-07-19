package a.a;

import com.appboy.f.c;
import com.appboy.f.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ba
{
  private static final String a = c.a(ba.class);
  private final List<String> b = new ArrayList(32);
  private long c;
  private boolean d = false;
  private final Object e = new Object();
  private au f;

  static String b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (i.c(paramString1));
    while ((i.c(paramString2)) && ((paramThrowable == null) || (i.c(paramThrowable.getMessage()))))
      return null;
    String str = c() + " " + paramString1;
    if (paramString2 != null)
      str = str + ": " + paramString2;
    if (paramThrowable != null)
      str = str + ": " + paramThrowable.getMessage();
    return str.substring(0, Math.min(str.length(), 1000));
  }

  private static String c()
  {
    return di.a(new Date(), gr.c);
  }

  private boolean d()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length == 0))
      return true;
    StackTraceElement localStackTraceElement1 = arrayOfStackTraceElement[1];
    String str1 = localStackTraceElement1.getMethodName();
    String str2 = localStackTraceElement1.getClassName();
    int i = arrayOfStackTraceElement.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      StackTraceElement localStackTraceElement2 = arrayOfStackTraceElement[j];
      if ((localStackTraceElement2.getClassName().equals(str2)) && (localStackTraceElement2.getMethodName().equals(str1)))
        k++;
      j++;
    }
    return k != 1;
  }

  public void a(au paramau)
  {
    this.f = paramau;
  }

  public void a(by paramby)
  {
    a(paramby.k());
  }

  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!this.d);
    while (((paramString2 != null) && ((paramString2.contains("device_logs")) || (paramString2.contains("test_user_data")))) || (d()))
      return;
    synchronized (this.e)
    {
      if (this.b.size() >= 32)
        b();
      if ((this.b.isEmpty()) || (this.c == 0L))
        this.c = di.a();
      String str = b(paramString1, paramString2, paramThrowable);
      if (str != null)
        this.b.add(str);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.e;
    if (!paramBoolean);
    try
    {
      this.b.clear();
      while (true)
      {
        this.d = paramBoolean;
        return;
        c.b(a, "Test user device logging is enabled.", false);
      }
    }
    finally
    {
    }
  }

  public boolean a()
  {
    return this.d;
  }

  void b()
  {
    ArrayList localArrayList;
    synchronized (this.e)
    {
      if (this.f == null)
        break label82;
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext())
        localArrayList.add((String)localIterator.next());
    }
    this.f.a(localArrayList, this.c);
    label82: this.b.clear();
    this.c = 0L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ba
 * JD-Core Version:    0.6.2
 */