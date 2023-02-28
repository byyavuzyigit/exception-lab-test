import javax.xml.crypto.Data;

public class UzayMekigi {
    String id;
    int count = 0;
    TasOrnegi[] tasOrnekleri = new TasOrnegi[15];
    DataCozumleyici hassasCozumleyici = new DataCozumleyici(0.1,"HC");
    DataCozumleyici varsayilanCozumleyici = new DataCozumleyici(0.5,"VC");

    public UzayMekigi(String id){
        this.id = id;
    }

    public void tasTopla(String ornekİsmi,double kutle,double hacim){
        try{
            if(kutle<=0 || hacim<=0){
                throw new ToplamaHatasi();
            }
            tasOrnekleri[count] = new TasOrnegi(ornekİsmi,kutle,hacim);
            count++;
            System.out.println("Ekleme basarili:" + ornekİsmi + "," + kutle + "," + hacim);
        }
        catch(ToplamaHatasi hata){
            System.out.println(hata.msg);
        }
    }

    public void raporla(){
        varsayilanCozumleyici.raporla(tasOrnekleri);
        hassasCozumleyici.raporla(tasOrnekleri);
    }

    private class TasOrnegi{
        String isim;
        double kutle;
        double hacim;

        public TasOrnegi(String isim,double kutle,double hacim){
            this.isim = isim;
            this.kutle = kutle;
            this.hacim = hacim;
        }

    }
    private class DataCozumleyici{
        private double hata = 0.5;
        String cozumleyici_id;
        public DataCozumleyici(double hata,String isim){
            this.hata = hata;
            cozumleyici_id = isim;
        }
        public void raporla(TasOrnegi[] tasOrnekleri){
            for(int i=0;i< tasOrnekleri.length;i++){
                if(tasOrnekleri[i] != null){
                    double min_yogunluk = tasOrnekleri[i].kutle/tasOrnekleri[i].hacim-hata;
                    double max_yogunluk = tasOrnekleri[i].kutle/tasOrnekleri[i].hacim+hata;
                    System.out.println("UzayMekigi:" + id + ", DataCozumleyici:" + cozumleyici_id + ", Ornek Ismi:" + tasOrnekleri[i].isim
                            + ", Ornek Yogunlugu:" + min_yogunluk + "-" + max_yogunluk);
                }


            }
        }


    }
    private class ToplamaHatasi extends Exception{
        String msg;
        public ToplamaHatasi(){
            msg = "Toplama aninda hata ile karsilasildi.";
        }
    }
}
