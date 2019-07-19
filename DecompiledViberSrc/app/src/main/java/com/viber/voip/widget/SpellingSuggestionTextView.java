package com.viber.voip.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.method.SingleLineTransformationMethod;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.style;

public class SpellingSuggestionTextView extends AppCompatTextView
{
  public SpellingSuggestionTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public SpellingSuggestionTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public SpellingSuggestionTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setTransformationMethod(new a(paramContext, null));
  }

  private static final class a extends SingleLineTransformationMethod
  {
    private final Context a;

    private a(Context paramContext)
    {
      this.a = paramContext;
    }

    private SpannableString a(SpannableString paramSpannableString)
    {
      TextAppearanceSpan[] arrayOfTextAppearanceSpan = (TextAppearanceSpan[])paramSpannableString.getSpans(0, paramSpannableString.length(), TextAppearanceSpan.class);
      if ((arrayOfTextAppearanceSpan != null) && (arrayOfTextAppearanceSpan.length > 0))
      {
        int i = arrayOfTextAppearanceSpan.length;
        for (int j = 0; j < i; j++)
          paramSpannableString.removeSpan(arrayOfTextAppearanceSpan[j]);
      }
      paramSpannableString.setSpan(new TextAppearanceSpan(this.a, R.style.EditTextSuggestionItemTextAppearance), 0, paramSpannableString.length(), 33);
      return paramSpannableString;
    }

    public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      if ((paramCharSequence instanceof SpannedString))
        paramCharSequence = a(new SpannableString((SpannedString)paramCharSequence));
      return super.getTransformation(paramCharSequence, paramView);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.SpellingSuggestionTextView
 * JD-Core Version:    0.6.2
 */