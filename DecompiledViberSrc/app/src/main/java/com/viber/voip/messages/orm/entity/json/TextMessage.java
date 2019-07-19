package com.viber.voip.messages.orm.entity.json;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.text.BidiFormatter;
import org.json.JSONException;
import org.json.JSONObject;

public class TextMessage extends BaseMessage
{
  public static final Parcelable.Creator<TextMessage> CREATOR = new Parcelable.Creator()
  {
    public TextMessage createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TextMessage(paramAnonymousParcel);
    }

    public TextMessage[] newArray(int paramAnonymousInt)
    {
      return new TextMessage[paramAnonymousInt];
    }
  };
  private static final int DEFAULT_TEXT_COLOR = -13487566;
  private static final String KEY_HAS_BOLD = "Bold";
  private static final String KEY_HAS_ITALIC = "Italic";
  private static final String KEY_HAS_UNDERLINE = "Underline";
  public static final String KEY_MESSAGE_TEXT = "Text";
  private static final String KEY_TEXT_COLOR = "Color";
  private static final String KEY_TEXT_SIZE = "Size";
  private final boolean mBold;
  private final boolean mConsiderMentions;
  private final boolean mHighlightEmoticons;
  private final boolean mHighlightLinks;
  private final boolean mItalic;
  private final int mMaxLines;
  private String mSpans;
  private final String mText;
  private final int mTextColor;
  private final TextSize mTextSize;
  private final boolean mUnderline;
  private transient CharSequence parsedStyledText;

  public TextMessage(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    super(paramInt, MessageType.TEXT, paramJSONObject);
    this.mText = paramJSONObject.optString("Text");
    this.mTextSize = TextSize.toEnum(paramJSONObject.optInt("Size", TextSize.NORMAL.ordinal()));
    this.mTextColor = parseColor(paramJSONObject);
    this.mBold = paramJSONObject.optBoolean("Bold", false);
    this.mItalic = paramJSONObject.optBoolean("Italic", false);
    this.mUnderline = paramJSONObject.optBoolean("Underline", false);
    this.mHighlightLinks = paramJSONObject.optBoolean("HighlightLinks", false);
    this.mHighlightEmoticons = paramJSONObject.optBoolean("HighlightEmoticons", false);
    this.mConsiderMentions = paramJSONObject.optBoolean("ConsiderMentions", false);
    this.mMaxLines = paramJSONObject.optInt("MaxLinesNumber");
    this.mSpans = paramJSONObject.optString("TextSpans");
  }

  public TextMessage(Parcel paramParcel)
  {
    super(paramParcel);
    this.mText = paramParcel.readString();
    int i = paramParcel.readInt();
    TextSize localTextSize;
    boolean bool2;
    label56: boolean bool3;
    label72: boolean bool4;
    label88: boolean bool5;
    label104: boolean bool6;
    if (i != -1)
    {
      localTextSize = TextSize.values()[i];
      this.mTextSize = localTextSize;
      this.mTextColor = paramParcel.readInt();
      if (paramParcel.readInt() == 0)
        break label163;
      bool2 = bool1;
      this.mBold = bool2;
      if (paramParcel.readInt() == 0)
        break label169;
      bool3 = bool1;
      this.mItalic = bool3;
      if (paramParcel.readInt() == 0)
        break label175;
      bool4 = bool1;
      this.mUnderline = bool4;
      if (paramParcel.readInt() == 0)
        break label181;
      bool5 = bool1;
      this.mHighlightLinks = bool5;
      if (paramParcel.readInt() == 0)
        break label187;
      bool6 = bool1;
      label120: this.mHighlightEmoticons = bool6;
      if (paramParcel.readInt() == 0)
        break label193;
    }
    while (true)
    {
      this.mConsiderMentions = bool1;
      this.mMaxLines = paramParcel.readInt();
      this.mSpans = paramParcel.readString();
      return;
      localTextSize = TextSize.NORMAL;
      break;
      label163: bool2 = false;
      break label56;
      label169: bool3 = false;
      break label72;
      label175: bool4 = false;
      break label88;
      label181: bool5 = false;
      break label104;
      label187: bool6 = false;
      break label120;
      label193: bool1 = false;
    }
  }

  private static int parseColor(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("Color", -13487566L);
    if (l >> 24 == 0L)
      l |= 4278190080L;
    return (int)l;
  }

  private void setSpans(String paramString)
  {
    this.mSpans = paramString;
  }

  public int getGravity(boolean paramBoolean)
  {
    if ((paramBoolean) && (BidiFormatter.getInstance().isRtl(this.mText)))
      return 8388613;
    return super.getGravity(paramBoolean);
  }

  public int getMaxLines()
  {
    return this.mMaxLines;
  }

  public CharSequence getParsedStyledText()
  {
    return this.parsedStyledText;
  }

  public String getSpans()
  {
    return this.mSpans;
  }

  public String getText()
  {
    return this.mText;
  }

  public int getTextColor()
  {
    return this.mTextColor;
  }

  public TextSize getTextSize()
  {
    return this.mTextSize;
  }

  public int getWidthPx(boolean paramBoolean)
  {
    if (paramBoolean)
      return -2;
    return -1;
  }

  public boolean hasBold()
  {
    return this.mBold;
  }

  public boolean hasItalic()
  {
    return this.mItalic;
  }

  public boolean hasUnderline()
  {
    return this.mUnderline;
  }

  public final MutableTextMessageWrapper mutate()
  {
    return new MutableTextMessageWrapper(this, null);
  }

  public void setParsedStyledText(CharSequence paramCharSequence)
  {
    this.parsedStyledText = paramCharSequence;
  }

  public boolean shouldConsiderMentions()
  {
    return this.mConsiderMentions;
  }

  public boolean shouldHighlightEmoticons()
  {
    return this.mHighlightEmoticons;
  }

  public boolean shouldHighlightLinks()
  {
    return this.mHighlightLinks;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Text [text=").append(this.mText).append(", textSize=").append(this.mTextSize).append(", textColor=").append(this.mTextColor).append(", bold=").append(this.mBold).append(", italic=").append(this.mItalic).append(", underline=").append(this.mUnderline).append(", width=").append(this.mWidth).append(", action=").append(this.mAction).append(" | highlightLinks=").append(this.mHighlightLinks).append(", highlightEmoticons=").append(this.mHighlightEmoticons).append(", ConsiderMentions=").append(this.mConsiderMentions).append(", maxLines=").append(this.mMaxLines).append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mText);
    int j;
    int k;
    label56: int m;
    label72: int n;
    label88: int i1;
    label104: int i2;
    if (this.mTextSize != null)
    {
      j = this.mTextSize.ordinal();
      paramParcel.writeInt(j);
      paramParcel.writeInt(this.mTextColor);
      if (!this.mBold)
        break label161;
      k = i;
      paramParcel.writeInt(k);
      if (!this.mItalic)
        break label167;
      m = i;
      paramParcel.writeInt(m);
      if (!this.mUnderline)
        break label173;
      n = i;
      paramParcel.writeInt(n);
      if (!this.mHighlightLinks)
        break label179;
      i1 = i;
      paramParcel.writeInt(i1);
      if (!this.mHighlightEmoticons)
        break label185;
      i2 = i;
      label120: paramParcel.writeInt(i2);
      if (!this.mConsiderMentions)
        break label191;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.mMaxLines);
      paramParcel.writeString(this.mSpans);
      return;
      j = -1;
      break;
      label161: k = 0;
      break label56;
      label167: m = 0;
      break label72;
      label173: n = 0;
      break label88;
      label179: i1 = 0;
      break label104;
      label185: i2 = 0;
      break label120;
      label191: i = 0;
    }
  }

  public static class InternalKey
  {
    public static final String CONSIDER_MENTIONS = "ConsiderMentions";
    public static final String HIGHLIGHT_EMOTICONS = "HighlightEmoticons";
    public static final String HIGHLIGHT_LINKS = "HighlightLinks";
    public static final String MAX_LINES = "MaxLinesNumber";
    public static final String SPANS = "TextSpans";
  }

  public static final class MutableTextMessageWrapper
  {
    private final TextMessage mTextMessage;

    private MutableTextMessageWrapper(TextMessage paramTextMessage)
    {
      this.mTextMessage = paramTextMessage;
    }

    public void setSpans(String paramString)
    {
      this.mTextMessage.setSpans(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.json.TextMessage
 * JD-Core Version:    0.6.2
 */