package hotel.storages;

import hotel.config.AutoDI;
import hotel.enums.ServiceType;
import hotel.models.Service;
import hotel.services.ServiceService;

public class ServicesStorage extends Storage {
  private final String SERVICE_DATA_PATH = String.format("%s/%s.csv", DATA_DIR, "services");

  @AutoDI
  private ServiceService serviceService;

  public void loadServices() { loadFromCSV(SERVICE_DATA_PATH, p->loadService(p)); }
  public void saveServices() { recreateFile(SERVICE_DATA_PATH); serviceService.getServices().each(r->saveToCSV(SERVICE_DATA_PATH, serviceParams(r)));  }
  public void saveService(Service service) { saveToCSV(SERVICE_DATA_PATH, serviceParams(service));  }

  public void loadService(String[] params) {
    if (params.length != 4) { System.out.println("Incorrect params count"); return; }

    Integer id = Integer.parseInt(params[0]);
    String title = params[1];
    Float price = Float.parseFloat(params[2]);

    ServiceType type = null;
    if (params[3] != "") {
      ServiceType[] types = ServiceType.values();
      Integer typeIndex = Integer.parseInt(params[3]);
      type = types[typeIndex];
    }

    Service service = serviceService.getService(id);

    if (service == null) {
      service = new Service(id);
      serviceService.addService(service);
    }

    service.setTitle(title);
    service.setPrice(price);
    service.setType(type);
  }

  private Object[] serviceParams(Service service) {
    Integer id = service.getID();
    String title = service.getTitle();
    Float price = service.getPrice();
    ServiceType type = service.getType();
    Integer typeIndex = type == null ? null : type.ordinal();

    return new Object[] { id, title, price, typeIndex };
  }
}