package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.color;
import com.viber.voip.R.integer;
import com.viber.voip.R.string;
import com.viber.voip.publicaccount.d.f;

public class PublicAccountIdEditText extends TextViewWithDescription
{
  private CharSequence e;

  public PublicAccountIdEditText(Context paramContext)
  {
    super(paramContext);
  }

  public PublicAccountIdEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PublicAccountIdEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private CharSequence a(Context paramContext)
  {
    int i = getResources().getColor(R.color.view_with_description_hint_color_states);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramContext.getString(R.string.public_account_id_prefix));
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, localSpannableStringBuilder.length(), 17);
    return localSpannableStringBuilder;
  }

  protected View b(Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = super.b(paramContext, paramAttributeSet);
    this.e = a(paramContext);
    final ae localae = super.getEditText();
    localae.setText(this.e);
    localae.setSingleLine(true);
    localae.setMaxLines(1);
    localae.setOnSelectionChangedListener(new ae.a()
    {
      private final int c = PublicAccountIdEditText.a(PublicAccountIdEditText.this).length();

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if ((localae.getText().length() >= this.c) && (paramAnonymousInt1 < this.c))
          localae.setSelection(this.c, Math.max(this.c, paramAnonymousInt2));
      }
    });
    int i = paramContext.getResources().getInteger(R.integer.public_account_max_id_chars);
    InputFilter[] arrayOfInputFilter1 = new InputFilter[1];
    arrayOfInputFilter1[0] = new InputFilter.LengthFilter(i + this.e.length());
    a(arrayOfInputFilter1);
    InputFilter[] arrayOfInputFilter2 = new InputFilter[1];
    arrayOfInputFilter2[0] = new a(this.e);
    a(arrayOfInputFilter2);
    return localView;
  }

  public String getPublicAccountId()
  {
    String str = getText().toString();
    if (str.length() > this.e.length())
      if (str.startsWith(this.e.toString()))
        str = str.substring(this.e.length());
    while (!str.equals(this.e.toString()))
      return str;
    return "";
  }

  private static class a
    implements InputFilter
  {
    private final CharSequence a;

    public a(CharSequence paramCharSequence)
    {
      this.a = paramCharSequence;
    }

    private boolean a(CharSequence paramCharSequence1, int paramInt1, int paramInt2, CharSequence paramCharSequence2)
    {
      if (paramInt2 - paramInt1 < paramCharSequence2.length())
        return false;
      for (int i = 0; ; i++)
      {
        if ((i >= paramCharSequence2.length()) || (paramInt1 + i >= paramInt2))
          break label66;
        if (paramCharSequence1.charAt(paramInt1 + i) != paramCharSequence2.charAt(i))
          break;
      }
      label66: return true;
    }

    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if (paramSpanned.length() == 0)
      {
        if (a(paramCharSequence, paramInt1, paramInt2, this.a))
          paramInt1 += this.a.length();
        return new SpannableStringBuilder(this.a).append(paramCharSequence, paramInt1, paramInt2);
      }
      if (paramInt3 < this.a.length())
        return this.a.subSequence(paramInt3, Math.min(this.a.length(), paramInt4));
      int i = paramInt2 - paramInt1;
      StringBuilder localStringBuilder = new StringBuilder(i);
      if (i > 0)
        while (paramInt1 < paramInt2)
        {
          if (f.b(paramCharSequence.charAt(paramInt1)))
            localStringBuilder.append(Character.toLowerCase(paramCharSequence.charAt(paramInt1)));
          paramInt1++;
        }
      return localStringBuilder.toString();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PublicAccountIdEditText
 * JD-Core Version:    0.6.2
 */