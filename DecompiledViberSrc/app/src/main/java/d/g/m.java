package d.g;

import d.d.b.h;
import org.jetbrains.annotations.NotNull;

class m extends l
{
  public static final int a(@NotNull CharSequence paramCharSequence)
  {
    h.b(paramCharSequence, "receiver$0");
    return -1 + paramCharSequence.length();
  }

  public static final int a(@NotNull CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    h.b(paramCharSequence, "receiver$0");
    if ((paramBoolean) || (!(paramCharSequence instanceof String)))
      return d.a(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
    return ((String)paramCharSequence).indexOf(paramChar, paramInt);
  }

  public static final int a(@NotNull CharSequence paramCharSequence, @NotNull char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    h.b(paramCharSequence, "receiver$0");
    h.b(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      int i1 = d.a.a.a(paramArrayOfChar);
      i = ((String)paramCharSequence).indexOf(i1, paramInt);
    }
    label138: 
    while (true)
    {
      return i;
      i = d.e.a.a(paramInt, 0);
      int j = d.a(paramCharSequence);
      if (i > j)
        break;
      char c = paramCharSequence.charAt(i);
      int k = paramArrayOfChar.length;
      int m = 0;
      label87: if (m < k)
        if (!a.a(paramArrayOfChar[m], c, paramBoolean));
      for (int n = 1; ; n = 0)
      {
        if (n != 0)
          break label138;
        if (i == j)
          break label140;
        i++;
        break;
        m++;
        break label87;
      }
    }
    label140: return -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.g.m
 * JD-Core Version:    0.6.2
 */