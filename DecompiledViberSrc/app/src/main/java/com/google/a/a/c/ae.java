package com.google.a.a.c;

import com.google.a.a.f.a.a;
import com.google.a.a.f.af;
import com.google.a.a.f.ag;
import com.google.a.a.f.b;
import com.google.a.a.f.g;
import com.google.a.a.f.h;
import com.google.a.a.f.i;
import com.google.a.a.f.m;
import com.google.a.a.f.n;
import com.google.a.a.f.x;
import com.google.a.a.f.z;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ae
  implements x
{
  public static final String a = new o("application/x-www-form-urlencoded").a(g.a).c();

  private static Object a(Type paramType, List<Type> paramList, String paramString)
  {
    return i.a(i.a(paramList, paramType), paramString);
  }

  public static void a(Reader paramReader, Object paramObject)
    throws IOException
  {
    Class localClass1 = paramObject.getClass();
    h localh = h.a(localClass1);
    List localList = Arrays.asList(new Type[] { localClass1 });
    n localn;
    Map localMap;
    b localb;
    StringWriter localStringWriter3;
    StringWriter localStringWriter4;
    int i;
    if (n.class.isAssignableFrom(localClass1))
    {
      localn = (n)paramObject;
      if (!Map.class.isAssignableFrom(localClass1))
        break label157;
      localMap = (Map)paramObject;
      localb = new b(paramObject);
      StringWriter localStringWriter1 = new StringWriter();
      StringWriter localStringWriter2 = new StringWriter();
      localStringWriter3 = localStringWriter1;
      localStringWriter4 = localStringWriter2;
      i = 1;
    }
    while (true)
    {
      int j = paramReader.read();
      switch (j)
      {
      default:
        if (i != 0)
        {
          localStringWriter3.write(j);
          continue;
          localn = null;
          break;
          localMap = null;
        }
        break;
      case -1:
      case 38:
        String str1 = a.b(localStringWriter3.toString());
        String str2;
        m localm;
        if (str1.length() != 0)
        {
          str2 = a.b(localStringWriter4.toString());
          localm = localh.a(str1);
          if (localm == null)
            break label391;
          localType1 = i.a(localList, localm.d());
          if (!ag.a(localType1))
            break label287;
          localClass2 = ag.a(localList, ag.b(localType1));
          localb.a(localm.a(), localClass2, a(localClass2, localList, str2));
        }
        while (localMap == null)
          while (true)
          {
            Type localType1;
            Class localClass2;
            localStringWriter3 = new StringWriter();
            localStringWriter4 = new StringWriter();
            if (j != -1)
              break;
            localb.a();
            return;
            if (ag.a(ag.a(localList, localType1), Iterable.class))
            {
              Collection localCollection = (Collection)localm.a(paramObject);
              if (localCollection == null)
              {
                localCollection = i.b(localType1);
                localm.a(paramObject, localCollection);
              }
              if (localType1 == Object.class);
              for (Type localType2 = null; ; localType2 = ag.c(localType1))
              {
                localCollection.add(a(localType2, localList, str2));
                break;
              }
            }
            localm.a(paramObject, a(localType1, localList, str2));
          }
        ArrayList localArrayList = (ArrayList)localMap.get(str1);
        if (localArrayList == null)
        {
          localArrayList = new ArrayList();
          if (localn == null)
            break label450;
          localn.c(str1, localArrayList);
        }
        while (true)
        {
          localArrayList.add(str2);
          break;
          localMap.put(str1, localArrayList);
        }
      case 61:
        label157: label287: label450: i = 0;
        label391: continue;
        localStringWriter4.write(j);
        continue;
        i = 1;
      }
    }
  }

  public static void a(String paramString, Object paramObject)
  {
    if (paramString == null)
      return;
    try
    {
      a(new StringReader(paramString), paramObject);
      return;
    }
    catch (IOException localIOException)
    {
      throw af.a(localIOException);
    }
  }

  public <T> T a(InputStream paramInputStream, Charset paramCharset, Class<T> paramClass)
    throws IOException
  {
    return a(new InputStreamReader(paramInputStream, paramCharset), paramClass);
  }

  public <T> T a(Reader paramReader, Class<T> paramClass)
    throws IOException
  {
    return a(paramReader, paramClass);
  }

  public Object a(Reader paramReader, Type paramType)
    throws IOException
  {
    z.a(paramType instanceof Class, "dataType has to be of type Class<?>");
    Object localObject = ag.a((Class)paramType);
    a(new BufferedReader(paramReader), localObject);
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.ae
 * JD-Core Version:    0.6.2
 */