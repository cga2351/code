package com.viber.voip.gallery.selection;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberEnv;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.b.c;
import com.viber.voip.messages.ui.al;
import com.viber.voip.messages.ui.al.a;
import com.viber.voip.model.entity.i;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.g;
import com.viber.voip.util.e.h.a;
import com.viber.voip.widget.DurationCheckableImageView;

public class w extends al<GalleryItem, a>
{
  private static final Logger a = ViberEnv.getLogger();
  private final c b;
  private final LayoutInflater c;
  private final int d;
  private final g e;
  private final f f;
  private final l g;
  private final n h;
  private boolean i = true;
  private Drawable j;

  public w(c paramc, LayoutInflater paramLayoutInflater, int paramInt1, g paramg, int paramInt2, l paraml, n paramn)
  {
    this.b = paramc;
    this.c = paramLayoutInflater;
    this.d = paramInt1;
    this.e = paramg;
    this.f = new f.a().a(Integer.valueOf(R.drawable.bg_loading_gallery_image)).a(paramInt2, paramInt2).e(true).c();
    this.g = paraml;
    this.h = paramn;
  }

  private Drawable a()
  {
    if (this.j == null)
      this.j = ContextCompat.getDrawable(this.c.getContext(), R.drawable.ic_gif_badge_left_top);
    return this.j;
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(this.c.inflate(this.d, paramViewGroup, false));
  }

  public void a(a parama, int paramInt)
  {
    super.onBindViewHolder(parama, paramInt);
    GalleryItem localGalleryItem = parama.a();
    if (localGalleryItem != null)
    {
      parama.itemView.setVisibility(0);
      if (localGalleryItem.isVideo())
        parama.a.setDuration(localGalleryItem.getDuration());
      while (true)
      {
        parama.a.setChecked(this.h.b(localGalleryItem));
        if (!this.i)
          break;
        if (!localGalleryItem.getOriginalUri().equals(parama.b))
          this.e.a(localGalleryItem.getOriginalUri(), parama.a, this.f, parama);
        return;
        if (localGalleryItem.isGif())
          parama.a.a(a(), 9);
        else
          parama.a.a(null, 48);
      }
      parama.a.setBackgroundResource(R.drawable.bg_loading_gallery_image);
      return;
    }
    parama.itemView.setVisibility(4);
    parama.a.setChecked(false);
  }

  public void a(boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      this.i = paramBoolean;
      notifyDataSetChanged();
    }
  }

  protected boolean a(GalleryItem paramGalleryItem1, GalleryItem paramGalleryItem2)
  {
    return paramGalleryItem1.getOriginalUri().equals(paramGalleryItem2.getOriginalUri());
  }

  protected GalleryItem b(int paramInt)
  {
    i locali = this.b.e(paramInt);
    if (locali != null)
      return locali.a();
    return null;
  }

  void c(int paramInt)
  {
    GalleryItem localGalleryItem = b(paramInt);
    if (localGalleryItem != null)
      this.g.a(localGalleryItem);
  }

  public int getItemCount()
  {
    return this.b.getCount();
  }

  public class a extends RecyclerView.ViewHolder
    implements View.OnClickListener, al.a<GalleryItem>, h.a
  {
    final DurationCheckableImageView a;
    Uri b;
    private GalleryItem d;

    public a(View arg2)
    {
      super();
      this.a = ((DurationCheckableImageView)localView);
      this.a.setOnClickListener(this);
      this.a.setDrawSelectorAndCheckCombination(false);
    }

    public GalleryItem a()
    {
      return this.d;
    }

    public void a(GalleryItem paramGalleryItem)
    {
      this.d = paramGalleryItem;
    }

    public void onClick(View paramView)
    {
      w.this.c(getAdapterPosition());
    }

    public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
    {
      if (paramBitmap != null)
        this.b = paramUri;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.w
 * JD-Core Version:    0.6.2
 */