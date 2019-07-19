package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.d.a.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class InternalBrowser
  implements Parcelable
{
  public static final Parcelable.Creator<InternalBrowser> CREATOR = new Parcelable.Creator()
  {
    public InternalBrowser a(Parcel paramAnonymousParcel)
    {
      return new InternalBrowser(paramAnonymousParcel);
    }

    public InternalBrowser[] a(int paramAnonymousInt)
    {
      return new InternalBrowser[paramAnonymousInt];
    }
  };

  @c(a="ActionButton")
  private a mActionButton;

  @c(a="ActionPredefinedURL")
  private String mActionPredefinedUrl;

  @c(a="ActionReplyData")
  private String mActionReplyData;

  @c(a="CustomTitle")
  private String mCustomTitle;

  @c(a="Mode")
  private b mOpenMode;

  @c(a="TitleType")
  private c mTitleType;

  public InternalBrowser()
  {
  }

  protected InternalBrowser(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    a locala;
    int j;
    c localc;
    label44: int k;
    b localb;
    if (i == -1)
    {
      locala = null;
      this.mActionButton = locala;
      this.mActionPredefinedUrl = paramParcel.readString();
      j = paramParcel.readInt();
      if (j != -1)
        break label104;
      localc = null;
      this.mTitleType = localc;
      this.mCustomTitle = paramParcel.readString();
      k = paramParcel.readInt();
      localb = null;
      if (k != -1)
        break label122;
    }
    while (true)
    {
      this.mOpenMode = localb;
      this.mActionReplyData = paramParcel.readString();
      return;
      locala = (a)a.list().get(i);
      break;
      label104: localc = (c)c.list().get(j);
      break label44;
      label122: localb = (b)b.list().get(k);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject)
      bool3 = bool1;
    InternalBrowser localInternalBrowser;
    label135: b localb1;
    b localb2;
    do
    {
      boolean bool4;
      do
      {
        c localc1;
        c localc2;
        do
        {
          boolean bool5;
          do
          {
            a locala1;
            a locala2;
            do
            {
              boolean bool2;
              do
              {
                return bool3;
                bool2 = paramObject instanceof InternalBrowser;
                bool3 = false;
              }
              while (!bool2);
              localInternalBrowser = (InternalBrowser)paramObject;
              locala1 = getActionButton();
              locala2 = localInternalBrowser.getActionButton();
              bool3 = false;
            }
            while (locala1 != locala2);
            if (getActionPredefinedUrl() == null)
              break;
            bool5 = getActionPredefinedUrl().equals(localInternalBrowser.getActionPredefinedUrl());
            bool3 = false;
          }
          while (!bool5);
          localc1 = getTitleType();
          localc2 = localInternalBrowser.getTitleType();
          bool3 = false;
        }
        while (localc1 != localc2);
        if (getCustomTitle() == null)
          break label190;
        bool4 = getCustomTitle().equals(localInternalBrowser.getCustomTitle());
        bool3 = false;
      }
      while (!bool4);
      localb1 = getOpenMode();
      localb2 = localInternalBrowser.getOpenMode();
      bool3 = false;
    }
    while (localb1 != localb2);
    if (getActionReplyData() != null)
      bool1 = getActionReplyData().equals(localInternalBrowser.getActionReplyData());
    while (true)
    {
      return bool1;
      if (localInternalBrowser.getActionPredefinedUrl() == null)
        break;
      return false;
      label190: if (localInternalBrowser.getCustomTitle() == null)
        break label135;
      return false;
      if (localInternalBrowser.getActionReplyData() != null)
        bool1 = false;
    }
  }

  public a getActionButton()
  {
    return this.mActionButton;
  }

  public String getActionPredefinedUrl()
  {
    return this.mActionPredefinedUrl;
  }

  public String getActionReplyData()
  {
    return this.mActionReplyData;
  }

  public String getCustomTitle()
  {
    return this.mCustomTitle;
  }

  public b getOpenMode()
  {
    if (this.mOpenMode != null)
      return this.mOpenMode;
    return b.getDefaultValue();
  }

  public c getTitleType()
  {
    if (this.mTitleType != null)
      return this.mTitleType;
    return c.getDefaultValue();
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i3;
    if (getActionButton() != null)
    {
      i = getActionButton().hashCode();
      int j = i * 31;
      if (getActionPredefinedUrl() == null)
        break label155;
      k = getActionPredefinedUrl().hashCode();
      int m = 31 * (k + j);
      if (getTitleType() == null)
        break label160;
      n = getTitleType().hashCode();
      int i1 = 31 * (n + m);
      if (getCustomTitle() == null)
        break label166;
      i2 = getCustomTitle().hashCode();
      i3 = 31 * (i2 + i1);
      if (getOpenMode() == null)
        break label172;
    }
    label155: label160: label166: label172: for (int i4 = getOpenMode().hashCode(); ; i4 = 0)
    {
      int i5 = 31 * (i4 + i3);
      String str = getActionReplyData();
      int i6 = 0;
      if (str != null)
        i6 = getActionReplyData().hashCode();
      return i5 + i6;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
    }
  }

  public void setActionButton(a parama)
  {
    this.mActionButton = parama;
  }

  public void setActionPredefinedUrl(String paramString)
  {
    this.mActionPredefinedUrl = paramString;
  }

  public void setActionReplyData(String paramString)
  {
    this.mActionReplyData = paramString;
  }

  public void setCustomTitle(String paramString)
  {
    this.mCustomTitle = paramString;
  }

  public void setOpenMode(b paramb)
  {
    this.mOpenMode = paramb;
  }

  public void setTitleType(c paramc)
  {
    this.mTitleType = paramc;
  }

  public String toString()
  {
    return "InternalBrowser{mActionButton=" + this.mActionButton + ", mActionPredefinedUrl='" + this.mActionPredefinedUrl + '\'' + ", mTitleType=" + this.mTitleType + ", mCustomTitle='" + this.mCustomTitle + '\'' + ", mOpenMode=" + this.mOpenMode + ", mActionReplyData=" + this.mActionReplyData + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    int j;
    int k;
    if (this.mActionButton == null)
    {
      j = i;
      paramParcel.writeInt(j);
      paramParcel.writeString(this.mActionPredefinedUrl);
      if (this.mTitleType != null)
        break label83;
      k = i;
      label36: paramParcel.writeInt(k);
      paramParcel.writeString(this.mCustomTitle);
      if (this.mOpenMode != null)
        break label95;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.mActionReplyData);
      return;
      j = this.mActionButton.ordinal();
      break;
      label83: k = this.mTitleType.ordinal();
      break label36;
      label95: i = this.mOpenMode.ordinal();
    }
  }

  public static enum a
  {
    private static final List<a> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private final String mTypeName;

    static
    {
      OPEN_EXTERNALLY = new a("OPEN_EXTERNALLY", 2, "open-externally");
      SEND_TO_BOT = new a("SEND_TO_BOT", 3, "send-to-bot");
      NONE = new a("NONE", 4, "none");
      a[] arrayOfa = new a[5];
      arrayOfa[0] = FORWARD;
      arrayOfa[1] = SEND;
      arrayOfa[2] = OPEN_EXTERNALLY;
      arrayOfa[3] = SEND_TO_BOT;
      arrayOfa[4] = NONE;
    }

    private a(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static List<a> list()
    {
      return VALUES;
    }

    public static a of(String paramString)
    {
      Iterator localIterator = list().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.mTypeName.equalsIgnoreCase(paramString))
          return locala;
      }
      return null;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }

  public static enum b
  {
    private static final List<b> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private final String mTypeName;

    static
    {
      FULLSCREEN_LANDSCAPE = new b("FULLSCREEN_LANDSCAPE", 2, "fullscreen-landscape");
      PARTIAL_SIZE = new b("PARTIAL_SIZE", 3, "partial-size");
      b[] arrayOfb = new b[4];
      arrayOfb[0] = FULLSCREEN;
      arrayOfb[1] = FULLSCREEN_PORTRAIT;
      arrayOfb[2] = FULLSCREEN_LANDSCAPE;
      arrayOfb[3] = PARTIAL_SIZE;
    }

    private b(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static b getDefaultValue()
    {
      return FULLSCREEN;
    }

    public static List<b> list()
    {
      return VALUES;
    }

    public static b of(String paramString)
    {
      Iterator localIterator = list().iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.mTypeName.equalsIgnoreCase(paramString))
          return localb;
      }
      return null;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }

  public static enum c
  {
    private static final List<c> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private final String mTypeName;

    static
    {
      c[] arrayOfc = new c[2];
      arrayOfc[0] = DEFAULT;
      arrayOfc[1] = DOMAIN;
    }

    private c(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static c getDefaultValue()
    {
      return DEFAULT;
    }

    public static List<c> list()
    {
      return VALUES;
    }

    public static c of(String paramString)
    {
      Iterator localIterator = list().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.mTypeName.equalsIgnoreCase(paramString))
          return localc;
      }
      return null;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.InternalBrowser
 * JD-Core Version:    0.6.2
 */