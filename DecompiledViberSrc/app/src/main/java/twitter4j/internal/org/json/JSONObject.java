package twitter4j.internal.org.json;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class JSONObject
{
  public static final Object NULL = new Null(null);
  private Map map = new HashMap();

  public JSONObject()
  {
  }

  public JSONObject(Object paramObject)
  {
    this();
    populateMap(paramObject);
  }

  public JSONObject(Object paramObject, String[] paramArrayOfString)
  {
    this();
    Class localClass = paramObject.getClass();
    int i = 0;
    while (true)
    {
      String str;
      if (i < paramArrayOfString.length)
        str = paramArrayOfString[i];
      try
      {
        putOpt(str, localClass.getField(str).get(paramObject));
        label42: i++;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label42;
      }
    }
  }

  public JSONObject(String paramString)
    throws JSONException
  {
    this(new JSONTokener(paramString));
  }

  public JSONObject(String paramString, Locale paramLocale)
    throws JSONException
  {
    this();
    ResourceBundle localResourceBundle = ResourceBundle.getBundle(paramString, paramLocale, Thread.currentThread().getContextClassLoader());
    Enumeration localEnumeration = localResourceBundle.getKeys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = localEnumeration.nextElement();
      if ((localObject1 instanceof String))
      {
        String[] arrayOfString = ((String)localObject1).split("\\.");
        int i = -1 + arrayOfString.length;
        int j = 0;
        Object localObject2 = this;
        if (j < i)
        {
          String str = arrayOfString[j];
          Object localObject3 = ((JSONObject)localObject2).opt(str);
          if ((localObject3 instanceof JSONObject));
          for (JSONObject localJSONObject = (JSONObject)localObject3; ; localJSONObject = null)
          {
            if (localJSONObject == null)
            {
              localJSONObject = new JSONObject();
              ((JSONObject)localObject2).put(str, localJSONObject);
            }
            j++;
            localObject2 = localJSONObject;
            break;
          }
        }
        ((JSONObject)localObject2).put(arrayOfString[i], localResourceBundle.getString((String)localObject1));
      }
    }
  }

  public JSONObject(Map paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject = localEntry.getValue();
        if (localObject != null)
          this.map.put(localEntry.getKey(), wrap(localObject));
      }
    }
  }

  public JSONObject(JSONObject paramJSONObject, String[] paramArrayOfString)
  {
    this();
    int i = 0;
    while (true)
    {
      if (i < paramArrayOfString.length);
      try
      {
        putOnce(paramArrayOfString[i], paramJSONObject.opt(paramArrayOfString[i]));
        label27: i++;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label27;
      }
    }
  }

  public JSONObject(JSONTokener paramJSONTokener)
    throws JSONException
  {
    this();
    if (paramJSONTokener.nextClean() != '{')
      throw paramJSONTokener.syntaxError("A JSONObject text must begin with '{' found:" + paramJSONTokener.nextClean());
    do
    {
      paramJSONTokener.back();
      String str;
      int i;
      switch (paramJSONTokener.nextClean())
      {
      default:
        paramJSONTokener.back();
        str = paramJSONTokener.nextValue().toString();
        i = paramJSONTokener.nextClean();
        if (i == 61)
          if (paramJSONTokener.next() != '>')
            paramJSONTokener.back();
      case '\000':
        while (i == 58)
        {
          putOnce(str, paramJSONTokener.nextValue());
          switch (paramJSONTokener.nextClean())
          {
          default:
            throw paramJSONTokener.syntaxError("Expected a ',' or '}'");
            throw paramJSONTokener.syntaxError("A JSONObject text must end with '}'");
          case ',':
          case ';':
          case '}':
          }
        }
        throw paramJSONTokener.syntaxError("Expected a ':' after a key");
      case '}':
      }
    }
    while (paramJSONTokener.nextClean() != '}');
  }

  public static String numberToString(Number paramNumber)
    throws JSONException
  {
    if (paramNumber == null)
      throw new JSONException("Null pointer");
    testValidity(paramNumber);
    String str = paramNumber.toString();
    if ((str.indexOf('.') > 0) && (str.indexOf('e') < 0) && (str.indexOf('E') < 0))
    {
      while (str.endsWith("0"))
        str = str.substring(0, -1 + str.length());
      if (str.endsWith("."))
        str = str.substring(0, -1 + str.length());
    }
    return str;
  }

  private void populateMap(Object paramObject)
  {
    int i = 0;
    Class localClass = paramObject.getClass();
    int j;
    if (localClass.getClassLoader() != null)
      j = 1;
    while (true)
    {
      Method[] arrayOfMethod;
      if (j != 0)
      {
        arrayOfMethod = localClass.getMethods();
        label28: if (i >= arrayOfMethod.length)
          break label284;
      }
      try
      {
        Method localMethod = arrayOfMethod[i];
        String str1;
        if (Modifier.isPublic(localMethod.getModifiers()))
        {
          str1 = localMethod.getName();
          str2 = "";
          if (!str1.startsWith("get"))
            break label209;
          if (str1.equals("getClass"))
            break label297;
          if (!str1.equals("getDeclaringClass"))
            break label198;
          break label297;
          label96: if ((str2.length() > 0) && (Character.isUpperCase(str2.charAt(0))) && (localMethod.getParameterTypes().length == 0))
            if (str2.length() != 1)
              break label231;
        }
        label198: label209: label231: String str3;
        for (localObject1 = str2.toLowerCase(); ; localObject1 = str3)
        {
          Object localObject2 = localMethod.invoke(paramObject, (Object[])null);
          if (localObject2 != null)
            this.map.put(localObject1, wrap(localObject2));
          i++;
          break label28;
          j = 0;
          break;
          arrayOfMethod = localClass.getDeclaredMethods();
          i = 0;
          break label28;
          str2 = str1.substring(3);
          break label96;
          if (!str1.startsWith("is"))
            break label96;
          str2 = str1.substring(2);
          break label96;
          if (Character.isUpperCase(str2.charAt(1)))
            break label290;
          str3 = str2.substring(0, 1).toLowerCase() + str2.substring(1);
        }
        label284: return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          continue;
          label290: Object localObject1 = str2;
          continue;
          label297: String str2 = "";
        }
      }
    }
  }

  public static String quote(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0))
      return "\"\"";
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j + 4);
    localStringBuilder.append('"');
    int k = 0;
    if (i < j)
    {
      int m = paramString.charAt(i);
      switch (m)
      {
      default:
        if ((m < 32) || ((m >= 128) && (m < 160)) || ((m >= 8192) && (m < 8448)))
        {
          String str = "000" + Integer.toHexString(m);
          localStringBuilder.append("\\u").append(str.substring(-4 + str.length()));
        }
        break;
      case 34:
      case 92:
      case 47:
      case 8:
      case 9:
      case 10:
      case 12:
      case 13:
      }
      while (true)
      {
        i++;
        k = m;
        break;
        localStringBuilder.append('\\');
        localStringBuilder.append(m);
        continue;
        if (k == 60)
          localStringBuilder.append('\\');
        localStringBuilder.append(m);
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append(m);
      }
    }
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }

  public static Object stringToValue(String paramString)
  {
    if (paramString.equals(""));
    int i;
    do
    {
      return paramString;
      if (paramString.equalsIgnoreCase("true"))
        return Boolean.TRUE;
      if (paramString.equalsIgnoreCase("false"))
        return Boolean.FALSE;
      if (paramString.equalsIgnoreCase("null"))
        return NULL;
      i = paramString.charAt(0);
    }
    while (((i < 48) || (i > 57)) && (i != 46) && (i != 45) && (i != 43));
    if ((i == 48) && (paramString.length() > 2) && ((paramString.charAt(1) == 'x') || (paramString.charAt(1) == 'X')))
      try
      {
        Integer localInteger2 = Integer.valueOf(Integer.parseInt(paramString.substring(2), 16));
        return localInteger2;
      }
      catch (Exception localException2)
      {
      }
    try
    {
      if ((paramString.indexOf('.') > -1) || (paramString.indexOf('e') > -1) || (paramString.indexOf('E') > -1))
        return Double.valueOf(paramString);
      Long localLong = new Long(paramString);
      if (localLong.longValue() == localLong.intValue())
      {
        Integer localInteger1 = Integer.valueOf(localLong.intValue());
        return localInteger1;
      }
      return localLong;
    }
    catch (Exception localException1)
    {
    }
    return paramString;
  }

  public static void testValidity(Object paramObject)
    throws JSONException
  {
    if (paramObject != null)
      if ((paramObject instanceof Double))
      {
        if ((((Double)paramObject).isInfinite()) || (((Double)paramObject).isNaN()))
          throw new JSONException("JSON does not allow non-finite numbers.");
      }
      else if (((paramObject instanceof Float)) && ((((Float)paramObject).isInfinite()) || (((Float)paramObject).isNaN())))
        throw new JSONException("JSON does not allow non-finite numbers.");
  }

  public static String valueToString(Object paramObject)
    throws JSONException
  {
    if ((paramObject == null) || (paramObject.equals(null)))
      return "null";
    if ((paramObject instanceof Number))
      return numberToString((Number)paramObject);
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONArray)))
      return paramObject.toString();
    if ((paramObject instanceof Map))
      return new JSONObject((Map)paramObject).toString();
    if ((paramObject instanceof Collection))
      return new JSONArray((Collection)paramObject).toString();
    if (paramObject.getClass().isArray())
      return new JSONArray(paramObject).toString();
    return quote(paramObject.toString());
  }

  static String valueToString(Object paramObject, int paramInt1, int paramInt2)
    throws JSONException
  {
    if ((paramObject == null) || (paramObject.equals(null)))
      return "null";
    if ((paramObject instanceof Number))
      return numberToString((Number)paramObject);
    if ((paramObject instanceof Boolean))
      return paramObject.toString();
    if ((paramObject instanceof JSONObject))
      return ((JSONObject)paramObject).toString(paramInt1, paramInt2);
    if ((paramObject instanceof JSONArray))
      return ((JSONArray)paramObject).toString(paramInt1, paramInt2);
    if ((paramObject instanceof Map))
      return new JSONObject((Map)paramObject).toString(paramInt1, paramInt2);
    if ((paramObject instanceof Collection))
      return new JSONArray((Collection)paramObject).toString(paramInt1, paramInt2);
    if (paramObject.getClass().isArray())
      return new JSONArray(paramObject).toString(paramInt1, paramInt2);
    return quote(paramObject.toString());
  }

  public static Object wrap(Object paramObject)
  {
    if (paramObject == null);
    while (true)
    {
      try
      {
        return NULL;
        if ((!(paramObject instanceof JSONObject)) && (!(paramObject instanceof JSONArray)) && (!NULL.equals(paramObject)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof String)))
        {
          if ((paramObject instanceof Collection))
            return new JSONArray((Collection)paramObject);
          if (paramObject.getClass().isArray())
            return new JSONArray(paramObject);
          if ((paramObject instanceof Map))
            return new JSONObject((Map)paramObject);
          Package localPackage = paramObject.getClass().getPackage();
          if (localPackage == null)
            break label222;
          str = localPackage.getName();
          if ((str.startsWith("java.")) || (str.startsWith("javax.")) || (paramObject.getClass().getClassLoader() == null))
            return paramObject.toString();
          JSONObject localJSONObject = new JSONObject(paramObject);
          return localJSONObject;
        }
      }
      catch (Exception localException)
      {
        paramObject = null;
      }
      return paramObject;
      label222: String str = "";
    }
  }

  public JSONObject append(String paramString, Object paramObject)
    throws JSONException
  {
    testValidity(paramObject);
    Object localObject = opt(paramString);
    if (localObject == null)
    {
      put(paramString, new JSONArray().put(paramObject));
      return this;
    }
    if ((localObject instanceof JSONArray))
    {
      put(paramString, ((JSONArray)localObject).put(paramObject));
      return this;
    }
    throw new JSONException("JSONObject[" + paramString + "] is not a JSONArray.");
  }

  public Object get(String paramString)
    throws JSONException
  {
    if (paramString == null)
      throw new JSONException("Null key.");
    Object localObject = opt(paramString);
    if (localObject == null)
      throw new JSONException("JSONObject[" + quote(paramString) + "] not found.");
    return localObject;
  }

  public boolean getBoolean(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if ((localObject.equals(Boolean.FALSE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("false"))))
      return false;
    if ((localObject.equals(Boolean.TRUE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("true"))))
      return true;
    throw new JSONException("JSONObject[" + quote(paramString) + "] is not a Boolean.");
  }

  public int getInt(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    try
    {
      if ((localObject instanceof Number))
        return ((Number)localObject).intValue();
      int i = Integer.parseInt((String)localObject);
      return i;
    }
    catch (Exception localException)
    {
    }
    throw new JSONException("JSONObject[" + quote(paramString) + "] is not an int.");
  }

  public JSONArray getJSONArray(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if ((localObject instanceof JSONArray))
      return (JSONArray)localObject;
    throw new JSONException("JSONObject[" + quote(paramString) + "] is not a JSONArray.");
  }

  public JSONObject getJSONObject(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if ((localObject instanceof JSONObject))
      return (JSONObject)localObject;
    throw new JSONException("JSONObject[" + quote(paramString) + "] is not a JSONObject.");
  }

  public long getLong(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    try
    {
      if ((localObject instanceof Number))
        return ((Number)localObject).longValue();
      long l = Long.parseLong((String)localObject);
      return l;
    }
    catch (Exception localException)
    {
    }
    throw new JSONException("JSONObject[" + quote(paramString) + "] is not a long.");
  }

  public String getString(String paramString)
    throws JSONException
  {
    Object localObject = get(paramString);
    if (localObject == NULL)
      return null;
    return localObject.toString();
  }

  public boolean has(String paramString)
  {
    return this.map.containsKey(paramString);
  }

  public boolean isNull(String paramString)
  {
    return NULL.equals(opt(paramString));
  }

  public Iterator keys()
  {
    return this.map.keySet().iterator();
  }

  public int length()
  {
    return this.map.size();
  }

  public JSONArray names()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = keys();
    while (localIterator.hasNext())
      localJSONArray.put(localIterator.next());
    if (localJSONArray.length() == 0)
      localJSONArray = null;
    return localJSONArray;
  }

  public Object opt(String paramString)
  {
    if (paramString == null)
      return null;
    return this.map.get(paramString);
  }

  public JSONObject put(String paramString, double paramDouble)
    throws JSONException
  {
    put(paramString, new Double(paramDouble));
    return this;
  }

  public JSONObject put(String paramString, int paramInt)
    throws JSONException
  {
    put(paramString, new Integer(paramInt));
    return this;
  }

  public JSONObject put(String paramString, long paramLong)
    throws JSONException
  {
    put(paramString, new Long(paramLong));
    return this;
  }

  public JSONObject put(String paramString, Object paramObject)
    throws JSONException
  {
    if (paramString == null)
      throw new JSONException("Null key.");
    if (paramObject != null)
    {
      testValidity(paramObject);
      this.map.put(paramString, paramObject);
      return this;
    }
    remove(paramString);
    return this;
  }

  public JSONObject put(String paramString, Collection paramCollection)
    throws JSONException
  {
    put(paramString, new JSONArray(paramCollection));
    return this;
  }

  public JSONObject put(String paramString, Map paramMap)
    throws JSONException
  {
    put(paramString, new JSONObject(paramMap));
    return this;
  }

  public JSONObject put(String paramString, boolean paramBoolean)
    throws JSONException
  {
    if (paramBoolean);
    for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE)
    {
      put(paramString, localBoolean);
      return this;
    }
  }

  public JSONObject putOnce(String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramString != null) && (paramObject != null))
    {
      if (opt(paramString) != null)
        throw new JSONException("Duplicate key \"" + paramString + "\"");
      put(paramString, paramObject);
    }
    return this;
  }

  public JSONObject putOpt(String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramString != null) && (paramObject != null))
      put(paramString, paramObject);
    return this;
  }

  public Object remove(String paramString)
  {
    return this.map.remove(paramString);
  }

  public Iterator sortedKeys()
  {
    return new TreeSet(this.map.keySet()).iterator();
  }

  public String toString()
  {
    try
    {
      Iterator localIterator = keys();
      StringBuilder localStringBuilder = new StringBuilder("{");
      while (localIterator.hasNext())
      {
        if (localStringBuilder.length() > 1)
          localStringBuilder.append(',');
        Object localObject = localIterator.next();
        localStringBuilder.append(quote(localObject.toString()));
        localStringBuilder.append(':');
        localStringBuilder.append(valueToString(this.map.get(localObject)));
      }
      localStringBuilder.append('}');
      String str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String toString(int paramInt)
    throws JSONException
  {
    return toString(paramInt, 0);
  }

  String toString(int paramInt1, int paramInt2)
    throws JSONException
  {
    int i = 0;
    int j = length();
    if (j == 0)
      return "{}";
    Iterator localIterator = sortedKeys();
    int k = paramInt2 + paramInt1;
    StringBuilder localStringBuilder = new StringBuilder("{");
    if (j == 1)
    {
      Object localObject2 = localIterator.next();
      localStringBuilder.append(quote(localObject2.toString()));
      localStringBuilder.append(": ");
      localStringBuilder.append(valueToString(this.map.get(localObject2), paramInt1, paramInt2));
    }
    while (true)
    {
      localStringBuilder.append('}');
      return localStringBuilder.toString();
      Object localObject1;
      localStringBuilder.append(quote(localObject1.toString()));
      localStringBuilder.append(": ");
      localStringBuilder.append(valueToString(this.map.get(localObject1), paramInt1, k));
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (localStringBuilder.length() > 1)
          localStringBuilder.append(",\n");
        while (true)
        {
          for (int m = 0; m < k; m++)
            localStringBuilder.append(' ');
          break;
          localStringBuilder.append('\n');
        }
      }
      if (localStringBuilder.length() > 1)
      {
        localStringBuilder.append('\n');
        while (i < paramInt2)
        {
          localStringBuilder.append(' ');
          i++;
        }
      }
    }
  }

  public Writer write(Writer paramWriter)
    throws JSONException
  {
    for (int i = 0; ; i = 1)
    {
      Object localObject2;
      try
      {
        Iterator localIterator = keys();
        paramWriter.write(123);
        if (!localIterator.hasNext())
          break label138;
        if (i != 0)
          paramWriter.write(44);
        Object localObject1 = localIterator.next();
        paramWriter.write(quote(localObject1.toString()));
        paramWriter.write(58);
        localObject2 = this.map.get(localObject1);
        if ((localObject2 instanceof JSONObject))
          ((JSONObject)localObject2).write(paramWriter);
        else if ((localObject2 instanceof JSONArray))
          ((JSONArray)localObject2).write(paramWriter);
      }
      catch (IOException localIOException)
      {
        throw new JSONException(localIOException);
      }
      paramWriter.write(valueToString(localObject2));
      continue;
      label138: paramWriter.write(125);
      return paramWriter;
    }
  }

  private static final class Null
  {
    protected final Object clone()
    {
      return this;
    }

    public boolean equals(Object paramObject)
    {
      return (paramObject == null) || (paramObject == this);
    }

    public String toString()
    {
      return "null";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.org.json.JSONObject
 * JD-Core Version:    0.6.2
 */