package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.appboy.f.a;
import com.appboy.f.c;
import com.appboy.f.f;
import com.appboy.f.i;
import com.appboy.f.k;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class fn
  implements fj
{
  private static final String a = c.a(fn.class);
  private final Context b;
  private final SharedPreferences c;
  private Map<String, String> d;
  private Map<String, String> e = new HashMap();

  public fn(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = paramContext.getSharedPreferences("com.appboy.storage.triggers.local_assets." + paramString, 0);
    this.d = a();
  }

  public static void a(Context paramContext)
  {
    File localFile = new File(paramContext.getCacheDir(), "ab_triggers");
    c.a(a, "Deleting triggers directory at: " + localFile.getAbsolutePath());
    a.a(localFile);
  }

  private static void a(List<dy> paramList, Set<fq> paramSet, Set<String> paramSet1)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      dy localdy = (dy)localIterator.next();
      fq localfq = localdy.d();
      if ((localfq != null) && (!i.c(localfq.b())))
        if (localdy.a())
        {
          c.b(a, "Received new remote path for triggered action " + localdy.b() + " at " + localfq.b() + ".");
          paramSet.add(localfq);
          paramSet1.add(localfq.b());
        }
        else
        {
          c.b(a, "Pre-fetch off for triggered action " + localdy.b() + ". Not pre-fetching assets at remote path " + localfq.b() + ".");
        }
    }
  }

  private static void a(Set<String> paramSet, SharedPreferences.Editor paramEditor, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    Iterator localIterator = new HashSet(paramMap1.keySet()).iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (paramMap2.containsKey(str1))
      {
        c.b(a, "Not removing local path for remote path " + str1 + " from cache because it is being preserved until the end of the app run.");
      }
      else if (!paramSet.contains(str1))
      {
        String str2 = (String)paramMap1.get(str1);
        paramMap1.remove(str1);
        paramEditor.remove(str1);
        if (!i.c(str2))
        {
          c.b(a, "Removing obsolete local path " + str2 + " for obsolete remote path " + str1 + " from cache.");
          a.a(new File(str2));
        }
      }
    }
    paramEditor.apply();
  }

  private void c()
  {
    while (true)
    {
      int j;
      String str;
      try
      {
        File[] arrayOfFile = b().listFiles();
        if (arrayOfFile != null)
        {
          int i = arrayOfFile.length;
          j = 0;
          if (j < i)
          {
            File localFile = arrayOfFile[j];
            str = localFile.getPath();
            if (this.d.containsValue(str))
              break label154;
            if (!this.e.containsValue(str))
            {
              c.b(a, "Deleting obsolete asset " + str + " from filesystem.");
              a.a(localFile);
            }
            else
            {
              c.b(a, "Asset " + str + " is being preserved. Not deleting.");
            }
          }
        }
      }
      catch (Exception localException)
      {
        c.a(a, "Exception while deleting obsolete assets from filesystem.", localException);
      }
      return;
      label154: c.b(a, "Asset " + str + " is not obsolete. Not deleting.");
      j++;
    }
  }

  public String a(dy paramdy)
  {
    if (!paramdy.a())
    {
      c.b(a, "Prefetch turned off for this triggered action. Not retrieving local asset path.");
      return null;
    }
    fq localfq = paramdy.d();
    if (localfq == null)
    {
      c.c(a, "Remote path was null or blank. Not retrieving local asset path.");
      return null;
    }
    String str1 = localfq.b();
    if (i.c(str1))
    {
      c.d(a, "Remote asset path string was null or blank. Not retrieving local asset path.");
      return null;
    }
    if (this.d.containsKey(str1))
    {
      String str2 = (String)this.d.get(str1);
      if (!new File(str2).exists())
      {
        c.d(a, "Local asset for remote asset path did not exist: " + str1);
        return null;
      }
      c.c(a, "Retrieving local asset path for remote asset path: " + str1);
      this.e.put(str1, str2);
      return str2;
    }
    c.d(a, "No local asset path found for remote asset path: " + str1);
    return null;
  }

  String a(fq paramfq)
  {
    File localFile1 = b();
    String str1 = paramfq.b();
    if (paramfq.a().equals(ex.a))
    {
      String str3 = k.a(localFile1, str1);
      if (!i.c(str3))
      {
        c.c(a, "Storing local triggered action html zip asset at local path " + str3 + " for remote path " + str1);
        return str3;
      }
      c.b(a, "Failed to store html zip asset for remote path " + str1 + ". Not storing local asset");
      return null;
    }
    String str2 = Integer.toString(f.a());
    File localFile2 = a.a(localFile1.toString(), str1, str2, null);
    if (localFile2 != null)
    {
      Uri localUri = Uri.fromFile(localFile2);
      if (localUri != null)
      {
        c.c(a, "Storing local triggered action image asset at local path " + localUri.getPath() + " for remote path " + str1);
        return localUri.getPath();
      }
      c.b(a, "Failed to store image asset for remote path " + str1 + ". Not storing local asset");
      return null;
    }
    return null;
  }

  Map<String, String> a()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Map localMap = this.c.getAll();
    if ((localMap == null) || (localMap.size() == 0))
      return localConcurrentHashMap;
    Set localSet = localMap.keySet();
    if ((localSet == null) || (localSet.size() == 0))
      return localConcurrentHashMap;
    try
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = this.c.getString(str1, null);
        if (!i.c(str2))
        {
          c.b(a, "Retrieving trigger local asset path " + str2 + " from local storage for remote path " + str1 + ".");
          localConcurrentHashMap.put(str1, str2);
        }
      }
    }
    catch (Exception localException)
    {
      c.d(a, "Encountered unexpected exception while parsing stored triggered action local assets.", localException);
    }
    return localConcurrentHashMap;
  }

  public void a(List<dy> paramList)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    a(paramList, localHashSet1, localHashSet2);
    SharedPreferences.Editor localEditor = this.c.edit();
    a(localHashSet2, localEditor, this.d, this.e);
    c();
    Iterator localIterator = localHashSet1.iterator();
    while (localIterator.hasNext())
    {
      fq localfq = (fq)localIterator.next();
      String str1 = localfq.b();
      if (this.d.containsKey(str1))
        c.b(a, "Local assets already contains remote path string: " + str1);
      else
        try
        {
          String str2 = a(localfq);
          if (!i.c(str2))
          {
            c.b(a, "Adding new local path " + str2 + " for remote path " + str1 + " to cache.");
            this.d.put(str1, str2);
            localEditor.putString(str1, str2);
            localEditor.apply();
          }
        }
        catch (Exception localException)
        {
          c.d(a, "Failed to add new local path for remote path " + str1, localException);
        }
    }
  }

  File b()
  {
    return new File(this.b.getCacheDir().getPath() + "/" + "ab_triggers");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fn
 * JD-Core Version:    0.6.2
 */