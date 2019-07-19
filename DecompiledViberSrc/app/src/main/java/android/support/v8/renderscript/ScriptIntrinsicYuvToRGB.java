package android.support.v8.renderscript;

import android.os.Build.VERSION;

public class ScriptIntrinsicYuvToRGB extends ScriptIntrinsic
{
  private static final int INTRINSIC_API_LEVEL = 19;
  private Allocation mInput;

  ScriptIntrinsicYuvToRGB(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public static ScriptIntrinsicYuvToRGB create(RenderScript paramRenderScript, Element paramElement)
  {
    if ((paramRenderScript.isUseNative()) && (Build.VERSION.SDK_INT < 19));
    for (boolean bool = true; ; bool = false)
    {
      ScriptIntrinsicYuvToRGB localScriptIntrinsicYuvToRGB = new ScriptIntrinsicYuvToRGB(paramRenderScript.nScriptIntrinsicCreate(6, paramElement.getID(paramRenderScript), bool), paramRenderScript);
      localScriptIntrinsicYuvToRGB.setIncSupp(bool);
      return localScriptIntrinsicYuvToRGB;
    }
  }

  public void forEach(Allocation paramAllocation)
  {
    forEach(0, (Allocation)null, paramAllocation, null);
  }

  public Script.FieldID getFieldID_Input()
  {
    return createFieldID(0, null);
  }

  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 2, null, null);
  }

  public void setInput(Allocation paramAllocation)
  {
    this.mInput = paramAllocation;
    setVar(0, paramAllocation);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicYuvToRGB
 * JD-Core Version:    0.6.2
 */