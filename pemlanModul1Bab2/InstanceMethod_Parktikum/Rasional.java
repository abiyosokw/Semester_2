package pemlanModul1Bab2.InstanceMethod_Parktikum;

public class Rasional{
    private int pembilang, penyebut;

    public Rasional(){
        pembilang=0;
        penyebut=0;
    }

    public Rasional(int pbl, int pyb){
        pembilang=pbl;
        penyebut=pyb;
    }

    //mengecek suatu bilangan adalah rasional atau bukan
    public boolean isRasional(){
        return (penyebut!= 0);
    }

    //menyederhanakan bilangan rasional
    public void Sederhana(){
        int temp, A, B;
        if (penyebut ==0){
            return;
        }
        A = (pembilang<penyebut) ? penyebut:pembilang;
        B = (pembilang<penyebut) ? pembilang:penyebut;

        for (; B != 0; ){
        temp= A % B;
        A = B;
        B = temp;
        }
        
        pembilang /=A;
        penyebut /=A; 
    }

    public double Cast(){
    return (penyebut==0.0) ? 0.0 : (double)pembilang /
    (double)penyebut;
    }

    //oprator >
    public boolean moreThan (Rasional A){
    return (pembilang * A.penyebut > penyebut * A.pembilang
    );
    }

    // operator <
    public boolean lessThan(Rasional A){
        return (pembilang * A.penyebut < penyebut * A.pembilang);
    }

    // operator <=
    public boolean lessOrEqual(Rasional A){
        return (pembilang * A.penyebut <= penyebut * A.pembilang);
    }

    // operator >=
    public boolean moreOrEqual(Rasional A){
        return (pembilang * A.penyebut >= penyebut * A.pembilang);
    }

    //operator Unary- ---> A = -A
    public void negasi(){
    pembilang = - pembilang;
    }

    //operator unary += \
    public void unaryPlus(Rasional A){
    pembilang = pembilang * A.penyebut + penyebut *
    A.pembilang;
    penyebut *= A.penyebut;
    }

    // operator -= (pengurangan)
    public void unaryMinus(Rasional A){
    pembilang = pembilang * A.penyebut - penyebut * A.pembilang;
    penyebut *= A.penyebut;
}

    // operator *= (perkalian)
    public void unaryKali(Rasional A){
    pembilang = pembilang * A.pembilang;
    penyebut = penyebut * A.penyebut;
}

    // operator /= (pembagian)
    public void unaryBagi(Rasional A){
    if (A.pembilang == 0){
        System.out.println("Error: Tidak dapat membagi dengan nol!");
        return;
    }
    pembilang = pembilang * A.penyebut;
    penyebut = penyebut * A.pembilang;
}
    
    public void cetak(){
    System.out.println(pembilang + "/" + penyebut);
    }
}