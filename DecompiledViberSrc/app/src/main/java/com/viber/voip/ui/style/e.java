package com.viber.voip.ui.style;

import android.text.Spannable;
import com.viber.voip.flatbuffers.model.TextMetaInfo;

public class e
  implements d
{
  public c a(TextMetaInfo paramTextMetaInfo)
  {
    switch (1.a[paramTextMetaInfo.getType().ordinal()])
    {
    default:
      return null;
    case 1:
    }
    return new UserMentionSpan(paramTextMetaInfo);
  }

  public void a(Spannable paramSpannable, int paramInt1, int paramInt2, TextMetaInfo paramTextMetaInfo)
  {
    a(paramSpannable, paramInt1, paramInt2, paramTextMetaInfo, 33);
  }

  public void a(Spannable paramSpannable, int paramInt1, int paramInt2, TextMetaInfo paramTextMetaInfo, int paramInt3)
  {
    c localc = a(paramTextMetaInfo);
    if (localc != null)
      paramSpannable.setSpan(localc, paramInt1, paramInt2, paramInt3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.style.e
 * JD-Core Version:    0.6.2
 */