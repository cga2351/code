package dagger.a;

public final class h
{
  public static <T> T a(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }

  public static <T> T a(T paramT, String paramString)
  {
    if (paramT == null)
      throw new NullPointerException(paramString);
    return paramT;
  }

  public static <T> T a(T paramT, String paramString, Object paramObject)
  {
    if (paramT == null)
    {
      if (!paramString.contains("%s"))
        throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
      if (paramString.indexOf("%s") != paramString.lastIndexOf("%s"))
        throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
      if ((paramObject instanceof Class));
      for (String str = ((Class)paramObject).getCanonicalName(); ; str = String.valueOf(paramObject))
        throw new NullPointerException(paramString.replace("%s", str));
    }
    return paramT;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.a.h
 * JD-Core Version:    0.6.2
 */