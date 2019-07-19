package android.support.v7.recyclerview.a;

import android.support.v7.d.c.c;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class c<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>
{
  private final b<T> a;

  protected c(c.c<T> paramc)
  {
    this.a = new b(new android.support.v7.d.a(this), new a.a(paramc).a());
  }

  protected c(a<T> parama)
  {
    this.a = new b(new android.support.v7.d.a(this), parama);
  }

  protected T a(int paramInt)
  {
    return this.a.a().get(paramInt);
  }

  public void a(List<T> paramList)
  {
    this.a.a(paramList);
  }

  public int getItemCount()
  {
    return this.a.a().size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.recyclerview.a.c
 * JD-Core Version:    0.6.2
 */