package com.viber.voip.engagement.carousel;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.SnapHelper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.engagement.data.BaseMediaViewData;
import com.viber.voip.engagement.data.GifsMediaViewData;
import com.viber.voip.engagement.data.StickersMediaViewData;
import com.viber.voip.ui.aq;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bp;
import com.viber.voip.util.cj;
import com.viber.voip.util.cl;
import com.viber.voip.util.dj;
import com.viber.voip.util.dj.a;
import com.viber.voip.util.e.j;
import com.viber.voip.widget.PagingIndicator;
import com.viber.voip.widget.ToggleImageView;
import com.viber.voip.widget.t;

public class f extends aq
  implements View.OnClickListener, CarouselLinearLayoutManager.a, CarouselLinearLayoutManager.b, e, h
{
  private static final Logger a = ViberEnv.getLogger();
  private static final e b = (e)cl.b(e.class);
  private Context c;
  private RecyclerView d;
  private CarouselLinearLayoutManager e;
  private SnapHelper f;
  private PagingIndicator g;
  private int h;
  private int i;
  private TextView j;
  private ToggleImageView k;
  private ToggleImageView l;
  private View[] m;
  private View[] n;
  private Presenter o;
  private com.viber.voip.engagement.carousel.a.a<?, ?> p;
  private e q = b;
  private com.viber.voip.stickers.f r;
  private com.viber.voip.stickers.d.a s;
  private com.viber.voip.stickers.d.b t;
  private Handler u;
  private a v;
  private final View.OnTouchListener w = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      return true;
    }
  };

  public static f a(int paramInt, String paramString, boolean paramBoolean)
  {
    f localf = new f();
    Bundle localBundle = new Bundle();
    localBundle.putInt("default_media_type", paramInt);
    localBundle.putString("campaign", paramString);
    localBundle.putBoolean("is_marketing_adaptions", paramBoolean);
    localf.setArguments(localBundle);
    return localf;
  }

  private void a(View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    int i1 = 0;
    int i2 = paramArrayOfView1.length;
    for (int i3 = 0; i3 < i2; i3++)
      dj.c(paramArrayOfView1[i3], 0);
    int i4 = paramArrayOfView2.length;
    while (i1 < i4)
    {
      dj.c(paramArrayOfView2[i1], 4);
      i1++;
    }
  }

  private void d(int paramInt)
  {
    if (this.p != null)
    {
      if (this.d.isComputingLayout())
        this.d.post(new g(this, paramInt));
    }
    else
      return;
    this.p.a(paramInt);
  }

  public com.viber.voip.engagement.data.d a()
  {
    return this.o.d();
  }

  public void a(int paramInt)
  {
    this.g.setCurrentPage(paramInt);
    d(paramInt);
    this.o.a(paramInt);
  }

  void a(a.a parama)
  {
    this.v.b();
    this.v.a(parama);
    this.v.a();
  }

  public void a(GifsMediaViewData paramGifsMediaViewData, i parami, int paramInt, boolean paramBoolean)
  {
    this.s.b();
    new b(null).a(paramGifsMediaViewData, parami.a(0), paramInt, paramBoolean);
  }

  public void a(StickersMediaViewData paramStickersMediaViewData, i parami, int paramInt, boolean paramBoolean)
  {
    this.s.a();
    new d(null).a(paramStickersMediaViewData, parami.a(1), paramInt, paramBoolean);
  }

  public void a(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof AppCompatActivity))
    {
      android.support.v7.app.a locala = ((AppCompatActivity)localFragmentActivity).getSupportActionBar();
      if (locala != null)
        locala.a(paramString);
    }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    dj.b(this.k, paramBoolean1);
    dj.b(this.l, paramBoolean2);
  }

  public void b()
  {
    this.e.a(null);
    this.f.attachToRecyclerView(this.d);
  }

  public void b(int paramInt)
  {
    int i1 = 1;
    ToggleImageView localToggleImageView1 = this.k;
    ToggleImageView localToggleImageView2;
    if (paramInt == i1)
    {
      int i2 = i1;
      localToggleImageView1.setChecked(i2);
      localToggleImageView2 = this.l;
      if (paramInt != 0)
        break label44;
    }
    while (true)
    {
      localToggleImageView2.setChecked(i1);
      return;
      int i3 = 0;
      break;
      label44: i1 = 0;
    }
  }

  public void c()
  {
    a(this.m, this.n);
  }

  public void d()
  {
    this.q.b();
  }

  public void e()
  {
    if (this.p != null)
      this.p.e();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Presenter localPresenter = this.o;
    if (paramBundle != null);
    for (Parcelable localParcelable = paramBundle.getParcelable("presenter_state"); ; localParcelable = null)
    {
      localPresenter.a(this, localParcelable);
      this.o.c();
      this.o.b();
      return;
    }
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.q = ((e)paramContext);
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.gif_button)
      this.o.b(0);
    while (i1 != R.id.stickers_button)
      return;
    this.o.b(1);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    Handler localHandler = av.e.f.a();
    this.u = av.e.a.a();
    String str = localBundle.getString("campaign", "");
    boolean bool = localBundle.getBoolean("is_marketing_adaptions", false);
    SparseArray localSparseArray = new SparseArray(2);
    localSparseArray.put(0, getString(R.string.select_a_gif));
    localSparseArray.put(1, getString(R.string.select_a_sticker));
    Object localObject1 = new d(getString(R.string.say_hi), localSparseArray);
    a locala = new a(null);
    Object localObject2;
    Object localObject3;
    if (!bool)
    {
      localObject2 = new com.viber.voip.engagement.c.d();
      localObject3 = new com.viber.voip.engagement.carousel.b.c(locala);
    }
    while (true)
    {
      com.viber.voip.engagement.c.c localc = new com.viber.voip.engagement.c.c((com.viber.voip.engagement.c.a)localObject2, localHandler, this.u);
      com.viber.voip.stickers.i locali = com.viber.voip.stickers.i.a();
      this.r = locali.e();
      this.s = new com.viber.voip.stickers.d.a(locali, localHandler, this.u);
      this.t = new com.viber.voip.stickers.d.b(getContext());
      this.o = new Presenter(localBundle.getInt("default_media_type", 1), localc, new b(), cj.a(getContext().getApplicationContext()), (i)localObject1, (com.viber.voip.engagement.carousel.b.a)localObject3);
      return;
      com.viber.voip.engagement.c.b localb = new com.viber.voip.engagement.c.b(ViberApplication.getInstance().getUserManager().getRegistrationValues(), bp.a(getResources()), str, com.viber.voip.flatbuffers.b.e.a().a());
      c localc1 = new c(getString(R.string.loading), (i)localObject1);
      localObject3 = new com.viber.voip.engagement.carousel.b.b(getContext(), locala);
      localObject1 = localc1;
      localObject2 = localb;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_say_hi_select_media, paramViewGroup, false);
  }

  public void onDestroyView()
  {
    this.o.e();
    this.s.b();
    this.v.b();
    super.onDestroyView();
  }

  public void onDetach()
  {
    this.q = b;
    super.onDetach();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("presenter_state", this.o.a());
  }

  public void onStart()
  {
    super.onStart();
    if (this.p != null)
      this.p.d();
  }

  public void onStop()
  {
    if (this.p != null)
      this.p.c();
    super.onStop();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.c = getContext();
    this.d = ((RecyclerView)paramView.findViewById(R.id.recycler_view));
    this.d.addOnScrollListener(new RecyclerView.OnScrollListener()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        if (f.a(f.this) != null)
        {
          if (paramAnonymousInt != 0)
            break label25;
          f.a(f.this).b();
        }
        label25: 
        while (paramAnonymousInt != 1)
          return;
        f.a(f.this).a();
      }
    });
    this.f = new t();
    Resources localResources = getResources();
    this.h = localResources.getDimensionPixelSize(R.dimen.engagement_carousel_item_height);
    this.i = localResources.getDimensionPixelSize(R.dimen.engagement_carousel_item_max_width);
    this.e = new CarouselLinearLayoutManager(getContext(), localResources.getDimensionPixelOffset(R.dimen.engagement_carousel_space_between_items));
    this.e.a(this);
    this.e.a(this);
    this.d.setLayoutManager(this.e);
    this.d.setHasFixedSize(true);
    this.d.setItemAnimator(null);
    this.d.setClipToPadding(false);
    this.j = ((TextView)paramView.findViewById(R.id.media_select_title));
    this.g = ((PagingIndicator)paramView.findViewById(R.id.paging_indicator));
    this.k = ((ToggleImageView)paramView.findViewById(R.id.stickers_button));
    this.k.setOnClickListener(this);
    this.l = ((ToggleImageView)paramView.findViewById(R.id.gif_button));
    this.l.setOnClickListener(this);
    dj.a(this.k, j.a(20.0F));
    dj.a(this.l, j.a(20.0F));
    View[] arrayOfView1 = new View[1];
    arrayOfView1[0] = paramView.findViewById(R.id.media_loading_progress);
    this.m = arrayOfView1;
    View[] arrayOfView2 = new View[3];
    arrayOfView2[0] = this.d;
    arrayOfView2[1] = this.g;
    arrayOfView2[2] = this.j;
    this.n = arrayOfView2;
    this.v = new a(this.e);
  }

  private class a
    implements com.viber.voip.engagement.carousel.b.a.a
  {
    private a()
    {
    }

    public void a(int paramInt)
    {
      f.n(f.this).c(paramInt);
    }
  }

  private class b extends f.c<GifsMediaViewData>
  {
    private b()
    {
      super(null);
    }

    protected float a()
    {
      return 0.54F;
    }

    protected com.viber.voip.engagement.carousel.a.a<?, ?> a(Context paramContext, GifsMediaViewData paramGifsMediaViewData, int paramInt1, int paramInt2, LayoutInflater paramLayoutInflater)
    {
      return new com.viber.voip.engagement.carousel.a.c(paramContext, paramGifsMediaViewData.getItems(), paramInt1, paramInt2, paramLayoutInflater);
    }

    protected void a(com.viber.voip.engagement.carousel.a.a<?, ?> parama, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString, int paramInt4)
    {
      super.a(parama, paramInt1, paramInt2, paramInt3, paramBoolean, paramString, paramInt4);
    }

    protected float b()
    {
      return 0.6F;
    }
  }

  private abstract class c<T extends BaseMediaViewData<?>>
  {
    private c()
    {
    }

    private void a(com.viber.voip.engagement.carousel.a.a<?, ?> parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      f.a(f.this, parama);
      f.h(f.this).setCount(paramInt1);
      f.h(f.this).setCurrentPage(paramInt2);
      f.d(f.this).setAdapter(f.a(f.this));
      f.j(f.this).a(a());
      f.j(f.this).b(b());
      f.j(f.this).a(paramInt3, paramInt4);
      f.j(f.this).scrollToPosition(paramInt2);
    }

    protected abstract float a();

    protected abstract com.viber.voip.engagement.carousel.a.a<?, ?> a(Context paramContext, T paramT, int paramInt1, int paramInt2, LayoutInflater paramLayoutInflater);

    protected void a(final com.viber.voip.engagement.carousel.a.a<?, ?> parama, final int paramInt1, final int paramInt2, final int paramInt3, boolean paramBoolean, String paramString, final int paramInt4)
    {
      f.e(f.this).setText(paramString);
      f.a(f.this, f.f(f.this), f.g(f.this));
      PagingIndicator localPagingIndicator = f.h(f.this);
      if (paramInt1 > 1);
      for (int i = 0; ; i = 4)
      {
        dj.c(localPagingIndicator, i);
        if (!paramBoolean)
          break;
        f.this.a(new a.a()
        {
          public void a()
          {
            f.d(f.this).setOnTouchListener(f.i(f.this));
            if (f.a(f.this) != null)
              f.a(f.this).a(false);
          }

          public void b()
          {
            if (f.a(f.this) != null)
              f.a(f.this).b(false);
            f.c.a(f.c.this, parama, paramInt1, paramInt2, paramInt3, paramInt4);
            f.a(f.this).a(true);
          }

          public void c()
          {
            f.d(f.this).setOnTouchListener(null);
            if (f.a(f.this) != null)
              f.a(f.this).b(true);
          }
        });
        return;
      }
      a(parama, paramInt1, paramInt2, paramInt3, paramInt4);
    }

    void a(T paramT, final String paramString, final int paramInt, final boolean paramBoolean)
    {
      final int i = Math.min(paramT.getItemWidth(f.b(f.this)), f.c(f.this));
      final com.viber.voip.engagement.carousel.a.a locala = a(f.this.getContext(), paramT, i, f.b(f.this), f.this.getLayoutInflater());
      int j = f.d(f.this).getWidth();
      final int k = paramT.getItemsCount();
      if (j > 0)
      {
        a(locala, k, paramInt, i, paramBoolean, paramString, j);
        return;
      }
      dj.a(f.d(f.this), new dj.a()
      {
        public boolean onGlobalLayout()
        {
          int i = f.d(f.this).getWidth();
          if (i > 0)
          {
            f.c.this.a(locala, k, paramInt, i, paramBoolean, paramString, i);
            return true;
          }
          return false;
        }
      });
    }

    protected abstract float b();
  }

  private class d extends f.c<StickersMediaViewData>
  {
    private d()
    {
      super(null);
    }

    protected float a()
    {
      return 0.59F;
    }

    protected com.viber.voip.engagement.carousel.a.a<?, ?> a(Context paramContext, StickersMediaViewData paramStickersMediaViewData, int paramInt1, int paramInt2, LayoutInflater paramLayoutInflater)
    {
      return new com.viber.voip.engagement.carousel.a.d(paramContext, paramStickersMediaViewData.getItems(), paramInt1, paramInt2, f.k(f.this), f.l(f.this), f.m(f.this), paramLayoutInflater);
    }

    protected void a(com.viber.voip.engagement.carousel.a.a<?, ?> parama, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString, int paramInt4)
    {
      super.a(parama, paramInt1, paramInt2, paramInt3, paramBoolean, paramString, paramInt4);
    }

    protected float b()
    {
      return 0.5F;
    }
  }

  public static abstract interface e
  {
    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.f
 * JD-Core Version:    0.6.2
 */