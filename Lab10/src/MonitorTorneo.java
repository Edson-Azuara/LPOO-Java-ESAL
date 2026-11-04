public class MonitorTorneo extends Thread {

    private String nombreCampo;

    public MonitorTorneo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    @Override
    public void run() {
        System.out.println("[Monitor] Estado del campo " + nombreCampo
                + ": en operación.");
    }
}