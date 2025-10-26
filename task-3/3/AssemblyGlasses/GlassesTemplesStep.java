package AssemblyGlasses;

import AssemblyInterfaces.ILineStep;
import AssemblyInterfaces.IProductPart;

public class GlassesTemplesStep implements ILineStep {
  public IProductPart buildProductPart() {
    IProductPart part = new GlassesTemples();
    System.out.println("Temples builded");
    return part;
  };
};