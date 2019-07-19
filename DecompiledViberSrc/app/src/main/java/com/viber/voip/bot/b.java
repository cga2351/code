package com.viber.voip.bot;

import android.support.v4.util.LongSparseArray;
import com.viber.voip.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
{
  private static final b a = new b();
  private LongSparseArray<Integer> b = new LongSparseArray();
  private Map<String, Boolean> c = new HashMap();

  public static b a()
  {
    return a;
  }

  public Integer a(long paramLong)
  {
    return (Integer)this.b.get(paramLong);
  }

  public void a(long paramLong, int paramInt)
  {
    this.b.put(paramLong, Integer.valueOf(paramInt));
  }

  public void a(String paramString, Boolean paramBoolean)
  {
    this.c.put(paramString, paramBoolean);
  }

  public boolean a(String paramString)
  {
    Boolean localBoolean = (Boolean)this.c.get(paramString);
    return (localBoolean != null) && (localBoolean.booleanValue());
  }

  public LongSparseArray<Integer> b()
  {
    if (!u.a(this.b))
      return this.b.clone();
    return null;
  }

  public void b(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.c.keySet());
      int i = localArrayList.size();
      for (int j = 0; j < i; j++)
      {
        String str = (String)localArrayList.get(j);
        if (str.startsWith(paramString))
          this.c.remove(str);
      }
      return;
    }
    finally
    {
    }
  }

  public void c()
  {
    this.b.clear();
    this.c.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.b
 * JD-Core Version:    0.6.2
 */