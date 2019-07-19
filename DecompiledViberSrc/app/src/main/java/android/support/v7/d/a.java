package android.support.v7.d;

import android.support.v7.widget.RecyclerView.Adapter;

public final class a
  implements d
{
  private final RecyclerView.Adapter a;

  public a(RecyclerView.Adapter paramAdapter)
  {
    this.a = paramAdapter;
  }

  public void onChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }

  public void onInserted(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(paramInt1, paramInt2);
  }

  public void onMoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemMoved(paramInt1, paramInt2);
  }

  public void onRemoved(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.d.a
 * JD-Core Version:    0.6.2
 */