package com.e.a.d;

import e.a.b.d;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class e
{
  public static long a(d paramd, String paramString)
    throws ParseException
  {
    return ((Number)a(paramd, paramString, Number.class)).longValue();
  }

  public static d a(String paramString)
    throws ParseException
  {
    try
    {
      Object localObject = new e.a.b.b.a(640).a(paramString);
      if ((localObject instanceof d))
        return (d)localObject;
    }
    catch (e.a.b.b.e locale)
    {
      throw new ParseException("Invalid JSON: " + locale.getMessage(), 0);
    }
    throw new ParseException("JSON entity is not an object", 0);
  }

  private static <T> T a(d paramd, String paramString, Class<T> paramClass)
    throws ParseException
  {
    if (!paramd.containsKey(paramString))
      throw new ParseException("Missing JSON object member with key \"" + paramString + "\"", 0);
    if (paramd.get(paramString) == null)
      throw new ParseException("JSON object member with key \"" + paramString + "\" has null value", 0);
    Object localObject = paramd.get(paramString);
    if (!paramClass.isAssignableFrom(localObject.getClass()))
      throw new ParseException("Unexpected type of JSON object member with key \"" + paramString + "\"", 0);
    return localObject;
  }

  public static String b(d paramd, String paramString)
    throws ParseException
  {
    return (String)a(paramd, paramString, String.class);
  }

  public static URI c(d paramd, String paramString)
    throws ParseException
  {
    try
    {
      URI localURI = new URI((String)a(paramd, paramString, String.class));
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new ParseException(localURISyntaxException.getMessage(), 0);
    }
  }

  public static e.a.b.a d(d paramd, String paramString)
    throws ParseException
  {
    return (e.a.b.a)a(paramd, paramString, e.a.b.a.class);
  }

  public static String[] e(d paramd, String paramString)
    throws ParseException
  {
    e.a.b.a locala = d(paramd, paramString);
    try
    {
      String[] arrayOfString = (String[])locala.toArray(new String[0]);
      return arrayOfString;
    }
    catch (ArrayStoreException localArrayStoreException)
    {
    }
    throw new ParseException("JSON object member with key \"" + paramString + "\" is not an array of strings", 0);
  }

  public static List<String> f(d paramd, String paramString)
    throws ParseException
  {
    return Arrays.asList(e(paramd, paramString));
  }

  public static d g(d paramd, String paramString)
    throws ParseException
  {
    return (d)a(paramd, paramString, d.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.d.e
 * JD-Core Version:    0.6.2
 */