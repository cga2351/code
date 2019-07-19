package com.viber.voip.messages.ui.expanel;

import android.support.v4.util.SparseArrayCompat;
import com.viber.voip.R.id;

public class f
{
  private static final SparseArrayCompat<d> a = new SparseArrayCompat();

  public static d a(int paramInt)
  {
    d locald = (d)a.get(paramInt);
    if (locald == null)
    {
      locald = b(paramInt);
      a.put(paramInt, locald);
    }
    return locald;
  }

  private static d b(int paramInt)
  {
    if (paramInt == R.id.options_menu_open_old_chat_extensions)
      return new a(paramInt);
    return new b(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.expanel.f
 * JD-Core Version:    0.6.2
 */