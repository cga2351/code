package com.viber.voip.camrecorder;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.R.dimen;
import com.viber.voip.R.layout;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.selection.GalleryFilter;
import com.viber.voip.gallery.selection.GalleryMediaSelector;
import com.viber.voip.gallery.selection.l;
import com.viber.voip.gallery.selection.q;
import com.viber.voip.gallery.selection.q.a;
import com.viber.voip.gallery.selection.w;
import com.viber.voip.gallery.selection.w.a;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.g;

class b
  implements d.a, l, com.viber.voip.gallery.selection.n
{
  private final FragmentActivity a;
  private final RecyclerView b;
  private final LinearLayoutManager c;
  private final a d;
  private final b e;
  private final com.viber.voip.gallery.b.c f;
  private final GalleryMediaSelector g;
  private final q h;
  private boolean i;
  private boolean j;

  public b(FragmentActivity paramFragmentActivity, RecyclerView paramRecyclerView, q.a parama, final l paraml, g paramg, com.viber.common.permission.c paramc)
  {
    this.a = paramFragmentActivity;
    this.b = paramRecyclerView;
    Resources localResources = paramFragmentActivity.getResources();
    this.c = new LinearLayoutManager(paramFragmentActivity, 0, false);
    this.b.setLayoutManager(this.c);
    this.d = new a(localResources.getDimensionPixelSize(R.dimen.custom_cam_gallery_divider));
    this.b.addItemDecoration(this.d);
    this.f = new com.viber.voip.gallery.b.c(GalleryFilter.ALL_MEDIA, null, paramFragmentActivity.getApplicationContext(), paramFragmentActivity.getSupportLoaderManager(), this);
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    int k = localResources.getDimensionPixelSize(R.dimen.custom_cam_gallery_item_size);
    this.b.getLayoutParams().height = k;
    this.e = new b(this.f, localLayoutInflater, paramg, k, this, this);
    this.b.setAdapter(this.e);
    if (paramc.a(com.viber.voip.permissions.n.m))
      this.f.i();
    this.g = new GalleryMediaSelector();
    this.h = new q(paramFragmentActivity, parama)
    {
      public void a(GalleryItem paramAnonymousGalleryItem)
      {
        super.a(paramAnonymousGalleryItem);
        b.a(b.this, false);
        b.a(b.this).clearSelection();
        if (!b.b(b.this))
          paraml.a(paramAnonymousGalleryItem);
      }

      public void a(GalleryItem paramAnonymousGalleryItem, int paramAnonymousInt)
      {
        if (b.b(b.this))
          return;
        super.a(paramAnonymousGalleryItem, paramAnonymousInt);
        b.a(b.this, false);
      }
    };
  }

  private void c(int paramInt)
  {
    int k = 1;
    b localb = this.e;
    RecyclerView localRecyclerView;
    if (paramInt == 0)
    {
      int m = k;
      localb.a(m);
      dj.c(this.b, paramInt);
      if (paramInt == 0)
      {
        this.e.notifyDataSetChanged();
        int i1 = this.e.getItemCount();
        int i2 = 0;
        if (i1 > 0)
          i2 = k;
        localRecyclerView = this.b;
        if (i2 == 0)
          break label83;
      }
    }
    while (true)
    {
      localRecyclerView.setOverScrollMode(k);
      return;
      int n = 0;
      break;
      label83: k = 2;
    }
  }

  public void a()
  {
    if (this.f.d())
    {
      this.f.l();
      return;
    }
    this.f.i();
  }

  public void a(int paramInt)
  {
    this.e.a(paramInt);
    this.e.notifyDataSetChanged();
    if ((paramInt == 90) || (paramInt == 180));
    for (boolean bool = true; ; bool = false)
    {
      if (this.c.getReverseLayout() != bool)
      {
        this.d.a(bool);
        int k = this.c.findFirstCompletelyVisibleItemPosition();
        this.c.setReverseLayout(bool);
        this.c.setStackFromEnd(bool);
        this.c.scrollToPositionWithOffset(k, 0);
      }
      return;
    }
  }

  public void a(GalleryItem paramGalleryItem)
  {
    if (!this.i)
    {
      this.i = true;
      this.g.select(paramGalleryItem, this.a, this.h);
    }
  }

  public void b()
  {
    this.f.j();
  }

  public void b(int paramInt)
  {
    if (paramInt != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.j = bool;
      c(paramInt);
      return;
    }
  }

  public boolean b(GalleryItem paramGalleryItem)
  {
    return false;
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    this.e.notifyDataSetChanged();
    if (!this.j)
      if (paramd.getCount() <= 0)
        break label29;
    label29: for (int k = 0; ; k = 8)
    {
      c(k);
      return;
    }
  }

  public void onLoaderReset(d paramd)
  {
  }

  private static final class a extends com.viber.voip.widget.a.c
  {
    private boolean a;

    public a(int paramInt)
    {
      super();
    }

    public void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    protected boolean a(int paramInt, RecyclerView.State paramState)
    {
      return ((!this.a) && (paramInt > 0)) || ((this.a) && (paramInt < -1 + paramState.getItemCount()));
    }
  }

  private static final class b extends w
  {
    private int a;

    public b(com.viber.voip.gallery.b.c paramc, LayoutInflater paramLayoutInflater, g paramg, int paramInt, l paraml, com.viber.voip.gallery.selection.n paramn)
    {
      super(paramLayoutInflater, R.layout.gallery_custom_cam_image_list_item, paramg, paramInt, paraml, paramn);
    }

    public w.a a(ViewGroup paramViewGroup, int paramInt)
    {
      w.a locala = super.a(paramViewGroup, paramInt);
      locala.itemView.setRotation(this.a);
      return locala;
    }

    public void a(int paramInt)
    {
      this.a = paramInt;
    }

    public void a(w.a parama, int paramInt)
    {
      super.a(parama, paramInt);
      if (parama.itemView.getRotation() != this.a)
        parama.itemView.setRotation(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.b
 * JD-Core Version:    0.6.2
 */