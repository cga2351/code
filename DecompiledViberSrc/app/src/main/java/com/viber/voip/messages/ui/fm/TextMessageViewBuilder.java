package com.viber.voip.messages.ui.fm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Parcel;
import android.support.v4.widget.TextViewCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.l;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f;
import com.viber.voip.messages.d.c;
import com.viber.voip.messages.orm.entity.json.TextMessage;
import com.viber.voip.messages.orm.entity.json.TextSize;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.util.da;
import com.viber.voip.util.g.a.b.a;
import com.viber.voip.widget.MessageTextView;

public class TextMessageViewBuilder extends a<TextView>
{
  protected final TextMessage g;
  private ai h;
  private final f i;

  public TextMessageViewBuilder(TextMessage paramTextMessage, Context paramContext, com.viber.voip.messages.conversation.adapter.a.a parama, i parami, com.viber.voip.messages.conversation.adapter.e.b paramb, f paramf)
  {
    super(paramTextMessage, paramContext, parama, parami, paramb);
    this.g = paramTextMessage;
    this.i = paramf;
  }

  private CharSequence a(Context paramContext)
  {
    if (this.g.getParsedStyledText() != null)
      return this.g.getParsedStyledText();
    String str1 = this.g.getText();
    if (TextUtils.isEmpty(str1))
      return "";
    SpannableString localSpannableString1 = new SpannableString(str1);
    int j;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    ai localai;
    com.viber.voip.messages.d.b localb;
    String str2;
    boolean bool4;
    if (this.d.c().aT())
    {
      j = this.g.getTextColor();
      TextSize localTextSize = this.g.getTextSize();
      localSpannableString1.setSpan(new TextMessageSpan(k(), localTextSize.getSizeInPx(paramContext), j, this.g.hasUnderline(), localTextSize.isLight()), 0, str1.length(), 17);
      bool1 = b.a.c(this.g, this.c);
      bool2 = b.a.b(this.g, this.c);
      bool3 = b.a.a(this.g, this.c);
      if ((!bool2) && (!bool3) && (!bool1))
        break label286;
      localai = j();
      localb = c.c();
      str2 = this.g.getSpans();
      if (b.a.a(this.c))
        break label280;
      bool4 = true;
    }
    label207: for (SpannableString localSpannableString2 = da.a(localSpannableString1, localai, localb, str2, bool3, bool4, bool2, bool1, aj.b, this.c.A(), this.f.h()); ; localSpannableString2 = localSpannableString1)
    {
      this.g.setParsedStyledText(localSpannableString2);
      return localSpannableString2;
      j = this.f.ay().a(this.g.getTextColor());
      break;
      bool4 = false;
      break label207;
    }
  }

  private ai j()
  {
    if (this.h == null)
      this.h = new ai(this.a);
    return this.h;
  }

  private int k()
  {
    if ((this.g.hasBold()) && (this.g.hasItalic()))
      return 3;
    if (this.g.hasBold())
      return 1;
    if (this.g.hasItalic())
      return 2;
    return 0;
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public void a(TextView paramTextView)
  {
    super.a(paramTextView);
    if (this.g.getAction() != null)
      paramTextView.setTag(this.c);
    paramTextView.setText(a(paramTextView.getContext()));
    paramTextView.setIncludeFontPadding(false);
    if (b.a.a(this.g, this.c))
      paramTextView.setMovementMethod(new l(paramTextView, this.i));
    int j = TextViewCompat.getMaxLines(paramTextView);
    if (this.g.getMaxLines() <= 0)
    {
      if (j != 2147483647)
      {
        paramTextView.setSingleLine(false);
        paramTextView.setMaxLines(2147483647);
      }
      return;
    }
    if (1 == this.g.getMaxLines())
    {
      paramTextView.setSingleLine(true);
      if (j != 1)
        paramTextView.setMaxLines(1);
    }
    while (true)
    {
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
      return;
      if (j == 1)
        paramTextView.setSingleLine(false);
      if (j != this.g.getMaxLines())
        paramTextView.setMaxLines(this.g.getMaxLines());
    }
  }

  public TextView d()
  {
    return new MessageTextView(this.a);
  }

  public int e()
  {
    Resources localResources = this.a.getResources();
    switch (1.a[this.g.getTextSize().ordinal()])
    {
    default:
      return localResources.getDimensionPixelSize(R.dimen.formatted_message_normal_text_padding_top);
    case 1:
      if (this.d.q())
        return localResources.getDimensionPixelSize(R.dimen.formatted_message_huge_text_padding_top);
      return localResources.getDimensionPixelOffset(R.dimen.formatted_message_huge_text_without_name_padding_top);
    case 2:
      return localResources.getDimensionPixelSize(R.dimen.formatted_message_big_text_padding_top);
    case 3:
    }
    return localResources.getDimensionPixelSize(R.dimen.formatted_message_small_text_padding_top);
  }

  public int f()
  {
    Resources localResources = this.a.getResources();
    switch (1.a[this.g.getTextSize().ordinal()])
    {
    default:
      return localResources.getDimensionPixelSize(R.dimen.formatted_message_normal_text_bottom_padding);
    case 1:
      return localResources.getDimensionPixelSize(R.dimen.formatted_message_huge_text_bottom_padding);
    case 2:
      return localResources.getDimensionPixelSize(R.dimen.formatted_message_normal_text_bottom_padding);
    case 3:
    }
    return localResources.getDimensionPixelSize(R.dimen.formatted_message_small_text_bottom_padding);
  }

  public TextMessage g()
  {
    return this.g;
  }

  @SuppressLint({"ParcelCreator"})
  static class TextMessageSpan extends StyleSpan
  {
    private final boolean mHasUnderline;
    private final boolean mIsLight;
    private final int mTextColor;
    private final float mTextSize;

    public TextMessageSpan(int paramInt1, float paramFloat, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      this.mTextSize = paramFloat;
      this.mTextColor = paramInt2;
      this.mHasUnderline = paramBoolean1;
      this.mIsLight = paramBoolean2;
    }

    public TextMessageSpan(Parcel paramParcel)
    {
      super();
      boolean bool2;
      if (paramParcel.readInt() != 0)
      {
        bool2 = bool1;
        this.mHasUnderline = bool2;
        this.mTextColor = paramParcel.readInt();
        this.mTextSize = paramParcel.readFloat();
        if (paramParcel.readInt() == 0)
          break label55;
      }
      while (true)
      {
        this.mIsLight = bool1;
        return;
        bool2 = false;
        break;
        label55: bool1 = false;
      }
    }

    private void apply(TextPaint paramTextPaint)
    {
      paramTextPaint.setUnderlineText(this.mHasUnderline);
      paramTextPaint.setColor(this.mTextColor);
      paramTextPaint.setTextSize(this.mTextSize);
      if (this.mIsLight)
        paramTextPaint.setTypeface(Typeface.create("sans-serif-light", 0));
    }

    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      apply(paramTextPaint);
    }

    public void updateMeasureState(TextPaint paramTextPaint)
    {
      super.updateMeasureState(paramTextPaint);
      apply(paramTextPaint);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      super.writeToParcel(paramParcel, paramInt);
      int j;
      if (this.mHasUnderline)
      {
        j = i;
        paramParcel.writeInt(j);
        paramParcel.writeInt(this.mTextColor);
        paramParcel.writeFloat(this.mTextSize);
        if (!this.mIsLight)
          break label59;
      }
      while (true)
      {
        paramParcel.writeInt(i);
        return;
        j = 0;
        break;
        label59: i = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.TextMessageViewBuilder
 * JD-Core Version:    0.6.2
 */