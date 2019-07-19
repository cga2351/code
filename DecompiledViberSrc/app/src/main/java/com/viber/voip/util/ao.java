package com.viber.voip.util;

import android.text.InputFilter;
import android.text.Spanned;

public abstract class ao
  implements InputFilter
{
  private boolean a = true;

  public abstract CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4);

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.a)
      paramCharSequence = a(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    return paramCharSequence;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ao
 * JD-Core Version:    0.6.2
 */