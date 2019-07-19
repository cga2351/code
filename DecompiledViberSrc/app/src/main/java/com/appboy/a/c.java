package com.appboy.a;

import a.a.gj;
import android.content.Context;
import android.content.res.Resources;
import com.appboy.f.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class c
{
  private static final String c = com.appboy.f.c.a(c.class);
  protected final Map<String, Object> a;
  protected final gj b;
  private final Context d;

  public c(Context paramContext)
  {
    this.d = paramContext;
    this.a = Collections.synchronizedMap(new HashMap());
    this.b = new gj(paramContext);
  }

  protected int a(String paramString, int paramInt)
  {
    if (this.a.containsKey(paramString))
      return ((Integer)this.a.get(paramString)).intValue();
    if (this.b.a(paramString))
    {
      int j = this.b.a(paramString, paramInt);
      this.a.put(paramString, Integer.valueOf(j));
      com.appboy.f.c.b(c, "Using runtime override value for key: " + paramString + " and value: " + j);
      return j;
    }
    int i = b(paramString, paramInt);
    this.a.put(paramString, Integer.valueOf(i));
    com.appboy.f.c.b(c, "Defaulting to using xml value for key: " + paramString + " and value: " + i);
    return i;
  }

  protected String a(String paramString1, String paramString2)
  {
    if (this.a.containsKey(paramString1))
      return (String)this.a.get(paramString1);
    if (this.b.a(paramString1))
    {
      String str2 = this.b.a(paramString1, paramString2);
      this.a.put(paramString1, str2);
      com.appboy.f.c.b(c, "Using runtime override value for key: " + paramString1 + " and value: " + str2);
      return str2;
    }
    String str1 = b(paramString1, paramString2);
    this.a.put(paramString1, str1);
    com.appboy.f.c.b(c, "Defaulting to using xml value for key: " + paramString1 + " and value: " + str1);
    return str1;
  }

  protected Set<String> a(String paramString, Set<String> paramSet)
  {
    if (this.a.containsKey(paramString))
      return (Set)this.a.get(paramString);
    if (this.b.a(paramString))
    {
      Set localSet = this.b.a(paramString, paramSet);
      this.a.put(paramString, localSet);
      com.appboy.f.c.b(c, "Using runtime override value for key: " + paramString + " and value: " + localSet);
      return localSet;
    }
    String[] arrayOfString = a(paramString, new String[0]);
    if (arrayOfString.length == 0);
    while (true)
    {
      this.a.put(paramString, paramSet);
      com.appboy.f.c.b(c, "Defaulting to using xml value for key: " + paramString + " and value: " + paramSet);
      return paramSet;
      paramSet = new HashSet(Arrays.asList(arrayOfString));
    }
  }

  protected boolean a(String paramString, boolean paramBoolean)
  {
    if (this.a.containsKey(paramString))
      return ((Boolean)this.a.get(paramString)).booleanValue();
    if (this.b.a(paramString))
    {
      boolean bool2 = this.b.a(paramString, paramBoolean);
      this.a.put(paramString, Boolean.valueOf(bool2));
      com.appboy.f.c.b(c, "Using runtime override value for key: " + paramString + " and value: " + bool2);
      return bool2;
    }
    boolean bool1 = b(paramString, paramBoolean);
    this.a.put(paramString, Boolean.valueOf(bool1));
    com.appboy.f.c.b(c, "Defaulting to using xml value for key: " + paramString + " and value: " + bool1);
    return bool1;
  }

  protected String[] a(String paramString, String[] paramArrayOfString)
  {
    if (paramString == null)
      return paramArrayOfString;
    int i;
    try
    {
      i = this.d.getResources().getIdentifier(paramString, "array", g.a(this.d));
      if (i == 0)
      {
        com.appboy.f.c.b(c, "Unable to find the xml string array configuration value with key " + paramString + ". Using default value '" + Arrays.toString(paramArrayOfString) + "'.");
        return paramArrayOfString;
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.b(c, "Unexpected exception retrieving the xml string array configuration value with key " + paramString + ". Using default value " + Arrays.toString(paramArrayOfString) + "'.");
      return paramArrayOfString;
    }
    String[] arrayOfString = this.d.getResources().getStringArray(i);
    return arrayOfString;
  }

  protected int b(String paramString, int paramInt)
  {
    if (paramString == null)
      return paramInt;
    int i;
    try
    {
      i = this.d.getResources().getIdentifier(paramString, "integer", g.a(this.d));
      if (i == 0)
      {
        com.appboy.f.c.b(c, "Unable to find the xml integer configuration value with key " + paramString + ". Using default value '" + paramInt + "'.");
        return paramInt;
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.b(c, "Unexpected exception retrieving the xml integer configuration value with key " + paramString + ". Using default value " + paramInt + "'.");
      return paramInt;
    }
    int j = this.d.getResources().getInteger(i);
    return j;
  }

  protected String b(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return paramString2;
    int i;
    try
    {
      i = this.d.getResources().getIdentifier(paramString1, "string", g.a(this.d));
      if (i == 0)
      {
        com.appboy.f.c.b(c, "Unable to find the xml string configuration value with key " + paramString1 + ". Using default value '" + paramString2 + "'.");
        return paramString2;
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.b(c, "Unexpected exception retrieving the xml string configuration value with key " + paramString1 + ". Using default value " + paramString2 + "'.");
      return paramString2;
    }
    String str = this.d.getResources().getString(i);
    return str;
  }

  protected boolean b(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      return paramBoolean;
    int i;
    try
    {
      i = this.d.getResources().getIdentifier(paramString, "bool", g.a(this.d));
      if (i == 0)
      {
        com.appboy.f.c.b(c, "Unable to find the xml boolean configuration value with key " + paramString + ". Using default value '" + paramBoolean + "'.");
        return paramBoolean;
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.b(c, "Unexpected exception retrieving the xml boolean configuration value with key " + paramString + ". Using default value " + paramBoolean + "'.");
      return paramBoolean;
    }
    boolean bool = this.d.getResources().getBoolean(i);
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.a.c
 * JD-Core Version:    0.6.2
 */