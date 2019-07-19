package twitter4j.internal.org.json;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class JSONArray
{
  private ArrayList myArrayList = new ArrayList();

  public JSONArray()
  {
  }

  public JSONArray(Object paramObject)
    throws JSONException
  {
    this();
    if (paramObject.getClass().isArray())
    {
      int i = Array.getLength(paramObject);
      for (int j = 0; j < i; j++)
        put(JSONObject.wrap(Array.get(paramObject, j)));
    }
    throw new JSONException("JSONArray initial value should be a string or collection or array.");
  }

  public JSONArray(String paramString)
    throws JSONException
  {
    this(new JSONTokener(paramString));
  }

  public JSONArray(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        this.myArrayList.add(JSONObject.wrap(localObject));
      }
    }
  }

  public JSONArray(JSONTokener paramJSONTokener)
    throws JSONException
  {
    this();
    if (paramJSONTokener.nextClean() != '[')
      throw paramJSONTokener.syntaxError("A JSONArray text must start with '['");
    if (paramJSONTokener.nextClean() != ']')
      paramJSONTokener.back();
    while (true)
    {
      if (paramJSONTokener.nextClean() == ',')
      {
        paramJSONTokener.back();
        this.myArrayList.add(JSONObject.NULL);
      }
      while (true)
        switch (paramJSONTokener.nextClean())
        {
        default:
          throw paramJSONTokener.syntaxError("Expected a ',' or ']'");
          paramJSONTokener.back();
          this.myArrayList.add(paramJSONTokener.nextValue());
        case ',':
        case ';':
        case ']':
        }
      if (paramJSONTokener.nextClean() == ']')
        return;
      paramJSONTokener.back();
    }
  }

  public Object get(int paramInt)
    throws JSONException
  {
    Object localObject = opt(paramInt);
    if (localObject == null)
      throw new JSONException("JSONArray[" + paramInt + "] not found.");
    return localObject;
  }

  public boolean getBoolean(int paramInt)
    throws JSONException
  {
    Object localObject = get(paramInt);
    if ((localObject.equals(Boolean.FALSE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("false"))))
      return false;
    if ((localObject.equals(Boolean.TRUE)) || (((localObject instanceof String)) && (((String)localObject).equalsIgnoreCase("true"))))
      return true;
    throw new JSONException("JSONArray[" + paramInt + "] is not a boolean.");
  }

  public double getDouble(int paramInt)
    throws JSONException
  {
    Object localObject = get(paramInt);
    try
    {
      if ((localObject instanceof Number))
        return ((Number)localObject).doubleValue();
      double d = Double.parseDouble((String)localObject);
      return d;
    }
    catch (Exception localException)
    {
    }
    throw new JSONException("JSONArray[" + paramInt + "] is not a number.");
  }

  public int getInt(int paramInt)
    throws JSONException
  {
    Object localObject = get(paramInt);
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
    throw new JSONException("JSONArray[" + paramInt + "] is not a number.");
  }

  public JSONArray getJSONArray(int paramInt)
    throws JSONException
  {
    Object localObject = get(paramInt);
    if ((localObject instanceof JSONArray))
      return (JSONArray)localObject;
    throw new JSONException("JSONArray[" + paramInt + "] is not a JSONArray.");
  }

  public JSONObject getJSONObject(int paramInt)
    throws JSONException
  {
    Object localObject = get(paramInt);
    if ((localObject instanceof JSONObject))
      return (JSONObject)localObject;
    throw new JSONException("JSONArray[" + paramInt + "] is not a JSONObject.");
  }

  public long getLong(int paramInt)
    throws JSONException
  {
    Object localObject = get(paramInt);
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
    throw new JSONException("JSONArray[" + paramInt + "] is not a number.");
  }

  public String getString(int paramInt)
    throws JSONException
  {
    Object localObject = get(paramInt);
    if (localObject == JSONObject.NULL)
      return null;
    return localObject.toString();
  }

  public boolean isNull(int paramInt)
  {
    return JSONObject.NULL.equals(opt(paramInt));
  }

  public String join(String paramString)
    throws JSONException
  {
    int i = length();
    StringBuilder localStringBuilder = new StringBuilder();
    for (int j = 0; j < i; j++)
    {
      if (j > 0)
        localStringBuilder.append(paramString);
      localStringBuilder.append(JSONObject.valueToString(this.myArrayList.get(j)));
    }
    return localStringBuilder.toString();
  }

  public int length()
  {
    return this.myArrayList.size();
  }

  public Object opt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= length()))
      return null;
    return this.myArrayList.get(paramInt);
  }

  public JSONArray put(int paramInt)
  {
    put(new Integer(paramInt));
    return this;
  }

  public JSONArray put(int paramInt, double paramDouble)
    throws JSONException
  {
    put(paramInt, new Double(paramDouble));
    return this;
  }

  public JSONArray put(int paramInt1, int paramInt2)
    throws JSONException
  {
    put(paramInt1, new Integer(paramInt2));
    return this;
  }

  public JSONArray put(int paramInt, long paramLong)
    throws JSONException
  {
    put(paramInt, new Long(paramLong));
    return this;
  }

  public JSONArray put(int paramInt, Object paramObject)
    throws JSONException
  {
    JSONObject.testValidity(paramObject);
    if (paramInt < 0)
      throw new JSONException("JSONArray[" + paramInt + "] not found.");
    if (paramInt < length())
    {
      this.myArrayList.set(paramInt, paramObject);
      return this;
    }
    while (paramInt != length())
      put(JSONObject.NULL);
    put(paramObject);
    return this;
  }

  public JSONArray put(int paramInt, Collection paramCollection)
    throws JSONException
  {
    put(paramInt, new JSONArray(paramCollection));
    return this;
  }

  public JSONArray put(int paramInt, Map paramMap)
    throws JSONException
  {
    put(paramInt, new JSONObject(paramMap));
    return this;
  }

  public JSONArray put(int paramInt, boolean paramBoolean)
    throws JSONException
  {
    if (paramBoolean);
    for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE)
    {
      put(paramInt, localBoolean);
      return this;
    }
  }

  public JSONArray put(long paramLong)
  {
    put(new Long(paramLong));
    return this;
  }

  public JSONArray put(Object paramObject)
  {
    this.myArrayList.add(paramObject);
    return this;
  }

  public JSONArray put(Collection paramCollection)
  {
    put(new JSONArray(paramCollection));
    return this;
  }

  public JSONArray put(Map paramMap)
  {
    put(new JSONObject(paramMap));
    return this;
  }

  public JSONArray put(boolean paramBoolean)
  {
    if (paramBoolean);
    for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE)
    {
      put(localBoolean);
      return this;
    }
  }

  public String toString()
  {
    try
    {
      String str = '[' + join(",") + ']';
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
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder("[");
    if (j == 1)
      localStringBuilder.append(JSONObject.valueToString(this.myArrayList.get(0), paramInt1, paramInt2));
    while (true)
    {
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      int k = paramInt2 + paramInt1;
      localStringBuilder.append('\n');
      for (int m = 0; m < j; m++)
      {
        if (m > 0)
          localStringBuilder.append(",\n");
        for (int n = 0; n < k; n++)
          localStringBuilder.append(' ');
        localStringBuilder.append(JSONObject.valueToString(this.myArrayList.get(m), paramInt1, k));
      }
      localStringBuilder.append('\n');
      while (i < paramInt2)
      {
        localStringBuilder.append(' ');
        i++;
      }
    }
  }

  public Writer write(Writer paramWriter)
    throws JSONException
  {
    for (int i = 0; ; i = 1)
    {
      int k;
      Object localObject;
      try
      {
        int j = length();
        paramWriter.write(91);
        k = 0;
        if (k >= j)
          break label109;
        if (i != 0)
          paramWriter.write(44);
        localObject = this.myArrayList.get(k);
        if ((localObject instanceof JSONObject))
          ((JSONObject)localObject).write(paramWriter);
        else if ((localObject instanceof JSONArray))
          ((JSONArray)localObject).write(paramWriter);
      }
      catch (IOException localIOException)
      {
        throw new JSONException(localIOException);
      }
      paramWriter.write(JSONObject.valueToString(localObject));
      break label117;
      label109: paramWriter.write(93);
      return paramWriter;
      label117: k++;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.org.json.JSONArray
 * JD-Core Version:    0.6.2
 */