package com.viber.voip.ui.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dq;

public class f
{
  private final Context a;
  private final boolean b;
  private ImageSpan c;

  public f(Context paramContext, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramBoolean;
  }

  private ImageSpan a()
  {
    if (this.c == null)
    {
      Bitmap localBitmap = df.a(dq.a(this.a.getResources(), b()), dc.d(this.a, R.attr.toolbarTitleColor));
      if (localBitmap != null)
        this.c = new ImageSpan(this.a, localBitmap);
    }
    return this.c;
  }

  private int b()
  {
    if (this.b)
      return R.drawable.rakuten_viber_logo;
    return R.drawable.viber_logo;
  }

  public CharSequence a(int paramInt)
  {
    return a(this.a.getString(paramInt));
  }

  public CharSequence a(CharSequence paramCharSequence)
  {
    ImageSpan localImageSpan = a();
    if (localImageSpan == null)
      return paramCharSequence;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramCharSequence);
    localSpannableStringBuilder.setSpan(localImageSpan, 0, localSpannableStringBuilder.length(), 33);
    return localSpannableStringBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.f.f
 * JD-Core Version:    0.6.2
 */