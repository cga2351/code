package com.viber.voip.gallery.selection;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.viber.voip.R.dimen;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.g;
import com.viber.voip.util.e.k;
import java.util.ArrayList;

public class s extends RecyclerView.Adapter<a>
{
  private final ArrayList<GalleryItem> a;
  private final k b;
  private final f c;
  private final int d;
  private final int e;
  private final int f;

  public s(Context paramContext, g paramg)
  {
    this(paramContext, paramg, null);
  }

  public s(Context paramContext, g paramg, ArrayList<GalleryItem> paramArrayList)
  {
    if (paramArrayList != null);
    for (this.a = paramArrayList; ; this.a = new ArrayList())
    {
      Resources localResources = paramContext.getResources();
      this.d = localResources.getDimensionPixelSize(R.dimen.gallery_selectable_area_thumb_size);
      this.e = localResources.getDimensionPixelSize(R.dimen.gallery_selectable_area_thumb_padding);
      this.f = ((localResources.getDimensionPixelSize(R.dimen.gallery_selectable_area_height) - this.d) / 2);
      this.b = paramg;
      this.c = new f.a().a(this.d, this.d).c();
      return;
    }
  }

  private boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.a.size());
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    ImageView localImageView = new ImageView(paramViewGroup.getContext());
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(this.d, this.d);
    localLayoutParams.leftMargin = this.e;
    localLayoutParams.topMargin = this.f;
    localLayoutParams.rightMargin = this.e;
    localLayoutParams.bottomMargin = 0;
    localImageView.setLayoutParams(localLayoutParams);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new a(localImageView);
  }

  public void a()
  {
    this.a.clear();
    notifyDataSetChanged();
  }

  public void a(GalleryItem paramGalleryItem)
  {
    int i = this.a.indexOf(paramGalleryItem);
    if (a(i))
    {
      this.a.remove(paramGalleryItem);
      notifyItemRemoved(i);
    }
  }

  public void a(a parama, int paramInt)
  {
    GalleryItem localGalleryItem = (GalleryItem)this.a.get(paramInt);
    parama.a(localGalleryItem);
    this.b.a(localGalleryItem.getOriginalUri(), (ImageView)parama.itemView, this.c);
  }

  public void b(GalleryItem paramGalleryItem)
  {
    this.a.add(paramGalleryItem);
    notifyItemInserted(1 + getItemCount());
  }

  public int getItemCount()
  {
    return this.a.size();
  }

  public static class a extends RecyclerView.ViewHolder
  {
    private GalleryItem a;

    public a(View paramView)
    {
      super();
    }

    public GalleryItem a()
    {
      return this.a;
    }

    public void a(GalleryItem paramGalleryItem)
    {
      this.a = paramGalleryItem;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.s
 * JD-Core Version:    0.6.2
 */