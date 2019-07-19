package com.viber.voip.messages.extensions.ui.details;

import com.viber.voip.messages.MessageEditText.a;
import javax.annotation.Nullable;

public class i
{

  @Nullable
  public final String a;

  @Nullable
  public final String b;
  public final MessageEditText.a c;
  public final boolean d;

  i(@Nullable String paramString1, @Nullable String paramString2, MessageEditText.a parama, boolean paramBoolean)
  {
    this.c = parama;
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramBoolean;
  }

  public String toString()
  {
    return "SearchConfig{searchQuery='" + this.a + '\'' + ", searchHint='" + this.b + '\'' + ", imeOptions=" + this.c + ", hasSearchIcon=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.details.i
 * JD-Core Version:    0.6.2
 */