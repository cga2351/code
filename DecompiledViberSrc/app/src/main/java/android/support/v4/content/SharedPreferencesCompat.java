package android.support.v4.content;

import android.content.SharedPreferences.Editor;

@Deprecated
public final class SharedPreferencesCompat
{
  @Deprecated
  public static final class EditorCompat
  {
    private static EditorCompat sInstance;
    private final Helper mHelper = new Helper();

    @Deprecated
    public static EditorCompat getInstance()
    {
      if (sInstance == null)
        sInstance = new EditorCompat();
      return sInstance;
    }

    @Deprecated
    public void apply(SharedPreferences.Editor paramEditor)
    {
      this.mHelper.apply(paramEditor);
    }

    private static class Helper
    {
      public void apply(SharedPreferences.Editor paramEditor)
      {
        try
        {
          paramEditor.apply();
          return;
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          paramEditor.commit();
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.SharedPreferencesCompat
 * JD-Core Version:    0.6.2
 */