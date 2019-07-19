package com.viber.voip.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.viber.voip.util.bp;
import com.viber.voip.util.da;

public class ItalicTextView extends ViberTextView
{
  private boolean a;
  private CharSequence b;
  private SpannableStringBuilder c;
  private CharSequence d;

  public ItalicTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public ItalicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public ItalicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private CharSequence a(boolean paramBoolean)
  {
    this.c.clear();
    if (paramBoolean)
      this.c.append(" ");
    this.c.append(this.b);
    if (!paramBoolean)
      this.c.append(" ");
    return SpannableString.valueOf(this.c);
  }

  private void a()
  {
    Typeface localTypeface = getTypeface();
    if (localTypeface == null);
    for (int i = 0; ; i = localTypeface.getStyle())
    {
      setTypeface(localTypeface, i);
      this.c = new SpannableStringBuilder();
      this.d = new StringBuilder(1).append(' ');
      return;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i;
    if (this.a)
    {
      this.a = false;
      StaticLayout localStaticLayout = new StaticLayout(getText(), 0, getText().length(), getPaint(), getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false, TextUtils.TruncateAt.END, getMeasuredWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      if (localStaticLayout.getLineCount() > 1)
      {
        boolean bool = bp.a(this.b.toString());
        i = localStaticLayout.getLineStart(1);
        CharSequence localCharSequence = getText();
        this.c.clear();
        this.c.append(localCharSequence);
        if (!bool)
          break label160;
        this.c.insert(i, this.d);
      }
    }
    while (true)
    {
      a(SpannableString.valueOf(this.c));
      return;
      label160: if (!Character.isWhitespace(this.c.charAt(i - 1)))
        this.c.insert(i - 1, this.d);
    }
  }

  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((paramCharSequence != null) && ((this.b == null) || (!da.a(paramCharSequence.toString(), this.b.toString()))))
    {
      this.b = paramCharSequence;
      if (!da.a(this.b))
      {
        boolean bool1 = bp.a(this.b.toString());
        boolean bool2 = Character.isWhitespace(this.b.charAt(0));
        boolean bool3 = Character.isWhitespace(this.b.charAt(-1 + paramCharSequence.length()));
        this.a = true;
        if (((!bool2) && (bool1)) || ((!bool3) && (!bool1)))
        {
          this.b = a(bool1);
          super.setText(this.b, paramBufferType);
          return;
        }
      }
    }
    super.setText(paramCharSequence, paramBufferType);
  }

  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    if ((paramInt & 0x1) > 0);
    for (int i = 3; ; i = 2)
    {
      super.setTypeface(paramTypeface, i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ItalicTextView
 * JD-Core Version:    0.6.2
 */