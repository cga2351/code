package com.viber.voip.stickers.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.f;
import com.viber.voip.bot.item.KeyboardItem;
import com.viber.voip.stickers.c.g;
import com.viber.voip.stickers.p;
import com.viber.voip.stickers.w;
import com.viber.voip.util.av;
import java.io.File;
import java.util.Collection;

public class Sticker extends KeyboardItem
  implements Comparable<Sticker>
{
  public static final Parcelable.Creator<Sticker> CREATOR = new Parcelable.Creator()
  {
    public Sticker a(Parcel paramAnonymousParcel)
    {
      return new Sticker(paramAnonymousParcel, null);
    }

    public Sticker[] a(int paramAnonymousInt)
    {
      return new Sticker[paramAnonymousInt];
    }
  };
  public static final String EXTENTION_MP3 = ".mp3";
  public static final String EXTENTION_PNG = ".png";
  public static final String EXTENTION_SVG = ".svg";
  private static final Logger L = ViberEnv.getLogger();
  private static final String RESOLUTION_FILE_PREFIX = "r" + p.a + "_";
  private String conversationPathKey;
  private String fileBase;
  private int flags;
  private String folderPath;
  public int id;
  private boolean isInDatabase;
  private boolean isReady;
  private String menuLandPathKey;
  private String menuPortPathKey;
  private String origFramePath;
  private String origPath;
  private String origSoundPath;
  public int packageId;
  private String thumbPath;
  private String thumbPathKey;
  public a type;

  public Sticker(int paramInt)
  {
    this(paramInt, 0, 0, 2, 2, false, 0, false);
  }

  public Sticker(int paramInt1, int paramInt2)
  {
    this(paramInt1, 0, 0, 2, 2, false, paramInt2, false);
  }

  public Sticker(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.flags = paramInt7;
    prepare(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }

  public Sticker(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, int paramInt6, boolean paramBoolean2)
  {
    setIsFrameFromAssets(paramBoolean1);
    setIsSvg(paramBoolean2);
    prepare(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }

  private Sticker(Parcel paramParcel)
  {
    super(paramParcel);
    this.id = paramParcel.readInt();
    this.type = a.values()[paramParcel.readInt()];
    this.packageId = paramParcel.readInt();
    this.fileBase = paramParcel.readString();
    this.folderPath = paramParcel.readString();
    this.origPath = paramParcel.readString();
    this.origFramePath = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.flags = paramParcel.readInt();
    int j;
    if (paramParcel.readByte() == i)
    {
      j = i;
      this.isReady = j;
      if (paramParcel.readByte() != i)
        break label149;
    }
    while (true)
    {
      this.isInDatabase = i;
      this.menuLandPathKey = paramParcel.readString();
      this.menuPortPathKey = paramParcel.readString();
      this.conversationPathKey = paramParcel.readString();
      this.thumbPathKey = paramParcel.readString();
      return;
      j = 0;
      break;
      label149: i = 0;
    }
  }

  private String getConversationPathKey()
  {
    if (this.conversationPathKey == null)
      this.conversationPathKey = (w.b.a() + getOrigPath(false));
    return this.conversationPathKey;
  }

  private static String getFileBase(int paramInt)
  {
    String str = Integer.toString(paramInt);
    StringBuilder localStringBuilder = new StringBuilder(8);
    int i = 0;
    int j = 8 - str.length();
    while (i < j)
    {
      localStringBuilder.append('0');
      i++;
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }

  private String getMenuKey(boolean paramBoolean)
  {
    if (paramBoolean)
      return getMenuPortPathKey();
    return getMenuLandPathKey();
  }

  private String getMenuLandPathKey()
  {
    if (this.menuLandPathKey == null)
      this.menuLandPathKey = (w.a.a(false) + getOrigPath(false));
    return this.menuLandPathKey;
  }

  private String getMenuPortPathKey()
  {
    if (this.menuPortPathKey == null)
      this.menuPortPathKey = (w.a.a(true) + getOrigPath(false));
    return this.menuPortPathKey;
  }

  private String getScaledPath(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(90);
    localStringBuilder.append(this.folderPath).append(RESOLUTION_FILE_PREFIX).append(this.fileBase).append("_scaled").append(paramString).append("_").append(paramInt1).append('x').append(paramInt2).append(".png");
    return localStringBuilder.toString();
  }

  private int getSize(float paramFloat, int paramInt)
  {
    float f = paramFloat * p.a(this.packageId).c();
    return (int)(0.5F + (paramFloat * paramInt + f * (paramInt - 1)));
  }

  private String getThumbPathKey()
  {
    if (this.thumbPathKey == null)
      this.thumbPathKey = (w.c.a() + getOrigPath(false));
    return this.thumbPathKey;
  }

  public static void invalidSize(w paramw)
  {
    throw new IllegalArgumentException("Invalid size: " + paramw);
  }

  private void prepare(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.id = paramInt1;
    this.fileBase = getFileBase(paramInt1);
    this.genericColPos = paramInt2;
    this.genericRowPos = paramInt3;
    this.packageId = paramInt6;
    if ((!isOwned()) && (paramInt4 == 0))
    {
      paramInt5 = 2;
      paramInt4 = 2;
    }
    this.colSpan = paramInt4;
    this.rowSpan = paramInt5;
    if (paramInt1 < 500)
      this.type = a.a;
    while (true)
    {
      this.folderPath = (g.a(ViberApplication.getApplication(), g.f(paramInt1)).getPath() + "/");
      checkStatus();
      return;
      if (paramInt1 < 1000)
        this.type = a.b;
      else
        this.type = a.c;
    }
  }

  private void resetPaths()
  {
    this.origPath = null;
    this.origFramePath = null;
    this.menuLandPathKey = null;
    this.menuPortPathKey = null;
    this.conversationPathKey = null;
  }

  public void checkStatus()
  {
    this.isReady = new File(getOrigPath()).exists();
  }

  public int compareTo(Sticker paramSticker)
  {
    return this.id - paramSticker.id;
  }

  public void createFolder()
  {
    new File(this.folderPath).mkdirs();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Sticker localSticker;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localSticker = (Sticker)paramObject;
    }
    while (this.id == localSticker.id);
    return false;
  }

  public int getConversationHeight()
  {
    return getSize(p.g * p.h, this.rowSpan);
  }

  public int getConversationWidth()
  {
    return getSize(p.g * p.h, this.colSpan);
  }

  public int getFlags()
  {
    return this.flags;
  }

  public int getMenuLandHeight()
  {
    return getSize(p.f * p.a(this.packageId).b(), this.rowSpan);
  }

  public int getMenuLandWidth()
  {
    return getSize(p.f * p.a(this.packageId).b(), this.colSpan);
  }

  public int getMenuPortHeight()
  {
    return getSize(p.e * p.a(this.packageId).a(), this.rowSpan);
  }

  public int getMenuPortWidth()
  {
    return getSize(p.e * p.a(this.packageId).a(), this.colSpan);
  }

  public String getOrigFramePath()
  {
    String str;
    if (this.origFramePath == null)
    {
      if (!isSvg())
        break label73;
      str = ".svg";
      if (!isOwned())
        break label174;
      if (!isFrameFromAssets())
        break label79;
      this.origFramePath = ("stickers/" + this.fileBase + "_frame" + str);
    }
    label174: 
    while (true)
    {
      return this.origFramePath;
      label73: str = ".png";
      break;
      label79: if (isSvg())
      {
        this.origFramePath = (this.folderPath + this.fileBase + "_frame" + str);
      }
      else
      {
        this.origFramePath = (this.folderPath + RESOLUTION_FILE_PREFIX + this.fileBase + "_orig_frame" + str);
        continue;
        this.origFramePath = "stickers/unknown_frame.png";
      }
    }
  }

  public String getOrigPath()
  {
    String str;
    StringBuilder localStringBuilder1;
    if (this.origPath == null)
    {
      if (!isSvg())
        break label67;
      str = ".svg";
      if (!isSvg())
        break label73;
      localStringBuilder1 = new StringBuilder(64);
      localStringBuilder1.append(this.folderPath).append(this.fileBase).append(str);
    }
    label67: label73: StringBuilder localStringBuilder2;
    for (this.origPath = localStringBuilder1.toString(); ; this.origPath = localStringBuilder2.toString())
    {
      return this.origPath;
      str = ".png";
      break;
      localStringBuilder2 = new StringBuilder(74);
      localStringBuilder2.append(this.folderPath).append(RESOLUTION_FILE_PREFIX).append(this.fileBase).append("_orig").append(str);
    }
  }

  public String getOrigPath(boolean paramBoolean)
  {
    if (paramBoolean)
      return getOrigFramePath();
    return getOrigPath();
  }

  public String getOrigSoundPath()
  {
    if (this.origSoundPath == null)
      this.origSoundPath = (this.folderPath + this.fileBase + ".mp3");
    return this.origSoundPath;
  }

  public String getPath(boolean paramBoolean, w paramw)
  {
    switch (2.a[paramw.ordinal()])
    {
    default:
      invalidSize(paramw);
    case 1:
    case 2:
    case 3:
    }
    do
    {
      return null;
      return getOrigPath(paramBoolean);
    }
    while (paramBoolean);
    return getThumbPath();
  }

  public String getScaledPath(boolean paramBoolean, w paramw)
  {
    switch (2.a[paramw.ordinal()])
    {
    default:
      invalidSize(paramw);
    case 1:
    case 2:
    case 3:
    }
    do
      return null;
    while (paramBoolean);
    return getThumbPath();
  }

  public String getScaledPathKey(boolean paramBoolean, w paramw)
  {
    return getScaledPathKey(paramBoolean, true, paramw);
  }

  public String getScaledPathKey(boolean paramBoolean1, boolean paramBoolean2, w paramw)
  {
    switch (2.a[paramw.ordinal()])
    {
    default:
      invalidSize(paramw);
    case 1:
    case 2:
    case 3:
    }
    do
    {
      return null;
      if (paramBoolean1)
        return w.a.a(paramBoolean2) + getOrigPath(paramBoolean1);
      return getMenuKey(paramBoolean2);
      if (paramBoolean1)
        return w.b.a() + getOrigPath(paramBoolean1);
      return getConversationPathKey();
    }
    while (paramBoolean1);
    return getThumbPathKey();
  }

  public int getThumbHeight()
  {
    return getSize(p.d, this.rowSpan);
  }

  public String getThumbPath()
  {
    if (this.thumbPath == null)
      this.thumbPath = getScaledPath("_thumb", getThumbWidth(), getThumbHeight());
    return this.thumbPath;
  }

  public int getThumbWidth()
  {
    return getSize(p.d, this.colSpan);
  }

  public boolean hasSound()
  {
    return av.c(this.flags, 5);
  }

  public int hashCode()
  {
    return 31 + this.id;
  }

  public boolean isAnimated()
  {
    return av.c(this.flags, 4);
  }

  public boolean isFrameFromAssets()
  {
    return av.c(this.flags, 2);
  }

  public boolean isInDatabase()
  {
    return this.isInDatabase;
  }

  public boolean isOwned()
  {
    return this.packageId != 0;
  }

  public boolean isReady()
  {
    return this.isReady;
  }

  public boolean isSvg()
  {
    return av.c(this.flags, 3);
  }

  public void markFiles(f paramf)
  {
    markFiles(paramf.e());
  }

  public void markFiles(Collection<String> paramCollection)
  {
    paramCollection.add(getOrigPath());
    paramCollection.add(getOrigFramePath());
    paramCollection.add(getThumbPath());
    paramCollection.add(getOrigSoundPath());
  }

  public void setFlags(int paramInt)
  {
    this.flags = paramInt;
  }

  public void setHasSound(boolean paramBoolean)
  {
    if (hasSound() != paramBoolean)
    {
      this.flags = av.a(this.flags, 5, paramBoolean);
      resetPaths();
    }
  }

  public void setIsAnimated(boolean paramBoolean)
  {
    this.flags = av.a(this.flags, 4, paramBoolean);
  }

  public void setIsFrameFromAssets(boolean paramBoolean)
  {
    this.flags = av.a(this.flags, 2, paramBoolean);
  }

  public void setIsInDatabase(boolean paramBoolean)
  {
    this.isInDatabase = paramBoolean;
  }

  public void setIsSvg(boolean paramBoolean)
  {
    if (isSvg() != paramBoolean)
    {
      this.flags = av.a(this.flags, 3, paramBoolean);
      resetPaths();
    }
  }

  public String toString()
  {
    return "Sticker{ id=" + this.id + ", flags=" + this.flags + ", packageId=" + this.packageId + ", origPath='" + getOrigPath() + '\'' + ", isReady=" + this.isReady + ", isInDatabase=" + isInDatabase() + ", colSpan=" + this.colSpan + ", rowSpan=" + this.rowSpan + ", genericRowPos=" + this.genericRowPos + ", genericColPos=" + this.genericColPos + ", isSvg=" + isSvg() + ", hasSound=" + hasSound() + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.id);
    paramParcel.writeInt(this.type.ordinal());
    paramParcel.writeInt(this.packageId);
    paramParcel.writeString(this.fileBase);
    paramParcel.writeString(this.folderPath);
    paramParcel.writeString(this.origPath);
    paramParcel.writeString(this.origFramePath);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeInt(this.flags);
    int j;
    if (this.isReady)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.isInDatabase)
        break label152;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.menuLandPathKey);
      paramParcel.writeString(this.menuPortPathKey);
      paramParcel.writeString(this.conversationPathKey);
      paramParcel.writeString(this.thumbPathKey);
      return;
      j = 0;
      break;
      label152: i = 0;
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.entity.Sticker
 * JD-Core Version:    0.6.2
 */