package android.support.v7.d;

import java.util.Comparator;

public class e<T>
{
  public static abstract class a<T2>
    implements d, Comparator<T2>
  {
    public abstract boolean areContentsTheSame(T2 paramT21, T2 paramT22);

    public abstract boolean areItemsTheSame(T2 paramT21, T2 paramT22);

    public abstract int compare(T2 paramT21, T2 paramT22);

    public Object getChangePayload(T2 paramT21, T2 paramT22)
    {
      return null;
    }

    public abstract void onChanged(int paramInt1, int paramInt2);

    public void onChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onChanged(paramInt1, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.d.e
 * JD-Core Version:    0.6.2
 */