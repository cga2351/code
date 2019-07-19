package com.mopub.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class NetworkResponse
{
  public final List<Header> allHeaders;
  public final byte[] data;
  public final Map<String, String> headers;
  public final long networkTimeMs;
  public final boolean notModified;
  public final int statusCode;

  private NetworkResponse(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, List<Header> paramList, boolean paramBoolean, long paramLong)
  {
    this.statusCode = paramInt;
    this.data = paramArrayOfByte;
    this.headers = paramMap;
    if (paramList == null);
    for (this.allHeaders = null; ; this.allHeaders = Collections.unmodifiableList(paramList))
    {
      this.notModified = paramBoolean;
      this.networkTimeMs = paramLong;
      return;
    }
  }

  @Deprecated
  public NetworkResponse(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean)
  {
    this(paramInt, paramArrayOfByte, paramMap, paramBoolean, 0L);
  }

  @Deprecated
  public NetworkResponse(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this(paramInt, paramArrayOfByte, paramMap, a(paramMap), paramBoolean, paramLong);
  }

  public NetworkResponse(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong, List<Header> paramList)
  {
    this(paramInt, paramArrayOfByte, a(paramList), paramList, paramBoolean, paramLong);
  }

  public NetworkResponse(byte[] paramArrayOfByte)
  {
    this(200, paramArrayOfByte, false, 0L, Collections.emptyList());
  }

  @Deprecated
  public NetworkResponse(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }

  private static List<Header> a(Map<String, String> paramMap)
  {
    if (paramMap == null)
      return null;
    if (paramMap.isEmpty())
      return Collections.emptyList();
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new Header((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }

  private static Map<String, String> a(List<Header> paramList)
  {
    if (paramList == null)
      return null;
    if (paramList.isEmpty())
      return Collections.emptyMap();
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Header localHeader = (Header)localIterator.next();
      localTreeMap.put(localHeader.getName(), localHeader.getValue());
    }
    return localTreeMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.NetworkResponse
 * JD-Core Version:    0.6.2
 */