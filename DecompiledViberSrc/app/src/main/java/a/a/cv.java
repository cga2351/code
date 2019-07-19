package a.a;

import com.appboy.f.c;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class cv
  implements cy
{
  private static final String a = c.a(cv.class);
  private final cy b;
  private final d c;
  private boolean d = false;

  public cv(cy paramcy, d paramd)
  {
    this.b = paramcy;
    this.c = paramd;
  }

  private void a(d paramd, Throwable paramThrowable)
  {
    try
    {
      paramd.a(new x("A storage exception has occurred. Please view the stack trace for more details.", paramThrowable), x.class);
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to log throwable.", localException);
    }
  }

  public Collection<be> a()
  {
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not getting all events.");
      return Collections.emptyList();
    }
    try
    {
      Collection localCollection = this.b.a();
      return localCollection;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to get all events from storage.", localException);
      a(this.c, localException);
    }
    return Collections.emptyList();
  }

  public void a(be parambe)
  {
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not adding event: " + parambe);
      return;
    }
    try
    {
      this.b.a(parambe);
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to insert event into storage. " + parambe, localException);
      a(this.c, localException);
    }
  }

  public void a(List<be> paramList)
  {
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not adding events: " + paramList);
      return;
    }
    try
    {
      this.b.a(paramList);
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to insert events into storage. " + paramList, localException);
      a(this.c, localException);
    }
  }

  public void b()
  {
    c.d(a, "Setting this provider and internal storage provider to closed.");
    this.d = true;
    this.b.b();
  }

  public void b(List<be> paramList)
  {
    if (this.d)
    {
      c.d(a, "Storage provider is closed. Not deleting event: " + paramList);
      return;
    }
    try
    {
      this.b.b(paramList);
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to delete events from storage. " + paramList, localException);
      a(this.c, localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cv
 * JD-Core Version:    0.6.2
 */