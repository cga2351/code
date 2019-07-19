package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract interface IFragmentWrapper extends IInterface
{
  public abstract Bundle getArguments()
    throws RemoteException;

  public abstract int getId()
    throws RemoteException;

  public abstract boolean getRetainInstance()
    throws RemoteException;

  public abstract String getTag()
    throws RemoteException;

  public abstract int getTargetRequestCode()
    throws RemoteException;

  public abstract boolean getUserVisibleHint()
    throws RemoteException;

  public abstract boolean isAdded()
    throws RemoteException;

  public abstract boolean isDetached()
    throws RemoteException;

  public abstract boolean isHidden()
    throws RemoteException;

  public abstract boolean isInLayout()
    throws RemoteException;

  public abstract boolean isRemoving()
    throws RemoteException;

  public abstract boolean isResumed()
    throws RemoteException;

  public abstract boolean isVisible()
    throws RemoteException;

  public abstract void setHasOptionsMenu(boolean paramBoolean)
    throws RemoteException;

  public abstract void setMenuVisibility(boolean paramBoolean)
    throws RemoteException;

  public abstract void setRetainInstance(boolean paramBoolean)
    throws RemoteException;

  public abstract void setUserVisibleHint(boolean paramBoolean)
    throws RemoteException;

  public abstract void startActivity(Intent paramIntent)
    throws RemoteException;

  public abstract void startActivityForResult(Intent paramIntent, int paramInt)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract IObjectWrapper zzad()
    throws RemoteException;

  public abstract IFragmentWrapper zzae()
    throws RemoteException;

  public abstract IObjectWrapper zzaf()
    throws RemoteException;

  public abstract IFragmentWrapper zzag()
    throws RemoteException;

  public abstract IObjectWrapper zzah()
    throws RemoteException;

  public abstract void zzb(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public static abstract class Stub extends zzb
    implements IFragmentWrapper
  {
    public Stub()
    {
      super();
    }

    public static IFragmentWrapper asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      if ((localIInterface instanceof IFragmentWrapper))
        return (IFragmentWrapper)localIInterface;
      return new zza(paramIBinder);
    }

    protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return false;
      case 2:
        IObjectWrapper localIObjectWrapper3 = zzad();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, localIObjectWrapper3);
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      }
      while (true)
      {
        return true;
        Bundle localBundle = getArguments();
        paramParcel2.writeNoException();
        zzc.zzb(paramParcel2, localBundle);
        continue;
        int j = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(j);
        continue;
        IFragmentWrapper localIFragmentWrapper2 = zzae();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, localIFragmentWrapper2);
        continue;
        IObjectWrapper localIObjectWrapper2 = zzaf();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, localIObjectWrapper2);
        continue;
        boolean bool9 = getRetainInstance();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool9);
        continue;
        String str = getTag();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str);
        continue;
        IFragmentWrapper localIFragmentWrapper1 = zzag();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, localIFragmentWrapper1);
        continue;
        int i = getTargetRequestCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i);
        continue;
        boolean bool8 = getUserVisibleHint();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool8);
        continue;
        IObjectWrapper localIObjectWrapper1 = zzah();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, localIObjectWrapper1);
        continue;
        boolean bool7 = isAdded();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool7);
        continue;
        boolean bool6 = isDetached();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool6);
        continue;
        boolean bool5 = isHidden();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool5);
        continue;
        boolean bool4 = isInLayout();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool4);
        continue;
        boolean bool3 = isRemoving();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool3);
        continue;
        boolean bool2 = isResumed();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool2);
        continue;
        boolean bool1 = isVisible();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool1);
        continue;
        zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        continue;
        setHasOptionsMenu(zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        continue;
        setMenuVisibility(zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        continue;
        setRetainInstance(zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        continue;
        setUserVisibleHint(zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        continue;
        startActivity((Intent)zzc.zza(paramParcel1, Intent.CREATOR));
        paramParcel2.writeNoException();
        continue;
        startActivityForResult((Intent)zzc.zza(paramParcel1, Intent.CREATOR), paramParcel1.readInt());
        paramParcel2.writeNoException();
        continue;
        zzb(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
      }
    }

    public static final class zza extends zza
      implements IFragmentWrapper
    {
      zza(IBinder paramIBinder)
      {
        super("com.google.android.gms.dynamic.IFragmentWrapper");
      }

      public final Bundle getArguments()
        throws RemoteException
      {
        Parcel localParcel = zza(3, zza());
        Bundle localBundle = (Bundle)zzc.zza(localParcel, Bundle.CREATOR);
        localParcel.recycle();
        return localBundle;
      }

      public final int getId()
        throws RemoteException
      {
        Parcel localParcel = zza(4, zza());
        int i = localParcel.readInt();
        localParcel.recycle();
        return i;
      }

      public final boolean getRetainInstance()
        throws RemoteException
      {
        Parcel localParcel = zza(7, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final String getTag()
        throws RemoteException
      {
        Parcel localParcel = zza(8, zza());
        String str = localParcel.readString();
        localParcel.recycle();
        return str;
      }

      public final int getTargetRequestCode()
        throws RemoteException
      {
        Parcel localParcel = zza(10, zza());
        int i = localParcel.readInt();
        localParcel.recycle();
        return i;
      }

      public final boolean getUserVisibleHint()
        throws RemoteException
      {
        Parcel localParcel = zza(11, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final boolean isAdded()
        throws RemoteException
      {
        Parcel localParcel = zza(13, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final boolean isDetached()
        throws RemoteException
      {
        Parcel localParcel = zza(14, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final boolean isHidden()
        throws RemoteException
      {
        Parcel localParcel = zza(15, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final boolean isInLayout()
        throws RemoteException
      {
        Parcel localParcel = zza(16, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final boolean isRemoving()
        throws RemoteException
      {
        Parcel localParcel = zza(17, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final boolean isResumed()
        throws RemoteException
      {
        Parcel localParcel = zza(18, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final boolean isVisible()
        throws RemoteException
      {
        Parcel localParcel = zza(19, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }

      public final void setHasOptionsMenu(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.writeBoolean(localParcel, paramBoolean);
        zzb(21, localParcel);
      }

      public final void setMenuVisibility(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.writeBoolean(localParcel, paramBoolean);
        zzb(22, localParcel);
      }

      public final void setRetainInstance(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.writeBoolean(localParcel, paramBoolean);
        zzb(23, localParcel);
      }

      public final void setUserVisibleHint(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.writeBoolean(localParcel, paramBoolean);
        zzb(24, localParcel);
      }

      public final void startActivity(Intent paramIntent)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.zza(localParcel, paramIntent);
        zzb(25, localParcel);
      }

      public final void startActivityForResult(Intent paramIntent, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.zza(localParcel, paramIntent);
        localParcel.writeInt(paramInt);
        zzb(26, localParcel);
      }

      public final void zza(IObjectWrapper paramIObjectWrapper)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.zza(localParcel, paramIObjectWrapper);
        zzb(20, localParcel);
      }

      public final IObjectWrapper zzad()
        throws RemoteException
      {
        Parcel localParcel = zza(2, zza());
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIObjectWrapper;
      }

      public final IFragmentWrapper zzae()
        throws RemoteException
      {
        Parcel localParcel = zza(5, zza());
        IFragmentWrapper localIFragmentWrapper = IFragmentWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIFragmentWrapper;
      }

      public final IObjectWrapper zzaf()
        throws RemoteException
      {
        Parcel localParcel = zza(6, zza());
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIObjectWrapper;
      }

      public final IFragmentWrapper zzag()
        throws RemoteException
      {
        Parcel localParcel = zza(9, zza());
        IFragmentWrapper localIFragmentWrapper = IFragmentWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIFragmentWrapper;
      }

      public final IObjectWrapper zzah()
        throws RemoteException
      {
        Parcel localParcel = zza(12, zza());
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIObjectWrapper;
      }

      public final void zzb(IObjectWrapper paramIObjectWrapper)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.zza(localParcel, paramIObjectWrapper);
        zzb(27, localParcel);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.IFragmentWrapper
 * JD-Core Version:    0.6.2
 */