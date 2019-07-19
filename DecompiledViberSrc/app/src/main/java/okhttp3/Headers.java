package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Headers
{
  private final String[] namesAndValues;

  Headers(Builder paramBuilder)
  {
    this.namesAndValues = ((String[])paramBuilder.namesAndValues.toArray(new String[paramBuilder.namesAndValues.size()]));
  }

  private Headers(String[] paramArrayOfString)
  {
    this.namesAndValues = paramArrayOfString;
  }

  private static String get(String[] paramArrayOfString, String paramString)
  {
    for (int i = -2 + paramArrayOfString.length; i >= 0; i -= 2)
      if (paramString.equalsIgnoreCase(paramArrayOfString[i]))
        return paramArrayOfString[(i + 1)];
    return null;
  }

  public static Headers of(Map<String, String> paramMap)
  {
    if (paramMap == null)
      throw new NullPointerException("headers == null");
    String[] arrayOfString = new String[2 * paramMap.size()];
    Iterator localIterator = paramMap.entrySet().iterator();
    for (int i = 0; localIterator.hasNext(); i += 2)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getKey() == null) || (localEntry.getValue() == null))
        throw new IllegalArgumentException("Headers cannot be null");
      String str1 = ((String)localEntry.getKey()).trim();
      String str2 = ((String)localEntry.getValue()).trim();
      if ((str1.length() == 0) || (str1.indexOf(0) != -1) || (str2.indexOf(0) != -1))
        throw new IllegalArgumentException("Unexpected header: " + str1 + ": " + str2);
      arrayOfString[i] = str1;
      arrayOfString[(i + 1)] = str2;
    }
    return new Headers(arrayOfString);
  }

  public static Headers of(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
      throw new NullPointerException("namesAndValues == null");
    if (paramArrayOfString.length % 2 != 0)
      throw new IllegalArgumentException("Expected alternating header names and values");
    String[] arrayOfString = (String[])paramArrayOfString.clone();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if (arrayOfString[i] == null)
        throw new IllegalArgumentException("Headers cannot be null");
      arrayOfString[i] = arrayOfString[i].trim();
    }
    for (int j = 0; j < arrayOfString.length; j += 2)
    {
      String str1 = arrayOfString[j];
      String str2 = arrayOfString[(j + 1)];
      if ((str1.length() == 0) || (str1.indexOf(0) != -1) || (str2.indexOf(0) != -1))
        throw new IllegalArgumentException("Unexpected header: " + str1 + ": " + str2);
    }
    return new Headers(arrayOfString);
  }

  public long byteCount()
  {
    long l = 2 * this.namesAndValues.length;
    int i = 0;
    int j = this.namesAndValues.length;
    while (i < j)
    {
      l += this.namesAndValues[i].length();
      i++;
    }
    return l;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Headers)) && (Arrays.equals(((Headers)paramObject).namesAndValues, this.namesAndValues));
  }

  @Nullable
  public String get(String paramString)
  {
    return get(this.namesAndValues, paramString);
  }

  @Nullable
  public Date getDate(String paramString)
  {
    String str = get(paramString);
    if (str != null)
      return HttpDate.parse(str);
    return null;
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.namesAndValues);
  }

  public String name(int paramInt)
  {
    return this.namesAndValues[(paramInt * 2)];
  }

  public Set<String> names()
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    int j = size();
    while (i < j)
    {
      localTreeSet.add(name(i));
      i++;
    }
    return Collections.unmodifiableSet(localTreeSet);
  }

  public Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    Collections.addAll(localBuilder.namesAndValues, this.namesAndValues);
    return localBuilder;
  }

  public int size()
  {
    return this.namesAndValues.length / 2;
  }

  public Map<String, List<String>> toMultimap()
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = size();
    for (int j = 0; j < i; j++)
    {
      String str = name(j).toLowerCase(Locale.US);
      Object localObject = (List)localTreeMap.get(str);
      if (localObject == null)
      {
        localObject = new ArrayList(2);
        localTreeMap.put(str, localObject);
      }
      ((List)localObject).add(value(j));
    }
    return localTreeMap;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = size();
    while (i < j)
    {
      localStringBuilder.append(name(i)).append(": ").append(value(i)).append("\n");
      i++;
    }
    return localStringBuilder.toString();
  }

  public String value(int paramInt)
  {
    return this.namesAndValues[(1 + paramInt * 2)];
  }

  public List<String> values(String paramString)
  {
    int i = size();
    ArrayList localArrayList = null;
    for (int j = 0; j < i; j++)
      if (paramString.equalsIgnoreCase(name(j)))
      {
        if (localArrayList == null)
          localArrayList = new ArrayList(2);
        localArrayList.add(value(j));
      }
    if (localArrayList != null)
      return Collections.unmodifiableList(localArrayList);
    return Collections.emptyList();
  }

  public static final class Builder
  {
    final List<String> namesAndValues = new ArrayList(20);

    private void checkNameAndValue(String paramString1, String paramString2)
    {
      if (paramString1 == null)
        throw new NullPointerException("name == null");
      if (paramString1.isEmpty())
        throw new IllegalArgumentException("name is empty");
      int i = paramString1.length();
      for (int j = 0; j < i; j++)
      {
        int i1 = paramString1.charAt(j);
        if ((i1 <= 32) || (i1 >= 127))
        {
          Object[] arrayOfObject2 = new Object[3];
          arrayOfObject2[0] = Integer.valueOf(i1);
          arrayOfObject2[1] = Integer.valueOf(j);
          arrayOfObject2[2] = paramString1;
          throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", arrayOfObject2));
        }
      }
      if (paramString2 == null)
        throw new NullPointerException("value for name " + paramString1 + " == null");
      int k = paramString2.length();
      for (int m = 0; m < k; m++)
      {
        int n = paramString2.charAt(m);
        if (((n <= 31) && (n != 9)) || (n >= 127))
        {
          Object[] arrayOfObject1 = new Object[4];
          arrayOfObject1[0] = Integer.valueOf(n);
          arrayOfObject1[1] = Integer.valueOf(m);
          arrayOfObject1[2] = paramString1;
          arrayOfObject1[3] = paramString2;
          throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", arrayOfObject1));
        }
      }
    }

    public Builder add(String paramString)
    {
      int i = paramString.indexOf(":");
      if (i == -1)
        throw new IllegalArgumentException("Unexpected header: " + paramString);
      return add(paramString.substring(0, i).trim(), paramString.substring(i + 1));
    }

    public Builder add(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      return addLenient(paramString1, paramString2);
    }

    Builder addLenient(String paramString)
    {
      int i = paramString.indexOf(":", 1);
      if (i != -1)
        return addLenient(paramString.substring(0, i), paramString.substring(i + 1));
      if (paramString.startsWith(":"))
        return addLenient("", paramString.substring(1));
      return addLenient("", paramString);
    }

    Builder addLenient(String paramString1, String paramString2)
    {
      this.namesAndValues.add(paramString1);
      this.namesAndValues.add(paramString2.trim());
      return this;
    }

    public Headers build()
    {
      return new Headers(this);
    }

    public String get(String paramString)
    {
      for (int i = -2 + this.namesAndValues.size(); i >= 0; i -= 2)
        if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i)))
          return (String)this.namesAndValues.get(i + 1);
      return null;
    }

    public Builder removeAll(String paramString)
    {
      for (int i = 0; i < this.namesAndValues.size(); i += 2)
        if (paramString.equalsIgnoreCase((String)this.namesAndValues.get(i)))
        {
          this.namesAndValues.remove(i);
          this.namesAndValues.remove(i);
          i -= 2;
        }
      return this;
    }

    public Builder set(String paramString1, String paramString2)
    {
      checkNameAndValue(paramString1, paramString2);
      removeAll(paramString1);
      addLenient(paramString1, paramString2);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Headers
 * JD-Core Version:    0.6.2
 */