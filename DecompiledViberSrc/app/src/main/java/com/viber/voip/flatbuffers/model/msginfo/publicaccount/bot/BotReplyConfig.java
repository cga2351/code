package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.f;
import java.util.Arrays;

public class BotReplyConfig
  implements Parcelable
{
  public static final Parcelable.Creator<BotReplyConfig> CREATOR = new Parcelable.Creator()
  {
    public BotReplyConfig a(Parcel paramAnonymousParcel)
    {
      return new BotReplyConfig(paramAnonymousParcel);
    }

    public BotReplyConfig[] a(int paramAnonymousInt)
    {
      return new BotReplyConfig[paramAnonymousInt];
    }
  };
  public static final int DEFAULT_BG_COLOR = 15987699;
  public static final int DEFAULT_HEIGHT_SCALE_PERCENT = 100;
  public static final int DEFAULT_KEYBOARD_BUTTONS_GROUP_COLUMNS = 6;
  public static final int DEFAULT_KEYBOARD_BUTTONS_GROUP_ROWS = 2;
  public static final int DEFAULT_RICH_BUTTONS_GROUP_COLUMNS = 6;
  public static final int DEFAULT_RICH_BUTTONS_GROUP_ROWS = 7;
  public static final String FAVORITES_METADATA = "FavoritesMetadata";

  @b(a="Lcom/viber/voip/flatbuffers/c/b;")
  @c(a="BgColor")
  private Integer mBgColor;

  @c(a="Buttons")
  private ReplyButton[] mButtons;

  @c(a="ButtonsGroupColumns")
  private int mButtonsGroupColumns;

  @c(a="ButtonsGroupRows")
  private int mButtonsGroupRows;

  @c(a="CustomDefaultHeight")
  private Integer mCustomDefaultHeightPercent;

  @c(a="DefaultHeight")
  private boolean mDefaultHeight;

  @c(a="FavoritesMetadata")
  private FavoritesMetadata mFavoritesMetadata;

  @c(a="HeightScale")
  private Integer mHeightScalePercent;

  @b(a="Lcom/viber/voip/flatbuffers/c/j;")
  @c(a="InputFieldState")
  private a mInputFieldState;

  @c(a="KeyboardDate")
  private Long mKeyboardDate;

  public BotReplyConfig()
  {
    this.mFavoritesMetadata = new FavoritesMetadata();
  }

  BotReplyConfig(Parcel paramParcel)
  {
    boolean bool;
    int i;
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.mDefaultHeight = bool;
      this.mCustomDefaultHeightPercent = Integer.valueOf(paramParcel.readInt());
      if (this.mCustomDefaultHeightPercent.intValue() < 0)
        this.mCustomDefaultHeightPercent = null;
      this.mBgColor = Integer.valueOf(paramParcel.readInt());
      if (this.mBgColor.intValue() == -2147483648)
        this.mBgColor = null;
      this.mKeyboardDate = Long.valueOf(paramParcel.readLong());
      if (this.mKeyboardDate.longValue() == -9223372036854775808L)
        this.mKeyboardDate = null;
      this.mHeightScalePercent = Integer.valueOf(paramParcel.readInt());
      if (this.mHeightScalePercent.intValue() < 0)
        this.mHeightScalePercent = null;
      this.mButtons = ((ReplyButton[])paramParcel.createTypedArray(ReplyButton.CREATOR));
      this.mButtonsGroupColumns = paramParcel.readInt();
      this.mButtonsGroupRows = paramParcel.readInt();
      i = paramParcel.readInt();
      if (i == -1)
        break label203;
    }
    label203: for (a locala = a.values()[i]; ; locala = null)
    {
      this.mInputFieldState = locala;
      this.mFavoritesMetadata = ((FavoritesMetadata)paramParcel.readParcelable(FavoritesMetadata.class.getClassLoader()));
      return;
      bool = false;
      break;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    BotReplyConfig localBotReplyConfig;
    label116: boolean bool5;
    label144: label216: 
    do
    {
      a locala1;
      a locala2;
      do
      {
        boolean bool6;
        do
        {
          int k;
          int m;
          do
          {
            int i;
            int j;
            do
            {
              boolean bool7;
              do
              {
                boolean bool8;
                do
                {
                  boolean bool3;
                  boolean bool4;
                  do
                  {
                    Class localClass1;
                    Class localClass2;
                    do
                    {
                      do
                      {
                        return bool2;
                        bool2 = false;
                      }
                      while (paramObject == null);
                      localClass1 = getClass();
                      localClass2 = paramObject.getClass();
                      bool2 = false;
                    }
                    while (localClass1 != localClass2);
                    localBotReplyConfig = (BotReplyConfig)paramObject;
                    bool3 = this.mDefaultHeight;
                    bool4 = localBotReplyConfig.mDefaultHeight;
                    bool2 = false;
                  }
                  while (bool3 != bool4);
                  if (this.mCustomDefaultHeightPercent == null)
                    break;
                  bool8 = this.mCustomDefaultHeightPercent.equals(localBotReplyConfig.mCustomDefaultHeightPercent);
                  bool2 = false;
                }
                while (!bool8);
                if (this.mKeyboardDate == null)
                  break label291;
                if (this.mKeyboardDate.equals(localBotReplyConfig.mKeyboardDate))
                  break;
                if (this.mBgColor == null)
                  break label302;
                bool7 = this.mBgColor.equals(localBotReplyConfig.mBgColor);
                bool2 = false;
              }
              while (!bool7);
              i = this.mButtonsGroupColumns;
              j = localBotReplyConfig.mButtonsGroupColumns;
              bool2 = false;
            }
            while (i != j);
            k = this.mButtonsGroupRows;
            m = localBotReplyConfig.mButtonsGroupRows;
            bool2 = false;
          }
          while (k != m);
          if (this.mHeightScalePercent == null)
            break label312;
          bool6 = this.mHeightScalePercent.equals(localBotReplyConfig.mHeightScalePercent);
          bool2 = false;
        }
        while (!bool6);
        locala1 = this.mInputFieldState;
        locala2 = localBotReplyConfig.mInputFieldState;
        bool2 = false;
      }
      while (locala1 != locala2);
      bool5 = Arrays.equals(this.mButtons, localBotReplyConfig.mButtons);
      bool2 = false;
    }
    while (!bool5);
    if (this.mFavoritesMetadata != null)
      bool1 = this.mFavoritesMetadata.equals(localBotReplyConfig.mFavoritesMetadata);
    while (true)
    {
      return bool1;
      if (localBotReplyConfig.mCustomDefaultHeightPercent == null)
        break;
      return false;
      label291: if (localBotReplyConfig.mKeyboardDate == null)
        break label144;
      break label116;
      label302: if (localBotReplyConfig.mBgColor == null)
        break label144;
      return false;
      label312: if (localBotReplyConfig.mHeightScalePercent == null)
        break label216;
      return false;
      if (localBotReplyConfig.mFavoritesMetadata != null)
        bool1 = false;
    }
  }

  public Integer getBgColor()
  {
    if (this.mBgColor == null);
    for (int i = 15987699; ; i = this.mBgColor.intValue())
      return Integer.valueOf(i);
  }

  public ReplyButton[] getButtons()
  {
    if (this.mButtons == null)
      return new ReplyButton[0];
    return this.mButtons;
  }

  public int getButtonsGroupColumns()
  {
    return this.mButtonsGroupColumns;
  }

  public int getButtonsGroupRows()
  {
    return this.mButtonsGroupRows;
  }

  public Integer getCustomDefaultHeightPercent()
  {
    if ((this.mCustomDefaultHeightPercent == null) || (this.mCustomDefaultHeightPercent.intValue() < 0))
      return null;
    return this.mCustomDefaultHeightPercent;
  }

  public FavoritesMetadata getFavoritesMetadata()
  {
    return this.mFavoritesMetadata;
  }

  public int getHeightScalePercent()
  {
    if ((this.mHeightScalePercent == null) || (this.mHeightScalePercent.intValue() < 0))
      return 100;
    return this.mHeightScalePercent.intValue();
  }

  public a getInputFieldState()
  {
    if (this.mInputFieldState == null)
      return a.getDefault();
    return this.mInputFieldState;
  }

  public long getKeyboardDate()
  {
    if (this.mKeyboardDate != null)
      return this.mKeyboardDate.longValue();
    return 0L;
  }

  public int hashCode()
  {
    int i;
    int k;
    label29: int n;
    label53: int i2;
    label90: int i4;
    label116: int i5;
    if (this.mDefaultHeight)
    {
      i = 1;
      int j = i * 31;
      if (this.mCustomDefaultHeightPercent == null)
        break label202;
      k = this.mCustomDefaultHeightPercent.hashCode();
      int m = 31 * (k + j);
      if (this.mBgColor == null)
        break label207;
      n = this.mBgColor.hashCode();
      int i1 = 31 * (31 * (n + m) + Arrays.hashCode(this.mButtons));
      if (this.mKeyboardDate == null)
        break label213;
      i2 = this.mKeyboardDate.hashCode();
      int i3 = 31 * (i2 + i1);
      if (this.mHeightScalePercent == null)
        break label219;
      i4 = this.mHeightScalePercent.hashCode();
      i5 = 31 * (31 * (31 * (i4 + i3) + this.mButtonsGroupColumns) + this.mButtonsGroupRows);
      if (this.mInputFieldState == null)
        break label225;
    }
    label202: label207: label213: label219: label225: for (int i6 = this.mInputFieldState.hashCode(); ; i6 = 0)
    {
      int i7 = 31 * (i6 + i5);
      FavoritesMetadata localFavoritesMetadata = this.mFavoritesMetadata;
      int i8 = 0;
      if (localFavoritesMetadata != null)
        i8 = this.mFavoritesMetadata.hashCode();
      return i7 + i8;
      i = 0;
      break;
      k = 0;
      break label29;
      n = 0;
      break label53;
      i2 = 0;
      break label90;
      i4 = 0;
      break label116;
    }
  }

  public boolean isDefaultHeight()
  {
    return this.mDefaultHeight;
  }

  public void setBgColor(Integer paramInteger)
  {
    this.mBgColor = paramInteger;
  }

  public void setButtons(ReplyButton[] paramArrayOfReplyButton)
  {
    this.mButtons = paramArrayOfReplyButton;
  }

  public void setButtonsGroupColumns(int paramInt)
  {
    this.mButtonsGroupColumns = paramInt;
  }

  public void setButtonsGroupRows(int paramInt)
  {
    this.mButtonsGroupRows = paramInt;
  }

  public void setCustomDefaultHeightPercent(int paramInt)
  {
    if (paramInt < 0);
    for (Integer localInteger = null; ; localInteger = Integer.valueOf(paramInt))
    {
      this.mCustomDefaultHeightPercent = localInteger;
      return;
    }
  }

  public void setDefaultHeight(boolean paramBoolean)
  {
    this.mDefaultHeight = paramBoolean;
  }

  public void setFavoritesMetadata(FavoritesMetadata paramFavoritesMetadata)
  {
    this.mFavoritesMetadata = paramFavoritesMetadata;
  }

  public void setHeightScalePercent(int paramInt)
  {
    if (paramInt < 0);
    for (Integer localInteger = null; ; localInteger = Integer.valueOf(paramInt))
    {
      this.mHeightScalePercent = localInteger;
      return;
    }
  }

  public void setInputFieldState(a parama)
  {
    this.mInputFieldState = parama;
  }

  public void setKeyboardDate(long paramLong)
  {
    this.mKeyboardDate = Long.valueOf(paramLong);
  }

  public String toJson()
  {
    return new f().b(this);
  }

  public String toString()
  {
    return "BotReplyConfig{mDefaultHeight=" + this.mDefaultHeight + ", mCustomDefaultHeightPercent=" + this.mCustomDefaultHeightPercent + ", mBgColor=" + this.mBgColor + ", mButtons=" + Arrays.toString(this.mButtons) + ", mKeyboardDate=" + this.mKeyboardDate + ", mHeightScalePercent=" + this.mHeightScalePercent + ", mButtonsGroupColumns=" + this.mButtonsGroupColumns + ", mButtonsGroupRows=" + this.mButtonsGroupRows + ", mInputFieldState=" + this.mInputFieldState + ", mFavoritesMetadata=" + this.mFavoritesMetadata + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -2147483648;
    int j;
    int k;
    label36: int m;
    label58: long l;
    if (this.mDefaultHeight)
    {
      j = 1;
      paramParcel.writeByte((byte)j);
      if (this.mCustomDefaultHeightPercent == null)
        break label169;
      k = this.mCustomDefaultHeightPercent.intValue();
      paramParcel.writeInt(k);
      if (this.mBgColor == null)
        break label175;
      m = this.mBgColor.intValue();
      paramParcel.writeInt(m);
      if (this.mKeyboardDate == null)
        break label181;
      l = this.mKeyboardDate.longValue();
      label80: paramParcel.writeLong(l);
      if (this.mHeightScalePercent != null)
        i = this.mHeightScalePercent.intValue();
      paramParcel.writeInt(i);
      paramParcel.writeTypedArray(this.mButtons, paramInt);
      paramParcel.writeInt(this.mButtonsGroupColumns);
      paramParcel.writeInt(this.mButtonsGroupRows);
      if (this.mInputFieldState == null)
        break label189;
    }
    label169: label175: label181: label189: for (int n = this.mInputFieldState.ordinal(); ; n = -1)
    {
      paramParcel.writeInt(n);
      paramParcel.writeParcelable(this.mFavoritesMetadata, paramInt);
      return;
      j = 0;
      break;
      k = i;
      break label36;
      m = i;
      break label58;
      l = -9223372036854775808L;
      break label80;
    }
  }

  public static enum a
  {
    private final String mTypeName;

    static
    {
      MINIMIZED = new a("MINIMIZED", 1, "minimized");
      HIDDEN = new a("HIDDEN", 2, "hidden");
      a[] arrayOfa = new a[3];
      arrayOfa[0] = REGULAR;
      arrayOfa[1] = MINIMIZED;
      arrayOfa[2] = HIDDEN;
    }

    private a(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static a fromName(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      while (true)
      {
        return null;
        for (a locala : values())
          if (locala.mTypeName.equalsIgnoreCase(paramString))
            return locala;
      }
    }

    public static a getDefault()
    {
      return REGULAR;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig
 * JD-Core Version:    0.6.2
 */