package android.arch.lifecycle;

public class t
{
  private final a a;
  private final u b;

  public t(u paramu, a parama)
  {
    this.a = parama;
    this.b = paramu;
  }

  public <T extends s> T a(Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null)
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    return a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }

  public <T extends s> T a(String paramString, Class<T> paramClass)
  {
    s locals1 = this.b.a(paramString);
    if (paramClass.isInstance(locals1))
      return locals1;
    if (locals1 != null);
    s locals2 = this.a.create(paramClass);
    this.b.a(paramString, locals2);
    return locals2;
  }

  public static abstract interface a
  {
    public abstract <T extends s> T create(Class<T> paramClass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.t
 * JD-Core Version:    0.6.2
 */