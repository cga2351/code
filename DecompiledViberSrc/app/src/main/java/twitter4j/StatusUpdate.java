package twitter4j;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

public final class StatusUpdate
  implements Serializable
{
  private static final long serialVersionUID = -3595502688477609916L;
  private boolean displayCoordinates = true;
  private long inReplyToStatusId = -1L;
  private GeoLocation location = null;
  private transient InputStream mediaBody;
  private File mediaFile;
  private String mediaName;
  private String placeId = null;
  private boolean possiblySensitive;
  private String status;

  public StatusUpdate(String paramString)
  {
    this.status = paramString;
  }

  private void appendParameter(String paramString, double paramDouble, List<HttpParameter> paramList)
  {
    paramList.add(new HttpParameter(paramString, String.valueOf(paramDouble)));
  }

  private void appendParameter(String paramString, long paramLong, List<HttpParameter> paramList)
  {
    paramList.add(new HttpParameter(paramString, String.valueOf(paramLong)));
  }

  private void appendParameter(String paramString1, String paramString2, List<HttpParameter> paramList)
  {
    if (paramString2 != null)
      paramList.add(new HttpParameter(paramString1, paramString2));
  }

  HttpParameter[] asHttpParameterArray()
  {
    ArrayList localArrayList = new ArrayList();
    appendParameter("status", this.status, localArrayList);
    if (-1L != this.inReplyToStatusId)
      appendParameter("in_reply_to_status_id", this.inReplyToStatusId, localArrayList);
    if (this.location != null)
    {
      appendParameter("lat", this.location.getLatitude(), localArrayList);
      appendParameter("long", this.location.getLongitude(), localArrayList);
    }
    appendParameter("place_id", this.placeId, localArrayList);
    if (!this.displayCoordinates)
      appendParameter("display_coordinates", "false", localArrayList);
    if (this.mediaFile != null)
    {
      localArrayList.add(new HttpParameter("media[]", this.mediaFile));
      localArrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
    }
    while (true)
    {
      return (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()]);
      if ((this.mediaName != null) && (this.mediaBody != null))
      {
        localArrayList.add(new HttpParameter("media[]", this.mediaName, this.mediaBody));
        localArrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
      }
    }
  }

  public StatusUpdate displayCoordinates(boolean paramBoolean)
  {
    setDisplayCoordinates(paramBoolean);
    return this;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StatusUpdate localStatusUpdate;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localStatusUpdate = (StatusUpdate)paramObject;
      if (this.displayCoordinates != localStatusUpdate.displayCoordinates)
        return false;
      if (this.inReplyToStatusId != localStatusUpdate.inReplyToStatusId)
        return false;
      if (this.possiblySensitive != localStatusUpdate.possiblySensitive)
        return false;
      if (this.location != null)
      {
        if (this.location.equals(localStatusUpdate.location));
      }
      else
        while (localStatusUpdate.location != null)
          return false;
      if (this.mediaBody != null)
      {
        if (this.mediaBody.equals(localStatusUpdate.mediaBody));
      }
      else
        while (localStatusUpdate.mediaBody != null)
          return false;
      if (this.mediaFile != null)
      {
        if (this.mediaFile.equals(localStatusUpdate.mediaFile));
      }
      else
        while (localStatusUpdate.mediaFile != null)
          return false;
      if (this.mediaName != null)
      {
        if (this.mediaName.equals(localStatusUpdate.mediaName));
      }
      else
        while (localStatusUpdate.mediaName != null)
          return false;
      if (this.placeId != null)
      {
        if (this.placeId.equals(localStatusUpdate.placeId));
      }
      else
        while (localStatusUpdate.placeId != null)
          return false;
      if (this.status == null)
        break;
    }
    while (this.status.equals(localStatusUpdate.status));
    while (true)
    {
      return false;
      if (localStatusUpdate.status == null)
        break;
    }
  }

  public long getInReplyToStatusId()
  {
    return this.inReplyToStatusId;
  }

  public GeoLocation getLocation()
  {
    return this.location;
  }

  public String getPlaceId()
  {
    return this.placeId;
  }

  public String getStatus()
  {
    return this.status;
  }

  public int hashCode()
  {
    int i = 1;
    int j;
    int m;
    label55: int i1;
    label80: int i3;
    label100: label117: int i6;
    label142: int i7;
    if (this.status != null)
    {
      j = this.status.hashCode();
      int k = 31 * (j * 31 + (int)(this.inReplyToStatusId ^ this.inReplyToStatusId >>> 32));
      if (this.location == null)
        break label212;
      m = this.location.hashCode();
      int n = 31 * (m + k);
      if (this.placeId == null)
        break label218;
      i1 = this.placeId.hashCode();
      int i2 = 31 * (i1 + n);
      if (!this.displayCoordinates)
        break label224;
      i3 = i;
      int i4 = 31 * (i3 + i2);
      if (!this.possiblySensitive)
        break label230;
      int i5 = 31 * (i4 + i);
      if (this.mediaName == null)
        break label235;
      i6 = this.mediaName.hashCode();
      i7 = 31 * (i6 + i5);
      if (this.mediaBody == null)
        break label241;
    }
    label212: label218: label224: label230: label235: label241: for (int i8 = this.mediaBody.hashCode(); ; i8 = 0)
    {
      int i9 = 31 * (i8 + i7);
      File localFile = this.mediaFile;
      int i10 = 0;
      if (localFile != null)
        i10 = this.mediaFile.hashCode();
      return i9 + i10;
      j = 0;
      break;
      m = 0;
      break label55;
      i1 = 0;
      break label80;
      i3 = 0;
      break label100;
      i = 0;
      break label117;
      i6 = 0;
      break label142;
    }
  }

  public StatusUpdate inReplyToStatusId(long paramLong)
  {
    setInReplyToStatusId(paramLong);
    return this;
  }

  public boolean isDisplayCoordinates()
  {
    return this.displayCoordinates;
  }

  public boolean isPossiblySensitive()
  {
    return this.possiblySensitive;
  }

  boolean isWithMedia()
  {
    return (this.mediaFile != null) || (this.mediaName != null);
  }

  public StatusUpdate location(GeoLocation paramGeoLocation)
  {
    setLocation(paramGeoLocation);
    return this;
  }

  public StatusUpdate media(File paramFile)
  {
    setMedia(paramFile);
    return this;
  }

  public StatusUpdate media(String paramString, InputStream paramInputStream)
  {
    setMedia(paramString, paramInputStream);
    return this;
  }

  public StatusUpdate placeId(String paramString)
  {
    setPlaceId(paramString);
    return this;
  }

  public StatusUpdate possiblySensitive(boolean paramBoolean)
  {
    setPossiblySensitive(paramBoolean);
    return this;
  }

  public void setDisplayCoordinates(boolean paramBoolean)
  {
    this.displayCoordinates = paramBoolean;
  }

  public void setInReplyToStatusId(long paramLong)
  {
    this.inReplyToStatusId = paramLong;
  }

  public void setLocation(GeoLocation paramGeoLocation)
  {
    this.location = paramGeoLocation;
  }

  public void setMedia(File paramFile)
  {
    this.mediaFile = paramFile;
  }

  public void setMedia(String paramString, InputStream paramInputStream)
  {
    this.mediaName = paramString;
    this.mediaBody = paramInputStream;
  }

  public void setPlaceId(String paramString)
  {
    this.placeId = paramString;
  }

  public void setPossiblySensitive(boolean paramBoolean)
  {
    this.possiblySensitive = paramBoolean;
  }

  public String toString()
  {
    return "StatusUpdate{status='" + this.status + '\'' + ", inReplyToStatusId=" + this.inReplyToStatusId + ", location=" + this.location + ", placeId='" + this.placeId + '\'' + ", displayCoordinates=" + this.displayCoordinates + ", possiblySensitive=" + this.possiblySensitive + ", mediaName='" + this.mediaName + '\'' + ", mediaBody=" + this.mediaBody + ", mediaFile=" + this.mediaFile + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.StatusUpdate
 * JD-Core Version:    0.6.2
 */