package com.viber.voip.gallery.selection;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.viber.voip.R.drawable;
import com.viber.voip.R.layout;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.b.c;
import com.viber.voip.model.entity.i;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.CheckableImageView;

class g extends RecyclerView.Adapter<k>
  implements k.a
{
  private LayoutInflater a;
  private c b;
  private com.viber.voip.util.e.k c;
  private f d;
  private n e;
  private a f;

  g(c paramc, com.viber.voip.util.e.k paramk, f paramf, n paramn, a parama, LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
    this.b = paramc;
    this.c = paramk;
    this.d = paramf;
    this.e = paramn;
    this.f = parama;
  }

  public k a(ViewGroup paramViewGroup, int paramInt)
  {
    return new k(this.a.inflate(R.layout.gallery_image_list_item, paramViewGroup, false), this);
  }

  public void a()
  {
    if (this.b.d())
    {
      this.b.l();
      return;
    }
    this.b.i();
  }

  public void a(int paramInt)
  {
    i locali = this.b.e(paramInt);
    if ((locali != null) && (locali.a() != null))
      this.f.a(locali.a());
  }

  public void a(k paramk, int paramInt)
  {
    GalleryItem localGalleryItem = this.b.e(paramInt).a();
    paramk.a.setChecked(this.e.b(localGalleryItem));
    this.c.a(localGalleryItem.getOriginalUri(), paramk.a, this.d);
    if (localGalleryItem.isVideo())
    {
      paramk.a.a(R.drawable.ic_gallery_video_item_thumb, 48);
      return;
    }
    if (!localGalleryItem.isGif())
    {
      paramk.a.a(null, 48);
      return;
    }
    paramk.a.a(R.drawable.ic_gif_badge_left_bottom, 5);
  }

  public void b()
  {
    this.b.j();
  }

  public int getItemCount()
  {
    return this.b.getCount();
  }

  static abstract interface a
  {
    public abstract void a(GalleryItem paramGalleryItem);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.g
 * JD-Core Version:    0.6.2
 */