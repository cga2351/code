package com.yandex.mobile.ads.video.models.ad;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.yandex.mobile.ads.impl.fm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Creative
  implements Parcelable
{
  public static final Parcelable.Creator<Creative> CREATOR = new Parcelable.Creator()
  {
  };
  private final ArrayList<String> mClickThroughEvents = new ArrayList();
  private int mDurationMillis;
  private List<Icon> mIcons = new ArrayList();
  private String mId;
  private List<MediaFile> mMediaFiles = new ArrayList();
  private Map<String, List<String>> mTrackingEvents = new HashMap();

  private Creative()
  {
  }

  public Creative(Parcel paramParcel)
  {
    this.mId = paramParcel.readString();
    this.mDurationMillis = paramParcel.readInt();
    paramParcel.readTypedList(this.mMediaFiles, MediaFile.CREATOR);
    this.mTrackingEvents = new HashMap();
    int j = paramParcel.readInt();
    for (int k = 0; k < j; k++)
    {
      String str = paramParcel.readString();
      ArrayList localArrayList = paramParcel.readArrayList(getClass().getClassLoader());
      this.mTrackingEvents.put(str, localArrayList);
    }
    int m = paramParcel.readInt();
    while (i < m)
    {
      this.mClickThroughEvents.add(paramParcel.readString());
      i++;
    }
  }

  private void addClickThroughUrls(Collection<String> paramCollection)
  {
    this.mClickThroughEvents.addAll(fm.a(paramCollection));
  }

  private void addIcons(Collection<Icon> paramCollection)
  {
    Iterator localIterator = fm.a(paramCollection).iterator();
    while (localIterator.hasNext())
    {
      Icon localIcon = (Icon)localIterator.next();
      this.mIcons.add(localIcon);
    }
  }

  private void addMediaFile(MediaFile paramMediaFile)
  {
    this.mMediaFiles.add(paramMediaFile);
  }

  private void addMediaFiles(Collection<MediaFile> paramCollection)
  {
    Iterator localIterator = fm.a(paramCollection).iterator();
    while (localIterator.hasNext())
      addMediaFile((MediaFile)localIterator.next());
  }

  private void addTrackingEvent(String paramString1, String paramString2)
  {
    Object localObject = (List)this.mTrackingEvents.get(paramString1);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.mTrackingEvents.put(paramString1, localObject);
    }
    ((List)localObject).add(paramString2);
  }

  private void addTrackingEvents(Collection<Pair<String, String>> paramCollection)
  {
    Iterator localIterator = fm.a(paramCollection).iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      addTrackingEvent((String)localPair.first, (String)localPair.second);
    }
  }

  private void setDurationHHMMSS(String paramString)
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("hh:mm:ss");
      this.mDurationMillis = ((int)(localSimpleDateFormat.parse(paramString).getTime() - localSimpleDateFormat.parse("00:00:00").getTime()));
      return;
    }
    catch (ParseException localParseException)
    {
    }
  }

  private void setDurationMillis(int paramInt)
  {
    this.mDurationMillis = paramInt;
  }

  private void setId(String paramString)
  {
    this.mId = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Creative localCreative;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCreative = (Creative)paramObject;
      if (this.mDurationMillis != localCreative.mDurationMillis)
        return false;
      if (this.mClickThroughEvents != null)
      {
        if (this.mClickThroughEvents.equals(localCreative.mClickThroughEvents));
      }
      else
        while (localCreative.mClickThroughEvents != null)
          return false;
      if (this.mId != null)
      {
        if (this.mId.equals(localCreative.mId));
      }
      else
        while (localCreative.mId != null)
          return false;
      if (this.mMediaFiles != null)
      {
        if (this.mMediaFiles.equals(localCreative.mMediaFiles));
      }
      else
        while (localCreative.mMediaFiles != null)
          return false;
      if (this.mTrackingEvents == null)
        break;
    }
    while (this.mTrackingEvents.equals(localCreative.mTrackingEvents));
    while (true)
    {
      return false;
      if (localCreative.mTrackingEvents == null)
        break;
    }
  }

  public String getClickThroughUrl()
  {
    if (this.mClickThroughEvents.isEmpty())
      return null;
    return (String)this.mClickThroughEvents.get(0);
  }

  public int getDurationMillis()
  {
    return this.mDurationMillis;
  }

  public List<Icon> getIcons()
  {
    return Collections.unmodifiableList(this.mIcons);
  }

  public String getId()
  {
    return this.mId;
  }

  public List<MediaFile> getMediaFiles()
  {
    return Collections.unmodifiableList(this.mMediaFiles);
  }

  public Map<String, List<String>> getTrackingEvents()
  {
    return Collections.unmodifiableMap(this.mTrackingEvents);
  }

  public int hashCode()
  {
    int i;
    int k;
    label45: int m;
    if (this.mId != null)
    {
      i = this.mId.hashCode();
      int j = 31 * (i * 31 + this.mDurationMillis);
      if (this.mMediaFiles == null)
        break label115;
      k = this.mMediaFiles.hashCode();
      m = 31 * (k + j);
      if (this.mTrackingEvents == null)
        break label120;
    }
    label115: label120: for (int n = this.mTrackingEvents.hashCode(); ; n = 0)
    {
      int i1 = 31 * (n + m);
      ArrayList localArrayList = this.mClickThroughEvents;
      int i2 = 0;
      if (localArrayList != null)
        i2 = this.mClickThroughEvents.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label45;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mId);
    paramParcel.writeInt(this.mDurationMillis);
    paramParcel.writeTypedList(this.mMediaFiles);
    paramParcel.writeInt(this.mTrackingEvents.size());
    Iterator localIterator1 = this.mTrackingEvents.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeList((List)localEntry.getValue());
    }
    paramParcel.writeInt(this.mClickThroughEvents.size());
    Iterator localIterator2 = this.mClickThroughEvents.iterator();
    while (localIterator2.hasNext())
      paramParcel.writeString((String)localIterator2.next());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.models.ad.Creative
 * JD-Core Version:    0.6.2
 */