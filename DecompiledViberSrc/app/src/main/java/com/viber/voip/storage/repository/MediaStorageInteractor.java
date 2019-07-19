package com.viber.voip.storage.repository;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.provider.d;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.State;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.util.cl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaStorageInteractor<LOADER extends d<ConversationWithMediaSizesEntity>,  extends h>
{
  private static final Logger a = ViberEnv.getLogger();
  private final LOADER b;
  private final r c;
  private final u d;
  private final Handler e;
  private final Handler f;
  private a g = (a)cl.b(a.class);
  private final i h = new i()
  {
    public void a(MessageEntity paramAnonymousMessageEntity)
    {
      synchronized (MediaStorageInteractor.b(MediaStorageInteractor.this))
      {
        MediaStorageInteractor.b(MediaStorageInteractor.this).append(paramAnonymousMessageEntity.getConversationId(), Long.valueOf(Math.max(0L, paramAnonymousMessageEntity.getDate() - 1L)));
        return;
      }
    }

    public void a(ArrayList<ConversationWithMediaSizesEntity> paramAnonymousArrayList)
    {
      if (paramAnonymousArrayList.isEmpty())
      {
        MediaStorageInteractor.a(MediaStorageInteractor.this).a(paramAnonymousArrayList);
        MediaStorageInteractor.a(MediaStorageInteractor.this).a();
        return;
      }
      ArrayList localArrayList = new ArrayList(paramAnonymousArrayList.size());
      Iterator localIterator = paramAnonymousArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationWithMediaSizesEntity localConversationWithMediaSizesEntity = (ConversationWithMediaSizesEntity)localIterator.next();
        if (localConversationWithMediaSizesEntity.hasCalculatedSummaryMediaSize())
          synchronized (MediaStorageInteractor.b(MediaStorageInteractor.this))
          {
            if (((Long)MediaStorageInteractor.b(MediaStorageInteractor.this).get(localConversationWithMediaSizesEntity.getId(), Long.valueOf(0L))).longValue() != localConversationWithMediaSizesEntity.getDate())
              localArrayList.add(localConversationWithMediaSizesEntity);
          }
        localArrayList.add(localConversationWithMediaSizesEntity);
      }
      if (!paramAnonymousArrayList.isEmpty())
        MediaStorageInteractor.a(MediaStorageInteractor.this).a(paramAnonymousArrayList);
      if (MediaStorageInteractor.c(MediaStorageInteractor.this) != null)
        MediaStorageInteractor.c(MediaStorageInteractor.this).a();
      if (localArrayList.isEmpty())
      {
        MediaStorageInteractor.a(MediaStorageInteractor.this).a();
        return;
      }
      MediaStorageInteractor.a(MediaStorageInteractor.this, new a(MediaStorageInteractor.d(MediaStorageInteractor.this), localArrayList, MediaStorageInteractor.e(MediaStorageInteractor.this)));
      MediaStorageInteractor.f(MediaStorageInteractor.this).post(MediaStorageInteractor.c(MediaStorageInteractor.this));
    }

    public void b(MessageEntity paramAnonymousMessageEntity)
    {
      synchronized (MediaStorageInteractor.b(MediaStorageInteractor.this))
      {
        MediaStorageInteractor.b(MediaStorageInteractor.this).append(paramAnonymousMessageEntity.getConversationId(), Long.valueOf(Math.max(0L, paramAnonymousMessageEntity.getDate())));
        return;
      }
    }
  };
  private final a.a i = new a.a()
  {
    public void a()
    {
      MediaStorageInteractor.h(MediaStorageInteractor.this).post(new w(this));
    }

    public void a(ConversationWithMediaSizesEntity paramAnonymousConversationWithMediaSizesEntity)
    {
      synchronized (MediaStorageInteractor.b(MediaStorageInteractor.this))
      {
        MediaStorageInteractor.b(MediaStorageInteractor.this).append(paramAnonymousConversationWithMediaSizesEntity.getId(), Long.valueOf(paramAnonymousConversationWithMediaSizesEntity.getDate()));
        MediaStorageInteractor.g(MediaStorageInteractor.this).a(paramAnonymousConversationWithMediaSizesEntity);
        MediaStorageInteractor.h(MediaStorageInteractor.this).post(new v(this, paramAnonymousConversationWithMediaSizesEntity));
        return;
      }
    }
  };
  private final LongSparseArray<Long> j = new LongSparseArray();
  private a k;

  public MediaStorageInteractor(LOADER paramLOADER, r paramr, u paramu, Handler paramHandler1, Handler paramHandler2)
  {
    this.b = paramLOADER;
    this.c = paramr;
    this.d = paramu;
    this.e = paramHandler1;
    this.f = paramHandler2;
  }

  public MediaStorageInteractorSaveState a()
  {
    return new MediaStorageInteractorSaveState(this.j);
  }

  public void a(MediaStorageInteractorSaveState paramMediaStorageInteractorSaveState)
  {
    LongSparseArray localLongSparseArray1 = paramMediaStorageInteractorSaveState.getCalculationTimeMillis();
    if (com.viber.voip.util.u.a(localLongSparseArray1))
      return;
    while (true)
    {
      int n;
      synchronized (this.j)
      {
        int m = localLongSparseArray1.size();
        n = 0;
        if (n < m)
        {
          long l = localLongSparseArray1.keyAt(n);
          Long localLong = (Long)localLongSparseArray1.valueAt(n);
          if (((Long)this.j.get(l, Long.valueOf(0L))).longValue() < localLong.longValue())
            this.j.put(l, localLong);
        }
        else
        {
          return;
        }
      }
      n++;
    }
  }

  public void a(a parama)
  {
    this.g = parama;
    ((h)this.b).a(this.h);
    if (this.b.b())
      this.b.c();
    this.b.l();
  }

  public void a(String paramString)
  {
    ((h)this.b).f(paramString);
  }

  public void b()
  {
    this.b.i();
    this.b.p();
  }

  public void c()
  {
    this.j.clear();
    this.b.l();
  }

  public void d()
  {
    this.g = ((a)cl.b(a.class));
    this.b.y_();
    ((h)this.b).a(null);
  }

  public void e()
  {
    this.b.q();
    this.b.j();
    if (this.k != null)
      this.k.a();
  }

  public static class MediaStorageInteractorSaveState extends State
  {
    public static final Parcelable.Creator<MediaStorageInteractorSaveState> CREATOR = new Parcelable.Creator()
    {
      public MediaStorageInteractor.MediaStorageInteractorSaveState a(Parcel paramAnonymousParcel)
      {
        return new MediaStorageInteractor.MediaStorageInteractorSaveState(paramAnonymousParcel);
      }

      public MediaStorageInteractor.MediaStorageInteractorSaveState[] a(int paramAnonymousInt)
      {
        return new MediaStorageInteractor.MediaStorageInteractorSaveState[paramAnonymousInt];
      }
    };
    private final LongSparseArray<Long> mCalculationTimeMillis;

    protected MediaStorageInteractorSaveState(Parcel paramParcel)
    {
      super();
      this.mCalculationTimeMillis = new LongSparseArray();
      long[] arrayOfLong1 = paramParcel.createLongArray();
      long[] arrayOfLong2 = paramParcel.createLongArray();
      if ((arrayOfLong1 != null) && (arrayOfLong2 != null))
      {
        int i = Math.min(arrayOfLong1.length, arrayOfLong2.length);
        for (int j = 0; j < i; j++)
          this.mCalculationTimeMillis.put(arrayOfLong1[j], Long.valueOf(arrayOfLong2[j]));
      }
    }

    MediaStorageInteractorSaveState(LongSparseArray<Long> paramLongSparseArray)
    {
      this.mCalculationTimeMillis = paramLongSparseArray.clone();
    }

    public static MediaStorageInteractorSaveState createEmpty()
    {
      return new MediaStorageInteractorSaveState(new LongSparseArray(0));
    }

    public int describeContents()
    {
      return 0;
    }

    public LongSparseArray<Long> getCalculationTimeMillis()
    {
      return this.mCalculationTimeMillis;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      int i = this.mCalculationTimeMillis.size();
      long[] arrayOfLong1 = new long[i];
      long[] arrayOfLong2 = new long[i];
      for (int j = 0; j < i; j++)
      {
        arrayOfLong1[j] = this.mCalculationTimeMillis.keyAt(j);
        arrayOfLong2[j] = ((Long)this.mCalculationTimeMillis.valueAt(j)).longValue();
      }
      paramParcel.writeLongArray(arrayOfLong1);
      paramParcel.writeLongArray(arrayOfLong2);
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(ConversationWithMediaSizesEntity paramConversationWithMediaSizesEntity);

    public abstract void a(List<ConversationWithMediaSizesEntity> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.MediaStorageInteractor
 * JD-Core Version:    0.6.2
 */