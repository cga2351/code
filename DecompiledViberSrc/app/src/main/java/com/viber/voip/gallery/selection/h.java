package com.viber.voip.gallery.selection;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.viber.common.permission.b;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.j;
import com.viber.voip.util.e.j.a;
import dagger.android.support.a;
import javax.inject.Inject;

public class h extends aq
  implements d.a, g.a, n, o
{

  @Inject
  com.viber.voip.util.e.g a;

  @Inject
  com.viber.common.permission.c b;
  private f c;
  private g d;
  private m e;
  private RecyclerView f;
  private boolean g;
  private boolean h;
  private String i;
  private String j;
  private b k = new b()
  {
    public int[] acceptOnly()
    {
      return new int[] { 112 };
    }

    public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
    {
      if ((DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) || (DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)))
      {
        if (paramAnonymousInt2 != -1)
          h.this.getActivity().finish();
      }
      else
        return;
      h.a(h.this, true);
    }

    public void onPermissionsDenied(int paramAnonymousInt, boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2, Object paramAnonymousObject)
    {
    }

    public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
    {
      h.a(h.this).a();
    }
  };

  public void a()
  {
    if (this.d != null)
      this.d.notifyDataSetChanged();
  }

  public void a(GalleryItem paramGalleryItem)
  {
    if (this.c != null)
      this.c.a(paramGalleryItem, this);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      a();
  }

  public void b()
  {
    this.g = true;
    if (this.e != null)
      this.e.a(true);
  }

  public boolean b(GalleryItem paramGalleryItem)
  {
    return (this.c != null) && (this.c.b(paramGalleryItem));
  }

  public void c()
  {
    this.g = false;
    if (this.e != null)
      this.e.a(false);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Context localContext = requireContext();
    Bundle localBundle = getArguments();
    if ((localBundle == null) || (!localBundle.containsKey("bucket_id")))
    {
      requireFragmentManager().popBackStack();
      return;
    }
    this.j = localBundle.getString("bucket_id");
    this.i = localBundle.getString("bucket_name");
    GalleryFilter localGalleryFilter1 = (GalleryFilter)localBundle.getParcelable("selection_filter");
    if (localGalleryFilter1 == null);
    for (GalleryFilter localGalleryFilter2 = GalleryFilter.IMAGE; ; localGalleryFilter2 = localGalleryFilter1)
    {
      com.viber.voip.gallery.b.c localc = new com.viber.voip.gallery.b.c(localGalleryFilter2, this.j, localContext, getLoaderManager(), this);
      Resources localResources = localContext.getResources();
      int m = localContext.getResources().getInteger(R.integer.gallery_images_per_row);
      this.e = new m(m, localResources.getDimensionPixelSize(R.dimen.gallery_image_outer_margin), localResources.getDimensionPixelSize(R.dimen.gallery_image_outer_top_margin), localResources.getDimensionPixelSize(R.dimen.gallery_image_padding), localResources.getDimensionPixelSize(R.dimen.gallery_selectable_area_height));
      this.e.a(this.g);
      this.f.addItemDecoration(this.e);
      GridLayoutManager localGridLayoutManager = new GridLayoutManager(getActivity(), m);
      this.f.setLayoutManager(localGridLayoutManager);
      int n = j.a(localContext, j.a.a) / m;
      com.viber.voip.util.e.f localf = new f.a().a(Integer.valueOf(R.drawable.bg_loading_gallery_image)).a(n, n).e(true).c();
      this.d = new g(localc, this.a, localf, this, this, getLayoutInflater());
      this.f.setAdapter(this.d);
      if (!this.b.a(com.viber.voip.permissions.n.m))
        break;
      this.d.a();
      return;
    }
  }

  public void onAttach(Context paramContext)
  {
    a.a(this);
    super.onAttach(paramContext);
    if (!(paramContext instanceof f))
      throw new RuntimeException("parent must implement Listener and GalleryController of GalleryImagesFragment");
    this.c = ((f)paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_gallery_images, paramViewGroup, false);
    this.f = ((RecyclerView)localView.findViewById(R.id.recycler_view));
    return localView;
  }

  public void onDestroyView()
  {
    dj.a(this.f);
    super.onDestroyView();
    this.d.b();
  }

  public void onDetach()
  {
    super.onDetach();
    this.c = null;
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    this.d.notifyDataSetChanged();
    if (this.d.getItemCount() == 0)
    {
      Toast.makeText(getActivity(), R.string.gallery_empty_album_message, 0).show();
      av.a(av.e.a).post(new i(this));
    }
  }

  public void onLoaderReset(d paramd)
  {
  }

  public void onResume()
  {
    super.onResume();
    if (this.c != null)
      this.c.b(this.j, this.i);
  }

  public void onStart()
  {
    super.onStart();
    this.b.a(this.k);
    if (this.h)
    {
      if (!this.b.a(com.viber.voip.permissions.n.m))
        break label48;
      this.d.a();
    }
    while (true)
    {
      this.h = false;
      return;
      label48: getActivity().finish();
    }
  }

  public void onStop()
  {
    super.onStop();
    this.b.b(this.k);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.h
 * JD-Core Version:    0.6.2
 */