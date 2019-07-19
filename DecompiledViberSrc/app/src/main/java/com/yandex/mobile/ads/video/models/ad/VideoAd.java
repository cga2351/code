package com.yandex.mobile.ads.video.models.ad;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.fm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VideoAd
  implements Parcelable
{
  public static final Parcelable.Creator<VideoAd> CREATOR = new Parcelable.Creator()
  {
  };
  private static final String ERROR = "error";
  private String mAdSystem;
  private String mAdTitle;
  private List<Creative> mCreatives = new ArrayList();
  private String mDescription;
  private String mSurvey;
  private Map<String, List<String>> mTrackingEvents = new HashMap();
  private String mVastAdTagUri;
  private final boolean mWrapper;

  private VideoAd(Parcel paramParcel)
  {
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.mWrapper = i;
      this.mAdSystem = paramParcel.readString();
      this.mAdTitle = paramParcel.readString();
      this.mDescription = paramParcel.readString();
      this.mSurvey = paramParcel.readString();
      this.mVastAdTagUri = paramParcel.readString();
      paramParcel.readTypedList(this.mCreatives, Creative.CREATOR);
      this.mTrackingEvents = new HashMap();
      int k = paramParcel.readInt();
      while (j < k)
      {
        String str = paramParcel.readString();
        ArrayList localArrayList = paramParcel.readArrayList(getClass().getClassLoader());
        this.mTrackingEvents.put(str, localArrayList);
        j++;
      }
      i = 0;
    }
  }

  private VideoAd(Boolean paramBoolean)
  {
    this.mWrapper = paramBoolean.booleanValue();
  }

  private void addCreative(Creative paramCreative)
  {
    this.mCreatives.add(paramCreative);
  }

  private void addCreatives(Collection<Creative> paramCollection)
  {
    Iterator localIterator = fm.a(paramCollection).iterator();
    while (localIterator.hasNext())
      addCreative((Creative)localIterator.next());
  }

  private void addError(String paramString)
  {
    addTrackingEvent("error", paramString);
  }

  private void addImpression(String paramString)
  {
    addTrackingEvent("impression", paramString);
  }

  private void addImpressions(Collection<String> paramCollection)
  {
    Iterator localIterator = fm.a(paramCollection).iterator();
    while (localIterator.hasNext())
      addImpression((String)localIterator.next());
  }

  private void addTrackingEvent(String paramString1, String paramString2)
  {
    Object localObject = (List)this.mTrackingEvents.get(paramString1);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.mTrackingEvents.put(paramString1, localObject);
    }
    if (!TextUtils.isEmpty(paramString2))
      ((List)localObject).add(paramString2);
  }

  private void setAdSystem(String paramString)
  {
    this.mAdSystem = paramString;
  }

  private void setAdTitle(String paramString)
  {
    this.mAdTitle = paramString;
  }

  private void setDescription(String paramString)
  {
    this.mDescription = paramString;
  }

  private void setSurvey(String paramString)
  {
    this.mSurvey = paramString;
  }

  private void setVastAdTagUri(String paramString)
  {
    this.mVastAdTagUri = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    VideoAd localVideoAd;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localVideoAd = (VideoAd)paramObject;
      if (this.mWrapper != localVideoAd.mWrapper)
        return false;
      if (this.mAdSystem != null)
      {
        if (this.mAdSystem.equals(localVideoAd.mAdSystem));
      }
      else
        while (localVideoAd.mAdSystem != null)
          return false;
      if (this.mAdTitle != null)
      {
        if (this.mAdTitle.equals(localVideoAd.mAdTitle));
      }
      else
        while (localVideoAd.mAdTitle != null)
          return false;
      if (!this.mCreatives.equals(localVideoAd.mCreatives))
        return false;
      if (this.mDescription != null)
      {
        if (this.mDescription.equals(localVideoAd.mDescription));
      }
      else
        while (localVideoAd.mDescription != null)
          return false;
      if (this.mSurvey != null)
      {
        if (this.mSurvey.equals(localVideoAd.mSurvey));
      }
      else
        while (localVideoAd.mSurvey != null)
          return false;
      if (!this.mTrackingEvents.equals(localVideoAd.mTrackingEvents))
        return false;
      if (this.mVastAdTagUri == null)
        break;
    }
    while (this.mVastAdTagUri.equals(localVideoAd.mVastAdTagUri));
    while (true)
    {
      return false;
      if (localVideoAd.mVastAdTagUri == null)
        break;
    }
  }

  public String getAdSystem()
  {
    return this.mAdSystem;
  }

  public String getAdTitle()
  {
    return this.mAdTitle;
  }

  public List<Creative> getCreatives()
  {
    return this.mCreatives;
  }

  public String getDescription()
  {
    return this.mDescription;
  }

  public String getSurvey()
  {
    return this.mSurvey;
  }

  public Map<String, List<String>> getTrackingEvents()
  {
    return Collections.unmodifiableMap(this.mTrackingEvents);
  }

  public String getVastAdTagUri()
  {
    return this.mVastAdTagUri;
  }

  public int hashCode()
  {
    int i;
    int k;
    label29: int n;
    label53: int i2;
    label79: int i3;
    if (this.mAdSystem != null)
    {
      i = this.mAdSystem.hashCode();
      int j = i * 31;
      if (!this.mWrapper)
        break label175;
      k = 1;
      int m = 31 * (k + j);
      if (this.mAdTitle == null)
        break label180;
      n = this.mAdTitle.hashCode();
      int i1 = 31 * (n + m);
      if (this.mDescription == null)
        break label186;
      i2 = this.mDescription.hashCode();
      i3 = 31 * (i2 + i1);
      if (this.mSurvey == null)
        break label192;
    }
    label175: label180: label186: label192: for (int i4 = this.mSurvey.hashCode(); ; i4 = 0)
    {
      int i5 = 31 * (i4 + i3);
      String str = this.mVastAdTagUri;
      int i6 = 0;
      if (str != null)
        i6 = this.mVastAdTagUri.hashCode();
      return 31 * (31 * (i5 + i6) + this.mCreatives.hashCode()) + this.mTrackingEvents.hashCode();
      i = 0;
      break;
      k = 0;
      break label29;
      n = 0;
      break label53;
      i2 = 0;
      break label79;
    }
  }

  public boolean isWrapper()
  {
    return this.mWrapper;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mWrapper);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.mAdSystem);
      paramParcel.writeString(this.mAdTitle);
      paramParcel.writeString(this.mDescription);
      paramParcel.writeString(this.mSurvey);
      paramParcel.writeString(this.mVastAdTagUri);
      paramParcel.writeTypedList(this.mCreatives);
      paramParcel.writeInt(this.mTrackingEvents.size());
      Iterator localIterator = this.mTrackingEvents.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeList((List)localEntry.getValue());
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.models.ad.VideoAd
 * JD-Core Version:    0.6.2
 */