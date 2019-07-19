package twitter4j;

import java.io.Serializable;

public class GeoLocation
  implements Serializable
{
  private static final long serialVersionUID = -4847567157651889935L;
  protected double latitude;
  protected double longitude;

  GeoLocation()
  {
  }

  public GeoLocation(double paramDouble1, double paramDouble2)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    GeoLocation localGeoLocation;
    do
    {
      return true;
      if (!(paramObject instanceof GeoLocation))
        return false;
      localGeoLocation = (GeoLocation)paramObject;
      if (Double.compare(localGeoLocation.getLatitude(), this.latitude) != 0)
        return false;
    }
    while (Double.compare(localGeoLocation.getLongitude(), this.longitude) == 0);
    return false;
  }

  public double getLatitude()
  {
    return this.latitude;
  }

  public double getLongitude()
  {
    return this.longitude;
  }

  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.latitude);
    int i = (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.longitude);
    return i * 31 + (int)(l2 ^ l2 >>> 32);
  }

  public String toString()
  {
    return "GeoLocation{latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.GeoLocation
 * JD-Core Version:    0.6.2
 */