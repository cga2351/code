package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

public final class Query
  implements Serializable
{
  public static final String KILOMETERS = "km";
  public static final String MILES = "mi";
  public static final String MIXED = "mixed";
  public static final String POPULAR = "popular";
  public static final String RECENT = "recent";
  private static HttpParameter WITH_TWITTER_USER_ID = new HttpParameter("with_twitter_user_id", "true");
  private static final long serialVersionUID = -8108425822233599808L;
  private int count = -1;
  private String geocode = null;
  private String lang = null;
  private String locale = null;
  private long maxId = -1L;
  private String nextPageQuery = null;
  private String query = null;
  private String resultType = null;
  private String since = null;
  private long sinceId = -1L;
  private String until = null;

  public Query()
  {
  }

  public Query(String paramString)
  {
    this.query = paramString;
  }

  private void appendParameter(String paramString, long paramLong, List<HttpParameter> paramList)
  {
    if (0L <= paramLong)
      paramList.add(new HttpParameter(paramString, String.valueOf(paramLong)));
  }

  private void appendParameter(String paramString1, String paramString2, List<HttpParameter> paramList)
  {
    if (paramString2 != null)
      paramList.add(new HttpParameter(paramString1, paramString2));
  }

  private static Query createWithNextPageQuery(String paramString)
  {
    Query localQuery = new Query();
    localQuery.nextPageQuery = paramString;
    return localQuery;
  }

  HttpParameter[] asHttpParameterArray()
  {
    ArrayList localArrayList = new ArrayList(12);
    appendParameter("q", this.query, localArrayList);
    appendParameter("lang", this.lang, localArrayList);
    appendParameter("locale", this.locale, localArrayList);
    appendParameter("max_id", this.maxId, localArrayList);
    appendParameter("count", this.count, localArrayList);
    appendParameter("since", this.since, localArrayList);
    appendParameter("since_id", this.sinceId, localArrayList);
    appendParameter("geocode", this.geocode, localArrayList);
    appendParameter("until", this.until, localArrayList);
    appendParameter("result_type", this.resultType, localArrayList);
    localArrayList.add(WITH_TWITTER_USER_ID);
    return (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()]);
  }

  public Query count(int paramInt)
  {
    setCount(paramInt);
    return this;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Query localQuery;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localQuery = (Query)paramObject;
      if (this.maxId != localQuery.maxId)
        return false;
      if (this.count != localQuery.count)
        return false;
      if (this.sinceId != localQuery.sinceId)
        return false;
      if (this.geocode != null)
      {
        if (this.geocode.equals(localQuery.geocode));
      }
      else
        while (localQuery.geocode != null)
          return false;
      if (this.lang != null)
      {
        if (this.lang.equals(localQuery.lang));
      }
      else
        while (localQuery.lang != null)
          return false;
      if (this.locale != null)
      {
        if (this.locale.equals(localQuery.locale));
      }
      else
        while (localQuery.locale != null)
          return false;
      if (this.nextPageQuery != null)
      {
        if (this.nextPageQuery.equals(localQuery.nextPageQuery));
      }
      else
        while (localQuery.nextPageQuery != null)
          return false;
      if (this.query != null)
      {
        if (this.query.equals(localQuery.query));
      }
      else
        while (localQuery.query != null)
          return false;
      if (this.resultType != null)
      {
        if (this.resultType.equals(localQuery.resultType));
      }
      else
        while (localQuery.resultType != null)
          return false;
      if (this.since != null)
      {
        if (this.since.equals(localQuery.since));
      }
      else
        while (localQuery.since != null)
          return false;
      if (this.until == null)
        break;
    }
    while (this.until.equals(localQuery.until));
    while (true)
    {
      return false;
      if (localQuery.until == null)
        break;
    }
  }

  public Query geoCode(GeoLocation paramGeoLocation, double paramDouble, String paramString)
  {
    setGeoCode(paramGeoLocation, paramDouble, paramString);
    return this;
  }

  public int getCount()
  {
    return this.count;
  }

  public String getGeocode()
  {
    return this.geocode;
  }

  public String getLang()
  {
    return this.lang;
  }

  public String getLocale()
  {
    return this.locale;
  }

  public long getMaxId()
  {
    return this.maxId;
  }

  public String getQuery()
  {
    return this.query;
  }

  public String getResultType()
  {
    return this.resultType;
  }

  public String getSince()
  {
    return this.since;
  }

  public long getSinceId()
  {
    return this.sinceId;
  }

  public String getUntil()
  {
    return this.until;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label110: int i4;
    label153: int i6;
    label179: int i7;
    if (this.query != null)
    {
      i = this.query.hashCode();
      int j = i * 31;
      if (this.lang == null)
        break label249;
      k = this.lang.hashCode();
      int m = 31 * (k + j);
      if (this.locale == null)
        break label254;
      n = this.locale.hashCode();
      int i1 = 31 * (31 * (31 * (n + m) + (int)(this.maxId ^ this.maxId >>> 32)) + this.count);
      if (this.since == null)
        break label260;
      i2 = this.since.hashCode();
      int i3 = 31 * (31 * (i2 + i1) + (int)(this.sinceId ^ this.sinceId >>> 32));
      if (this.geocode == null)
        break label266;
      i4 = this.geocode.hashCode();
      int i5 = 31 * (i4 + i3);
      if (this.until == null)
        break label272;
      i6 = this.until.hashCode();
      i7 = 31 * (i6 + i5);
      if (this.resultType == null)
        break label278;
    }
    label260: label266: label272: label278: for (int i8 = this.resultType.hashCode(); ; i8 = 0)
    {
      int i9 = 31 * (i8 + i7);
      String str = this.nextPageQuery;
      int i10 = 0;
      if (str != null)
        i10 = this.nextPageQuery.hashCode();
      return i9 + i10;
      i = 0;
      break;
      label249: k = 0;
      break label35;
      label254: n = 0;
      break label59;
      i2 = 0;
      break label110;
      i4 = 0;
      break label153;
      i6 = 0;
      break label179;
    }
  }

  public Query lang(String paramString)
  {
    setLang(paramString);
    return this;
  }

  public Query locale(String paramString)
  {
    setLocale(paramString);
    return this;
  }

  public Query maxId(long paramLong)
  {
    setMaxId(paramLong);
    return this;
  }

  String nextPage()
  {
    return this.nextPageQuery;
  }

  public Query query(String paramString)
  {
    setQuery(paramString);
    return this;
  }

  public Query resultType(String paramString)
  {
    setResultType(paramString);
    return this;
  }

  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }

  public void setGeoCode(GeoLocation paramGeoLocation, double paramDouble, String paramString)
  {
    this.geocode = (paramGeoLocation.getLatitude() + "," + paramGeoLocation.getLongitude() + "," + paramDouble + paramString);
  }

  public void setLang(String paramString)
  {
    this.lang = paramString;
  }

  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }

  public void setMaxId(long paramLong)
  {
    this.maxId = paramLong;
  }

  public void setQuery(String paramString)
  {
    this.query = paramString;
  }

  public void setResultType(String paramString)
  {
    this.resultType = paramString;
  }

  public void setSince(String paramString)
  {
    this.since = paramString;
  }

  public void setSinceId(long paramLong)
  {
    this.sinceId = paramLong;
  }

  public void setUntil(String paramString)
  {
    this.until = paramString;
  }

  public Query since(String paramString)
  {
    setSince(paramString);
    return this;
  }

  public Query sinceId(long paramLong)
  {
    setSinceId(paramLong);
    return this;
  }

  public String toString()
  {
    return "Query{query='" + this.query + '\'' + ", lang='" + this.lang + '\'' + ", locale='" + this.locale + '\'' + ", maxId=" + this.maxId + ", count=" + this.count + ", since='" + this.since + '\'' + ", sinceId=" + this.sinceId + ", geocode='" + this.geocode + '\'' + ", until='" + this.until + '\'' + ", resultType='" + this.resultType + '\'' + ", nextPageQuery='" + this.nextPageQuery + '\'' + '}';
  }

  public Query until(String paramString)
  {
    setUntil(paramString);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.Query
 * JD-Core Version:    0.6.2
 */