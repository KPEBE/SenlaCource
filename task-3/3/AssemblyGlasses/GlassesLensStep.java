package AssemblyGlasses;

import AssemblyInterfaces.ILineStep;
import AssemblyInterfaces.IProductPart;

public class GlassesLensStep implements ILineStep {
  public IProductPart buildProductPart() {
    IProductPart part = new GlassesLens();
    System.out.println("Lens builded");
    return part;
  };
};