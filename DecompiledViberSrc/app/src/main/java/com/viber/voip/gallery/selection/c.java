package com.viber.voip.gallery.selection;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.g;
import com.viber.voip.util.e.j;
import com.viber.voip.util.e.j.a;
import javax.inject.Inject;

public class c extends aq
  implements d.a, b.a
{

  @Inject
  g a;

  @Inject
  com.viber.common.permission.c b;
  private f c;
  private com.viber.voip.gallery.b.a d;
  private b e;
  private m f;
  private RecyclerView g;
  private View h;
  private boolean i;
  private boolean j;
  private com.viber.common.permission.b k = new com.viber.common.permission.b()
  {
    public int[] acceptOnly()
    {
      return new int[] { 112 };
    }

    public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
    {
      if (((DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) || (DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString))) && (paramAnonymousInt2 != -1))
        c.this.getActivity().finish();
    }

    public void onPermissionsDenied(int paramAnonymousInt, boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2, Object paramAnonymousObject)
    {
    }

    public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
    {
      c.a(c.this).i();
    }
  };

  public static c a(GalleryFilter paramGalleryFilter)
  {
    c localc = new c();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("album_filter", paramGalleryFilter);
    localc.setArguments(localBundle);
    return localc;
  }

  public void a()
  {
    this.i = true;
    if (this.f != null)
      this.f.a(true);
  }

  public void a(com.viber.voip.model.entity.a parama)
  {
    if ((parama != null) && (this.c != null))
      this.c.a(parama.a(), parama.b());
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1);
    for (boolean bool = true; ; bool = false)
    {
      this.j = bool;
      if (this.h != null)
      {
        if ((!paramBoolean2) || (!ViewCompat.isLaidOut(this.h)))
          break label60;
        if (!this.j)
          break;
        com.viber.voip.ui.b.a.a(this.h);
      }
      return;
    }
    com.viber.voip.ui.b.a.b(this.h);
    return;
    label60: View localView = this.h;
    int m = 0;
    if (paramBoolean1)
      m = 8;
    localView.setVisibility(m);
  }

  public void b()
  {
    this.i = false;
    if (this.f != null)
      this.f.a(false);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Context localContext = requireContext();
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("album_filter")));
    for (GalleryFilter localGalleryFilter = (GalleryFilter)localBundle.getParcelable("album_filter"); ; localGalleryFilter = GalleryFilter.IMAGE)
    {
      this.d = new com.viber.voip.gallery.b.a(localGalleryFilter, localContext, getLoaderManager(), this);
      Resources localResources = localContext.getResources();
      int m = localContext.getResources().getInteger(R.integer.gallery_albums_per_row);
      this.f = new m(m, localResources.getDimensionPixelSize(R.dimen.gallery_album_outer_margin), localResources.getDimensionPixelSize(R.dimen.gallery_album_outer_top_margin), localResources.getDimensionPixelSize(R.dimen.gallery_album_padding), localResources.getDimensionPixelSize(R.dimen.gallery_selectable_area_height));
      this.f.a(this.i);
      this.g.addItemDecoration(this.f);
      GridLayoutManager localGridLayoutManager = new GridLayoutManager(getActivity(), m);
      this.g.setLayoutManager(localGridLayoutManager);
      int n = j.a(localContext, j.a.a) / m;
      com.viber.voip.util.e.f localf = new f.a().a(Integer.valueOf(R.drawable.bg_loading_gallery_image)).a(n, n).e(true).c();
      this.e = new b(this.d, this.a, localf, this, getLayoutInflater());
      this.g.setAdapter(this.e);
      if (this.b.a(n.m))
        this.d.i();
      return;
    }
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    if (!(paramContext instanceof f))
      throw new RuntimeException("parent must implement GalleryController");
    this.c = ((f)paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_gallery_albums, paramViewGroup, false);
    this.g = ((RecyclerView)localView.findViewById(R.id.recycler_view));
    this.h = localView.findViewById(R.id.overlay);
    if (this.j)
      this.h.setVisibility(0);
    if (this.c != null)
      this.c.b();
    return localView;
  }

  public void onDestroyView()
  {
    dj.a(this.g);
    if (this.d != null)
    {
      this.d.j();
      this.d = null;
    }
    super.onDestroyView();
  }

  public void onDetach()
  {
    super.onDetach();
    this.c = null;
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    this.e.notifyDataSetChanged();
  }

  public void onLoaderReset(d paramd)
  {
  }

  public void onStart()
  {
    super.onStart();
    this.b.a(this.k);
  }

  public void onStop()
  {
    super.onStop();
    this.b.b(this.k);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.selection.c
 * JD-Core Version:    0.6.2
 */