package c.b.a.a.a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class c
{
  private a<String, Pattern> a;

  public c(int paramInt)
  {
    this.a = new a(paramInt);
  }

  public Pattern a(String paramString)
  {
    Pattern localPattern = (Pattern)this.a.a(paramString);
    if (localPattern == null)
    {
      localPattern = Pattern.compile(paramString);
      this.a.a(paramString, localPattern);
    }
    return localPattern;
  }

  private static class a<K, V>
  {
    private LinkedHashMap<K, V> a;
    private int b;

    public a(int paramInt)
    {
      this.b = paramInt;
      this.a = new LinkedHashMap(1 + paramInt * 4 / 3, 0.75F, true)
      {
        protected boolean removeEldestEntry(Map.Entry<K, V> paramAnonymousEntry)
        {
          return size() > c.a.a(c.a.this);
        }
      };
    }

    public V a(K paramK)
    {
      try
      {
        Object localObject2 = this.a.get(paramK);
        return localObject2;
      }
      finally
      {
        localObject1 = finally;
        throw localObject1;
      }
    }

    public void a(K paramK, V paramV)
    {
      try
      {
        this.a.put(paramK, paramV);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.a.c
 * JD-Core Version:    0.6.2
 */