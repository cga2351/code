package android.support.v8.renderscript;

import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

public class Script extends BaseObj
{
  private final SparseArray<FieldID> mFIDs = new SparseArray();
  private final SparseArray<InvokeID> mIIDs = new SparseArray();
  private final SparseArray<KernelID> mKIDs = new SparseArray();
  private boolean mUseIncSupp = false;

  Script(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public void bindAllocation(Allocation paramAllocation, int paramInt)
  {
    this.mRS.validate();
    if (paramAllocation != null)
    {
      this.mRS.nScriptBindAllocation(getID(this.mRS), paramAllocation.getID(this.mRS), paramInt, this.mUseIncSupp);
      return;
    }
    this.mRS.nScriptBindAllocation(getID(this.mRS), 0L, paramInt, this.mUseIncSupp);
  }

  protected FieldID createFieldID(int paramInt, Element paramElement)
  {
    FieldID localFieldID1 = (FieldID)this.mFIDs.get(paramInt);
    if (localFieldID1 != null)
      return localFieldID1;
    long l = this.mRS.nScriptFieldIDCreate(getID(this.mRS), paramInt, this.mUseIncSupp);
    if (l == 0L)
      throw new RSDriverException("Failed to create FieldID");
    FieldID localFieldID2 = new FieldID(l, this.mRS, this, paramInt);
    this.mFIDs.put(paramInt, localFieldID2);
    return localFieldID2;
  }

  protected InvokeID createInvokeID(int paramInt)
  {
    InvokeID localInvokeID1 = (InvokeID)this.mIIDs.get(paramInt);
    if (localInvokeID1 != null)
      return localInvokeID1;
    long l = this.mRS.nScriptInvokeIDCreate(getID(this.mRS), paramInt);
    if (l == 0L)
      throw new RSDriverException("Failed to create KernelID");
    InvokeID localInvokeID2 = new InvokeID(l, this.mRS, this, paramInt);
    this.mIIDs.put(paramInt, localInvokeID2);
    return localInvokeID2;
  }

  protected KernelID createKernelID(int paramInt1, int paramInt2, Element paramElement1, Element paramElement2)
  {
    KernelID localKernelID1 = (KernelID)this.mKIDs.get(paramInt1);
    if (localKernelID1 != null)
      return localKernelID1;
    long l = this.mRS.nScriptKernelIDCreate(getID(this.mRS), paramInt1, paramInt2, this.mUseIncSupp);
    if (l == 0L)
      throw new RSDriverException("Failed to create KernelID");
    KernelID localKernelID2 = new KernelID(l, this.mRS, this, paramInt1, paramInt2);
    this.mKIDs.put(paramInt1, localKernelID2);
    return localKernelID2;
  }

  protected void forEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker)
  {
    long l1 = 0L;
    if ((paramAllocation1 == null) && (paramAllocation2 == null))
      throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
    if (paramAllocation1 != null);
    for (long l2 = paramAllocation1.getID(this.mRS); ; l2 = l1)
    {
      if (paramAllocation2 != null)
        l1 = paramAllocation2.getID(this.mRS);
      byte[] arrayOfByte = null;
      if (paramFieldPacker != null)
        arrayOfByte = paramFieldPacker.getData();
      if (this.mUseIncSupp)
      {
        long l3 = getDummyAlloc(paramAllocation1);
        long l4 = getDummyAlloc(paramAllocation2);
        this.mRS.nScriptForEach(getID(this.mRS), paramInt, l3, l4, arrayOfByte, this.mUseIncSupp);
        return;
      }
      this.mRS.nScriptForEach(getID(this.mRS), paramInt, l2, l1, arrayOfByte, this.mUseIncSupp);
      return;
    }
  }

