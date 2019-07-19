package com.viber.voip.messages.extensions.ui;

import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import java.util.Collections;
import java.util.List;

public final class c extends RecyclerView.Adapter<d>
{
  public static final Object a = new Object();
  private final LayoutInflater b;
  private final a c;
  private List<ChatExtensionLoaderEntity> d;
  private String e;
  private SparseIntArray f = new SparseIntArray();

  public c(a parama, LayoutInflater paramLayoutInflater)
  {
    this.b = paramLayoutInflater;
    this.d = Collections.emptyList();
    this.c = parama;
  }

  private void a(d paramd, int paramInt, Object paramObject)
  {
    ChatExtensionLoaderEntity localChatExtensionLoaderEntity = a(paramInt);
    boolean bool = localChatExtensionLoaderEntity.getPublicAccountId().equals(this.e);
    if (a == paramObject)
      paramd.a(bool);
    while (true)
    {
      if (paramObject == null)
        b(paramd, paramInt);
      return;
      paramd.a(localChatExtensionLoaderEntity, bool);
    }
  }

  private void b(d paramd, int paramInt)
  {
    long l = this.f.get(paramInt, -1);
    if (l >= 0L)
    {
      this.f.delete(paramInt);
      paramd.a(l);
    }
  }

  private void c(d paramd)
  {
    paramd.a();
  }

  public ChatExtensionLoaderEntity a(int paramInt)
  {
    return (ChatExtensionLoaderEntity)this.d.get(paramInt);
  }

  public d a(ViewGroup paramViewGroup, int paramInt)
  {
    return new d(this.b.inflate(R.layout.keyboard_extension_filter_item_layout, paramViewGroup, false), this.c);
  }

  public String a()
  {
    return this.e;
  }

  public void a(SparseIntArray paramSparseIntArray)
  {
    this.f = paramSparseIntArray;
  }

  public void a(d paramd)
  {
    c(paramd);
    super.onViewDetachedFromWindow(paramd);
  }

  public void a(d paramd, int paramInt)
  {
    a(paramd, paramInt, null);
  }

  public void a(d paramd, int paramInt, List<Object> paramList)
  {
    if ((!paramList.isEmpty()) && (a == paramList.get(0)))
    {
      a(paramd, paramInt, a);
      return;
    }
    super.onBindViewHolder(paramd, paramInt, paramList);
  }

  public void a(String paramString)
  {
    this.e = paramString;
  }

  public void a(List<ChatExtensionLoaderEntity> paramList)
  {
    this.d = paramList;
  }

  public int b(String paramString)
  {
    for (int i = 0; i < getItemCount(); i++)
      if (a(i).getPublicAccountId().equals(paramString))
        return i;
    int j = getItemCount();
    int k = 0;
    if (j > 0);
    while (true)
    {
      return k;
      k = -1;
    }
  }

  public boolean b(d paramd)
  {
    c(paramd);
    return true;
  }

  public int getItemCount()
  {
    return this.d.size();
  }

  public static abstract interface a
  {
    public abstract void a(ChatExtensionLoaderEntity paramChatExtensionLoaderEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.c
 * JD-Core Version:    0.6.2
 */