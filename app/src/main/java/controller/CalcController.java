package controller;

public class CalcController {

    public CalcController(){
        super();
    }

    public int primos(int n1 ,int n2){

        int primos=0 ;


        if(n1>n2){//trocar n2 com n1 caso o primeiro digitado seja maior que o segundo
            int aux=n2;
            n2=n1;
            n1=aux;
        }
        if(n2<2){
            return 0;
        }
        for(int x1=n1;x1<n2;x1++) {//enquanto o primeiro for menor que o segundo
            int divisor=1;
            for(int cta=2;cta<=n2;cta++){

                if (x1 % cta == 0) {
                    divisor++;
                }
            }
                  if(divisor==2){
                      primos++;
                  }
        }
        return primos;
    }
}
