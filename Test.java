public class Test {
    public static void main(String[] args){
        UzayMekigi um = new UzayMekigi("UM-1");
        String[] ornekIsimleri = {"A1", "A2", "BX-12", "XA-44", "ABC-2", "JUP-2",
                "JUP-1","W-10","L-9", "N-17"};
        double[] kutleler = {3.5, 0.8, 0.4, 23.9, 12.6, 6.5, 0, -5.7, -4.4, 0};
        double[] hacimler = {1.0, 0.4, 1.6, 10.5, 0, -1.2,12.4, 2.3, -3.2, 0};
        for(int i=0;i<10;i++) {
            um.tasTopla(ornekIsimleri[i], kutleler[i], hacimler[i]);
        }
        um.raporla();
    }
}
