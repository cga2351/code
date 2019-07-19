package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.b.c.a;
import com.appboy.f.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ct
  implements cz<com.appboy.c.a>
{
  private static final String a = com.appboy.f.c.a(ct.class);
  private static final Set<String> b = new HashSet();
  private final SharedPreferences c;
  private final SharedPreferences d;
  private final bc e;
  private final String f;
  private ap g;

  static
  {
    b.add(com.appboy.b.c.b.a());
    b.add(com.appboy.b.c.j.a());
  }

  public ct(Context paramContext, String paramString1, String paramString2)
  {
    this.f = paramString1;
    String str = i.a(paramContext, paramString1, paramString2);
    this.d = paramContext.getSharedPreferences("com.appboy.storage.content_cards_storage_provider.metadata" + str, 0);
    this.c = paramContext.getSharedPreferences("com.appboy.storage.content_cards_storage_provider.cards" + str, 0);
    this.e = new a();
  }

  static boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject2 == null);
    String str;
    do
    {
      return true;
      if (paramJSONObject1 == null)
        return false;
      str = com.appboy.b.c.c.a();
    }
    while ((paramJSONObject1.has(str)) && (paramJSONObject2.has(str)) && (paramJSONObject1.getLong(str) > paramJSONObject2.getLong(str)));
    return false;
  }

  static JSONObject b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1 == null)
      return paramJSONObject2;
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator1 = paramJSONObject1.keys();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      localJSONObject.put(str2, paramJSONObject1.get(str2));
    }
    Iterator localIterator2 = paramJSONObject2.keys();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      if (b.contains(str1))
      {
        boolean bool1 = paramJSONObject1.getBoolean(str1);
        boolean bool2 = paramJSONObject2.getBoolean(str1);
        if ((bool1) || (bool2));
        for (boolean bool3 = true; ; bool3 = false)
        {
          localJSONObject.put(str1, bool3);
          break;
        }
      }
      localJSONObject.put(str1, paramJSONObject2.get(str1));
    }
    return localJSONObject;
  }

  private void e()
  {
    SharedPreferences.Editor localEditor = this.d.edit();
    localEditor.putLong("last_storage_update_timestamp", di.a());
    localEditor.apply();
  }

  private long f()
  {
    return this.d.getLong("last_storage_update_timestamp", 0L);
  }

  public com.appboy.c.a a()
  {
    return a(true);
  }

  public com.appboy.c.a a(bv parambv, String paramString)
  {
    if (paramString == null)
    {
      com.appboy.f.c.b(a, "Input user id was null. Defaulting to the empty user id");
      paramString = "";
    }
    if (!this.f.equals(paramString))
    {
      com.appboy.f.c.c(a, "The received cards are for user " + paramString + " and the current user is " + this.f + " , the cards will be discarded and no changes will be made.");
      return null;
    }
    com.appboy.f.c.c(a, "Updating offline Content Cards for user with id: " + paramString);
    a(parambv);
    e();
    HashSet localHashSet = new HashSet();
    JSONArray localJSONArray = parambv.d();
    if ((localJSONArray != null) && (localJSONArray.length() != 0))
    {
      Set localSet = d();
      int i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject1 = localJSONArray.getJSONObject(i);
        String str = localJSONObject1.getString(com.appboy.b.c.a.a());
        JSONObject localJSONObject2 = e(str);
        if (a(localJSONObject2, localJSONObject1))
        {
          com.appboy.f.c.c(a, "The server card received is older than the cached card. Discarding the server card.");
          com.appboy.f.c.b(a, "Server card json: " + localJSONObject1.toString());
          com.appboy.f.c.b(a, "Cached card json: " + localJSONObject1.toString());
        }
        while (true)
        {
          i++;
          break;
          localHashSet.add(str);
          if ((localJSONObject1.has(com.appboy.b.c.k.a())) && (localJSONObject1.getBoolean(com.appboy.b.c.k.a())))
          {
            com.appboy.f.c.b(a, "Server card is marked as removed. Removing from card storage with id: " + str);
            g(str);
            a(str, null);
          }
          else if (localSet.contains(str))
          {
            com.appboy.f.c.b(a, "Server card was locally dismissed already. Not adding card to storage. Server card: " + localJSONObject1);
          }
          else if ((localJSONObject1.has(com.appboy.b.c.j.a())) && (localJSONObject1.getBoolean(com.appboy.b.c.j.a())))
          {
            com.appboy.f.c.b(a, "Server card is marked as dismissed. Adding to dismissed cached and removing from card storage with id: " + str);
            f(str);
            a(str, null);
          }
          else
          {
            a(str, b(localJSONObject2, localJSONObject1));
          }
        }
      }
    }
    if (parambv.c())
    {
      a(localHashSet);
      b(localHashSet);
    }
    return a(false);
  }

  com.appboy.c.a a(boolean paramBoolean)
  {
    c.a locala = new c.a(true);
    Map localMap = this.c.getAll();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator1 = localMap.values().iterator();
    while (localIterator1.hasNext())
      localJSONArray.put((String)localIterator1.next());
    List localList = bd.a(localJSONArray, locala, this.g, this, this.e);
    Iterator localIterator2 = localList.iterator();
    while (localIterator2.hasNext())
    {
      com.appboy.e.a.c localc = (com.appboy.e.a.c)localIterator2.next();
      if (localc.t())
      {
        com.appboy.f.c.b(a, "Deleting expired card from storage with id: " + localc.m());
        a(localc.m(), null);
        localIterator2.remove();
      }
    }
    return new com.appboy.c.a(localList, this.f, f(), paramBoolean);
  }

  public void a(ap paramap)
  {
    this.g = paramap;
  }

  void a(bv parambv)
  {
    SharedPreferences.Editor localEditor = this.d.edit();
    if (parambv.b() != -1L)
      localEditor.putLong("last_card_updated_at", parambv.b());
    if (parambv.a() != -1L)
      localEditor.putLong("last_full_sync_at", parambv.a());
    localEditor.apply();
  }

  public void a(String paramString)
  {
    a(paramString, com.appboy.b.c.n, true);
  }

  void a(String paramString, com.appboy.b.c paramc, boolean paramBoolean)
  {
    JSONObject localJSONObject = e(paramString);
    if (localJSONObject == null)
    {
      com.appboy.f.c.b(a, "Can't update card field. Json cannot be parsed from disk or is not present. Id: " + paramString);
      return;
    }
    try
    {
      localJSONObject.put(paramc.a(), paramBoolean);
      a(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      com.appboy.f.c.d(a, "Failed to update card json field to " + paramBoolean + " with key: " + paramc, localJSONException);
    }
  }

  void a(String paramString, JSONObject paramJSONObject)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    if (paramJSONObject != null)
      localEditor.putString(paramString, paramJSONObject.toString());
    while (true)
    {
      localEditor.apply();
      return;
      localEditor.remove(paramString);
    }
  }

  void a(Set<String> paramSet)
  {
    Set localSet = d();
    localSet.retainAll(paramSet);
    this.d.edit().putStringSet("dismissed", localSet).apply();
  }

  public long b()
  {
    return this.d.getLong("last_card_updated_at", 0L);
  }

  public void b(String paramString)
  {
    a(paramString, com.appboy.b.c.b, true);
  }

  void b(Set<String> paramSet)
  {
    Set localSet = this.c.getAll().keySet();
    SharedPreferences.Editor localEditor = this.c.edit();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramSet.contains(str))
      {
        com.appboy.f.c.b(a, "Removing card from storage with id: " + str);
        localEditor.remove(str);
      }
    }
    localEditor.apply();
  }

  public long c()
  {
    return this.d.getLong("last_full_sync_at", 0L);
  }

  public void c(String paramString)
  {
    a(paramString, com.appboy.b.c.o, true);
  }

  Set<String> d()
  {
    return new HashSet(this.d.getStringSet("dismissed", new HashSet()));
  }

  public void d(String paramString)
  {
    f(paramString);
    a(paramString, null);
  }

  JSONObject e(String paramString)
  {
    String str = this.c.getString(paramString, null);
    if (str == null)
    {
      com.appboy.f.c.b(a, "Card not present in storage for id: " + paramString);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      com.appboy.f.c.d(a, "Failed to read card json from storage. Json: " + str, localJSONException);
    }
    return null;
  }

  void f(String paramString)
  {
    Set localSet = d();
    localSet.add(paramString);
    this.d.edit().putStringSet("dismissed", localSet).apply();
  }

  void g(String paramString)
  {
    Set localSet = d();
    localSet.remove(paramString);
    this.d.edit().putStringSet("dismissed", localSet).apply();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ct
 * JD-Core Version:    0.6.2
 */