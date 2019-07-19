package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;

public class df
  implements cy
{
  private static final String a = c.a(df.class);
  private boolean b = false;
  private final SharedPreferences c;

  public df(Context paramContext, String paramString1, String paramString2)
  {
    this.c = paramContext.getSharedPreferences("com.appboy.storage.appboy_event_storage" + i.a(paramContext, paramString1, paramString2), 0);
  }

  public Collection<be> a()
  {
    if (this.b)
    {
      c.d(a, "Storage provider is closed. Not getting all events.");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      String str2 = (String)localEntry.getValue();
      try
      {
        localArrayList.add(bp.d(str2, str1));
      }
      catch (JSONException localJSONException)
      {
        c.e(a, "Could not create AppboyEvent from [serialized event string=" + str2 + ", unique identifier=" + str1 + "] ... Deleting!");
        a(str1);
      }
    }
    return localArrayList;
  }

  public void a(be parambe)
  {
    if (this.b)
    {
      c.d(a, "Storage provider is closed. Not adding event: " + parambe);
      return;
    }
    SharedPreferences.Editor localEditor = this.c.edit();
    c.a(a, "Adding event to storage with uid " + parambe.d(), false);
    localEditor.putString(parambe.d(), parambe.e());
    localEditor.apply();
  }

  void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }

  public void a(List<be> paramList)
  {
    if (this.b)
    {
      c.d(a, "Storage provider is closed. Not adding events: " + paramList);
      return;
    }
    SharedPreferences.Editor localEditor = this.c.edit();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      be localbe = (be)localIterator.next();
      c.a(a, "Adding event to storage with uid " + localbe.d(), false);
      localEditor.putString(localbe.d(), localbe.e());
    }
    localEditor.apply();
  }

  public void b()
  {
    c.d(a, "Setting this provider to closed.");
    this.b = true;
  }

  public void b(List<be> paramList)
  {
    if (this.b)
    {
      c.d(a, "Storage provider is closed. Not deleting events: " + paramList);
      return;
    }
    SharedPreferences.Editor localEditor = this.c.edit();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((be)localIterator.next()).d();
      c.a(a, "Deleting event from storage with uid " + str, false);
      localEditor.remove(str);
    }
    localEditor.apply();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.df
 * JD-Core Version:    0.6.2
 */