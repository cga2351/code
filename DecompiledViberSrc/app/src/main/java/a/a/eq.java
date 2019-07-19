package a.a;

import com.appboy.f.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public abstract class eq
  implements ee
{
  private static final String b = c.a(eq.class);
  protected List<ee> a;

  protected eq(List<ee> paramList)
  {
    this.a = paramList;
  }

  public JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((ee)localIterator.next()).h());
    }
    catch (Exception localException)
    {
      c.d(b, "Caught exception creating Json.", localException);
    }
    return localJSONArray;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.eq
 * JD-Core Version:    0.6.2
 */