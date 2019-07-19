package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

public final class GeoQuery
  implements Serializable
{
  private static final long serialVersionUID = 927081526936169802L;
  private String accuracy = null;
  private String granularity = null;
  private String ip = null;
  private GeoLocation location;
  private int maxResults = -1;
  private String query = null;

  public GeoQuery(String paramString)
  {
    this.ip = paramString;
  }

  public GeoQuery(GeoLocation paramGeoLocation)
  {
    this.location = paramGeoLocation;
  }

  private void appendParameter(String paramString, double paramDouble, List<HttpParameter> paramList)
  {
    paramList.add(new HttpParameter(paramString, String.valueOf(paramDouble)));
  }

  private void appendParameter(String paramString, int paramInt, List<HttpParameter> paramList)
  {
    if (paramInt > 0)
      paramList.add(new HttpParameter(paramString, String.valueOf(paramInt)));
  }

  private void appendParameter(String paramString1, String paramString2, List<HttpParameter> paramList)
  {
    if (paramString2 != null)
      paramList.add(new HttpParameter(paramString1, paramString2));
  }

  public GeoQuery accuracy(String paramString)
  {
    setAccuracy(paramString);
    return this;
  }

  HttpParameter[] asHttpParameterArray()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.location != null)
    {
      appendParameter("lat", this.location.getLatitude(), localArrayList);
      appendParameter("long", this.location.getLongitude(), localArrayList);
    }
    if (this.ip != null)
      appendParameter("ip", this.ip, localArrayList);
    appendParameter("accuracy", this.accuracy, localArrayList);
    appendParameter("query", this.query, localArrayList);
    appendParameter("granularity", this.granularity, localArrayList);
    appendParameter("max_results", this.maxResults, localArrayList);
    return (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()]);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    GeoQuery localGeoQuery;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localGeoQuery = (GeoQuery)paramObject;
      if (this.maxResults != localGeoQuery.maxResults)
        return false;
      if (this.accuracy != null)
      {
        if (this.accuracy.equals(localGeoQuery.accuracy));
      }
      else
        while (localGeoQuery.accuracy != null)
          return false;
      if (this.granularity != null)
      {
        if (this.granularity.equals(localGeoQuery.granularity));
      }
      else
        while (localGeoQuery.granularity != null)
          return false;
      if (this.ip != null)
      {
        if (this.ip.equals(localGeoQuery.ip));
      }
      else
        while (localGeoQuery.ip != null)
          return false;
      if (this.location == null)
        break;
    }
    while (this.location.equals(localGeoQuery.location));
    while (true)
    {
      return false;
      if (localGeoQuery.location == null)
        break;
    }
  }

  public String getAccuracy()
  {
    return this.accuracy;
  }

  public String getGranularity()
  {
    return this.granularity;
  }

  public String getIp()
  {
    return this.ip;
  }

  public GeoLocation getLocation()
  {
    return this.location;
  }

  public int getMaxResults()
  {
    return this.maxResults;
  }

  public String getQuery()
  {
    return this.query;
  }

  public GeoQuery granularity(String paramString)
  {
    setGranularity(paramString);
    return this;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.location != null)
    {
      i = this.location.hashCode();
      int j = i * 31;
      if (this.ip == null)
        break label111;
      k = this.ip.hashCode();
      m = 31 * (k + j);
      if (this.accuracy == null)
        break label116;
    }
    label111: label116: for (int n = this.accuracy.hashCode(); ; n = 0)
    {
      int i1 = 31 * (n + m);
      String str = this.granularity;
      int i2 = 0;
      if (str != null)
        i2 = this.granularity.hashCode();
      return 31 * (i1 + i2) + this.maxResults;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  public GeoQuery maxResults(int paramInt)
  {
    setMaxResults(paramInt);
    return this;
  }

  public void setAccuracy(String paramString)
  {
    this.accuracy = paramString;
  }

  public void setGranularity(String paramString)
  {
    this.granularity = paramString;
  }

  public void setMaxResults(int paramInt)
  {
    this.maxResults = paramInt;
  }

  public void setQuery(String paramString)
  {
    this.query = paramString;
  }

  public String toString()
  {
    return "GeoQuery{location=" + this.location + ", query='" + this.query + '\'' + ", ip='" + this.ip + '\'' + ", accuracy='" + this.accuracy + '\'' + ", granularity='" + this.granularity + '\'' + ", maxResults=" + this.maxResults + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.GeoQuery
 * JD-Core Version:    0.6.2
 */