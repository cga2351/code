package android.support.v4.os;

import java.util.Locale;

abstract interface LocaleListInterface
{
  public abstract boolean equals(Object paramObject);

  public abstract Locale get(int paramInt);

  public abstract Locale getFirstMatch(String[] paramArrayOfString);

  public abstract Object getLocaleList();

  public abstract int hashCode();

  public abstract int indexOf(Locale paramLocale);

  public abstract boolean isEmpty();

  public abstract void setLocaleList(Locale[] paramArrayOfLocale);

  public abstract int size();

  public abstract String toLanguageTags();

  public abstract String toString();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.os.LocaleListInterface
 * JD-Core Version:    0.6.2
 */