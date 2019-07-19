package com.viber.voip.messages.conversation.community.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.a;
import com.google.d.a.c;
import java.util.ArrayList;
import java.util.List;

public class CommunitySearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<CommunitySearchResult> CREATOR = new Parcelable.Creator()
  {
    public CommunitySearchResult a(Parcel paramAnonymousParcel)
    {
      return new CommunitySearchResult(paramAnonymousParcel);
    }

    public CommunitySearchResult[] a(int paramAnonymousInt)
    {
      return new CommunitySearchResult[paramAnonymousInt];
    }
  };

  @a
  @c(a="defaultResults")
  private boolean defaultResults;

  @a
  @c(a="groups")
  private List<Group> groups = null;

  @a
  @c(a="result")
  private int result;

  @a
  @c(a="serverDate")
  private String serverDate;

  @a
  @c(a="serverHost")
  private String serverHost;

  @a
  @c(a="totalHits")
  private int totalHits;

  CommunitySearchResult(Parcel paramParcel)
  {
    this.result = paramParcel.readInt();
    this.totalHits = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      this.groups = new ArrayList();
      paramParcel.readList(this.groups, Group.class.getClassLoader());
    }
    if (paramParcel.readByte() > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.defaultResults = bool;
      this.serverDate = paramParcel.readString();
      this.serverHost = paramParcel.readString();
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public List<Group> getGroups()
  {
    return this.groups;
  }

  public int getResult()
  {
    return this.result;
  }

  public String getServerDate()
  {
    return this.serverDate;
  }

  public String getServerHost()
  {
    return this.serverHost;
  }

  public int getTotalHits()
  {
    return this.totalHits;
  }

  public boolean isDefaultResults()
  {
    return this.defaultResults;
  }

  public void setDefaultResults(boolean paramBoolean)
  {
    this.defaultResults = paramBoolean;
  }

  public void setGroups(List<Group> paramList)
  {
    this.groups = paramList;
  }

  public void setResult(int paramInt)
  {
    this.result = paramInt;
  }

  public void setServerDate(String paramString)
  {
    this.serverDate = paramString;
  }

  public void setServerHost(String paramString)
  {
    this.serverHost = paramString;
  }

  public void setTotalHits(int paramInt)
  {
    this.totalHits = paramInt;
  }

  public String toString()
  {
    return "CommunitySearchResult{result=" + this.result + ", totalHits=" + this.totalHits + ", groups=" + this.groups + ", defaultResults=" + this.defaultResults + ", serverDate='" + this.serverDate + '\'' + ", serverHost='" + this.serverHost + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.result);
    paramParcel.writeInt(this.totalHits);
    if (this.groups == null)
    {
      paramParcel.writeInt(0);
      if (!this.defaultResults)
        break label76;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.serverDate);
      paramParcel.writeString(this.serverHost);
      return;
      paramParcel.writeInt(i);
      paramParcel.writeList(this.groups);
      break;
      label76: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.search.CommunitySearchResult
 * JD-Core Version:    0.6.2
 */