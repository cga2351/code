package com.viber.voip.util;

import d.d.a.b;
import d.d.b.i;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aa
{

  @NotNull
  private static final b<String, Boolean> a = (b)a.a;

  @NotNull
  public static final b<String, Boolean> a()
  {
    return a;
  }

  static final class a extends i
    implements b<String, Boolean>
  {
    public static final a a = new a();

    a()
    {
      super();
    }

    public final boolean a(@Nullable String paramString)
    {
      return (!da.a((CharSequence)paramString)) && (ce.k.matcher((CharSequence)paramString).find());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.aa
 * JD-Core Version:    0.6.2
 */