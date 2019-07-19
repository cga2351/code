package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.b.c.a;
import com.appboy.c.b;
import com.appboy.f.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class cx
  implements cz<b>
{
  private static final String a = com.appboy.f.c.a(cx.class);
  private final SharedPreferences b;
  private final Set<String> c;
  private final Set<String> d;
  private final bc e = new ab();
  private ap f;

  public cx(Context paramContext, String paramString)
  {
    if (paramString == null);
    for (String str1 = ""; ; str1 = paramString)
    {
      String str2 = i.a(paramContext, str1);
      this.b = paramContext.getSharedPreferences("com.appboy.storage.feedstorageprovider" + str2, 0);
      this.c = a(a.b);
      this.d = a(a.a);
      f(paramString);
      return;
    }
  }

  private b a(JSONArray paramJSONArray, String paramString, boolean paramBoolean, long paramLong)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0));
    for (Object localObject = new ArrayList(); ; localObject = bd.a(paramJSONArray, new c.a(false), this.f, this, this.e))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.appboy.e.a.c localc = (com.appboy.e.a.c)localIterator.next();
        if (this.c.contains(localc.m()))
        {
          localc.c(true);
          localc.a(true);
        }
        if (this.d.contains(localc.m()))
          localc.a(true);
      }
    }
    return new b((List)localObject, paramString, paramBoolean, paramLong);
  }

  private Set<String> a(a parama)
  {
    String str1 = parama.a();
    String str2 = parama.b();
    if (this.b.contains(str2))
    {
      Set localSet = e(this.b.getString(str2, null));
      SharedPreferences.Editor localEditor = this.b.edit();
      localEditor.remove(str2);
      localEditor.apply();
      a(localSet, parama);
      return localSet;
    }
    return new ConcurrentSkipListSet(this.b.getStringSet(str1, new HashSet()));
  }

  static Set<String> a(JSONArray paramJSONArray)
  {
    HashSet localHashSet = new HashSet();
    if (paramJSONArray != null)
      for (int i = 0; i < paramJSONArray.length(); i++)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        if (localJSONObject.has(com.appboy.b.c.a.b()))
          localHashSet.add(localJSONObject.getString(com.appboy.b.c.a.b()));
      }
    return localHashSet;
  }

  private void a(JSONArray paramJSONArray, long paramLong)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
      localEditor.remove("cards");
    while (true)
    {
      localEditor.putLong("cards_timestamp", paramLong);
      localEditor.apply();
      return;
      localEditor.putString("cards", paramJSONArray.toString());
    }
  }

  static Set<String> e(String paramString)
  {
    HashSet localHashSet = new HashSet();
    if (paramString != null)
      Collections.addAll(localHashSet, paramString.split(";"));
    return localHashSet;
  }

  private void f(String paramString)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putString("uid", paramString);
    localEditor.apply();
  }

  public b a()
  {
    String str = this.b.getString("uid", "");
    return a(new JSONArray(this.b.getString("cards", "[]")), str, true, this.b.getLong("cards_timestamp", -1L));
  }

  public b a(JSONArray paramJSONArray, String paramString)
  {
    if (paramString == null);
    String str2;
    for (String str1 = ""; ; str1 = paramString)
    {
      str2 = this.b.getString("uid", "");
      if (!str2.equals(str1))
        break;
      com.appboy.f.c.c(a, "Updating offline feed for user with id: " + paramString);
      long l = di.a();
      a(paramJSONArray, l);
      this.c.retainAll(a(paramJSONArray));
      a(this.c, a.b);
      this.d.retainAll(a(paramJSONArray));
      a(this.d, a.a);
      return a(paramJSONArray, paramString, false, l);
    }
    com.appboy.f.c.c(a, "The received cards are for user " + paramString + " and the current user is " + str2 + " , the cards will be discarded and no changes will be made.");
    return null;
  }

  public void a(ap paramap)
  {
    this.f = paramap;
  }

  public void a(String paramString)
  {
    if (this.d.contains(paramString))
      return;
    this.d.add(paramString);
    a(this.d, a.a);
  }

  void a(Set<String> paramSet, a parama)
  {
    String str = parama.a();
    SharedPreferences.Editor localEditor = this.b.edit();
    if ((paramSet == null) || (paramSet.isEmpty()))
      localEditor.remove(str);
    while (true)
    {
      localEditor.apply();
      return;
      localEditor.putStringSet(str, paramSet);
    }
  }

  public void b(String paramString)
  {
    if (this.c.contains(paramString))
      return;
    this.c.add(paramString);
    a(this.c, a.b);
  }

  public void c(String paramString)
  {
  }

  public void d(String paramString)
  {
  }

  static enum a
  {
    private final String c;
    private final String d;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    private a(String paramString1, String paramString2)
    {
      this.c = paramString1;
      this.d = paramString2;
    }

    public String a()
    {
      return this.c;
    }

    public String b()
    {
      return this.d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cx
 * JD-Core Version:    0.6.2
 */