  protected void forEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker, LaunchOptions paramLaunchOptions)
  {
    if ((paramAllocation1 == null) && (paramAllocation2 == null))
      throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
    if (paramLaunchOptions == null)
    {
      forEach(paramInt, paramAllocation1, paramAllocation2, paramFieldPacker);
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    if (paramAllocation1 != null)
      l1 = paramAllocation1.getID(this.mRS);
    if (paramAllocation2 != null)
      l2 = paramAllocation2.getID(this.mRS);
    byte[] arrayOfByte = null;
    if (paramFieldPacker != null)
      arrayOfByte = paramFieldPacker.getData();
    if (this.mUseIncSupp)
    {
      long l3 = getDummyAlloc(paramAllocation1);
      long l4 = getDummyAlloc(paramAllocation2);
      this.mRS.nScriptForEachClipped(getID(this.mRS), paramInt, l3, l4, arrayOfByte, paramLaunchOptions.xstart, paramLaunchOptions.xend, paramLaunchOptions.ystart, paramLaunchOptions.yend, paramLaunchOptions.zstart, paramLaunchOptions.zend, this.mUseIncSupp);
      return;
    }
    this.mRS.nScriptForEachClipped(getID(this.mRS), paramInt, l1, l2, arrayOfByte, paramLaunchOptions.xstart, paramLaunchOptions.xend, paramLaunchOptions.ystart, paramLaunchOptions.yend, paramLaunchOptions.zstart, paramLaunchOptions.zend, this.mUseIncSupp);
  }

  protected void forEach(int paramInt, Allocation[] paramArrayOfAllocation, Allocation paramAllocation, FieldPacker paramFieldPacker)
  {
    forEach(paramInt, paramArrayOfAllocation, paramAllocation, paramFieldPacker, null);
  }

  protected void forEach(int paramInt, Allocation[] paramArrayOfAllocation, Allocation paramAllocation, FieldPacker paramFieldPacker, LaunchOptions paramLaunchOptions)
  {
    this.mRS.validate();
    if (paramArrayOfAllocation != null)
    {
      int j = paramArrayOfAllocation.length;
      for (int k = 0; k < j; k++)
      {
        Allocation localAllocation = paramArrayOfAllocation[k];
        this.mRS.validateObject(localAllocation);
      }
    }
    this.mRS.validateObject(paramAllocation);
    if ((paramArrayOfAllocation == null) && (paramAllocation == null))
      throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
    if (paramArrayOfAllocation != null)
    {
      arrayOfLong = new long[paramArrayOfAllocation.length];
      for (int i = 0; i < paramArrayOfAllocation.length; i++)
        arrayOfLong[i] = paramArrayOfAllocation[i].getID(this.mRS);
    }
    long[] arrayOfLong = null;
    long l = 0L;
    if (paramAllocation != null)
      l = paramAllocation.getID(this.mRS);
    if (paramFieldPacker != null);
    for (byte[] arrayOfByte = paramFieldPacker.getData(); ; arrayOfByte = null)
    {
      int[] arrayOfInt = null;
      if (paramLaunchOptions != null)
      {
        arrayOfInt = new int[6];
        arrayOfInt[0] = paramLaunchOptions.xstart;
        arrayOfInt[1] = paramLaunchOptions.xend;
        arrayOfInt[2] = paramLaunchOptions.ystart;
        arrayOfInt[3] = paramLaunchOptions.yend;
        arrayOfInt[4] = paramLaunchOptions.zstart;
        arrayOfInt[5] = paramLaunchOptions.zend;
      }
      this.mRS.nScriptForEach(getID(this.mRS), paramInt, arrayOfLong, l, arrayOfByte, arrayOfInt);
      return;
    }
  }

  long getDummyAlloc(Allocation paramAllocation)
  {
    long l1 = 0L;
    if (paramAllocation != null)
    {
      Type localType = paramAllocation.getType();
      long l2 = localType.getElement().getDummyElement(this.mRS);
      long l3 = localType.getDummyType(this.mRS, l2);
      int i = localType.getX() * localType.getElement().getBytesSize();
      l1 = this.mRS.nIncAllocationCreateTyped(paramAllocation.getID(this.mRS), l3, i);
      paramAllocation.setIncAllocID(l1);
    }
    return l1;
  }

  protected void invoke(int paramInt)
  {
    this.mRS.nScriptInvoke(getID(this.mRS), paramInt, this.mUseIncSupp);
  }

  protected void invoke(int paramInt, FieldPacker paramFieldPacker)
  {
    if (paramFieldPacker != null)
    {
      this.mRS.nScriptInvokeV(getID(this.mRS), paramInt, paramFieldPacker.getData(), this.mUseIncSupp);
      return;
    }
    this.mRS.nScriptInvoke(getID(this.mRS), paramInt, this.mUseIncSupp);
  }

  protected boolean isIncSupp()
  {
    return this.mUseIncSupp;
  }

  protected void reduce(int paramInt, Allocation[] paramArrayOfAllocation, Allocation paramAllocation, LaunchOptions paramLaunchOptions)
  {
    this.mRS.validate();
    if ((paramArrayOfAllocation == null) || (paramArrayOfAllocation.length < 1))
      throw new RSIllegalArgumentException("At least one input is required.");
    if (paramAllocation == null)
      throw new RSIllegalArgumentException("aout is required to be non-null.");
    int i = paramArrayOfAllocation.length;
    for (int j = 0; j < i; j++)
    {
      Allocation localAllocation = paramArrayOfAllocation[j];
      this.mRS.validateObject(localAllocation);
    }
    long[] arrayOfLong = new long[paramArrayOfAllocation.length];
    for (int k = 0; k < paramArrayOfAllocation.length; k++)
      arrayOfLong[k] = paramArrayOfAllocation[k].getID(this.mRS);
    long l = paramAllocation.getID(this.mRS);
    int[] arrayOfInt = null;
    if (paramLaunchOptions != null)
    {
      arrayOfInt = new int[6];
      arrayOfInt[0] = paramLaunchOptions.xstart;
      arrayOfInt[1] = paramLaunchOptions.xend;
      arrayOfInt[2] = paramLaunchOptions.ystart;
      arrayOfInt[3] = paramLaunchOptions.yend;
      arrayOfInt[4] = paramLaunchOptions.zstart;
      arrayOfInt[5] = paramLaunchOptions.zend;
    }
    this.mRS.nScriptReduce(getID(this.mRS), paramInt, arrayOfLong, l, arrayOfInt);
  }

  protected void setIncSupp(boolean paramBoolean)
  {
    this.mUseIncSupp = paramBoolean;
  }

  public void setTimeZone(String paramString)
  {
    this.mRS.validate();
    try
    {
      this.mRS.nScriptSetTimeZone(getID(this.mRS), paramString.getBytes("UTF-8"), this.mUseIncSupp);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  public void setVar(int paramInt, double paramDouble)
  {
    this.mRS.nScriptSetVarD(getID(this.mRS), paramInt, paramDouble, this.mUseIncSupp);
  }

  public void setVar(int paramInt, float paramFloat)
  {
    this.mRS.nScriptSetVarF(getID(this.mRS), paramInt, paramFloat, this.mUseIncSupp);
  }

  public void setVar(int paramInt1, int paramInt2)
  {
    this.mRS.nScriptSetVarI(getID(this.mRS), paramInt1, paramInt2, this.mUseIncSupp);
  }

  public void setVar(int paramInt, long paramLong)
  {
    this.mRS.nScriptSetVarJ(getID(this.mRS), paramInt, paramLong, this.mUseIncSupp);
  }

  public void setVar(int paramInt, BaseObj paramBaseObj)
  {
    long l1 = 0L;
    if (this.mUseIncSupp)
    {
      long l3 = getDummyAlloc((Allocation)paramBaseObj);
      RenderScript localRenderScript2 = this.mRS;
      long l4 = getID(this.mRS);
      if (paramBaseObj == null);
      while (true)
      {
        localRenderScript2.nScriptSetVarObj(l4, paramInt, l1, this.mUseIncSupp);
        return;
        l1 = l3;
      }
    }
    RenderScript localRenderScript1 = this.mRS;
    long l2 = getID(this.mRS);
    if (paramBaseObj == null);
    while (true)
    {
      localRenderScript1.nScriptSetVarObj(l2, paramInt, l1, this.mUseIncSupp);
      return;
      l1 = paramBaseObj.getID(this.mRS);
    }
  }

  public void setVar(int paramInt, FieldPacker paramFieldPacker)
  {
    this.mRS.nScriptSetVarV(getID(this.mRS), paramInt, paramFieldPacker.getData(), this.mUseIncSupp);
  }

  public void setVar(int paramInt, FieldPacker paramFieldPacker, Element paramElement, int[] paramArrayOfInt)
  {
    if (this.mUseIncSupp)
    {
      long l = paramElement.getDummyElement(this.mRS);
      this.mRS.nScriptSetVarVE(getID(this.mRS), paramInt, paramFieldPacker.getData(), l, paramArrayOfInt, this.mUseIncSupp);
      return;
    }
    this.mRS.nScriptSetVarVE(getID(this.mRS), paramInt, paramFieldPacker.getData(), paramElement.getID(this.mRS), paramArrayOfInt, this.mUseIncSupp);
  }

  public void setVar(int paramInt, boolean paramBoolean)
  {
    RenderScript localRenderScript = this.mRS;
    long l = getID(this.mRS);
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localRenderScript.nScriptSetVarI(l, paramInt, i, this.mUseIncSupp);
      return;
    }
  }

  public static class Builder
  {
    RenderScript mRS;

    Builder(RenderScript paramRenderScript)
    {
      this.mRS = paramRenderScript;
    }
  }

  public static class FieldBase
  {
    protected Allocation mAllocation;
    protected Element mElement;

    public Allocation getAllocation()
    {
      return this.mAllocation;
    }

    public Element getElement()
    {
      return this.mElement;
    }

    public Type getType()
    {
      return this.mAllocation.getType();
    }

    protected void init(RenderScript paramRenderScript, int paramInt)
    {
      this.mAllocation = Allocation.createSized(paramRenderScript, this.mElement, paramInt, 1);
    }

    protected void init(RenderScript paramRenderScript, int paramInt1, int paramInt2)
    {
      this.mAllocation = Allocation.createSized(paramRenderScript, this.mElement, paramInt1, paramInt2 | 0x1);
    }

    public void updateAllocation()
    {
    }
  }

  public static final class FieldID extends BaseObj
  {
    android.renderscript.Script.FieldID mN;
    Script mScript;
    int mSlot;

    FieldID(long paramLong, RenderScript paramRenderScript, Script paramScript, int paramInt)
    {
      super(paramRenderScript);
      this.mScript = paramScript;
      this.mSlot = paramInt;
    }
  }

  public static final class InvokeID extends BaseObj
  {
    Script mScript;
    int mSlot;

    InvokeID(long paramLong, RenderScript paramRenderScript, Script paramScript, int paramInt)
    {
      super(paramRenderScript);
      this.mScript = paramScript;
      this.mSlot = paramInt;
    }
  }

  public static final class KernelID extends BaseObj
  {
    android.renderscript.Script.KernelID mN;
    Script mScript;
    int mSig;
    int mSlot;

    KernelID(long paramLong, RenderScript paramRenderScript, Script paramScript, int paramInt1, int paramInt2)
    {
      super(paramRenderScript);
      this.mScript = paramScript;
      this.mSlot = paramInt1;
      this.mSig = paramInt2;
    }
  }

  public static final class LaunchOptions
  {
    private int strategy;
    private int xend = 0;
    private int xstart = 0;
    private int yend = 0;
    private int ystart = 0;
    private int zend = 0;
    private int zstart = 0;

    public int getXEnd()
    {
      return this.xend;
    }

    public int getXStart()
    {
      return this.xstart;
    }

    public int getYEnd()
    {
      return this.yend;
    }

    public int getYStart()
    {
      return this.ystart;
    }

    public int getZEnd()
    {
      return this.zend;
    }

    public int getZStart()
    {
      return this.zstart;
    }

    public LaunchOptions setX(int paramInt1, int paramInt2)
    {
      if ((paramInt1 < 0) || (paramInt2 <= paramInt1))
        throw new RSIllegalArgumentException("Invalid dimensions");
      this.xstart = paramInt1;
      this.xend = paramInt2;
      return this;
    }

    public LaunchOptions setY(int paramInt1, int paramInt2)
    {
      if ((paramInt1 < 0) || (paramInt2 <= paramInt1))
        throw new RSIllegalArgumentException("Invalid dimensions");
      this.ystart = paramInt1;
      this.yend = paramInt2;
      return this;
    }

    public LaunchOptions setZ(int paramInt1, int paramInt2)
    {
      if ((paramInt1 < 0) || (paramInt2 <= paramInt1))
        throw new RSIllegalArgumentException("Invalid dimensions");
      this.zstart = paramInt1;
      this.zend = paramInt2;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Script
 * JD-Core Version:    0.6.2
 */