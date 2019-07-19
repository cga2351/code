package com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.d.a.c;
import java.util.Arrays;

public class ReplyButton
  implements Parcelable
{
  public static final Parcelable.Creator<ReplyButton> CREATOR = new Parcelable.Creator()
  {
    public ReplyButton a(Parcel paramAnonymousParcel)
    {
      return new ReplyButton(paramAnonymousParcel);
    }

    public ReplyButton[] a(int paramAnonymousInt)
    {
      return new ReplyButton[paramAnonymousInt];
    }
  };
  public static final int DEFAULT_BG_COLOR = -1;
  public static final int DEFAULT_ROW_COUNT_IN_BOT_KEYBOARD = 1;
  public static final int DEFAULT_TEXT_OPACITY = 100;
  public static final int MAX_TEXT_PADDING_DP = 12;
  public static final int MIN_TEXT_PADDING_DP;

  @c(a="ActionBody")
  private String mActionBody;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/o;")
  @c(a="ActionType")
  private a mActionType;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/p;")
  @c(a="BgColor")
  private Integer mBgColor;

  @c(a="BgLoop")
  private Boolean mBgLoop;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/y;")
  @c(a="BgMedia")
  private Uri mBgMedia;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/u;")
  @c(a="BgMediaScaleType")
  private f mBgMediaScaleType;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/q;")
  @c(a="BgMediaType")
  private c mBgMediaType;

  @c(a="Columns")
  private int mColumns;

  @c(a="Frame")
  private Frame mFrame;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/u;")
  @c(a="ImageScaleType")
  private f mImageScaleType;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/y;")
  @c(a="Image")
  private Uri mImageUri;

  @c(a="InternalBrowser")
  private InternalBrowser mInternalBrowserSection;

  @c(a="Map")
  private Map mMap;

  @c(a="MediaPlayer")
  private MediaPlayer mMediaPlayer;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/s;")
  @c(a="OpenURLMediaType")
  private d mOpenUrlMediaType;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/t;")
  @c(a="OpenURLType")
  private e mOpenUrlType;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/c;")
  @c(a="ReplyType")
  private b mReplyType;

  @c(a="Rows")
  private int mRows;

  @c(a="Silent")
  private Boolean mSilent;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/d;")
  @c(a="Text")
  private String mText;

  @c(a="TextBgGradientColor")
  private String mTextBgGradientColor;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/i;")
  @c(a="TextHAlign")
  private a mTextHorizontalAlign;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/r;")
  @c(a="TextOpacity")
  private int mTextOpacity;

  @c(a="TextPaddings")
  private int[] mTextPaddings;

  @c(a="TextShouldFit")
  private boolean mTextShouldFit;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/v;")
  @c(a="TextSize")
  private g mTextSize;

  @com.google.d.a.b(a="Lcom/viber/voip/flatbuffers/c/aa;")
  @c(a="TextVAlign")
  private b mTextVerticalAlign;

  public ReplyButton()
  {
    this.mTextOpacity = 100;
  }

  protected ReplyButton(Parcel paramParcel)
  {
    this.mColumns = paramParcel.readInt();
    this.mRows = paramParcel.readInt();
    this.mBgColor = Integer.valueOf(paramParcel.readInt());
    if (this.mBgColor.intValue() == -2147483648)
      this.mBgColor = null;
    this.mBgMedia = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    int i = paramParcel.readInt();
    c localc;
    int j;
    f localf1;
    label100: boolean bool2;
    label116: int k;
    e locale;
    label140: int m;
    d locald;
    label161: int n;
    a locala;
    label182: Boolean localBoolean;
    label217: int i2;
    b localb;
    label238: int i3;
    f localf2;
    label275: int i4;
    b localb1;
    label296: int i5;
    a locala1;
    label317: int i6;
    g localg;
    if (i == -1)
    {
      localc = null;
      this.mBgMediaType = localc;
      j = paramParcel.readInt();
      if (j != -1)
        break label463;
      localf1 = null;
      this.mBgMediaScaleType = localf1;
      if (paramParcel.readByte() == 0)
        break label474;
      bool2 = bool1;
      this.mBgLoop = Boolean.valueOf(bool2);
      k = paramParcel.readInt();
      if (k != -1)
        break label480;
      locale = null;
      this.mOpenUrlType = locale;
      m = paramParcel.readInt();
      if (m != -1)
        break label491;
      locald = null;
      this.mOpenUrlMediaType = locald;
      n = paramParcel.readInt();
      if (n != -1)
        break label502;
      locala = null;
      this.mActionType = locala;
      this.mActionBody = paramParcel.readString();
      int i1 = paramParcel.readByte();
      if (i1 >= 0)
      {
        if (i1 != 0)
          break label513;
        localBoolean = Boolean.FALSE;
        this.mSilent = localBoolean;
      }
      i2 = paramParcel.readInt();
      if (i2 != -1)
        break label521;
      localb = null;
      this.mReplyType = localb;
      this.mImageUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      i3 = paramParcel.readInt();
      if (i3 != -1)
        break label532;
      localf2 = null;
      this.mImageScaleType = localf2;
      i4 = paramParcel.readInt();
      if (i4 != -1)
        break label543;
      localb1 = null;
      this.mTextVerticalAlign = localb1;
      i5 = paramParcel.readInt();
      if (i5 != -1)
        break label554;
      locala1 = null;
      this.mTextHorizontalAlign = locala1;
      this.mText = paramParcel.readString();
      i6 = paramParcel.readInt();
      localg = null;
      if (i6 != -1)
        break label565;
      label346: this.mTextSize = localg;
      if (paramParcel.readByte() == 0)
        break label576;
    }
    while (true)
    {
      this.mTextShouldFit = bool1;
      this.mTextOpacity = paramParcel.readInt();
      this.mTextBgGradientColor = paramParcel.readString();
      this.mInternalBrowserSection = ((InternalBrowser)paramParcel.readParcelable(InternalBrowser.class.getClassLoader()));
      this.mMediaPlayer = ((MediaPlayer)paramParcel.readParcelable(MediaPlayer.class.getClassLoader()));
      this.mTextPaddings = paramParcel.createIntArray();
      this.mFrame = ((Frame)paramParcel.readParcelable(Frame.class.getClassLoader()));
      this.mMap = ((Map)paramParcel.readParcelable(Map.class.getClassLoader()));
      return;
      localc = c.values()[i];
      break;
      label463: localf1 = f.values()[j];
      break label100;
      label474: bool2 = false;
      break label116;
      label480: locale = e.values()[k];
      break label140;
      label491: locald = d.values()[m];
      break label161;
      label502: locala = a.values()[n];
      break label182;
      label513: localBoolean = Boolean.TRUE;
      break label217;
      label521: localb = b.values()[i2];
      break label238;
      label532: localf2 = f.values()[i3];
      break label275;
      label543: localb1 = b.values()[i4];
      break label296;
      label554: locala1 = a.values()[i5];
      break label317;
      label565: localg = g.values()[i6];
      break label346;
      label576: bool1 = false;
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
    ReplyButton localReplyButton;
    label210: label348: label376: boolean bool6;
    label426: label570: label598: label626: 
    do
    {
      boolean bool5;
      do
      {
        boolean bool7;
        do
        {
          boolean bool8;
          do
          {
            boolean bool9;
            do
            {
              g localg1;
              g localg2;
              do
              {
                boolean bool10;
                do
                {
                  a locala3;
                  a locala4;
                  do
                  {
                    b localb3;
                    b localb4;
                    do
                    {
                      f localf3;
                      f localf4;
                      do
                      {
                        boolean bool11;
                        do
                        {
                          b localb1;
                          b localb2;
                          do
                          {
                            boolean bool12;
                            do
                            {
                              boolean bool13;
                              do
                              {
                                a locala1;
                                a locala2;
                                do
                                {
                                  d locald1;
                                  d locald2;
                                  do
                                  {
                                    e locale1;
                                    e locale2;
                                    do
                                    {
                                      f localf1;
                                      f localf2;
                                      do
                                      {
                                        c localc1;
                                        c localc2;
                                        do
                                        {
                                          boolean bool14;
                                          do
                                          {
                                            boolean bool15;
                                            do
                                            {
                                              int n;
                                              int i1;
                                              do
                                              {
                                                boolean bool3;
                                                boolean bool4;
                                                do
                                                {
                                                  Boolean localBoolean1;
                                                  Boolean localBoolean2;
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
                                                        localReplyButton = (ReplyButton)paramObject;
                                                        i = this.mColumns;
                                                        j = localReplyButton.mColumns;
                                                        bool2 = false;
                                                      }
                                                      while (i != j);
                                                      k = this.mRows;
                                                      m = localReplyButton.mRows;
                                                      bool2 = false;
                                                    }
                                                    while (k != m);
                                                    localBoolean1 = this.mBgLoop;
                                                    localBoolean2 = localReplyButton.mBgLoop;
                                                    bool2 = false;
                                                  }
                                                  while (localBoolean1 != localBoolean2);
                                                  bool3 = this.mTextShouldFit;
                                                  bool4 = localReplyButton.mTextShouldFit;
                                                  bool2 = false;
                                                }
                                                while (bool3 != bool4);
                                                n = this.mTextOpacity;
                                                i1 = localReplyButton.mTextOpacity;
                                                bool2 = false;
                                              }
                                              while (n != i1);
                                              if (this.mBgColor == null)
                                                break;
                                              bool15 = this.mBgColor.equals(localReplyButton.mBgColor);
                                              bool2 = false;
                                            }
                                            while (!bool15);
                                            if (this.mBgMedia == null)
                                              break label707;
                                            bool14 = this.mBgMedia.equals(localReplyButton.mBgMedia);
                                            bool2 = false;
                                          }
                                          while (!bool14);
                                          localc1 = this.mBgMediaType;
                                          localc2 = localReplyButton.mBgMediaType;
                                          bool2 = false;
                                        }
                                        while (localc1 != localc2);
                                        localf1 = this.mBgMediaScaleType;
                                        localf2 = localReplyButton.mBgMediaScaleType;
                                        bool2 = false;
                                      }
                                      while (localf1 != localf2);
                                      locale1 = this.mOpenUrlType;
                                      locale2 = localReplyButton.mOpenUrlType;
                                      bool2 = false;
                                    }
                                    while (locale1 != locale2);
                                    locald1 = this.mOpenUrlMediaType;
                                    locald2 = localReplyButton.mOpenUrlMediaType;
                                    bool2 = false;
                                  }
                                  while (locald1 != locald2);
                                  locala1 = this.mActionType;
                                  locala2 = localReplyButton.mActionType;
                                  bool2 = false;
                                }
                                while (locala1 != locala2);
                                if (this.mActionBody == null)
                                  break label717;
                                bool13 = this.mActionBody.equals(localReplyButton.mActionBody);
                                bool2 = false;
                              }
                              while (!bool13);
                              if (this.mSilent == null)
                                break label727;
                              bool12 = this.mSilent.equals(localReplyButton.mSilent);
                              bool2 = false;
                            }
                            while (!bool12);
                            localb1 = this.mReplyType;
                            localb2 = localReplyButton.mReplyType;
                            bool2 = false;
                          }
                          while (localb1 != localb2);
                          if (this.mImageUri == null)
                            break label737;
                          bool11 = this.mImageUri.equals(localReplyButton.mImageUri);
                          bool2 = false;
                        }
                        while (!bool11);
                        localf3 = this.mImageScaleType;
                        localf4 = localReplyButton.mImageScaleType;
                        bool2 = false;
                      }
                      while (localf3 != localf4);
                      localb3 = this.mTextVerticalAlign;
                      localb4 = localReplyButton.mTextVerticalAlign;
                      bool2 = false;
                    }
                    while (localb3 != localb4);
                    locala3 = this.mTextHorizontalAlign;
                    locala4 = localReplyButton.mTextHorizontalAlign;
                    bool2 = false;
                  }
                  while (locala3 != locala4);
                  if (this.mText == null)
                    break label747;
                  bool10 = this.mText.equals(localReplyButton.mText);
                  bool2 = false;
                }
                while (!bool10);
                localg1 = this.mTextSize;
                localg2 = localReplyButton.mTextSize;
                bool2 = false;
              }
              while (localg1 != localg2);
              if (this.mTextBgGradientColor == null)
                break label757;
              bool9 = this.mTextBgGradientColor.equals(localReplyButton.mTextBgGradientColor);
              bool2 = false;
            }
            while (!bool9);
            if (this.mInternalBrowserSection == null)
              break label767;
            bool8 = this.mInternalBrowserSection.equals(localReplyButton.mInternalBrowserSection);
            bool2 = false;
          }
          while (!bool8);
          if (this.mMediaPlayer == null)
            break label777;
          bool7 = this.mMediaPlayer.equals(localReplyButton.mMediaPlayer);
          bool2 = false;
        }
        while (!bool7);
        bool5 = Arrays.equals(this.mTextPaddings, localReplyButton.mTextPaddings);
        bool2 = false;
      }
      while (!bool5);
      if (this.mFrame == null)
        break label787;
      bool6 = this.mFrame.equals(localReplyButton.mFrame);
      bool2 = false;
    }
    while (!bool6);
    label520: label675: if (this.mMap != null)
      bool1 = this.mMap.equals(localReplyButton.mMap);
    while (true)
    {
      return bool1;
      if (localReplyButton.mBgColor == null)
        break;
      return false;
      label707: if (localReplyButton.mBgMedia == null)
        break label210;
      return false;
      label717: if (localReplyButton.mActionBody == null)
        break label348;
      return false;
      label727: if (localReplyButton.mSilent == null)
        break label376;
      return false;
      label737: if (localReplyButton.mImageUri == null)
        break label426;
      return false;
      label747: if (localReplyButton.mText == null)
        break label520;
      return false;
      label757: if (localReplyButton.mTextBgGradientColor == null)
        break label570;
      return false;
      label767: if (localReplyButton.mInternalBrowserSection == null)
        break label598;
      return false;
      label777: if (localReplyButton.mMediaPlayer == null)
        break label626;
      return false;
      label787: if (localReplyButton.mFrame == null)
        break label675;
      return false;
      if (localReplyButton.mMap != null)
        bool1 = false;
    }
  }

  public String getActionBody()
  {
    return this.mActionBody;
  }

  public a getActionType()
  {
    if (this.mActionType != null)
      return this.mActionType;
    return a.getDefaultValue();
  }

  public Integer getBgColor()
  {
    if (this.mBgColor == null);
    for (int i = -1; ; i = this.mBgColor.intValue())
      return Integer.valueOf(i);
  }

  public Uri getBgMedia()
  {
    return this.mBgMedia;
  }

  public f getBgMediaScaleType()
  {
    if (this.mBgMediaScaleType == null)
      return f.getDefault();
    return this.mBgMediaScaleType;
  }

  public c getBgMediaType()
  {
    if (this.mBgMediaType != null)
      return this.mBgMediaType;
    return c.PICTURE;
  }

  public int getColumns()
  {
    return this.mColumns;
  }

  public Frame getFrame()
  {
    return this.mFrame;
  }

  public f getImageScaleType()
  {
    if (this.mImageScaleType == null)
      return f.getDefault();
    return this.mImageScaleType;
  }

  public Uri getImageUri()
  {
    return this.mImageUri;
  }

  public InternalBrowser getInternalBrowserSection()
  {
    return this.mInternalBrowserSection;
  }

  public Map getMap()
  {
    return this.mMap;
  }

  public MediaPlayer getMediaPlayer()
  {
    return this.mMediaPlayer;
  }

  public d getOpenUrlMediaType()
  {
    if (this.mOpenUrlMediaType != null)
      return this.mOpenUrlMediaType;
    return d.getDefaultValue();
  }

  public e getOpenUrlType()
  {
    if (this.mOpenUrlType != null)
      return this.mOpenUrlType;
    return e.getDefaultValue();
  }

  public b getReplyType()
  {
    if (this.mReplyType == null)
      return b.getDefaultValue();
    return this.mReplyType;
  }

  public int getRows()
  {
    return this.mRows;
  }

  public String getText()
  {
    return this.mText;
  }

  public String getTextBgGradientColor()
  {
    return this.mTextBgGradientColor;
  }

  public a getTextHorizontalAlign()
  {
    if (this.mTextHorizontalAlign != null)
      return this.mTextHorizontalAlign;
    return a.getDefault();
  }

  public int getTextOpacity()
  {
    return this.mTextOpacity;
  }

  public int[] getTextPaddings()
  {
    return this.mTextPaddings;
  }

  public g getTextSize()
  {
    if (this.mTextSize != null)
      return this.mTextSize;
    return g.REGULAR;
  }

  public b getTextVerticalAlign()
  {
    if (this.mTextVerticalAlign != null)
      return this.mTextVerticalAlign;
    return b.getDefault();
  }

  public boolean hasBgLoop()
  {
    if (this.mBgLoop == null)
      return true;
    return this.mBgLoop.booleanValue();
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * (31 * this.mColumns + this.mRows);
    int k;
    int n;
    label57: int i2;
    label83: int i4;
    label109: int i6;
    label139: int i8;
    label165: int i10;
    label191: int i12;
    label217: int i14;
    label243: int i16;
    label269: int i18;
    label295: int i20;
    label321: int i22;
    label347: int i24;
    label373: int i26;
    label399: int i28;
    label425: int i30;
    label451: label468: int i33;
    label501: int i35;
    label527: int i37;
    label553: int i38;
    if (this.mBgColor != null)
    {
      k = this.mBgColor.hashCode();
      int m = 31 * (k + j);
      if (this.mBgMedia == null)
        break label634;
      n = this.mBgMedia.hashCode();
      int i1 = 31 * (n + m);
      if (this.mBgMediaType == null)
        break label640;
      i2 = this.mBgMediaType.hashCode();
      int i3 = 31 * (i2 + i1);
      if (this.mBgMediaScaleType == null)
        break label646;
      i4 = this.mBgMediaScaleType.hashCode();
      int i5 = 31 * (i4 + i3);
      if ((this.mBgLoop == null) || (!this.mBgLoop.booleanValue()))
        break label652;
      i6 = i;
      int i7 = 31 * (i6 + i5);
      if (this.mOpenUrlType == null)
        break label658;
      i8 = this.mOpenUrlType.hashCode();
      int i9 = 31 * (i8 + i7);
      if (this.mOpenUrlMediaType == null)
        break label664;
      i10 = this.mOpenUrlMediaType.hashCode();
      int i11 = 31 * (i10 + i9);
      if (this.mActionType == null)
        break label670;
      i12 = this.mActionType.hashCode();
      int i13 = 31 * (i12 + i11);
      if (this.mActionBody == null)
        break label676;
      i14 = this.mActionBody.hashCode();
      int i15 = 31 * (i14 + i13);
      if (this.mSilent == null)
        break label682;
      i16 = this.mSilent.hashCode();
      int i17 = 31 * (i16 + i15);
      if (this.mReplyType == null)
        break label688;
      i18 = this.mReplyType.hashCode();
      int i19 = 31 * (i18 + i17);
      if (this.mImageUri == null)
        break label694;
      i20 = this.mImageUri.hashCode();
      int i21 = 31 * (i20 + i19);
      if (this.mImageScaleType == null)
        break label700;
      i22 = this.mImageScaleType.hashCode();
      int i23 = 31 * (i22 + i21);
      if (this.mTextVerticalAlign == null)
        break label706;
      i24 = this.mTextVerticalAlign.hashCode();
      int i25 = 31 * (i24 + i23);
      if (this.mTextHorizontalAlign == null)
        break label712;
      i26 = this.mTextHorizontalAlign.hashCode();
      int i27 = 31 * (i26 + i25);
      if (this.mText == null)
        break label718;
      i28 = this.mText.hashCode();
      int i29 = 31 * (i28 + i27);
      if (this.mTextSize == null)
        break label724;
      i30 = this.mTextSize.hashCode();
      int i31 = 31 * (i30 + i29);
      if (!this.mTextShouldFit)
        break label730;
      int i32 = 31 * (31 * (i31 + i) + this.mTextOpacity);
      if (this.mTextBgGradientColor == null)
        break label735;
      i33 = this.mTextBgGradientColor.hashCode();
      int i34 = 31 * (i33 + i32);
      if (this.mInternalBrowserSection == null)
        break label741;
      i35 = this.mInternalBrowserSection.hashCode();
      int i36 = 31 * (i35 + i34);
      if (this.mMediaPlayer == null)
        break label747;
      i37 = this.mMediaPlayer.hashCode();
      i38 = 31 * (31 * (i37 + i36) + Arrays.hashCode(this.mTextPaddings));
      if (this.mFrame == null)
        break label753;
    }
    label640: label646: label652: label658: label664: label670: label676: label682: label688: label694: label700: label706: label712: label718: label724: label730: label735: label741: label747: label753: for (int i39 = this.mFrame.hashCode(); ; i39 = 0)
    {
      int i40 = 31 * (i39 + i38);
      Map localMap = this.mMap;
      int i41 = 0;
      if (localMap != null)
        i41 = this.mMap.hashCode();
      return i40 + i41;
      k = 0;
      break;
      label634: n = 0;
      break label57;
      i2 = 0;
      break label83;
      i4 = 0;
      break label109;
      i6 = 0;
      break label139;
      i8 = 0;
      break label165;
      i10 = 0;
      break label191;
      i12 = 0;
      break label217;
      i14 = 0;
      break label243;
      i16 = 0;
      break label269;
      i18 = 0;
      break label295;
      i20 = 0;
      break label321;
      i22 = 0;
      break label347;
      i24 = 0;
      break label373;
      i26 = 0;
      break label399;
      i28 = 0;
      break label425;
      i30 = 0;
      break label451;
      i = 0;
      break label468;
      i33 = 0;
      break label501;
      i35 = 0;
      break label527;
      i37 = 0;
      break label553;
    }
  }

  public Boolean isSilent()
  {
    return this.mSilent;
  }

  public boolean isTextShouldFit()
  {
    return this.mTextShouldFit;
  }

  public void setActionBody(String paramString)
  {
    this.mActionBody = paramString;
  }

  public void setActionType(a parama)
  {
    this.mActionType = parama;
  }

  public void setBgColor(Integer paramInteger)
  {
    this.mBgColor = paramInteger;
  }

  public void setBgLoop(Boolean paramBoolean)
  {
    this.mBgLoop = paramBoolean;
  }

  public void setBgMedia(Uri paramUri)
  {
    this.mBgMedia = paramUri;
  }

  public void setBgMediaScaleType(f paramf)
  {
    this.mBgMediaScaleType = paramf;
  }

  public void setBgMediaType(c paramc)
  {
    this.mBgMediaType = paramc;
  }

  public void setColumns(int paramInt)
  {
    this.mColumns = paramInt;
  }

  public void setFrame(Frame paramFrame)
  {
    this.mFrame = paramFrame;
  }

  public void setImageScaleType(f paramf)
  {
    this.mImageScaleType = paramf;
  }

  public void setImageUri(Uri paramUri)
  {
    this.mImageUri = paramUri;
  }

  public void setInternalBrowserSection(InternalBrowser paramInternalBrowser)
  {
    this.mInternalBrowserSection = paramInternalBrowser;
  }

  public void setMap(Map paramMap)
  {
    this.mMap = paramMap;
  }

  public void setMediaPlayer(MediaPlayer paramMediaPlayer)
  {
    this.mMediaPlayer = paramMediaPlayer;
  }

  public void setOpenUrlMediaType(d paramd)
  {
    this.mOpenUrlMediaType = paramd;
  }

  public void setOpenUrlType(e parame)
  {
    this.mOpenUrlType = parame;
  }

  public void setReplyType(b paramb)
  {
    this.mReplyType = paramb;
  }

  public void setRows(int paramInt)
  {
    this.mRows = paramInt;
  }

  public void setSilent(Boolean paramBoolean)
  {
    this.mSilent = paramBoolean;
  }

  public void setText(String paramString)
  {
    this.mText = paramString;
  }

  public void setTextBgGradientColor(String paramString)
  {
    this.mTextBgGradientColor = paramString;
  }

  public void setTextHorizontalAlign(a parama)
  {
    this.mTextHorizontalAlign = parama;
  }

  public void setTextOpacity(int paramInt)
  {
    this.mTextOpacity = paramInt;
  }

  public void setTextPaddings(int[] paramArrayOfInt)
  {
    this.mTextPaddings = paramArrayOfInt;
  }

  public void setTextShouldFit(boolean paramBoolean)
  {
    this.mTextShouldFit = paramBoolean;
  }

  public void setTextSize(g paramg)
  {
    this.mTextSize = paramg;
  }

  public void setTextVerticalAlign(b paramb)
  {
    this.mTextVerticalAlign = paramb;
  }

  public String toString()
  {
    return "ReplyButton{mColumns=" + this.mColumns + ", mRows=" + this.mRows + ", mBgColor=" + this.mBgColor + ", mBgMedia=" + this.mBgMedia + ", mBgMediaType=" + this.mBgMediaType + ", mBgMediaScaleType=" + this.mBgMediaScaleType + ", mBgLoop=" + this.mBgLoop + ", mOpenUrlType=" + this.mOpenUrlType + ", mOpenUrlMediaType=" + this.mOpenUrlMediaType + ", mActionType=" + this.mActionType + ", mActionBody='" + this.mActionBody + '\'' + ", mSilent=" + this.mSilent + ", mReplyType=" + this.mReplyType + ", mImageUri=" + this.mImageUri + ", mImageScaleType=" + this.mImageScaleType + ", mTextVerticalAlign=" + this.mTextVerticalAlign + ", mTextHorizontalAlign=" + this.mTextHorizontalAlign + ", mText='" + this.mText + '\'' + ", mTextSize=" + this.mTextSize + ", mTextShouldFit=" + this.mTextShouldFit + ", mTextOpacity=" + this.mTextOpacity + ", mTextBgGradientColor='" + this.mTextBgGradientColor + '\'' + ", mInternalBrowserSection=" + this.mInternalBrowserSection + ", mMediaPlayer=" + this.mMediaPlayer + ", mTextPaddings=" + Arrays.toString(this.mTextPaddings) + ", mFrame=" + this.mFrame + ", mMap=" + this.mMap + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    int j = -1;
    paramParcel.writeInt(this.mColumns);
    paramParcel.writeInt(this.mRows);
    int k;
    int m;
    label63: int n;
    label80: int i1;
    label106: int i2;
    label124: int i3;
    label141: int i4;
    label158: int i5;
    label192: int i6;
    label210: int i7;
    label236: int i8;
    label253: int i9;
    if (this.mBgColor != null)
    {
      k = this.mBgColor.intValue();
      paramParcel.writeInt(k);
      paramParcel.writeParcelable(this.mBgMedia, paramInt);
      if (this.mBgMediaType != null)
        break label378;
      m = j;
      paramParcel.writeInt(m);
      if (this.mBgMediaScaleType != null)
        break label390;
      n = j;
      paramParcel.writeInt(n);
      if ((this.mBgLoop == null) || (!this.mBgLoop.booleanValue()))
        break label402;
      i1 = i;
      paramParcel.writeByte((byte)i1);
      if (this.mOpenUrlType != null)
        break label408;
      i2 = j;
      paramParcel.writeInt(i2);
      if (this.mOpenUrlMediaType != null)
        break label420;
      i3 = j;
      paramParcel.writeInt(i3);
      if (this.mActionType != null)
        break label432;
      i4 = j;
      paramParcel.writeInt(i4);
      paramParcel.writeString(this.mActionBody);
      if (this.mSilent == null)
        break label450;
      if (!this.mSilent.booleanValue())
        break label444;
      i5 = i;
      paramParcel.writeByte((byte)i5);
      if (this.mReplyType != null)
        break label457;
      i6 = j;
      paramParcel.writeInt(i6);
      paramParcel.writeParcelable(this.mImageUri, paramInt);
      if (this.mImageScaleType != null)
        break label469;
      i7 = j;
      paramParcel.writeInt(i7);
      if (this.mTextVerticalAlign != null)
        break label481;
      i8 = j;
      paramParcel.writeInt(i8);
      if (this.mTextHorizontalAlign != null)
        break label493;
      i9 = j;
      label270: paramParcel.writeInt(i9);
      paramParcel.writeString(this.mText);
      if (this.mTextSize != null)
        break label505;
      label291: paramParcel.writeInt(j);
      if (!this.mTextShouldFit)
        break label517;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeInt(this.mTextOpacity);
      paramParcel.writeString(this.mTextBgGradientColor);
      paramParcel.writeParcelable(this.mInternalBrowserSection, paramInt);
      paramParcel.writeParcelable(this.mMediaPlayer, paramInt);
      paramParcel.writeIntArray(this.mTextPaddings);
      paramParcel.writeParcelable(this.mFrame, paramInt);
      paramParcel.writeParcelable(this.mMap, paramInt);
      return;
      k = -2147483648;
      break;
      label378: m = this.mBgMediaType.ordinal();
      break label63;
      label390: n = this.mBgMediaScaleType.ordinal();
      break label80;
      label402: i1 = 0;
      break label106;
      label408: i2 = this.mOpenUrlType.ordinal();
      break label124;
      label420: i3 = this.mOpenUrlMediaType.ordinal();
      break label141;
      label432: i4 = this.mActionType.ordinal();
      break label158;
      label444: i5 = 0;
      break label192;
      label450: i5 = j;
      break label192;
      label457: i6 = this.mReplyType.ordinal();
      break label210;
      label469: i7 = this.mImageScaleType.ordinal();
      break label236;
      label481: i8 = this.mTextVerticalAlign.ordinal();
      break label253;
      label493: i9 = this.mTextHorizontalAlign.ordinal();
      break label270;
      label505: j = this.mTextSize.ordinal();
      break label291;
      label517: i = 0;
    }
  }

  public static enum a
  {
    private final String mTypeName;

    static
    {
      OPEN_URL = new a("OPEN_URL", 1, "open-url");
      LOCATION_PICKER = new a("LOCATION_PICKER", 2, "location-picker");
      SHARE_PHONE = new a("SHARE_PHONE", 3, "share-phone");
      OPEN_MAP = new a("OPEN_MAP", 4, "open-map");
      SUBSCRIBE_BOT = new a("SUBSCRIBE_BOT", 5, "subscribe-bot");
      NONE = new a("NONE", 6, "none");
      a[] arrayOfa = new a[7];
      arrayOfa[0] = REPLY;
      arrayOfa[1] = OPEN_URL;
      arrayOfa[2] = LOCATION_PICKER;
      arrayOfa[3] = SHARE_PHONE;
      arrayOfa[4] = OPEN_MAP;
      arrayOfa[5] = SUBSCRIBE_BOT;
      arrayOfa[6] = NONE;
    }

    private a(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static a fromName(String paramString)
    {
      a locala;
      if (TextUtils.isEmpty(paramString))
      {
        locala = getDefaultValue();
        return locala;
      }
      a[] arrayOfa = values();
      int i = arrayOfa.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label52;
        locala = arrayOfa[j];
        if (locala.mTypeName.equalsIgnoreCase(paramString))
          break;
      }
      label52: return getDefaultValue();
    }

    public static a getDefaultValue()
    {
      return REPLY;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }

  public static enum b
  {
    private final String mTypeName;

    static
    {
      MESSAGE = new b("MESSAGE", 1, "message");
      b[] arrayOfb = new b[2];
      arrayOfb[0] = QUERY;
      arrayOfb[1] = MESSAGE;
    }

    private b(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static b fromName(String paramString)
    {
      b localb;
      if (TextUtils.isEmpty(paramString))
      {
        localb = getDefaultValue();
        return localb;
      }
      b[] arrayOfb = values();
      int i = arrayOfb.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label52;
        localb = arrayOfb[j];
        if (localb.mTypeName.equalsIgnoreCase(paramString))
          break;
      }
      label52: return getDefaultValue();
    }

    public static b getDefaultValue()
    {
      return MESSAGE;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }

  public static enum c
  {
    private final String mTypeName;

    static
    {
      GIF = new c("GIF", 1, "gif");
      VIDEO = new c("VIDEO", 2, "video");
      UNKNOWN = new c("UNKNOWN", 3, "unknown");
      c[] arrayOfc = new c[4];
      arrayOfc[0] = PICTURE;
      arrayOfc[1] = GIF;
      arrayOfc[2] = VIDEO;
      arrayOfc[3] = UNKNOWN;
    }

    private c(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static c fromName(String paramString)
    {
      c localc;
      if (TextUtils.isEmpty(paramString))
      {
        localc = null;
        return localc;
      }
      c[] arrayOfc = values();
      int i = arrayOfc.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label50;
        localc = arrayOfc[j];
        if (localc.mTypeName.equalsIgnoreCase(paramString))
          break;
      }
      label50: return UNKNOWN;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }

  public static enum d
  {
    private final String mTypeName;

    static
    {
      AUDIO = new d("AUDIO", 1, "audio");
      GIF = new d("GIF", 2, "gif");
      PICTURE = new d("PICTURE", 3, "picture");
      NOT_MEDIA = new d("NOT_MEDIA", 4, "not-media");
      d[] arrayOfd = new d[5];
      arrayOfd[0] = VIDEO;
      arrayOfd[1] = AUDIO;
      arrayOfd[2] = GIF;
      arrayOfd[3] = PICTURE;
      arrayOfd[4] = NOT_MEDIA;
    }

    private d(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static d fromName(String paramString)
    {
      d locald;
      if (TextUtils.isEmpty(paramString))
      {
        locald = getDefaultValue();
        return locald;
      }
      d[] arrayOfd = values();
      int i = arrayOfd.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label52;
        locald = arrayOfd[j];
        if (locald.mTypeName.equalsIgnoreCase(paramString))
          break;
      }
      label52: return getDefaultValue();
    }

    public static d getDefaultValue()
    {
      return NOT_MEDIA;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }

  public static enum e
  {
    private final String mTypeName;

    static
    {
      EXTERNAL = new e("EXTERNAL", 1, "external");
      e[] arrayOfe = new e[2];
      arrayOfe[0] = INTERNAL;
      arrayOfe[1] = EXTERNAL;
    }

    private e(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static e fromName(String paramString)
    {
      e locale;
      if (TextUtils.isEmpty(paramString))
      {
        locale = getDefaultValue();
        return locale;
      }
      e[] arrayOfe = values();
      int i = arrayOfe.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label52;
        locale = arrayOfe[j];
        if (locale.mTypeName.equalsIgnoreCase(paramString))
          break;
      }
      label52: return getDefaultValue();
    }

    public static e getDefaultValue()
    {
      return EXTERNAL;
    }

    public String getTypeName()
    {
      return this.mTypeName;
    }
  }

  public static enum f
  {
    private final String mScaleTypeName;

    static
    {
      f[] arrayOff = new f[3];
      arrayOff[0] = CROP;
      arrayOff[1] = FILL;
      arrayOff[2] = FIT;
    }

    private f(String paramString)
    {
      this.mScaleTypeName = paramString;
    }

    public static f fromName(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      while (true)
      {
        return null;
        for (f localf : values())
          if (localf.getScaleTypeName().equalsIgnoreCase(paramString))
            return localf;
      }
    }

    public static f getDefault()
    {
      return CROP;
    }

    public String getScaleTypeName()
    {
      return this.mScaleTypeName;
    }
  }

  public static enum g
  {
    private final String mTypeName;

    static
    {
      REGULAR = new g("REGULAR", 1, "regular");
      LARGE = new g("LARGE", 2, "large");
      g[] arrayOfg = new g[3];
      arrayOfg[0] = SMALL;
      arrayOfg[1] = REGULAR;
      arrayOfg[2] = LARGE;
    }

    private g(String paramString)
    {
      this.mTypeName = paramString;
    }

    public static g fromName(String paramString)
    {
      g localg;
      if (TextUtils.isEmpty(paramString))
      {
        localg = getDefaultValue();
        return localg;
      }
      g[] arrayOfg = values();
      int i = arrayOfg.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label52;
        localg = arrayOfg[j];
        if (localg.mTypeName.equalsIgnoreCase(paramString))
          break;
      }
      label52: return getDefaultValue();
    }

    public static g getDefaultValue()
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
 * Qualified Name:     com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton
 * JD-Core Version:    0.6.2
 */