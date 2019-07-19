package android.arch.persistence.room.b;

public class a
{
  public static final String[] a = new String[0];

  public static StringBuilder a()
  {
    return new StringBuilder();
  }

  public static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      paramStringBuilder.append("?");
      if (i < paramInt - 1)
        paramStringBuilder.append(",");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.b.a
 * JD-Core Version:    0.6.2
 */