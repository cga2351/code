package com.yandex.mobile.ads.video.models.blocksinfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.yandex.mobile.ads.impl.fm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BlocksInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BlocksInfo> CREATOR = new Parcelable.Creator()
  {
  };
  private static final int INVALID_POSITIVE_VALUE = -1;
  private List<Block> mBlocks = new ArrayList();
  private int mBufferEmptyLimit;
  private int mBufferFullTimeout = -1;
  private String mCategoryId;
  private String mCategoryName;
  private int mFirstBuffTimeout = -1;
  private String mPartnerId;
  private String mSessionId;
  private boolean mShowSkipTimeLeft = false;
  private boolean mShowTimeLeft = false;
  private String mSkin;
  private int mSkinTimeout = -1;
  private int mSkipDelay = -1;
  private String mTitle;
  private boolean mVPaidEnabled = false;
  private int mVastTimeout = -1;
  private int mVersion;
  private int mVideoTimeout = -1;
  private int mVpaidTimeout = -1;
  private int mWrapperMaxCount = -1;
  private int mWrapperTimeout = -1;

  private BlocksInfo()
  {
  }

  private BlocksInfo(Parcel paramParcel)
  {
    this.mVersion = paramParcel.readInt();
    this.mPartnerId = paramParcel.readString();
    this.mSessionId = paramParcel.readString();
    this.mCategoryId = paramParcel.readString();
    this.mCategoryName = paramParcel.readString();
    this.mSkin = paramParcel.readString();
    boolean bool2;
    boolean bool3;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mVPaidEnabled = bool2;
      this.mBufferEmptyLimit = paramParcel.readInt();
      this.mTitle = paramParcel.readString();
      this.mSkipDelay = paramParcel.readInt();
      this.mSkinTimeout = paramParcel.readInt();
      this.mVpaidTimeout = paramParcel.readInt();
      this.mWrapperTimeout = paramParcel.readInt();
      this.mVideoTimeout = paramParcel.readInt();
      this.mVastTimeout = paramParcel.readInt();
      if (paramParcel.readByte() == 0)
        break label272;
      bool3 = bool1;
      label213: this.mShowTimeLeft = bool3;
      if (paramParcel.readByte() == 0)
        break label278;
    }
    while (true)
    {
      this.mShowSkipTimeLeft = bool1;
      this.mBufferFullTimeout = paramParcel.readInt();
      this.mWrapperMaxCount = paramParcel.readInt();
      this.mFirstBuffTimeout = paramParcel.readInt();
      paramParcel.readTypedList(this.mBlocks, Block.CREATOR);
      return;
      bool2 = false;
      break;
      label272: bool3 = false;
      break label213;
      label278: bool1 = false;
    }
  }

  private void addBlock(Block paramBlock)
  {
    this.mBlocks.add(paramBlock);
  }

  private void addBlocks(Collection<Block> paramCollection)
  {
    Iterator localIterator = fm.a(paramCollection).iterator();
    while (localIterator.hasNext())
      addBlock((Block)localIterator.next());
  }

  private static boolean parseBooleanWithDefault(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      return bool;
    }
    catch (Exception localException)
    {
    }
    return paramBoolean;
  }

  private static int parsePositiveIntOrInvalidValue(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception localException)
    {
    }
    return -1;
  }

  private void setBufferEmptyLimit(String paramString)
  {
    this.mBufferEmptyLimit = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setBufferFullTimeout(String paramString)
  {
    this.mBufferFullTimeout = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setCategoryId(String paramString)
  {
    this.mCategoryId = paramString;
  }

  private void setCategoryName(String paramString)
  {
    this.mCategoryName = paramString;
  }

  private void setFirstBuffTimeout(String paramString)
  {
    this.mFirstBuffTimeout = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setPartnerId(String paramString)
  {
    this.mPartnerId = paramString;
  }

  private void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
  }

  private void setShowSkipTimeLeft(String paramString)
  {
    this.mShowSkipTimeLeft = parseBooleanWithDefault(paramString, this.mShowSkipTimeLeft);
  }

  private void setShowTimeLeft(String paramString)
  {
    this.mShowTimeLeft = parseBooleanWithDefault(paramString, this.mShowTimeLeft);
  }

  private void setSkin(String paramString)
  {
    this.mSkin = paramString;
  }

  private void setSkinTimeout(String paramString)
  {
    this.mSkinTimeout = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setSkipDelay(String paramString)
  {
    this.mSkipDelay = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }

  private void setVPaidEnabled(String paramString)
  {
    this.mVPaidEnabled = parseBooleanWithDefault(paramString, this.mVPaidEnabled);
  }

  private void setVastTimeout(String paramString)
  {
    this.mVastTimeout = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setVersion(String paramString)
  {
    this.mVersion = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setVideoTimeout(String paramString)
  {
    this.mVideoTimeout = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setVpaidTimeout(String paramString)
  {
    this.mVpaidTimeout = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setWrapperMaxCount(String paramString)
  {
    this.mWrapperMaxCount = parsePositiveIntOrInvalidValue(paramString);
  }

  private void setWrapperTimeout(String paramString)
  {
    this.mWrapperTimeout = parsePositiveIntOrInvalidValue(paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    BlocksInfo localBlocksInfo;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localBlocksInfo = (BlocksInfo)paramObject;
      if (this.mBufferEmptyLimit != localBlocksInfo.mBufferEmptyLimit)
        return false;
      if (this.mBufferFullTimeout != localBlocksInfo.mBufferFullTimeout)
        return false;
      if (this.mFirstBuffTimeout != localBlocksInfo.mFirstBuffTimeout)
        return false;
      if (this.mVPaidEnabled != localBlocksInfo.mVPaidEnabled)
        return false;
      if (this.mShowSkipTimeLeft != localBlocksInfo.mShowSkipTimeLeft)
        return false;
      if (this.mShowTimeLeft != localBlocksInfo.mShowTimeLeft)
        return false;
      if (this.mSkinTimeout != localBlocksInfo.mSkinTimeout)
        return false;
      if (this.mSkipDelay != localBlocksInfo.mSkipDelay)
        return false;
      if (this.mVastTimeout != localBlocksInfo.mVastTimeout)
        return false;
      if (this.mVersion != localBlocksInfo.mVersion)
        return false;
      if (this.mVideoTimeout != localBlocksInfo.mVideoTimeout)
        return false;
      if (this.mVpaidTimeout != localBlocksInfo.mVpaidTimeout)
        return false;
      if (this.mWrapperMaxCount != localBlocksInfo.mWrapperMaxCount)
        return false;
      if (this.mWrapperTimeout != localBlocksInfo.mWrapperTimeout)
        return false;
      if (this.mBlocks != null)
      {
        if (this.mBlocks.equals(localBlocksInfo.mBlocks));
      }
      else
        while (localBlocksInfo.mBlocks != null)
          return false;
      if (this.mCategoryId != null)
      {
        if (this.mCategoryId.equals(localBlocksInfo.mCategoryId));
      }
      else
        while (localBlocksInfo.mCategoryId != null)
          return false;
      if (this.mCategoryName != null)
      {
        if (this.mCategoryName.equals(localBlocksInfo.mCategoryName));
      }
      else
        while (localBlocksInfo.mCategoryName != null)
          return false;
      if (this.mPartnerId != null)
      {
        if (this.mPartnerId.equals(localBlocksInfo.mPartnerId));
      }
      else
        while (localBlocksInfo.mPartnerId != null)
          return false;
      if (this.mSessionId != null)
      {
        if (this.mSessionId.equals(localBlocksInfo.mSessionId));
      }
      else
        while (localBlocksInfo.mSessionId != null)
          return false;
      if (this.mSkin != null)
      {
        if (this.mSkin.equals(localBlocksInfo.mSkin));
      }
      else
        while (localBlocksInfo.mSkin != null)
          return false;
      if (this.mTitle == null)
        break;
    }
    while (this.mTitle.equals(localBlocksInfo.mTitle));
    while (true)
    {
      return false;
      if (localBlocksInfo.mTitle == null)
        break;
    }
  }

  public List<Block> getBlocks()
  {
    return this.mBlocks;
  }

  public int getBufferEmptyLimit()
  {
    return this.mBufferEmptyLimit;
  }

  public int getBufferFullTimeout()
  {
    return this.mBufferFullTimeout;
  }

  public String getCategoryId()
  {
    return this.mCategoryId;
  }

  public String getCategoryName()
  {
    return this.mCategoryName;
  }

  public int getFirstBuffTimeout()
  {
    return this.mFirstBuffTimeout;
  }

  public String getPartnerId()
  {
    return this.mPartnerId;
  }

  public String getSessionId()
  {
    return this.mSessionId;
  }

  public String getSkin()
  {
    return this.mSkin;
  }

  public int getSkinTimeout()
  {
    return this.mSkinTimeout;
  }

  public int getSkipDelay()
  {
    return this.mSkipDelay;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public int getVastTimeout()
  {
    return this.mVastTimeout;
  }

  public int getVersion()
  {
    return this.mVersion;
  }

  public int getVideoTimeout()
  {
    return this.mVideoTimeout;
  }

  public int getVpaidTimeout()
  {
    return this.mVpaidTimeout;
  }

  public int getWrapperMaxCount()
  {
    return this.mWrapperMaxCount;
  }

  public int getWrapperTimeout()
  {
    return this.mWrapperTimeout;
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * this.mVersion;
    int k;
    int n;
    label49: int i2;
    label75: int i4;
    label101: int i6;
    label127: int i8;
    label147: int i10;
    label181: int i12;
    label249: int i13;
    if (this.mPartnerId != null)
    {
      k = this.mPartnerId.hashCode();
      int m = 31 * (k + j);
      if (this.mSessionId == null)
        break label335;
      n = this.mSessionId.hashCode();
      int i1 = 31 * (n + m);
      if (this.mCategoryId == null)
        break label341;
      i2 = this.mCategoryId.hashCode();
      int i3 = 31 * (i2 + i1);
      if (this.mCategoryName == null)
        break label347;
      i4 = this.mCategoryName.hashCode();
      int i5 = 31 * (i4 + i3);
      if (this.mSkin == null)
        break label353;
      i6 = this.mSkin.hashCode();
      int i7 = 31 * (i6 + i5);
      if (!this.mVPaidEnabled)
        break label359;
      i8 = i;
      int i9 = 31 * (31 * (i8 + i7) + this.mBufferEmptyLimit);
      if (this.mTitle == null)
        break label365;
      i10 = this.mTitle.hashCode();
      int i11 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (i10 + i9) + this.mSkipDelay) + this.mSkinTimeout) + this.mVpaidTimeout) + this.mWrapperTimeout) + this.mVideoTimeout) + this.mVastTimeout);
      if (!this.mShowTimeLeft)
        break label371;
      i12 = i;
      i13 = 31 * (i12 + i11);
      if (!this.mShowSkipTimeLeft)
        break label377;
    }
    while (true)
    {
      int i14 = 31 * (31 * (31 * (31 * (i13 + i) + this.mBufferFullTimeout) + this.mWrapperMaxCount) + this.mFirstBuffTimeout);
      List localList = this.mBlocks;
      int i15 = 0;
      if (localList != null)
        i15 = this.mBlocks.hashCode();
      return i14 + i15;
      k = 0;
      break;
      label335: n = 0;
      break label49;
      label341: i2 = 0;
      break label75;
      label347: i4 = 0;
      break label101;
      label353: i6 = 0;
      break label127;
      label359: i8 = 0;
      break label147;
      label365: i10 = 0;
      break label181;
      label371: i12 = 0;
      break label249;
      label377: i = 0;
    }
  }

  public boolean isVPaidEnabled()
  {
    return this.mVPaidEnabled;
  }

  public boolean showSkipTimeLeft()
  {
    return this.mShowSkipTimeLeft;
  }

  public boolean showTimeLeft()
  {
    return this.mShowTimeLeft;
  }

  public String toString()
  {
    return "mVersion=" + this.mVersion + '\'' + "\nmPartnerId='" + this.mPartnerId + '\'' + "\nmSessionId='" + this.mSessionId + '\'' + "\nmCategoryId='" + this.mCategoryId + '\'' + "\nmCategoryName='" + this.mCategoryName + '\'' + "\nmSkin='" + this.mSkin + '\'' + "\nmVPaidEnabled=" + this.mVPaidEnabled + "\nmBufferEmptyLimit=" + this.mBufferEmptyLimit + "\nmTitle='" + this.mTitle + '\'' + "\nmSkipDelay=" + this.mSkipDelay + "\nmSkinTimeout=" + this.mSkinTimeout + "\nmVpaidTimeout=" + this.mVpaidTimeout + "\nmWrapperTimeout=" + this.mWrapperTimeout + "\nmVideoTimeout=" + this.mVideoTimeout + "\nmVastTimeout=" + this.mVastTimeout + "\nmShowTimeLeft=" + this.mShowTimeLeft + "\nmShowSkipTimeLeft=" + this.mShowSkipTimeLeft + "\nmBufferFullTimeout=" + this.mBufferFullTimeout + "\nmWrapperMaxCount=" + this.mWrapperMaxCount + "\nmFirstBuffTimeout=" + this.mFirstBuffTimeout + "\nmBlocks.size()=" + this.mBlocks.size();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b1 = 1;
    paramParcel.writeInt(this.mVersion);
    paramParcel.writeString(this.mPartnerId);
    paramParcel.writeString(this.mSessionId);
    paramParcel.writeString(this.mCategoryId);
    paramParcel.writeString(this.mCategoryName);
    paramParcel.writeString(this.mSkin);
    byte b2;
    byte b3;
    if (this.mVPaidEnabled)
    {
      b2 = b1;
      paramParcel.writeByte(b2);
      paramParcel.writeInt(this.mBufferEmptyLimit);
      paramParcel.writeString(this.mTitle);
      paramParcel.writeInt(this.mSkipDelay);
      paramParcel.writeInt(this.mSkinTimeout);
      paramParcel.writeInt(this.mVpaidTimeout);
      paramParcel.writeInt(this.mWrapperTimeout);
      paramParcel.writeInt(this.mVideoTimeout);
      paramParcel.writeInt(this.mVastTimeout);
      if (!this.mShowTimeLeft)
        break label197;
      b3 = b1;
      label140: paramParcel.writeByte(b3);
      if (!this.mShowSkipTimeLeft)
        break label203;
    }
    while (true)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.mBufferFullTimeout);
      paramParcel.writeInt(this.mWrapperMaxCount);
      paramParcel.writeInt(this.mFirstBuffTimeout);
      paramParcel.writeTypedList(this.mBlocks);
      return;
      b2 = 0;
      break;
      label197: b3 = 0;
      break label140;
      label203: b1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo
 * JD-Core Version:    0.6.2
 */