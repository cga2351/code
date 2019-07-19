package com.viber.voip.messages.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.permission.b;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.R.anim;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.selection.GalleryFilter;
import com.viber.voip.gallery.selection.GalleryMediaSelector;
import com.viber.voip.gallery.selection.l;
import com.viber.voip.gallery.selection.p;
import com.viber.voip.gallery.selection.q;
import com.viber.voip.gallery.selection.q.a;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.h;
import com.viber.voip.permissions.m;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.g;
import java.util.ArrayList;
import java.util.List;

public class w
  implements View.OnClickListener, d.a, l, com.viber.voip.gallery.selection.n, ao.a
{
  static final Logger a = ViberEnv.getLogger();
  private final FragmentActivity b;
  private d.g c;
  private final com.viber.voip.gallery.b.c d;
  private final g e;
  private View f;
  private RecyclerView g;
  private com.viber.voip.gallery.selection.w h;
  private View i;
  private View j;
  private Group k;
  private Group l;
  private final GalleryMediaSelector m;
  private final p n;
  private bx o;
  private final com.viber.common.permission.c p;
  private long q;
  private boolean r;
  private final b s;
  private final b t;
  private LayoutInflater u;
  private Animation v;
  private boolean w = true;

  public w(Fragment paramFragment, Bundle paramBundle, com.viber.common.permission.c paramc, g paramg, q.a parama)
  {
    FragmentActivity localFragmentActivity1 = paramFragment.getActivity();
    if (localFragmentActivity1 == null)
      throw new IllegalArgumentException("Fragment should be attached to activity");
    this.b = localFragmentActivity1;
    this.p = paramc;
    this.e = paramg;
    this.u = paramFragment.getLayoutInflater();
    FragmentActivity localFragmentActivity2 = this.b;
    Pair[] arrayOfPair1 = new Pair[1];
    arrayOfPair1[0] = m.a(7);
    this.s = new f(localFragmentActivity2, arrayOfPair1)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        w.a(w.this);
      }
    };
    FragmentActivity localFragmentActivity3 = this.b;
    Pair[] arrayOfPair2 = new Pair[1];
    arrayOfPair2[0] = m.a(99);
    this.t = new h(localFragmentActivity3, arrayOfPair2)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        w.a(w.this, true);
        w.b(w.this);
      }
    };
    GalleryMediaSelector localGalleryMediaSelector;
    if (paramBundle != null)
    {
      localGalleryMediaSelector = (GalleryMediaSelector)paramBundle.getParcelable("media_selector");
      if (localGalleryMediaSelector == null)
        break label225;
    }
    while (true)
    {
      this.m = localGalleryMediaSelector;
      this.n = new q(this.b, parama)
      {
        private void b()
        {
          if (a())
            Toast.makeText(w.d(w.this), w.d(w.this).getString(R.string.gallery_video_limit_exceeded), 0).show();
        }

        public void a(GalleryItem paramAnonymousGalleryItem)
        {
          super.a(paramAnonymousGalleryItem);
          w.a(w.this, paramAnonymousGalleryItem);
        }

        @SuppressLint({"SwitchIntDef"})
        public void a(GalleryItem paramAnonymousGalleryItem, int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default:
            super.a(paramAnonymousGalleryItem, paramAnonymousInt);
            return;
          case 1:
            b();
            return;
          case 5:
          }
          if (paramAnonymousGalleryItem.isVideo())
          {
            b();
            return;
          }
          super.a(paramAnonymousGalleryItem, paramAnonymousInt);
        }

        public boolean a()
        {
          long l = System.currentTimeMillis();
          if (l - 2000L >= w.c(w.this))
          {
            w.a(w.this, l);
            return true;
          }
          return false;
        }

        public void b(GalleryItem paramAnonymousGalleryItem)
        {
          super.b(paramAnonymousGalleryItem);
          w.a(w.this, paramAnonymousGalleryItem);
        }
      };
      Context localContext = this.b.getApplicationContext();
      this.d = new com.viber.voip.gallery.b.c(GalleryFilter.ALL_MEDIA, null, localContext, paramFragment.getLoaderManager(), this);
      this.v = AnimationUtils.loadAnimation(this.b, R.anim.menu_bottom_buttons_slide_in);
      return;
      localGalleryMediaSelector = null;
      break;
      label225: localGalleryMediaSelector = new GalleryMediaSelector();
    }
  }

  private void a(boolean paramBoolean)
  {
    if (!dj.e(this.i))
    {
      dj.b(this.i, paramBoolean);
      dj.b(this.j, paramBoolean);
      if (paramBoolean)
      {
        if (this.i != null)
          this.i.startAnimation(this.v);
        if (this.j != null)
          this.j.startAnimation(this.v);
      }
    }
  }

  private void c(GalleryItem paramGalleryItem)
  {
    if (this.h != null)
      this.h.b(paramGalleryItem);
    m();
  }

  private void g()
  {
    if (this.f == null)
      return;
    this.f.findViewById(R.id.open_photo_camera).setOnClickListener(this);
    View localView;
    if (this.j != null)
    {
      localView = this.j;
      if (b())
        break label56;
    }
    label56: for (boolean bool = true; ; bool = false)
    {
      localView.setEnabled(bool);
      this.d.i();
      return;
    }
  }

  private void k()
  {
    if (this.f == null)
      return;
    ImageView localImageView = (ImageView)this.f.findViewById(R.id.permission_icon);
    TextView localTextView = (TextView)this.f.findViewById(R.id.permission_description);
    Button localButton = (Button)this.f.findViewById(R.id.button_request_permission);
    localImageView.setImageResource(R.drawable.ic_permission_gallery);
    localTextView.setText(R.string.storage_permission_description);
    localButton.setOnClickListener(this);
    this.m.clearSelection();
    dj.b(this.l, true);
    dj.b(this.g, false);
    if (this.j != null)
      this.j.setEnabled(false);
    if ((ViberApplication.isTablet(this.b)) || (!dj.c(this.b)));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localImageView, bool);
      return;
    }
  }

  private void l()
  {
    if (this.h != null)
      this.h.notifyDataSetChanged();
    m();
  }

  private void m()
  {
    View localView;
    if (this.j != null)
    {
      localView = this.j;
      if (b())
        break label50;
    }
    label50: for (boolean bool = true; ; bool = false)
    {
      localView.setEnabled(bool);
      if (this.o != null)
        this.o.b(this.m.selectionSize());
      return;
    }
  }

  private void n()
  {
    if (this.c != null)
      this.c.k();
  }

  private void o()
  {
    if ((this.c != null) && (!this.m.isSelectionEmpty()))
      this.c.a(new ArrayList(this.m.getSelection()));
  }

  private void p()
  {
    if (this.p.a(com.viber.voip.permissions.n.c))
    {
      q();
      return;
    }
    this.p.a(this.b, 7, com.viber.voip.permissions.n.c);
  }

  private void q()
  {
    if (this.c != null)
      this.c.m();
  }

  @SuppressLint({"MissingPermission", "InflateParams"})
  public View a(View paramView)
  {
    if (paramView != null)
      return paramView;
    this.f = this.u.inflate(R.layout.menu_gallery, null);
    this.g = ((RecyclerView)this.f.findViewById(R.id.recent_media_list));
    Resources localResources = this.b.getResources();
    int i1 = localResources.getInteger(R.integer.conversation_gallery_menu_columns_count);
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(this.b, i1, 1, false);
    this.g.setLayoutManager(localGridLayoutManager);
    int i2 = localResources.getDimensionPixelSize(R.dimen.gallery_image_padding_large);
    this.g.addItemDecoration(new com.viber.voip.widget.a.d(1, i2, i1));
    int i3 = localResources.getDisplayMetrics().widthPixels / i1;
    this.h = new com.viber.voip.gallery.selection.w(this.d, this.u, R.layout.gallery_menu_image_list_item, this.e, i3, this, this);
    com.viber.voip.gallery.selection.w localw = this.h;
    boolean bool;
    if (!this.w)
    {
      bool = true;
      localw.a(bool);
      if (this.w)
        this.w = false;
      this.g.setAdapter(this.h);
      this.i = this.f.findViewById(R.id.open_gallery);
      this.i.setOnClickListener(this);
      this.j = this.f.findViewById(R.id.send_selected_media);
      this.j.setOnClickListener(this);
      this.k = ((Group)this.f.findViewById(R.id.empty_group));
      this.l = ((Group)this.f.findViewById(R.id.no_permissions_group));
      this.r = this.p.a(com.viber.voip.permissions.n.m);
      if (!this.r)
        break label307;
      g();
    }
    while (true)
    {
      return this.f;
      bool = false;
      break;
      label307: k();
    }
  }

  public void a()
  {
    if (this.m.getSelection().size() > 0)
    {
      this.m.clearSelection();
      l();
    }
  }

  public void a(Bundle paramBundle)
  {
    if (!this.m.isSelectionEmpty())
      paramBundle.putParcelable("media_selector", this.m);
  }

  public void a(GalleryItem paramGalleryItem)
  {
    this.m.toggleItemSelection(paramGalleryItem, this.b, this.n);
  }

  public void a(bx parambx)
  {
    this.o = parambx;
  }

  public void a(d.g paramg)
  {
    this.c = paramg;
  }

  public void a(List<GalleryItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.m.swapSelection(paramList);
      l();
      return;
    }
    a();
  }

  public boolean b()
  {
    return this.m.isSelectionEmpty();
  }

  public boolean b(GalleryItem paramGalleryItem)
  {
    return this.m.isSelected(paramGalleryItem);
  }

  public List<GalleryItem> c()
  {
    return this.m.getSelection();
  }

  public void d()
  {
    if (!this.p.c(this.s))
      this.p.a(this.s);
    if (!this.p.c(this.t))
      this.p.a(this.t);
    boolean bool = this.p.a(com.viber.voip.permissions.n.m);
    if (this.r != bool)
    {
      this.r = bool;
      if (bool)
        g();
    }
    else
    {
      return;
    }
    k();
  }

  public void e()
  {
    this.p.b(this.s);
    this.p.b(this.t);
  }

  public void f()
  {
    this.d.j();
  }

  public void h()
  {
    ap.a(this);
  }

  public void i()
  {
    boolean bool = true;
    if (this.h != null)
    {
      this.h.a(bool);
      if (this.h.getItemCount() <= 0)
        break label33;
    }
    while (true)
    {
      a(bool);
      return;
      label33: bool = false;
    }
  }

  public void j()
  {
    if (this.i != null)
    {
      this.i.clearAnimation();
      dj.b(this.i, false);
    }
    if (this.j != null)
    {
      this.j.clearAnimation();
      dj.b(this.j, false);
    }
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.open_gallery)
      n();
    do
    {
      return;
      if (i1 == R.id.send_selected_media)
      {
        o();
        return;
      }
      if (i1 == R.id.open_photo_camera)
      {
        p();
        return;
      }
    }
    while (i1 != R.id.button_request_permission);
    this.p.a(this.b, 99, com.viber.voip.permissions.n.m);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label43: Group localGroup2;
    if (this.h != null)
    {
      this.h.notifyDataSetChanged();
      if (this.h.getItemCount() <= 0)
        break label89;
      bool2 = bool1;
      Group localGroup1 = this.k;
      if (bool2)
        break label95;
      bool3 = bool1;
      dj.b(localGroup1, bool3);
      dj.b(this.g, bool2);
      localGroup2 = this.l;
      if (this.r)
        break label101;
    }
    while (true)
    {
      dj.b(localGroup2, bool1);
      if (paramBoolean)
        a(bool2);
      return;
      label89: bool2 = false;
      break;
      label95: bool3 = false;
      break label43;
      label101: bool1 = false;
    }
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.w
 * JD-Core Version:    0.6.2
 */