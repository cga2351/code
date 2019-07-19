package android.support.v8.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.util.Log;
import android.view.Surface;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class Allocation extends BaseObj
{
  public static final int USAGE_GRAPHICS_TEXTURE = 2;
  public static final int USAGE_IO_INPUT = 32;
  public static final int USAGE_IO_OUTPUT = 64;
  public static final int USAGE_SCRIPT = 1;
  public static final int USAGE_SHARED = 128;
  static BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();
  Allocation mAdaptedAllocation;
  boolean mAutoPadding = false;
  Bitmap mBitmap;
  ByteBuffer mByteBuffer = null;
  long mByteBufferStride = 0L;
  boolean mConstrainedFace;
  boolean mConstrainedLOD;
  boolean mConstrainedY;
  boolean mConstrainedZ;
  int mCurrentCount;
  int mCurrentDimX;
  int mCurrentDimY;
  int mCurrentDimZ;
  boolean mIncAllocDestroyed;
  long mIncCompatAllocation;
  boolean mReadAllowed = true;
  Type.CubemapFace mSelectedFace = Type.CubemapFace.POSITIVE_X;
  int mSelectedLOD;
  int mSelectedY;
  int mSelectedZ;
  int mSize;
  Type mType;
  int mUsage;
  boolean mWriteAllowed = true;

  static
  {
    mBitmapOptions.inScaled = false;
  }

  Allocation(long paramLong, RenderScript paramRenderScript, Type paramType, int paramInt)
  {
    super(paramLong, paramRenderScript);
    if ((paramInt & 0xFFFFFF1C) != 0)
      throw new RSIllegalArgumentException("Unknown usage specified.");
    if ((paramInt & 0x20) != 0)
    {
      this.mWriteAllowed = false;
      if ((paramInt & 0xFFFFFFDC) != 0)
        throw new RSIllegalArgumentException("Invalid usage combination.");
    }
    this.mType = paramType;
    this.mUsage = paramInt;
    this.mIncCompatAllocation = 0L;
    this.mIncAllocDestroyed = false;
    if (paramType != null)
    {
      this.mSize = (this.mType.getCount() * this.mType.getElement().getBytesSize());
      updateCacheInfo(paramType);
    }
    if (RenderScript.sUseGCHooks == true);
    try
    {
      Method localMethod = RenderScript.registerNativeAllocation;
      Object localObject = RenderScript.sRuntime;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.mSize);
      localMethod.invoke(localObject, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      Log.e("RenderScript_jni", "Couldn't invoke registerNativeAllocation:" + localException);
      throw new RSRuntimeException("Couldn't invoke registerNativeAllocation:" + localException);
    }
  }

  private void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, Object paramObject, Element.DataType paramDataType, int paramInt3)
  {
    int i = paramInt2 * this.mType.mElement.getBytesSize();
    boolean bool1 = this.mAutoPadding;
    boolean bool2 = false;
    if (bool1)
    {
      int j = this.mType.getElement().getVectorSize();
      bool2 = false;
      if (j == 3)
        bool2 = true;
    }
    data1DChecks(paramInt1, paramInt2, paramInt3 * paramDataType.mSize, i, bool2);
    this.mRS.nAllocationData1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, paramObject, i, paramDataType, this.mType.mElement.mType.mSize, bool2);
  }

  private void copy1DRangeToUnchecked(int paramInt1, int paramInt2, Object paramObject, Element.DataType paramDataType, int paramInt3)
  {
    int i = paramInt2 * this.mType.mElement.getBytesSize();
    boolean bool1 = this.mAutoPadding;
    boolean bool2 = false;
    if (bool1)
    {
      int j = this.mType.getElement().getVectorSize();
      bool2 = false;
      if (j == 3)
        bool2 = true;
    }
    data1DChecks(paramInt1, paramInt2, paramInt3 * paramDataType.mSize, i, bool2);
    this.mRS.nAllocationRead1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, paramObject, i, paramDataType, this.mType.mElement.mType.mSize, bool2);
  }

  private void copy3DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject, Element.DataType paramDataType, int paramInt7)
  {
    this.mRS.validate();
    validate3DRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    int i = paramInt6 * (paramInt5 * (paramInt4 * this.mType.mElement.getBytesSize()));
    int j = paramInt7 * paramDataType.mSize;
    if ((this.mAutoPadding) && (this.mType.getElement().getVectorSize() == 3))
      if (3 * (i / 4) > j)
        throw new RSIllegalArgumentException("Array too small for allocation type.");
    for (boolean bool = true; ; bool = false)
    {
      this.mRS.nAllocationData3D(getIDSafe(), paramInt1, paramInt2, paramInt3, this.mSelectedLOD, paramInt4, paramInt5, paramInt6, paramObject, i, paramDataType, this.mType.mElement.mType.mSize, bool);
      return;
      if (i > j)
        throw new RSIllegalArgumentException("Array too small for allocation type.");
      i = j;
    }
  }

  private void copyFromUnchecked(Object paramObject, Element.DataType paramDataType, int paramInt)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramObject, paramDataType, paramInt);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramObject, paramDataType, paramInt);
      return;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, paramObject, paramDataType, paramInt);
  }

  private void copyTo(Object paramObject, Element.DataType paramDataType, int paramInt)
  {
    this.mRS.validate();
    boolean bool1 = this.mAutoPadding;
    boolean bool2 = false;
    if (bool1)
    {
      int i = this.mType.getElement().getVectorSize();
      bool2 = false;
      if (i == 3)
        bool2 = true;
    }
    if (bool2)
    {
      if (paramInt * paramDataType.mSize < 3 * (this.mSize / 4))
        throw new RSIllegalArgumentException("Size of output array cannot be smaller than size of allocation.");
    }
    else if (paramInt * paramDataType.mSize < this.mSize)
      throw new RSIllegalArgumentException("Size of output array cannot be smaller than size of allocation.");
    this.mRS.nAllocationRead(getID(this.mRS), paramObject, paramDataType, this.mType.mElement.mType.mSize, bool2);
  }

  public static Allocation createCubemapFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap)
  {
    return createCubemapFromBitmap(paramRenderScript, paramBitmap, MipmapControl.MIPMAP_NONE, 2);
  }

  public static Allocation createCubemapFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, MipmapControl paramMipmapControl, int paramInt)
  {
    boolean bool1 = true;
    paramRenderScript.validate();
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    if (j % 6 != 0)
      throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
    if (j / 6 != i)
      throw new RSIllegalArgumentException("Only square cube map faces supported");
    if ((i & i - 1) == 0);
    for (boolean bool2 = bool1; !bool2; bool2 = false)
      throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
    Element localElement = elementFromBitmap(paramRenderScript, paramBitmap);
    Type.Builder localBuilder = new Type.Builder(paramRenderScript, localElement);
    localBuilder.setX(i);
    localBuilder.setY(i);
    localBuilder.setFaces(bool1);
    if (paramMipmapControl == MipmapControl.MIPMAP_FULL);
    Type localType;
    long l;
    while (true)
    {
      localBuilder.setMipmaps(bool1);
      localType = localBuilder.create();
      l = paramRenderScript.nAllocationCubeCreateFromBitmap(localType.getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
      if (l != 0L)
        break;
      throw new RSRuntimeException("Load failed for bitmap " + paramBitmap + " element " + localElement);
      bool1 = false;
    }
    return new Allocation(l, paramRenderScript, localType, paramInt);
  }

  public static Allocation createCubemapFromCubeFaces(RenderScript paramRenderScript, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6)
  {
    return createCubemapFromCubeFaces(paramRenderScript, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, paramBitmap5, paramBitmap6, MipmapControl.MIPMAP_NONE, 2);
  }

  public static Allocation createCubemapFromCubeFaces(RenderScript paramRenderScript, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, MipmapControl paramMipmapControl, int paramInt)
  {
    return null;
  }

  public static Allocation createFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap)
  {
    return createFromBitmap(paramRenderScript, paramBitmap, MipmapControl.MIPMAP_NONE, 131);
  }

  public static Allocation createFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, MipmapControl paramMipmapControl, int paramInt)
  {
    paramRenderScript.validate();
    if (paramBitmap.getConfig() == null)
    {
      if ((paramInt & 0x80) != 0)
        throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      return createFromBitmap(paramRenderScript, localBitmap, paramMipmapControl, paramInt);
    }
    Type localType = typeFromBitmap(paramRenderScript, paramBitmap, paramMipmapControl);
    if ((paramMipmapControl == MipmapControl.MIPMAP_NONE) && (localType.getElement().isCompatible(Element.RGBA_8888(paramRenderScript))) && (paramInt == 131))
    {
      long l2 = paramRenderScript.nAllocationCreateBitmapBackedAllocation(localType.getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
      if (l2 == 0L)
        throw new RSRuntimeException("Load failed.");
      Allocation localAllocation = new Allocation(l2, paramRenderScript, localType, paramInt);
      localAllocation.setBitmap(paramBitmap);
      return localAllocation;
    }
    long l1 = paramRenderScript.nAllocationCreateFromBitmap(localType.getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
    if (l1 == 0L)
      throw new RSRuntimeException("Load failed.");
    return new Allocation(l1, paramRenderScript, localType, paramInt);
  }

  public static Allocation createFromBitmapResource(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    return createFromBitmapResource(paramRenderScript, paramResources, paramInt, MipmapControl.MIPMAP_NONE, 3);
  }

  public static Allocation createFromBitmapResource(RenderScript paramRenderScript, Resources paramResources, int paramInt1, MipmapControl paramMipmapControl, int paramInt2)
  {
    paramRenderScript.validate();
    if ((paramInt2 & 0xE0) != 0)
      throw new RSIllegalArgumentException("Unsupported usage specified.");
    Bitmap localBitmap = BitmapFactory.decodeResource(paramResources, paramInt1);
    Allocation localAllocation = createFromBitmap(paramRenderScript, localBitmap, paramMipmapControl, paramInt2);
    localBitmap.recycle();
    return localAllocation;
  }

  public static Allocation createFromString(RenderScript paramRenderScript, String paramString, int paramInt)
  {
    paramRenderScript.validate();
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      Allocation localAllocation = createSized(paramRenderScript, Element.U8(paramRenderScript), arrayOfByte.length, paramInt);
      localAllocation.copyFrom(arrayOfByte);
      return localAllocation;
    }
    catch (Exception localException)
    {
    }
    throw new RSRuntimeException("Could not convert string to utf-8.");
  }

  public static Allocation createSized(RenderScript paramRenderScript, Element paramElement, int paramInt)
  {
    return createSized(paramRenderScript, paramElement, paramInt, 1);
  }

  public static Allocation createSized(RenderScript paramRenderScript, Element paramElement, int paramInt1, int paramInt2)
  {
    paramRenderScript.validate();
    Type.Builder localBuilder = new Type.Builder(paramRenderScript, paramElement);
    localBuilder.setX(paramInt1);
    Type localType = localBuilder.create();
    long l = paramRenderScript.nAllocationCreateTyped(localType.getID(paramRenderScript), MipmapControl.MIPMAP_NONE.mID, paramInt2, 0L);
    if (l == 0L)
      throw new RSRuntimeException("Allocation creation failed.");
    return new Allocation(l, paramRenderScript, localType, paramInt2);
  }

  public static Allocation createTyped(RenderScript paramRenderScript, Type paramType)
  {
    return createTyped(paramRenderScript, paramType, MipmapControl.MIPMAP_NONE, 1);
  }

  public static Allocation createTyped(RenderScript paramRenderScript, Type paramType, int paramInt)
  {
    return createTyped(paramRenderScript, paramType, MipmapControl.MIPMAP_NONE, paramInt);
  }

  public static Allocation createTyped(RenderScript paramRenderScript, Type paramType, MipmapControl paramMipmapControl, int paramInt)
  {
    paramRenderScript.validate();
    if (paramType.getID(paramRenderScript) == 0L)
      throw new RSInvalidStateException("Bad Type");
    if ((!paramRenderScript.usingIO()) && ((paramInt & 0x20) != 0))
      throw new RSRuntimeException("USAGE_IO not supported, Allocation creation failed.");
    long l = paramRenderScript.nAllocationCreateTyped(paramType.getID(paramRenderScript), paramMipmapControl.mID, paramInt, 0L);
    if (l == 0L)
      throw new RSRuntimeException("Allocation creation failed.");
    return new Allocation(l, paramRenderScript, paramType, paramInt);
  }

  private void data1DChecks(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.mRS.validate();
    if (paramInt1 < 0)
      throw new RSIllegalArgumentException("Offset must be >= 0.");
    if (paramInt2 < 1)
      throw new RSIllegalArgumentException("Count must be >= 1.");
    if (paramInt1 + paramInt2 > this.mCurrentCount)
      throw new RSIllegalArgumentException("Overflow, Available count " + this.mCurrentCount + ", got " + paramInt2 + " at offset " + paramInt1 + ".");
    if (paramBoolean)
    {
      if (paramInt3 < 3 * (paramInt4 / 4))
        throw new RSIllegalArgumentException("Array too small for allocation type.");
    }
    else if (paramInt3 < paramInt4)
      throw new RSIllegalArgumentException("Array too small for allocation type.");
  }

  static Element elementFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    if (localConfig == Bitmap.Config.ALPHA_8)
      return Element.A_8(paramRenderScript);
    if (localConfig == Bitmap.Config.ARGB_4444)
      return Element.RGBA_4444(paramRenderScript);
    if (localConfig == Bitmap.Config.ARGB_8888)
      return Element.RGBA_8888(paramRenderScript);
    if (localConfig == Bitmap.Config.RGB_565)
      return Element.RGB_565(paramRenderScript);
    throw new RSInvalidStateException("Bad bitmap type: " + localConfig);
  }

  private long getIDSafe()
  {
    if (this.mAdaptedAllocation != null)
      return this.mAdaptedAllocation.getID(this.mRS);
    return getID(this.mRS);
  }

  private void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }

  static Type typeFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, MipmapControl paramMipmapControl)
  {
    Type.Builder localBuilder = new Type.Builder(paramRenderScript, elementFromBitmap(paramRenderScript, paramBitmap));
    localBuilder.setX(paramBitmap.getWidth());
    localBuilder.setY(paramBitmap.getHeight());
    if (paramMipmapControl == MipmapControl.MIPMAP_FULL);
    for (boolean bool = true; ; bool = false)
    {
      localBuilder.setMipmaps(bool);
      return localBuilder.create();
    }
  }

  private void updateCacheInfo(Type paramType)
  {
    this.mCurrentDimX = paramType.getX();
    this.mCurrentDimY = paramType.getY();
    this.mCurrentDimZ = paramType.getZ();
    this.mCurrentCount = this.mCurrentDimX;
    if (this.mCurrentDimY > 1)
      this.mCurrentCount *= this.mCurrentDimY;
    if (this.mCurrentDimZ > 1)
      this.mCurrentCount *= this.mCurrentDimZ;
  }

  private void validate2DRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mAdaptedAllocation != null);
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt2 < 0))
        throw new RSIllegalArgumentException("Offset cannot be negative.");
      if ((paramInt4 < 0) || (paramInt3 < 0))
        throw new RSIllegalArgumentException("Height or width cannot be negative.");
    }
    while ((paramInt1 + paramInt3 <= this.mCurrentDimX) && (paramInt2 + paramInt4 <= this.mCurrentDimY));
    throw new RSIllegalArgumentException("Updated region larger than allocation.");
  }

  private void validate3DRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.mAdaptedAllocation != null);
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
        throw new RSIllegalArgumentException("Offset cannot be negative.");
      if ((paramInt5 < 0) || (paramInt4 < 0) || (paramInt6 < 0))
        throw new RSIllegalArgumentException("Height or width cannot be negative.");
    }
    while ((paramInt1 + paramInt4 <= this.mCurrentDimX) && (paramInt2 + paramInt5 <= this.mCurrentDimY) && (paramInt3 + paramInt6 <= this.mCurrentDimZ));
    throw new RSIllegalArgumentException("Updated region larger than allocation.");
  }

  private void validateBitmapFormat(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    if (localConfig == null)
      throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
    switch (1.$SwitchMap$android$graphics$Bitmap$Config[localConfig.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    do
    {
      do
      {
        do
        {
          do
            return;
          while (this.mType.getElement().mKind == Element.DataKind.PIXEL_A);
          throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + localConfig);
        }
        while ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA) && (this.mType.getElement().getBytesSize() == 4));
        throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + localConfig);
      }
      while ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGB) && (this.mType.getElement().getBytesSize() == 2));
      throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + localConfig);
    }
    while ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA) && (this.mType.getElement().getBytesSize() == 2));
    throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + localConfig);
  }

  private void validateBitmapSize(Bitmap paramBitmap)
  {
    if ((this.mCurrentDimX != paramBitmap.getWidth()) || (this.mCurrentDimY != paramBitmap.getHeight()))
      throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
  }

  private void validateIsFloat32()
  {
    if (this.mType.mElement.mType == Element.DataType.FLOAT_32)
      return;
    throw new RSIllegalArgumentException("32 bit float source does not match allocation type " + this.mType.mElement.mType);
  }

  private void validateIsFloat64()
  {
    if (this.mType.mElement.mType == Element.DataType.FLOAT_64)
      return;
    throw new RSIllegalArgumentException("64 bit float source does not match allocation type " + this.mType.mElement.mType);
  }

  private void validateIsInt16()
  {
    if ((this.mType.mElement.mType == Element.DataType.SIGNED_16) || (this.mType.mElement.mType == Element.DataType.UNSIGNED_16))
      return;
    throw new RSIllegalArgumentException("16 bit integer source does not match allocation type " + this.mType.mElement.mType);
  }

  private void validateIsInt32()
  {
    if ((this.mType.mElement.mType == Element.DataType.SIGNED_32) || (this.mType.mElement.mType == Element.DataType.UNSIGNED_32))
      return;
    throw new RSIllegalArgumentException("32 bit integer source does not match allocation type " + this.mType.mElement.mType);
  }

  private void validateIsInt64()
  {
    if ((this.mType.mElement.mType == Element.DataType.SIGNED_64) || (this.mType.mElement.mType == Element.DataType.UNSIGNED_64))
      return;
    throw new RSIllegalArgumentException("64 bit integer source does not match allocation type " + this.mType.mElement.mType);
  }

  private void validateIsInt8()
  {
    if ((this.mType.mElement.mType == Element.DataType.SIGNED_8) || (this.mType.mElement.mType == Element.DataType.UNSIGNED_8))
      return;
    throw new RSIllegalArgumentException("8 bit integer source does not match allocation type " + this.mType.mElement.mType);
  }

  private void validateIsObject()
  {
    if ((this.mType.mElement.mType == Element.DataType.RS_ELEMENT) || (this.mType.mElement.mType == Element.DataType.RS_TYPE) || (this.mType.mElement.mType == Element.DataType.RS_ALLOCATION) || (this.mType.mElement.mType == Element.DataType.RS_SAMPLER) || (this.mType.mElement.mType == Element.DataType.RS_SCRIPT))
      return;
    throw new RSIllegalArgumentException("Object source does not match allocation type " + this.mType.mElement.mType);
  }

  private Element.DataType validateObjectIsPrimitiveArray(Object paramObject, boolean paramBoolean)
  {
    Class localClass1 = paramObject.getClass();
    if (!localClass1.isArray())
      throw new RSIllegalArgumentException("Object passed is not an array of primitives.");
    Class localClass2 = localClass1.getComponentType();
    if (!localClass2.isPrimitive())
      throw new RSIllegalArgumentException("Object passed is not an Array of primitives.");
    if (localClass2 == Long.TYPE)
    {
      if (paramBoolean)
      {
        validateIsInt64();
        return this.mType.mElement.mType;
      }
      return Element.DataType.SIGNED_64;
    }
    if (localClass2 == Integer.TYPE)
    {
      if (paramBoolean)
      {
        validateIsInt32();
        return this.mType.mElement.mType;
      }
      return Element.DataType.SIGNED_32;
    }
    if (localClass2 == Short.TYPE)
    {
      if (paramBoolean)
      {
        validateIsInt16();
        return this.mType.mElement.mType;
      }
      return Element.DataType.SIGNED_16;
    }
    if (localClass2 == Byte.TYPE)
    {
      if (paramBoolean)
      {
        validateIsInt8();
        return this.mType.mElement.mType;
      }
      return Element.DataType.SIGNED_8;
    }
    if (localClass2 == Float.TYPE)
    {
      if (paramBoolean)
        validateIsFloat32();
      return Element.DataType.FLOAT_32;
    }
    if (localClass2 == Double.TYPE)
    {
      if (paramBoolean)
        validateIsFloat64();
      return Element.DataType.FLOAT_64;
    }
    return null;
  }

  public void copy1DRangeFrom(int paramInt1, int paramInt2, Allocation paramAllocation, int paramInt3)
  {
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, 0, this.mSelectedLOD, this.mSelectedFace.mID, paramInt2, 1, paramAllocation.getID(this.mRS), paramInt3, 0, paramAllocation.mSelectedLOD, paramAllocation.mSelectedFace.mID);
  }

  public void copy1DRangeFrom(int paramInt1, int paramInt2, Object paramObject)
  {
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramObject, validateObjectIsPrimitiveArray(paramObject, true), Array.getLength(paramObject));
  }

  public void copy1DRangeFrom(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copy1DRangeFrom(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copy1DRangeFrom(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    validateIsInt32();
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copy1DRangeFrom(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    validateIsInt16();
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, Object paramObject)
  {
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramObject, validateObjectIsPrimitiveArray(paramObject, false), Array.getLength(paramObject));
  }

  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  public void copy1DRangeTo(int paramInt1, int paramInt2, Object paramObject)
  {
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramObject, validateObjectIsPrimitiveArray(paramObject, true), Array.getLength(paramObject));
  }

  public void copy1DRangeTo(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copy1DRangeTo(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copy1DRangeTo(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    validateIsInt32();
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copy1DRangeTo(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    validateIsInt16();
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  public void copy1DRangeToUnchecked(int paramInt1, int paramInt2, Object paramObject)
  {
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramObject, validateObjectIsPrimitiveArray(paramObject, false), Array.getLength(paramObject));
  }

  public void copy1DRangeToUnchecked(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copy1DRangeToUnchecked(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copy1DRangeToUnchecked(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copy1DRangeToUnchecked(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    copy1DRangeToUnchecked(paramInt1, paramInt2, paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Allocation paramAllocation, int paramInt5, int paramInt6)
  {
    this.mRS.validate();
    validate2DRange(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramInt3, paramInt4, paramAllocation.getID(this.mRS), paramInt5, paramInt6, paramAllocation.mSelectedLOD, paramAllocation.mSelectedFace.mID);
  }

  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramObject, validateObjectIsPrimitiveArray(paramObject, true), Array.getLength(paramObject));
  }

  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    validateIsInt32();
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort)
  {
    validateIsInt16();
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  public void copy2DRangeFrom(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this.mRS.validate();
    if (paramBitmap.getConfig() == null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      copy2DRangeFrom(paramInt1, paramInt2, localBitmap);
      return;
    }
    validateBitmapFormat(paramBitmap);
    validate2DRange(paramInt1, paramInt2, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramBitmap);
  }

  void copy2DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Element.DataType paramDataType, int paramInt5)
  {
    this.mRS.validate();
    validate2DRange(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = paramInt4 * (paramInt3 * this.mType.mElement.getBytesSize());
    int j = paramInt5 * paramDataType.mSize;
    if ((this.mAutoPadding) && (this.mType.getElement().getVectorSize() == 3))
      if (3 * (i / 4) > j)
        throw new RSIllegalArgumentException("Array too small for allocation type.");
    for (boolean bool = true; ; bool = false)
    {
      this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramInt3, paramInt4, paramObject, i, paramDataType, this.mType.mElement.mType.mSize, bool);
      return;
      if (i > j)
        throw new RSIllegalArgumentException("Array too small for allocation type.");
      i = j;
    }
  }

  public void copy2DRangeTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    copy2DRangeToUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramObject, validateObjectIsPrimitiveArray(paramObject, true), Array.getLength(paramObject));
  }

  public void copy2DRangeTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copy2DRangeToUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copy2DRangeTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copy2DRangeToUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copy2DRangeTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    validateIsInt32();
    copy2DRangeToUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copy2DRangeTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort)
  {
    validateIsInt16();
    copy2DRangeToUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  void copy2DRangeToUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject, Element.DataType paramDataType, int paramInt5)
  {
    this.mRS.validate();
    validate2DRange(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = paramInt4 * (paramInt3 * this.mType.mElement.getBytesSize());
    int j = paramInt5 * paramDataType.mSize;
    if ((this.mAutoPadding) && (this.mType.getElement().getVectorSize() == 3))
      if (3 * (i / 4) > j)
        throw new RSIllegalArgumentException("Array too small for allocation type.");
    for (boolean bool = true; ; bool = false)
    {
      this.mRS.nAllocationRead2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramInt3, paramInt4, paramObject, i, paramDataType, this.mType.mElement.mType.mSize, bool);
      return;
      if (i > j)
        throw new RSIllegalArgumentException("Array too small for allocation type.");
      i = j;
    }
  }

  public void copy3DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Allocation paramAllocation, int paramInt7, int paramInt8, int paramInt9)
  {
    this.mRS.validate();
    validate3DRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    this.mRS.nAllocationData3D(getIDSafe(), paramInt1, paramInt2, paramInt3, this.mSelectedLOD, paramInt4, paramInt5, paramInt6, paramAllocation.getID(this.mRS), paramInt7, paramInt8, paramInt9, paramAllocation.mSelectedLOD);
  }

  public void copy3DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject)
  {
    copy3DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramObject, validateObjectIsPrimitiveArray(paramObject, true), Array.getLength(paramObject));
  }

  public void copyFrom(Bitmap paramBitmap)
  {
    this.mRS.validate();
    if (paramBitmap.getConfig() == null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      copyFrom(localBitmap);
      return;
    }
    validateBitmapSize(paramBitmap);
    validateBitmapFormat(paramBitmap);
    this.mRS.nAllocationCopyFromBitmap(getID(this.mRS), paramBitmap);
  }

  public void copyFrom(Allocation paramAllocation)
  {
    this.mRS.validate();
    if (!this.mType.equals(paramAllocation.getType()))
      throw new RSIllegalArgumentException("Types of allocations must match.");
    copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramAllocation, 0, 0);
  }

  public void copyFrom(Object paramObject)
  {
    copyFromUnchecked(paramObject, validateObjectIsPrimitiveArray(paramObject, true), Array.getLength(paramObject));
  }

  public void copyFrom(byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copyFromUnchecked(paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copyFrom(float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copyFromUnchecked(paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copyFrom(int[] paramArrayOfInt)
  {
    validateIsInt32();
    copyFromUnchecked(paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copyFrom(BaseObj[] paramArrayOfBaseObj)
  {
    this.mRS.validate();
    validateIsObject();
    if (paramArrayOfBaseObj.length != this.mCurrentCount)
      throw new RSIllegalArgumentException("Array size mismatch, allocation sizeX = " + this.mCurrentCount + ", array length = " + paramArrayOfBaseObj.length);
    if (RenderScript.sPointerSize == 8)
    {
      long[] arrayOfLong = new long[4 * paramArrayOfBaseObj.length];
      for (int j = 0; j < paramArrayOfBaseObj.length; j++)
        arrayOfLong[(j * 4)] = paramArrayOfBaseObj[j].getID(this.mRS);
      copy1DRangeFromUnchecked(0, this.mCurrentCount, arrayOfLong);
      return;
    }
    int[] arrayOfInt = new int[paramArrayOfBaseObj.length];
    for (int i = 0; i < paramArrayOfBaseObj.length; i++)
      arrayOfInt[i] = ((int)paramArrayOfBaseObj[i].getID(this.mRS));
    copy1DRangeFromUnchecked(0, this.mCurrentCount, arrayOfInt);
  }

  public void copyFrom(short[] paramArrayOfShort)
  {
    validateIsInt16();
    copyFromUnchecked(paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  public void copyFromUnchecked(Object paramObject)
  {
    copyFromUnchecked(paramObject, validateObjectIsPrimitiveArray(paramObject, false), Array.getLength(paramObject));
  }

  public void copyFromUnchecked(byte[] paramArrayOfByte)
  {
    copyFromUnchecked(paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copyFromUnchecked(float[] paramArrayOfFloat)
  {
    copyFromUnchecked(paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copyFromUnchecked(int[] paramArrayOfInt)
  {
    copyFromUnchecked(paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copyFromUnchecked(short[] paramArrayOfShort)
  {
    copyFromUnchecked(paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  public void copyTo(Bitmap paramBitmap)
  {
    this.mRS.validate();
    validateBitmapFormat(paramBitmap);
    validateBitmapSize(paramBitmap);
    this.mRS.nAllocationCopyToBitmap(getID(this.mRS), paramBitmap);
  }

  public void copyTo(Object paramObject)
  {
    copyTo(paramObject, validateObjectIsPrimitiveArray(paramObject, true), Array.getLength(paramObject));
  }

  public void copyTo(byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copyTo(paramArrayOfByte, Element.DataType.SIGNED_8, paramArrayOfByte.length);
  }

  public void copyTo(float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copyTo(paramArrayOfFloat, Element.DataType.FLOAT_32, paramArrayOfFloat.length);
  }

  public void copyTo(int[] paramArrayOfInt)
  {
    validateIsInt32();
    copyTo(paramArrayOfInt, Element.DataType.SIGNED_32, paramArrayOfInt.length);
  }

  public void copyTo(short[] paramArrayOfShort)
  {
    validateIsInt16();
    copyTo(paramArrayOfShort, Element.DataType.SIGNED_16, paramArrayOfShort.length);
  }

  public void destroy()
  {
    int i = 1;
    if (this.mIncCompatAllocation != 0L);
    while (true)
    {
      try
      {
        if (!this.mIncAllocDestroyed)
        {
          this.mIncAllocDestroyed = true;
          if (i != 0)
          {
            ReentrantReadWriteLock.ReadLock localReadLock = this.mRS.mRWLock.readLock();
            localReadLock.lock();
            if (this.mRS.isAlive())
              this.mRS.nIncObjDestroy(this.mIncCompatAllocation);
            localReadLock.unlock();
            this.mIncCompatAllocation = 0L;
          }
          if ((0x60 & this.mUsage) != 0)
            setSurface(null);
          super.destroy();
          return;
        }
      }
      finally
      {
      }
      i = 0;
    }
  }

  protected void finalize()
    throws Throwable
  {
    if (RenderScript.sUseGCHooks == true)
    {
      Method localMethod = RenderScript.registerNativeFree;
      Object localObject = RenderScript.sRuntime;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.mSize);
      localMethod.invoke(localObject, arrayOfObject);
    }
    super.finalize();
  }

  public void generateMipmaps()
  {
    this.mRS.nAllocationGenerateMipmaps(getID(this.mRS));
  }

  public ByteBuffer getByteBuffer()
  {
    int i = this.mType.getX() * this.mType.getElement().getBytesSize();
    if (this.mRS.getDispatchAPILevel() < 21)
    {
      if (this.mType.getZ() > 0)
        return null;
      byte[] arrayOfByte;
      if (this.mType.getY() > 0)
      {
        arrayOfByte = new byte[i * this.mType.getY()];
        copy2DRangeToUnchecked(0, 0, this.mType.getX(), this.mType.getY(), arrayOfByte, Element.DataType.SIGNED_8, i * this.mType.getY());
      }
      while (true)
      {
        ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte).asReadOnlyBuffer();
        this.mByteBufferStride = i;
        return localByteBuffer;
        arrayOfByte = new byte[i];
        copy1DRangeToUnchecked(0, this.mType.getX(), arrayOfByte);
      }
    }
    if ((this.mByteBuffer == null) || ((0x20 & this.mUsage) != 0))
      this.mByteBuffer = this.mRS.nAllocationGetByteBuffer(getID(this.mRS), i, this.mType.getY(), this.mType.getZ());
    return this.mByteBuffer;
  }

  public int getBytesSize()
  {
    if (this.mType.mDimYuv != 0)
      return (int)Math.ceil(1.5D * (this.mType.getCount() * this.mType.getElement().getBytesSize()));
    return this.mType.getCount() * this.mType.getElement().getBytesSize();
  }

  public Element getElement()
  {
    return this.mType.getElement();
  }

  public long getIncAllocID()
  {
    return this.mIncCompatAllocation;
  }

  public long getStride()
  {
    if (this.mByteBufferStride == 0L)
      if (this.mRS.getDispatchAPILevel() <= 21)
        break label45;
    label45: for (this.mByteBufferStride = this.mRS.nAllocationGetStride(getID(this.mRS)); ; this.mByteBufferStride = (this.mType.getX() * this.mType.getElement().getBytesSize()))
      return this.mByteBufferStride;
  }

  public Type getType()
  {
    return this.mType;
  }

  public int getUsage()
  {
    return this.mUsage;
  }

  public void ioReceive()
  {
    if ((0x20 & this.mUsage) == 0)
      throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
    this.mRS.validate();
    this.mRS.nAllocationIoReceive(getID(this.mRS));
  }

  public void ioSend()
  {
    if ((0x40 & this.mUsage) == 0)
      throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
    this.mRS.validate();
    this.mRS.nAllocationIoSend(getID(this.mRS));
  }

  public void ioSendOutput()
  {
    ioSend();
  }

  public void setAutoPadding(boolean paramBoolean)
  {
    this.mAutoPadding = paramBoolean;
  }

  public void setFromFieldPacker(int paramInt1, int paramInt2, FieldPacker paramFieldPacker)
  {
    this.mRS.validate();
    if (paramInt2 >= this.mType.mElement.mElements.length)
      throw new RSIllegalArgumentException("Component_number " + paramInt2 + " out of range.");
    if (paramInt1 < 0)
      throw new RSIllegalArgumentException("Offset must be >= 0.");
    byte[] arrayOfByte = paramFieldPacker.getData();
    int i = paramFieldPacker.getPos();
    int j = this.mType.mElement.mElements[paramInt2].getBytesSize() * this.mType.mElement.mArraySizes[paramInt2];
    if (i != j)
      throw new RSIllegalArgumentException("Field packer sizelength " + i + " does not match component size " + j + ".");
    this.mRS.nAllocationElementData1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, arrayOfByte, i);
  }

  public void setFromFieldPacker(int paramInt, FieldPacker paramFieldPacker)
  {
    this.mRS.validate();
    int i = this.mType.mElement.getBytesSize();
    byte[] arrayOfByte = paramFieldPacker.getData();
    int j = paramFieldPacker.getPos();
    int k = j / i;
    if (i * k != j)
      throw new RSIllegalArgumentException("Field packer length " + j + " not divisible by element size " + i + ".");
    copy1DRangeFromUnchecked(paramInt, k, arrayOfByte);
  }

  public void setIncAllocID(long paramLong)
  {
    this.mIncCompatAllocation = paramLong;
  }

  public void setSurface(Surface paramSurface)
  {
    this.mRS.validate();
    if ((0x40 & this.mUsage) == 0)
      throw new RSInvalidStateException("Allocation is not USAGE_IO_OUTPUT.");
    this.mRS.nAllocationSetSurface(getID(this.mRS), paramSurface);
  }

  public void syncAll(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new RSIllegalArgumentException("Source must be exactly one usage type.");
    case 1:
    case 2:
    }
    this.mRS.validate();
    this.mRS.nAllocationSyncAll(getIDSafe(), paramInt);
  }

  public static enum MipmapControl
  {
    int mID;

    static
    {
      MIPMAP_FULL = new MipmapControl("MIPMAP_FULL", 1, 1);
      MIPMAP_ON_SYNC_TO_TEXTURE = new MipmapControl("MIPMAP_ON_SYNC_TO_TEXTURE", 2, 2);
      MipmapControl[] arrayOfMipmapControl = new MipmapControl[3];
      arrayOfMipmapControl[0] = MIPMAP_NONE;
      arrayOfMipmapControl[1] = MIPMAP_FULL;
      arrayOfMipmapControl[2] = MIPMAP_ON_SYNC_TO_TEXTURE;
    }

    private MipmapControl(int paramInt)
    {
      this.mID = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Allocation
 * JD-Core Version:    0.6.2
 */