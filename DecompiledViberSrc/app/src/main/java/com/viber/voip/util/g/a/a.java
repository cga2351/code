package com.viber.voip.util.g.a;

import android.text.Spannable;
import android.text.SpannableString;
import android.util.Base64;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.TextMetaInfo.a;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.ui.style.c;
import com.viber.voip.ui.style.d;
import com.viber.voip.util.da;
import com.viber.voip.util.links.f;

public class a
  implements e
{
  protected final int a;
  private final Logger b = ViberEnv.getLogger(getClass());
  private ai c;
  private f d;

  public a(int paramInt)
  {
    this.a = paramInt;
  }

  private void a(d paramd, Spannable paramSpannable, TextMetaInfo paramTextMetaInfo, int paramInt)
    throws IndexOutOfBoundsException
  {
    if ((paramTextMetaInfo.getType() == TextMetaInfo.a.MENTION) && ((paramInt & 0x8) == 0));
    c localc;
    do
    {
      return;
      localc = paramd.a(paramTextMetaInfo);
    }
    while ((localc == null) || (paramTextMetaInfo.getStartPosition() < 0) || (paramTextMetaInfo.getEndPosition() > paramSpannable.length()));
    paramSpannable.setSpan(localc, paramTextMetaInfo.getStartPosition(), paramTextMetaInfo.getEndPosition(), 33);
  }

  private f c()
  {
    if (this.d == null)
      this.d = f.b();
    return this.d;
  }

  protected final ai a()
  {
    if (this.c == null)
      this.c = new ai(ViberApplication.getApplication());
    return this.c;
  }

  public final String a(String paramString, TextMetaInfo[] paramArrayOfTextMetaInfo)
  {
    return a(paramString, paramArrayOfTextMetaInfo, this.a);
  }

  protected final String a(String paramString, TextMetaInfo[] paramArrayOfTextMetaInfo, int paramInt)
  {
    if (paramInt == 0)
      return "no_sp";
    if (da.a(paramString))
      return "no_sp";
    SpannableString localSpannableString = SpannableString.valueOf(paramString);
    if ((paramInt & 0x1) != 0)
      c().a(localSpannableString);
    while (true)
    {
      if ((paramInt & 0x2) != 0)
        a().a(localSpannableString, b());
      com.viber.voip.ui.style.e locale;
      int j;
      label83: TextMetaInfo localTextMetaInfo;
      if ((paramArrayOfTextMetaInfo != null) && (paramArrayOfTextMetaInfo.length > 0))
      {
        locale = new com.viber.voip.ui.style.e();
        int i = paramArrayOfTextMetaInfo.length;
        j = 0;
        if (j < i)
          localTextMetaInfo = paramArrayOfTextMetaInfo[j];
      }
      try
      {
        a(locale, localSpannableString, localTextMetaInfo, paramInt);
        label107: j++;
        break label83;
        if ((paramInt & 0x4) == 0)
          continue;
        f.c().a(localSpannableString);
        continue;
        byte[] arrayOfByte = da.c(localSpannableString);
        if (arrayOfByte == null)
          return "no_sp";
        return Base64.encodeToString(arrayOfByte, 19);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        break label107;
      }
    }
  }

  public void a(MessageEntity paramMessageEntity)
  {
  }

  protected int b()
  {
    return aj.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.g.a.a
 * JD-Core Version:    0.6.2
 */