package dagger.a;

import java.util.LinkedHashMap;

public final class a
{
  static <K, V> LinkedHashMap<K, V> a(int paramInt)
  {
    return new LinkedHashMap(b(paramInt));
  }

  private static int b(int paramInt)
  {
    if (paramInt < 3)
      return paramInt + 1;
    if (paramInt < 1073741824)
      return (int)(1.0F + paramInt / 0.75F);
    return 2147483647;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.a.a
 * JD-Core Version:    0.6.2
 */