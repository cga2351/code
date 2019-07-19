package com.viber.voip.messages.conversation.community.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.a;
import com.google.d.a.c;

public class Group
  implements Parcelable
{
  public static final Parcelable.Creator<Group> CREATOR = new Parcelable.Creator()
  {
    public Group a(Parcel paramAnonymousParcel)
    {
      return new Group(paramAnonymousParcel);
    }

    public Group[] a(int paramAnonymousInt)
    {
      return new Group[paramAnonymousInt];
    }
  };

  @a
  @c(a="bkgrd")
  private String bkgrd;

  @a
  @c(a="cc")
  private String cc;

  @a
  @c(a="communityPrivileges")
  private long communityPrivileges;

  @a
  @c(a="fl")
  private int fl;

  @a
  @c(a="hasJokerButtons")
  private boolean hasJokerButtons;

  @a
  @c(a="hasWebhook")
  private boolean hasWebhook;

  @a
  @c(a="icn")
  private String icn;

  @a
  @c(a="id")
  private String id;

  @a
  @c(a="language")
  private String language;

  @a
  @c(a="loc")
  private Loc loc;

  @a
  @c(a="name")
  private String name;

  @a
  @c(a="numSpkrs")
  private int numSpkrs;

  @a
  @c(a="numSubs")
  private int numSubs;

  @a
  @c(a="numWchrs")
  private int numWchrs;

  @a
  @c(a="rev")
  private int rev;

  @a
  @c(a="st")
  private int st;

  @a
  @c(a="tagln")
  private String tagln;

  @a
  @c(a="typ")
  private int typ;

  Group(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.icn = paramParcel.readString();
    this.bkgrd = paramParcel.readString();
    this.rev = paramParcel.readInt();
    this.numWchrs = paramParcel.readInt();
    this.numSpkrs = paramParcel.readInt();
    this.numSubs = paramParcel.readInt();
    this.id = paramParcel.readString();
    this.cc = paramParcel.readString();
    this.loc = ((Loc)paramParcel.readParcelable(Loc.class.getClassLoader()));
    this.tagln = paramParcel.readString();
    this.typ = paramParcel.readInt();
    this.st = paramParcel.readInt();
    boolean bool2;
    if (paramParcel.readByte() > 0)
    {
      bool2 = bool1;
      this.hasJokerButtons = bool2;
      this.fl = paramParcel.readInt();
      this.communityPrivileges = paramParcel.readLong();
      if (paramParcel.readByte() <= 0)
        break label174;
    }
    while (true)
    {
      this.hasWebhook = bool1;
      this.language = paramParcel.readString();
      return;
      bool2 = false;
      break;
      label174: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String getBkgrd()
  {
    return this.bkgrd;
  }

  public String getCc()
  {
    return this.cc;
  }

  public long getCommunityPrivileges()
  {
    return this.communityPrivileges;
  }

  public int getFl()
  {
    return this.fl;
  }

  public String getIcn()
  {
    return this.icn;
  }

  public String getId()
  {
    return this.id;
  }

  public String getLanguage()
  {
    return this.language;
  }

  public Loc getLoc()
  {
    return this.loc;
  }

  public String getName()
  {
    return this.name;
  }

  public int getNumSpkrs()
  {
    return this.numSpkrs;
  }

  public int getNumSubs()
  {
    return this.numSubs;
  }

  public int getNumWchrs()
  {
    return this.numWchrs;
  }

  public int getRev()
  {
    return this.rev;
  }

  public int getSt()
  {
    return this.st;
  }

  public String getTagln()
  {
    return this.tagln;
  }

  public int getTyp()
  {
    return this.typ;
  }

  public boolean isHasJokerButtons()
  {
    return this.hasJokerButtons;
  }

  public boolean isHasWebhook()
  {
    return this.hasWebhook;
  }

  public void setBkgrd(String paramString)
  {
    this.bkgrd = paramString;
  }

  public void setCc(String paramString)
  {
    this.cc = paramString;
  }

  public void setCommunityPrivileges(long paramLong)
  {
    this.communityPrivileges = paramLong;
  }

  public void setFl(int paramInt)
  {
    this.fl = paramInt;
  }

  public void setHasJokerButtons(boolean paramBoolean)
  {
    this.hasJokerButtons = paramBoolean;
  }

  public void setHasWebhook(boolean paramBoolean)
  {
    this.hasWebhook = paramBoolean;
  }

  public void setIcn(String paramString)
  {
    this.icn = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }

  public void setLoc(Loc paramLoc)
  {
    this.loc = paramLoc;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setNumSpkrs(int paramInt)
  {
    this.numSpkrs = paramInt;
  }

  public void setNumSubs(int paramInt)
  {
    this.numSubs = paramInt;
  }

  public void setNumWchrs(int paramInt)
  {
    this.numWchrs = paramInt;
  }

  public void setRev(int paramInt)
  {
    this.rev = paramInt;
  }

  public void setSt(int paramInt)
  {
    this.st = paramInt;
  }

  public void setTagln(String paramString)
  {
    this.tagln = paramString;
  }

  public void setTyp(int paramInt)
  {
    this.typ = paramInt;
  }

  public String toString()
  {
    return "Group{name='" + this.name + '\'' + ", icn='" + this.icn + '\'' + ", bkgrd='" + this.bkgrd + '\'' + ", rev=" + this.rev + ", numWchrs=" + this.numWchrs + ", numSpkrs=" + this.numSpkrs + ", numSubs=" + this.numSubs + ", id='" + this.id + '\'' + ", cc='" + this.cc + '\'' + ", loc=" + this.loc + ", tagln='" + this.tagln + '\'' + ", typ=" + this.typ + ", st=" + this.st + ", hasJokerButtons=" + this.hasJokerButtons + ", fl=" + this.fl + ", communityPrivileges='" + this.communityPrivileges + '\'' + ", hasWebhook=" + this.hasWebhook + ", language='" + this.language + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.icn);
    paramParcel.writeString(this.bkgrd);
    paramParcel.writeInt(this.rev);
    paramParcel.writeInt(this.numWchrs);
    paramParcel.writeInt(this.numSpkrs);
    paramParcel.writeInt(this.numSubs);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.cc);
    paramParcel.writeParcelable(this.loc, paramInt);
    paramParcel.writeString(this.tagln);
    paramParcel.writeInt(this.typ);
    paramParcel.writeInt(this.st);
    int j;
    if (this.hasJokerButtons)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      paramParcel.writeInt(this.fl);
      paramParcel.writeLong(this.communityPrivileges);
      if (!this.hasWebhook)
        break label168;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.language);
      return;
      j = 0;
      break;
      label168: i = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.search.Group
 * JD-Core Version:    0.6.2
 */